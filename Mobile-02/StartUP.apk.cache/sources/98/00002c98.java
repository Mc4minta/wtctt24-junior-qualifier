package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;

/* compiled from: BitmapCounter.java */
/* loaded from: classes2.dex */
public class a {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private long f4560b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4561c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4562d;

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.common.references.c<Bitmap> f4563e;

    /* compiled from: BitmapCounter.java */
    /* renamed from: com.facebook.imagepipeline.memory.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0108a implements com.facebook.common.references.c<Bitmap> {
        C0108a() {
        }

        @Override // com.facebook.common.references.c
        /* renamed from: a */
        public void release(Bitmap bitmap) {
            try {
                a.this.a(bitmap);
            } finally {
                bitmap.recycle();
            }
        }
    }

    public a(int i2, int i3) {
        e.f.d.c.i.b(i2 > 0);
        e.f.d.c.i.b(i3 > 0);
        this.f4561c = i2;
        this.f4562d = i3;
        this.f4563e = new C0108a();
    }

    public synchronized void a(Bitmap bitmap) {
        int e2 = com.facebook.imageutils.a.e(bitmap);
        e.f.d.c.i.c(this.a > 0, "No bitmaps registered.");
        long j2 = e2;
        e.f.d.c.i.d(j2 <= this.f4560b, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(e2), Long.valueOf(this.f4560b));
        this.f4560b -= j2;
        this.a--;
    }

    public synchronized int b() {
        return this.a;
    }

    public synchronized int c() {
        return this.f4561c;
    }

    public synchronized int d() {
        return this.f4562d;
    }

    public com.facebook.common.references.c<Bitmap> e() {
        return this.f4563e;
    }

    public synchronized long f() {
        return this.f4560b;
    }

    public synchronized boolean g(Bitmap bitmap) {
        int e2 = com.facebook.imageutils.a.e(bitmap);
        int i2 = this.a;
        if (i2 < this.f4561c) {
            long j2 = this.f4560b;
            long j3 = e2;
            if (j2 + j3 <= this.f4562d) {
                this.a = i2 + 1;
                this.f4560b = j2 + j3;
                return true;
            }
        }
        return false;
    }
}