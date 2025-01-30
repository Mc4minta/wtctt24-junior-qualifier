package com.google.firebase.crashlytics.c.p.i;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class f implements e {
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public final d f9057b;

    /* renamed from: c  reason: collision with root package name */
    public final c f9058c;

    /* renamed from: d  reason: collision with root package name */
    public final long f9059d;

    /* renamed from: e  reason: collision with root package name */
    public final int f9060e;

    /* renamed from: f  reason: collision with root package name */
    public final int f9061f;

    public f(long j2, b bVar, d dVar, c cVar, int i2, int i3) {
        this.f9059d = j2;
        this.a = bVar;
        this.f9057b = dVar;
        this.f9058c = cVar;
        this.f9060e = i2;
        this.f9061f = i3;
    }

    @Override // com.google.firebase.crashlytics.c.p.i.e
    public c a() {
        return this.f9058c;
    }

    @Override // com.google.firebase.crashlytics.c.p.i.e
    public d b() {
        return this.f9057b;
    }

    public b c() {
        return this.a;
    }

    public long d() {
        return this.f9059d;
    }

    public boolean e(long j2) {
        return this.f9059d < j2;
    }
}