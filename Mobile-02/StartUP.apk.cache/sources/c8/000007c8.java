package com.bugsnag.android;

import com.bugsnag.android.o0;
import com.coinbase.ApiConstants;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Session.java */
/* loaded from: classes.dex */
public class w0 implements o0.a {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final Date f3722b;

    /* renamed from: c  reason: collision with root package name */
    private final d1 f3723c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f3724d;

    /* renamed from: e  reason: collision with root package name */
    private AtomicInteger f3725e;

    /* renamed from: f  reason: collision with root package name */
    private AtomicInteger f3726f;

    /* renamed from: g  reason: collision with root package name */
    private AtomicBoolean f3727g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicBoolean f3728h;

    public w0(String str, Date date, d1 d1Var, boolean z) {
        this.f3725e = new AtomicInteger();
        this.f3726f = new AtomicInteger();
        this.f3727g = new AtomicBoolean(false);
        this.f3728h = new AtomicBoolean(false);
        this.a = str;
        this.f3722b = new Date(date.getTime());
        this.f3723c = d1Var;
        this.f3724d = new AtomicBoolean(z);
    }

    static w0 a(w0 w0Var) {
        w0 w0Var2 = new w0(w0Var.a, w0Var.f3722b, w0Var.f3723c, w0Var.f3725e.get(), w0Var.f3726f.get());
        w0Var2.f3727g.set(w0Var.f3727g.get());
        w0Var2.f3724d.set(w0Var.h());
        return w0Var2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f3726f.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Date d() {
        return new Date(this.f3722b.getTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f3725e.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0 f() {
        this.f3726f.incrementAndGet();
        return a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0 g() {
        this.f3725e.incrementAndGet();
        return a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f3724d.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AtomicBoolean i() {
        return this.f3727g;
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        o0Var.d().j("id").d0(this.a).j("startedAt").d0(x.b(this.f3722b));
        if (this.f3723c != null) {
            o0Var.j(ApiConstants.USER).n0(this.f3723c);
        }
        o0Var.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0(String str, Date date, d1 d1Var, int i2, int i3) {
        this.f3725e = new AtomicInteger();
        this.f3726f = new AtomicInteger();
        this.f3727g = new AtomicBoolean(false);
        this.f3728h = new AtomicBoolean(false);
        this.a = str;
        this.f3722b = new Date(date.getTime());
        this.f3723c = d1Var;
        this.f3724d = new AtomicBoolean(false);
        this.f3725e = new AtomicInteger(i2);
        this.f3726f = new AtomicInteger(i3);
        this.f3727g = new AtomicBoolean(true);
    }
}