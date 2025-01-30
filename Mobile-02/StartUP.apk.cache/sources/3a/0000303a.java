package com.facebook.react.views.viewpager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.o;
import com.facebook.react.uimanager.w0;
import e.f.m.a0.m;
import e.f.m.a0.n;
import java.util.Map;

@e.f.m.x.a.a(name = ReactViewPagerManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactViewPagerManager extends ViewGroupManager<d> implements n<d> {
    public static final int COMMAND_SET_PAGE = 1;
    public static final int COMMAND_SET_PAGE_WITHOUT_ANIMATION = 2;
    public static final String REACT_CLASS = "AndroidViewPager";
    private final w0<d> mDelegate = new m(this);

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return com.facebook.react.common.c.e("setPage", 1, "setPageWithoutAnimation", 2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public w0<d> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return com.facebook.react.common.c.f("topPageScroll", com.facebook.react.common.c.d("registrationName", "onPageScroll"), "topPageScrollStateChanged", com.facebook.react.common.c.d("registrationName", "onPageScrollStateChanged"), "topPageSelected", com.facebook.react.common.c.d("registrationName", "onPageSelected"));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.f
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // e.f.m.a0.n
    public void setInitialPage(d dVar, int i2) {
    }

    @Override // e.f.m.a0.n
    public void setKeyboardDismissMode(d dVar, String str) {
    }

    public void setPage(d dVar, int i2) {
    }

    public void setPageWithoutAnimation(d dVar, int i2) {
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(d dVar, View view, int i2) {
        dVar.d(view, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public d createViewInstance(i0 i0Var) {
        return new d(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(d dVar, int i2) {
        return dVar.e(i2);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(d dVar) {
        return dVar.getViewCountInAdapter();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(d dVar, int i2) {
        dVar.f(i2);
    }

    @Override // e.f.m.a0.n
    @com.facebook.react.uimanager.c1.a(defaultInt = 0, name = "pageMargin")
    public void setPageMargin(d dVar, int i2) {
        dVar.setPageMargin((int) o.c(i2));
    }

    @Override // e.f.m.a0.n
    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "peekEnabled")
    public void setPeekEnabled(d dVar, boolean z) {
        dVar.setClipToPadding(!z);
    }

    @Override // e.f.m.a0.n
    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(d dVar, boolean z) {
        dVar.setScrollEnabled(z);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(d dVar, int i2, ReadableArray readableArray) {
        e.f.k.a.a.c(dVar);
        e.f.k.a.a.c(readableArray);
        if (i2 == 1) {
            dVar.g(readableArray.getInt(0), true);
        } else if (i2 == 2) {
            dVar.g(readableArray.getInt(0), false);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", Integer.valueOf(i2), getClass().getSimpleName()));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(d dVar, String str, ReadableArray readableArray) {
        e.f.k.a.a.c(dVar);
        e.f.k.a.a.c(readableArray);
        str.hashCode();
        if (str.equals("setPageWithoutAnimation")) {
            dVar.g(readableArray.getInt(0), false);
        } else if (!str.equals("setPage")) {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", str, getClass().getSimpleName()));
        } else {
            dVar.g(readableArray.getInt(0), true);
        }
    }
}