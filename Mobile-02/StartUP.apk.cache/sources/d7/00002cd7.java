package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.imagepipeline.common.f;
import e.f.d.c.h;
import java.io.File;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: ImageRequest.java */
/* loaded from: classes2.dex */
public class b {
    private final a a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f4647b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4648c;

    /* renamed from: d  reason: collision with root package name */
    private File f4649d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f4650e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f4651f;

    /* renamed from: g  reason: collision with root package name */
    private final com.facebook.imagepipeline.common.b f4652g;

    /* renamed from: h  reason: collision with root package name */
    private final com.facebook.imagepipeline.common.e f4653h;

    /* renamed from: i  reason: collision with root package name */
    private final f f4654i;

    /* renamed from: j  reason: collision with root package name */
    private final com.facebook.imagepipeline.common.a f4655j;

    /* renamed from: k  reason: collision with root package name */
    private final com.facebook.imagepipeline.common.d f4656k;

    /* renamed from: l  reason: collision with root package name */
    private final EnumC0109b f4657l;
    private final boolean m;
    private final boolean n;
    private final Boolean o;
    private final c p;
    private final e.f.j.j.c q;
    private final Boolean r;

    /* compiled from: ImageRequest.java */
    /* loaded from: classes2.dex */
    public enum a {
        SMALL,
        DEFAULT
    }

    /* compiled from: ImageRequest.java */
    /* renamed from: com.facebook.imagepipeline.request.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0109b {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);
        

        /* renamed from: f  reason: collision with root package name */
        private int f4664f;

        EnumC0109b(int i2) {
            this.f4664f = i2;
        }

        public static EnumC0109b h(EnumC0109b enumC0109b, EnumC0109b enumC0109b2) {
            return enumC0109b.n() > enumC0109b2.n() ? enumC0109b : enumC0109b2;
        }

        public int n() {
            return this.f4664f;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(ImageRequestBuilder imageRequestBuilder) {
        this.a = imageRequestBuilder.d();
        Uri m = imageRequestBuilder.m();
        this.f4647b = m;
        this.f4648c = s(m);
        this.f4650e = imageRequestBuilder.q();
        this.f4651f = imageRequestBuilder.o();
        this.f4652g = imageRequestBuilder.e();
        this.f4653h = imageRequestBuilder.j();
        this.f4654i = imageRequestBuilder.l() == null ? f.a() : imageRequestBuilder.l();
        this.f4655j = imageRequestBuilder.c();
        this.f4656k = imageRequestBuilder.i();
        this.f4657l = imageRequestBuilder.f();
        this.m = imageRequestBuilder.n();
        this.n = imageRequestBuilder.p();
        this.o = imageRequestBuilder.G();
        this.p = imageRequestBuilder.g();
        this.q = imageRequestBuilder.h();
        this.r = imageRequestBuilder.k();
    }

    public static b a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.r(uri).a();
    }

    private static int s(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.e.k(uri)) {
            return 0;
        }
        if (com.facebook.common.util.e.i(uri)) {
            return e.f.d.e.a.c(e.f.d.e.a.b(uri.getPath())) ? 2 : 3;
        } else if (com.facebook.common.util.e.h(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.e.e(uri)) {
                return 5;
            }
            if (com.facebook.common.util.e.j(uri)) {
                return 6;
            }
            if (com.facebook.common.util.e.d(uri)) {
                return 7;
            }
            return com.facebook.common.util.e.l(uri) ? 8 : -1;
        }
    }

    public com.facebook.imagepipeline.common.a b() {
        return this.f4655j;
    }

    public a c() {
        return this.a;
    }

    public com.facebook.imagepipeline.common.b d() {
        return this.f4652g;
    }

    public boolean e() {
        return this.f4651f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (h.a(this.f4647b, bVar.f4647b) && h.a(this.a, bVar.a) && h.a(this.f4649d, bVar.f4649d) && h.a(this.f4655j, bVar.f4655j) && h.a(this.f4652g, bVar.f4652g) && h.a(this.f4653h, bVar.f4653h) && h.a(this.f4654i, bVar.f4654i)) {
                c cVar = this.p;
                e.f.b.a.d c2 = cVar != null ? cVar.c() : null;
                c cVar2 = bVar.p;
                return h.a(c2, cVar2 != null ? cVar2.c() : null);
            }
            return false;
        }
        return false;
    }

    public EnumC0109b f() {
        return this.f4657l;
    }

    public c g() {
        return this.p;
    }

    public int h() {
        com.facebook.imagepipeline.common.e eVar = this.f4653h;
        return eVar != null ? eVar.f4529b : PKIFailureInfo.wrongIntegrity;
    }

    public int hashCode() {
        c cVar = this.p;
        return h.b(this.a, this.f4647b, this.f4649d, this.f4655j, this.f4652g, this.f4653h, this.f4654i, cVar != null ? cVar.c() : null, this.r);
    }

    public int i() {
        com.facebook.imagepipeline.common.e eVar = this.f4653h;
        return eVar != null ? eVar.a : PKIFailureInfo.wrongIntegrity;
    }

    public com.facebook.imagepipeline.common.d j() {
        return this.f4656k;
    }

    public boolean k() {
        return this.f4650e;
    }

    public e.f.j.j.c l() {
        return this.q;
    }

    public com.facebook.imagepipeline.common.e m() {
        return this.f4653h;
    }

    public Boolean n() {
        return this.r;
    }

    public f o() {
        return this.f4654i;
    }

    public synchronized File p() {
        if (this.f4649d == null) {
            this.f4649d = new File(this.f4647b.getPath());
        }
        return this.f4649d;
    }

    public Uri q() {
        return this.f4647b;
    }

    public int r() {
        return this.f4648c;
    }

    public boolean t() {
        return this.m;
    }

    public String toString() {
        return h.d(this).b("uri", this.f4647b).b("cacheChoice", this.a).b("decodeOptions", this.f4652g).b("postprocessor", this.p).b("priority", this.f4656k).b("resizeOptions", this.f4653h).b("rotationOptions", this.f4654i).b("bytesRange", this.f4655j).b("resizingAllowedOverride", this.r).toString();
    }

    public boolean u() {
        return this.n;
    }

    public Boolean v() {
        return this.o;
    }
}