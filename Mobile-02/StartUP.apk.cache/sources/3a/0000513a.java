package j;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: Segment.kt */
/* loaded from: classes3.dex */
public final class z {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f17187b;

    /* renamed from: c  reason: collision with root package name */
    public int f17188c;

    /* renamed from: d  reason: collision with root package name */
    public int f17189d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17190e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17191f;

    /* renamed from: g  reason: collision with root package name */
    public z f17192g;

    /* renamed from: h  reason: collision with root package name */
    public z f17193h;

    /* compiled from: Segment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public z() {
        this.f17187b = new byte[PKIFailureInfo.certRevoked];
        this.f17191f = true;
        this.f17190e = false;
    }

    public final void a() {
        z zVar = this.f17193h;
        int i2 = 0;
        if (zVar != this) {
            kotlin.jvm.internal.m.e(zVar);
            if (zVar.f17191f) {
                int i3 = this.f17189d - this.f17188c;
                z zVar2 = this.f17193h;
                kotlin.jvm.internal.m.e(zVar2);
                int i4 = 8192 - zVar2.f17189d;
                z zVar3 = this.f17193h;
                kotlin.jvm.internal.m.e(zVar3);
                if (!zVar3.f17190e) {
                    z zVar4 = this.f17193h;
                    kotlin.jvm.internal.m.e(zVar4);
                    i2 = zVar4.f17188c;
                }
                if (i3 > i4 + i2) {
                    return;
                }
                z zVar5 = this.f17193h;
                kotlin.jvm.internal.m.e(zVar5);
                g(zVar5, i3);
                b();
                a0.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    public final z b() {
        z zVar = this.f17192g;
        if (zVar == this) {
            zVar = null;
        }
        z zVar2 = this.f17193h;
        kotlin.jvm.internal.m.e(zVar2);
        zVar2.f17192g = this.f17192g;
        z zVar3 = this.f17192g;
        kotlin.jvm.internal.m.e(zVar3);
        zVar3.f17193h = this.f17193h;
        this.f17192g = null;
        this.f17193h = null;
        return zVar;
    }

    public final z c(z segment) {
        kotlin.jvm.internal.m.g(segment, "segment");
        segment.f17193h = this;
        segment.f17192g = this.f17192g;
        z zVar = this.f17192g;
        kotlin.jvm.internal.m.e(zVar);
        zVar.f17193h = segment;
        this.f17192g = segment;
        return segment;
    }

    public final z d() {
        this.f17190e = true;
        return new z(this.f17187b, this.f17188c, this.f17189d, true, false);
    }

    public final z e(int i2) {
        z c2;
        if (i2 > 0 && i2 <= this.f17189d - this.f17188c) {
            if (i2 >= 1024) {
                c2 = d();
            } else {
                c2 = a0.c();
                byte[] bArr = this.f17187b;
                byte[] bArr2 = c2.f17187b;
                int i3 = this.f17188c;
                kotlin.a0.m.f(bArr, bArr2, 0, i3, i3 + i2, 2, null);
            }
            c2.f17189d = c2.f17188c + i2;
            this.f17188c += i2;
            z zVar = this.f17193h;
            kotlin.jvm.internal.m.e(zVar);
            zVar.c(c2);
            return c2;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    public final z f() {
        byte[] bArr = this.f17187b;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.m.f(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new z(copyOf, this.f17188c, this.f17189d, false, true);
    }

    public final void g(z sink, int i2) {
        kotlin.jvm.internal.m.g(sink, "sink");
        if (sink.f17191f) {
            int i3 = sink.f17189d;
            if (i3 + i2 > 8192) {
                if (!sink.f17190e) {
                    int i4 = sink.f17188c;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = sink.f17187b;
                        kotlin.a0.m.f(bArr, bArr, 0, i4, i3, 2, null);
                        sink.f17189d -= sink.f17188c;
                        sink.f17188c = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.f17187b;
            byte[] bArr3 = sink.f17187b;
            int i5 = sink.f17189d;
            int i6 = this.f17188c;
            kotlin.a0.m.d(bArr2, bArr3, i5, i6, i6 + i2);
            sink.f17189d += i2;
            this.f17188c += i2;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public z(byte[] data, int i2, int i3, boolean z, boolean z2) {
        kotlin.jvm.internal.m.g(data, "data");
        this.f17187b = data;
        this.f17188c = i2;
        this.f17189d = i3;
        this.f17190e = z;
        this.f17191f = z2;
    }
}