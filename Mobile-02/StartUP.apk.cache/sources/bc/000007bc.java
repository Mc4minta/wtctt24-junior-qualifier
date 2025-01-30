package com.bugsnag.android;

import java.util.Map;

/* compiled from: MapUtils.java */
/* loaded from: classes.dex */
final class r0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, Map<String, Object> map) {
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }
}