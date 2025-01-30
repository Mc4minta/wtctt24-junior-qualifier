package com.google.zxing;

/* loaded from: classes2.dex */
public final class NotFoundException extends ReaderException {

    /* renamed from: c  reason: collision with root package name */
    private static final NotFoundException f9786c;

    static {
        NotFoundException notFoundException = new NotFoundException();
        f9786c = notFoundException;
        notFoundException.setStackTrace(ReaderException.f9787b);
    }

    private NotFoundException() {
    }

    public static NotFoundException a() {
        return f9786c;
    }
}