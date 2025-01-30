package com.google.firebase.crashlytics.c.g;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class g0 {
    private String a = null;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f8682b = new ConcurrentHashMap<>();

    private static String c(String str) {
        if (str != null) {
            String trim = str.trim();
            return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
        }
        return str;
    }

    public Map<String, String> a() {
        return Collections.unmodifiableMap(this.f8682b);
    }

    public String b() {
        return this.a;
    }

    public void d(String str, String str2) {
        if (str != null) {
            String c2 = c(str);
            if (this.f8682b.size() >= 64 && !this.f8682b.containsKey(c2)) {
                com.google.firebase.crashlytics.c.b.f().b("Exceeded maximum number of custom attributes (64)");
                return;
            } else {
                this.f8682b.put(c2, str2 == null ? "" : c(str2));
                return;
            }
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public void e(String str) {
        this.a = c(str);
    }
}