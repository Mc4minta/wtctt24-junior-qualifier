package com.th3rdwave.safeareacontext;

/* compiled from: Rect.java */
/* loaded from: classes2.dex */
class c {
    float a;

    /* renamed from: b  reason: collision with root package name */
    float f11056b;

    /* renamed from: c  reason: collision with root package name */
    float f11057c;

    /* renamed from: d  reason: collision with root package name */
    float f11058d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.f11056b = f3;
        this.f11057c = f4;
        this.f11058d = f5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(c cVar) {
        if (this == cVar) {
            return true;
        }
        return this.a == cVar.a && this.f11056b == cVar.f11056b && this.f11057c == cVar.f11057c && this.f11058d == cVar.f11058d;
    }
}