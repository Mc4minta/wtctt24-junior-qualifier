package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
final class l {
    final String a;

    /* renamed from: b  reason: collision with root package name */
    final String f7725b;

    /* renamed from: c  reason: collision with root package name */
    final long f7726c;

    /* renamed from: d  reason: collision with root package name */
    final long f7727d;

    /* renamed from: e  reason: collision with root package name */
    final long f7728e;

    /* renamed from: f  reason: collision with root package name */
    final long f7729f;

    /* renamed from: g  reason: collision with root package name */
    final long f7730g;

    /* renamed from: h  reason: collision with root package name */
    final Long f7731h;

    /* renamed from: i  reason: collision with root package name */
    final Long f7732i;

    /* renamed from: j  reason: collision with root package name */
    final Long f7733j;

    /* renamed from: k  reason: collision with root package name */
    final Boolean f7734k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(String str, String str2, long j2, long j3, long j4, long j5, long j6, Long l2, Long l3, Long l4, Boolean bool) {
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.g(str2);
        com.google.android.gms.common.internal.t.a(j2 >= 0);
        com.google.android.gms.common.internal.t.a(j3 >= 0);
        com.google.android.gms.common.internal.t.a(j4 >= 0);
        com.google.android.gms.common.internal.t.a(j6 >= 0);
        this.a = str;
        this.f7725b = str2;
        this.f7726c = j2;
        this.f7727d = j3;
        this.f7728e = j4;
        this.f7729f = j5;
        this.f7730g = j6;
        this.f7731h = l2;
        this.f7732i = l3;
        this.f7733j = l4;
        this.f7734k = bool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l a(long j2) {
        return new l(this.a, this.f7725b, this.f7726c, this.f7727d, this.f7728e, j2, this.f7730g, this.f7731h, this.f7732i, this.f7733j, this.f7734k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l b(long j2, long j3) {
        return new l(this.a, this.f7725b, this.f7726c, this.f7727d, this.f7728e, this.f7729f, j2, Long.valueOf(j3), this.f7732i, this.f7733j, this.f7734k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l c(Long l2, Long l3, Boolean bool) {
        return new l(this.a, this.f7725b, this.f7726c, this.f7727d, this.f7728e, this.f7729f, this.f7730g, this.f7731h, l2, l3, (bool == null || bool.booleanValue()) ? bool : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(String str, String str2, long j2, long j3, long j4, long j5, Long l2, Long l3, Long l4, Boolean bool) {
        this(str, str2, 0L, 0L, 0L, j4, 0L, null, null, null, null);
    }
}