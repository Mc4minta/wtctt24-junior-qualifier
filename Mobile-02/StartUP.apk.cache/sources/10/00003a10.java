package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class i extends v.d.c {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8880b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8881c;

    /* renamed from: d  reason: collision with root package name */
    private final long f8882d;

    /* renamed from: e  reason: collision with root package name */
    private final long f8883e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f8884f;

    /* renamed from: g  reason: collision with root package name */
    private final int f8885g;

    /* renamed from: h  reason: collision with root package name */
    private final String f8886h;

    /* renamed from: i  reason: collision with root package name */
    private final String f8887i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.c.a {
        private Integer a;

        /* renamed from: b  reason: collision with root package name */
        private String f8888b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f8889c;

        /* renamed from: d  reason: collision with root package name */
        private Long f8890d;

        /* renamed from: e  reason: collision with root package name */
        private Long f8891e;

        /* renamed from: f  reason: collision with root package name */
        private Boolean f8892f;

        /* renamed from: g  reason: collision with root package name */
        private Integer f8893g;

        /* renamed from: h  reason: collision with root package name */
        private String f8894h;

        /* renamed from: i  reason: collision with root package name */
        private String f8895i;

        @Override // com.google.firebase.crashlytics.c.i.v.d.c.a
        public v.d.c a() {
            String str = "";
            if (this.a == null) {
                str = " arch";
            }
            if (this.f8888b == null) {
                str = str + " model";
            }
            if (this.f8889c == null) {
                str = str + " cores";
            }
            if (this.f8890d == null) {
                str = str + " ram";
            }
            if (this.f8891e == null) {
                str = str + " diskSpace";
            }
            if (this.f8892f == null) {
                str = str + " simulator";
            }
            if (this.f8893g == null) {
                str = str + " state";
            }
            if (this.f8894h == null) {
                str = str + " manufacturer";
            }
            if (this.f8895i == null) {
                str = str + " modelClass";
            }
            if (str.isEmpty()) {
                return new i(this.a.intValue(), this.f8888b, this.f8889c.intValue(), this.f8890d.longValue(), this.f8891e.longValue(), this.f8892f.booleanValue(), this.f8893g.intValue(), this.f8894h, this.f8895i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.c.a
        public v.d.c.a b(int i2) {
            this.a = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.c.a
        public v.d.c.a c(int i2) {
            this.f8889c = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.c.a
        public v.d.c.a d(long j2) {
            this.f8891e = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.c.a
        public v.d.c.a e(String str) {
            Objects.requireNonNull(str, "Null manufacturer");
            this.f8894h = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.c.a
        public v.d.c.a f(String str) {
            Objects.requireNonNull(str, "Null model");
            this.f8888b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.c.a
        public v.d.c.a g(String str) {
            Objects.requireNonNull(str, "Null modelClass");
            this.f8895i = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.c.a
        public v.d.c.a h(long j2) {
            this.f8890d = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.c.a
        public v.d.c.a i(boolean z) {
            this.f8892f = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.c.a
        public v.d.c.a j(int i2) {
            this.f8893g = Integer.valueOf(i2);
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.c
    public int b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.c
    public int c() {
        return this.f8881c;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.c
    public long d() {
        return this.f8883e;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.c
    public String e() {
        return this.f8886h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.c) {
            v.d.c cVar = (v.d.c) obj;
            return this.a == cVar.b() && this.f8880b.equals(cVar.f()) && this.f8881c == cVar.c() && this.f8882d == cVar.h() && this.f8883e == cVar.d() && this.f8884f == cVar.j() && this.f8885g == cVar.i() && this.f8886h.equals(cVar.e()) && this.f8887i.equals(cVar.g());
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.c
    public String f() {
        return this.f8880b;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.c
    public String g() {
        return this.f8887i;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.c
    public long h() {
        return this.f8882d;
    }

    public int hashCode() {
        long j2 = this.f8882d;
        long j3 = this.f8883e;
        return ((((((((((((((((this.a ^ 1000003) * 1000003) ^ this.f8880b.hashCode()) * 1000003) ^ this.f8881c) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ (this.f8884f ? 1231 : 1237)) * 1000003) ^ this.f8885g) * 1000003) ^ this.f8886h.hashCode()) * 1000003) ^ this.f8887i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.c
    public int i() {
        return this.f8885g;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.c
    public boolean j() {
        return this.f8884f;
    }

    public String toString() {
        return "Device{arch=" + this.a + ", model=" + this.f8880b + ", cores=" + this.f8881c + ", ram=" + this.f8882d + ", diskSpace=" + this.f8883e + ", simulator=" + this.f8884f + ", state=" + this.f8885g + ", manufacturer=" + this.f8886h + ", modelClass=" + this.f8887i + "}";
    }

    private i(int i2, String str, int i3, long j2, long j3, boolean z, int i4, String str2, String str3) {
        this.a = i2;
        this.f8880b = str;
        this.f8881c = i3;
        this.f8882d = j2;
        this.f8883e = j3;
        this.f8884f = z;
        this.f8885g = i4;
        this.f8886h = str2;
        this.f8887i = str3;
    }
}