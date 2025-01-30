package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class k6 implements s5 {
    private final u5 a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7221b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f7222c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7223d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k6(u5 u5Var, String str, Object[] objArr) {
        this.a = u5Var;
        this.f7221b = str;
        this.f7222c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f7223d = charAt;
            return;
        }
        int i2 = charAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            if (charAt2 < 55296) {
                this.f7223d = i2 | (charAt2 << i3);
                return;
            }
            i2 |= (charAt2 & 8191) << i3;
            i3 += 13;
            i4 = i5;
        }
    }

    @Override // com.google.android.gms.internal.measurement.s5
    public final int a() {
        return (this.f7223d & 1) == 1 ? n4.f.f7262i : n4.f.f7263j;
    }

    @Override // com.google.android.gms.internal.measurement.s5
    public final boolean b() {
        return (this.f7223d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.s5
    public final u5 c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.f7221b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] e() {
        return this.f7222c;
    }
}