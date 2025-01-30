package com.coinbase.wallet.bip44wallets.models;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BIP44SignedData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/models/BIP44SignedData;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()[B", "hash", "data", "copy", "(Ljava/lang/String;[B)Lcom/coinbase/wallet/bip44wallets/models/BIP44SignedData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "[B", "getData", "Ljava/lang/String;", "getHash", "<init>", "(Ljava/lang/String;[B)V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BIP44SignedData {
    private final byte[] data;
    private final String hash;

    public BIP44SignedData(String hash, byte[] data) {
        m.g(hash, "hash");
        m.g(data, "data");
        this.hash = hash;
        this.data = data;
    }

    public static /* synthetic */ BIP44SignedData copy$default(BIP44SignedData bIP44SignedData, String str, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bIP44SignedData.hash;
        }
        if ((i2 & 2) != 0) {
            bArr = bIP44SignedData.data;
        }
        return bIP44SignedData.copy(str, bArr);
    }

    public final String component1() {
        return this.hash;
    }

    public final byte[] component2() {
        return this.data;
    }

    public final BIP44SignedData copy(String hash, byte[] data) {
        m.g(hash, "hash");
        m.g(data, "data");
        return new BIP44SignedData(hash, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BIP44SignedData) {
            BIP44SignedData bIP44SignedData = (BIP44SignedData) obj;
            return m.c(this.hash, bIP44SignedData.hash) && m.c(this.data, bIP44SignedData.data);
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
        return "BIP44SignedData(hash=" + this.hash + ", data=" + Arrays.toString(this.data) + ')';
    }
}