package com.zoontek.rnlocalize;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import e.f.m.p;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: RNLocalizePackage.java */
/* loaded from: classes2.dex */
public class a implements p {
    @Override // e.f.m.p
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RNLocalizeModule(reactApplicationContext));
    }

    @Override // e.f.m.p
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}