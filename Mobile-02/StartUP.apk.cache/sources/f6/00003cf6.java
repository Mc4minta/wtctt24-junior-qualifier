package com.google.zxing.p.a;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: DecodeHintManager.java */
/* loaded from: classes2.dex */
public final class d {
    private static final String a = "d";

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f9894b = Pattern.compile(",");

    public static Map<com.google.zxing.d, Object> a(Intent intent) {
        com.google.zxing.d[] values;
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        EnumMap enumMap = new EnumMap(com.google.zxing.d.class);
        for (com.google.zxing.d dVar : com.google.zxing.d.values()) {
            if (dVar != com.google.zxing.d.CHARACTER_SET && dVar != com.google.zxing.d.NEED_RESULT_POINT_CALLBACK && dVar != com.google.zxing.d.POSSIBLE_FORMATS) {
                String name = dVar.name();
                if (extras.containsKey(name)) {
                    if (dVar.h().equals(Void.class)) {
                        enumMap.put((EnumMap) dVar, (com.google.zxing.d) Boolean.TRUE);
                    } else {
                        Object obj = extras.get(name);
                        if (dVar.h().isInstance(obj)) {
                            enumMap.put((EnumMap) dVar, (com.google.zxing.d) obj);
                        } else {
                            Log.w(a, "Ignoring hint " + dVar + " because it is not assignable from " + obj);
                        }
                    }
                }
            }
        }
        Log.i(a, "Hints from the Intent: " + enumMap);
        return enumMap;
    }
}