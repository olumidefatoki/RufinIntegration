/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RUFINScheme;

import Utils.DBUtils;
import Utils.WalletCredentials;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author olumidefatoki
 */
public class Bowen {
     private String transactionResponse = null;
    private String response = null;
    private String arugement = null;   
    private final String URL = "http://41.223.47.86:8059/api/Transaction/CellulantTrans?";
    
    public String  accountQuery(String referenceNo, String MSISDN, String platformId, int mfb, String actionId) {

        try {
            arugement = "Account Query Request";
            StringBuilder param = new StringBuilder();
            param.append(URL);
            param.append("?PlatformID=");
            param.append("&RefId=").append(referenceNo);
            param.append("&Sender=").append(referenceNo);
            param.append("&Receiver=").append(referenceNo);
            param.append("&Action=").append(referenceNo);
            param.append("&MFBCode=").append(WalletCredentials.FormatMSISDN(MSISDN));

            DBUtils.insert(MSISDN, referenceNo, arugement, platformId, mfb, actionId, "0", "0");
        //    transactionResponse = sendSms(param.toString());
            
               
          
          
            System.out.println(transactionResponse);

            
        //     DBUtils.update(referenceNo, transactionResponse, actionId,response.getResponseCode(),response.getResponseDescription());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
    public String accountCredit(String referenceNo, String MSISDN, String narration, String transactionAmount, String platformId, int mfb, String actionId) {

        try {

            StringBuilder param = new StringBuilder();
            param.append(URL);
            param.append("?Action=CreditTransaction");
            param.append("&RefId=").append(referenceNo);
            param.append("&phoneNumber=").append(WalletCredentials.FormatMSISDN(MSISDN));
            param.append("&Amount=").append(transactionAmount);
            param.append("&Narration=").append(narration);

            DBUtils.insert(MSISDN, referenceNo, narration, platformId, mfb, actionId, transactionAmount, "0");
        //    transactionResponse = sendSms(param.toString());
            
          
           //     response = parseAccountCreditXML(transactionResponse);
            
            System.out.println("Response " + transactionResponse);
            
          //  DBUtils.update(referenceNo, transactionResponse, actionId,response.getResponseCode(),response.getResponseDescription()); 

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }

    public String accountDebit(String referenceNo, String MSISDN, String narration, String transactionAmount, String transactionFee, String platformId, int mfb, String actionId) {

        try {
            StringBuilder param = new StringBuilder();
            param.append(URL);
            param.append("?Action=DebitTransaction");
            param.append("&RefId=").append(referenceNo);
            param.append("&phoneNumber=").append(WalletCredentials.FormatMSISDN(MSISDN));
            param.append("&Amount=").append(transactionAmount);
            param.append("&Narration=").append(narration);
            param.append("&Transactionfee=").append(transactionFee);

            DBUtils.insert(MSISDN, referenceNo, narration, platformId, mfb, actionId, transactionAmount, transactionFee);
            //use this method to call accountQuery
         //   transactionResponse = sendSms(param.toString());
           
                
            
            System.out.println("Response " + transactionResponse);
       
        //     DBUtils.update(referenceNo, transactionResponse, actionId,response.getResponseCode(),response.getResponseDescription());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
     public Zoedeck transactionReversal(String referenceNo, String MSISDN, String platformId, int mfb, String actionId) {
        Zoedeck response = null;

        try {
            StringBuilder param = new StringBuilder();
            param.append(URL);
            param.append("?Action=ReversalTransaction");
            param.append("&RefId=").append(referenceNo);
            param.append("&phoneNumber=").append(WalletCredentials.FormatMSISDN(MSISDN));

            arugement = "transactionReversal Request ";
            DBUtils.insert(MSISDN, referenceNo, arugement, platformId, mfb, actionId, "0", "0");
            //use this method to call accountQuery
           
               
            //transactionResponse = sendSms(param.toString());
          
            System.out.println(transactionResponse);
            
            DBUtils.update(referenceNo, transactionResponse, actionId,response.getResponseCode(),response.getResponseDescription());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
     private void sendSms() {
        //http://41.223.47.86:8059/api/Transaction/CellulantTrans
         
        try {
             URL obj = new URL("http://41.223.47.86:8059/api/Transaction/CellulantTrans");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
 
        // For POST only - START
        String POST_PARAMS = "?PlatformID=001&Sender=2348096479922&Receiver=2348060099476&Action=016&RefID=2356&MFBCode=0458974";
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        // For POST only - END
 
        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);
        System.out.println("POST Response Message :: " + con.getResponseMessage());
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
 
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
 
            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("POST request not worked");
        }
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        
    }
     public static void main(String[] args) {
        Bowen myBowen=new Bowen();
        myBowen.sendSms();
    }
    
}
