package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.f;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
final class w implements Runnable {
    private final /* synthetic */ f.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(f.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.t();
    }
}