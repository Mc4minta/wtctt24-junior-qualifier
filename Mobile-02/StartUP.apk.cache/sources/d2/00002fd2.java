package com.facebook.react.views.scroll;

import android.view.MotionEvent;
import android.view.VelocityTracker;

/* compiled from: VelocityHelper.java */
/* loaded from: classes2.dex */
public class j {
    private VelocityTracker a;

    /* renamed from: b  reason: collision with root package name */
    private float f5390b;

    /* renamed from: c  reason: collision with root package name */
    private float f5391c;

    public void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.a == null) {
            this.a = VelocityTracker.obtain();
        }
        this.a.addMovement(motionEvent);
        if (action == 1 || action == 3) {
            this.a.computeCurrentVelocity(1);
            this.f5390b = this.a.getXVelocity();
            this.f5391c = this.a.getYVelocity();
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.a = null;
            }
        }
    }

    public float b() {
        return this.f5390b;
    }

    public float c() {
        return this.f5391c;
    }
}