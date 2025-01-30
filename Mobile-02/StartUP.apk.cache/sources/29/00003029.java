package com.facebook.react.views.unimplementedview;

import com.coinbase.ApiConstants;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i0;

@e.f.m.x.a.a(name = ReactUnimplementedViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactUnimplementedViewManager extends ViewGroupManager<a> {
    public static final String REACT_CLASS = "UnimplementedNativeView";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @com.facebook.react.uimanager.c1.a(name = ApiConstants.NAME)
    public void setName(a aVar, String str) {
        aVar.setName(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public a createViewInstance(i0 i0Var) {
        return new a(i0Var);
    }
}