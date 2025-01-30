package com.google.common.collect;

import java.lang.reflect.Array;

/* compiled from: Platform.java */
/* loaded from: classes2.dex */
final class a0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(T[] tArr, int i2) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
    }
}