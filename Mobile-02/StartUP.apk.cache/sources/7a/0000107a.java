package com.coinbase.errors;

import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public class CoinbaseException extends IOException {
    private List<Error> errors;

    public CoinbaseException(List<Error> list) {
        this.errors = list;
    }

    public Error getServerError() {
        if (this.errors.isEmpty()) {
            return null;
        }
        return this.errors.get(0);
    }

    public List<Error> getServerErrors() {
        return this.errors;
    }
}