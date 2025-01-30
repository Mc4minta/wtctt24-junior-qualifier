package com.facebook.react.views.scroll;

import com.facebook.react.uimanager.i0;
import com.facebook.react.views.view.ReactClippingViewManager;

@e.f.m.x.a.a(name = ReactHorizontalScrollContainerViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactHorizontalScrollContainerViewManager extends ReactClippingViewManager<c> {
    public static final String REACT_CLASS = "AndroidHorizontalScrollContentView";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public c createViewInstance(i0 i0Var) {
        return new c(i0Var);
    }
}