package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class z extends e.g.a.e.d.f.e {
    private final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(w wVar, Looper looper) {
        super(looper);
        this.a = wVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.a.d(message);
    }
}