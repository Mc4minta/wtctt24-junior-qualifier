package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.j;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
final class e {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f9272b;

    /* renamed from: c  reason: collision with root package name */
    private final t f9273c;

    public e(Context context, t tVar, Executor executor) {
        this.a = executor;
        this.f9272b = context;
        this.f9273c = tVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        boolean z;
        if (this.f9273c.g("gcm.n.noui")) {
            return true;
        }
        if (!((KeyguardManager) this.f9272b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!com.google.android.gms.common.util.l.h()) {
                SystemClock.sleep(10L);
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f9272b.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        if (next.importance == 100) {
                            z = true;
                        }
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        q b2 = q.b(this.f9273c.c("gcm.n.image"));
        if (b2 != null) {
            b2.c(this.a);
        }
        c d2 = d.d(this.f9272b, this.f9273c);
        j.e eVar = d2.a;
        if (b2 != null) {
            try {
                Bitmap bitmap = (Bitmap) com.google.android.gms.tasks.j.b(b2.a(), 5L, TimeUnit.SECONDS);
                eVar.s(bitmap);
                eVar.D(new j.b().i(bitmap).h(null));
            } catch (InterruptedException unused) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                b2.close();
                Thread.currentThread().interrupt();
            } catch (ExecutionException e2) {
                String valueOf = String.valueOf(e2.getCause());
                StringBuilder sb = new StringBuilder(valueOf.length() + 26);
                sb.append("Failed to download image: ");
                sb.append(valueOf);
                Log.w("FirebaseMessaging", sb.toString());
            } catch (TimeoutException unused2) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                b2.close();
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f9272b.getSystemService("notification")).notify(d2.f9270b, 0, d2.a.c());
        return true;
    }
}