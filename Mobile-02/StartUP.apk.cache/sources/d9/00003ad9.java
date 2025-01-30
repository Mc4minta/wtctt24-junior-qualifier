package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import java.util.concurrent.ExecutorService;
import org.apache.http.HttpStatus;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class FirebaseInstanceIdReceiver extends c.n.a.a {

    /* renamed from: c */
    private final ExecutorService f9127c = s0.b();

    public static final /* synthetic */ void d(boolean z, BroadcastReceiver.PendingResult pendingResult, com.google.android.gms.tasks.g gVar) {
        if (z) {
            pendingResult.setResultCode(gVar.q() ? ((Integer) gVar.m()).intValue() : HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
        pendingResult.finish();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        c0 cVar;
        if (intent == null) {
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
        Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
        if (intent2 != null) {
            intent = intent2;
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ("google.com/iid".equals(intent.getStringExtra(ApiConstants.FROM))) {
            cVar = new k1(this.f9127c);
        } else {
            cVar = new c(context, this.f9127c);
        }
        cVar.a(intent).c(this.f9127c, new com.google.android.gms.tasks.c(isOrderedBroadcast(), goAsync()) { // from class: com.google.firebase.iid.c1
            private final boolean a;

            /* renamed from: b  reason: collision with root package name */
            private final BroadcastReceiver.PendingResult f9139b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = r1;
                this.f9139b = r2;
            }

            @Override // com.google.android.gms.tasks.c
            public final void a(com.google.android.gms.tasks.g gVar) {
                FirebaseInstanceIdReceiver.d(this.a, this.f9139b, gVar);
            }
        });
    }
}