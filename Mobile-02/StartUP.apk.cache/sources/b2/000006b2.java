package com.amplitude.api;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Amplitude.java */
/* loaded from: classes.dex */
public class a {
    static final Map<String, c> a = new HashMap();

    public static c a() {
        return b(null);
    }

    public static synchronized c b(String str) {
        c cVar;
        synchronized (a.class) {
            String c2 = l.c(str);
            Map<String, c> map = a;
            cVar = map.get(c2);
            if (cVar == null) {
                cVar = new c(c2);
                map.put(c2, cVar);
            }
        }
        return cVar;
    }
}