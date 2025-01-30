package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
final class b0 extends z {

    /* renamed from: e  reason: collision with root package name */
    private final Callable<String> f6156e;

    private b0(Callable<String> callable) {
        super(false, null, null);
        this.f6156e = callable;
    }

    @Override // com.google.android.gms.common.z
    final String a() {
        try {
            return this.f6156e.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}