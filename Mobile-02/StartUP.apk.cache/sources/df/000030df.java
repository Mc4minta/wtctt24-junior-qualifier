package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import e.g.a.c.i.l;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i2 = intent.getExtras().getInt("attemptNumber");
        e.g.a.c.i.q.f(context);
        l.a d2 = e.g.a.c.i.l.a().b(queryParameter).d(e.g.a.c.i.x.a.b(intValue));
        if (queryParameter2 != null) {
            d2.c(Base64.decode(queryParameter2, 0));
        }
        e.g.a.c.i.q.c().e().g(d2.a(), i2, b.a());
    }
}