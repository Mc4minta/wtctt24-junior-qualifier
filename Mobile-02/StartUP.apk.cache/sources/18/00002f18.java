package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.ViewGroup;

/* compiled from: JSTouchDispatcher.java */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: e  reason: collision with root package name */
    private final ViewGroup f5121e;
    private int a = -1;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f5118b = new float[2];

    /* renamed from: c  reason: collision with root package name */
    private boolean f5119c = false;

    /* renamed from: d  reason: collision with root package name */
    private long f5120d = Long.MIN_VALUE;

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.react.uimanager.events.h f5122f = new com.facebook.react.uimanager.events.h();

    public g(ViewGroup viewGroup) {
        this.f5121e = viewGroup;
    }

    private void a(MotionEvent motionEvent, com.facebook.react.uimanager.events.d dVar) {
        if (this.a == -1) {
            e.f.d.d.a.A("ReactNative", "Can't cancel already finished gesture. Is a child View trying to start a gesture from an UP/CANCEL event?");
            return;
        }
        e.f.k.a.a.b(!this.f5119c, "Expected to not have already sent a cancel for this gesture");
        int i2 = this.a;
        com.facebook.react.uimanager.events.i iVar = com.facebook.react.uimanager.events.i.CANCEL;
        long j2 = this.f5120d;
        float[] fArr = this.f5118b;
        ((com.facebook.react.uimanager.events.d) e.f.k.a.a.c(dVar)).v(com.facebook.react.uimanager.events.g.q(i2, iVar, motionEvent, j2, fArr[0], fArr[1], this.f5122f));
    }

    private int b(MotionEvent motionEvent) {
        return j0.b(motionEvent.getX(), motionEvent.getY(), this.f5121e, this.f5118b, null);
    }

    public void c(MotionEvent motionEvent, com.facebook.react.uimanager.events.d dVar) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.a != -1) {
                e.f.d.d.a.i("ReactNative", "Got DOWN touch before receiving UP or CANCEL from last gesture");
            }
            this.f5119c = false;
            this.f5120d = motionEvent.getEventTime();
            int b2 = b(motionEvent);
            this.a = b2;
            com.facebook.react.uimanager.events.i iVar = com.facebook.react.uimanager.events.i.START;
            long j2 = this.f5120d;
            float[] fArr = this.f5118b;
            dVar.v(com.facebook.react.uimanager.events.g.q(b2, iVar, motionEvent, j2, fArr[0], fArr[1], this.f5122f));
        } else if (this.f5119c) {
        } else {
            int i2 = this.a;
            if (i2 == -1) {
                e.f.d.d.a.i("ReactNative", "Unexpected state: received touch event but didn't get starting ACTION_DOWN for this gesture before");
            } else if (action == 1) {
                b(motionEvent);
                int i3 = this.a;
                com.facebook.react.uimanager.events.i iVar2 = com.facebook.react.uimanager.events.i.END;
                long j3 = this.f5120d;
                float[] fArr2 = this.f5118b;
                dVar.v(com.facebook.react.uimanager.events.g.q(i3, iVar2, motionEvent, j3, fArr2[0], fArr2[1], this.f5122f));
                this.a = -1;
                this.f5120d = Long.MIN_VALUE;
            } else if (action == 2) {
                b(motionEvent);
                int i4 = this.a;
                com.facebook.react.uimanager.events.i iVar3 = com.facebook.react.uimanager.events.i.MOVE;
                long j4 = this.f5120d;
                float[] fArr3 = this.f5118b;
                dVar.v(com.facebook.react.uimanager.events.g.q(i4, iVar3, motionEvent, j4, fArr3[0], fArr3[1], this.f5122f));
            } else if (action == 5) {
                com.facebook.react.uimanager.events.i iVar4 = com.facebook.react.uimanager.events.i.START;
                long j5 = this.f5120d;
                float[] fArr4 = this.f5118b;
                dVar.v(com.facebook.react.uimanager.events.g.q(i2, iVar4, motionEvent, j5, fArr4[0], fArr4[1], this.f5122f));
            } else if (action == 6) {
                com.facebook.react.uimanager.events.i iVar5 = com.facebook.react.uimanager.events.i.END;
                long j6 = this.f5120d;
                float[] fArr5 = this.f5118b;
                dVar.v(com.facebook.react.uimanager.events.g.q(i2, iVar5, motionEvent, j6, fArr5[0], fArr5[1], this.f5122f));
            } else if (action == 3) {
                if (this.f5122f.c(motionEvent.getDownTime())) {
                    a(motionEvent, dVar);
                } else {
                    e.f.d.d.a.i("ReactNative", "Received an ACTION_CANCEL touch event for which we have no corresponding ACTION_DOWN");
                }
                this.a = -1;
                this.f5120d = Long.MIN_VALUE;
            } else {
                e.f.d.d.a.A("ReactNative", "Warning : touch event was ignored. Action=" + action + " Target=" + this.a);
            }
        }
    }

    public void d(MotionEvent motionEvent, com.facebook.react.uimanager.events.d dVar) {
        if (this.f5119c) {
            return;
        }
        a(motionEvent, dVar);
        this.f5119c = true;
        this.a = -1;
    }
}