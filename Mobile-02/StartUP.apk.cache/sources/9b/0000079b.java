package com.bugsnag.android;

import com.bugsnag.android.o0;
import com.coinbase.ApiConstants;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.java */
/* loaded from: classes.dex */
public class h0 implements o0.a {
    private final k a;

    /* renamed from: b  reason: collision with root package name */
    private String f3653b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f3654c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(s sVar, k kVar) {
        this.a = kVar;
        this.f3653b = kVar.b();
        this.f3654c = sVar.x();
    }

    private void a(o0 o0Var, String str, String str2, StackTraceElement[] stackTraceElementArr) throws IOException {
        o0Var.d();
        o0Var.j("errorClass").d0(str);
        o0Var.j(ApiConstants.MESSAGE).d0(str2);
        o0Var.j("type").d0(this.f3653b);
        o0Var.j("stacktrace").n0(new a1(stackTraceElementArr, this.f3654c));
        o0Var.g();
    }

    private String c(Throwable th) {
        if (th instanceof k) {
            return ((k) th).a();
        }
        return th.getClass().getName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f3653b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str) {
        this.f3653b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String[] strArr) {
        this.f3654c = strArr;
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        o0Var.c();
        for (Throwable th = this.a; th != null; th = th.getCause()) {
            if (th instanceof o0.a) {
                ((o0.a) th).toStream(o0Var);
            } else {
                a(o0Var, c(th), th.getLocalizedMessage(), th.getStackTrace());
            }
        }
        o0Var.f();
    }
}