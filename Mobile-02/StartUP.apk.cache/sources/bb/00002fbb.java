package com.facebook.react.views.picker;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ReactPickerItem.java */
/* loaded from: classes2.dex */
class c {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f5344b;

    public c(ReadableMap readableMap) {
        this.a = readableMap.getString("label");
        if (readableMap.hasKey("color") && !readableMap.isNull("color")) {
            this.f5344b = Integer.valueOf(readableMap.getInt("color"));
        } else {
            this.f5344b = null;
        }
    }

    public static List<c> a(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            arrayList.add(new c(readableArray.getMap(i2)));
        }
        return arrayList;
    }
}