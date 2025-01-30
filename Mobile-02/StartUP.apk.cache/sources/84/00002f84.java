package com.facebook.react.views.art;

import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.i0;
import com.facebook.yoga.m;
import com.facebook.yoga.n;
import com.facebook.yoga.p;

@e.f.m.x.a.a(name = ARTSurfaceViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ARTSurfaceViewManager extends BaseViewManager<c, d> {
    private static final m MEASURE_FUNCTION = new a();
    public static final String REACT_CLASS = "ARTSurfaceView";

    /* loaded from: classes2.dex */
    static class a implements m {
        a() {
        }

        @Override // com.facebook.yoga.m
        public long T(p pVar, float f2, n nVar, float f3, n nVar2) {
            throw new IllegalStateException("SurfaceView should have explicit width and height set");
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<d> getShadowNodeClass() {
        return d.class;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
    public void setBackgroundColor(c cVar, int i2) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public d createShadowNodeInstance() {
        d dVar = new d();
        dVar.R0(MEASURE_FUNCTION);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public c createViewInstance(i0 i0Var) {
        return new c(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(c cVar, Object obj) {
        ((d) obj).q1(cVar);
    }
}