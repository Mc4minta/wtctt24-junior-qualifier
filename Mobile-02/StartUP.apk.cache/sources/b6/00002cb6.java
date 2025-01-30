package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;

/* compiled from: LruBitmapPool.java */
/* loaded from: classes2.dex */
public class r implements c {
    protected final b0<Bitmap> a = new d();

    /* renamed from: b  reason: collision with root package name */
    private final int f4616b;

    /* renamed from: c  reason: collision with root package name */
    private int f4617c;

    /* renamed from: d  reason: collision with root package name */
    private final f0 f4618d;

    /* renamed from: e  reason: collision with root package name */
    private int f4619e;

    public r(int i2, int i3, f0 f0Var, com.facebook.common.memory.c cVar) {
        this.f4616b = i2;
        this.f4617c = i3;
        this.f4618d = f0Var;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    private Bitmap a(int i2) {
        this.f4618d.a(i2);
        return Bitmap.createBitmap(1, i2, Bitmap.Config.ALPHA_8);
    }

    private synchronized void d(int i2) {
        Bitmap pop;
        while (this.f4619e > i2 && (pop = this.a.pop()) != null) {
            int a = this.a.a(pop);
            this.f4619e -= a;
            this.f4618d.e(a);
        }
    }

    @Override // com.facebook.common.memory.e
    /* renamed from: b */
    public synchronized Bitmap get(int i2) {
        int i3 = this.f4619e;
        int i4 = this.f4616b;
        if (i3 > i4) {
            d(i4);
        }
        Bitmap bitmap = this.a.get(i2);
        if (bitmap != null) {
            int a = this.a.a(bitmap);
            this.f4619e -= a;
            this.f4618d.b(a);
            return bitmap;
        }
        return a(i2);
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    /* renamed from: c */
    public void release(Bitmap bitmap) {
        int a = this.a.a(bitmap);
        if (a <= this.f4617c) {
            this.f4618d.g(a);
            this.a.put(bitmap);
            synchronized (this) {
                this.f4619e += a;
            }
        }
    }
}