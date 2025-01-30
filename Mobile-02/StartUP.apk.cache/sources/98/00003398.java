package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.j6  reason: invalid package */
/* loaded from: classes2.dex */
final class j6 implements t5 {
    private final v5 a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6780b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f6781c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6782d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j6(v5 v5Var, String str, Object[] objArr) {
        this.a = v5Var;
        this.f6780b = str;
        this.f6781c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f6782d = charAt;
            return;
        }
        int i2 = charAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            if (charAt2 < 55296) {
                this.f6782d = i2 | (charAt2 << i3);
                return;
            }
            i2 |= (charAt2 & 8191) << i3;
            i3 += 13;
            i4 = i5;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.t5
    public final boolean a() {
        return (this.f6782d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.t5
    public final v5 b() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.t5
    public final int c() {
        return (this.f6782d & 1) == 1 ? i6.a : i6.f6757b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.f6780b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] e() {
        return this.f6781c;
    }
}