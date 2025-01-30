package com.google.android.gms.common.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
final class z extends f {
    private final /* synthetic */ Intent a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.common.api.internal.i f6282b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f6283c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Intent intent, com.google.android.gms.common.api.internal.i iVar, int i2) {
        this.a = intent;
        this.f6282b = iVar;
        this.f6283c = i2;
    }

    @Override // com.google.android.gms.common.internal.f
    public final void c() {
        Intent intent = this.a;
        if (intent != null) {
            this.f6282b.startActivityForResult(intent, this.f6283c);
        }
    }
}