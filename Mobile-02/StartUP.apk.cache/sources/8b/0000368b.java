package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class l9 implements h4 {
    private final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ j9 f7749b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l9(j9 j9Var, String str) {
        this.f7749b = j9Var;
        this.a = str;
    }

    @Override // com.google.android.gms.measurement.internal.h4
    public final void a(String str, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.f7749b.j(i2, th, bArr, this.a);
    }
}