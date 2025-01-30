package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: ReactStylesDiffMap.java */
/* loaded from: classes2.dex */
public class a0 {
    final ReadableMap a;

    public a0(ReadableMap readableMap) {
        this.a = readableMap;
    }

    public ReadableArray a(String str) {
        return this.a.getArray(str);
    }

    public boolean b(String str, boolean z) {
        return this.a.isNull(str) ? z : this.a.getBoolean(str);
    }

    public float c(String str, float f2) {
        return this.a.isNull(str) ? f2 : (float) this.a.getDouble(str);
    }

    public int d(String str, int i2) {
        return this.a.isNull(str) ? i2 : this.a.getInt(str);
    }

    public ReadableMap e(String str) {
        return this.a.getMap(str);
    }

    public String f(String str) {
        return this.a.getString(str);
    }

    public boolean g(String str) {
        return this.a.hasKey(str);
    }

    public String toString() {
        return "{ " + a0.class.getSimpleName() + ": " + this.a.toString() + " }";
    }
}