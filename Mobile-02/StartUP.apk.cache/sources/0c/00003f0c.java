package com.rumax.reactnative.pdfviewer;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.i0;
import java.util.Map;

/* loaded from: classes2.dex */
public class PDFViewManager extends SimpleViewManager<c> {
    private static final int COMMAND_RELOAD = 1;
    private static final String EVENT_BUBBLED = "bubbled";
    private static final String REACT_CLASS = "PDFView";

    PDFViewManager(ReactApplicationContext reactApplicationContext) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return com.facebook.react.common.c.d("reload", 1);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return com.facebook.react.common.c.a().b("onLoad", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.d(EVENT_BUBBLED, "onLoad"))).b("onError", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.d(EVENT_BUBBLED, "onError"))).b("onPageChanged", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.d(EVENT_BUBBLED, "onPageChanged"))).b("onScrolled", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.d(EVENT_BUBBLED, "onScrolled"))).a();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @com.facebook.react.uimanager.c1.a(name = "enableAnnotations")
    public void setEnableAnnotations(c cVar, boolean z) {
        cVar.p(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "fadeInDuration")
    public void setFadeInDuration(c cVar, int i2) {
        cVar.q(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "fileFrom")
    public void setFileFrom(c cVar, String str) {
    }

    @com.facebook.react.uimanager.c1.a(name = "resource")
    public void setResource(c cVar, String str) {
        cVar.r(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "resourceType")
    public void setResourceType(c cVar, String str) {
        cVar.s(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "textEncoding")
    public void setTextEncoding(c cVar, String str) {
    }

    @com.facebook.react.uimanager.c1.a(name = "urlProps")
    public void setUrlProps(c cVar, ReadableMap readableMap) {
        cVar.t(readableMap);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public c createViewInstance(i0 i0Var) {
        return new c(i0Var);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(c cVar) {
        super.onAfterUpdateTransaction((PDFViewManager) cVar);
        cVar.l();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(c cVar) {
        cVar.g();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(c cVar, int i2, ReadableArray readableArray) {
        if (i2 != 1) {
            return;
        }
        cVar.k();
    }
}