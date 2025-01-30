package com.coinbase.resources.trades;

import com.coinbase.resources.base.BaseResource;
import com.coinbase.resources.paymentmethods.models.PaymentMethod;
import com.coinbase.resources.transactions.MoneyHash;
import com.coinbase.resources.transactions.Transaction;
import java.util.Date;

/* loaded from: classes.dex */
public abstract class Trade extends BaseResource {
    public static final String STATUS_CANCELED = "canceled";
    public static final String STATUS_COMPLETED = "completed";
    public static final String STATUS_CREATED = "created";
    private MoneyHash amount;
    private Boolean committed;
    private Date createdAt;
    private MoneyHash fee;
    private PaymentMethod paymentMethod;
    private Date payoutAt;
    private String status;
    private MoneyHash subtotal;
    private Transaction transaction;
    private Date updatedAt;
    private String userReference;

    /* loaded from: classes.dex */
    public enum ExpandField implements com.coinbase.resources.ExpandField {
        ALL("all"),
        TRANSACTION("transaction"),
        PAYMENT_METHOD("payment_method");
        
        private final String code;

        ExpandField(String str) {
            this.code = str;
        }

        @Override // com.coinbase.resources.ExpandField
        public String getCode() {
            return this.code;
        }
    }

    public MoneyHash getAmount() {
        return this.amount;
    }

    public Boolean getCommitted() {
        return this.committed;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public MoneyHash getFee() {
        return this.fee;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public Date getPayoutAt() {
        return this.payoutAt;
    }

    public String getStatus() {
        return this.status;
    }

    public MoneyHash getSubtotal() {
        return this.subtotal;
    }

    public Transaction getTransaction() {
        return this.transaction;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public String getUserReference() {
        return this.userReference;
    }
}