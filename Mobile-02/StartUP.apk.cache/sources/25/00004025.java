package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i0;

@e.f.m.x.a.a(name = ScreenContainerViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ScreenContainerViewManager extends ViewGroupManager<d> {
    protected static final String REACT_CLASS = "RNSScreenContainer";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.f
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(d dVar, View view, int i2) {
        if (view instanceof b) {
            dVar.f((b) view, i2);
            return;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type RNScreens");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public d createViewInstance(i0 i0Var) {
        return new d(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(d dVar, int i2) {
        return dVar.i(i2);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(d dVar) {
        return dVar.getScreenCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeAllViews(d dVar) {
        dVar.r();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(d dVar, int i2) {
        dVar.t(i2);
    }
}