package com.bugsnag.android;

import com.bugsnag.android.o0;
import com.coinbase.ApiConstants;
import java.io.IOException;
import org.apache.http.cookie.ClientCookie;

/* compiled from: Notifier.java */
/* loaded from: classes.dex */
public class t0 implements o0.a {
    private static final t0 a = new t0();

    /* renamed from: b  reason: collision with root package name */
    private String f3709b = "Android Bugsnag Notifier";

    /* renamed from: c  reason: collision with root package name */
    private String f3710c = "4.19.0";

    /* renamed from: d  reason: collision with root package name */
    private String f3711d = "https://bugsnag.com";

    public static t0 a() {
        return a;
    }

    public String b() {
        return this.f3709b;
    }

    public String c() {
        return this.f3710c;
    }

    public void d(String str) {
        this.f3709b = str;
    }

    public void e(String str) {
        this.f3711d = str;
    }

    public void f(String str) {
        this.f3710c = str;
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        o0Var.d();
        o0Var.j(ApiConstants.NAME).d0(this.f3709b);
        o0Var.j(ClientCookie.VERSION_ATTR).d0(this.f3710c);
        o0Var.j("url").d0(this.f3711d);
        o0Var.g();
    }
}