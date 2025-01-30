package com.rd.b.d;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.rd.b.b.b;

/* compiled from: BaseAnimation.java */
/* loaded from: classes2.dex */
public abstract class b<T extends Animator> {

    /* renamed from: b  reason: collision with root package name */
    protected b.a f10594b;
    protected long a = 350;

    /* renamed from: c  reason: collision with root package name */
    protected T f10595c = a();

    public b(b.a aVar) {
        this.f10594b = aVar;
    }

    public abstract T a();

    public b b(long j2) {
        this.a = j2;
        T t = this.f10595c;
        if (t instanceof ValueAnimator) {
            t.setDuration(j2);
        }
        return this;
    }

    public void c() {
        T t = this.f10595c;
        if (t == null || !t.isStarted()) {
            return;
        }
        this.f10595c.end();
    }

    public abstract b d(float f2);

    public void e() {
        T t = this.f10595c;
        if (t == null || t.isRunning()) {
            return;
        }
        this.f10595c.start();
    }
}