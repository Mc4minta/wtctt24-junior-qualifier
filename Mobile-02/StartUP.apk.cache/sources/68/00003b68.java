package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.e1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
public final class v {
    private static final long a = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f9279b = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f9280c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f9281d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.firebase.iid.q f9282e;

    /* renamed from: f  reason: collision with root package name */
    private final e1 f9283f;

    /* renamed from: g  reason: collision with root package name */
    private final ScheduledExecutorService f9284g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9285h;

    /* renamed from: i  reason: collision with root package name */
    private int f9286i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<Integer, com.google.android.gms.tasks.h<Void>> f9287j;

    /* renamed from: k  reason: collision with root package name */
    private final w f9288k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(com.google.firebase.c cVar, FirebaseInstanceId firebaseInstanceId, com.google.firebase.iid.q qVar, com.google.firebase.i.h hVar, com.google.firebase.f.c cVar2, com.google.firebase.installations.i iVar, Context context, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this(firebaseInstanceId, qVar, new w(context), new e1(cVar, qVar, executor, hVar, cVar2, iVar), context, scheduledExecutorService);
    }

    private static <T> T b(com.google.android.gms.tasks.g<T> gVar) throws IOException {
        try {
            return (T) com.google.android.gms.tasks.j.b(gVar, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            e = e2;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e3);
            }
            throw ((IOException) cause);
        } catch (TimeoutException e4) {
            e = e4;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    private static String c(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 78);
            sb.append("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in ");
            sb.append(str2);
            sb.append(".");
            Log.w("FirebaseMessaging", sb.toString());
            str = str.substring(8);
        }
        if (str == null || !f9279b.matcher(str).matches()) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 79);
            sb2.append("Invalid topic name: ");
            sb2.append(str);
            sb2.append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}.");
            throw new IllegalArgumentException(sb2.toString());
        }
        return str;
    }

    private final synchronized com.google.android.gms.tasks.g<Void> j(String str) {
        String a2;
        com.google.android.gms.tasks.h<Void> hVar;
        synchronized (this.f9288k) {
            a2 = this.f9288k.a();
            w wVar = this.f9288k;
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 1 + String.valueOf(str).length());
            sb.append(a2);
            sb.append(",");
            sb.append(str);
            wVar.b(sb.toString());
        }
        hVar = new com.google.android.gms.tasks.h<>();
        this.f9287j.put(Integer.valueOf(this.f9286i + (TextUtils.isEmpty(a2) ? 0 : a2.split(",").length - 1)), hVar);
        return hVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    private final synchronized boolean l() {
        return o() != null;
    }

    private final boolean m(String str) throws IOException {
        String[] split = str.split("!");
        if (split.length == 2) {
            String str2 = split[0];
            String str3 = split[1];
            char c2 = 65535;
            try {
                int hashCode = str2.hashCode();
                if (hashCode != 83) {
                    if (hashCode == 85 && str2.equals("U")) {
                        c2 = 1;
                    }
                } else if (str2.equals("S")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    com.google.firebase.iid.a aVar = (com.google.firebase.iid.a) b(this.f9280c.d());
                    b(this.f9283f.h(aVar.getId(), aVar.a(), str3));
                    if (k()) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 31);
                        sb.append("Subscribe to topic: ");
                        sb.append(str3);
                        sb.append(" succeeded.");
                        Log.d("FirebaseMessaging", sb.toString());
                    }
                } else if (c2 != 1) {
                    if (k()) {
                        StringBuilder sb2 = new StringBuilder(str.length() + 24);
                        sb2.append("Unknown topic operation");
                        sb2.append(str);
                        sb2.append(".");
                        Log.d("FirebaseMessaging", sb2.toString());
                    }
                } else {
                    com.google.firebase.iid.a aVar2 = (com.google.firebase.iid.a) b(this.f9280c.d());
                    b(this.f9283f.i(aVar2.getId(), aVar2.a(), str3));
                    if (k()) {
                        StringBuilder sb3 = new StringBuilder(String.valueOf(str3).length() + 35);
                        sb3.append("Unsubscribe from topic: ");
                        sb3.append(str3);
                        sb3.append(" succeeded.");
                        Log.d("FirebaseMessaging", sb3.toString());
                    }
                }
            } catch (IOException e2) {
                if (!"SERVICE_NOT_AVAILABLE".equals(e2.getMessage()) && !"INTERNAL_SERVER_ERROR".equals(e2.getMessage())) {
                    if (e2.getMessage() == null) {
                        Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
                        return false;
                    }
                    throw e2;
                }
                String message = e2.getMessage();
                StringBuilder sb4 = new StringBuilder(String.valueOf(message).length() + 53);
                sb4.append("Topic operation failed: ");
                sb4.append(message);
                sb4.append(". Will retry Topic operation.");
                Log.e("FirebaseMessaging", sb4.toString());
                return false;
            }
        }
        return true;
    }

    private final synchronized void n() {
        if (!this.f9285h) {
            e(0L);
        }
    }

    private final String o() {
        String a2;
        synchronized (this.f9288k) {
            a2 = this.f9288k.a();
        }
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String[] split = a2.split(",");
        if (split.length <= 1 || TextUtils.isEmpty(split[1])) {
            return null;
        }
        return split[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.tasks.g<Void> a(String str) {
        String valueOf = String.valueOf(c(str, "subscribeToTopic"));
        com.google.android.gms.tasks.g<Void> j2 = j(valueOf.length() != 0 ? "S!".concat(valueOf) : new String("S!"));
        d();
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void d() {
        if (l()) {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void e(long j2) {
        f(new y(this, this.f9281d, this.f9282e, Math.min(Math.max(30L, j2 << 1), a)), j2);
        this.f9285h = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void f(Runnable runnable, long j2) {
        this.f9284g.schedule(runnable, j2, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void g(boolean z) {
        this.f9285h = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.tasks.g<Void> h(String str) {
        String valueOf = String.valueOf(c(str, "unsubscribeFromTopic"));
        com.google.android.gms.tasks.g<Void> j2 = j(valueOf.length() != 0 ? "U!".concat(valueOf) : new String("U!"));
        d();
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (k() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
        android.util.Log.d("FirebaseMessaging", "topic sync succeeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i() throws java.io.IOException {
        /*
            r5 = this;
        L0:
            monitor-enter(r5)
            java.lang.String r0 = r5.o()     // Catch: java.lang.Throwable -> L4b
            r1 = 1
            if (r0 != 0) goto L17
            boolean r0 = k()     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L15
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r2 = "topic sync succeeded"
            android.util.Log.d(r0, r2)     // Catch: java.lang.Throwable -> L4b
        L15:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L4b
            return r1
        L17:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L4b
            boolean r2 = r5.m(r0)
            if (r2 != 0) goto L20
            r0 = 0
            return r0
        L20:
            monitor-enter(r5)
            java.util.Map<java.lang.Integer, com.google.android.gms.tasks.h<java.lang.Void>> r2 = r5.f9287j     // Catch: java.lang.Throwable -> L48
            int r3 = r5.f9286i     // Catch: java.lang.Throwable -> L48
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L48
            java.lang.Object r2 = r2.remove(r3)     // Catch: java.lang.Throwable -> L48
            com.google.android.gms.tasks.h r2 = (com.google.android.gms.tasks.h) r2     // Catch: java.lang.Throwable -> L48
            com.google.firebase.messaging.w r3 = r5.f9288k     // Catch: java.lang.Throwable -> L48
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L48
            com.google.firebase.messaging.w r4 = r5.f9288k     // Catch: java.lang.Throwable -> L45
            r4.c(r0)     // Catch: java.lang.Throwable -> L45
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L45
            int r0 = r5.f9286i     // Catch: java.lang.Throwable -> L48
            int r0 = r0 + r1
            r5.f9286i = r0     // Catch: java.lang.Throwable -> L48
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L48
            if (r2 == 0) goto L0
            r0 = 0
            r2.c(r0)
            goto L0
        L45:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L45
            throw r0     // Catch: java.lang.Throwable -> L48
        L48:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L48
            throw r0
        L4b:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L4b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.v.i():boolean");
    }

    private v(FirebaseInstanceId firebaseInstanceId, com.google.firebase.iid.q qVar, w wVar, e1 e1Var, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f9285h = false;
        this.f9286i = 0;
        this.f9287j = new c.e.a();
        this.f9280c = firebaseInstanceId;
        this.f9282e = qVar;
        this.f9288k = wVar;
        this.f9283f = e1Var;
        this.f9281d = context;
        this.f9284g = scheduledExecutorService;
    }
}