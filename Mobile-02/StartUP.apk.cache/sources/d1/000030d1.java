package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class c extends h {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final e.g.a.c.i.w.a f5815b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.a.c.i.w.a f5816c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5817d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, e.g.a.c.i.w.a aVar, e.g.a.c.i.w.a aVar2, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.a = context;
        Objects.requireNonNull(aVar, "Null wallClock");
        this.f5815b = aVar;
        Objects.requireNonNull(aVar2, "Null monotonicClock");
        this.f5816c = aVar2;
        Objects.requireNonNull(str, "Null backendName");
        this.f5817d = str;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public Context b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public String c() {
        return this.f5817d;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public e.g.a.c.i.w.a d() {
        return this.f5816c;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public e.g.a.c.i.w.a e() {
        return this.f5815b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.a.equals(hVar.b()) && this.f5815b.equals(hVar.e()) && this.f5816c.equals(hVar.d()) && this.f5817d.equals(hVar.c());
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f5815b.hashCode()) * 1000003) ^ this.f5816c.hashCode()) * 1000003) ^ this.f5817d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.a + ", wallClock=" + this.f5815b + ", monotonicClock=" + this.f5816c + ", backendName=" + this.f5817d + "}";
    }
}