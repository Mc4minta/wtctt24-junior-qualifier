package com.facebook.react.views.modal;

import android.content.DialogInterface;
import android.graphics.Point;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.a0;
import com.facebook.react.uimanager.h;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.w0;
import com.facebook.react.views.modal.d;
import e.f.m.a0.o;
import e.f.m.a0.p;
import java.util.Map;

@e.f.m.x.a.a(name = ReactModalHostManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactModalHostManager extends ViewGroupManager<d> implements p<d> {
    public static final String REACT_CLASS = "RCTModalHostView";
    private final w0<d> mDelegate = new o(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements d.c {
        final /* synthetic */ com.facebook.react.uimanager.events.d a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f5318b;

        a(com.facebook.react.uimanager.events.d dVar, d dVar2) {
            this.a = dVar;
            this.f5318b = dVar2;
        }

        @Override // com.facebook.react.views.modal.d.c
        public void a(DialogInterface dialogInterface) {
            this.a.v(new e(this.f5318b.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnShowListener {
        final /* synthetic */ com.facebook.react.uimanager.events.d a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f5320b;

        b(com.facebook.react.uimanager.events.d dVar, d dVar2) {
            this.a = dVar;
            this.f5320b = dVar2;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.a.v(new f(this.f5320b.getId()));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public w0<d> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return com.facebook.react.common.c.a().b("topRequestClose", com.facebook.react.common.c.d("registrationName", "onRequestClose")).b("topShow", com.facebook.react.common.c.d("registrationName", "onShow")).a();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public Class<? extends h> getShadowNodeClass() {
        return com.facebook.react.views.modal.b.class;
    }

    @Override // e.f.m.a0.p
    public void setAnimated(d dVar, boolean z) {
    }

    @Override // e.f.m.a0.p
    public void setIdentifier(d dVar, int i2) {
    }

    @Override // e.f.m.a0.p
    public void setPresentationStyle(d dVar, String str) {
    }

    @Override // e.f.m.a0.p
    public void setSupportedOrientations(d dVar, ReadableArray readableArray) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(i0 i0Var, d dVar) {
        com.facebook.react.uimanager.events.d eventDispatcher = ((UIManagerModule) i0Var.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        dVar.setOnRequestCloseListener(new a(eventDispatcher, dVar));
        dVar.setOnShowListener(new b(eventDispatcher, dVar));
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public h createShadowNodeInstance() {
        return new com.facebook.react.views.modal.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public d createViewInstance(i0 i0Var) {
        return new d(i0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(d dVar) {
        super.onAfterUpdateTransaction((ReactModalHostManager) dVar);
        dVar.d();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(d dVar) {
        super.onDropViewInstance((ReactModalHostManager) dVar);
        dVar.c();
    }

    @Override // e.f.m.a0.p
    @com.facebook.react.uimanager.c1.a(name = "animationType")
    public void setAnimationType(d dVar, String str) {
        if (str != null) {
            dVar.setAnimationType(str);
        }
    }

    @Override // e.f.m.a0.p
    @com.facebook.react.uimanager.c1.a(name = "hardwareAccelerated")
    public void setHardwareAccelerated(d dVar, boolean z) {
        dVar.setHardwareAccelerated(z);
    }

    @Override // e.f.m.a0.p
    @com.facebook.react.uimanager.c1.a(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(d dVar, boolean z) {
        dVar.setStatusBarTranslucent(z);
    }

    @Override // e.f.m.a0.p
    @com.facebook.react.uimanager.c1.a(name = "transparent")
    public void setTransparent(d dVar, boolean z) {
        dVar.setTransparent(z);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(d dVar, a0 a0Var, h0 h0Var) {
        Point a2 = com.facebook.react.views.modal.a.a(dVar.getContext());
        dVar.f(h0Var, a2.x, a2.y);
        return null;
    }
}