package com.facebook.react.views.swiperefresh;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.f;
import com.facebook.react.uimanager.o;

/* compiled from: ReactSwipeRefreshLayout.java */
/* loaded from: classes2.dex */
public class a extends SwipeRefreshLayout {
    private boolean U;
    private boolean V;
    private float W;
    private int a0;
    private float b0;
    private boolean c0;

    public a(ReactContext reactContext) {
        super(reactContext);
        this.U = false;
        this.V = false;
        this.W = 0.0f;
        this.a0 = ViewConfiguration.get(reactContext).getScaledTouchSlop();
    }

    private boolean v(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b0 = motionEvent.getX();
            this.c0 = false;
        } else if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.b0);
            if (this.c0 || abs > this.a0) {
                this.c0 = true;
                return false;
            }
        }
        return true;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (v(motionEvent) && super.onInterceptTouchEvent(motionEvent)) {
            f.a(this, motionEvent);
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.U) {
            return;
        }
        this.U = true;
        setProgressViewOffset(this.W);
        setRefreshing(this.V);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setProgressViewOffset(float f2) {
        this.W = f2;
        if (this.U) {
            int progressCircleDiameter = getProgressCircleDiameter();
            m(false, Math.round(o.c(f2)) - progressCircleDiameter, Math.round(o.c(f2 + 64.0f) - progressCircleDiameter));
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    public void setRefreshing(boolean z) {
        this.V = z;
        if (this.U) {
            super.setRefreshing(z);
        }
    }
}