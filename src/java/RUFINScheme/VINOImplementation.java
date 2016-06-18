/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RUFINScheme;


import Utils.WalletCredentials;
import Utils.DBUtils;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Olumide
 */
public class VINOImplementation {
    private String arugement = "", ResponseCode = "", Balance = "", ResponseDescription = "";
    private String transactionResponse = "";
    private Connection msconn=null;
    private VINO response = null;

    private Connection createConnection() {
       
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            msconn = DriverManager.getConnection("jdbc:sqlserver://178.239.50.59:1433;databaseName=MicroFinance", "CompAcct", "comp");

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return msconn;
    }

    private void closeConnection() {
        if (msconn != null) {
            try {
                msconn.close();
            } catch (Exception ex) {

                System.out.println("Error ; " + ex);
            }
        }
    }

    public VINO accountQuery(String referenceNo, String MSISDN, String platformId, int mfb, String actionId) {

        try {
            response = new VINO();
            arugement = "Account Query Request";
            StringBuilder param = new StringBuilder();

            //DBUtils.insert(MSISDN, referenceNo, arugement, platformId, mfb, actionId, "0", "0");

            Connection con = createConnection();
            CallableStatement cstmt = con.prepareCall("{ call Accountquery (?,?)}");
            cstmt.setString(1, WalletCredentials.FormatMSISDN(MSISDN));
            cstmt.registerOutParameter(2, Types.NVARCHAR);
            cstmt.execute();
            transactionResponse = cstmt.getString("final3");
            System.out.println(transactionResponse);
            String[] parts = transactionResponse.split("\\|");

            if (parts.length > 1) {
                ResponseCode = parts[0];
                Balance = parts[1];
            }

            if (ResponseCode.equals("00")) {
                ResponseDescription = "Success";
            } else {
                ResponseDescription = "Failed";
            }

            //DBUtils.update(referenceNo, transactionResponse, actionId, ResponseCode, ResponseDescription);
            response.setBalance(Double.parseDouble(Balance));
            response.setResponseCode(ResponseCode);
             
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }

    public VINO accountCredit(String referenceNo, String MSISDN, String narration, String transactionAmount, String platformId, int mfb, String actionId) {

        try {
            response = new VINO();

            DBUtils.insert(MSISDN, referenceNo, narration, platformId, mfb, actionId, transactionAmount, "0");
            Connection con = createConnection();

            CallableStatement cstmt = con.prepareCall("{  call AccountCredit (?,?,?,?,?,?,?)}");

            cstmt.setString("glperiods", formatDate());
            cstmt.setString("Phoneno", WalletCredentials.FormatMSISDN(MSISDN));
            cstmt.setString("Amt", transactionAmount);
            cstmt.setString("charges", "0");
            cstmt.setString("transid", referenceNo);
            cstmt.setString("Narration", narration);
            cstmt.registerOutParameter("final", Types.NVARCHAR);
            cstmt.execute();

            transactionResponse = cstmt.getString("final");
             System.out.println("Response " + transactionResponse);
            String[] parts = transactionResponse.split("\\|");
            if (parts.length > 1) {
                ResponseCode = parts[0];
            }
            if (ResponseCode.equals("00")) {
                ResponseDescription = "Success";
            } else {
                ResponseDescription = "Failed";
            }
              response.setResponseCode(ResponseCode);
            
           

            DBUtils.update(referenceNo, transactionResponse, actionId, ResponseCode, ResponseDescription);
           

        } catch (Exception ex) {
          System.out.println(ex.getMessage());
        }
       
        return response;
    }

    public VINO accountDebit(String referenceNo, String MSISDN, String narration, String transactionAmount, String transactionFee, String platformId, int mfb, String actionId) {

        try {
            response = new VINO();
            DBUtils.insert(MSISDN, referenceNo, narration, platformId, mfb, actionId, transactionAmount, transactionFee);
           
            Connection con = createConnection();
            CallableStatement cstmt = con.prepareCall("{  call AccountDebit (?,?,?,?,?,?,?)}");
            
            cstmt.setString("glperiods", formatDate());
            cstmt.setString("Phoneno", WalletCredentials.FormatMSISDN(MSISDN));
            cstmt.setString("Amt", transactionAmount);
            cstmt.setString("charges", transactionFee);
            cstmt.setString("transid", referenceNo);
            cstmt.setString("Narration", narration);

            cstmt.registerOutParameter("final", Types.NVARCHAR);
            // The name argument is the second ?
            cstmt.execute();
            cstmt.toString();
            transactionResponse = cstmt.getString("final");
               System.out.println("Response " + transactionResponse);
            String[] parts = transactionResponse.split("\\|");
            if (parts.length > 1) {
                ResponseCode = parts[0];

            }
            if (ResponseCode.equals("00")) {
                ResponseDescription = "Success";
            } else {
                ResponseDescription = "Failed";
            }

            

            DBUtils.update(referenceNo, transactionResponse, actionId, ResponseCode, ResponseDescription);
            response.setResponseCode(ResponseCode);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }

    public VINO transactionReversal(String referenceNo, String MSISDN, String platformId, int mfb, String actionId) {

        try {
            response = new VINO();
            arugement = "transactionReversal Request ";
            DBUtils.insert(MSISDN, referenceNo, arugement, platformId, mfb, actionId, "0", "0");
            
             Connection con = createConnection();
            CallableStatement cstmt = con.prepareCall("{  call Reversal (?,?)}");
            cstmt.setString(1, referenceNo);
            cstmt.registerOutParameter(2, Types.NVARCHAR);
            cstmt.execute();
            cstmt.toString();
            transactionResponse = cstmt.getString("final");
            
             System.out.println("Response " + transactionResponse);
             response.setResponseCode(transactionResponse);
             
             if (transactionResponse.equals("00")) {
                ResponseDescription = "Success";
            } else {
                ResponseDescription = "Failed";
            }
            DBUtils.update(referenceNo, transactionResponse, actionId, ResponseCode, ResponseDescription);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }

    private String formatDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss a");
        Date date = new Date();
        Date time = new Date();
        String myDate = dateFormat.format(date);
        String myTime = timeFormat.format(time);
        myDate = myDate.replace("-", "");
        myTime = myTime.replace(" ", "");
        String datetime = myDate + " " + myTime;
        return datetime;
    }
}
