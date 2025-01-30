package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;

/* compiled from: RNGestureHandlerRootView.java */
/* loaded from: classes2.dex */
public class h extends com.facebook.react.views.view.f {
    private boolean w;
    private g x;

    public h(Context context) {
        super(context);
    }

    private static boolean y(ViewGroup viewGroup) {
        UiThreadUtil.assertOnUiThread();
        for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
            if ((parent instanceof a) || (parent instanceof h)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.w && ((g) e.f.k.a.a.c(this.x)).d(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.views.view.f, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean z = !y(this);
        this.w = z;
        if (!z) {
            Log.i("ReactNative", "[GESTURE HANDLER] Gesture handler is already enabled for a parent view");
        }
        if (this.w && this.x == null) {
            this.x = new g((ReactContext) getContext(), this);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (this.w) {
            ((g) e.f.k.a.a.c(this.x)).h(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void z() {
        g gVar = this.x;
        if (gVar != null) {
            gVar.i();
        }
    }
}