package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class c extends v.b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8846b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.b.a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f8847b;

        @Override // com.google.firebase.crashlytics.c.i.v.b.a
        public v.b a() {
            String str = "";
            if (this.a == null) {
                str = " key";
            }
            if (this.f8847b == null) {
                str = str + " value";
            }
            if (str.isEmpty()) {
                return new c(this.a, this.f8847b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.b.a
        public v.b.a b(String str) {
            Objects.requireNonNull(str, "Null key");
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.b.a
        public v.b.a c(String str) {
            Objects.requireNonNull(str, "Null value");
            this.f8847b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.b
    public String b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.b
    public String c() {
        return this.f8846b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.b) {
            v.b bVar = (v.b) obj;
            return this.a.equals(bVar.b()) && this.f8846b.equals(bVar.c());
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f8846b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.a + ", value=" + this.f8846b + "}";
    }

    private c(String str, String str2) {
        this.a = str;
        this.f8846b = str2;
    }
}