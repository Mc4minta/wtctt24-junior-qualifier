package com.coinbase.wallet.ethereum.models;

import com.coinbase.wallet.core.extensions.Chars;
import com.coinbase.wallet.core.extensions.Chars_CoreKt;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.ethereum.interfaces.ETHABIEncoding;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.y;

/* compiled from: ETHABIEncodedAddress.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/ETHABIEncodedAddress;", "Lcom/coinbase/wallet/ethereum/interfaces/ETHABIEncoding;", "", "encode", "()Ljava/lang/String;", "", "isDynamicLength", "Z", "()Z", "value", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ETHABIEncodedAddress implements ETHABIEncoding {
    private final boolean isDynamicLength;
    private final String value;

    public ETHABIEncodedAddress(String value) {
        m.g(value, "value");
        this.value = value;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.ETHABIEncoding
    public String encode() {
        String u0;
        u0 = y.u0(String_CoreKt.strip0x(this.value), 64, Chars_CoreKt.getZero(Chars.INSTANCE));
        return u0;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.ETHABIEncoding
    public boolean isDynamicLength() {
        return this.isDynamicLength;
    }
}