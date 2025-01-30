package com.bugsnag.android;

import com.bugsnag.android.NativeInterface;
import com.bugsnag.android.o0;
import com.coinbase.ApiConstants;
import java.io.IOException;
import java.util.Observable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: User.java */
/* loaded from: classes.dex */
public class d1 extends Observable implements o0.a {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f3638b;

    /* renamed from: c  reason: collision with root package name */
    private String f3639c;

    public String a() {
        return this.f3638b;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.f3639c;
    }

    public void d(String str) {
        this.f3638b = str;
        setChanged();
        notifyObservers(new NativeInterface.b(NativeInterface.c.UPDATE_USER_EMAIL, str));
    }

    public void e(String str) {
        this.a = str;
        setChanged();
        notifyObservers(new NativeInterface.b(NativeInterface.c.UPDATE_USER_ID, str));
    }

    public void f(String str) {
        this.f3639c = str;
        setChanged();
        notifyObservers(new NativeInterface.b(NativeInterface.c.UPDATE_USER_NAME, str));
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        o0Var.d();
        o0Var.j("id").d0(this.a);
        o0Var.j("email").d0(this.f3638b);
        o0Var.j(ApiConstants.NAME).d0(this.f3639c);
        o0Var.g();
    }
}