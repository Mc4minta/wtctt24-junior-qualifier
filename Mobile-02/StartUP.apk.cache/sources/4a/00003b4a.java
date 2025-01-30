package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
public class FirebaseMessaging {
    @SuppressLint({"FirebaseUnknownNullness"})
    static e.g.a.c.g a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f9265b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f9266c;

    /* renamed from: d  reason: collision with root package name */
    private final v f9267d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseMessaging(com.google.firebase.c cVar, FirebaseInstanceId firebaseInstanceId, com.google.firebase.i.h hVar, com.google.firebase.f.c cVar2, com.google.firebase.installations.i iVar, e.g.a.c.g gVar) {
        a = gVar;
        this.f9266c = firebaseInstanceId;
        Context g2 = cVar.g();
        this.f9265b = g2;
        this.f9267d = new v(cVar, firebaseInstanceId, new com.google.firebase.iid.q(g2), hVar, cVar2, iVar, g2, k.a(), new ScheduledThreadPoolExecutor(1, new com.google.android.gms.common.util.q.a("Firebase-Messaging-Topics-Io")));
        k.c().execute(new Runnable(this) { // from class: com.google.firebase.messaging.m
            private final FirebaseMessaging a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.e();
            }
        });
    }

    public static synchronized FirebaseMessaging a() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = getInstance(com.google.firebase.c.h());
        }
        return firebaseMessaging;
    }

    @Keep
    static synchronized FirebaseMessaging getInstance(com.google.firebase.c cVar) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) cVar.f(FirebaseMessaging.class);
        }
        return firebaseMessaging;
    }

    public boolean b() {
        return this.f9266c.C();
    }

    public com.google.android.gms.tasks.g<Void> c(String str) {
        return this.f9267d.a(str);
    }

    public com.google.android.gms.tasks.g<Void> d(String str) {
        return this.f9267d.h(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e() {
        if (b()) {
            this.f9267d.d();
        }
    }
}