package com.th3rdwave.safeareacontext;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i0;
import com.th3rdwave.safeareacontext.e;
import java.util.Map;

/* loaded from: classes2.dex */
public class SafeAreaProviderManager extends ViewGroupManager<e> {
    private final ReactApplicationContext mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements e.a {
        final /* synthetic */ com.facebook.react.uimanager.events.d a;

        a(com.facebook.react.uimanager.events.d dVar) {
            this.a = dVar;
        }

        @Override // com.th3rdwave.safeareacontext.e.a
        public void a(e eVar, com.th3rdwave.safeareacontext.a aVar, c cVar) {
            this.a.v(new b(eVar.getId(), aVar, cVar));
        }
    }

    public SafeAreaProviderManager(ReactApplicationContext reactApplicationContext) {
        this.mContext = reactApplicationContext;
    }

    private Map<String, Object> getInitialWindowMetrics() {
        ViewGroup viewGroup;
        Activity currentActivity = this.mContext.getCurrentActivity();
        if (currentActivity == null || (viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView()) == null) {
            return null;
        }
        View findViewById = viewGroup.findViewById(16908290);
        com.th3rdwave.safeareacontext.a c2 = f.c(viewGroup);
        c a2 = f.a(viewGroup, findViewById);
        if (c2 == null || a2 == null) {
            return null;
        }
        return com.facebook.react.common.c.e("insets", l.a(c2), "frame", l.c(a2));
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return com.facebook.react.common.c.a().b("topInsetsChange", com.facebook.react.common.c.d("registrationName", "onInsetsChange")).a();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedViewConstants() {
        return com.facebook.react.common.c.d("initialWindowMetrics", getInitialWindowMetrics());
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNCSafeAreaProvider";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(i0 i0Var, e eVar) {
        eVar.setOnInsetsChangeListener(new a(((UIManagerModule) i0Var.getNativeModule(UIManagerModule.class)).getEventDispatcher()));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public e createViewInstance(i0 i0Var) {
        return new e(i0Var);
    }
}