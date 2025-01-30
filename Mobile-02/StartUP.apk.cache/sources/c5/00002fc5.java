package com.facebook.react.views.scroll;

import android.content.Context;
import android.widget.HorizontalScrollView;

/* compiled from: ReactHorizontalScrollContainerView.java */
/* loaded from: classes2.dex */
public class c extends com.facebook.react.views.view.f {
    private int w;
    private int x;

    public c(Context context) {
        super(context);
        this.w = com.facebook.react.modules.i18nmanager.a.d().g(context) ? 1 : 0;
        this.x = 0;
    }

    @Override // com.facebook.react.views.view.f, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.w == 1) {
            setLeft(0);
            setRight((i4 - i2) + 0);
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) getParent();
            horizontalScrollView.scrollTo((horizontalScrollView.getScrollX() + getWidth()) - this.x, horizontalScrollView.getScrollY());
        }
        this.x = getWidth();
    }
}