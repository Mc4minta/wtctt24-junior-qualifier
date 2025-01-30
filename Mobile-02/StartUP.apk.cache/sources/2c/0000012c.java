package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: AppCompatImageHelper.java */
/* loaded from: classes.dex */
public class k {
    private final ImageView a;

    /* renamed from: b  reason: collision with root package name */
    private q0 f826b;

    /* renamed from: c  reason: collision with root package name */
    private q0 f827c;

    /* renamed from: d  reason: collision with root package name */
    private q0 f828d;

    public k(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f828d == null) {
            this.f828d = new q0();
        }
        q0 q0Var = this.f828d;
        q0Var.a();
        ColorStateList a = androidx.core.widget.e.a(this.a);
        if (a != null) {
            q0Var.f876d = true;
            q0Var.a = a;
        }
        PorterDuff.Mode b2 = androidx.core.widget.e.b(this.a);
        if (b2 != null) {
            q0Var.f875c = true;
            q0Var.f874b = b2;
        }
        if (q0Var.f876d || q0Var.f875c) {
            h.i(drawable, q0Var, this.a.getDrawableState());
            return true;
        }
        return false;
    }

    private boolean j() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f826b != null : i2 == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            z.b(drawable);
        }
        if (drawable != null) {
            if (j() && a(drawable)) {
                return;
            }
            q0 q0Var = this.f827c;
            if (q0Var != null) {
                h.i(drawable, q0Var, this.a.getDrawableState());
                return;
            }
            q0 q0Var2 = this.f826b;
            if (q0Var2 != null) {
                h.i(drawable, q0Var2, this.a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        q0 q0Var = this.f827c;
        if (q0Var != null) {
            return q0Var.a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        q0 q0Var = this.f827c;
        if (q0Var != null) {
            return q0Var.f874b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return Build.VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i2) {
        int n;
        Context context = this.a.getContext();
        int[] iArr = c.a.j.R;
        s0 v = s0.v(context, attributeSet, iArr, i2, 0);
        ImageView imageView = this.a;
        c.h.k.v.i0(imageView, imageView.getContext(), iArr, attributeSet, v.r(), i2, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (n = v.n(c.a.j.S, -1)) != -1 && (drawable = c.a.k.a.a.d(this.a.getContext(), n)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                z.b(drawable);
            }
            int i3 = c.a.j.T;
            if (v.s(i3)) {
                androidx.core.widget.e.c(this.a, v.c(i3));
            }
            int i4 = c.a.j.U;
            if (v.s(i4)) {
                androidx.core.widget.e.d(this.a, z.e(v.k(i4, -1), null));
            }
        } finally {
            v.w();
        }
    }

    public void g(int i2) {
        if (i2 != 0) {
            Drawable d2 = c.a.k.a.a.d(this.a.getContext(), i2);
            if (d2 != null) {
                z.b(d2);
            }
            this.a.setImageDrawable(d2);
        } else {
            this.a.setImageDrawable(null);
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (this.f827c == null) {
            this.f827c = new q0();
        }
        q0 q0Var = this.f827c;
        q0Var.a = colorStateList;
        q0Var.f876d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(PorterDuff.Mode mode) {
        if (this.f827c == null) {
            this.f827c = new q0();
        }
        q0 q0Var = this.f827c;
        q0Var.f874b = mode;
        q0Var.f875c = true;
        b();
    }
}