package com.coinbase.walletengine.services.xrp;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: XRPService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\bø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\f\u0010\nJD\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR'\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0087\u0004ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\u0007R'\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0087\u0004ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b#\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Lcom/coinbase/walletengine/services/xrp/TransactionResult;", "", "Lcom/coinbase/walletengine/services/xrp/TransactionStatus;", "component1", "()Lcom/coinbase/walletengine/services/xrp/TransactionStatus;", "", "component2", "()Ljava/lang/String;", "Lkotlin/UInt;", "component3-0hXNFcg", "()Lkotlin/UInt;", "component3", "component4-0hXNFcg", "component4", "status", "resultCode", "ledgerVersion", "indexInLedger", "copy-1HOQnIw", "(Lcom/coinbase/walletengine/services/xrp/TransactionStatus;Ljava/lang/String;Lkotlin/UInt;Lkotlin/UInt;)Lcom/coinbase/walletengine/services/xrp/TransactionResult;", "copy", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/UInt;", "getIndexInLedger-0hXNFcg", "Lcom/coinbase/walletengine/services/xrp/TransactionStatus;", "getStatus", "Ljava/lang/String;", "getResultCode", "getLedgerVersion-0hXNFcg", "<init>", "(Lcom/coinbase/walletengine/services/xrp/TransactionStatus;Ljava/lang/String;Lkotlin/UInt;Lkotlin/UInt;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TransactionResult {
    @Json(name = "indexInLedger")
    private final UInt indexInLedger;
    @Json(name = "ledgerVersion")
    private final UInt ledgerVersion;
    @Json(name = "resultCode")
    private final String resultCode;
    @Json(name = "status")
    private final TransactionStatus status;

    private TransactionResult(TransactionStatus transactionStatus, String str, UInt uInt, UInt uInt2) {
        this.status = transactionStatus;
        this.resultCode = str;
        this.ledgerVersion = uInt;
        this.indexInLedger = uInt2;
    }

    public /* synthetic */ TransactionResult(TransactionStatus transactionStatus, String str, UInt uInt, UInt uInt2, DefaultConstructorMarker defaultConstructorMarker) {
        this(transactionStatus, str, uInt, uInt2);
    }

    /* renamed from: copy-1HOQnIw$default  reason: not valid java name */
    public static /* synthetic */ TransactionResult m2102copy1HOQnIw$default(TransactionResult transactionResult, TransactionStatus transactionStatus, String str, UInt uInt, UInt uInt2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            transactionStatus = transactionResult.status;
        }
        if ((i2 & 2) != 0) {
            str = transactionResult.resultCode;
        }
        if ((i2 & 4) != 0) {
            uInt = transactionResult.ledgerVersion;
        }
        if ((i2 & 8) != 0) {
            uInt2 = transactionResult.indexInLedger;
        }
        return transactionResult.m2105copy1HOQnIw(transactionStatus, str, uInt, uInt2);
    }

    public final TransactionStatus component1() {
        return this.status;
    }

    public final String component2() {
        return this.resultCode;
    }

    /* renamed from: component3-0hXNFcg  reason: not valid java name */
    public final UInt m2103component30hXNFcg() {
        return this.ledgerVersion;
    }

    /* renamed from: component4-0hXNFcg  reason: not valid java name */
    public final UInt m2104component40hXNFcg() {
        return this.indexInLedger;
    }

    /* renamed from: copy-1HOQnIw  reason: not valid java name */
    public final TransactionResult m2105copy1HOQnIw(TransactionStatus status, String str, UInt uInt, UInt uInt2) {
        m.g(status, "status");
        return new TransactionResult(status, str, uInt, uInt2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TransactionResult) {
            TransactionResult transactionResult = (TransactionResult) obj;
            return this.status == transactionResult.status && m.c(this.resultCode, transactionResult.resultCode) && m.c(this.ledgerVersion, transactionResult.ledgerVersion) && m.c(this.indexInLedger, transactionResult.indexInLedger);
        }
        return false;
    }

    /* renamed from: getIndexInLedger-0hXNFcg  reason: not valid java name */
    public final UInt m2106getIndexInLedger0hXNFcg() {
        return this.indexInLedger;
    }

    /* renamed from: getLedgerVersion-0hXNFcg  reason: not valid java name */
    public final UInt m2107getLedgerVersion0hXNFcg() {
        return this.ledgerVersion;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final TransactionStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode = this.status.hashCode() * 31;
        String str = this.resultCode;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        UInt uInt = this.ledgerVersion;
        int z = (hashCode2 + (uInt == null ? 0 : UInt.z(uInt.B()))) * 31;
        UInt uInt2 = this.indexInLedger;
        return z + (uInt2 != null ? UInt.z(uInt2.B()) : 0);
    }

    public String toString() {
        return "TransactionResult(status=" + this.status + ", resultCode=" + ((Object) this.resultCode) + ", ledgerVersion=" + this.ledgerVersion + ", indexInLedger=" + this.indexInLedger + ')';
    }
}