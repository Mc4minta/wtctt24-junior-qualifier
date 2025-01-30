package com.swmansion.rnscreens;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i0;

@e.f.m.x.a.a(name = ScreenStackViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ScreenStackViewManager extends ViewGroupManager<h> {
    protected static final String REACT_CLASS = "RNSScreenStack";

    private void prepareOutTransition(b bVar) {
        startTransitionRecursive(bVar);
    }

    private void startTransitionRecursive(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            viewGroup.startViewTransition(childAt);
            if (childAt instanceof ViewGroup) {
                startTransitionRecursive((ViewGroup) childAt);
            }
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.f
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(h hVar, View view, int i2) {
        if (view instanceof b) {
            hVar.f((b) view, i2);
            return;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type RNScreen");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public h createViewInstance(i0 i0Var) {
        return new h(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(h hVar, int i2) {
        return hVar.i(i2);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(h hVar) {
        return hVar.getScreenCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(h hVar, int i2) {
        prepareOutTransition(hVar.i(i2));
        hVar.t(i2);
    }
}