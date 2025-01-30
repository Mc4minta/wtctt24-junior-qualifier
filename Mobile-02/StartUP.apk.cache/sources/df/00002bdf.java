package com.coinbase.walletlink.models;

import kotlin.Metadata;

/* compiled from: ClientMetadataKey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/walletlink/models/ClientMetadataKey;", "", "", "rawValue", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "EthereumAddress", "WalletUsername", "Destroyed", "ChainId", "JsonRpcUrl", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public enum ClientMetadataKey {
    EthereumAddress("EthereumAddress"),
    WalletUsername("WalletUsername"),
    Destroyed("__destroyed"),
    ChainId("ChainId"),
    JsonRpcUrl("JsonRpcUrl");
    
    private final String rawValue;

    ClientMetadataKey(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}