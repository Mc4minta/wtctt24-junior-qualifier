package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ProtoReader.kt */
/* loaded from: classes2.dex */
public final class k {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private long f10865b;

    /* renamed from: c  reason: collision with root package name */
    private long f10866c;

    /* renamed from: d  reason: collision with root package name */
    private int f10867d;

    /* renamed from: e  reason: collision with root package name */
    private int f10868e;

    /* renamed from: f  reason: collision with root package name */
    private int f10869f;

    /* renamed from: g  reason: collision with root package name */
    private long f10870g;

    /* renamed from: h  reason: collision with root package name */
    private c f10871h;

    /* renamed from: i  reason: collision with root package name */
    private final List<j.f> f10872i;

    /* renamed from: j  reason: collision with root package name */
    private final j.h f10873j;

    /* compiled from: ProtoReader.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k(j.h source) {
        kotlin.jvm.internal.m.h(source, "source");
        this.f10873j = source;
        this.f10866c = Long.MAX_VALUE;
        this.f10868e = 2;
        this.f10869f = -1;
        this.f10870g = -1L;
        this.f10872i = new ArrayList();
    }

    private final void b(int i2) throws IOException {
        if (this.f10868e == i2) {
            this.f10868e = 6;
            return;
        }
        long j2 = this.f10865b;
        long j3 = this.f10866c;
        if (j2 > j3) {
            throw new IOException("Expected to end at " + this.f10866c + " but was " + this.f10865b);
        } else if (j2 == j3) {
            this.f10866c = this.f10870g;
            this.f10870g = -1L;
            this.f10868e = 6;
        } else {
            this.f10868e = 7;
        }
    }

    private final long c() throws IOException {
        if (this.f10868e == 2) {
            long j2 = this.f10866c - this.f10865b;
            this.f10873j.Z0(j2);
            this.f10868e = 6;
            this.f10865b = this.f10866c;
            this.f10866c = this.f10870g;
            this.f10870g = -1L;
            return j2;
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f10868e);
    }

    private final int f() {
        int i2;
        this.f10873j.Z0(1L);
        this.f10865b++;
        byte m0 = this.f10873j.m0();
        if (m0 >= 0) {
            return m0;
        }
        int i3 = m0 & Byte.MAX_VALUE;
        this.f10873j.Z0(1L);
        this.f10865b++;
        byte m02 = this.f10873j.m0();
        if (m02 >= 0) {
            i2 = m02 << 7;
        } else {
            i3 |= (m02 & Byte.MAX_VALUE) << 7;
            this.f10873j.Z0(1L);
            this.f10865b++;
            byte m03 = this.f10873j.m0();
            if (m03 >= 0) {
                i2 = m03 << 14;
            } else {
                i3 |= (m03 & Byte.MAX_VALUE) << 14;
                this.f10873j.Z0(1L);
                this.f10865b++;
                byte m04 = this.f10873j.m0();
                if (m04 < 0) {
                    int i4 = i3 | ((m04 & Byte.MAX_VALUE) << 21);
                    this.f10873j.Z0(1L);
                    this.f10865b++;
                    byte m05 = this.f10873j.m0();
                    int i5 = i4 | (m05 << 28);
                    if (m05 < 0) {
                        for (int i6 = 0; i6 <= 4; i6++) {
                            this.f10873j.Z0(1L);
                            this.f10865b++;
                            if (this.f10873j.m0() >= 0) {
                                return i5;
                            }
                        }
                        throw new ProtocolException("Malformed VARINT");
                    }
                    return i5;
                }
                i2 = m04 << 21;
            }
        }
        return i3 | i2;
    }

    private final void p(int i2) {
        while (this.f10865b < this.f10866c && !this.f10873j.Q()) {
            int f2 = f();
            if (f2 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i3 = f2 >> 3;
            int i4 = f2 & 7;
            if (i4 == 3) {
                p(i3);
            } else if (i4 == 4) {
                if (i3 != i2) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else if (i4 == 2) {
                long f3 = f();
                this.f10865b += f3;
                this.f10873j.skip(f3);
            } else if (i4 == 0) {
                this.f10868e = 0;
                o();
            } else if (i4 == 1) {
                this.f10868e = 1;
                k();
            } else if (i4 == 5) {
                this.f10868e = 5;
                j();
            } else {
                throw new ProtocolException("Unexpected field encoding: " + i4);
            }
        }
        throw new EOFException();
    }

    public final void a(int i2, c fieldEncoding, Object obj) {
        kotlin.jvm.internal.m.h(fieldEncoding, "fieldEncoding");
        l lVar = new l(this.f10872i.get(this.f10867d - 1));
        ProtoAdapter<?> n = fieldEncoding.n();
        if (n == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
        }
        n.encodeWithTag(lVar, i2, obj);
    }

    public final long d() throws IOException {
        if (this.f10868e == 2) {
            int i2 = this.f10867d + 1;
            this.f10867d = i2;
            if (i2 <= 65) {
                if (i2 > this.f10872i.size()) {
                    this.f10872i.add(new j.f());
                }
                long j2 = this.f10870g;
                this.f10870g = -1L;
                this.f10868e = 6;
                return j2;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()".toString());
    }

    public final j.i e(long j2) throws IOException {
        boolean z = true;
        if (this.f10868e == 6) {
            int i2 = this.f10867d - 1;
            this.f10867d = i2;
            if (i2 < 0 || this.f10870g != -1) {
                z = false;
            }
            if (z) {
                if (this.f10865b != this.f10866c && i2 != 0) {
                    throw new IOException("Expected to end at " + this.f10866c + " but was " + this.f10865b);
                }
                this.f10866c = j2;
                j.f fVar = this.f10872i.get(i2);
                if (fVar.O0() > 0) {
                    return fVar.v0();
                }
                return j.i.a;
            }
            throw new IllegalStateException("No corresponding call to beginMessage()".toString());
        }
        throw new IllegalStateException("Unexpected call to endMessage()".toString());
    }

    public final int g() throws IOException {
        int i2 = this.f10868e;
        if (i2 == 7) {
            this.f10868e = 2;
            return this.f10869f;
        } else if (i2 == 6) {
            while (this.f10865b < this.f10866c && !this.f10873j.Q()) {
                int f2 = f();
                if (f2 != 0) {
                    int i3 = f2 >> 3;
                    this.f10869f = i3;
                    int i4 = f2 & 7;
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 2) {
                                if (i4 == 0) {
                                    this.f10871h = c.VARINT;
                                    this.f10868e = 0;
                                    return i3;
                                } else if (i4 == 1) {
                                    this.f10871h = c.FIXED64;
                                    this.f10868e = 1;
                                    return i3;
                                } else if (i4 == 5) {
                                    this.f10871h = c.FIXED32;
                                    this.f10868e = 5;
                                    return i3;
                                } else {
                                    throw new ProtocolException("Unexpected field encoding: " + i4);
                                }
                            }
                            this.f10871h = c.LENGTH_DELIMITED;
                            this.f10868e = 2;
                            int f3 = f();
                            if (f3 >= 0) {
                                if (this.f10870g == -1) {
                                    long j2 = this.f10866c;
                                    this.f10870g = j2;
                                    long j3 = this.f10865b + f3;
                                    this.f10866c = j3;
                                    if (j3 <= j2) {
                                        return this.f10869f;
                                    }
                                    throw new EOFException();
                                }
                                throw new IllegalStateException();
                            }
                            throw new ProtocolException("Negative length: " + f3);
                        }
                        throw new ProtocolException("Unexpected end group");
                    }
                    p(i3);
                } else {
                    throw new ProtocolException("Unexpected tag 0");
                }
            }
            return -1;
        } else {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
    }

    public final c h() {
        return this.f10871h;
    }

    public final j.i i() throws IOException {
        long c2 = c();
        this.f10873j.Z0(c2);
        return this.f10873j.s(c2);
    }

    public final int j() throws IOException {
        int i2 = this.f10868e;
        if (i2 != 5 && i2 != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f10868e);
        }
        this.f10873j.Z0(4L);
        this.f10865b += 4;
        int D0 = this.f10873j.D0();
        b(5);
        return D0;
    }

    public final long k() throws IOException {
        int i2 = this.f10868e;
        if (i2 != 1 && i2 != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f10868e);
        }
        this.f10873j.Z0(8L);
        this.f10865b += 8;
        long P0 = this.f10873j.P0();
        b(1);
        return P0;
    }

    public final String l() throws IOException {
        long c2 = c();
        this.f10873j.Z0(c2);
        return this.f10873j.p(c2);
    }

    public final void m(int i2) {
        c h2 = h();
        if (h2 == null) {
            kotlin.jvm.internal.m.q();
        }
        a(i2, h2, h2.n().decode(this));
    }

    public final int n() throws IOException {
        int i2 = this.f10868e;
        if (i2 != 0 && i2 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f10868e);
        }
        int f2 = f();
        b(0);
        return f2;
    }

    public final long o() throws IOException {
        byte m0;
        int i2 = this.f10868e;
        if (i2 != 0 && i2 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f10868e);
        }
        long j2 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            this.f10873j.Z0(1L);
            this.f10865b++;
            j2 |= (m0 & Byte.MAX_VALUE) << i3;
            if ((this.f10873j.m0() & 128) == 0) {
                b(0);
                return j2;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }
}