package com.squareup.wire;

/* loaded from: classes2.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[c.values().length];
        a = iArr;
        iArr[c.VARINT.ordinal()] = 1;
        iArr[c.FIXED32.ordinal()] = 2;
        iArr[c.FIXED64.ordinal()] = 3;
        iArr[c.LENGTH_DELIMITED.ordinal()] = 4;
    }
}