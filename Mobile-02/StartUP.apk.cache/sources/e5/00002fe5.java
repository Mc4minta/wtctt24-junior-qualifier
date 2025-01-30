package com.facebook.react.views.text;

import android.content.Context;
import android.text.Spannable;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.i0;
import java.util.Map;

@e.f.m.x.a.a(name = ReactTextViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactTextViewManager extends ReactTextAnchorViewManager<r, p> implements com.facebook.react.uimanager.f {
    public static final String REACT_CLASS = "RCTText";
    protected s mReactTextViewManagerCallback;

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return com.facebook.react.common.c.e("topTextLayout", com.facebook.react.common.c.d("registrationName", "onTextLayout"), "topInlineViewLayout", com.facebook.react.common.c.d("registrationName", "onInlineViewLayout"));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<p> getShadowNodeClass() {
        return p.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, com.facebook.yoga.n nVar, float f3, com.facebook.yoga.n nVar2, int[] iArr) {
        return b0.d(context, readableMap, readableMap2, f2, nVar, f3, nVar2, this.mReactTextViewManagerCallback, iArr);
    }

    @Override // com.facebook.react.uimanager.f
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public p createShadowNodeInstance() {
        return new p();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public r createViewInstance(i0 i0Var) {
        return new r(i0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(r rVar) {
        super.onAfterUpdateTransaction((ReactTextViewManager) rVar);
        rVar.l();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void setPadding(r rVar, int i2, int i3, int i4, int i5) {
        rVar.setPadding(i2, i3, i4, i5);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(r rVar, Object obj) {
        q qVar = (q) obj;
        if (qVar.b()) {
            z.g(qVar.k(), rVar);
        }
        rVar.setText(qVar);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(r rVar, com.facebook.react.uimanager.a0 a0Var, h0 h0Var) {
        ReadableNativeMap state = h0Var.getState();
        ReadableNativeMap map = state.getMap("attributedString");
        ReadableNativeMap map2 = state.getMap("paragraphAttributes");
        Spannable c2 = b0.c(rVar.getContext(), map, this.mReactTextViewManagerCallback);
        rVar.setSpanned(c2);
        return new q(c2, state.hasKey("mostRecentEventCount") ? state.getInt("mostRecentEventCount") : -1, false, x.i(a0Var), x.j(map2.getString("textBreakStrategy")), x.f(a0Var));
    }

    public p createShadowNodeInstance(s sVar) {
        return new p(sVar);
    }
}