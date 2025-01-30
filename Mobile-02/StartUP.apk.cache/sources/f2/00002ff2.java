package com.facebook.react.views.text.frescosupport;

import android.view.View;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.i0;
import e.f.h.a.a.c;

@e.f.m.x.a.a(name = FrescoBasedReactTextInlineImageViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class FrescoBasedReactTextInlineImageViewManager extends ViewManager<View, a> {
    public static final String REACT_CLASS = "RCTTextInlineImage";
    private final Object mCallerContext;
    private final e.f.h.c.b mDraweeControllerBuilder;

    public FrescoBasedReactTextInlineImageViewManager() {
        this(null, null);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public View createViewInstance(i0 i0Var) {
        throw new IllegalStateException("RCTTextInlineImage doesn't map into a native view");
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<? extends a> getShadowNodeClass() {
        return a.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(View view, Object obj) {
    }

    public FrescoBasedReactTextInlineImageViewManager(e.f.h.c.b bVar, Object obj) {
        this.mDraweeControllerBuilder = bVar;
        this.mCallerContext = obj;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public a createShadowNodeInstance() {
        e.f.h.c.b bVar = this.mDraweeControllerBuilder;
        if (bVar == null) {
            bVar = c.h();
        }
        return new a(bVar, this.mCallerContext);
    }
}