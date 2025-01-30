package com.coinbase.resources.transactions.entities;

import com.coinbase.resources.base.DynamicResource;

/* loaded from: classes.dex */
public class CryptoAddress extends DynamicResource {
    private String address;
    private AddressInfo addressInfo;
    private String currency;

    public String getAddress() {
        return this.address;
    }

    public AddressInfo getAddressInfo() {
        return this.addressInfo;
    }

    public String getCurrency() {
        return this.currency;
    }
}