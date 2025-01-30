package com.swmansion.gesturehandler.react;

import android.os.Bundle;
import android.view.MotionEvent;
import e.f.m.l;
import e.f.m.s;

/* compiled from: RNGestureHandlerEnabledRootView.java */
/* loaded from: classes2.dex */
public class a extends s {
    private l a;

    /* renamed from: b  reason: collision with root package name */
    private g f10904b;

    public void a() {
        if (this.f10904b == null) {
            this.f10904b = new g(this.a.u(), this);
            return;
        }
        throw new IllegalStateException("GestureHandler already initialized for root view " + this);
    }

    public void b() {
        g gVar = this.f10904b;
        if (gVar != null) {
            gVar.i();
            this.f10904b = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        g gVar = this.f10904b;
        if (gVar == null || !gVar.d(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // e.f.m.s, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        g gVar = this.f10904b;
        if (gVar != null) {
            gVar.h(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // e.f.m.s
    public void startReactApplication(l lVar, String str, Bundle bundle) {
        super.startReactApplication(lVar, str, bundle);
        this.a = lVar;
    }
}