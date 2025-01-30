package com.google.gson;

import java.util.Map;
import java.util.Set;

/* compiled from: JsonObject.java */
/* loaded from: classes2.dex */
public final class n extends l {
    private final com.google.gson.u.h<String, l> a = new com.google.gson.u.h<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof n) && ((n) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void r(String str, l lVar) {
        if (lVar == null) {
            lVar = m.a;
        }
        this.a.put(str, lVar);
    }

    public Set<Map.Entry<String, l>> s() {
        return this.a.entrySet();
    }

    public l t(String str) {
        return this.a.get(str);
    }
}