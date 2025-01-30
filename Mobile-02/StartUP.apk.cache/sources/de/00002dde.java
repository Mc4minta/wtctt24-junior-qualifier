package com.facebook.react.common;

/* compiled from: SingleThreadAsserter.java */
/* loaded from: classes2.dex */
public class d {
    private Thread a = null;

    public void a() {
        Thread currentThread = Thread.currentThread();
        if (this.a == null) {
            this.a = currentThread;
        }
        e.f.k.a.a.a(this.a == currentThread);
    }
}