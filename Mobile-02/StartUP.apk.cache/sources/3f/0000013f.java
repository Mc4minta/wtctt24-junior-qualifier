package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: AppCompatSeekBarHelper.java */
/* loaded from: classes.dex */
class r extends n {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f877d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f878e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f879f;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f880g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f881h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f882i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SeekBar seekBar) {
        super(seekBar);
        this.f879f = null;
        this.f880g = null;
        this.f881h = false;
        this.f882i = false;
        this.f877d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f878e;
        if (drawable != null) {
            if (this.f881h || this.f882i) {
                Drawable r = androidx.core.graphics.drawable.a.r(drawable.mutate());
                this.f878e = r;
                if (this.f881h) {
                    androidx.core.graphics.drawable.a.o(r, this.f879f);
                }
                if (this.f882i) {
                    androidx.core.graphics.drawable.a.p(this.f878e, this.f880g);
                }
                if (this.f878e.isStateful()) {
                    this.f878e.setState(this.f877d.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.n
    public void c(AttributeSet attributeSet, int i2) {
        super.c(attributeSet, i2);
        Context context = this.f877d.getContext();
        int[] iArr = c.a.j.V;
        s0 v = s0.v(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f877d;
        c.h.k.v.i0(seekBar, seekBar.getContext(), iArr, attributeSet, v.r(), i2, 0);
        Drawable h2 = v.h(c.a.j.W);
        if (h2 != null) {
            this.f877d.setThumb(h2);
        }
        j(v.g(c.a.j.X));
        int i3 = c.a.j.Z;
        if (v.s(i3)) {
            this.f880g = z.e(v.k(i3, -1), this.f880g);
            this.f882i = true;
        }
        int i4 = c.a.j.Y;
        if (v.s(i4)) {
            this.f879f = v.c(i4);
            this.f881h = true;
        }
        v.w();
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.f878e != null) {
            int max = this.f877d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f878e.getIntrinsicWidth();
                int intrinsicHeight = this.f878e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i3 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f878e.setBounds(-i2, -i3, i2, i3);
                float width = ((this.f877d.getWidth() - this.f877d.getPaddingLeft()) - this.f877d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f877d.getPaddingLeft(), this.f877d.getHeight() / 2);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f878e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f878e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f877d.getDrawableState())) {
            this.f877d.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f878e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f878e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f878e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f877d);
            androidx.core.graphics.drawable.a.m(drawable, c.h.k.v.y(this.f877d));
            if (drawable.isStateful()) {
                drawable.setState(this.f877d.getDrawableState());
            }
            f();
        }
        this.f877d.invalidate();
    }
}