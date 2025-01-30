package com.coinbase.wallet.ethereum.models;

import com.coinbase.wallet.core.extensions.Chars;
import com.coinbase.wallet.core.extensions.Chars_CoreKt;
import com.coinbase.wallet.ethereum.extensions.BigIntegers;
import com.coinbase.wallet.ethereum.extensions.BigIntegers_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.ETHABIEncoding;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.h;
import kotlin.j0.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlin.l0.y;

/* compiled from: ETHABIEncodedUInt256.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0011J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/ETHABIEncodedUInt256;", "Lcom/coinbase/wallet/ethereum/interfaces/ETHABIEncoding;", "", "encode", "()Ljava/lang/String;", "", "isDynamicLength", "Z", "()Z", "Ljava/math/BigInteger;", "value", "Ljava/math/BigInteger;", "getValue", "()Ljava/math/BigInteger;", "<init>", "(Ljava/math/BigInteger;)V", "", "(I)V", "Companion", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ETHABIEncodedUInt256 implements ETHABIEncoding {
    public static final Companion Companion = new Companion(null);
    private static final h<ETHABIEncodedUInt256> one$delegate;
    private static final h<ETHABIEncodedUInt256> zero$delegate;
    private final boolean isDynamicLength;
    private final BigInteger value;

    /* compiled from: ETHABIEncodedUInt256.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\n\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/ETHABIEncodedUInt256$Companion;", "", "Lcom/coinbase/wallet/ethereum/models/ETHABIEncodedUInt256;", "one$delegate", "Lkotlin/h;", "getOne", "()Lcom/coinbase/wallet/ethereum/models/ETHABIEncodedUInt256;", "one", "zero$delegate", "getZero", "zero", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(Companion.class), "zero", "getZero()Lcom/coinbase/wallet/ethereum/models/ETHABIEncodedUInt256;")), e0.h(new x(e0.b(Companion.class), "one", "getOne()Lcom/coinbase/wallet/ethereum/models/ETHABIEncodedUInt256;"))};

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ETHABIEncodedUInt256 getOne() {
            return (ETHABIEncodedUInt256) ETHABIEncodedUInt256.one$delegate.getValue();
        }

        public final ETHABIEncodedUInt256 getZero() {
            return (ETHABIEncodedUInt256) ETHABIEncodedUInt256.zero$delegate.getValue();
        }
    }

    static {
        h<ETHABIEncodedUInt256> b2;
        h<ETHABIEncodedUInt256> b3;
        b2 = k.b(ETHABIEncodedUInt256$Companion$zero$2.INSTANCE);
        zero$delegate = b2;
        b3 = k.b(ETHABIEncodedUInt256$Companion$one$2.INSTANCE);
        one$delegate = b3;
    }

    public ETHABIEncodedUInt256(BigInteger value) {
        kotlin.jvm.internal.m.g(value, "value");
        this.value = value;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.ETHABIEncoding
    public String encode() {
        String u0;
        if (this.value.compareTo(BigIntegers_EthereumKt.getUint256MaxValue(BigIntegers.INSTANCE)) > 0) {
            return null;
        }
        String stringValue = this.value.toString(16);
        kotlin.jvm.internal.m.f(stringValue, "stringValue");
        u0 = y.u0(stringValue, 64, Chars_CoreKt.getZero(Chars.INSTANCE));
        return u0;
    }

    public final BigInteger getValue() {
        return this.value;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.ETHABIEncoding
    public boolean isDynamicLength() {
        return this.isDynamicLength;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ETHABIEncodedUInt256(int r3) {
        /*
            r2 = this;
            long r0 = (long) r3
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r0)
            java.lang.String r0 = "valueOf(value.toLong())"
            kotlin.jvm.internal.m.f(r3, r0)
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.ethereum.models.ETHABIEncodedUInt256.<init>(int):void");
    }
}