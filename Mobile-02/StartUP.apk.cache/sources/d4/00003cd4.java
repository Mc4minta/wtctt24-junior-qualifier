package com.google.zxing;

/* loaded from: classes2.dex */
public abstract class ReaderException extends Exception {
    protected static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    protected static final StackTraceElement[] f9787b;

    static {
        a = System.getProperty("surefire.test.class.path") != null;
        f9787b = new StackTraceElement[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReaderException() {
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReaderException(Throwable th) {
        super(th);
    }
}