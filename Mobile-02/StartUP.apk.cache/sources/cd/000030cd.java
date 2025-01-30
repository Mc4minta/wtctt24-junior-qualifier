package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.f;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final class a extends f {
    private final Iterable<e.g.a.c.i.h> a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f5812b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    public static final class b extends f.a {
        private Iterable<e.g.a.c.i.h> a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f5813b;

        @Override // com.google.android.datatransport.runtime.backends.f.a
        public f a() {
            String str = "";
            if (this.a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.f5813b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.backends.f.a
        public f.a b(Iterable<e.g.a.c.i.h> iterable) {
            Objects.requireNonNull(iterable, "Null events");
            this.a = iterable;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.backends.f.a
        public f.a c(byte[] bArr) {
            this.f5813b = bArr;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public Iterable<e.g.a.c.i.h> b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public byte[] c() {
        return this.f5812b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.a.equals(fVar.b())) {
                if (Arrays.equals(this.f5812b, fVar instanceof a ? ((a) fVar).f5812b : fVar.c())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f5812b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.a + ", extras=" + Arrays.toString(this.f5812b) + "}";
    }

    private a(Iterable<e.g.a.c.i.h> iterable, byte[] bArr) {
        this.a = iterable;
        this.f5812b = bArr;
    }
}