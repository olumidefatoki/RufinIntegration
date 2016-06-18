/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import RUFINScheme.Mambu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author olumidefatoki
 */
public class DBUtils {

    static private Connection conn;

    public static RufinCustProfile getCBAID(String MSISDN, String platformId) {

        PreparedStatement ps = null;
        String result = null;
        Connection con = createConnection();
        ResultSet rs = null;
        RufinCustProfile rcp = new RufinCustProfile();
        try {
            String sql = "SELECT CBAcode,MFB,accountNumber FROM RufinCustomerProfile WHERE MSISDN =? and SchemeCode=?  limit 1";
            ps = con.prepareStatement(sql);
            ps.setString(1, MSISDN);
            ps.setString(2, platformId);
            rs = ps.executeQuery();
            while (rs.next()) {

                rcp.setCBAcode(rs.getString(1));
                rcp.setMFB(rs.getInt(2));
                rcp.setAccountNumber(rs.getString(3));

            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        } finally {

            closeConnection();
        }
        return rcp;
        //To change body of generated methods, choose Tools | Templates.
    }

    public static String getTransAmt(String refenceID) {

        PreparedStatement ps = null;
        String result = null;
        Connection con = createConnection();
        ResultSet rs = null;
        String amount = "0";
        try {
            String sql = "SELECT Amount FROM RufinTransactionlog WHERE RefID =? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, refenceID);
            rs = ps.executeQuery();
            while (rs.next()) {
                amount = rs.getString(1);
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        } finally {

            closeConnection();
        }
        return amount;
        //To change body of generated methods, choose Tools | Templates.
    }

    private static Connection createConnection() {
        Connection conn = null;
        try {
            //  conn =null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RufinTransactionlog", "rufin", "cba!ntegat!on.");

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return conn;
    }

    public static void updatewithTransID(String refId, String PayloadRequest, String action, String TransStatus, String TransRemark, String CBATransactionID) {
        PreparedStatement ps = null;
        int result = 0;
        Connection con = createConnection();
        try {
            String sql = "Update RufinTransactionlog  set CBAResponse=?,ResponseTime=now(),StatusID=1,TransStatus=?,TransRemark=?,CBATransactionID=? where StatusID=0 and RefID= ? and ActionId=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, PayloadRequest);
            ps.setString(2, TransStatus);
            ps.setString(3, TransRemark);
            ps.setString(4, CBATransactionID);
            ps.setString(5, refId);
            ps.setString(6, action);

            result = ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        } finally {

            closeConnection();
        }
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ex) {

                System.out.println("Error ; " + ex);
            }
        }
    }

    public static void update(String refId, String PayloadRequest, String action, String TransStatus, String TransRemark) {
        PreparedStatement ps = null;
        int result = 0;
        Connection con = createConnection();
        try {
            String sql = "Update RufinTransactionlog  set CBAResponse=?,ResponseTime=now(),StatusID=1,TransStatus=?,TransRemark=? where StatusID=0 and RefID= ? and ActionId=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, PayloadRequest);
            ps.setString(2, TransStatus);
            ps.setString(3, TransRemark);
            ps.setString(4, refId);
            ps.setString(5, action);

            result = ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        } finally {

            closeConnection();
        }
    }

     public static void updateSmartMicroTrans(String refId, String PayloadRequest, String action, String TransStatus, String TransRemark) {
        PreparedStatement ps = null;
        int result = 0;
        Connection con = createConnection();
        try {
            String sql = "Update SmartMicroTransactionlog  set CBAResponse=?,ResponseTime=now(),StatusID=1,TransStatus=?,TransRemark=? where StatusID=0 and RefID= ? and ActionId=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, PayloadRequest);
            ps.setString(2, TransStatus);
            ps.setString(3, TransRemark);
            ps.setString(4, refId);
            ps.setString(5, action);

            result = ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        } finally {

            closeConnection();
        }
    }
    public static void insert(String sender, String refId, String narration, String platformId, int mfb, String actionId, String amount, String tfee) {
        PreparedStatement ps = null;
        int result = 0;
        Connection con = createConnection();
        try {
            String sql = "insert into RufinTransactionlog (RefID,Sender,Narration,CBAcode,mfb,ActionId,amount,Tfee,RequestTime,ResponseTime)"
                    + "  values (?,?,?,?,?,?,?,?,now(),now())";
            ps = con.prepareStatement(sql);
            ps.setString(1, refId);
            ps.setString(2, sender);
            ps.setString(3, narration);
            ps.setString(4, platformId);
            ps.setInt(5, mfb);
            ps.setString(6, actionId);
            ps.setString(7, amount);
            ps.setString(8, tfee);
            result = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }
    public static void insert(String sender, String refId, String narration, String actionId, String amount, String tfee) {
        PreparedStatement ps = null;
        int result = 0;
        Connection con = createConnection();
        try {
            String sql = "insert into SmartMicroTransactionlog (RefID,Sender,Narration,ActionId,amount,Tfee,RequestTime,ResponseTime)"
                    + "  values (?,?,?,?,?,?,now(),now())";
            ps = con.prepareStatement(sql);
            ps.setString(1, refId);
            ps.setString(2, sender);
            ps.setString(3, narration);
            ps.setString(4, actionId);
            ps.setString(5, amount);
            ps.setString(6, tfee);
            result = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }
    public static void main(String[] args) {
//      
        System.out.println(DBUtils.getTransAmt("1234567894"));
    }

    public static int createCustomer(String name, String email, String occupation, String phone, String address, String AgentNumber) {
        PreparedStatement ps = null;
        int result = 0;
        Connection con = createConnection();
        try {
            String sql = "insert into RufinCustomerProfile (CustomerFullName,MSISDN,Email,Occupation,Address)"
                    + "  values (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.setString(4, occupation);
            ps.setString(5, address);
            result = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return result;
    }

    public static int createAgent(String name, String email, String occupation, String phone, String address) {
        PreparedStatement ps = null;
        int result = 0;
        Connection con = createConnection();
        try {
            String sql = "insert into RufinAgent (AgentFullName,MSISDN,Email,Occupation,Address)"
                    + "  values (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.setString(4, occupation);
            ps.setString(5, address);
            result = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return result;
    }

    public static int checkAgentNumbner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static int checkCUstomerAcount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Mambu getTransDetails(String refenceID) {

        PreparedStatement ps = null;
        String result = null;
        Connection con = createConnection();
        ResultSet rs = null;
        Mambu myMambu = new Mambu();
        try {
            String sql = "SELECT ActionID,CBATransactionID FROM RufinTransactionlog WHERE RefID =? and ActionID in ('008','007','010','002','006')  limit 1";
            ps = con.prepareStatement(sql);
            ps.setString(1, refenceID);
            rs = ps.executeQuery();
            while (rs.next()) {
                myMambu.setActionID(rs.getString(1));
                myMambu.setCbatransactionID(rs.getString(2));
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        } finally {

            closeConnection();
        }
        return myMambu;
        //To change body of generated methods, choose Tools | Templates.
    }

   

}
