package com.facebook.react.views.drawer;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import c.k.d.a;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.f;

/* compiled from: ReactDrawerLayout.java */
/* loaded from: classes2.dex */
class a extends c.k.d.a {
    private int U;
    private int V;

    public a(ReactContext reactContext) {
        super(reactContext);
        this.U = 8388611;
        this.V = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W() {
        d(this.U);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X() {
        I(this.U);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(int i2) {
        this.U = i2;
        Z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z() {
        if (getChildCount() == 2) {
            View childAt = getChildAt(1);
            a.f fVar = (a.f) childAt.getLayoutParams();
            fVar.a = this.U;
            ((ViewGroup.MarginLayoutParams) fVar).width = this.V;
            childAt.setLayoutParams(fVar);
            childAt.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(int i2) {
        this.V = i2;
        Z();
    }

    @Override // c.k.d.a, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                f.a(this, motionEvent);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e2) {
            e.f.d.d.a.B("ReactNative", "Error intercepting touch event.", e2);
            return false;
        }
    }
}