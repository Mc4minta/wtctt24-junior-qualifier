package com.bugsnag.android;

import com.bugsnag.android.o0;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: SessionTrackingPayload.java */
/* loaded from: classes.dex */
public class z0 implements o0.a {
    private final t0 a = t0.a();

    /* renamed from: b  reason: collision with root package name */
    private final w0 f3740b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object> f3741c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Object> f3742d;

    /* renamed from: e  reason: collision with root package name */
    private final List<File> f3743e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(w0 w0Var, List<File> list, c cVar, b0 b0Var) {
        this.f3742d = cVar.h();
        this.f3741c = b0Var.h();
        this.f3740b = w0Var;
        this.f3743e = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> a() {
        return this.f3741c;
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        o0Var.d();
        o0Var.j("notifier").n0(this.a);
        o0Var.j("app").r0(this.f3742d);
        o0Var.j("device").r0(this.f3741c);
        o0Var.j("sessions").c();
        w0 w0Var = this.f3740b;
        if (w0Var == null) {
            for (File file : this.f3743e) {
                o0Var.o0(file);
            }
        } else {
            o0Var.n0(w0Var);
        }
        o0Var.f();
        o0Var.g();
    }
}