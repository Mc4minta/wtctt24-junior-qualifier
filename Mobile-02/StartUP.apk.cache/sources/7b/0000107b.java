package com.coinbase.errors;

import java.io.IOException;

/* loaded from: classes.dex */
public class CoinbaseOAuthException extends IOException {
    private final OAuthError oAuthError;

    public CoinbaseOAuthException(OAuthError oAuthError) {
        this.oAuthError = oAuthError;
    }

    public OAuthError getoAuthError() {
        return this.oAuthError;
    }
}