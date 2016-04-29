/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import RUFINScheme.Mambu;
import RUFINScheme.MambuImplementation;
import Utils.WalletCredentials;
import Utils.DBUtils;
import RUFINScheme.POM;
import RUFINScheme.POMImplementation;
import Utils.RufinCustProfile;
import RUFINScheme.RufinSmartMicro;
import RUFINScheme.RufinSmartMicroImplemation;
import RUFINScheme.VINO;
import RUFINScheme.VINOImplementation;
import RUFINScheme.Zoedeck;
import RUFINScheme.ZoedeckImplementation;
import SmartMicroScheme.SmartMicro;
import SmartMicroScheme.SmartMicroImplemation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author olumidefatoki
 */
@WebServlet(urlPatterns = {"/RufinTransaction"})
public class RufinTransaction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("Action");
            String refId = request.getParameter("RefId");
            String sender = request.getParameter("Sender");
            String platformId = request.getParameter("PlatformId");
            String receiver = request.getParameter("Receiver");
            String amount = request.getParameter("Amount");
            String narration = request.getParameter("Narration");
            String fee = request.getParameter("Fee");
            String name = request.getParameter("Name");
            String email = request.getParameter("Email");
            String occupation = request.getParameter("Occupation");
            String phone = request.getParameter("Phone");
            String address = request.getParameter("Address");
            String agentNumber = request.getParameter("AgentNumber");

            switch (platformId) {
                case WalletCredentials.RufinSchemeID: {

                    RufinCustProfile rcp = DBUtils.getCBAID(sender, platformId);
                       System.out.println("CBACode is " + rcp.getCBAcode());

                    switch (rcp.getCBAcode()) {

                        case WalletCredentials.rufinSmartMicroCBACode:

                            RufinSmartMicroImplemation smi = new RufinSmartMicroImplemation();
                            switch (action) {
                                case "007": {
                                    // Airtime Purchase   
                                    RufinSmartMicro fundTransferAccountDebit = smi.fundTransferAccountDebit(refId, sender, narration, amount, "0", "", rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (fundTransferAccountDebit.getResponseCode().equals("0")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "008": {
                                    //Bill Payment
                                    RufinSmartMicro fundTransferAccountDebit = smi.fundTransferAccountDebit(refId, sender, narration, amount, fee, "", rcp.getCBAcode(), rcp.getMFB(), action);
                                    if (fundTransferAccountDebit.getResponseCode().equals("0")) {
                                        out.println("00");
                                    } else {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "010": {
                                    //Trasfer to Bank

                                    RufinSmartMicro fundTransferAccountDebit = smi.fundTransferAccountDebit(refId, sender, narration, amount, fee, "", rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (fundTransferAccountDebit.getResponseCode().equals("0")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                     case "006": {
                                    //ATM  Transaction, POS Card Transaction

                                    RufinSmartMicro fundTransferAccountDebit = smi.fundTransferAccountDebit(refId, sender, narration, amount, fee, "", rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (fundTransferAccountDebit.getResponseCode().equals("0")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break; 
                                case "016": {
                                    //Balance Inquiry

                                    RufinSmartMicro accountQuery = smi.accountQuery(refId, sender, rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (accountQuery.getResponseCode().equals("0")) {
                                            out.println(accountQuery.getAvailableBalance());
                                        } else {
                                            out.println("25");
                                        }

                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "002": {
                                    //Credit

                                    RufinSmartMicro fundTransferAccountCredit = smi.fundTransferAccountCredit(refId, sender, narration, amount, rcp.getCBAcode(), rcp.getMFB(), action);
                                    if (fundTransferAccountCredit.getResponseCode().equals("0")) {
                                        out.println("00");
                                    } else {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "RVL": {
                                    //Reversal Transaction     
                                    RufinSmartMicro fundTransferReversal = smi.fundTransferReversal(refId, sender, rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (fundTransferReversal.getResponseCode().equals("0")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                default:
                                    out.println("25");
                                    System.out.println(" Action  Details does not exist");
                                    break;
                            }
                            break;
                        case WalletCredentials.andybaseDataSolutionCBACode:

                            ZoedeckImplementation zi = new ZoedeckImplementation();

                            switch (action) {
                                case "007": {
                                    // Airtime Purchase   
                                    Zoedeck accountDebit = zi.accountDebit(refId, sender, narration, amount, "0", rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (accountDebit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }

                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "008": {
                                    //Bill Payment
                                    Zoedeck accountDebit = zi.accountDebit(refId, sender, narration, amount, "100", rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (accountDebit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }
                                }
                                break;
                                case "010": {
                                    //Trasfer to Bank
                                    Zoedeck accountDebit = zi.accountDebit(refId, sender, narration, amount, "100", rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (accountDebit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }
                                }
                                break;
                                     case "006": {
                                    //ATM  Transaction, POS Card Transaction
                                    Zoedeck accountDebit = zi.accountDebit(refId, sender, narration, amount, "100", rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (accountDebit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }
                                }
                                break;
                                case "016": {
                                    //Balance Inquiry

                                    Zoedeck accountQuery = zi.accountQuery(refId, sender, rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (accountQuery.getResponseCode().equals("00")) {
                                            out.println(accountQuery.getBalance());
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }
                                }
                                break;
                                case "002": {
                                    //Credit
                                    Zoedeck credit = zi.accountCredit(refId, sender, narration, amount, rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (credit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }
                                } 
                                break;
                                case "RVL": {
                                    //Reversal
                                    Zoedeck fundTransferReversal = zi.transactionReversal(refId, sender, rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (fundTransferReversal.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }
                                }
                                break;
                                default:
                                    out.println("25");
                                    System.out.println(" Action  Details does not exist");
                                    break;
                            }

                            break;
                        case WalletCredentials.PomCBACode:

                            POMImplementation myPomCba = new POMImplementation();
                            switch (action) {
                                case "007": {
                                    // Airtime Purchase   
                                    POM accountDebit = myPomCba.accountDebit(refId, sender, narration, amount, "0", rcp.getCBAcode(), rcp.getMFB(), action, rcp.getAccountNumber());
                                    try {
                                        if (accountDebit.getRespCode().equals("0")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "008": {
                                    //Bill Payment
                                    POM accountDebit = myPomCba.accountDebit(refId, sender, narration, amount, fee, rcp.getCBAcode(), rcp.getMFB(), action, rcp.getAccountNumber());
                                    try {
                                        if (accountDebit.getRespCode().equals("0")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }

                                    } catch (Exception e) {
                                    }

                                }
                                break;
                                case "010": {
                                    //Trasfer to Bank

                                    POM accountDebit = myPomCba.accountDebit(refId, sender, narration, amount, fee, rcp.getCBAcode(), rcp.getMFB(), action, rcp.getAccountNumber());
                                    try {
                                        if (accountDebit.getRespCode().equals("0")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                    case "006": {
                                    //ATM  Transaction, POS Card Transaction

                                    POM accountDebit = myPomCba.accountDebit(refId, sender, narration, amount, fee, rcp.getCBAcode(), rcp.getMFB(), action, rcp.getAccountNumber());
                                    try {
                                        if (accountDebit.getRespCode().equals("0")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "016": {
                                    //Balance Inquiry
                                    try {
                                        POM accountQuery = myPomCba.accountQuery(refId, sender, rcp.getCBAcode(), rcp.getMFB(), action, rcp.getAccountNumber());
                                        if (accountQuery.getRespCode().equals("0")) {
                                            out.println(accountQuery.getAbalance());
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "002": {
                                    //Credit

                                    POM accountCredit = myPomCba.accountCredit(refId, sender, narration, amount, rcp.getCBAcode(), rcp.getMFB(), action, rcp.getAccountNumber());
                                    try {
                                        if (accountCredit.getRespCode().equals("0")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "RVL": {
                                    //Reversal Transaction     
                                    POM transactionReversal = myPomCba.transactionReversal(refId, sender, rcp.getCBAcode(), rcp.getMFB(), action, rcp.getAccountNumber());
                                    try {
                                        if (transactionReversal.getRespCode().equals("0")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                default:
                                    out.println("25");
                                    System.out.println(" Action  Details does not exist");
                                    break;
                            }
                            break;

                        case WalletCredentials.vinoBankingCBACode:

                            VINOImplementation myVin = new VINOImplementation();
                            switch (action) {
                                case "007": {
                                    // Airtime Purchase   
                                    VINO accountDebit = myVin.accountDebit(refId, sender, narration, amount, "0", rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (accountDebit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "008": {
                                    //Bill Payment
                                    VINO accountDebit = myVin.accountDebit(refId, sender, narration, amount, fee, rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (accountDebit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }

                                    } catch (Exception e) {
                                    }

                                }
                                break;
                                case "010": {
                                    //Trasfer to Bank

                                    VINO accountDebit = myVin.accountDebit(refId, sender, narration, amount, fee, rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (accountDebit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                     case "006": {
                                    //ATM  Transaction, POS Card Transaction

                                    VINO accountDebit = myVin.accountDebit(refId, sender, narration, amount, fee, rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (accountDebit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "016": {
                                    //Balance Inquiry
                                    try {
                                        VINO accountQuery = myVin.accountQuery(refId, sender, rcp.getCBAcode(), rcp.getMFB(), action);
                                        if (accountQuery.getResponseCode().equals("00")) {
                                            out.println(accountQuery.getBalance());
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "002": {
                                    //Credit

                                    VINO accountCredit = myVin.accountCredit(refId, sender, narration, amount, rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (accountCredit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "RVL": {
                                    //Reversal Transaction     
                                    VINO transactionReversal = myVin.transactionReversal(refId, sender, rcp.getCBAcode(), rcp.getMFB(), action);
                                    try {
                                        if (transactionReversal.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                            
                                    
                            break;
                                default:
                                    out.println("25");
                                    System.out.println(" Action  Details does not exist");
                                    break;
                            }
                            break;
                                    
                                    case WalletCredentials.mambuCBACode:

                               MambuImplementation myMambu = new MambuImplementation();
                            switch (action) {
                                case "007": {
                                    // Airtime Purchase   
                                    Mambu accountDebit = myMambu.accountDebit(refId, sender, narration, amount, "0", rcp.getCBAcode(), rcp.getMFB(), action,rcp.getAccountNumber());
                                    try {
                                        if (accountDebit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "008": {
                                    //Bill Payment
                                    Mambu accountDebit = myMambu.accountDebit(refId, sender, narration, amount, fee, rcp.getCBAcode(), rcp.getMFB(), action,rcp.getAccountNumber());
                                    try {
                                        if (accountDebit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }

                                    } catch (Exception e) {
                                    }

                                }
                                break;
                                case "010": {
                                    //Trasfer to Bank

                                     Mambu accountDebit = myMambu.accountDebit(refId, sender, narration, amount, fee, rcp.getCBAcode(), rcp.getMFB(), action,rcp.getAccountNumber());
                                    try {
                                        if (accountDebit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;                                    

                                        case "006": {
                                    //ATM  Transaction, POS Card Transaction

                                     Mambu accountDebit = myMambu.accountDebit(refId, sender, narration, amount, fee, rcp.getCBAcode(), rcp.getMFB(), action,rcp.getAccountNumber());
                                    try {
                                        if (accountDebit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;  
                                case "016": {
                                    //Balance Inquiry
                                    try {
                                         Mambu accountQuery = myMambu.accountQuery(refId, sender, rcp.getCBAcode(), rcp.getMFB(), action,rcp.getAccountNumber());
                                        if (accountQuery.getResponseCode().equals("00")) {
                                            out.println(accountQuery.getAcctBalance());
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "002": {
                                    //Credit

                                    Mambu accountCredit = myMambu.accountCredit(refId, sender, narration, amount, rcp.getCBAcode(), rcp.getMFB(), action,rcp.getAccountNumber());
                                    try {
                                        if (accountCredit.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                case "RVL": {
                                    //Reversal Transaction     
                                     Mambu transactionReversal = myMambu.transactionReversal(refId, sender, rcp.getCBAcode(), rcp.getMFB(), action,rcp.getAccountNumber());
                                    try {
                                        if (transactionReversal.getResponseCode().equals("00")) {
                                            out.println("00");
                                        } else {
                                            out.println("25");
                                        }
                                    } catch (Exception e) {
                                        out.println("25");
                                    }

                                }
                                break;
                                default:
                                    out.println("25");
                                    System.out.println(" Action  Details does not exist");
                                    break;
                            }

                            break;

                        default:
                            out.println("25");
                            System.out.println("Rufin Scheme can not Retrieve CBA Details" + "CBACode IS " + rcp.getCBAcode());
                            break;

                    }
                }
                break;

                case WalletCredentials.SmartMicroSchemeID: {

                    SmartMicroImplemation smi = new SmartMicroImplemation();
                    switch (action) {
                        case "007": {
                            // Airtime Purchase   
                            SmartMicro fundTransferAccountDebit = smi.fundTransferAccountDebit(refId, sender, narration, amount, "0", action);
                            try {
                                if (fundTransferAccountDebit.getResponseCode().equals("0")) {
                                    out.println("00");
                                } else {
                                    out.println("25");
                                }
                            } catch (Exception e) {
                                out.println("25");
                            }

                        }
                        break;
                        case "008": {
                            //Bill Payment
                            SmartMicro fundTransferAccountDebit = smi.fundTransferAccountDebit(refId, sender, narration, amount, fee, action);
                            if (fundTransferAccountDebit.getResponseCode().equals("0")) {
                                out.println("00");
                            } else {
                                out.println("25");
                            }

                        }
                        break;
                        case "010": {
                            //Trasfer to Bank

                            SmartMicro fundTransferAccountDebit = smi.fundTransferAccountDebit(refId, sender, narration, amount, fee, action);
                            try {
                                if (fundTransferAccountDebit.getResponseCode().equals("0")) {
                                    out.println("00");
                                } else {
                                    out.println("25");
                                }
                            } catch (Exception e) {
                                out.println("25");
                            }

                        }
                        break;
                        case "006": {
                            //ATM  Transaction, POS Card Transaction

                            SmartMicro fundTransferAccountDebit = smi.fundTransferAccountDebit(refId, sender, narration, amount, fee, action);
                            try {
                                if (fundTransferAccountDebit.getResponseCode().equals("0")) {
                                    out.println("00");
                                } else {
                                    out.println("25");
                                }
                            } catch (Exception e) {
                                out.println("25");
                            }

                        }
                        break;
                        case "016": {
                            //Balance Inquiry

                            SmartMicro accountQuery = smi.accountQuery(refId, sender, action);
                            try {
                                if (accountQuery.getResponseCode().equals("0")) {
                                    out.println(accountQuery.getAvailableBalance());
                                } else {
                                    out.println("25");
                                }

                            } catch (Exception e) {
                                out.println("25");
                            }

                        }
                        break;
                        case "002": {
                            //Credit

                            SmartMicro fundTransferAccountCredit = smi.fundTransferAccountCredit(refId, sender, narration, amount, action);
                            if (fundTransferAccountCredit.getResponseCode().equals("0")) {
                                out.println("00");
                            } else {
                                out.println("25");
                            }

                        }
                        break;
                        case "RVL": {
                            //Reversal Transaction     
                            SmartMicro fundTransferReversal = smi.fundTransferReversal(refId, sender, action);
                            try {
                                if (fundTransferReversal.getResponseCode().equals("0")) {
                                    out.println("00");
                                } else {
                                    out.println("25");
                                }
                            } catch (Exception e) {
                                out.println("25");
                            }

                        }
                        break;
                        default:
                            out.println("25");
                            System.out.println(" Action  Details does not exist");
                            break;
                    }

                }
                break;

                default:
                    out.println("25");
                    System.out.println("Can not Retrieve Scheme Details");
                    break;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private int createCustomer(String name, String email, String occupation, String phone, String address, String agentNumber) {
        int response;

        response = DBUtils.checkAgentNumbner();
        response = DBUtils.checkCUstomerAcount();
        response = DBUtils.createCustomer(name, email, occupation, phone, address, agentNumber);
        return response;
    }
}
