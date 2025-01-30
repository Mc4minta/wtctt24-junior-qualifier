package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class g8 implements Runnable {
    private final /* synthetic */ AtomicReference a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7609b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7610c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f7611d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ z9 f7612e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ s7 f7613f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g8(s7 s7Var, AtomicReference atomicReference, String str, String str2, String str3, z9 z9Var) {
        this.f7613f = s7Var;
        this.a = atomicReference;
        this.f7609b = str;
        this.f7610c = str2;
        this.f7611d = str3;
        this.f7612e = z9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        synchronized (this.a) {
            try {
                p3Var = this.f7613f.f7853d;
            } catch (RemoteException e2) {
                this.f7613f.f().H().d("(legacy) Failed to get conditional properties; remote exception", x3.y(this.f7609b), this.f7610c, e2);
                this.a.set(Collections.emptyList());
                this.a.notify();
            }
            if (p3Var == null) {
                this.f7613f.f().H().d("(legacy) Failed to get conditional properties; not connected to service", x3.y(this.f7609b), this.f7610c, this.f7611d);
                this.a.set(Collections.emptyList());
                this.a.notify();
                return;
            }
            if (TextUtils.isEmpty(this.f7609b)) {
                this.a.set(p3Var.W(this.f7610c, this.f7611d, this.f7612e));
            } else {
                this.a.set(p3Var.V(this.f7609b, this.f7610c, this.f7611d));
            }
            this.f7613f.f0();
            this.a.notify();
        }
    }
}