package com.google.zxing;

/* loaded from: classes2.dex */
public final class FormatException extends ReaderException {

    /* renamed from: c  reason: collision with root package name */
    private static final FormatException f9785c;

    static {
        FormatException formatException = new FormatException();
        f9785c = formatException;
        formatException.setStackTrace(ReaderException.f9787b);
    }

    private FormatException() {
    }

    public static FormatException a() {
        return ReaderException.a ? new FormatException() : f9785c;
    }

    public static FormatException b(Throwable th) {
        return ReaderException.a ? new FormatException(th) : f9785c;
    }

    private FormatException(Throwable th) {
        super(th);
    }
}