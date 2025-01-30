package com.google.android.gms.internal.clearcut;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d extends ContentObserver {
    private final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, Handler handler) {
        super(null);
        this.a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.a.d();
        this.a.f();
    }
}