package com.rd.c;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import com.rd.c.b.b;
import com.rd.c.b.c;

/* compiled from: DrawManager.java */
/* loaded from: classes2.dex */
public class a {
    private com.rd.c.c.a a;

    /* renamed from: b  reason: collision with root package name */
    private b f10635b;

    /* renamed from: c  reason: collision with root package name */
    private c f10636c;

    /* renamed from: d  reason: collision with root package name */
    private com.rd.c.b.a f10637d;

    public a() {
        com.rd.c.c.a aVar = new com.rd.c.c.a();
        this.a = aVar;
        this.f10635b = new b(aVar);
        this.f10636c = new c();
        this.f10637d = new com.rd.c.b.a(this.a);
    }

    public void a(Canvas canvas) {
        this.f10635b.a(canvas);
    }

    public com.rd.c.c.a b() {
        if (this.a == null) {
            this.a = new com.rd.c.c.a();
        }
        return this.a;
    }

    public void c(Context context, AttributeSet attributeSet) {
        this.f10637d.c(context, attributeSet);
    }

    public Pair<Integer, Integer> d(int i2, int i3) {
        return this.f10636c.a(this.a, i2, i3);
    }

    public void e(b.InterfaceC0225b interfaceC0225b) {
        this.f10635b.e(interfaceC0225b);
    }

    public void f(MotionEvent motionEvent) {
        this.f10635b.f(motionEvent);
    }

    public void g(com.rd.b.c.a aVar) {
        this.f10635b.g(aVar);
    }
}