package com.swmansion.reanimated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public class e {
    public static int[] a(ReadableArray readableArray) {
        int size = readableArray.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = readableArray.getInt(i2);
        }
        return iArr;
    }

    public static Map<String, Integer> b(ReadableMap readableMap) {
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        HashMap hashMap = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            hashMap.put(nextKey, Integer.valueOf(readableMap.getInt(nextKey)));
        }
        return hashMap;
    }
}