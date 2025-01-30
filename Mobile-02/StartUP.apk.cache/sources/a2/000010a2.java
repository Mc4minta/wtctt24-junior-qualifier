package com.coinbase.resources;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class ExpandUtils {
    private ExpandUtils() {
    }

    public static Set<String> toValueSet(ExpandField... expandFieldArr) {
        HashSet hashSet = new HashSet();
        if (expandFieldArr != null && expandFieldArr.length > 0) {
            for (ExpandField expandField : expandFieldArr) {
                if ("all".equalsIgnoreCase(expandField.getCode())) {
                    hashSet.clear();
                    hashSet.add("all");
                    return hashSet;
                }
                hashSet.add(expandField.getCode());
            }
        }
        return hashSet;
    }
}