package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class d extends v.c {
    private final w<v.c.b> a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8848b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.c.a {
        private w<v.c.b> a;

        /* renamed from: b  reason: collision with root package name */
        private String f8849b;

        @Override // com.google.firebase.crashlytics.c.i.v.c.a
        public v.c a() {
            String str = "";
            if (this.a == null) {
                str = " files";
            }
            if (str.isEmpty()) {
                return new d(this.a, this.f8849b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.c.a
        public v.c.a b(w<v.c.b> wVar) {
            Objects.requireNonNull(wVar, "Null files");
            this.a = wVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.c.a
        public v.c.a c(String str) {
            this.f8849b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.c
    public w<v.c.b> b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.c
    public String c() {
        return this.f8848b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.c) {
            v.c cVar = (v.c) obj;
            if (this.a.equals(cVar.b())) {
                String str = this.f8848b;
                if (str == null) {
                    if (cVar.c() == null) {
                        return true;
                    }
                } else if (str.equals(cVar.c())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.f8848b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.a + ", orgId=" + this.f8848b + "}";
    }

    private d(w<v.c.b> wVar, String str) {
        this.a = wVar;
        this.f8848b = str;
    }
}