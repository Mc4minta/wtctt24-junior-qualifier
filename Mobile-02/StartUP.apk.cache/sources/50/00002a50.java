package com.coinbase.walletengine.services.bitcoincash;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: BitcoinCashService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/walletengine/services/bitcoincash/SignedTransaction;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()[B", "hash", "data", "copy", "(Ljava/lang/String;[B)Lcom/coinbase/walletengine/services/bitcoincash/SignedTransaction;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "[B", "getData", "Ljava/lang/String;", "getHash", "<init>", "(Ljava/lang/String;[B)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SignedTransaction {
    @Json(name = "data")
    private final byte[] data;
    @Json(name = "hash")
    private final String hash;

    public SignedTransaction(String hash, byte[] data) {
        kotlin.jvm.internal.m.g(hash, "hash");
        kotlin.jvm.internal.m.g(data, "data");
        this.hash = hash;
        this.data = data;
    }

    public static /* synthetic */ SignedTransaction copy$default(SignedTransaction signedTransaction, String str, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = signedTransaction.hash;
        }
        if ((i2 & 2) != 0) {
            bArr = signedTransaction.data;
        }
        return signedTransaction.copy(str, bArr);
    }

    public final String component1() {
        return this.hash;
    }

    public final byte[] component2() {
        return this.data;
    }

    public final SignedTransaction copy(String hash, byte[] data) {
        kotlin.jvm.internal.m.g(hash, "hash");
        kotlin.jvm.internal.m.g(data, "data");
        return new SignedTransaction(hash, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SignedTransaction) {
            SignedTransaction signedTransaction = (SignedTransaction) obj;
            return kotlin.jvm.internal.m.c(this.hash, signedTransaction.hash) && kotlin.jvm.internal.m.c(this.data, signedTransaction.data);
        }
        return false;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getHash() {
        return this.hash;
    }

    public int hashCode() {
        return (this.hash.hashCode() * 31) + Arrays.hashCode(this.data);
    }

    public String toString() {
        return "SignedTransaction(hash=" + this.hash + ", data=" + Arrays.toString(this.data) + ')';
    }
}