package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.imagepipeline.common.f;
import com.facebook.imagepipeline.request.b;
import e.f.j.e.i;

/* loaded from: classes2.dex */
public class ImageRequestBuilder {
    private e.f.j.j.c n;
    private Uri a = null;

    /* renamed from: b  reason: collision with root package name */
    private b.EnumC0109b f4636b = b.EnumC0109b.FULL_FETCH;

    /* renamed from: c  reason: collision with root package name */
    private com.facebook.imagepipeline.common.e f4637c = null;

    /* renamed from: d  reason: collision with root package name */
    private f f4638d = null;

    /* renamed from: e  reason: collision with root package name */
    private com.facebook.imagepipeline.common.b f4639e = com.facebook.imagepipeline.common.b.a();

    /* renamed from: f  reason: collision with root package name */
    private b.a f4640f = b.a.DEFAULT;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4641g = i.h().a();

    /* renamed from: h  reason: collision with root package name */
    private boolean f4642h = false;

    /* renamed from: i  reason: collision with root package name */
    private com.facebook.imagepipeline.common.d f4643i = com.facebook.imagepipeline.common.d.HIGH;

    /* renamed from: j  reason: collision with root package name */
    private c f4644j = null;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4645k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4646l = true;
    private Boolean m = null;
    private com.facebook.imagepipeline.common.a o = null;
    private Boolean p = null;

    /* loaded from: classes2.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    private ImageRequestBuilder() {
    }

    public static ImageRequestBuilder b(b bVar) {
        return r(bVar.q()).v(bVar.d()).t(bVar.b()).u(bVar.c()).w(bVar.e()).x(bVar.f()).y(bVar.g()).z(bVar.k()).B(bVar.j()).C(bVar.m()).A(bVar.l()).D(bVar.o()).E(bVar.v());
    }

    public static ImageRequestBuilder r(Uri uri) {
        return new ImageRequestBuilder().F(uri);
    }

    public ImageRequestBuilder A(e.f.j.j.c cVar) {
        this.n = cVar;
        return this;
    }

    public ImageRequestBuilder B(com.facebook.imagepipeline.common.d dVar) {
        this.f4643i = dVar;
        return this;
    }

    public ImageRequestBuilder C(com.facebook.imagepipeline.common.e eVar) {
        this.f4637c = eVar;
        return this;
    }

    public ImageRequestBuilder D(f fVar) {
        this.f4638d = fVar;
        return this;
    }

    public ImageRequestBuilder E(Boolean bool) {
        this.m = bool;
        return this;
    }

    public ImageRequestBuilder F(Uri uri) {
        e.f.d.c.i.g(uri);
        this.a = uri;
        return this;
    }

    public Boolean G() {
        return this.m;
    }

    protected void H() {
        Uri uri = this.a;
        if (uri != null) {
            if (com.facebook.common.util.e.j(uri)) {
                if (this.a.isAbsolute()) {
                    if (!this.a.getPath().isEmpty()) {
                        try {
                            Integer.parseInt(this.a.getPath().substring(1));
                        } catch (NumberFormatException unused) {
                            throw new BuilderException("Resource URI path must be a resource id.");
                        }
                    } else {
                        throw new BuilderException("Resource URI must not be empty");
                    }
                } else {
                    throw new BuilderException("Resource URI path must be absolute.");
                }
            }
            if (com.facebook.common.util.e.e(this.a) && !this.a.isAbsolute()) {
                throw new BuilderException("Asset URI path must be absolute.");
            }
            return;
        }
        throw new BuilderException("Source must be set!");
    }

    public b a() {
        H();
        return new b(this);
    }

    public com.facebook.imagepipeline.common.a c() {
        return this.o;
    }

    public b.a d() {
        return this.f4640f;
    }

    public com.facebook.imagepipeline.common.b e() {
        return this.f4639e;
    }

    public b.EnumC0109b f() {
        return this.f4636b;
    }

    public c g() {
        return this.f4644j;
    }

    public e.f.j.j.c h() {
        return this.n;
    }

    public com.facebook.imagepipeline.common.d i() {
        return this.f4643i;
    }

    public com.facebook.imagepipeline.common.e j() {
        return this.f4637c;
    }

    public Boolean k() {
        return this.p;
    }

    public f l() {
        return this.f4638d;
    }

    public Uri m() {
        return this.a;
    }

    public boolean n() {
        return this.f4645k && com.facebook.common.util.e.k(this.a);
    }

    public boolean o() {
        return this.f4642h;
    }

    public boolean p() {
        return this.f4646l;
    }

    public boolean q() {
        return this.f4641g;
    }

    @Deprecated
    public ImageRequestBuilder s(boolean z) {
        if (z) {
            return D(f.a());
        }
        return D(f.d());
    }

    public ImageRequestBuilder t(com.facebook.imagepipeline.common.a aVar) {
        this.o = aVar;
        return this;
    }

    public ImageRequestBuilder u(b.a aVar) {
        this.f4640f = aVar;
        return this;
    }

    public ImageRequestBuilder v(com.facebook.imagepipeline.common.b bVar) {
        this.f4639e = bVar;
        return this;
    }

    public ImageRequestBuilder w(boolean z) {
        this.f4642h = z;
        return this;
    }

    public ImageRequestBuilder x(b.EnumC0109b enumC0109b) {
        this.f4636b = enumC0109b;
        return this;
    }

    public ImageRequestBuilder y(c cVar) {
        this.f4644j = cVar;
        return this;
    }

    public ImageRequestBuilder z(boolean z) {
        this.f4641g = z;
        return this;
    }
}