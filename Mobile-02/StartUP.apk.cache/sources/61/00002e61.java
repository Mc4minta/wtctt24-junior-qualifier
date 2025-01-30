package com.facebook.react.modules.debug;

import com.facebook.fbreact.specs.NativeDevSettingsSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.g.c;

@e.f.m.x.a.a(name = DevSettingsModule.NAME)
/* loaded from: classes2.dex */
public class DevSettingsModule extends NativeDevSettingsSpec {
    public static final String NAME = "DevSettings";
    private final c mDevSupportManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DevSettingsModule.this.mDevSupportManager.f();
        }
    }

    /* loaded from: classes2.dex */
    class b implements com.facebook.react.devsupport.g.b {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }
    }

    public DevSettingsModule(ReactApplicationContext reactApplicationContext, c cVar) {
        super(reactApplicationContext);
        this.mDevSupportManager = cVar;
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void addListener(String str) {
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void addMenuItem(String str) {
        this.mDevSupportManager.i(str, new b(str));
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void onFastRefresh() {
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void reload() {
        if (this.mDevSupportManager.b()) {
            UiThreadUtil.runOnUiThread(new a());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void reloadWithReason(String str) {
        reload();
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void removeListeners(double d2) {
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void setHotLoadingEnabled(boolean z) {
        this.mDevSupportManager.c(z);
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void setIsDebuggingRemotely(boolean z) {
        this.mDevSupportManager.l(z);
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void setIsShakeToShowDevMenuEnabled(boolean z) {
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void setProfilingEnabled(boolean z) {
        this.mDevSupportManager.k(z);
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void toggleElementInspector() {
        this.mDevSupportManager.n();
    }
}