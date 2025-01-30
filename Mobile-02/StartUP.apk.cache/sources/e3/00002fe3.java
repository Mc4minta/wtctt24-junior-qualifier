package com.facebook.react.views.text;

import android.view.View;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.i0;

@e.f.m.x.a.a(name = ReactRawTextManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactRawTextManager extends ViewManager<View, k> {
    public static final String REACT_CLASS = "RCTRawText";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<? extends k> getShadowNodeClass() {
        return k.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(View view, Object obj) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public k createShadowNodeInstance() {
        return new k();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public View createViewInstance(i0 i0Var) {
        throw new IllegalStateException("Attempt to create a native view for RCTRawText");
    }
}