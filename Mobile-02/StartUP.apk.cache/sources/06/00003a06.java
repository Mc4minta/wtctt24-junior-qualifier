package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class e extends v.c.b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f8850b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.c.b.a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f8851b;

        @Override // com.google.firebase.crashlytics.c.i.v.c.b.a
        public v.c.b a() {
            String str = "";
            if (this.a == null) {
                str = " filename";
            }
            if (this.f8851b == null) {
                str = str + " contents";
            }
            if (str.isEmpty()) {
                return new e(this.a, this.f8851b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.c.b.a
        public v.c.b.a b(byte[] bArr) {
            Objects.requireNonNull(bArr, "Null contents");
            this.f8851b = bArr;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.c.b.a
        public v.c.b.a c(String str) {
            Objects.requireNonNull(str, "Null filename");
            this.a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.c.b
    public byte[] b() {
        return this.f8850b;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.c.b
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.c.b) {
            v.c.b bVar = (v.c.b) obj;
            if (this.a.equals(bVar.c())) {
                if (Arrays.equals(this.f8850b, bVar instanceof e ? ((e) bVar).f8850b : bVar.b())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f8850b);
    }

    public String toString() {
        return "File{filename=" + this.a + ", contents=" + Arrays.toString(this.f8850b) + "}";
    }

    private e(String str, byte[] bArr) {
        this.a = str;
        this.f8850b = bArr;
    }
}