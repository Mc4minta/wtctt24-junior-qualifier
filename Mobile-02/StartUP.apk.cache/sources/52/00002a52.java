package com.coinbase.walletengine.services.bitcoincash;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BitcoinCashService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\tø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R'\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u000b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Lcom/coinbase/walletengine/services/bitcoincash/TransactionResult;", "", "Lcom/coinbase/walletengine/services/bitcoincash/TransactionStatus;", "component1", "()Lcom/coinbase/walletengine/services/bitcoincash/TransactionStatus;", "Lkotlin/UInt;", "component2-0hXNFcg", "()Lkotlin/UInt;", "component2", "", "component3", "()Ljava/lang/String;", "status", "blockNumber", "blockHash", "copy-SLwFa_Y", "(Lcom/coinbase/walletengine/services/bitcoincash/TransactionStatus;Lkotlin/UInt;Ljava/lang/String;)Lcom/coinbase/walletengine/services/bitcoincash/TransactionResult;", "copy", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/UInt;", "getBlockNumber-0hXNFcg", "Lcom/coinbase/walletengine/services/bitcoincash/TransactionStatus;", "getStatus", "Ljava/lang/String;", "getBlockHash", "<init>", "(Lcom/coinbase/walletengine/services/bitcoincash/TransactionStatus;Lkotlin/UInt;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TransactionResult {
    @Json(name = "blockHash")
    private final String blockHash;
    @Json(name = "blockNumber")
    private final UInt blockNumber;
    @Json(name = "status")
    private final TransactionStatus status;

    private TransactionResult(TransactionStatus transactionStatus, UInt uInt, String str) {
        this.status = transactionStatus;
        this.blockNumber = uInt;
        this.blockHash = str;
    }

    public /* synthetic */ TransactionResult(TransactionStatus transactionStatus, UInt uInt, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(transactionStatus, uInt, str);
    }

    /* renamed from: copy-SLwFa_Y$default  reason: not valid java name */
    public static /* synthetic */ TransactionResult m1965copySLwFa_Y$default(TransactionResult transactionResult, TransactionStatus transactionStatus, UInt uInt, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            transactionStatus = transactionResult.status;
        }
        if ((i2 & 2) != 0) {
            uInt = transactionResult.blockNumber;
        }
        if ((i2 & 4) != 0) {
            str = transactionResult.blockHash;
        }
        return transactionResult.m1967copySLwFa_Y(transactionStatus, uInt, str);
    }

    public final TransactionStatus component1() {
        return this.status;
    }

    /* renamed from: component2-0hXNFcg  reason: not valid java name */
    public final UInt m1966component20hXNFcg() {
        return this.blockNumber;
    }

    public final String component3() {
        return this.blockHash;
    }

    /* renamed from: copy-SLwFa_Y  reason: not valid java name */
    public final TransactionResult m1967copySLwFa_Y(TransactionStatus status, UInt uInt, String str) {
        kotlin.jvm.internal.m.g(status, "status");
        return new TransactionResult(status, uInt, str, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TransactionResult) {
            TransactionResult transactionResult = (TransactionResult) obj;
            return this.status == transactionResult.status && kotlin.jvm.internal.m.c(this.blockNumber, transactionResult.blockNumber) && kotlin.jvm.internal.m.c(this.blockHash, transactionResult.blockHash);
        }
        return false;
    }

    public final String getBlockHash() {
        return this.blockHash;
    }

    /* renamed from: getBlockNumber-0hXNFcg  reason: not valid java name */
    public final UInt m1968getBlockNumber0hXNFcg() {
        return this.blockNumber;
    }

    public final TransactionStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode = this.status.hashCode() * 31;
        UInt uInt = this.blockNumber;
        int z = (hashCode + (uInt == null ? 0 : UInt.z(uInt.B()))) * 31;
        String str = this.blockHash;
        return z + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "TransactionResult(status=" + this.status + ", blockNumber=" + this.blockNumber + ", blockHash=" + ((Object) this.blockHash) + ')';
    }
}