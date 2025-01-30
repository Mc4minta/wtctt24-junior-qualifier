package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i0;
import org.spongycastle.i18n.MessageBundle;

@e.f.m.x.a.a(name = ScreenStackHeaderConfigViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ScreenStackHeaderConfigViewManager extends ViewGroupManager<j> {
    protected static final String REACT_CLASS = "RNSScreenStackHeaderConfig";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.f
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @com.facebook.react.uimanager.c1.a(name = "backButtonInCustomView")
    public void setBackButtonInCustomView(j jVar, boolean z) {
        jVar.setBackButtonInCustomView(z);
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "color")
    public void setColor(j jVar, int i2) {
        jVar.setTintColor(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "direction")
    public void setDirection(j jVar, String str) {
        jVar.setDirection(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "hidden")
    public void setHidden(j jVar, boolean z) {
        jVar.setHidden(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "hideBackButton")
    public void setHideBackButton(j jVar, boolean z) {
        jVar.setHideBackButton(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "hideShadow")
    public void setHideShadow(j jVar, boolean z) {
        jVar.setHideShadow(z);
    }

    @com.facebook.react.uimanager.c1.a(name = MessageBundle.TITLE_ENTRY)
    public void setTitle(j jVar, String str) {
        jVar.setTitle(str);
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "titleColor")
    public void setTitleColor(j jVar, int i2) {
        jVar.setTitleColor(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "titleFontFamily")
    public void setTitleFontFamily(j jVar, String str) {
        jVar.setTitleFontFamily(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "titleFontSize")
    public void setTitleFontSize(j jVar, float f2) {
        jVar.setTitleFontSize(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "topInsetEnabled")
    public void setTopInsetEnabled(j jVar, boolean z) {
        jVar.setTopInsetEnabled(z);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(j jVar, View view, int i2) {
        if (view instanceof k) {
            jVar.c((k) view, i2);
            return;
        }
        throw new JSApplicationCausedNativeException("Config children should be of type RNSScreenStackHeaderSubview");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public j createViewInstance(i0 i0Var) {
        return new j(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(j jVar, int i2) {
        return jVar.e(i2);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(j jVar) {
        return jVar.getConfigSubviewsCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(j jVar) {
        super.onAfterUpdateTransaction((ScreenStackHeaderConfigViewManager) jVar);
        jVar.g();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(j jVar) {
        jVar.d();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeAllViews(j jVar) {
        jVar.h();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(j jVar, int i2) {
        jVar.i(i2);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(j jVar, int i2) {
        jVar.setBackgroundColor(i2);
    }
}