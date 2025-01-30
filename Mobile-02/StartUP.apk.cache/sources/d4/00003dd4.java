package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

/* compiled from: TextProperties.java */
/* loaded from: classes2.dex */
enum o0 {
    None("none"),
    Underline("underline"),
    Overline("overline"),
    LineThrough("line-through"),
    Blink("blink");
    

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, o0> f10288f = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final String f10290h;

    static {
        o0[] values;
        for (o0 o0Var : values()) {
            f10288f.put(o0Var.f10290h, o0Var);
        }
    }

    o0(String str) {
        this.f10290h = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o0 h(String str) {
        Map<String, o0> map = f10288f;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Unknown String Value: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f10290h;
    }
}