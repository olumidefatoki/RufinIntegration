/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RUFINScheme;

import Utils.DBUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.sddscorp.pfc.server.service.sws.PFSTransactionService;
import net.sddscorp.pfc.server.service.sws.PFSTransactionService_Service;
import net.sddscorp.pfc.server.service.sws.PfstReqData;
/**
 * 
 *
 * @author olumidefatoki
 */
public class POMImplementation {
     private String transactionResponse = null;
    private POM response = null;
    private String arugement = null;
    private PfstReqData res=null;
    private final String PassId="5376df092c48417796d7929e039059f662747bf1a4222d5b989333c2a2c705a72f56c2fd489ce63402f131a18982d011094a79a97d2bd73af91837a12411c1a6";
    private final String GatewayId="3570001138";
   

    public POM accountQuery(String referenceNo, String MSISDN, String platformId, int mfb, String actionId,String accountNumber) {

        try {
            
            PFSTransactionService_Service service = new PFSTransactionService_Service();
            PFSTransactionService port = service.getPFSTransactionPort();
            PfstReqData req=new PfstReqData();
            
            req.setAccountno(accountNumber);
            req.setTranType("420");
            req.setReferenceno(referenceNo);
            req.setPassId(PassId);
            req.setGatewayId(GatewayId);
            res= port.getP2435(req);
            arugement = "Account Query Request";
            
            response=new POM();
            response.setRespCode(res.getRespCode());
            response.setRespMessage(res.getRespMessage());
            response.setAccountName(res.getAccountName());
            response.setAbalance(res.getAbalance());
            response.setAccountName(res.getAccountName());
            response.setTransactionMessage(res.getTransactionMessage());
            response.setTransactionStatus(res.getTranDesc());
            

            DBUtils.insert(MSISDN, referenceNo, arugement, platformId, mfb, actionId, "0", "0");
            transactionResponse = " Account Name : " + response.getAccountName()+" Abalance : " +response.getAbalance();
          
            System.out.println(transactionResponse);
            DBUtils.update(referenceNo, transactionResponse, actionId,res.getRespCode(),res.getRespMessage());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return response;
    }

  

    public POM accountCredit(String referenceNo, String MSISDN, String narration, String transactionAmount, String platformId, int mfb, String actionId,String accountNumber) {

        try {

            PFSTransactionService_Service service = new PFSTransactionService_Service();
            PFSTransactionService port = service.getPFSTransactionPort();
            PfstReqData req=new PfstReqData();
            
            req.setAccountName("NA");
            req.setAccountno(accountNumber);
            req.setTranType("100");
            req.setReferenceno(referenceNo);
            req.setSequenceNo(referenceNo);
            req.setTranAmount(Double.parseDouble(transactionAmount));
            req.setTranDate(formatDate());
            req.setFeecharge(0.0);
            req.setPassId(PassId);
            req.setGatewayId(GatewayId);
            req.setTranDesc(narration);
            res= port.getP2435(req);
            
            
            response=new POM();
            response.setRespCode(res.getRespCode());
            response.setRespMessage(res.getRespMessage());
            response.setAccountName(res.getAccountName());
            response.setAbalance(res.getAbalance());
            response.setAccountName(res.getAccountName());
            response.setTransactionMessage(res.getTransactionMessage());
            response.setTransactionStatus(res.getTranDesc());
            
            DBUtils.insert(MSISDN, referenceNo, narration, platformId, mfb, actionId, transactionAmount, "0");
            transactionResponse = "Resp Code : " + response.getRespCode()+" RespMessage : " +response.getRespMessage();
            System.out.println(transactionResponse);
            DBUtils.update(referenceNo, transactionResponse, actionId,response.getRespCode(),response.getRespMessage()); 

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
    
    public POM accountDebit(String referenceNo, String MSISDN, String narration, String transactionAmount, String transactionFee, String platformId, int mfb, String actionId,String accountNumber) {

        try {

            PFSTransactionService_Service service = new PFSTransactionService_Service();
            PFSTransactionService port = service.getPFSTransactionPort();
            PfstReqData req=new PfstReqData();
            
            req.setAccountName("NA");
            req.setAccountno(accountNumber);
            req.setTranType("311");
            req.setReferenceno(referenceNo);
            req.setSequenceNo(referenceNo);
            req.setTranAmount(Double.parseDouble(transactionAmount));
            req.setTranDate(formatDate());
            req.setFeecharge(Double.parseDouble(transactionFee));
            req.setPassId(PassId);
            req.setGatewayId(GatewayId);
            req.setTranDesc(narration);
            res= port.getP2435(req);
            
            
            response=new POM();
            response.setRespCode(res.getRespCode());
            response.setRespMessage(res.getRespMessage());
            response.setAccountName(res.getAccountName());
            response.setAbalance(res.getAbalance());
            response.setAccountName(res.getAccountName());
            response.setTransactionMessage(res.getTransactionMessage());
            response.setTransactionStatus(res.getTranDesc());
            
            DBUtils.insert(MSISDN, referenceNo, narration, platformId, mfb, actionId, transactionAmount, transactionFee);
            transactionResponse = "Resp Code : " + response.getRespCode()+" RespMessage : " +response.getRespMessage();
             System.out.println(transactionResponse);
            DBUtils.update(referenceNo, transactionResponse, actionId,response.getRespCode(),response.getRespMessage()); 

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
public POM transactionReversal(String referenceNo, String MSISDN, String platformId, int mfb, String actionId, String accountNumber) {
String transactionAmount=DBUtils.getTransAmt(referenceNo);
String transactionFee="0.0";
arugement = "transactionReversal Request ";
        try {

            PFSTransactionService_Service service = new PFSTransactionService_Service();
            PFSTransactionService port = service.getPFSTransactionPort();
            PfstReqData req=new PfstReqData();
             
            req.setAccountName("NA");
            req.setAccountno(accountNumber);
            req.setTranType("106");
            req.setReferenceno(referenceNo);
            req.setSequenceNo(referenceNo);
            req.setTranAmount(Double.parseDouble(transactionAmount));
            req.setTranDate(formatDate());
           // req.setFeecharge(Double.parseDouble(transactionFee));
            req.setPassId(PassId);
            req.setGatewayId(GatewayId);
            req.setTranDesc(arugement);
            res= port.getP2435(req);
            
            
            response=new POM();
            response.setRespCode(res.getRespCode());
            response.setRespMessage(res.getRespMessage());
            response.setAccountName(res.getAccountName());
            response.setAbalance(res.getAbalance());
            response.setAccountName(res.getAccountName());
            response.setTransactionMessage(res.getTransactionMessage());
            response.setTransactionStatus(res.getTranDesc());
            
            DBUtils.insert(MSISDN, referenceNo, arugement, platformId, mfb, actionId, transactionAmount, "0");
            transactionResponse = "Resp Code : " + response.getRespCode()+" RespMessage : " +response.getRespMessage();
             System.out.println(transactionResponse);
            DBUtils.update(referenceNo, transactionResponse, actionId,response.getRespCode(),response.getRespMessage()); 

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }



    public String formatDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String myDate=dateFormat.format(date);
         String escChar[] = {"-",":"," "};
        for (int i = 0; i < escChar.length; i++) {
            myDate =myDate.replace(escChar[i], "");
        }
        return myDate;
    }
    public static void main(String[] args) {
       
        POMImplementation myPom= new POMImplementation();
        // System.out.println(myPom.formatDate());
      myPom.accountQuery("1234567891", "08060099476", "006", 4, "016", "810015200009");
     //   myPom.accountCredit("1234567895", "08060099476", "Glo Airtime Purchase","200", "006", 4, "008","810015200009" );
     //  myPom.accountDebit("1234567894", "08060099476", "Glo Airtime Purchase","200","100", "006", 4, "008","810015200009" );
     //myPom.transactionReversal("1234567895", "08060099476","006", 4, "RVL",  "810015200009");
   
    }
}
