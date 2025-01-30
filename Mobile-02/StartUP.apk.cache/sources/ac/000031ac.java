package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class v implements c.a {
    private final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(f fVar) {
        this.a = fVar;
    }

    @Override // com.google.android.gms.common.api.internal.c.a
    public final void a(boolean z) {
        this.a.q.sendMessage(this.a.q.obtainMessage(1, Boolean.valueOf(z)));
    }
}