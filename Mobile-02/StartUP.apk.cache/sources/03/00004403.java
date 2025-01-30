package com.uber.autodispose;

import java.util.Objects;

/* compiled from: AutoDisposeUtil.java */
/* loaded from: classes2.dex */
final class m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }
}