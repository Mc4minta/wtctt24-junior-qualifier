package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

/* compiled from: TextProperties.java */
/* loaded from: classes2.dex */
enum j0 {
    baseline("baseline"),
    textBottom("text-bottom"),
    alphabetic("alphabetic"),
    ideographic("ideographic"),
    middle("middle"),
    central("central"),
    mathematical("mathematical"),
    textTop("text-top"),
    bottom("bottom"),
    center("center"),
    top("top"),
    textBeforeEdge("text-before-edge"),
    textAfterEdge("text-after-edge"),
    beforeEdge("before-edge"),
    afterEdge("after-edge"),
    hanging("hanging");
    
    private static final Map<String, j0> u = new HashMap();
    private final String w;

    static {
        j0[] values;
        for (j0 j0Var : values()) {
            u.put(j0Var.w, j0Var);
        }
    }

    j0(String str) {
        this.w = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j0 h(String str) {
        Map<String, j0> map = u;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Unknown String Value: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.w;
    }
}