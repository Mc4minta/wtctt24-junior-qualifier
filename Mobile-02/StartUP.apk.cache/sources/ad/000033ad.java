package com.google.android.gms.internal.p000firebaseperf;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.l3  reason: invalid package */
/* loaded from: classes2.dex */
public final class l3 extends n3 {
    private int a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f6813b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ i3 f6814c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l3(i3 i3Var) {
        this.f6814c = i3Var;
        this.f6813b = i3Var.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.f6813b;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.r3
    public final byte nextByte() {
        int i2 = this.a;
        if (i2 < this.f6813b) {
            this.a = i2 + 1;
            return this.f6814c.w(i2);
        }
        throw new NoSuchElementException();
    }
}