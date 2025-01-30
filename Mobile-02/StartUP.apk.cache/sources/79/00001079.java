package com.coinbase.errors;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CoinbaseErrorResponse {
    private List<Error> errors = new ArrayList();

    public List<Error> getErrors() {
        return this.errors;
    }
}