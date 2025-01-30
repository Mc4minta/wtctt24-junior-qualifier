package com.facebook.react.uimanager;

import android.widget.ImageView;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UIManagerModuleConstants.java */
/* loaded from: classes2.dex */
class p0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map a() {
        return com.facebook.react.common.c.a().b("topChange", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.e("bubbled", "onChange", "captured", "onChangeCapture"))).b("topSelect", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.e("bubbled", "onSelect", "captured", "onSelectCapture"))).b(com.facebook.react.uimanager.events.i.h(com.facebook.react.uimanager.events.i.START), com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.e("bubbled", "onTouchStart", "captured", "onTouchStartCapture"))).b(com.facebook.react.uimanager.events.i.h(com.facebook.react.uimanager.events.i.MOVE), com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.e("bubbled", "onTouchMove", "captured", "onTouchMoveCapture"))).b(com.facebook.react.uimanager.events.i.h(com.facebook.react.uimanager.events.i.END), com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.e("bubbled", "onTouchEnd", "captured", "onTouchEndCapture"))).b(com.facebook.react.uimanager.events.i.h(com.facebook.react.uimanager.events.i.CANCEL), com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.e("bubbled", "onTouchCancel", "captured", "onTouchCancelCapture"))).a();
    }

    public static Map<String, Object> b() {
        HashMap b2 = com.facebook.react.common.c.b();
        b2.put("UIView", com.facebook.react.common.c.d("ContentMode", com.facebook.react.common.c.f("ScaleAspectFit", Integer.valueOf(ImageView.ScaleType.FIT_CENTER.ordinal()), "ScaleAspectFill", Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), "ScaleAspectCenter", Integer.valueOf(ImageView.ScaleType.CENTER_INSIDE.ordinal()))));
        b2.put("StyleConstants", com.facebook.react.common.c.d("PointerEventsValues", com.facebook.react.common.c.g("none", Integer.valueOf(p.NONE.ordinal()), "boxNone", Integer.valueOf(p.BOX_NONE.ordinal()), "boxOnly", Integer.valueOf(p.BOX_ONLY.ordinal()), "unspecified", Integer.valueOf(p.AUTO.ordinal()))));
        b2.put("PopupMenu", com.facebook.react.common.c.e("dismissed", "dismissed", "itemSelected", "itemSelected"));
        b2.put("AccessibilityEventTypes", com.facebook.react.common.c.f("typeWindowStateChanged", 32, "typeViewFocused", 8, "typeViewClicked", 1));
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map c() {
        return com.facebook.react.common.c.a().b("topContentSizeChange", com.facebook.react.common.c.d("registrationName", "onContentSizeChange")).b("topLayout", com.facebook.react.common.c.d("registrationName", "onLayout")).b("topLoadingError", com.facebook.react.common.c.d("registrationName", "onLoadingError")).b("topLoadingFinish", com.facebook.react.common.c.d("registrationName", "onLoadingFinish")).b("topLoadingStart", com.facebook.react.common.c.d("registrationName", "onLoadingStart")).b("topSelectionChange", com.facebook.react.common.c.d("registrationName", "onSelectionChange")).b("topMessage", com.facebook.react.common.c.d("registrationName", "onMessage")).b("topClick", com.facebook.react.common.c.d("registrationName", "onClick")).b("topScrollBeginDrag", com.facebook.react.common.c.d("registrationName", "onScrollBeginDrag")).b("topScrollEndDrag", com.facebook.react.common.c.d("registrationName", "onScrollEndDrag")).b("topScroll", com.facebook.react.common.c.d("registrationName", "onScroll")).b("topMomentumScrollBegin", com.facebook.react.common.c.d("registrationName", "onMomentumScrollBegin")).b("topMomentumScrollEnd", com.facebook.react.common.c.d("registrationName", "onMomentumScrollEnd")).a();
    }
}