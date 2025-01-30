package com.bugsnag;

import java.util.HashMap;
import java.util.Map;

/* compiled from: RuntimeVersions.java */
/* loaded from: classes.dex */
public class c {
    public static void a(Map<String, Object> map) {
        Map map2 = (Map) map.get("runtimeVersions");
        if (map2 == null) {
            map2 = new HashMap();
            map.put("runtimeVersions", map2);
        }
        map2.put("reactNative", b());
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        Map<String, Object> map = com.facebook.react.modules.systeminfo.b.a;
        String c2 = c("major", map);
        if (c2 != null) {
            sb.append(c2);
            sb.append(".");
        }
        String c3 = c("minor", map);
        if (c3 != null) {
            sb.append(c3);
            sb.append(".");
        }
        String c4 = c("patch", map);
        if (c4 != null) {
            sb.append(c4);
        }
        String c5 = c("prerelease", map);
        if (c5 != null) {
            sb.append("-");
            sb.append(c5);
        }
        return sb.toString();
    }

    private static String c(String str, Map<String, Object> map) {
        Object obj = map.get(str);
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }
}