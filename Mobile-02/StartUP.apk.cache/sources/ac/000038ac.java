package com.google.common.base;

import java.util.logging.Logger;

/* compiled from: Platform.java */
/* loaded from: classes2.dex */
final class k {
    private static final Logger a = Logger.getLogger(k.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final j f8441b = a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Platform.java */
    /* loaded from: classes2.dex */
    public static final class b implements j {
        private b() {
        }
    }

    private k() {
    }

    private static j a() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(String str) {
        return str == null || str.isEmpty();
    }
}