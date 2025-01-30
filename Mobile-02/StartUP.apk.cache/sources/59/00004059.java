package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.o;
import java.util.Map;

/* compiled from: SerializationUtils.java */
/* loaded from: classes2.dex */
class l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Float> a(a aVar) {
        return com.facebook.react.common.c.g("top", Float.valueOf(o.a(aVar.a)), "right", Float.valueOf(o.a(aVar.f11051b)), "bottom", Float.valueOf(o.a(aVar.f11052c)), "left", Float.valueOf(o.a(aVar.f11053d)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WritableMap b(a aVar) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("top", o.a(aVar.a));
        createMap.putDouble("right", o.a(aVar.f11051b));
        createMap.putDouble("bottom", o.a(aVar.f11052c));
        createMap.putDouble("left", o.a(aVar.f11053d));
        return createMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Float> c(c cVar) {
        return com.facebook.react.common.c.g("x", Float.valueOf(o.a(cVar.a)), "y", Float.valueOf(o.a(cVar.f11056b)), "width", Float.valueOf(o.a(cVar.f11057c)), "height", Float.valueOf(o.a(cVar.f11058d)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WritableMap d(c cVar) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("x", o.a(cVar.a));
        createMap.putDouble("y", o.a(cVar.f11056b));
        createMap.putDouble("width", o.a(cVar.f11057c));
        createMap.putDouble("height", o.a(cVar.f11058d));
        return createMap;
    }
}