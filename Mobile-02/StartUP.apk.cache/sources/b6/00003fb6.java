package com.swmansion.gesturehandler.react;

import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i0;
import java.util.Map;

@e.f.m.x.a.a(name = RNGestureHandlerRootViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class RNGestureHandlerRootViewManager extends ViewGroupManager<h> {
    public static final String REACT_CLASS = "GestureHandlerRootView";

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return com.facebook.react.common.c.e("onGestureHandlerEvent", com.facebook.react.common.c.d("registrationName", "onGestureHandlerEvent"), "onGestureHandlerStateChange", com.facebook.react.common.c.d("registrationName", "onGestureHandlerStateChange"));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public h createViewInstance(i0 i0Var) {
        return new h(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(h hVar) {
        hVar.z();
    }
}