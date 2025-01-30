package e.f.h.i;

import android.net.Uri;
import e.f.d.c.l;

/* compiled from: SimpleDraweeView.java */
/* loaded from: classes2.dex */
public class e extends d {

    /* renamed from: g  reason: collision with root package name */
    private static l<? extends e.f.h.c.b> f12375g;

    /* renamed from: h  reason: collision with root package name */
    private e.f.h.c.b f12376h;

    public static void g(l<? extends e.f.h.c.b> lVar) {
        f12375g = lVar;
    }

    protected e.f.h.c.b getControllerBuilder() {
        return this.f12376h;
    }

    public void h(int i2, Object obj) {
        i(com.facebook.common.util.e.c(i2), obj);
    }

    public void i(Uri uri, Object obj) {
        setController(this.f12376h.y(obj).a(uri).b(getController()).build());
    }

    public void j(String str, Object obj) {
        i(str != null ? Uri.parse(str) : null, obj);
    }

    public void setActualImageResource(int i2) {
        h(i2, null);
    }

    public void setImageRequest(com.facebook.imagepipeline.request.b bVar) {
        setController(this.f12376h.A(bVar).b(getController()).build());
    }

    @Override // e.f.h.i.c, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
    }

    @Override // e.f.h.i.c, android.widget.ImageView
    public void setImageURI(Uri uri) {
        i(uri, null);
    }

    public void setImageURI(String str) {
        j(str, null);
    }
}