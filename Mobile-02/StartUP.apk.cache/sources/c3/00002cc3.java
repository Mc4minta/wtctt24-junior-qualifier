package com.facebook.imagepipeline.nativecode;

import e.f.d.c.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@e.f.d.c.d
/* loaded from: classes2.dex */
public class NativeJpegTranscoder implements e.f.j.n.c {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private int f4625b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4626c;

    static {
        d.a();
    }

    public NativeJpegTranscoder(boolean z, int i2, boolean z2) {
        this.a = z;
        this.f4625b = i2;
        this.f4626c = z2;
    }

    public static void e(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException {
        d.a();
        boolean z = false;
        i.b(i3 >= 1);
        i.b(i3 <= 16);
        i.b(i4 >= 0);
        i.b(i4 <= 100);
        i.b(e.f.j.n.e.j(i2));
        if (i3 != 8 || i2 != 0) {
            z = true;
        }
        i.c(z, "no transformation requested");
        nativeTranscodeJpeg((InputStream) i.g(inputStream), (OutputStream) i.g(outputStream), i2, i3, i4);
    }

    public static void f(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException {
        d.a();
        boolean z = false;
        i.b(i3 >= 1);
        i.b(i3 <= 16);
        i.b(i4 >= 0);
        i.b(i4 <= 100);
        i.b(e.f.j.n.e.i(i2));
        if (i3 != 8 || i2 != 1) {
            z = true;
        }
        i.c(z, "no transformation requested");
        nativeTranscodeJpegWithExifOrientation((InputStream) i.g(inputStream), (OutputStream) i.g(outputStream), i2, i3, i4);
    }

    @e.f.d.c.d
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException;

    @e.f.d.c.d
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException;

    @Override // e.f.j.n.c
    public String a() {
        return "NativeJpegTranscoder";
    }

    @Override // e.f.j.n.c
    public boolean b(e.f.j.i.d dVar, com.facebook.imagepipeline.common.f fVar, com.facebook.imagepipeline.common.e eVar) {
        if (fVar == null) {
            fVar = com.facebook.imagepipeline.common.f.a();
        }
        return e.f.j.n.e.f(fVar, eVar, dVar, this.a) < 8;
    }

    @Override // e.f.j.n.c
    public e.f.j.n.b c(e.f.j.i.d dVar, OutputStream outputStream, com.facebook.imagepipeline.common.f fVar, com.facebook.imagepipeline.common.e eVar, e.f.i.c cVar, Integer num) throws IOException {
        if (num == null) {
            num = 85;
        }
        if (fVar == null) {
            fVar = com.facebook.imagepipeline.common.f.a();
        }
        int b2 = e.f.j.n.a.b(fVar, eVar, dVar, this.f4625b);
        try {
            int f2 = e.f.j.n.e.f(fVar, eVar, dVar, this.a);
            int a = e.f.j.n.e.a(b2);
            if (this.f4626c) {
                f2 = a;
            }
            InputStream z = dVar.z();
            if (e.f.j.n.e.a.contains(Integer.valueOf(dVar.j()))) {
                f(z, outputStream, e.f.j.n.e.d(fVar, dVar), f2, num.intValue());
            } else {
                e(z, outputStream, e.f.j.n.e.e(fVar, dVar), f2, num.intValue());
            }
            e.f.d.c.b.b(z);
            return new e.f.j.n.b(b2 != 1 ? 0 : 1);
        } catch (Throwable th) {
            e.f.d.c.b.b(null);
            throw th;
        }
    }

    @Override // e.f.j.n.c
    public boolean d(e.f.i.c cVar) {
        return cVar == e.f.i.b.a;
    }
}