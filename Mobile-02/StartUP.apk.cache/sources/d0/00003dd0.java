package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

/* compiled from: TextProperties.java */
/* loaded from: classes2.dex */
enum m0 {
    Normal("normal"),
    Bold("bold"),
    w100("100"),
    w200("200"),
    w300("300"),
    w400("400"),
    w500("500"),
    w600("600"),
    w700("700"),
    w800("800"),
    w900("900"),
    Bolder("bolder"),
    Lighter("lighter");
    
    private static final Map<String, m0> p = new HashMap();
    private final String t;

    static {
        m0[] values;
        for (m0 m0Var : values()) {
            p.put(m0Var.t, m0Var);
        }
    }

    m0(String str) {
        this.t = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m0 h(String str) {
        return p.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean n(String str) {
        return p.containsKey(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.t;
    }
}