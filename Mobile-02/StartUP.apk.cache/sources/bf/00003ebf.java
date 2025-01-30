package com.reactnativecommunity.clipboard;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import e.f.m.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ClipboardPackage.java */
/* loaded from: classes2.dex */
public class a implements p {
    @Override // e.f.m.p
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ClipboardModule(reactApplicationContext));
        return arrayList;
    }

    @Override // e.f.m.p
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}