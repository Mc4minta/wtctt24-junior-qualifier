package com.google.zxing;

/* loaded from: classes2.dex */
public final class ChecksumException extends ReaderException {

    /* renamed from: c  reason: collision with root package name */
    private static final ChecksumException f9784c;

    static {
        ChecksumException checksumException = new ChecksumException();
        f9784c = checksumException;
        checksumException.setStackTrace(ReaderException.f9787b);
    }

    private ChecksumException() {
    }

    public static ChecksumException a() {
        return ReaderException.a ? new ChecksumException() : f9784c;
    }
}