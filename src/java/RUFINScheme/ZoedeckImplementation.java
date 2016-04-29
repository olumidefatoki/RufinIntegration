/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RUFINScheme;

import Utils.WalletCredentials;
import Utils.DBUtils;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Olumide
 */

public class ZoedeckImplementation {

    private String transactionResponse = null;
    private Zoedeck response = null;
    private String arugement = null;
    private final String URL = "http://otukpomfb.zoedeck.net/mfb/cellulant";

    public Zoedeck accountQuery(String referenceNo, String MSISDN, String platformId, int mfb, String actionId) {

        try {
            arugement = "Account Query Request";
            StringBuilder param = new StringBuilder();
            param.append(URL);
            param.append("?Action=AccountQuery");
            param.append("&RefId=").append(referenceNo);
            param.append("&phoneNumber=").append(WalletCredentials.FormatMSISDN(MSISDN));

            DBUtils.insert(MSISDN, referenceNo, arugement, platformId, mfb, actionId, "0", "0");
            transactionResponse = sendSms(param.toString());
            
                response = parseAccountQueryResponseXML(transactionResponse);
          
          
            System.out.println(transactionResponse);

            
             DBUtils.update(referenceNo, transactionResponse, actionId,response.getResponseCode(),response.getResponseDescription());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }

    private Zoedeck parseAccountQueryResponseXML(String transactionResponse) {
        Zoedeck res = new Zoedeck();
        try {

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(transactionResponse));

            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("NotificationResponse");

            Element element = (Element) nodes.item(0);

            NodeList responseCode = element.getElementsByTagName("responseCode");
            Element line = (Element) responseCode.item(0);
            res.setResponseCode(getCharacterDataFromElement(line));
           

            NodeList responseDescription = element.getElementsByTagName("responseDescription");
            line = (Element) responseDescription.item(0);
            res.setResponseDescription(getCharacterDataFromElement(line));
          

            NodeList RefId = element.getElementsByTagName("RefId");
            line = (Element) RefId.item(0);
            res.setReferenceNo(getCharacterDataFromElement(line));
           

            if (res.getResponseCode().equals("00")) {
                NodeList balance = element.getElementsByTagName("balance");
                line = (Element) balance.item(0);
                res.setBalance(Double.parseDouble(getCharacterDataFromElement(line)));
                
            }

        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return res;

    }

    public Zoedeck accountCredit(String referenceNo, String MSISDN, String narration, String transactionAmount, String platformId, int mfb, String actionId) {

        try {

            StringBuilder param = new StringBuilder();
            param.append(URL);
            param.append("?Action=CreditTransaction");
            param.append("&RefId=").append(referenceNo);
            param.append("&phoneNumber=").append(WalletCredentials.FormatMSISDN(MSISDN));
            param.append("&Amount=").append(transactionAmount);
            param.append("&Narration=").append(narration);

            DBUtils.insert(MSISDN, referenceNo, narration, platformId, mfb, actionId, transactionAmount, "0");
            transactionResponse = sendSms(param.toString());
            
          
                response = parseAccountCreditXML(transactionResponse);
            
            System.out.println("Response " + transactionResponse);
            
            DBUtils.update(referenceNo, transactionResponse, actionId,response.getResponseCode(),response.getResponseDescription()); 

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }

    public Zoedeck accountDebit(String referenceNo, String MSISDN, String narration, String transactionAmount, String transactionFee, String platformId, int mfb, String actionId) {

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
            transactionResponse = sendSms(param.toString());
           
                response = parseAccountDebitXML(transactionResponse);
            
            System.out.println("Response " + transactionResponse);
       
             DBUtils.update(referenceNo, transactionResponse, actionId,response.getResponseCode(),response.getResponseDescription());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }

    public Zoedeck transactionStatus(String referenceNo, String MSISDN, String platformId, int mfb, String actionId) {
        Zoedeck Response = null;


        try {

            StringBuilder param = new StringBuilder();
            param.append(URL);
            param.append("?Action=TransactionQuery");
            param.append("&RefId=").append(referenceNo);

            arugement = "transactionStatus Request ";
            //use this method to call accountQuery
            DBUtils.insert(MSISDN, referenceNo, arugement, platformId, mfb, actionId, "0", "0");
            transactionResponse = sendSms(param.toString());
            
            System.out.println("Response " + transactionResponse);
            Response = parseTransactionStatusXML(transactionResponse);
            DBUtils.update(referenceNo, transactionResponse, actionId,Response.getResponseCode(),Response.getResponseDescription());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return Response;
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
           
                response = parseTransactionReversalXML(transactionResponse);
            
            transactionResponse = sendSms(param.toString());
          
            System.out.println(transactionResponse);
            
            DBUtils.update(referenceNo, transactionResponse, actionId,response.getResponseCode(),response.getResponseDescription());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }

    private String sendSms(String msg) {
        int responseCode = 0;
        String responseMessage = "";

        try {
            URL myUrl = new URL(msg);
            System.out.println("Invoke URL " + myUrl.toString());
            HttpURLConnection resp = (HttpURLConnection) myUrl.openConnection();
            responseCode = resp.getResponseCode();
            responseMessage = resp.getResponseMessage();
            BufferedReader in = new BufferedReader(new InputStreamReader(resp.getInputStream()));
            String inputLine;
            StringBuilder res = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                res.append(inputLine.trim());
            }
            responseMessage = res.toString();
            in.close();
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return responseMessage;
    }

    private Zoedeck parseAccountCreditXML(String transactionResponse) {

        Zoedeck res = new Zoedeck();
        try {

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(transactionResponse));

            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("NotificationResponse");

            Element element = (Element) nodes.item(0);

            NodeList responseCode = element.getElementsByTagName("responseCode");
            Element line = (Element) responseCode.item(0);
            res.setResponseCode(getCharacterDataFromElement(line));
            System.out.println("responseCode : " + res.getResponseCode());

            NodeList responseDescription = element.getElementsByTagName("responseDescription");
            line = (Element) responseDescription.item(0);
            res.setResponseDescription(getCharacterDataFromElement(line));
            System.out.println("responseDescription : " + res.getResponseDescription());


        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return res;
    }

    private Zoedeck  parseAccountDebitXML(String transactionResponse) {
        Zoedeck res = new Zoedeck();
        try {

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(transactionResponse));

            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("NotificationResponse");

            Element element = (Element) nodes.item(0);

            NodeList responseCode = element.getElementsByTagName("responseCode");
            Element line = (Element) responseCode.item(0);
            res.setResponseCode(getCharacterDataFromElement(line));
            System.out.println("responseCode : " + res.getResponseCode());

            NodeList responseDescription = element.getElementsByTagName("responseDescription");
            line = (Element) responseDescription.item(0);
            res.setResponseDescription(getCharacterDataFromElement(line));
            System.out.println("responseDescription : " + res.getResponseDescription());


        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return res;
    }

    private Zoedeck parseTransactionStatusXML(String transactionResponse) {
        Zoedeck res = new Zoedeck();
        try {

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(transactionResponse));

            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("NotificationResponse");

            Element element = (Element) nodes.item(0);

            NodeList responseCode = element.getElementsByTagName("responseCode");
            Element line = (Element) responseCode.item(0);
            res.setResponseCode(getCharacterDataFromElement(line));
            System.out.println("responseCode : " + res.getResponseCode());

            NodeList responseDescription = element.getElementsByTagName("responseDescription");
            line = (Element) responseDescription.item(0);
            res.setResponseDescription(getCharacterDataFromElement(line));
            System.out.println("responseDescription : " + res.getResponseDescription());

            NodeList RefId = element.getElementsByTagName("RefId");
            line = (Element) RefId.item(0);
            res.setReferenceNo(getCharacterDataFromElement(line));
            System.out.println("RefId : " + res.getReferenceNo());

            NodeList phoneNumber = element.getElementsByTagName("phoneNumber");
            line = (Element) phoneNumber.item(0);
            res.setPhoneNumber(getCharacterDataFromElement(line));
            System.out.println("phoneNumber : " + res.getPhoneNumber());

            NodeList Amount = element.getElementsByTagName("Amount");
            line = (Element) Amount.item(0);
            res.setTransactionAmount(getCharacterDataFromElement(line));
            System.out.println("Amount : " + res.getTransactionAmount());


        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return res;
    }

    private Zoedeck parseTransactionReversalXML(String transactionResponse) {
        Zoedeck res = new Zoedeck();
        try {

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(transactionResponse));

            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("NotificationResponse");

            Element element = (Element) nodes.item(0);

            NodeList responseCode = element.getElementsByTagName("responseCode");
            Element line = (Element) responseCode.item(0);
            res.setResponseCode(getCharacterDataFromElement(line));
            System.out.println("responseCode : " + res.getResponseCode());

            NodeList responseDescription = element.getElementsByTagName("responseDescription");
            line = (Element) responseDescription.item(0);
            res.setResponseDescription(getCharacterDataFromElement(line));
            System.out.println("responseDescription : " + res.getResponseDescription());


        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return res;
    }

    public static void main(String[] args) {
        ZoedeckImplementation mytest = new ZoedeckImplementation();
              mytest.accountQuery("334345", "08012345671", "005", 4, "016");
//        mytest.accountCredit("33434555", "08012345671", "Account Credit", "100", "005", 4, "002");
   //     mytest.accountDebit("33434555", "08012345671", "Account Credit", "100", "150", "005", 4, "002");
        //    mytest.transactionStatus("3343455987", "08012345671", "005", 4,"00");
    }

   public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }
}

 