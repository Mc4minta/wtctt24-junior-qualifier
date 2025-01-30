package com.horcrux.svg;

import android.util.SparseArray;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.views.view.ReactViewManager;

/* loaded from: classes2.dex */
class SvgViewManager extends ReactViewManager {
    private static final String REACT_CLASS = "RNSVGSvgView";
    private static final SparseArray<f0> mTagToSvgView = new SparseArray<>();
    private static final SparseArray<Runnable> mTagToRunnable = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f0 getSvgViewByTag(int i2) {
        return mTagToSvgView.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void runWhenViewIsAvailable(int i2, Runnable runnable) {
        mTagToRunnable.put(i2, runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSvgView(int i2, f0 f0Var) {
        mTagToSvgView.put(i2, f0Var);
        SparseArray<Runnable> sparseArray = mTagToRunnable;
        Runnable runnable = sparseArray.get(i2);
        if (runnable != null) {
            runnable.run();
            sparseArray.delete(i2);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.f
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @com.facebook.react.uimanager.c1.a(name = "align")
    public void setAlign(f0 f0Var, String str) {
        f0Var.setAlign(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "bbHeight")
    public void setBbHeight(f0 f0Var, Dynamic dynamic) {
        f0Var.setBbHeight(dynamic);
    }

    @com.facebook.react.uimanager.c1.a(name = "bbWidth")
    public void setBbWidth(f0 f0Var, Dynamic dynamic) {
        f0Var.setBbWidth(dynamic);
    }

    @com.facebook.react.uimanager.c1.a(name = "color")
    public void setColor(f0 f0Var, Integer num) {
        f0Var.setTintColor(num);
    }

    @com.facebook.react.uimanager.c1.a(name = "meetOrSlice")
    public void setMeetOrSlice(f0 f0Var, int i2) {
        f0Var.setMeetOrSlice(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "minX")
    public void setMinX(f0 f0Var, float f2) {
        f0Var.setMinX(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "minY")
    public void setMinY(f0 f0Var, float f2) {
        f0Var.setMinY(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "tintColor")
    public void setTintColor(f0 f0Var, Integer num) {
        f0Var.setTintColor(num);
    }

    @com.facebook.react.uimanager.c1.a(name = "vbHeight")
    public void setVbHeight(f0 f0Var, float f2) {
        f0Var.setVbHeight(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "vbWidth")
    public void setVbWidth(f0 f0Var, float f2) {
        f0Var.setVbWidth(f2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(com.facebook.react.views.view.f fVar) {
        super.onDropViewInstance((SvgViewManager) fVar);
        mTagToSvgView.remove(fVar.getId());
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public f0 createViewInstance(com.facebook.react.uimanager.i0 i0Var) {
        return new f0(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void updateExtraData(com.facebook.react.views.view.f fVar, Object obj) {
        super.updateExtraData((SvgViewManager) fVar, obj);
        fVar.invalidate();
    }
}