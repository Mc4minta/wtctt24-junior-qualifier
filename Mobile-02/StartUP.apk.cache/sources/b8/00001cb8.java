package com.coinbase.wallet.ethereum.models;

import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: ETHABIEncodedUInt256.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/ETHABIEncodedUInt256;", "<anonymous>", "()Lcom/coinbase/wallet/ethereum/models/ETHABIEncodedUInt256;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ETHABIEncodedUInt256$Companion$zero$2 extends o implements a<ETHABIEncodedUInt256> {
    public static final ETHABIEncodedUInt256$Companion$zero$2 INSTANCE = new ETHABIEncodedUInt256$Companion$zero$2();

    ETHABIEncodedUInt256$Companion$zero$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final ETHABIEncodedUInt256 invoke() {
        BigInteger ZERO = BigInteger.ZERO;
        m.f(ZERO, "ZERO");
        return new ETHABIEncodedUInt256(ZERO);
    }
}