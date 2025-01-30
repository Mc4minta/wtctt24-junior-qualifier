package com.coinbase.walletlink.models;

import kotlin.Metadata;

/* compiled from: EventType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/walletlink/models/EventType;", "", "", "rawValue", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Web3Request", "Web3Response", "Web3RequestCanceled", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public enum EventType {
    Web3Request("Web3Request"),
    Web3Response("Web3Response"),
    Web3RequestCanceled("Web3RequestCanceled");
    
    private final String rawValue;

    EventType(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}