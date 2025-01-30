package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class Foreground {
    public static long CHECK_DELAY = 500;
    public static Listener listener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.appsflyer.Foreground$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public static class AnonymousClass4 implements Application.ActivityLifecycleCallbacks {

        /* renamed from: ı  reason: contains not printable characters */
        final /* synthetic */ Listener f133;

        /* renamed from: Ι  reason: contains not printable characters */
        boolean f135;

        /* renamed from: ɩ  reason: contains not printable characters */
        boolean f134 = true;

        /* renamed from: ι  reason: contains not printable characters */
        private Executor f136 = Executors.newSingleThreadExecutor();

        AnonymousClass4(Listener listener) {
            this.f133 = listener;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(final Activity activity, Bundle bundle) {
            this.f136.execute(new Runnable() { // from class: com.appsflyer.Foreground.4.4
                @Override // java.lang.Runnable
                public final void run() {
                    AFDeepLinkManager.getInstance().collectIntentsFromActivities(activity.getIntent());
                }
            });
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(final Activity activity) {
            this.f136.execute(new Runnable() { // from class: com.appsflyer.Foreground.4.3
                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass4.this.f134 = true;
                    final Context applicationContext = activity.getApplicationContext();
                    try {
                        new Timer().schedule(new TimerTask() { // from class: com.appsflyer.Foreground.4.3.3
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public final void run() {
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                if (anonymousClass4.f135 && anonymousClass4.f134) {
                                    anonymousClass4.f135 = false;
                                    try {
                                        anonymousClass4.f133.onBecameBackground(applicationContext);
                                    } catch (Exception e2) {
                                        AFLogger.afErrorLog("Listener threw exception! ", e2);
                                    }
                                }
                            }
                        }, Foreground.CHECK_DELAY);
                    } catch (Throwable th) {
                        AFLogger.afErrorLog("Background task failed with a throwable: ", th);
                    }
                }
            });
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(final Activity activity) {
            this.f136.execute(new Runnable() { // from class: com.appsflyer.Foreground.4.5
                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    if (!anonymousClass4.f135) {
                        try {
                            anonymousClass4.f133.onBecameForeground(activity);
                        } catch (Exception e2) {
                            AFLogger.afErrorLog("Listener thrown an exception: ", e2);
                        }
                    }
                    AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                    anonymousClass42.f134 = false;
                    anonymousClass42.f135 = true;
                }
            });
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    }

    /* loaded from: classes.dex */
    public interface Listener {
        void onBecameBackground(Context context);

        void onBecameForeground(Activity activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public static void m112(Context context, Listener listener2) {
        listener = listener2;
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(listener2);
        if (context instanceof Activity) {
            anonymousClass4.onActivityResumed((Activity) context);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(anonymousClass4);
    }
}