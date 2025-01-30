package e.g.a.f.m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.i;
import c.h.k.v;
import com.google.android.material.internal.h;
import e.g.a.f.j;
import e.g.a.f.k;

/* compiled from: MaterialButton.java */
/* loaded from: classes2.dex */
public class a extends AppCompatButton {

    /* renamed from: c  reason: collision with root package name */
    private final c f13305c;

    /* renamed from: d  reason: collision with root package name */
    private int f13306d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f13307e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f13308f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f13309g;

    /* renamed from: h  reason: collision with root package name */
    private int f13310h;

    /* renamed from: j  reason: collision with root package name */
    private int f13311j;

    /* renamed from: k  reason: collision with root package name */
    private int f13312k;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.g.a.f.b.f13231f);
    }

    private boolean a() {
        return v.y(this) == 1;
    }

    private boolean b() {
        c cVar = this.f13305c;
        return (cVar == null || cVar.j()) ? false : true;
    }

    private void c() {
        Drawable drawable = this.f13309g;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f13309g = mutate;
            androidx.core.graphics.drawable.a.o(mutate, this.f13308f);
            PorterDuff.Mode mode = this.f13307e;
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(this.f13309g, mode);
            }
            int i2 = this.f13310h;
            if (i2 == 0) {
                i2 = this.f13309g.getIntrinsicWidth();
            }
            int i3 = this.f13310h;
            if (i3 == 0) {
                i3 = this.f13309g.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f13309g;
            int i4 = this.f13311j;
            drawable2.setBounds(i4, 0, i2 + i4, i3);
        }
        i.l(this, this.f13309g, null, null, null);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (b()) {
            return this.f13305c.d();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f13309g;
    }

    public int getIconGravity() {
        return this.f13312k;
    }

    public int getIconPadding() {
        return this.f13306d;
    }

    public int getIconSize() {
        return this.f13310h;
    }

    public ColorStateList getIconTint() {
        return this.f13308f;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f13307e;
    }

    public ColorStateList getRippleColor() {
        if (b()) {
            return this.f13305c.e();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.f13305c.f();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (b()) {
            return this.f13305c.g();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, c.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        if (b()) {
            return this.f13305c.h();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, c.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (b()) {
            return this.f13305c.i();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT >= 21 || !b()) {
            return;
        }
        this.f13305c.c(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        c cVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT != 21 || (cVar = this.f13305c) == null) {
            return;
        }
        cVar.v(i5 - i3, i4 - i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f13309g == null || this.f13312k != 2) {
            return;
        }
        int measureText = (int) getPaint().measureText(getText().toString());
        int i4 = this.f13310h;
        if (i4 == 0) {
            i4 = this.f13309g.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - measureText) - v.C(this)) - i4) - this.f13306d) - v.D(this)) / 2;
        if (a()) {
            measuredWidth = -measuredWidth;
        }
        if (this.f13311j != measuredWidth) {
            this.f13311j = measuredWidth;
            c();
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (b()) {
            this.f13305c.l(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (b()) {
            if (drawable != getBackground()) {
                Log.i("MaterialButton", "Setting a custom background is not supported.");
                this.f13305c.m();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? c.a.k.a.a.d(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int i2) {
        if (b()) {
            this.f13305c.n(i2);
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f13309g != drawable) {
            this.f13309g = drawable;
            c();
        }
    }

    public void setIconGravity(int i2) {
        this.f13312k = i2;
    }

    public void setIconPadding(int i2) {
        if (this.f13306d != i2) {
            this.f13306d = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? c.a.k.a.a.d(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 >= 0) {
            if (this.f13310h != i2) {
                this.f13310h = i2;
                c();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f13308f != colorStateList) {
            this.f13308f = colorStateList;
            c();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f13307e != mode) {
            this.f13307e = mode;
            c();
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(c.a.k.a.a.c(getContext(), i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (b()) {
            this.f13305c.o(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        if (b()) {
            setRippleColor(c.a.k.a.a.c(getContext(), i2));
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (b()) {
            this.f13305c.p(colorStateList);
        }
    }

    public void setStrokeColorResource(int i2) {
        if (b()) {
            setStrokeColor(c.a.k.a.a.c(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (b()) {
            this.f13305c.q(i2);
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, c.h.k.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (b()) {
            this.f13305c.r(colorStateList);
        } else if (this.f13305c != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, c.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (b()) {
            this.f13305c.s(mode);
        } else if (this.f13305c != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray h2 = h.h(context, attributeSet, k.E0, i2, j.f13279j, new int[0]);
        this.f13306d = h2.getDimensionPixelSize(k.O0, 0);
        this.f13307e = com.google.android.material.internal.i.b(h2.getInt(k.R0, -1), PorterDuff.Mode.SRC_IN);
        this.f13308f = e.g.a.f.q.a.a(getContext(), h2, k.Q0);
        this.f13309g = e.g.a.f.q.a.b(getContext(), h2, k.M0);
        this.f13312k = h2.getInteger(k.N0, 1);
        this.f13310h = h2.getDimensionPixelSize(k.P0, 0);
        c cVar = new c(this);
        this.f13305c = cVar;
        cVar.k(h2);
        h2.recycle();
        setCompoundDrawablePadding(this.f13306d);
        c();
    }
}