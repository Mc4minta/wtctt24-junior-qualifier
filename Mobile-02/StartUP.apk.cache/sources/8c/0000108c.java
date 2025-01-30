package com.coinbase.network;

/* loaded from: classes.dex */
public interface Callback<T> {
    void onFailure(Throwable th);

    void onSuccess(T t);
}