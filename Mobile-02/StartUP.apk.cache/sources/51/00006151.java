package org.spongycastle.crypto;

/* loaded from: classes3.dex */
public class CryptoException extends Exception {
    private Throwable cause;

    public CryptoException() {
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public CryptoException(String str) {
        super(str);
    }

    public CryptoException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }
}