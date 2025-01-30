package com.google.android.gms.internal.clearcut;

import java.util.List;

/* loaded from: classes2.dex */
public final class zzew extends RuntimeException {
    private final List<String> a;

    public zzew(i2 i2Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.a = null;
    }
}