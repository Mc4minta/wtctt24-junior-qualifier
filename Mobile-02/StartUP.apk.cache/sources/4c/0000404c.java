package com.th3rdwave.safeareacontext;

/* compiled from: EdgeInsets.java */
/* loaded from: classes2.dex */
class a {
    float a;

    /* renamed from: b  reason: collision with root package name */
    float f11051b;

    /* renamed from: c  reason: collision with root package name */
    float f11052c;

    /* renamed from: d  reason: collision with root package name */
    float f11053d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.f11051b = f3;
        this.f11052c = f4;
        this.f11053d = f5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        if (this == aVar) {
            return true;
        }
        return this.a == aVar.a && this.f11051b == aVar.f11051b && this.f11052c == aVar.f11052c && this.f11053d == aVar.f11053d;
    }
}