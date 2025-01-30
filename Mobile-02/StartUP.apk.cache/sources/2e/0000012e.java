package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* compiled from: AppCompatMultiAutoCompleteTextView.java */
/* loaded from: classes.dex */
public class l extends MultiAutoCompleteTextView implements c.h.k.u {
    private static final int[] a = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final e f836b;

    /* renamed from: c  reason: collision with root package name */
    private final u f837c;

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.p);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f836b;
        if (eVar != null) {
            eVar.b();
        }
        u uVar = this.f837c;
        if (uVar != null) {
            uVar.b();
        }
    }

    @Override // c.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f836b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // c.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f836b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return i.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f836b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f836b;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(c.a.k.a.a.d(getContext(), i2));
    }

    @Override // c.h.k.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f836b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // c.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f836b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        u uVar = this.f837c;
        if (uVar != null) {
            uVar.q(context, i2);
        }
    }

    public l(Context context, AttributeSet attributeSet, int i2) {
        super(p0.b(context), attributeSet, i2);
        n0.a(this, getContext());
        s0 v = s0.v(getContext(), attributeSet, a, i2, 0);
        if (v.s(0)) {
            setDropDownBackgroundDrawable(v.g(0));
        }
        v.w();
        e eVar = new e(this);
        this.f836b = eVar;
        eVar.e(attributeSet, i2);
        u uVar = new u(this);
        this.f837c = uVar;
        uVar.m(attributeSet, i2);
        uVar.b();
    }
}