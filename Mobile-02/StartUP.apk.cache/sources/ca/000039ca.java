package com.google.firebase.crashlytics.c.g;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
class o implements Thread.UncaughtExceptionHandler {
    private final a a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.p.e f8777b;

    /* renamed from: c  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f8778c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f8779d = new AtomicBoolean(false);

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    interface a {
        void a(com.google.firebase.crashlytics.c.p.e eVar, Thread thread, Throwable th);
    }

    public o(a aVar, com.google.firebase.crashlytics.c.p.e eVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = aVar;
        this.f8777b = eVar;
        this.f8778c = uncaughtExceptionHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f8779d.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Thread$UncaughtExceptionHandler] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Thread$UncaughtExceptionHandler] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.firebase.crashlytics.c.b] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.concurrent.atomic.AtomicBoolean] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.f8779d.set(true);
        ?? r1 = "Crashlytics completed exception processing. Invoking default exception handler.";
        try {
            try {
                if (thread == 0) {
                    com.google.firebase.crashlytics.c.b.f().d("Could not handle uncaught exception; null thread");
                } else if (th == null) {
                    com.google.firebase.crashlytics.c.b.f().d("Could not handle uncaught exception; null throwable");
                } else {
                    this.a.a(this.f8777b, thread, th);
                }
            } catch (Exception e2) {
                com.google.firebase.crashlytics.c.b.f().e("An error occurred in the uncaught exception handler", e2);
            }
            com.google.firebase.crashlytics.c.b.f().b("Crashlytics completed exception processing. Invoking default exception handler.");
            r1 = this.f8778c;
            r1.uncaughtException(thread, th);
            thread = this.f8779d;
            thread.set(false);
        } catch (Throwable th2) {
            com.google.firebase.crashlytics.c.b.f().b(r1);
            this.f8778c.uncaughtException(thread, th);
            this.f8779d.set(false);
            throw th2;
        }
    }
}