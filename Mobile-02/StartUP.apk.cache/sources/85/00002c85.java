package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import android.os.Build;
import e.f.j.i.g;
import java.util.Map;

/* compiled from: DefaultImageDecoder.java */
/* loaded from: classes2.dex */
public class a implements b {
    private final b a;

    /* renamed from: b  reason: collision with root package name */
    private final b f4536b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.imagepipeline.platform.f f4537c;

    /* renamed from: d  reason: collision with root package name */
    private final b f4538d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<e.f.i.c, b> f4539e;

    /* compiled from: DefaultImageDecoder.java */
    /* renamed from: com.facebook.imagepipeline.decoder.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0107a implements b {
        C0107a() {
        }

        @Override // com.facebook.imagepipeline.decoder.b
        public e.f.j.i.b a(e.f.j.i.d dVar, int i2, g gVar, com.facebook.imagepipeline.common.b bVar) {
            e.f.i.c v = dVar.v();
            if (v == e.f.i.b.a) {
                return a.this.d(dVar, i2, gVar, bVar);
            }
            if (v == e.f.i.b.f12389c) {
                return a.this.c(dVar, i2, gVar, bVar);
            }
            if (v == e.f.i.b.f12396j) {
                return a.this.b(dVar, i2, gVar, bVar);
            }
            if (v != e.f.i.c.a) {
                return a.this.e(dVar, bVar);
            }
            throw new DecodeException("unknown image format", dVar);
        }
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.platform.f fVar) {
        this(bVar, bVar2, fVar, null);
    }

    private void f(e.f.j.o.a aVar, com.facebook.common.references.a<Bitmap> aVar2) {
        if (aVar == null) {
            return;
        }
        Bitmap n = aVar2.n();
        if (Build.VERSION.SDK_INT >= 12 && aVar.a()) {
            n.setHasAlpha(true);
        }
        aVar.b(n);
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public e.f.j.i.b a(e.f.j.i.d dVar, int i2, g gVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        b bVar3 = bVar.f4515h;
        if (bVar3 != null) {
            return bVar3.a(dVar, i2, gVar, bVar);
        }
        e.f.i.c v = dVar.v();
        if (v == null || v == e.f.i.c.a) {
            v = e.f.i.d.c(dVar.z());
            dVar.w0(v);
        }
        Map<e.f.i.c, b> map = this.f4539e;
        if (map != null && (bVar2 = map.get(v)) != null) {
            return bVar2.a(dVar, i2, gVar, bVar);
        }
        return this.f4538d.a(dVar, i2, gVar, bVar);
    }

    public e.f.j.i.b b(e.f.j.i.d dVar, int i2, g gVar, com.facebook.imagepipeline.common.b bVar) {
        return this.f4536b.a(dVar, i2, gVar, bVar);
    }

    public e.f.j.i.b c(e.f.j.i.d dVar, int i2, g gVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (dVar.N() != -1 && dVar.n() != -1) {
            if (!bVar.f4513f && (bVar2 = this.a) != null) {
                return bVar2.a(dVar, i2, gVar, bVar);
            }
            return e(dVar, bVar);
        }
        throw new DecodeException("image width or height is incorrect", dVar);
    }

    public e.f.j.i.c d(e.f.j.i.d dVar, int i2, g gVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> c2 = this.f4537c.c(dVar, bVar.f4514g, null, i2, bVar.f4517j);
        try {
            f(bVar.f4516i, c2);
            return new e.f.j.i.c(c2, gVar, dVar.A(), dVar.j());
        } finally {
            c2.close();
        }
    }

    public e.f.j.i.c e(e.f.j.i.d dVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.f4537c.a(dVar, bVar.f4514g, null, bVar.f4517j);
        try {
            f(bVar.f4516i, a);
            return new e.f.j.i.c(a, e.f.j.i.f.a, dVar.A(), dVar.j());
        } finally {
            a.close();
        }
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.platform.f fVar, Map<e.f.i.c, b> map) {
        this.f4538d = new C0107a();
        this.a = bVar;
        this.f4536b = bVar2;
        this.f4537c = fVar;
        this.f4539e = map;
    }
}