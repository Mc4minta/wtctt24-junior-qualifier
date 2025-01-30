package com.coinbase.resources.accounts;

import com.coinbase.resources.base.DynamicResource;
import com.coinbase.resources.transactions.MoneyHash;
import java.util.Date;

/* loaded from: classes.dex */
public class Account extends DynamicResource {
    public static final String TYPE_FIAT = "fiat";
    public static final String TYPE_MULTISIG = "multisig";
    public static final String TYPE_MULTISIG_VAULT = "multisig_vault";
    public static final String TYPE_VAULT = "vault";
    public static final String TYPE_WALLET = "wallet";
    private MoneyHash balance;
    private Date createdAt;
    private Currency currency;
    private String name;
    private Boolean primary;
    private String type;
    private Date updatedAt;

    public MoneyHash getBalance() {
        return this.balance;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getPrimary() {
        return this.primary;
    }

    public String getType() {
        return this.type;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }
}