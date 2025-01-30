package com.facebook.imagepipeline.decoder;

/* loaded from: classes2.dex */
public class DecodeException extends RuntimeException {
    private final e.f.j.i.d a;

    public DecodeException(String str, e.f.j.i.d dVar) {
        super(str);
        this.a = dVar;
    }

    public e.f.j.i.d a() {
        return this.a;
    }
}