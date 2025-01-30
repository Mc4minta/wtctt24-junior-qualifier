package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;

/* compiled from: ImageDecodeOptions.java */
/* loaded from: classes2.dex */
public class b {
    private static final b a = b().a();

    /* renamed from: b  reason: collision with root package name */
    public final int f4509b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4510c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4511d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4512e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4513f;

    /* renamed from: g  reason: collision with root package name */
    public final Bitmap.Config f4514g;

    /* renamed from: h  reason: collision with root package name */
    public final com.facebook.imagepipeline.decoder.b f4515h;

    /* renamed from: i  reason: collision with root package name */
    public final e.f.j.o.a f4516i;

    /* renamed from: j  reason: collision with root package name */
    public final ColorSpace f4517j;

    public b(c cVar) {
        this.f4509b = cVar.i();
        this.f4510c = cVar.g();
        this.f4511d = cVar.j();
        this.f4512e = cVar.f();
        this.f4513f = cVar.h();
        this.f4514g = cVar.b();
        this.f4515h = cVar.e();
        this.f4516i = cVar.c();
        this.f4517j = cVar.d();
    }

    public static b a() {
        return a;
    }

    public static c b() {
        return new c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4510c == bVar.f4510c && this.f4511d == bVar.f4511d && this.f4512e == bVar.f4512e && this.f4513f == bVar.f4513f && this.f4514g == bVar.f4514g && this.f4515h == bVar.f4515h && this.f4516i == bVar.f4516i && this.f4517j == bVar.f4517j;
    }

    public int hashCode() {
        int ordinal = ((((((((((this.f4509b * 31) + (this.f4510c ? 1 : 0)) * 31) + (this.f4511d ? 1 : 0)) * 31) + (this.f4512e ? 1 : 0)) * 31) + (this.f4513f ? 1 : 0)) * 31) + this.f4514g.ordinal()) * 31;
        com.facebook.imagepipeline.decoder.b bVar = this.f4515h;
        int hashCode = (ordinal + (bVar != null ? bVar.hashCode() : 0)) * 31;
        e.f.j.o.a aVar = this.f4516i;
        int hashCode2 = (hashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        ColorSpace colorSpace = this.f4517j;
        return hashCode2 + (colorSpace != null ? colorSpace.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%b-%s-%s-%s", Integer.valueOf(this.f4509b), Boolean.valueOf(this.f4510c), Boolean.valueOf(this.f4511d), Boolean.valueOf(this.f4512e), Boolean.valueOf(this.f4513f), this.f4514g.name(), this.f4515h, this.f4516i, this.f4517j);
    }
}