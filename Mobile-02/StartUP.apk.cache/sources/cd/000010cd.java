package com.coinbase.resources.paymentmethods.models;

import com.coinbase.resources.accounts.Account;
import com.coinbase.resources.base.BaseResource;
import java.util.Date;

/* loaded from: classes.dex */
public class PaymentMethod extends BaseResource {
    public static final String TYPE_ACH_BANK_ACCOUNT = "ach_bank_account";
    public static final String TYPE_BANK_WIRE = "bank_wire";
    public static final String TYPE_CREDIT_CARD = "credit_card";
    public static final String TYPE_DEBIT_CARD = "debit_card";
    public static final String TYPE_EFT_BANK_ACCOUNT = "eft_bank_account";
    public static final String TYPE_FIAT_ACCOUNT = "fiat_account";
    public static final String TYPE_IDEAL_BANK = "ideal_bank_account";
    public static final String TYPE_INTERAC = "interac";
    public static final String TYPE_SECURE_3D = "secure3d_card";
    public static final String TYPE_SEPA_BANK_ACCOUNT = "sepa_bank_account";
    private Boolean allowBuy;
    private Boolean allowDeposit;
    private Boolean allowSell;
    private Boolean allowWithdraw;
    private Date createdAt;
    private String currency;
    private Account fiatAccount;
    private Boolean instantBuy;
    private Boolean instantSell;
    private Limits limits;
    private String name;
    private Boolean primaryBuy;
    private Boolean primarySell;
    private String type;
    private Date updatedAt;
    private Boolean verified;

    /* loaded from: classes.dex */
    public enum ExpandField implements com.coinbase.resources.ExpandField {
        FIAT_ACCOUNT("fiat_account"),
        ALL("all");
        
        private String value;

        ExpandField(String str) {
            this.value = str;
        }

        @Override // com.coinbase.resources.ExpandField
        public String getCode() {
            return this.value;
        }
    }

    public Boolean getAllowBuy() {
        return this.allowBuy;
    }

    public Boolean getAllowDeposit() {
        return this.allowDeposit;
    }

    public Boolean getAllowSell() {
        return this.allowSell;
    }

    public Boolean getAllowWithdraw() {
        return this.allowWithdraw;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Account getFiatAccount() {
        return this.fiatAccount;
    }

    public Boolean getInstantBuy() {
        return this.instantBuy;
    }

    public Boolean getInstantSell() {
        return this.instantSell;
    }

    public Limits getLimits() {
        return this.limits;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getPrimaryBuy() {
        return this.primaryBuy;
    }

    public Boolean getPrimarySell() {
        return this.primarySell;
    }

    public String getType() {
        return this.type;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public Boolean getVerified() {
        return this.verified;
    }
}