package com.facebook.react.views.scroll;

import android.util.DisplayMetrics;
import c.h.k.v;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.a0;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.o;
import com.facebook.react.views.scroll.f;
import java.util.ArrayList;

@e.f.m.x.a.a(name = ReactHorizontalScrollViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactHorizontalScrollViewManager extends ViewGroupManager<d> implements f.a<d> {
    public static final String REACT_CLASS = "AndroidHorizontalScrollView";
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    private a mFpsListener;

    public ReactHorizontalScrollViewManager() {
        this(null);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @com.facebook.react.uimanager.c1.b(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(d dVar, int i2, Integer num) {
        dVar.y(SPACING_TYPES[i2], num == null ? Float.NaN : num.intValue() & 16777215, num != null ? num.intValue() >>> 24 : Float.NaN);
    }

    @com.facebook.react.uimanager.c1.b(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(d dVar, int i2, float f2) {
        if (!com.facebook.yoga.g.a(f2)) {
            f2 = o.c(f2);
        }
        if (i2 == 0) {
            dVar.setBorderRadius(f2);
        } else {
            dVar.z(f2, i2 - 1);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "borderStyle")
    public void setBorderStyle(d dVar, String str) {
        dVar.setBorderStyle(str);
    }

    @com.facebook.react.uimanager.c1.b(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(d dVar, int i2, float f2) {
        if (!com.facebook.yoga.g.a(f2)) {
            f2 = o.c(f2);
        }
        dVar.A(SPACING_TYPES[i2], f2);
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", defaultInt = 0, name = "endFillColor")
    public void setBottomFillColor(d dVar, int i2) {
        dVar.setEndFillColor(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "decelerationRate")
    public void setDecelerationRate(d dVar, float f2) {
        dVar.setDecelerationRate(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "disableIntervalMomentum")
    public void setDisableIntervalMomentum(d dVar, boolean z) {
        dVar.setDisableIntervalMomentum(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "fadingEdgeLength")
    public void setFadingEdgeLength(d dVar, int i2) {
        if (i2 > 0) {
            dVar.setHorizontalFadingEdgeEnabled(true);
            dVar.setFadingEdgeLength(i2);
            return;
        }
        dVar.setHorizontalFadingEdgeEnabled(false);
        dVar.setFadingEdgeLength(0);
    }

    @com.facebook.react.uimanager.c1.a(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(d dVar, boolean z) {
        v.v0(dVar, z);
    }

    @com.facebook.react.uimanager.c1.a(name = "overScrollMode")
    public void setOverScrollMode(d dVar, String str) {
        dVar.setOverScrollMode(g.h(str));
    }

    @com.facebook.react.uimanager.c1.a(name = "overflow")
    public void setOverflow(d dVar, String str) {
        dVar.setOverflow(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "pagingEnabled")
    public void setPagingEnabled(d dVar, boolean z) {
        dVar.setPagingEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "persistentScrollbar")
    public void setPersistentScrollbar(d dVar, boolean z) {
        dVar.setScrollbarFadingEnabled(!z);
    }

    @com.facebook.react.uimanager.c1.a(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(d dVar, boolean z) {
        dVar.setRemoveClippedSubviews(z);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(d dVar, boolean z) {
        dVar.setScrollEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "scrollPerfTag")
    public void setScrollPerfTag(d dVar, String str) {
        dVar.setScrollPerfTag(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "sendMomentumEvents")
    public void setSendMomentumEvents(d dVar, boolean z) {
        dVar.setSendMomentumEvents(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(d dVar, boolean z) {
        dVar.setHorizontalScrollBarEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "snapToEnd")
    public void setSnapToEnd(d dVar, boolean z) {
        dVar.setSnapToEnd(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "snapToInterval")
    public void setSnapToInterval(d dVar, float f2) {
        dVar.setSnapInterval((int) (f2 * com.facebook.react.uimanager.c.e().density));
    }

    @com.facebook.react.uimanager.c1.a(name = "snapToOffsets")
    public void setSnapToOffsets(d dVar, ReadableArray readableArray) {
        DisplayMetrics e2 = com.facebook.react.uimanager.c.e();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            arrayList.add(Integer.valueOf((int) (readableArray.getDouble(i2) * e2.density)));
        }
        dVar.setSnapOffsets(arrayList);
    }

    @com.facebook.react.uimanager.c1.a(name = "snapToStart")
    public void setSnapToStart(d dVar, boolean z) {
        dVar.setSnapToStart(z);
    }

    public ReactHorizontalScrollViewManager(a aVar) {
        this.mFpsListener = null;
        this.mFpsListener = aVar;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public d createViewInstance(i0 i0Var) {
        return new d(i0Var, this.mFpsListener);
    }

    @Override // com.facebook.react.views.scroll.f.a
    public void flashScrollIndicators(d dVar) {
        dVar.m();
    }

    @Override // com.facebook.react.views.scroll.f.a
    public void scrollTo(d dVar, f.b bVar) {
        if (bVar.f5377c) {
            dVar.w(bVar.a, bVar.f5376b);
        } else {
            dVar.v(bVar.a, bVar.f5376b);
        }
    }

    @Override // com.facebook.react.views.scroll.f.a
    public void scrollToEnd(d dVar, f.c cVar) {
        int width = dVar.getChildAt(0).getWidth() + dVar.getPaddingRight();
        if (cVar.a) {
            dVar.w(width, dVar.getScrollY());
        } else {
            dVar.v(width, dVar.getScrollY());
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(d dVar, a0 a0Var, h0 h0Var) {
        dVar.D(h0Var);
        return null;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(d dVar, int i2, ReadableArray readableArray) {
        f.b(this, dVar, i2, readableArray);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(d dVar, String str, ReadableArray readableArray) {
        f.c(this, dVar, str, readableArray);
    }
}