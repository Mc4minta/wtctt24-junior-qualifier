package com.google.common.collect;

/* compiled from: Collections2.java */
/* loaded from: classes2.dex */
public final class e {
    static final com.google.common.base.g a = com.google.common.base.g.g(", ").i("null");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder a(int i2) {
        d.b(i2, "size");
        return new StringBuilder((int) Math.min(i2 * 8, 1073741824L));
    }
}