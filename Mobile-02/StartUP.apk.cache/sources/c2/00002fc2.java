package com.facebook.react.views.scroll;

import android.util.DisplayMetrics;
import android.view.View;
import c.h.k.v;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.a0;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.o;
import com.facebook.react.views.scroll.f;
import java.util.ArrayList;
import java.util.Map;

@e.f.m.x.a.a(name = ReactScrollViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactScrollViewManager extends ViewGroupManager<e> implements f.a<e> {
    public static final String REACT_CLASS = "RCTScrollView";
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    private a mFpsListener;

    public ReactScrollViewManager() {
        this(null);
    }

    public static Map<String, Object> createExportedCustomDirectEventTypeConstants() {
        return com.facebook.react.common.c.a().b(i.h(i.SCROLL), com.facebook.react.common.c.d("registrationName", "onScroll")).b(i.h(i.BEGIN_DRAG), com.facebook.react.common.c.d("registrationName", "onScrollBeginDrag")).b(i.h(i.END_DRAG), com.facebook.react.common.c.d("registrationName", "onScrollEndDrag")).b(i.h(i.MOMENTUM_BEGIN), com.facebook.react.common.c.d("registrationName", "onMomentumScrollBegin")).b(i.h(i.MOMENTUM_END), com.facebook.react.common.c.d("registrationName", "onMomentumScrollEnd")).a();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return f.a();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return createExportedCustomDirectEventTypeConstants();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @com.facebook.react.uimanager.c1.b(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(e eVar, int i2, Integer num) {
        eVar.u(SPACING_TYPES[i2], num == null ? Float.NaN : num.intValue() & 16777215, num != null ? num.intValue() >>> 24 : Float.NaN);
    }

    @com.facebook.react.uimanager.c1.b(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(e eVar, int i2, float f2) {
        if (!com.facebook.yoga.g.a(f2)) {
            f2 = o.c(f2);
        }
        if (i2 == 0) {
            eVar.setBorderRadius(f2);
        } else {
            eVar.v(f2, i2 - 1);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "borderStyle")
    public void setBorderStyle(e eVar, String str) {
        eVar.setBorderStyle(str);
    }

    @com.facebook.react.uimanager.c1.b(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(e eVar, int i2, float f2) {
        if (!com.facebook.yoga.g.a(f2)) {
            f2 = o.c(f2);
        }
        eVar.w(SPACING_TYPES[i2], f2);
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", defaultInt = 0, name = "endFillColor")
    public void setBottomFillColor(e eVar, int i2) {
        eVar.setEndFillColor(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "decelerationRate")
    public void setDecelerationRate(e eVar, float f2) {
        eVar.setDecelerationRate(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "disableIntervalMomentum")
    public void setDisableIntervalMomentum(e eVar, boolean z) {
        eVar.setDisableIntervalMomentum(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "fadingEdgeLength")
    public void setFadingEdgeLength(e eVar, int i2) {
        if (i2 > 0) {
            eVar.setVerticalFadingEdgeEnabled(true);
            eVar.setFadingEdgeLength(i2);
            return;
        }
        eVar.setVerticalFadingEdgeEnabled(false);
        eVar.setFadingEdgeLength(0);
    }

    @com.facebook.react.uimanager.c1.a(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(e eVar, boolean z) {
        v.v0(eVar, z);
    }

    @com.facebook.react.uimanager.c1.a(name = "overScrollMode")
    public void setOverScrollMode(e eVar, String str) {
        eVar.setOverScrollMode(g.h(str));
    }

    @com.facebook.react.uimanager.c1.a(name = "overflow")
    public void setOverflow(e eVar, String str) {
        eVar.setOverflow(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "pagingEnabled")
    public void setPagingEnabled(e eVar, boolean z) {
        eVar.setPagingEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "persistentScrollbar")
    public void setPersistentScrollbar(e eVar, boolean z) {
        eVar.setScrollbarFadingEnabled(!z);
    }

    @com.facebook.react.uimanager.c1.a(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(e eVar, boolean z) {
        eVar.setRemoveClippedSubviews(z);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(e eVar, boolean z) {
        eVar.setScrollEnabled(z);
        eVar.setFocusable(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "scrollPerfTag")
    public void setScrollPerfTag(e eVar, String str) {
        eVar.setScrollPerfTag(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "sendMomentumEvents")
    public void setSendMomentumEvents(e eVar, boolean z) {
        eVar.setSendMomentumEvents(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(e eVar, boolean z) {
        eVar.setVerticalScrollBarEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "snapToEnd")
    public void setSnapToEnd(e eVar, boolean z) {
        eVar.setSnapToEnd(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "snapToInterval")
    public void setSnapToInterval(e eVar, float f2) {
        eVar.setSnapInterval((int) (f2 * com.facebook.react.uimanager.c.e().density));
    }

    @com.facebook.react.uimanager.c1.a(name = "snapToOffsets")
    public void setSnapToOffsets(e eVar, ReadableArray readableArray) {
        DisplayMetrics e2 = com.facebook.react.uimanager.c.e();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            arrayList.add(Integer.valueOf((int) (readableArray.getDouble(i2) * e2.density)));
        }
        eVar.setSnapOffsets(arrayList);
    }

    @com.facebook.react.uimanager.c1.a(name = "snapToStart")
    public void setSnapToStart(e eVar, boolean z) {
        eVar.setSnapToStart(z);
    }

    public ReactScrollViewManager(a aVar) {
        this.mFpsListener = null;
        this.mFpsListener = aVar;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public e createViewInstance(i0 i0Var) {
        return new e(i0Var, this.mFpsListener);
    }

    @Override // com.facebook.react.views.scroll.f.a
    public void flashScrollIndicators(e eVar) {
        eVar.m();
    }

    @Override // com.facebook.react.views.scroll.f.a
    public void scrollTo(e eVar, f.b bVar) {
        if (bVar.f5377c) {
            eVar.s(bVar.a, bVar.f5376b);
        } else {
            eVar.r(bVar.a, bVar.f5376b);
        }
    }

    @Override // com.facebook.react.views.scroll.f.a
    public void scrollToEnd(e eVar, f.c cVar) {
        View childAt = eVar.getChildAt(0);
        if (childAt != null) {
            int height = childAt.getHeight() + eVar.getPaddingBottom();
            if (cVar.a) {
                eVar.s(eVar.getScrollX(), height);
                return;
            } else {
                eVar.r(eVar.getScrollX(), height);
                return;
            }
        }
        throw new RetryableMountingLayerException("scrollToEnd called on ScrollView without child");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(e eVar, a0 a0Var, h0 h0Var) {
        eVar.y(h0Var);
        return null;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(e eVar, int i2, ReadableArray readableArray) {
        f.b(this, eVar, i2, readableArray);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(e eVar, String str, ReadableArray readableArray) {
        f.c(this, eVar, str, readableArray);
    }
}