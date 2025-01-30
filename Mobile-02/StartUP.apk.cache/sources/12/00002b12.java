package com.coinbase.walletengine.services.xrp;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: XRPService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B*\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0019\u0010\f\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ>\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000bJ\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR%\u0010\u0010\u001a\u00020\t8\u0006@\u0007X\u0087\u0004ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u000e\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b!\u0010\u0004\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Lcom/coinbase/walletengine/services/xrp/SignedTransaction;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()[B", "component3", "Lkotlin/UInt;", "component4-pVg5ArA", "()I", "component4", "hash", "data", "txJSON", "maxLedgerVersion", "copy-hJeF8fQ", "(Ljava/lang/String;[BLjava/lang/String;I)Lcom/coinbase/walletengine/services/xrp/SignedTransaction;", "copy", "toString", "", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getMaxLedgerVersion-pVg5ArA", "[B", "getData", "Ljava/lang/String;", "getTxJSON", "getHash", "<init>", "(Ljava/lang/String;[BLjava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SignedTransaction {
    @Json(name = "data")
    private final byte[] data;
    @Json(name = "hash")
    private final String hash;
    @Json(name = "maxLedgerVersion")
    private final int maxLedgerVersion;
    @Json(name = "txJSON")
    private final String txJSON;

    private SignedTransaction(String str, byte[] bArr, String str2, int i2) {
        this.hash = str;
        this.data = bArr;
        this.txJSON = str2;
        this.maxLedgerVersion = i2;
    }

    public /* synthetic */ SignedTransaction(String str, byte[] bArr, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bArr, str2, i2);
    }

    /* renamed from: copy-hJeF8fQ$default  reason: not valid java name */
    public static /* synthetic */ SignedTransaction m2094copyhJeF8fQ$default(SignedTransaction signedTransaction, String str, byte[] bArr, String str2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = signedTransaction.hash;
        }
        if ((i3 & 2) != 0) {
            bArr = signedTransaction.data;
        }
        if ((i3 & 4) != 0) {
            str2 = signedTransaction.txJSON;
        }
        if ((i3 & 8) != 0) {
            i2 = signedTransaction.maxLedgerVersion;
        }
        return signedTransaction.m2096copyhJeF8fQ(str, bArr, str2, i2);
    }

    public final String component1() {
        return this.hash;
    }

    public final byte[] component2() {
        return this.data;
    }

    public final String component3() {
        return this.txJSON;
    }

    /* renamed from: component4-pVg5ArA  reason: not valid java name */
    public final int m2095component4pVg5ArA() {
        return this.maxLedgerVersion;
    }

    /* renamed from: copy-hJeF8fQ  reason: not valid java name */
    public final SignedTransaction m2096copyhJeF8fQ(String hash, byte[] data, String txJSON, int i2) {
        m.g(hash, "hash");
        m.g(data, "data");
        m.g(txJSON, "txJSON");
        return new SignedTransaction(hash, data, txJSON, i2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SignedTransaction) {
            SignedTransaction signedTransaction = (SignedTransaction) obj;
            return m.c(this.hash, signedTransaction.hash) && m.c(this.data, signedTransaction.data) && m.c(this.txJSON, signedTransaction.txJSON) && this.maxLedgerVersion == signedTransaction.maxLedgerVersion;
        }
        return false;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getHash() {
        return this.hash;
    }

    /* renamed from: getMaxLedgerVersion-pVg5ArA  reason: not valid java name */
    public final int m2097getMaxLedgerVersionpVg5ArA() {
        return this.maxLedgerVersion;
    }

    public final String getTxJSON() {
        return this.txJSON;
    }

    public int hashCode() {
        return (((((this.hash.hashCode() * 31) + Arrays.hashCode(this.data)) * 31) + this.txJSON.hashCode()) * 31) + UInt.z(this.maxLedgerVersion);
    }

    public String toString() {
        return "SignedTransaction(hash=" + this.hash + ", data=" + Arrays.toString(this.data) + ", txJSON=" + this.txJSON + ", maxLedgerVersion=" + ((Object) UInt.A(this.maxLedgerVersion)) + ')';
    }
}