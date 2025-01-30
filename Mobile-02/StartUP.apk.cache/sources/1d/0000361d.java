package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class c8 extends h {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ s7 f7523e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c8(s7 s7Var, z5 z5Var) {
        super(z5Var);
        this.f7523e = s7Var;
    }

    @Override // com.google.android.gms.measurement.internal.h
    public final void b() {
        this.f7523e.f().K().a("Tasks have been queued for a long time");
    }
}