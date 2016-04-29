/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author olumidefatoki
 */
public class WalletCredentials {

    public final static String rufinSmartMicroCBACode = "001";
    public final static String vinoBankingCBACode = "003";
    public final static String andybaseDataSolutionCBACode = "008";
    public final static String PomCBACode = "006";
    public final static String mambuCBACode = "011";
    
    public final static String RufinSchemeID = "005";
    public final static String SmartMicroSchemeID = "800";
    
    public static  String SMResponseCodesIntertation(String Response) {
        String Interpretation;
        switch (Response) {
            case "0":
                Interpretation = "00";
                break;
            case "-1":
                Interpretation = "35";
                break;
            case "-2":
                Interpretation = "41";
                break;
            case "-3":
                Interpretation = "33";
                break;
            case "-4":
                Interpretation = "33";
                break;
            case "-5":
                Interpretation = "38";
                break;
            case "-6":
                Interpretation = "33";
                break;
            case "-7":
                Interpretation = "07";
                break;
            case "-8":
                Interpretation = "31";
                break;
            case "-9":
                Interpretation = "31";
                break;
            case "-10":
                Interpretation = "07";
                break;
            case "-11":
                Interpretation = "07";
                break;
            case "-12":
                Interpretation = "41";
                break;
            case "-13":
                Interpretation = "24";
                break;
            case "-14":
                Interpretation = "No debit is permitted on account";
                break;
            default:
                throw new AssertionError();
        }
        return Interpretation;
    }
    public static String FormatMSISDN(String MSISDN)
    {
        MSISDN="0".concat(MSISDN.substring(3));
        return MSISDN;
    }

}
