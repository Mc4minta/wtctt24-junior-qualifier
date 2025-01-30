package com.coinbase.walletengine.services.stellar;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: StellarService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R%\u0010\r\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u000b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Lcom/coinbase/walletengine/services/stellar/TransactionResult;", "", "", "component1", "()Z", "Lkotlin/UInt;", "component2-pVg5ArA", "()I", "component2", "Ljava/math/BigInteger;", "component3", "()Ljava/math/BigInteger;", "successful", "ledgerSequence", "feePaid", "copy-OsBMiQA", "(ZILjava/math/BigInteger;)Lcom/coinbase/walletengine/services/stellar/TransactionResult;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getSuccessful", "I", "getLedgerSequence-pVg5ArA", "Ljava/math/BigInteger;", "getFeePaid", "<init>", "(ZILjava/math/BigInteger;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TransactionResult {
    @Json(name = "feePaid")
    private final BigInteger feePaid;
    @Json(name = "ledgerSequence")
    private final int ledgerSequence;
    @Json(name = "successful")
    private final boolean successful;

    private TransactionResult(boolean z, int i2, BigInteger bigInteger) {
        this.successful = z;
        this.ledgerSequence = i2;
        this.feePaid = bigInteger;
    }

    public /* synthetic */ TransactionResult(boolean z, int i2, BigInteger bigInteger, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i2, bigInteger);
    }

    /* renamed from: copy-OsBMiQA$default  reason: not valid java name */
    public static /* synthetic */ TransactionResult m2084copyOsBMiQA$default(TransactionResult transactionResult, boolean z, int i2, BigInteger bigInteger, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = transactionResult.successful;
        }
        if ((i3 & 2) != 0) {
            i2 = transactionResult.ledgerSequence;
        }
        if ((i3 & 4) != 0) {
            bigInteger = transactionResult.feePaid;
        }
        return transactionResult.m2086copyOsBMiQA(z, i2, bigInteger);
    }

    public final boolean component1() {
        return this.successful;
    }

    /* renamed from: component2-pVg5ArA  reason: not valid java name */
    public final int m2085component2pVg5ArA() {
        return this.ledgerSequence;
    }

    public final BigInteger component3() {
        return this.feePaid;
    }

    /* renamed from: copy-OsBMiQA  reason: not valid java name */
    public final TransactionResult m2086copyOsBMiQA(boolean z, int i2, BigInteger feePaid) {
        m.g(feePaid, "feePaid");
        return new TransactionResult(z, i2, feePaid, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TransactionResult) {
            TransactionResult transactionResult = (TransactionResult) obj;
            return this.successful == transactionResult.successful && this.ledgerSequence == transactionResult.ledgerSequence && m.c(this.feePaid, transactionResult.feePaid);
        }
        return false;
    }

    public final BigInteger getFeePaid() {
        return this.feePaid;
    }

    /* renamed from: getLedgerSequence-pVg5ArA  reason: not valid java name */
    public final int m2087getLedgerSequencepVg5ArA() {
        return this.ledgerSequence;
    }

    public final boolean getSuccessful() {
        return this.successful;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.successful;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + UInt.z(this.ledgerSequence)) * 31) + this.feePaid.hashCode();
    }

    public String toString() {
        return "TransactionResult(successful=" + this.successful + ", ledgerSequence=" + ((Object) UInt.A(this.ledgerSequence)) + ", feePaid=" + this.feePaid + ')';
    }
}