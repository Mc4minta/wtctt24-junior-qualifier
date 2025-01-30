package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* compiled from: AppCompatRadioButton.java */
/* loaded from: classes.dex */
public class o extends RadioButton implements androidx.core.widget.j, c.h.k.u {
    private final g a;

    /* renamed from: b  reason: collision with root package name */
    private final e f869b;

    /* renamed from: c  reason: collision with root package name */
    private final u f870c;

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.G);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f869b;
        if (eVar != null) {
            eVar.b();
        }
        u uVar = this.f870c;
        if (uVar != null) {
            uVar.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        g gVar = this.a;
        return gVar != null ? gVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // c.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f869b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // c.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f869b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.d();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f869b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f869b;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        g gVar = this.a;
        if (gVar != null) {
            gVar.f();
        }
    }

    @Override // c.h.k.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f869b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // c.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f869b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.g(colorStateList);
        }
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.h(mode);
        }
    }

    public o(Context context, AttributeSet attributeSet, int i2) {
        super(p0.b(context), attributeSet, i2);
        n0.a(this, getContext());
        g gVar = new g(this);
        this.a = gVar;
        gVar.e(attributeSet, i2);
        e eVar = new e(this);
        this.f869b = eVar;
        eVar.e(attributeSet, i2);
        u uVar = new u(this);
        this.f870c = uVar;
        uVar.m(attributeSet, i2);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i2) {
        setButtonDrawable(c.a.k.a.a.d(getContext(), i2));
    }
}