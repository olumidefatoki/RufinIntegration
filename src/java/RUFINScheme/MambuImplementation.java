/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RUFINScheme;

import Utils.DBUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author olumidefatoki
 */
public class MambuImplementation {

    private String transactionResponse = null;
    private String arugement = null;
    private final String URL = "https://seapmfi.mambu.com/api/savings/";
    private final String authentication = "Basic Y2VsbHVsYW50d2FsbGV0OmFiZ2RRMjgx";
    private int responseCode = 0;
    private String responseMessage = null;
    private Response cbaResp;
    private Mambu response;

    public Mambu accountQuery(String referenceNo, String MSISDN, String platformId, int mfb, String actionId, String accountNumber) {
        response = new Mambu();
        try {
            arugement = "Account Query Request";
            StringBuilder param = new StringBuilder();
            param.append(URL);
            param.append(accountNumber);
            //DBUtils.insert(MSISDN, referenceNo, arugement, platformId, mfb, actionId, "0", "0");
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(param.toString());
            cbaResp = target.request(MediaType.APPLICATION_JSON).header("authorization", authentication).get();
            responseCode = cbaResp.getStatus();
            responseMessage = cbaResp.readEntity(String.class);
            JSONObject obj = new JSONObject(responseMessage);
            if (responseCode == 200 || responseCode == 201) {
                response.setResponseCode("00");
                response.setResponseMessage("Successful");
                response.setAcctBalance(obj.getString("balance"));
                System.out.println("CBA Response: " + responseMessage);
            } else {
                response.setResponseCode(String.valueOf(obj.getInt("returnCode")));
                response.setResponseMessage(obj.getString("returnStatus"));
                System.out.println("CBA Response: " + responseMessage);
            }

            //DBUtils.update(referenceNo, responseMessage, actionId, response.getResponseCode(), response.getResponseMessage());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
    
    public Mambu accountCredit(String referenceNo, String MSISDN, String narration, String transactionAmount, String platformId, int mfb, String actionId, String accountNumber) {
        response = new Mambu();
        try {

            StringBuilder param = new StringBuilder();
            param.append(URL);
            param.append(accountNumber);
            param.append("/transactions");
            param.append("?type=DEPOSIT");
            param.append("&amount=").append(transactionAmount);

            DBUtils.insert(MSISDN, referenceNo, narration, platformId, mfb, actionId, transactionAmount, "0");
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(param.toString());
            cbaResp = target.request(MediaType.APPLICATION_JSON).header("authorization", authentication).post(null);
            responseCode = cbaResp.getStatus();
            responseMessage = cbaResp.readEntity(String.class);
            System.out.println("CBA Response : " + responseMessage);
            JSONObject obj = new JSONObject(responseMessage);
            if (responseCode == 200 || responseCode == 201) {
                response.setResponseCode("00");
                response.setResponseMessage("Successful");
                response.setCbatransactionID(String.valueOf(obj.getInt("transactionId")));
                System.out.println("CBA Response : " + responseMessage);

            } else {

                response.setResponseCode(String.valueOf(obj.getInt("returnCode")));
                response.setResponseMessage(obj.getString("returnStatus"));
                System.out.println("CBA Response: " + responseMessage);
            }

            DBUtils.updatewithTransID(referenceNo, responseMessage, actionId, response.getResponseCode(), response.getResponseMessage(), response.getCbatransactionID());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }

    public Mambu accountDebit(String referenceNo, String MSISDN, String narration, String transactionAmount, String transactionFee, String platformId, int mfb, String actionId, String accountNumber) {

        response = new Mambu();
        double amt = Double.parseDouble(transactionAmount) + Double.parseDouble(transactionFee);
        narration = narration.concat(" ,Convenience Fee:" + transactionFee );
        try {

            StringBuilder param = new StringBuilder();
            param.append(URL);
            param.append(accountNumber);
            param.append("/transactions");
            param.append("?type=WITHDRAWAL");
            param.append("&amount=").append(amt);
            param.append("&notes=").append(URLEncoder.encode(narration, "UTF-8"));
            System.out.println("URL " + param.toString());
            DBUtils.insert(MSISDN, referenceNo, narration, platformId, mfb, actionId, transactionAmount, "0");
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(param.toString());
            cbaResp = target.request(MediaType.APPLICATION_JSON).header("authorization", authentication).post(null);
            responseCode = cbaResp.getStatus();
            responseMessage = cbaResp.readEntity(String.class);
            JSONObject obj = new JSONObject(responseMessage);
            if (responseCode == 200 || responseCode == 201) {
                response.setResponseCode("00");
                response.setResponseMessage("Successful");
                response.setCbatransactionID(String.valueOf(obj.getInt("transactionId")));
                System.out.println("CBA Response : " + responseMessage);

            } else {
                response.setResponseCode(String.valueOf(obj.getInt("returnCode")));
                response.setResponseMessage(obj.getString("returnStatus"));
                System.out.println("CBA Response: " + responseMessage);

            }

            DBUtils.updatewithTransID(referenceNo, responseMessage, actionId, response.getResponseCode(), response.getResponseMessage(), response.getCbatransactionID());
        } catch (UnsupportedEncodingException | JSONException ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
    
    public Mambu transfer(String referenceNo, String MSISDN, String narration, String transactionAmount, String platformId, int mfb, String actionId, String fromAccountNumber,String toAccountNumber) {
        
        response = new Mambu();
        
         try {
            double amt = Double.parseDouble(transactionAmount);
        
            StringBuilder param = new StringBuilder();
            param.append(URL);
            param.append(fromAccountNumber);
            param.append("/transactions");
            param.append("?type=TRANSFER");
            param.append("&toSavingsAccount=").append(toAccountNumber);
            param.append("&amount=").append(amt);
            
            System.out.println("URL " + param.toString());
            DBUtils.insert(MSISDN, referenceNo, narration, platformId, mfb, actionId, transactionAmount, "0");
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(param.toString());
            cbaResp = target.request(MediaType.APPLICATION_JSON).header("authorization", authentication).post(null);
            responseCode = cbaResp.getStatus();
            responseMessage = cbaResp.readEntity(String.class);
            JSONObject obj = new JSONObject(responseMessage);
            if (responseCode == 200 || responseCode == 201) {
                response.setResponseCode("00");
                response.setResponseMessage("Successful");
                response.setCbatransactionID(String.valueOf(obj.getInt("transactionId")));
                System.out.println("CBA Response : " + responseMessage);

            } else {
                response.setResponseCode(String.valueOf(obj.getInt("returnCode")));
                response.setResponseMessage(obj.getString("returnStatus"));
                System.out.println("CBA Response: " + responseMessage);
            }

            DBUtils.updatewithTransID(referenceNo, responseMessage, actionId, response.getResponseCode(), response.getResponseMessage(), response.getCbatransactionID());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
    
    public Mambu transactionReversal(String referenceNo, String MSISDN, String platformId, int mfb, String actionId, String accountNumber) {
        String  transType = null;
        response = new Mambu();
        try {
            Mambu transDetail = DBUtils.getTransDetails(referenceNo);
            System.out.println("ActionID "+transDetail.getActionID());
             System.out.println("TransactionID "+transDetail.getCbatransactionID());
            if (transDetail.getActionID().equals("008") || transDetail.getActionID().equals("007") || transDetail.getActionID().equals("010") || transDetail.getActionID().equals("006")) {
                transType = "withdrawal_adjustment";

            } else if (transDetail.getActionID().equals("002")) {

                transType = "deposit_adjustment";
            }

            StringBuilder param = new StringBuilder();
            param.append(URL);
            param.append(accountNumber);
            param.append("/transactions");
            param.append("?type=").append(transType);
            param.append("&originalTransactionId=").append(transDetail.getCbatransactionID());
            param.append("&notes=").append(URLEncoder.encode(transType, "UTF-8"));
            System.out.println("url : " + param.toString());
            DBUtils.insert(MSISDN, referenceNo, transType+" Reversal Request ", platformId, mfb, actionId, "0", "0");
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(param.toString());
            cbaResp = target.request(MediaType.APPLICATION_JSON).header("authorization", authentication).post(null);
            responseCode = cbaResp.getStatus();
            responseMessage = cbaResp.readEntity(String.class);
            JSONObject obj = new JSONObject(responseMessage);
            if (responseCode == 200 || responseCode == 201) {
                response.setResponseCode("00");
                response.setResponseMessage("Successful");
                response.setCbatransactionID(String.valueOf(obj.getInt("transactionId")));
                System.out.println("CBA Response : " + responseMessage);

            } else {
                response.setResponseCode(String.valueOf(obj.getInt("returnCode")));
                response.setResponseMessage(obj.getString("returnStatus"));
                System.out.println("CBA Response: " + responseMessage);

            }

            DBUtils.updatewithTransID(referenceNo, responseMessage, actionId, response.getResponseCode(), response.getResponseMessage(), response.getCbatransactionID());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;

    }
    
    public static void main(String[] args) {
        MambuImplementation test= new MambuImplementation();
        test.transfer("11111", "2348060099476", "transfer", "100", "005", 2, "005", "AINE361", "ONDA468");
        
    }
}
