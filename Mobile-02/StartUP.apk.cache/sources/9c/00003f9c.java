package com.squareup.wire;

import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ProtoWriter.kt */
/* loaded from: classes2.dex */
public final class l {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final j.g f10874b;

    /* compiled from: ProtoWriter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int g(int i2, c cVar) {
            return (i2 << 3) | cVar.h();
        }

        public final int b(int i2) {
            return (-(i2 & 1)) ^ (i2 >>> 1);
        }

        public final long c(long j2) {
            return (-(j2 & 1)) ^ (j2 >>> 1);
        }

        public final int d(int i2) {
            return (i2 >> 31) ^ (i2 << 1);
        }

        public final long e(long j2) {
            return (j2 >> 63) ^ (j2 << 1);
        }

        public final int f(int i2) {
            if (i2 >= 0) {
                return i(i2);
            }
            return 10;
        }

        public final int h(int i2) {
            return i(g(i2, c.VARINT));
        }

        public final int i(int i2) {
            if ((i2 & (-128)) == 0) {
                return 1;
            }
            if ((i2 & (-16384)) == 0) {
                return 2;
            }
            if (((-2097152) & i2) == 0) {
                return 3;
            }
            return (i2 & (-268435456)) == 0 ? 4 : 5;
        }

        public final int j(long j2) {
            if (((-128) & j2) == 0) {
                return 1;
            }
            if (((-16384) & j2) == 0) {
                return 2;
            }
            if (((-2097152) & j2) == 0) {
                return 3;
            }
            if (((-268435456) & j2) == 0) {
                return 4;
            }
            if (((-34359738368L) & j2) == 0) {
                return 5;
            }
            if (((-4398046511104L) & j2) == 0) {
                return 6;
            }
            if (((-562949953421312L) & j2) == 0) {
                return 7;
            }
            if (((-72057594037927936L) & j2) == 0) {
                return 8;
            }
            return (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public l(j.g sink) {
        kotlin.jvm.internal.m.h(sink, "sink");
        this.f10874b = sink;
    }

    public final void a(j.i value) throws IOException {
        kotlin.jvm.internal.m.h(value, "value");
        this.f10874b.K0(value);
    }

    public final void b(int i2) throws IOException {
        this.f10874b.P(i2);
    }

    public final void c(long j2) throws IOException {
        this.f10874b.F(j2);
    }

    public final void d(int i2) throws IOException {
        if (i2 >= 0) {
            g(i2);
        } else {
            h(i2);
        }
    }

    public final void e(String value) throws IOException {
        kotlin.jvm.internal.m.h(value, "value");
        this.f10874b.h0(value);
    }

    public final void f(int i2, c fieldEncoding) throws IOException {
        kotlin.jvm.internal.m.h(fieldEncoding, "fieldEncoding");
        g(a.g(i2, fieldEncoding));
    }

    public final void g(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            this.f10874b.R((i2 & 127) | 128);
            i2 >>>= 7;
        }
        this.f10874b.R(i2);
    }

    public final void h(long j2) throws IOException {
        while (((-128) & j2) != 0) {
            this.f10874b.R((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        this.f10874b.R((int) j2);
    }
}