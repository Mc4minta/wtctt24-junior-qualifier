package com.coinbase.wallet.bip44wallets.models;

import java.math.BigInteger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: BIP44UTXO.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\t\u001a\u00020\u0006HÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJH\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\rHÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\bJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0013\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010\fR\u0019\u0010\u0014\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u000fR\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\bR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b'\u0010\u0004\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006*"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/models/BIP44UTXO;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lkotlin/UInt;", "component3-pVg5ArA", "()I", "component3", "Ljava/math/BigInteger;", "component4", "()Ljava/math/BigInteger;", "", "component5", "()[B", "address", "hash", "index", "value", "script", "copy-k571xdo", "(Ljava/lang/String;Ljava/lang/String;ILjava/math/BigInteger;[B)Lcom/coinbase/wallet/bip44wallets/models/BIP44UTXO;", "copy", "toString", "", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/math/BigInteger;", "getValue", "[B", "getScript", "I", "getIndex-pVg5ArA", "Ljava/lang/String;", "getHash", "getAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/math/BigInteger;[BLkotlin/jvm/internal/DefaultConstructorMarker;)V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BIP44UTXO {
    private final String address;
    private final String hash;
    private final int index;
    private final byte[] script;
    private final BigInteger value;

    private BIP44UTXO(String str, String str2, int i2, BigInteger bigInteger, byte[] bArr) {
        this.address = str;
        this.hash = str2;
        this.index = i2;
        this.value = bigInteger;
        this.script = bArr;
    }

    public /* synthetic */ BIP44UTXO(String str, String str2, int i2, BigInteger bigInteger, byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i2, bigInteger, bArr);
    }

    /* renamed from: copy-k571xdo$default  reason: not valid java name */
    public static /* synthetic */ BIP44UTXO m761copyk571xdo$default(BIP44UTXO bip44utxo, String str, String str2, int i2, BigInteger bigInteger, byte[] bArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = bip44utxo.address;
        }
        if ((i3 & 2) != 0) {
            str2 = bip44utxo.hash;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            i2 = bip44utxo.index;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            bigInteger = bip44utxo.value;
        }
        BigInteger bigInteger2 = bigInteger;
        if ((i3 & 16) != 0) {
            bArr = bip44utxo.script;
        }
        return bip44utxo.m763copyk571xdo(str, str3, i4, bigInteger2, bArr);
    }

    public final String component1() {
        return this.address;
    }

    public final String component2() {
        return this.hash;
    }

    /* renamed from: component3-pVg5ArA  reason: not valid java name */
    public final int m762component3pVg5ArA() {
        return this.index;
    }

    public final BigInteger component4() {
        return this.value;
    }

    public final byte[] component5() {
        return this.script;
    }

    /* renamed from: copy-k571xdo  reason: not valid java name */
    public final BIP44UTXO m763copyk571xdo(String address, String hash, int i2, BigInteger value, byte[] script) {
        m.g(address, "address");
        m.g(hash, "hash");
        m.g(value, "value");
        m.g(script, "script");
        return new BIP44UTXO(address, hash, i2, value, script, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BIP44UTXO) {
            BIP44UTXO bip44utxo = (BIP44UTXO) obj;
            return m.c(this.address, bip44utxo.address) && m.c(this.hash, bip44utxo.hash) && this.index == bip44utxo.index && m.c(this.value, bip44utxo.value) && m.c(this.script, bip44utxo.script);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getHash() {
        return this.hash;
    }

    /* renamed from: getIndex-pVg5ArA  reason: not valid java name */
    public final int m764getIndexpVg5ArA() {
        return this.index;
    }

    public final byte[] getScript() {
        return this.script;
    }

    public final BigInteger getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((((this.address.hashCode() * 31) + this.hash.hashCode()) * 31) + UInt.z(this.index)) * 31) + this.value.hashCode()) * 31) + Arrays.hashCode(this.script);
    }

    public String toString() {
        return "BIP44UTXO(address=" + this.address + ", hash=" + this.hash + ", index=" + ((Object) UInt.A(this.index)) + ", value=" + this.value + ", script=" + Arrays.toString(this.script) + ')';
    }
}