package com.bugsnag.android;

import com.bugsnag.android.o0;
import java.io.IOException;

/* compiled from: Report.java */
/* loaded from: classes.dex */
public class v0 implements o0.a {
    private final c0 a;

    /* renamed from: b  reason: collision with root package name */
    private final t0 f3716b = t0.a();

    /* renamed from: c  reason: collision with root package name */
    private String f3717c;

    /* renamed from: d  reason: collision with root package name */
    private transient boolean f3718d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v0(String str, c0 c0Var) {
        this.a = c0Var;
        this.f3717c = str;
    }

    public c0 a() {
        return this.a;
    }

    public t0 b() {
        return this.f3716b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f3718d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z) {
        this.f3718d = z;
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        o0Var.d();
        o0Var.j("apiKey").d0(this.f3717c);
        o0Var.j("payloadVersion").d0("4.0");
        o0Var.j("notifier").n0(this.f3716b);
        o0Var.j("events").c();
        o0Var.n0(this.a);
        o0Var.f();
        o0Var.g();
    }
}