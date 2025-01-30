package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class s extends v.d.AbstractC0173d.AbstractC0184d {
    private final String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.AbstractC0173d.AbstractC0184d.a {
        private String a;

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.AbstractC0184d.a
        public v.d.AbstractC0173d.AbstractC0184d a() {
            String str = "";
            if (this.a == null) {
                str = " content";
            }
            if (str.isEmpty()) {
                return new s(this.a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.AbstractC0184d.a
        public v.d.AbstractC0173d.AbstractC0184d.a b(String str) {
            Objects.requireNonNull(str, "Null content");
            this.a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.AbstractC0184d
    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.AbstractC0173d.AbstractC0184d) {
            return this.a.equals(((v.d.AbstractC0173d.AbstractC0184d) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.a + "}";
    }

    private s(String str) {
        this.a = str;
    }
}