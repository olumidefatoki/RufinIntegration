/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RUFINScheme;

import Utils.WalletCredentials;
import Utils.Encryptor;
import Utils.DBUtils;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.parsers.*;
import org.tempuri.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author olumidefatoki
 */
public class RufinSmartMicroImplemation {

    final private String clientID = "1510000004";
    final private String PASSWORD = "YmE4ZTQxMDBmYTM3";
    private String arugement=null;
    String transactionResponse = null;
    RufinSmartMicro parseAccountQueryResponseXML = null;
    public RufinSmartMicro accountQuery(String referenceNo, String MSISDN,String platformId,int mfb,String actionId ) {
      
        try {
            String transactionResponse = null;
 
            SmartMicroTransactionGate gate = new SmartMicroTransactionGate();
            ITransactionGate tGate = gate.getBasicHttpsBindingITransactionGate();
            //use this method to call accountQuery
            arugement="Account Query Request";
            
            DBUtils.insert(MSISDN,referenceNo , arugement,platformId,mfb,actionId,"0","0");
            transactionResponse = tGate.accountQuery(clientID, PASSWORD, referenceNo, WalletCredentials.FormatMSISDN(MSISDN), "");
            
             System.out.println(transactionResponse);
            // Log.l.infoLog.info("Response for Transction "+referenceNo +"**"+transactionResponse +"**");
             if (transactionResponse==null) {
                parseAccountQueryResponseXML.setResponseCode("25");
                parseAccountQueryResponseXML.setResponseMessage("Third Party is not reachable");
            }
             else{
            parseAccountQueryResponseXML = parseAccountQueryResponseXML(transactionResponse);
             }
             DBUtils.update(referenceNo, transactionResponse,actionId,parseAccountQueryResponseXML.getResponseCode(),parseAccountQueryResponseXML.getResponseMessage());
           
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return parseAccountQueryResponseXML;
    }

    private RufinSmartMicro parseAccountQueryResponseXML(String transactionResponse) {
        RufinSmartMicro res = new RufinSmartMicro();
        try {

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(transactionResponse));

            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("TransactionGateResponse");

            Element element = (Element) nodes.item(0);
            NodeList responseCode = element.getElementsByTagName("responseCode");
            Element line = (Element) responseCode.item(0);
            res.setResponseCode(getCharacterDataFromElement(line));
           

            NodeList responseMessage = element.getElementsByTagName("responseMessage");
            line = (Element) responseMessage.item(0);
            res.setResponseMessage(getCharacterDataFromElement(line));
           

            NodeList accountName = element.getElementsByTagName("accountInfo");
            line = (Element) accountName.item(0);
            res.setAccountInfo(getCharacterDataFromElement(line));
            String[] parts = res.getAccountInfo().split("\\|");
            if (parts.length>1) {
                res.setAccountName(parts[2]);
             res.setAvailableBalance(Double.parseDouble(parts[1]));
             res.setAccountType(parts[4]);
            }
            NodeList referenceNo = element.getElementsByTagName("referenceNo");
            line = (Element) referenceNo.item(0);
            res.setReferenceNo(getCharacterDataFromElement(line));
        

            NodeList accountNo = element.getElementsByTagName("accountNo");
            line = (Element) accountNo.item(0);
            res.setAccountNo(getCharacterDataFromElement(line));
            

            NodeList bin = element.getElementsByTagName("bin");
            line = (Element) bin.item(0);
            res.setBin(getCharacterDataFromElement(line));
         

        } catch (ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        } catch (SAXException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;

    }

    public RufinSmartMicro fundTransferAccountCredit(String referenceNo, String MSISDN, String narration, String transactionAmount,String platformId,int mfb,String actionId) {
         RufinSmartMicro accountQueryResponse = null ;
       
        try {
        String authorizationKey=Encryptor.encrypt(referenceNo,PASSWORD );

      //  System.out.println("Encrption :" + authorizationKey);
      accountQueryResponse = new RufinSmartMicro();
        String transactionResponse;
       
            SmartMicroTransactionGate gate = new SmartMicroTransactionGate();
            ITransactionGate tGate = gate.getBasicHttpsBindingITransactionGate();
            //use this method to call accountQuery
             
              DBUtils.insert(MSISDN, referenceNo, narration,platformId,mfb,actionId,transactionAmount,"0");
              transactionResponse = tGate.fundTransferAccountCredit(clientID, PASSWORD, referenceNo, WalletCredentials.FormatMSISDN(MSISDN), "", narration, transactionAmount, "0", authorizationKey);//.transactionStatus("1510000004", "9b5607c1dd96ecf93816feab55871bf2", "123456");
             System.out.println("Response " + transactionResponse);
               
            accountQueryResponse=parsefundTransferAccountCreditXML(transactionResponse);
             DBUtils.update(referenceNo, transactionResponse,actionId,accountQueryResponse.getResponseCode(),accountQueryResponse.getResponseMessage());

        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        }
        return accountQueryResponse;
    }

    private   RufinSmartMicro parsefundTransferAccountCreditXML(String transactionResponse) {
        RufinSmartMicro res = new RufinSmartMicro();
        try {

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(transactionResponse));

            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("TransactionGateResponse");

            Element element = (Element) nodes.item(0);
            NodeList responseCode = element.getElementsByTagName("responseCode");
            Element line = (Element) responseCode.item(0);
            res.setResponseCode(getCharacterDataFromElement(line));
           // System.out.println("Element" + line.toString() + "responseCode: " + res.getResponseCode());

            NodeList responseMessage = element.getElementsByTagName("responseMessage");
            line = (Element) responseMessage.item(0);
            res.setResponseMessage(getCharacterDataFromElement(line));
            //System.out.println("Element" + line.toString() + "responseMessage: " + res.getResponseMessage());

            NodeList narration = element.getElementsByTagName("narration");
            line = (Element) narration.item(0);
            res.setNarration(getCharacterDataFromElement(line));
           // System.out.println("Element" + line.toString() + "narration: " +res.getNarration() );

            NodeList referenceNo = element.getElementsByTagName("referenceNo");
            line = (Element) referenceNo.item(0);
            res.setReferenceNo(getCharacterDataFromElement(line));
           // System.out.println("Element" + line.toString() + "referenceNo: " + res.getReferenceNo());

            NodeList accountNo = element.getElementsByTagName("accountNo");
            line = (Element) accountNo.item(0);
            res.setAccountNo(getCharacterDataFromElement(line));
          //  System.out.println("Element" + line.toString() + "accountNo: " + res.getAccountNo());

             NodeList amount = element.getElementsByTagName("amount");
            line = (Element) amount.item(0);
            res.setTransactionAmount(getCharacterDataFromElement(line));
           // System.out.println("Element" + line.toString() + "TransactionAmount: " + res.getTransactionAmount());
            
            NodeList fee = element.getElementsByTagName("fee");
            line = (Element) fee.item(0);
            res.setTransactionFee(getCharacterDataFromElement(line));
          //  System.out.println("Element" + line.toString() + "fee: " + res.getTransactionFee());
            
            NodeList bin = element.getElementsByTagName("bin");
            line = (Element) bin.item(0);
            res.setBin(getCharacterDataFromElement(line));
           // System.out.println("Element" + line.toString() + "bin: " + res.getBin());

        } catch (ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        } catch (SAXException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;

    }
    
    public RufinSmartMicro fundTransferAccountDebit(String referenceNo, String MSISDN, String narration, String transactionAmount,String transactionFee, String bin,String platformId,int mfb,String actionId) 
    {
       RufinSmartMicro accountQueryResponse = null;
      
               try {
        String authorizationKey=Encryptor.encrypt(referenceNo,PASSWORD );

      //  System.out.println("Encrption :" + authorizationKey);
        accountQueryResponse = new RufinSmartMicro();
        
       
                String transactionResponse;
            
            SmartMicroTransactionGate gate = new SmartMicroTransactionGate();
            ITransactionGate tGate = gate.getBasicHttpsBindingITransactionGate();
            
            DBUtils.insert(MSISDN, referenceNo, narration,platformId,mfb,actionId,transactionAmount,transactionFee);
            //use this method to call accountQuery
            transactionResponse = tGate.fundTransferAccountDebit(clientID, PASSWORD, referenceNo, WalletCredentials.FormatMSISDN(MSISDN), bin, narration, transactionAmount, transactionFee, authorizationKey,1);//.transactionStatus("1510000004", "9b5607c1dd96ecf93816feab55871bf2", "123456");
           
            System.out.println("Response " + transactionResponse);
            accountQueryResponse=parsefundTransferAccountDebitXML(transactionResponse);
             DBUtils.update(referenceNo, transactionResponse,actionId,accountQueryResponse.getResponseCode(),accountQueryResponse.getResponseMessage());

        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
                   System.out.println("Error : " + ex.getMessage());
        }
        return accountQueryResponse;
    }

    private   RufinSmartMicro parsefundTransferAccountDebitXML(String transactionResponse) {
        RufinSmartMicro res = new RufinSmartMicro();
        try {

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(transactionResponse));

            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("TransactionGateResponse");

            Element element = (Element) nodes.item(0);
            NodeList responseCode = element.getElementsByTagName("responseCode");
            Element line = (Element) responseCode.item(0);
            res.setResponseCode(getCharacterDataFromElement(line));
         //   System.out.println("Element" + line.toString() + "responseCode: " + res.getResponseCode());

            NodeList responseMessage = element.getElementsByTagName("responseMessage");
            line = (Element) responseMessage.item(0);
            res.setResponseMessage(getCharacterDataFromElement(line));
         //   System.out.println("Element" + line.toString() + "responseMessage: " + res.getResponseMessage());

            NodeList narration = element.getElementsByTagName("narration");
            line = (Element) narration.item(0);
            res.setNarration(getCharacterDataFromElement(line));
        //    System.out.println("Element" + line.toString() + "narration: " +res.getNarration() );

            NodeList referenceNo = element.getElementsByTagName("referenceNo");
            line = (Element) referenceNo.item(0);
            res.setReferenceNo(getCharacterDataFromElement(line));
       //     System.out.println("Element" + line.toString() + "referenceNo: " + res.getReferenceNo());

            NodeList accountNo = element.getElementsByTagName("accountNo");
            line = (Element) accountNo.item(0);
            res.setAccountNo(getCharacterDataFromElement(line));
        //    System.out.println("Element" + line.toString() + "accountNo: " + res.getAccountNo());

             NodeList amount = element.getElementsByTagName("amount");
            line = (Element) amount.item(0);
            res.setTransactionAmount(getCharacterDataFromElement(line));
          //  System.out.println("Element" + line.toString() + "TransactionAmount: " + res.getTransactionAmount());
            
            NodeList fee = element.getElementsByTagName("fee");
            line = (Element) fee.item(0);
            res.setTransactionFee(getCharacterDataFromElement(line));
         //   System.out.println("Element" + line.toString() + "fee: " + res.getTransactionFee());
            
            NodeList bin = element.getElementsByTagName("bin");
            line = (Element) bin.item(0);
            res.setBin(getCharacterDataFromElement(line));
         //   System.out.println("Element" + line.toString() + "bin: " + res.getBin());

        } catch (ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        } catch (SAXException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;

    }

    public RufinSmartMicro transactionStatus(String referenceNo, String MSISDN,String platformId,int mfb,String actionId) {

        RufinSmartMicro accountQueryResponse = null;
             //       DBUtils myDBUtils=new DBUtils();

        try {
            String transactionResponse = null;
            
            SmartMicroTransactionGate gate = new SmartMicroTransactionGate();
            ITransactionGate tGate = gate.getBasicHttpsBindingITransactionGate();
             arugement="transactionStatus Request " ;
            //use this method to call accountQuery
             DBUtils.insert(MSISDN, referenceNo, arugement,platformId,mfb,actionId,"0","0");
            transactionResponse = tGate.transactionStatus(clientID, PASSWORD, referenceNo);
           
           System.out.println("Response " + transactionResponse);
            accountQueryResponse = parseTransactionStatusResponseXML(transactionResponse);
         
            DBUtils.update(referenceNo, transactionResponse,actionId,accountQueryResponse.getResponseCode(),accountQueryResponse.getResponseMessage());
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return accountQueryResponse;
    }

    private  RufinSmartMicro parseTransactionStatusResponseXML(String transactionResponse) {
        RufinSmartMicro res = new RufinSmartMicro();
        try {
          
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(transactionResponse));
            
            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("TransactionGateResponse");

            Element element = (Element) nodes.item(0);
            NodeList responseCode = element.getElementsByTagName("responseCode");
            Element line = (Element) responseCode.item(0);
            res.setResponseCode(getCharacterDataFromElement(line));
          // System.out.println("Element" + line.toString() + "responseCode: " + res.getResponseCode());

            NodeList responseMessage = element.getElementsByTagName("responseMessage");
            line = (Element) responseMessage.item(0);
            res.setResponseMessage(getCharacterDataFromElement(line));
         //  System.out.println("Element" + line.toString() + "responseMessage: " + res.getResponseMessage());

            NodeList referenceNo = element.getElementsByTagName("referenceNo");
            line = (Element) referenceNo.item(0);
            res.setReferenceNo(getCharacterDataFromElement(line));
          //  System.out.println("Element" + line.toString() + "referenceNo: " + res.getReferenceNo());


        } catch (ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        } catch (SAXException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;

    }

    public RufinSmartMicro fundTransferReversal(String referenceNo,String MSISDN,String platformId,int mfb,String actionId) {

        RufinSmartMicro accountQueryResponse = null;
        
        try {  
            String authorizationKey=Encryptor.encrypt(referenceNo,PASSWORD );
            String transactionResponse = null;
           
            SmartMicroTransactionGate gate = new SmartMicroTransactionGate();
            ITransactionGate tGate = gate.getBasicHttpsBindingITransactionGate();
            
             arugement="fundTransferReversal Request " ;
              DBUtils.insert(MSISDN, referenceNo, arugement,platformId,mfb,actionId,"0","0");
            //use this method to call accountQuery
            transactionResponse = tGate.fundTransferReversal(clientID, PASSWORD, referenceNo,authorizationKey);//.transactionStatus("1510000004", "9b5607c1dd96ecf93816feab55871bf2", "123456");
           
           System.out.println( transactionResponse);
            accountQueryResponse = parseTransactionStatusResponseXML(transactionResponse);
             DBUtils.update(referenceNo, transactionResponse,actionId,accountQueryResponse.getResponseCode(),accountQueryResponse.getResponseMessage());
         
           
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        }
        return accountQueryResponse;
    }

    private RufinSmartMicro parsefundTransferReversalResponseXML(String transactionResponse) {
        RufinSmartMicro res = new RufinSmartMicro();
        try {

             DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(transactionResponse));

            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("TransactionGateResponse");

            Element element = (Element) nodes.item(0);
            NodeList responseCode = element.getElementsByTagName("responseCode");
            Element line = (Element) responseCode.item(0);
            res.setResponseCode(getCharacterDataFromElement(line));
           // System.out.println("Element" + line.toString() + "responseCode: " + res.getResponseCode());

            NodeList responseMessage = element.getElementsByTagName("responseMessage");
            line = (Element) responseMessage.item(0);
            res.setResponseMessage(getCharacterDataFromElement(line));
           // System.out.println("Element" + line.toString() + "responseMessage: " + res.getResponseMessage());

              NodeList referenceNo = element.getElementsByTagName("referenceNo");
            line = (Element) referenceNo.item(0);
            res.setReferenceNo(getCharacterDataFromElement(line));
         //   System.out.println("Element" + line.toString() + "referenceNo: " + res.getReferenceNo());
            
            NodeList accountNo = element.getElementsByTagName("accountNo");
            line = (Element) accountNo.item(0);
            res.setAccountNo(getCharacterDataFromElement(line));
          //  System.out.println("Element" + line.toString() + "accountNo: " + res.getAccountNo());
            
             NodeList bin = element.getElementsByTagName("bin");
            line = (Element) bin.item(0);
            res.setBin(getCharacterDataFromElement(line));
         //   System.out.println("Element" + line.toString() + "bin: " + res.getBin());
            
            NodeList narration = element.getElementsByTagName("narration");
            line = (Element) narration.item(0);
            res.setNarration(getCharacterDataFromElement(line));
         //   System.out.println("Element" + line.toString() + "narration: " +res.getNarration() );

             NodeList amount = element.getElementsByTagName("amount");
            line = (Element) amount.item(0);
            res.setTransactionAmount(getCharacterDataFromElement(line));
          //  System.out.println("Element" + line.toString() + "TransactionAmount: " + res.getTransactionAmount());
            
            NodeList fee = element.getElementsByTagName("fee");
            line = (Element) fee.item(0);
            res.setTransactionFee(getCharacterDataFromElement(line));
         //   System.out.println("Element" + line.toString() + "fee: " + res.getTransactionFee());
            

        } catch (ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        } catch (SAXException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;

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
