package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class t extends v.d.e {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8956b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8957c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8958d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.e.a {
        private Integer a;

        /* renamed from: b  reason: collision with root package name */
        private String f8959b;

        /* renamed from: c  reason: collision with root package name */
        private String f8960c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f8961d;

        @Override // com.google.firebase.crashlytics.c.i.v.d.e.a
        public v.d.e a() {
            String str = "";
            if (this.a == null) {
                str = " platform";
            }
            if (this.f8959b == null) {
                str = str + " version";
            }
            if (this.f8960c == null) {
                str = str + " buildVersion";
            }
            if (this.f8961d == null) {
                str = str + " jailbroken";
            }
            if (str.isEmpty()) {
                return new t(this.a.intValue(), this.f8959b, this.f8960c, this.f8961d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.e.a
        public v.d.e.a b(String str) {
            Objects.requireNonNull(str, "Null buildVersion");
            this.f8960c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.e.a
        public v.d.e.a c(boolean z) {
            this.f8961d = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.e.a
        public v.d.e.a d(int i2) {
            this.a = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.e.a
        public v.d.e.a e(String str) {
            Objects.requireNonNull(str, "Null version");
            this.f8959b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.e
    public String b() {
        return this.f8957c;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.e
    public int c() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.e
    public String d() {
        return this.f8956b;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.e
    public boolean e() {
        return this.f8958d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.e) {
            v.d.e eVar = (v.d.e) obj;
            return this.a == eVar.c() && this.f8956b.equals(eVar.d()) && this.f8957c.equals(eVar.b()) && this.f8958d == eVar.e();
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.a ^ 1000003) * 1000003) ^ this.f8956b.hashCode()) * 1000003) ^ this.f8957c.hashCode()) * 1000003) ^ (this.f8958d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.a + ", version=" + this.f8956b + ", buildVersion=" + this.f8957c + ", jailbroken=" + this.f8958d + "}";
    }

    private t(int i2, String str, String str2, boolean z) {
        this.a = i2;
        this.f8956b = str;
        this.f8957c = str2;
        this.f8958d = z;
    }
}