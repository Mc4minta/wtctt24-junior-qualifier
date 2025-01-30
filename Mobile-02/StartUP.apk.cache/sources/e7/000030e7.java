package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public class e implements s {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final e.g.a.c.i.v.j.c f5838b;

    /* renamed from: c  reason: collision with root package name */
    private final g f5839c;

    public e(Context context, e.g.a.c.i.v.j.c cVar, g gVar) {
        this.a = context;
        this.f5838b = cVar;
        this.f5839c = gVar;
    }

    private boolean c(JobScheduler jobScheduler, int i2, int i3) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i4 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i2) {
                return i4 >= i3;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s
    public void a(e.g.a.c.i.l lVar, int i2) {
        ComponentName componentName = new ComponentName(this.a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        int b2 = b(lVar);
        if (c(jobScheduler, b2, i2)) {
            e.g.a.c.i.t.a.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", lVar);
            return;
        }
        long N0 = this.f5838b.N0(lVar);
        JobInfo.Builder b3 = this.f5839c.b(new JobInfo.Builder(b2, componentName), lVar.d(), N0, i2);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i2);
        persistableBundle.putString("backendName", lVar.b());
        persistableBundle.putInt("priority", e.g.a.c.i.x.a.a(lVar.d()));
        if (lVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(lVar.c(), 0));
        }
        b3.setExtras(persistableBundle);
        e.g.a.c.i.t.a.b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", lVar, Integer.valueOf(b2), Long.valueOf(this.f5839c.f(lVar.d(), N0, i2)), Long.valueOf(N0), Integer.valueOf(i2));
        jobScheduler.schedule(b3.build());
    }

    int b(e.g.a.c.i.l lVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(lVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(e.g.a.c.i.x.a.a(lVar.d())).array());
        if (lVar.c() != null) {
            adler32.update(lVar.c());
        }
        return (int) adler32.getValue();
    }
}