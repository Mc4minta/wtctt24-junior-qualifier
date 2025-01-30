package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class g3 extends i3 {
    private int a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f7138b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ h3 f7139c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g3(h3 h3Var) {
        this.f7139c = h3Var;
        this.f7138b = h3Var.i();
    }

    @Override // com.google.android.gms.internal.measurement.m3
    public final byte a() {
        int i2 = this.a;
        if (i2 < this.f7138b) {
            this.a = i2 + 1;
            return this.f7139c.s(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.f7138b;
    }
}