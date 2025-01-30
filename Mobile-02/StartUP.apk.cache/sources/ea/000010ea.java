package com.coinbase.resources.transactions;

/* loaded from: classes.dex */
public class SendMoneyRequest extends TransactionRequest {
    private String description;
    private String fee;
    private String financialInstitutionWebsite;
    private String idem;
    private Boolean skipNotifications;
    private Boolean toFinancialInstitution;

    public SendMoneyRequest(String str, String str2, String str3) {
        super("send", str, str2, str3);
    }

    public String getDescription() {
        return this.description;
    }

    public String getFee() {
        return this.fee;
    }

    public String getFinancialInstitutionWebsite() {
        return this.financialInstitutionWebsite;
    }

    public String getIdem() {
        return this.idem;
    }

    public Boolean getSkipNotifications() {
        return this.skipNotifications;
    }

    public Boolean getToFinancialInstitution() {
        return this.toFinancialInstitution;
    }

    public SendMoneyRequest setDescription(String str) {
        this.description = str;
        return this;
    }

    public SendMoneyRequest setFee(String str) {
        this.fee = str;
        return this;
    }

    public SendMoneyRequest setFinancialInstitutionWebsite(String str) {
        this.financialInstitutionWebsite = str;
        return this;
    }

    public SendMoneyRequest setIdem(String str) {
        this.idem = str;
        return this;
    }

    public SendMoneyRequest setSkipNotifications(Boolean bool) {
        this.skipNotifications = bool;
        return this;
    }

    public SendMoneyRequest setToFinancialInstitution(Boolean bool) {
        this.toFinancialInstitution = bool;
        return this;
    }
}