package com.facebook.common.util;

/* compiled from: TriState.java */
/* loaded from: classes2.dex */
public enum d {
    YES,
    NO,
    UNSET;

    public static d h(boolean z) {
        return z ? YES : NO;
    }
}