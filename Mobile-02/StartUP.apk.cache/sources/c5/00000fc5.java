package com.coinbase.ciphercore;

import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: types.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/coinbase/ciphercore/KeyPair;", "", "", "component1", "()[B", "component2", "privateKey", "publicKey", "copy", "([B[B)Lcom/coinbase/ciphercore/KeyPair;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "[B", "getPublicKey", "getPrivateKey", "<init>", "([B[B)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class KeyPair {
    private final byte[] privateKey;
    private final byte[] publicKey;

    public KeyPair(byte[] privateKey, byte[] publicKey) {
        kotlin.jvm.internal.m.g(privateKey, "privateKey");
        kotlin.jvm.internal.m.g(publicKey, "publicKey");
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public static /* synthetic */ KeyPair copy$default(KeyPair keyPair, byte[] bArr, byte[] bArr2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bArr = keyPair.privateKey;
        }
        if ((i2 & 2) != 0) {
            bArr2 = keyPair.publicKey;
        }
        return keyPair.copy(bArr, bArr2);
    }

    public final byte[] component1() {
        return this.privateKey;
    }

    public final byte[] component2() {
        return this.publicKey;
    }

    public final KeyPair copy(byte[] privateKey, byte[] publicKey) {
        kotlin.jvm.internal.m.g(privateKey, "privateKey");
        kotlin.jvm.internal.m.g(publicKey, "publicKey");
        return new KeyPair(privateKey, publicKey);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KeyPair) {
            KeyPair keyPair = (KeyPair) obj;
            return kotlin.jvm.internal.m.c(this.privateKey, keyPair.privateKey) && kotlin.jvm.internal.m.c(this.publicKey, keyPair.publicKey);
        }
        return false;
    }

    public final byte[] getPrivateKey() {
        return this.privateKey;
    }

    public final byte[] getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.privateKey) * 31) + Arrays.hashCode(this.publicKey);
    }

    public String toString() {
        return "KeyPair(privateKey=" + Arrays.toString(this.privateKey) + ", publicKey=" + Arrays.toString(this.publicKey) + ')';
    }
}