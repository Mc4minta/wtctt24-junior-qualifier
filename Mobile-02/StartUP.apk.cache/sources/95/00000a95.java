package com.coinbase;

import com.coinbase.errors.Error;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CoinbaseResponse<T> {
    private T data;
    private List<Error> warnings = new ArrayList();

    public T getData() {
        return this.data;
    }

    public List<Error> getWarnings() {
        return this.warnings;
    }
}