package com.facebook.imagepipeline.nativecode;

@e.f.d.c.d
/* loaded from: classes2.dex */
public class NativeJpegTranscoderFactory implements e.f.j.n.d {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f4627b;

    @e.f.d.c.d
    public NativeJpegTranscoderFactory(int i2, boolean z) {
        this.a = i2;
        this.f4627b = z;
    }

    @Override // e.f.j.n.d
    @e.f.d.c.d
    public e.f.j.n.c createImageTranscoder(e.f.i.c cVar, boolean z) {
        if (cVar != e.f.i.b.a) {
            return null;
        }
        return new NativeJpegTranscoder(z, this.a, this.f4627b);
    }
}