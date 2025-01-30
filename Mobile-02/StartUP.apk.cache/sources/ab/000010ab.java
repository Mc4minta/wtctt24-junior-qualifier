package com.coinbase.resources.addresses;

import com.coinbase.resources.base.BaseResource;
import com.coinbase.resources.transactions.entities.AddressInfo;
import java.util.Date;

/* loaded from: classes.dex */
public class Address extends BaseResource {
    private String address;
    private AddressInfo addressInfo;
    private String callbackUrl;
    private Date createdAt;
    private String legacyAddress;
    private String name;
    private String network;
    private Date updatedAt;
    private String uriScheme;
    private String warningDetails;
    private String warningTitle;

    public String getAddress() {
        return this.address;
    }

    public AddressInfo getAddressInfo() {
        return this.addressInfo;
    }

    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getLegacyAddress() {
        return this.legacyAddress;
    }

    public String getName() {
        return this.name;
    }

    public String getNetwork() {
        return this.network;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public String getUriScheme() {
        return this.uriScheme;
    }

    public String getWarningDetails() {
        return this.warningDetails;
    }

    public String getWarningTitle() {
        return this.warningTitle;
    }
}