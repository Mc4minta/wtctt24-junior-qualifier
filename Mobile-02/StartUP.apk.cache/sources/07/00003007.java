package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import java.util.ArrayList;

/* compiled from: ReactTypefaceUtils.java */
/* loaded from: classes2.dex */
public class t {
    public static Typeface a(Typeface typeface, int i2, int i3, String str, AssetManager assetManager) {
        int i4 = 0;
        int style = typeface == null ? 0 : typeface.getStyle();
        if (i3 == 1 || ((style & 1) != 0 && i3 == -1)) {
            i4 = 1;
        }
        if (i2 == 2 || ((style & 2) != 0 && i2 == -1)) {
            i4 |= 2;
        }
        if (str != null) {
            typeface = i.c().d(str, i4, i3, assetManager);
        } else if (typeface != null) {
            typeface = Typeface.create(typeface, i4);
        }
        return typeface != null ? typeface : Typeface.defaultFromStyle(i4);
    }

    public static int b(String str) {
        if ("italic".equals(str)) {
            return 2;
        }
        return "normal".equals(str) ? 0 : -1;
    }

    public static String c(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            String string = readableArray.getString(i2);
            if (string != null) {
                char c2 = 65535;
                switch (string.hashCode()) {
                    case -1195362251:
                        if (string.equals("proportional-nums")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1061392823:
                        if (string.equals("lining-nums")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -771984547:
                        if (string.equals("tabular-nums")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -659678800:
                        if (string.equals("oldstyle-nums")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1183323111:
                        if (string.equals("small-caps")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        arrayList.add("'pnum'");
                        continue;
                    case 1:
                        arrayList.add("'lnum'");
                        continue;
                    case 2:
                        arrayList.add("'tnum'");
                        continue;
                    case 3:
                        arrayList.add("'onum'");
                        continue;
                    case 4:
                        arrayList.add("'smcp'");
                        continue;
                }
            }
        }
        return TextUtils.join(", ", arrayList);
    }

    public static int d(String str) {
        int e2 = str != null ? e(str) : -1;
        if (e2 == -1) {
            e2 = 0;
        }
        if (e2 == 700 || "bold".equals(str)) {
            return 1;
        }
        if (e2 == 400 || "normal".equals(str)) {
            return 0;
        }
        return e2;
    }

    private static int e(String str) {
        if (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') {
            return -1;
        }
        return (str.charAt(0) - '0') * 100;
    }
}