package com.google.firebase.perf.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.google.android.gms.internal.p000firebaseperf.s0;
import com.google.android.gms.internal.p000firebaseperf.s8;
import java.util.List;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
final class q {
    private final Runtime a;

    /* renamed from: b  reason: collision with root package name */
    private final ActivityManager f9337b;

    /* renamed from: c  reason: collision with root package name */
    private final ActivityManager.MemoryInfo f9338c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9339d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f9340e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context) {
        this(Runtime.getRuntime(), context);
    }

    public final String a() {
        return this.f9339d;
    }

    public final int b() {
        return s8.a(s0.f6902e.h(this.a.maxMemory()));
    }

    public final int c() {
        return s8.a(s0.f6900c.h(this.f9337b.getMemoryClass()));
    }

    public final int d() {
        return s8.a(s0.f6902e.h(this.f9338c.totalMem));
    }

    private q(Runtime runtime, Context context) {
        String packageName;
        this.a = runtime;
        this.f9340e = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f9337b = activityManager;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.f9338c = memoryInfo;
        activityManager.getMemoryInfo(memoryInfo);
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    packageName = runningAppProcessInfo.processName;
                    break;
                }
            }
        }
        packageName = this.f9340e.getPackageName();
        this.f9339d = packageName;
    }
}