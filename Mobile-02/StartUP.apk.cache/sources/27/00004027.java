package com.swmansion.rnscreens;

import com.facebook.react.uimanager.i0;
import com.facebook.react.views.view.ReactViewManager;
import com.swmansion.rnscreens.k;

@e.f.m.x.a.a(name = ScreenStackHeaderSubviewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ScreenStackHeaderSubviewManager extends ReactViewManager {
    protected static final String REACT_CLASS = "RNSScreenStackHeaderSubview";

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @com.facebook.react.uimanager.c1.a(name = "type")
    public void setType(k kVar, String str) {
        if ("left".equals(str)) {
            kVar.setType(k.a.LEFT);
        } else if ("center".equals(str)) {
            kVar.setType(k.a.CENTER);
        } else if ("right".equals(str)) {
            kVar.setType(k.a.RIGHT);
        } else if ("back".equals(str)) {
            kVar.setType(k.a.BACK);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public com.facebook.react.views.view.f createViewInstance(i0 i0Var) {
        return new k(i0Var);
    }
}