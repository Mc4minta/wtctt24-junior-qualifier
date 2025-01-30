package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public class a implements s {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final e.g.a.c.i.v.j.c f5829b;

    /* renamed from: c  reason: collision with root package name */
    private AlarmManager f5830c;

    /* renamed from: d  reason: collision with root package name */
    private final g f5831d;

    /* renamed from: e  reason: collision with root package name */
    private final e.g.a.c.i.w.a f5832e;

    public a(Context context, e.g.a.c.i.v.j.c cVar, e.g.a.c.i.w.a aVar, g gVar) {
        this(context, cVar, (AlarmManager) context.getSystemService("alarm"), aVar, gVar);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s
    public void a(e.g.a.c.i.l lVar, int i2) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", lVar.b());
        builder.appendQueryParameter("priority", String.valueOf(e.g.a.c.i.x.a.a(lVar.d())));
        if (lVar.c() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(lVar.c(), 0));
        }
        Intent intent = new Intent(this.a, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i2);
        if (b(intent)) {
            e.g.a.c.i.t.a.a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", lVar);
            return;
        }
        long N0 = this.f5829b.N0(lVar);
        long f2 = this.f5831d.f(lVar.d(), N0, i2);
        e.g.a.c.i.t.a.b("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", lVar, Long.valueOf(f2), Long.valueOf(N0), Integer.valueOf(i2));
        this.f5830c.set(3, this.f5832e.a() + f2, PendingIntent.getBroadcast(this.a, 0, intent, 0));
    }

    boolean b(Intent intent) {
        return PendingIntent.getBroadcast(this.a, 0, intent, PKIFailureInfo.duplicateCertReq) != null;
    }

    a(Context context, e.g.a.c.i.v.j.c cVar, AlarmManager alarmManager, e.g.a.c.i.w.a aVar, g gVar) {
        this.a = context;
        this.f5829b = cVar;
        this.f5830c = alarmManager;
        this.f5832e = aVar;
        this.f5831d = gVar;
    }
}