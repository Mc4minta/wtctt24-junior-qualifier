package com.coinbase;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/* loaded from: classes.dex */
public final class AuthorizationRequest {
    static final String ARG_ACCOUNT = "account";
    static final String ARG_ACCOUNT_CURRENCY = "account_currency";
    static final String ARG_CLIENT_ID = "client_id";
    static final String ARG_LAYOUT = "layout";
    static final String ARG_REDIRECT_URI = "redirect_uri";
    static final String ARG_REFERRAL = "referral";
    static final String ARG_RESPONSE_TYPE = "response_type";
    static final String ARG_SCOPE = "scope";
    static final String LAYOUT_SIGNUP = "signup";
    static final String META_NAME = "meta[name]";
    static final String META_SEND_LIMIT_AMOUNT = "meta[send_limit_amount]";
    static final String META_SEND_LIMIT_CURRENCY = "meta[send_limit_currency]";
    static final String META_SEND_LIMIT_PERIOD = "meta[send_limit_period]";
    private AccountSetting account;
    private String accountCurrency;
    private String metaName;
    private final Uri redirectUri;
    private String referralId;
    private final String scope;
    private String sendLimitAmount;
    private String sendLimitCurrency;
    private LimitPeriod sendLimitPeriod;
    private boolean showSignUp = false;

    /* loaded from: classes.dex */
    public enum AccountSetting {
        SELECT("select"),
        ALL("all");
        
        String value;

        AccountSetting(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public enum LimitPeriod {
        DAY("day"),
        MONTH("month"),
        YEAR("year");
        
        String value;

        LimitPeriod(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    public AuthorizationRequest(Uri uri, String... strArr) {
        if (((String[]) throwIfNull(strArr, "scopes array")).length != 0) {
            this.redirectUri = (Uri) throwIfNull(uri, "redirectUri");
            this.scope = (String) throwIfNull(TextUtils.join(",", strArr), "scopes");
            return;
        }
        throw new IllegalArgumentException("Scopes can not be empty");
    }

    private <T> void appendIfNotNull(Uri.Builder builder, String str, T t) {
        if (t != null) {
            builder.appendQueryParameter(str, t.toString());
        }
    }

    private <T> T throwIfNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str + " == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uri getAuthorizationUri(URL url, String str) {
        try {
            Uri.Builder appendQueryParameter = Uri.parse(new URL(url, ApiConstants.AUTHORIZE).toURI().toString()).buildUpon().appendQueryParameter(ARG_RESPONSE_TYPE, "code").appendQueryParameter("client_id", str).appendQueryParameter(ARG_REDIRECT_URI, this.redirectUri.toString()).appendQueryParameter(ARG_SCOPE, this.scope);
            if (this.showSignUp) {
                appendQueryParameter.appendQueryParameter(ARG_LAYOUT, LAYOUT_SIGNUP);
            }
            appendIfNotNull(appendQueryParameter, ARG_ACCOUNT, this.account);
            appendIfNotNull(appendQueryParameter, ARG_ACCOUNT_CURRENCY, this.accountCurrency);
            appendIfNotNull(appendQueryParameter, ARG_REFERRAL, this.referralId);
            appendIfNotNull(appendQueryParameter, META_NAME, this.metaName);
            appendIfNotNull(appendQueryParameter, META_SEND_LIMIT_AMOUNT, this.sendLimitAmount);
            appendIfNotNull(appendQueryParameter, META_SEND_LIMIT_CURRENCY, this.sendLimitCurrency);
            appendIfNotNull(appendQueryParameter, META_SEND_LIMIT_PERIOD, this.sendLimitPeriod);
            return appendQueryParameter.build();
        } catch (MalformedURLException | URISyntaxException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public AuthorizationRequest setAccount(AccountSetting accountSetting) {
        this.account = accountSetting;
        return this;
    }

    public AuthorizationRequest setAccountCurrency(String str) {
        this.accountCurrency = str;
        return this;
    }

    public AuthorizationRequest setMetaName(String str) {
        this.metaName = str;
        return this;
    }

    public AuthorizationRequest setMetaSendLimitAmount(String str) {
        this.sendLimitAmount = str;
        return this;
    }

    public AuthorizationRequest setMetaSendLimitCurrency(String str) {
        this.sendLimitCurrency = str;
        return this;
    }

    public AuthorizationRequest setMetaSendLimitPeriod(LimitPeriod limitPeriod) {
        this.sendLimitPeriod = limitPeriod;
        return this;
    }

    public AuthorizationRequest setReferralId(String str) {
        this.referralId = str;
        return this;
    }

    public AuthorizationRequest setShowSignUpPage(boolean z) {
        this.showSignUp = z;
        return this;
    }
}