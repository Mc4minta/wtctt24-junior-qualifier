package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.List;

/* compiled from: ForegroundDetector.java */
/* loaded from: classes.dex */
class j0 {
    private final ActivityManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(Context context) {
        this.a = (ActivityManager) context.getSystemService("activity");
    }

    private ActivityManager.RunningAppProcessInfo a() {
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            return runningAppProcessInfo;
        }
        return b();
    }

    private ActivityManager.RunningAppProcessInfo b() {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.a.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (myPid == runningAppProcessInfo.pid) {
                        return runningAppProcessInfo;
                    }
                }
            }
        } catch (SecurityException unused) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        ActivityManager.RunningAppProcessInfo a = a();
        return a != null && a.importance <= 100;
    }
}