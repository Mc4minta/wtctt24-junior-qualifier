package com.facebook.react.uimanager;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

/* compiled from: TransformHelper.java */
/* loaded from: classes2.dex */
public class k0 {
    private static ThreadLocal<double[]> a = new a();

    /* compiled from: TransformHelper.java */
    /* loaded from: classes2.dex */
    static class a extends ThreadLocal<double[]> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public double[] initialValue() {
            return new double[16];
        }
    }

    private static double a(ReadableMap readableMap, String str) {
        double d2;
        boolean z = true;
        if (readableMap.getType(str) == ReadableType.String) {
            String string = readableMap.getString(str);
            if (string.endsWith("rad")) {
                string = string.substring(0, string.length() - 3);
            } else if (string.endsWith("deg")) {
                string = string.substring(0, string.length() - 3);
                z = false;
            }
            d2 = Float.parseFloat(string);
        } else {
            d2 = readableMap.getDouble(str);
        }
        return z ? d2 : i.l(d2);
    }

    public static void b(ReadableArray readableArray, double[] dArr) {
        double[] dArr2 = a.get();
        i.r(dArr);
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map = readableArray.getMap(i2);
            String nextKey = map.keySetIterator().nextKey();
            i.r(dArr2);
            if ("matrix".equals(nextKey)) {
                ReadableArray array = map.getArray(nextKey);
                for (int i3 = 0; i3 < 16; i3++) {
                    dArr2[i3] = array.getDouble(i3);
                }
            } else if ("perspective".equals(nextKey)) {
                i.a(dArr2, map.getDouble(nextKey));
            } else if ("rotateX".equals(nextKey)) {
                i.b(dArr2, a(map, nextKey));
            } else if ("rotateY".equals(nextKey)) {
                i.c(dArr2, a(map, nextKey));
            } else if (!"rotate".equals(nextKey) && !"rotateZ".equals(nextKey)) {
                if ("scale".equals(nextKey)) {
                    double d2 = map.getDouble(nextKey);
                    i.e(dArr2, d2);
                    i.f(dArr2, d2);
                } else if ("scaleX".equals(nextKey)) {
                    i.e(dArr2, map.getDouble(nextKey));
                } else if ("scaleY".equals(nextKey)) {
                    i.f(dArr2, map.getDouble(nextKey));
                } else if ("translate".equals(nextKey)) {
                    ReadableArray array2 = map.getArray(nextKey);
                    i.j(dArr2, array2.getDouble(0), array2.getDouble(1), array2.size() > 2 ? array2.getDouble(2) : 0.0d);
                } else if ("translateX".equals(nextKey)) {
                    i.i(dArr2, map.getDouble(nextKey), 0.0d);
                } else if ("translateY".equals(nextKey)) {
                    i.i(dArr2, 0.0d, map.getDouble(nextKey));
                } else if ("skewX".equals(nextKey)) {
                    i.g(dArr2, a(map, nextKey));
                } else if ("skewY".equals(nextKey)) {
                    i.h(dArr2, a(map, nextKey));
                } else {
                    throw new JSApplicationIllegalArgumentException("Unsupported transform type: " + nextKey);
                }
            } else {
                i.d(dArr2, a(map, nextKey));
            }
            i.p(dArr, dArr, dArr2);
        }
    }
}