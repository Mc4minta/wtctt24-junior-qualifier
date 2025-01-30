package com.facebook.react.views.view;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.views.view.f;

/* loaded from: classes2.dex */
public abstract class ReactClippingViewManager<T extends f> extends ViewGroupManager<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.ViewGroupManager
    public /* bridge */ /* synthetic */ void addView(ViewGroup viewGroup, View view, int i2) {
        addView((ReactClippingViewManager<T>) ((f) viewGroup), view, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.ViewGroupManager
    public /* bridge */ /* synthetic */ View getChildAt(ViewGroup viewGroup, int i2) {
        return getChildAt((ReactClippingViewManager<T>) ((f) viewGroup), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.ViewGroupManager
    public /* bridge */ /* synthetic */ int getChildCount(ViewGroup viewGroup) {
        return getChildCount((ReactClippingViewManager<T>) ((f) viewGroup));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.ViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(ViewGroup viewGroup) {
        removeAllViews((ReactClippingViewManager<T>) ((f) viewGroup));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.ViewGroupManager
    public /* bridge */ /* synthetic */ void removeViewAt(ViewGroup viewGroup, int i2) {
        removeViewAt((ReactClippingViewManager<T>) ((f) viewGroup), i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(T t, boolean z) {
        UiThreadUtil.assertOnUiThread();
        t.setRemoveClippedSubviews(z);
    }

    public void addView(T t, View view, int i2) {
        UiThreadUtil.assertOnUiThread();
        if (t.getRemoveClippedSubviews()) {
            t.i(view, i2);
        } else {
            t.addView(view, i2);
        }
    }

    public View getChildAt(T t, int i2) {
        if (t.getRemoveClippedSubviews()) {
            return t.l(i2);
        }
        return t.getChildAt(i2);
    }

    public int getChildCount(T t) {
        if (t.getRemoveClippedSubviews()) {
            return t.getAllChildrenCount();
        }
        return t.getChildCount();
    }

    public void removeAllViews(T t) {
        UiThreadUtil.assertOnUiThread();
        if (t.getRemoveClippedSubviews()) {
            t.n();
        } else {
            t.removeAllViews();
        }
    }

    public void removeViewAt(T t, int i2) {
        UiThreadUtil.assertOnUiThread();
        if (t.getRemoveClippedSubviews()) {
            View childAt = getChildAt((ReactClippingViewManager<T>) t, i2);
            if (childAt.getParent() != null) {
                t.removeView(childAt);
            }
            t.p(childAt);
            return;
        }
        t.removeViewAt(i2);
    }
}