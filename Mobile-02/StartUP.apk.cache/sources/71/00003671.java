package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class j8 implements Runnable {
    private final /* synthetic */ AtomicReference a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7680b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7681c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f7682d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ boolean f7683e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ z9 f7684f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ s7 f7685g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j8(s7 s7Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z, z9 z9Var) {
        this.f7685g = s7Var;
        this.a = atomicReference;
        this.f7680b = str;
        this.f7681c = str2;
        this.f7682d = str3;
        this.f7683e = z;
        this.f7684f = z9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        synchronized (this.a) {
            try {
                p3Var = this.f7685g.f7853d;
            } catch (RemoteException e2) {
                this.f7685g.f().H().d("(legacy) Failed to get user properties; remote exception", x3.y(this.f7680b), this.f7681c, e2);
                this.a.set(Collections.emptyList());
                this.a.notify();
            }
            if (p3Var == null) {
                this.f7685g.f().H().d("(legacy) Failed to get user properties; not connected to service", x3.y(this.f7680b), this.f7681c, this.f7682d);
                this.a.set(Collections.emptyList());
                this.a.notify();
                return;
            }
            if (TextUtils.isEmpty(this.f7680b)) {
                this.a.set(p3Var.e0(this.f7681c, this.f7682d, this.f7683e, this.f7684f));
            } else {
                this.a.set(p3Var.E(this.f7680b, this.f7681c, this.f7682d, this.f7683e));
            }
            this.f7685g.f0();
            this.a.notify();
        }
    }
}