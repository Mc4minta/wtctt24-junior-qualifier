package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
final class v0 extends c0 {
    private final /* synthetic */ Dialog a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ t0 f6145b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v0(t0 t0Var, Dialog dialog) {
        this.f6145b = t0Var;
        this.a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.c0
    public final void a() {
        this.f6145b.f6143b.p();
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}