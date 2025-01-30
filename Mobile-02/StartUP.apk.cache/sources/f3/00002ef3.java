package com.facebook.react.uimanager.events;

import com.facebook.react.uimanager.events.c;

/* compiled from: Event.java */
/* loaded from: classes2.dex */
public abstract class c<T extends c> {
    private static int a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5052b;

    /* renamed from: c  reason: collision with root package name */
    private int f5053c;

    /* renamed from: d  reason: collision with root package name */
    private long f5054d;

    /* renamed from: e  reason: collision with root package name */
    private int f5055e;

    /* JADX INFO: Access modifiers changed from: protected */
    public c() {
        int i2 = a;
        a = i2 + 1;
        this.f5055e = i2;
    }

    public boolean a() {
        return true;
    }

    public T b(T t) {
        return g() >= t.g() ? this : t;
    }

    public abstract void c(RCTEventEmitter rCTEventEmitter);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        this.f5052b = false;
        l();
    }

    public short e() {
        return (short) 0;
    }

    public abstract String f();

    public final long g() {
        return this.f5054d;
    }

    public int h() {
        return this.f5055e;
    }

    public final int i() {
        return this.f5053c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i2) {
        this.f5053c = i2;
        this.f5054d = com.facebook.react.common.f.c();
        this.f5052b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f5052b;
    }

    public void l() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(int i2) {
        int i3 = a;
        a = i3 + 1;
        this.f5055e = i3;
        j(i2);
    }
}