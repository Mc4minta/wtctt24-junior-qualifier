package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: AppCompatBackgroundHelper.java */
/* loaded from: classes.dex */
class e {
    private final View a;

    /* renamed from: d  reason: collision with root package name */
    private q0 f785d;

    /* renamed from: e  reason: collision with root package name */
    private q0 f786e;

    /* renamed from: f  reason: collision with root package name */
    private q0 f787f;

    /* renamed from: c  reason: collision with root package name */
    private int f784c = -1;

    /* renamed from: b  reason: collision with root package name */
    private final h f783b = h.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(View view) {
        this.a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f787f == null) {
            this.f787f = new q0();
        }
        q0 q0Var = this.f787f;
        q0Var.a();
        ColorStateList p = c.h.k.v.p(this.a);
        if (p != null) {
            q0Var.f876d = true;
            q0Var.a = p;
        }
        PorterDuff.Mode q = c.h.k.v.q(this.a);
        if (q != null) {
            q0Var.f875c = true;
            q0Var.f874b = q;
        }
        if (q0Var.f876d || q0Var.f875c) {
            h.i(drawable, q0Var, this.a.getDrawableState());
            return true;
        }
        return false;
    }

    private boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f785d != null : i2 == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            q0 q0Var = this.f786e;
            if (q0Var != null) {
                h.i(background, q0Var, this.a.getDrawableState());
                return;
            }
            q0 q0Var2 = this.f785d;
            if (q0Var2 != null) {
                h.i(background, q0Var2, this.a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        q0 q0Var = this.f786e;
        if (q0Var != null) {
            return q0Var.a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        q0 q0Var = this.f786e;
        if (q0Var != null) {
            return q0Var.f874b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i2) {
        Context context = this.a.getContext();
        int[] iArr = c.a.j.V3;
        s0 v = s0.v(context, attributeSet, iArr, i2, 0);
        View view = this.a;
        c.h.k.v.i0(view, view.getContext(), iArr, attributeSet, v.r(), i2, 0);
        try {
            int i3 = c.a.j.W3;
            if (v.s(i3)) {
                this.f784c = v.n(i3, -1);
                ColorStateList f2 = this.f783b.f(this.a.getContext(), this.f784c);
                if (f2 != null) {
                    h(f2);
                }
            }
            int i4 = c.a.j.X3;
            if (v.s(i4)) {
                c.h.k.v.n0(this.a, v.c(i4));
            }
            int i5 = c.a.j.Y3;
            if (v.s(i5)) {
                c.h.k.v.o0(this.a, z.e(v.k(i5, -1), null));
            }
        } finally {
            v.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f784c = -1;
        h(null);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i2) {
        this.f784c = i2;
        h hVar = this.f783b;
        h(hVar != null ? hVar.f(this.a.getContext(), i2) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f785d == null) {
                this.f785d = new q0();
            }
            q0 q0Var = this.f785d;
            q0Var.a = colorStateList;
            q0Var.f876d = true;
        } else {
            this.f785d = null;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f786e == null) {
            this.f786e = new q0();
        }
        q0 q0Var = this.f786e;
        q0Var.a = colorStateList;
        q0Var.f876d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f786e == null) {
            this.f786e = new q0();
        }
        q0 q0Var = this.f786e;
        q0Var.f874b = mode;
        q0Var.f875c = true;
        b();
    }
}