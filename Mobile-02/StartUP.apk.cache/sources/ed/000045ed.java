package e.f.h.i;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import e.f.d.c.h;
import e.f.h.h.b;
import e.f.h.i.a;

/* compiled from: DraweeView.java */
/* loaded from: classes2.dex */
public class c<DH extends e.f.h.h.b> extends ImageView {
    private static boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0270a f12370b;

    /* renamed from: c  reason: collision with root package name */
    private float f12371c;

    /* renamed from: d  reason: collision with root package name */
    private b<DH> f12372d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12373e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12374f;

    public c(Context context) {
        super(context);
        this.f12370b = new a.C0270a();
        this.f12371c = 0.0f;
        this.f12373e = false;
        this.f12374f = false;
        c(context);
    }

    private void c(Context context) {
        boolean d2;
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("DraweeView#init");
            }
            if (this.f12373e) {
                if (d2) {
                    return;
                }
                return;
            }
            boolean z = true;
            this.f12373e = true;
            this.f12372d = b.e(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList == null) {
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.b();
                        return;
                    }
                    return;
                }
                setColorFilter(imageTintList.getDefaultColor());
            }
            if (!a || context.getApplicationInfo().targetSdkVersion < 24) {
                z = false;
            }
            this.f12374f = z;
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    private void d() {
        Drawable drawable;
        if (!this.f12374f || (drawable = getDrawable()) == null) {
            return;
        }
        drawable.setVisible(getVisibility() == 0, false);
    }

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        a = z;
    }

    protected void a() {
        this.f12372d.k();
    }

    protected void b() {
        this.f12372d.l();
    }

    protected void e() {
        a();
    }

    protected void f() {
        b();
    }

    public float getAspectRatio() {
        return this.f12371c;
    }

    public e.f.h.h.a getController() {
        return this.f12372d.g();
    }

    public DH getHierarchy() {
        return this.f12372d.h();
    }

    public Drawable getTopLevelDrawable() {
        return this.f12372d.i();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        e();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
        f();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        d();
        e();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        a.C0270a c0270a = this.f12370b;
        c0270a.a = i2;
        c0270a.f12364b = i3;
        a.b(c0270a, this.f12371c, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        a.C0270a c0270a2 = this.f12370b;
        super.onMeasure(c0270a2.a, c0270a2.f12364b);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        d();
        f();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f12372d.m(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        d();
    }

    public void setAspectRatio(float f2) {
        if (f2 == this.f12371c) {
            return;
        }
        this.f12371c = f2;
        requestLayout();
    }

    public void setController(e.f.h.h.a aVar) {
        this.f12372d.o(aVar);
        super.setImageDrawable(this.f12372d.i());
    }

    public void setHierarchy(DH dh) {
        this.f12372d.p(dh);
        super.setImageDrawable(this.f12372d.i());
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        c(getContext());
        this.f12372d.o(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        c(getContext());
        this.f12372d.o(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i2) {
        c(getContext());
        this.f12372d.o(null);
        super.setImageResource(i2);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        c(getContext());
        this.f12372d.o(null);
        super.setImageURI(uri);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.f12374f = z;
    }

    @Override // android.view.View
    public String toString() {
        h.b d2 = h.d(this);
        b<DH> bVar = this.f12372d;
        return d2.b("holder", bVar != null ? bVar.toString() : "<no holder set>").toString();
    }
}