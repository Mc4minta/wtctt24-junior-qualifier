package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
@TargetApi(24)
/* loaded from: classes2.dex */
public final class h6 {
    private static final Method a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final Method f7166b = d();

    /* renamed from: c  reason: collision with root package name */
    private final JobScheduler f7167c;

    private h6(JobScheduler jobScheduler) {
        this.f7167c = jobScheduler;
    }

    private final int a(JobInfo jobInfo, String str, int i2, String str2) {
        Method method = a;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f7167c, jobInfo, str, Integer.valueOf(i2), str2)).intValue();
            } catch (IllegalAccessException | InvocationTargetException e2) {
                Log.e(str2, "error calling scheduleAsPackage", e2);
            }
        }
        return this.f7167c.schedule(jobInfo);
    }

    public static int b(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (a != null && context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") == 0) {
            return new h6(jobScheduler).a(jobInfo, str, e(), str2);
        }
        return jobScheduler.schedule(jobInfo);
    }

    private static Method c() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    private static Method d() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No myUserId method available");
                }
            }
        }
        return null;
    }

    private static int e() {
        Method method = f7166b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException e2) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e2);
                }
            }
        }
        return 0;
    }
}