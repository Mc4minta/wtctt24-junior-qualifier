package com.swmansion.rnscreens;

import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;

/* compiled from: ScreenStackHeaderSubview.java */
/* loaded from: classes2.dex */
public class k extends com.facebook.react.views.view.f {
    private int w;
    private int x;
    private a y;

    /* compiled from: ScreenStackHeaderSubview.java */
    /* loaded from: classes2.dex */
    public enum a {
        LEFT,
        CENTER,
        RIGHT,
        BACK
    }

    public k(ReactContext reactContext) {
        super(reactContext);
        this.y = a.RIGHT;
    }

    public a getType() {
        return this.y;
    }

    @Override // com.facebook.react.views.view.f, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // com.facebook.react.views.view.f, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i2) == 1073741824 && View.MeasureSpec.getMode(i3) == 1073741824) {
            this.w = View.MeasureSpec.getSize(i2);
            this.x = View.MeasureSpec.getSize(i3);
            ViewParent parent = getParent();
            if (parent != null) {
                forceLayout();
                ((View) parent).requestLayout();
            }
        }
        setMeasuredDimension(this.w, this.x);
    }

    public void setType(a aVar) {
        this.y = aVar;
    }
}