package com.google.firebase.crashlytics.c.q;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class e {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9074b;

    /* renamed from: c  reason: collision with root package name */
    public final StackTraceElement[] f9075c;

    /* renamed from: d  reason: collision with root package name */
    public final e f9076d;

    public e(Throwable th, d dVar) {
        this.a = th.getLocalizedMessage();
        this.f9074b = th.getClass().getName();
        this.f9075c = dVar.a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f9076d = cause != null ? new e(cause, dVar) : null;
    }
}