package com.coinbase.resources.users;

import java.util.Date;

/* loaded from: classes.dex */
public class AuthUser extends User {
    private String bitcoinUnit;
    private Country country;
    private Date createdAt;
    private String email;
    private String nativeCurrency;
    private String timeZone;

    public String getBitcoinUnit() {
        return this.bitcoinUnit;
    }

    public Country getCountry() {
        return this.country;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNativeCurrency() {
        return this.nativeCurrency;
    }

    public String getTimeZone() {
        return this.timeZone;
    }
}