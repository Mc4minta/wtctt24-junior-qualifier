package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class b implements Runnable {
    private static final b a = new b();

    private b() {
    }

    public static Runnable a() {
        return a;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlarmManagerSchedulerBroadcastReceiver.a();
    }
}