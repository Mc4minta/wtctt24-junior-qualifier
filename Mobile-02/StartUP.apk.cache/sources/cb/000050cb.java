package io.branch.referral;

import android.content.Context;

/* compiled from: TrackingController.java */
/* loaded from: classes2.dex */
class h0 {
    private boolean a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(Context context) {
        b(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Context context) {
        this.a = q.B(context).m("bnc_tracking_state");
    }
}