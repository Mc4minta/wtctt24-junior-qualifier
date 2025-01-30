package com.coinbase.resources.transactions;

import com.coinbase.ApiConstants;
import com.coinbase.resources.addresses.Address;
import com.coinbase.resources.base.BaseResource;
import com.coinbase.resources.base.DynamicResource;
import com.coinbase.resources.buys.Buy;
import com.coinbase.resources.sells.Sell;
import java.util.Date;

/* loaded from: classes.dex */
public class Transaction extends BaseResource {
    public static final String STATUS_CANCELED = "canceled";
    public static final String STATUS_COMPLETED = "completed";
    public static final String STATUS_EXPIRED = "expired";
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_WAITING_FOR_CLEARING = "waiting_for_clearing";
    public static final String STATUS_WAITING_FOR_SIGNATURE = "waiting_for_signature";
    public static final String TYPE_BUY = "buy";
    public static final String TYPE_EXCHANGE_DEPOSIT = "exchange_deposit";
    public static final String TYPE_EXCHANGE_WITHDRAWAL = "exchange_withdrawal";
    public static final String TYPE_FIAT_DEPOSIT = "fiat_deposit";
    public static final String TYPE_FIAT_WITHDRAWAL = "fiat_withdrawal";
    public static final String TYPE_REQUEST = "request";
    public static final String TYPE_SELL = "sell";
    public static final String TYPE_SEND = "send";
    public static final String TYPE_TRANSFER = "transfer";
    public static final String TYPE_VAULT_WITHDRAWAL = "vault_withdrawal";
    private Address address;
    private MoneyHash amount;
    private Application application;
    private Buy buy;
    private Date createdAt;
    private String description;
    private Details details;
    private DynamicResource from;
    private String idem;
    private Boolean instantExchange;
    private MoneyHash nativeAmount;
    private Network network;
    private Sell sell;
    private String status;
    private DynamicResource to;
    private String type;
    private Date updatedAt;

    /* loaded from: classes.dex */
    public static class Details {
        private String paymentMethodName;
        private String subtitle;
        private String title;

        public String getPaymentMethodName() {
            return this.paymentMethodName;
        }

        public String getSubtitle() {
            return this.subtitle;
        }

        public String getTitle() {
            return this.title;
        }
    }

    /* loaded from: classes.dex */
    public enum ExpandField implements com.coinbase.resources.ExpandField {
        FROM(ApiConstants.FROM),
        TO(ApiConstants.TO),
        BUY("buy"),
        SELL("sell"),
        APPLICATION("application"),
        ALL("all");
        
        private final String value;

        ExpandField(String str) {
            this.value = str;
        }

        @Override // com.coinbase.resources.ExpandField
        public String getCode() {
            return this.value;
        }
    }

    public Address getAddress() {
        return this.address;
    }

    public MoneyHash getAmount() {
        return this.amount;
    }

    public Application getApplication() {
        return this.application;
    }

    public Buy getBuy() {
        return this.buy;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getDescription() {
        return this.description;
    }

    public Details getDetails() {
        return this.details;
    }

    public DynamicResource getFrom() {
        return this.from;
    }

    public String getIdem() {
        return this.idem;
    }

    public Boolean getInstantExchange() {
        return this.instantExchange;
    }

    public MoneyHash getNativeAmount() {
        return this.nativeAmount;
    }

    public Network getNetwork() {
        return this.network;
    }

    public Sell getSell() {
        return this.sell;
    }

    public String getStatus() {
        return this.status;
    }

    public DynamicResource getTo() {
        return this.to;
    }

    public String getType() {
        return this.type;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }
}