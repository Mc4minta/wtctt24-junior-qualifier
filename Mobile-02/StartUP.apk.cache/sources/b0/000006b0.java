package com.airbnb.android.react.lottie;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import e.f.m.p;
import java.util.Collections;
import java.util.List;

/* compiled from: LottiePackage.java */
/* loaded from: classes.dex */
public class b implements p {
    @Override // e.f.m.p
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    @Override // e.f.m.p
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(new LottieAnimationViewManager());
    }
}