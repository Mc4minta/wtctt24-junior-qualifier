package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
final class y extends f {
    private final /* synthetic */ Intent a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Activity f6280b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f6281c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Intent intent, Activity activity, int i2) {
        this.a = intent;
        this.f6280b = activity;
        this.f6281c = i2;
    }

    @Override // com.google.android.gms.common.internal.f
    public final void c() {
        Intent intent = this.a;
        if (intent != null) {
            this.f6280b.startActivityForResult(intent, this.f6281c);
        }
    }
}