package com.swmansion.rnscreens;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i0;
import com.swmansion.rnscreens.b;
import java.util.Map;
import org.apache.http.client.config.CookieSpecs;

@e.f.m.x.a.a(name = ScreenViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ScreenViewManager extends ViewGroupManager<b> {
    protected static final String REACT_CLASS = "RNSScreen";

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return com.facebook.react.common.c.i("topDismissed", com.facebook.react.common.c.d("registrationName", "onDismissed"), "topWillAppear", com.facebook.react.common.c.d("registrationName", "onWillAppear"), "topAppear", com.facebook.react.common.c.d("registrationName", "onAppear"), "topWillDisappear", com.facebook.react.common.c.d("registrationName", "onWillDisappear"), "topDisappear", com.facebook.react.common.c.d("registrationName", "onDisappear"), "topFinishTransitioning", com.facebook.react.common.c.d("registrationName", "onFinishTransitioning"));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = 0.0f, name = AppStateModule.APP_STATE_ACTIVE)
    public void setActive(b bVar, float f2) {
        bVar.setActive(f2 != 0.0f);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "gestureEnabled")
    public void setGestureEnabled(b bVar, boolean z) {
        bVar.setGestureEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "replaceAnimation")
    public void setReplaceAnimation(b bVar, String str) {
        if (str != null && !"pop".equals(str)) {
            if ("push".equals(str)) {
                bVar.setReplaceAnimation(b.c.PUSH);
                return;
            }
            return;
        }
        bVar.setReplaceAnimation(b.c.POP);
    }

    @com.facebook.react.uimanager.c1.a(name = "stackAnimation")
    public void setStackAnimation(b bVar, String str) {
        if (str != null && !CookieSpecs.DEFAULT.equals(str)) {
            if ("none".equals(str)) {
                bVar.setStackAnimation(b.d.NONE);
                return;
            } else if ("fade".equals(str)) {
                bVar.setStackAnimation(b.d.FADE);
                return;
            } else {
                return;
            }
        }
        bVar.setStackAnimation(b.d.DEFAULT);
    }

    @com.facebook.react.uimanager.c1.a(name = "stackPresentation")
    public void setStackPresentation(b bVar, String str) {
        if ("push".equals(str)) {
            bVar.setStackPresentation(b.e.PUSH);
        } else if (!"modal".equals(str) && !"containedModal".equals(str) && !"fullScreenModal".equals(str) && !"formSheet".equals(str)) {
            if (!"transparentModal".equals(str) && !"containedTransparentModal".equals(str)) {
                throw new JSApplicationIllegalArgumentException("Unknown presentation type " + str);
            }
            bVar.setStackPresentation(b.e.TRANSPARENT_MODAL);
        } else {
            bVar.setStackPresentation(b.e.MODAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public b createViewInstance(i0 i0Var) {
        return new b(i0Var);
    }
}