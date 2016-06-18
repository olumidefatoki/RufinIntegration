
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.smartmicrotransactiongate.CompositeType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FundTransferAccountDebitResponseFundTransferAccountDebitResult_QNAME = new QName("http://tempuri.org/", "fundTransferAccountDebitResult");
    private final static QName _GetDataUsingDataContractResponseGetDataUsingDataContractResult_QNAME = new QName("http://tempuri.org/", "GetDataUsingDataContractResult");
    private final static QName _CustomerLinkAccountRequestClientID_QNAME = new QName("http://tempuri.org/", "clientID");
    private final static QName _CustomerLinkAccountRequestReferenceNo_QNAME = new QName("http://tempuri.org/", "referenceNo");
    private final static QName _CustomerLinkAccountRequestMobileNo_QNAME = new QName("http://tempuri.org/", "mobileNo");
    private final static QName _CustomerLinkAccountRequestClientPassword_QNAME = new QName("http://tempuri.org/", "clientPassword");
    private final static QName _GetDataResponseGetDataResult_QNAME = new QName("http://tempuri.org/", "GetDataResult");
    private final static QName _AccountMinistatementResponseAccountMinistatementResult_QNAME = new QName("http://tempuri.org/", "accountMinistatementResult");
    private final static QName _FundTransferAccountCreditResponseFundTransferAccountCreditResult_QNAME = new QName("http://tempuri.org/", "fundTransferAccountCreditResult");
    private final static QName _FundTransferReversalResponseFundTransferReversalResult_QNAME = new QName("http://tempuri.org/", "fundTransferReversalResult");
    private final static QName _FundTransferAccountDebitTransactionFee_QNAME = new QName("http://tempuri.org/", "transactionFee");
    private final static QName _FundTransferAccountDebitAccountNo_QNAME = new QName("http://tempuri.org/", "accountNo");
    private final static QName _FundTransferAccountDebitNarration_QNAME = new QName("http://tempuri.org/", "narration");
    private final static QName _FundTransferAccountDebitTransactionAmount_QNAME = new QName("http://tempuri.org/", "transactionAmount");
    private final static QName _FundTransferAccountDebitBin_QNAME = new QName("http://tempuri.org/", "bin");
    private final static QName _FundTransferAccountDebitAuthorizationKey_QNAME = new QName("http://tempuri.org/", "authorizationKey");
    private final static QName _GetDataUsingDataContractComposite_QNAME = new QName("http://tempuri.org/", "composite");
    private final static QName _AccountQueryResponseAccountQueryResult_QNAME = new QName("http://tempuri.org/", "accountQueryResult");
    private final static QName _GetBankListResponseGetBankListResult_QNAME = new QName("http://tempuri.org/", "getBankListResult");
    private final static QName _CustomerLinkAccountRequestResponseCustomerLinkAccountRequestResult_QNAME = new QName("http://tempuri.org/", "CustomerLinkAccountRequestResult");
    private final static QName _TransactionStatusResponseTransactionStatusResult_QNAME = new QName("http://tempuri.org/", "transactionStatusResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransactionStatus }
     * 
     */
    public TransactionStatus createTransactionStatus() {
        return new TransactionStatus();
    }

    /**
     * Create an instance of {@link GetDataUsingDataContractResponse }
     * 
     */
    public GetDataUsingDataContractResponse createGetDataUsingDataContractResponse() {
        return new GetDataUsingDataContractResponse();
    }

    /**
     * Create an instance of {@link AccountQueryResponse }
     * 
     */
    public AccountQueryResponse createAccountQueryResponse() {
        return new AccountQueryResponse();
    }

    /**
     * Create an instance of {@link CustomerLinkAccountRequest }
     * 
     */
    public CustomerLinkAccountRequest createCustomerLinkAccountRequest() {
        return new CustomerLinkAccountRequest();
    }

    /**
     * Create an instance of {@link FundTransferAccountDebit }
     * 
     */
    public FundTransferAccountDebit createFundTransferAccountDebit() {
        return new FundTransferAccountDebit();
    }

    /**
     * Create an instance of {@link GetBankListResponse }
     * 
     */
    public GetBankListResponse createGetBankListResponse() {
        return new GetBankListResponse();
    }

    /**
     * Create an instance of {@link FundTransferReversalResponse }
     * 
     */
    public FundTransferReversalResponse createFundTransferReversalResponse() {
        return new FundTransferReversalResponse();
    }

    /**
     * Create an instance of {@link AccountMinistatement }
     * 
     */
    public AccountMinistatement createAccountMinistatement() {
        return new AccountMinistatement();
    }

    /**
     * Create an instance of {@link GetDataUsingDataContract }
     * 
     */
    public GetDataUsingDataContract createGetDataUsingDataContract() {
        return new GetDataUsingDataContract();
    }

    /**
     * Create an instance of {@link AccountQuery }
     * 
     */
    public AccountQuery createAccountQuery() {
        return new AccountQuery();
    }

    /**
     * Create an instance of {@link CustomerLinkAccountRequestResponse }
     * 
     */
    public CustomerLinkAccountRequestResponse createCustomerLinkAccountRequestResponse() {
        return new CustomerLinkAccountRequestResponse();
    }

    /**
     * Create an instance of {@link FundTransferAccountDebitResponse }
     * 
     */
    public FundTransferAccountDebitResponse createFundTransferAccountDebitResponse() {
        return new FundTransferAccountDebitResponse();
    }

    /**
     * Create an instance of {@link GetData }
     * 
     */
    public GetData createGetData() {
        return new GetData();
    }

    /**
     * Create an instance of {@link FundTransferAccountCreditResponse }
     * 
     */
    public FundTransferAccountCreditResponse createFundTransferAccountCreditResponse() {
        return new FundTransferAccountCreditResponse();
    }

    /**
     * Create an instance of {@link TransactionStatusResponse }
     * 
     */
    public TransactionStatusResponse createTransactionStatusResponse() {
        return new TransactionStatusResponse();
    }

    /**
     * Create an instance of {@link GetBankList }
     * 
     */
    public GetBankList createGetBankList() {
        return new GetBankList();
    }

    /**
     * Create an instance of {@link GetDataResponse }
     * 
     */
    public GetDataResponse createGetDataResponse() {
        return new GetDataResponse();
    }

    /**
     * Create an instance of {@link FundTransferAccountCredit }
     * 
     */
    public FundTransferAccountCredit createFundTransferAccountCredit() {
        return new FundTransferAccountCredit();
    }

    /**
     * Create an instance of {@link FundTransferReversal }
     * 
     */
    public FundTransferReversal createFundTransferReversal() {
        return new FundTransferReversal();
    }

    /**
     * Create an instance of {@link AccountMinistatementResponse }
     * 
     */
    public AccountMinistatementResponse createAccountMinistatementResponse() {
        return new AccountMinistatementResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "fundTransferAccountDebitResult", scope = FundTransferAccountDebitResponse.class)
    public JAXBElement<String> createFundTransferAccountDebitResponseFundTransferAccountDebitResult(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitResponseFundTransferAccountDebitResult_QNAME, String.class, FundTransferAccountDebitResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetDataUsingDataContractResult", scope = GetDataUsingDataContractResponse.class)
    public JAXBElement<CompositeType> createGetDataUsingDataContractResponseGetDataUsingDataContractResult(CompositeType value) {
        return new JAXBElement<CompositeType>(_GetDataUsingDataContractResponseGetDataUsingDataContractResult_QNAME, CompositeType.class, GetDataUsingDataContractResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientID", scope = CustomerLinkAccountRequest.class)
    public JAXBElement<String> createCustomerLinkAccountRequestClientID(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientID_QNAME, String.class, CustomerLinkAccountRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "referenceNo", scope = CustomerLinkAccountRequest.class)
    public JAXBElement<String> createCustomerLinkAccountRequestReferenceNo(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestReferenceNo_QNAME, String.class, CustomerLinkAccountRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "mobileNo", scope = CustomerLinkAccountRequest.class)
    public JAXBElement<String> createCustomerLinkAccountRequestMobileNo(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestMobileNo_QNAME, String.class, CustomerLinkAccountRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientPassword", scope = CustomerLinkAccountRequest.class)
    public JAXBElement<String> createCustomerLinkAccountRequestClientPassword(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientPassword_QNAME, String.class, CustomerLinkAccountRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetDataResult", scope = GetDataResponse.class)
    public JAXBElement<String> createGetDataResponseGetDataResult(String value) {
        return new JAXBElement<String>(_GetDataResponseGetDataResult_QNAME, String.class, GetDataResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "accountMinistatementResult", scope = AccountMinistatementResponse.class)
    public JAXBElement<String> createAccountMinistatementResponseAccountMinistatementResult(String value) {
        return new JAXBElement<String>(_AccountMinistatementResponseAccountMinistatementResult_QNAME, String.class, AccountMinistatementResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "fundTransferAccountCreditResult", scope = FundTransferAccountCreditResponse.class)
    public JAXBElement<String> createFundTransferAccountCreditResponseFundTransferAccountCreditResult(String value) {
        return new JAXBElement<String>(_FundTransferAccountCreditResponseFundTransferAccountCreditResult_QNAME, String.class, FundTransferAccountCreditResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientID", scope = GetBankList.class)
    public JAXBElement<String> createGetBankListClientID(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientID_QNAME, String.class, GetBankList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "referenceNo", scope = GetBankList.class)
    public JAXBElement<String> createGetBankListReferenceNo(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestReferenceNo_QNAME, String.class, GetBankList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientPassword", scope = GetBankList.class)
    public JAXBElement<String> createGetBankListClientPassword(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientPassword_QNAME, String.class, GetBankList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "fundTransferReversalResult", scope = FundTransferReversalResponse.class)
    public JAXBElement<String> createFundTransferReversalResponseFundTransferReversalResult(String value) {
        return new JAXBElement<String>(_FundTransferReversalResponseFundTransferReversalResult_QNAME, String.class, FundTransferReversalResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientID", scope = FundTransferAccountDebit.class)
    public JAXBElement<String> createFundTransferAccountDebitClientID(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientID_QNAME, String.class, FundTransferAccountDebit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "transactionFee", scope = FundTransferAccountDebit.class)
    public JAXBElement<String> createFundTransferAccountDebitTransactionFee(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitTransactionFee_QNAME, String.class, FundTransferAccountDebit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "accountNo", scope = FundTransferAccountDebit.class)
    public JAXBElement<String> createFundTransferAccountDebitAccountNo(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitAccountNo_QNAME, String.class, FundTransferAccountDebit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "narration", scope = FundTransferAccountDebit.class)
    public JAXBElement<String> createFundTransferAccountDebitNarration(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitNarration_QNAME, String.class, FundTransferAccountDebit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "transactionAmount", scope = FundTransferAccountDebit.class)
    public JAXBElement<String> createFundTransferAccountDebitTransactionAmount(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitTransactionAmount_QNAME, String.class, FundTransferAccountDebit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "bin", scope = FundTransferAccountDebit.class)
    public JAXBElement<String> createFundTransferAccountDebitBin(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitBin_QNAME, String.class, FundTransferAccountDebit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "referenceNo", scope = FundTransferAccountDebit.class)
    public JAXBElement<String> createFundTransferAccountDebitReferenceNo(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestReferenceNo_QNAME, String.class, FundTransferAccountDebit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "authorizationKey", scope = FundTransferAccountDebit.class)
    public JAXBElement<String> createFundTransferAccountDebitAuthorizationKey(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitAuthorizationKey_QNAME, String.class, FundTransferAccountDebit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientPassword", scope = FundTransferAccountDebit.class)
    public JAXBElement<String> createFundTransferAccountDebitClientPassword(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientPassword_QNAME, String.class, FundTransferAccountDebit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientID", scope = FundTransferAccountCredit.class)
    public JAXBElement<String> createFundTransferAccountCreditClientID(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientID_QNAME, String.class, FundTransferAccountCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "transactionFee", scope = FundTransferAccountCredit.class)
    public JAXBElement<String> createFundTransferAccountCreditTransactionFee(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitTransactionFee_QNAME, String.class, FundTransferAccountCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "accountNo", scope = FundTransferAccountCredit.class)
    public JAXBElement<String> createFundTransferAccountCreditAccountNo(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitAccountNo_QNAME, String.class, FundTransferAccountCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "narration", scope = FundTransferAccountCredit.class)
    public JAXBElement<String> createFundTransferAccountCreditNarration(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitNarration_QNAME, String.class, FundTransferAccountCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "transactionAmount", scope = FundTransferAccountCredit.class)
    public JAXBElement<String> createFundTransferAccountCreditTransactionAmount(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitTransactionAmount_QNAME, String.class, FundTransferAccountCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "bin", scope = FundTransferAccountCredit.class)
    public JAXBElement<String> createFundTransferAccountCreditBin(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitBin_QNAME, String.class, FundTransferAccountCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "referenceNo", scope = FundTransferAccountCredit.class)
    public JAXBElement<String> createFundTransferAccountCreditReferenceNo(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestReferenceNo_QNAME, String.class, FundTransferAccountCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "authorizationKey", scope = FundTransferAccountCredit.class)
    public JAXBElement<String> createFundTransferAccountCreditAuthorizationKey(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitAuthorizationKey_QNAME, String.class, FundTransferAccountCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientPassword", scope = FundTransferAccountCredit.class)
    public JAXBElement<String> createFundTransferAccountCreditClientPassword(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientPassword_QNAME, String.class, FundTransferAccountCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientID", scope = FundTransferReversal.class)
    public JAXBElement<String> createFundTransferReversalClientID(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientID_QNAME, String.class, FundTransferReversal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "referenceNo", scope = FundTransferReversal.class)
    public JAXBElement<String> createFundTransferReversalReferenceNo(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestReferenceNo_QNAME, String.class, FundTransferReversal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "authorizationKey", scope = FundTransferReversal.class)
    public JAXBElement<String> createFundTransferReversalAuthorizationKey(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitAuthorizationKey_QNAME, String.class, FundTransferReversal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientPassword", scope = FundTransferReversal.class)
    public JAXBElement<String> createFundTransferReversalClientPassword(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientPassword_QNAME, String.class, FundTransferReversal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientID", scope = TransactionStatus.class)
    public JAXBElement<String> createTransactionStatusClientID(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientID_QNAME, String.class, TransactionStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "referenceNo", scope = TransactionStatus.class)
    public JAXBElement<String> createTransactionStatusReferenceNo(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestReferenceNo_QNAME, String.class, TransactionStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientPassword", scope = TransactionStatus.class)
    public JAXBElement<String> createTransactionStatusClientPassword(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientPassword_QNAME, String.class, TransactionStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientID", scope = AccountMinistatement.class)
    public JAXBElement<String> createAccountMinistatementClientID(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientID_QNAME, String.class, AccountMinistatement.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "accountNo", scope = AccountMinistatement.class)
    public JAXBElement<String> createAccountMinistatementAccountNo(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitAccountNo_QNAME, String.class, AccountMinistatement.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "bin", scope = AccountMinistatement.class)
    public JAXBElement<String> createAccountMinistatementBin(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitBin_QNAME, String.class, AccountMinistatement.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "referenceNo", scope = AccountMinistatement.class)
    public JAXBElement<String> createAccountMinistatementReferenceNo(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestReferenceNo_QNAME, String.class, AccountMinistatement.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientPassword", scope = AccountMinistatement.class)
    public JAXBElement<String> createAccountMinistatementClientPassword(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientPassword_QNAME, String.class, AccountMinistatement.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "composite", scope = GetDataUsingDataContract.class)
    public JAXBElement<CompositeType> createGetDataUsingDataContractComposite(CompositeType value) {
        return new JAXBElement<CompositeType>(_GetDataUsingDataContractComposite_QNAME, CompositeType.class, GetDataUsingDataContract.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientID", scope = AccountQuery.class)
    public JAXBElement<String> createAccountQueryClientID(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientID_QNAME, String.class, AccountQuery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "accountNo", scope = AccountQuery.class)
    public JAXBElement<String> createAccountQueryAccountNo(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitAccountNo_QNAME, String.class, AccountQuery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "bin", scope = AccountQuery.class)
    public JAXBElement<String> createAccountQueryBin(String value) {
        return new JAXBElement<String>(_FundTransferAccountDebitBin_QNAME, String.class, AccountQuery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "referenceNo", scope = AccountQuery.class)
    public JAXBElement<String> createAccountQueryReferenceNo(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestReferenceNo_QNAME, String.class, AccountQuery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "clientPassword", scope = AccountQuery.class)
    public JAXBElement<String> createAccountQueryClientPassword(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestClientPassword_QNAME, String.class, AccountQuery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "accountQueryResult", scope = AccountQueryResponse.class)
    public JAXBElement<String> createAccountQueryResponseAccountQueryResult(String value) {
        return new JAXBElement<String>(_AccountQueryResponseAccountQueryResult_QNAME, String.class, AccountQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "getBankListResult", scope = GetBankListResponse.class)
    public JAXBElement<String> createGetBankListResponseGetBankListResult(String value) {
        return new JAXBElement<String>(_GetBankListResponseGetBankListResult_QNAME, String.class, GetBankListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CustomerLinkAccountRequestResult", scope = CustomerLinkAccountRequestResponse.class)
    public JAXBElement<String> createCustomerLinkAccountRequestResponseCustomerLinkAccountRequestResult(String value) {
        return new JAXBElement<String>(_CustomerLinkAccountRequestResponseCustomerLinkAccountRequestResult_QNAME, String.class, CustomerLinkAccountRequestResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "transactionStatusResult", scope = TransactionStatusResponse.class)
    public JAXBElement<String> createTransactionStatusResponseTransactionStatusResult(String value) {
        return new JAXBElement<String>(_TransactionStatusResponseTransactionStatusResult_QNAME, String.class, TransactionStatusResponse.class, value);
    }

}
