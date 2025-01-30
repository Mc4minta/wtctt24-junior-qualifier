package com.google.android.datatransport.cct.b;

import com.google.android.datatransport.cct.b.e;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
public abstract class k {

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract a a(com.google.android.datatransport.cct.b.a aVar);

        public abstract a b(b bVar);

        public abstract k c();
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    public static final class b {
        public static final b a = new b("UNKNOWN", 0, 0);

        /* renamed from: b  reason: collision with root package name */
        public static final b f5776b = new b("ANDROID_FIREBASE", 1, 23);

        private b(String str, int i2, int i3) {
        }
    }

    public static a a() {
        return new e.b();
    }

    public abstract com.google.android.datatransport.cct.b.a b();

    public abstract b c();
}