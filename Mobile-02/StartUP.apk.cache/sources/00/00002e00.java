package com.facebook.react.fabric;

import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.soloader.SoLoader;

/* compiled from: FabricSoLoader.java */
/* loaded from: classes2.dex */
public class b {
    private static volatile boolean a;

    public static void a() {
        if (a) {
            return;
        }
        com.facebook.systrace.a.c(0L, "FabricSoLoader.staticInit::load:fabricjni");
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_START);
        SoLoader.j("fabricjni");
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_END);
        com.facebook.systrace.a.g(0L);
        a = true;
    }
}