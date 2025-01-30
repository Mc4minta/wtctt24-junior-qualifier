package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.u0;
import c.h.k.v;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* loaded from: classes2.dex */
public class NavigationMenuItemView extends e implements n.a {
    private static final int[] z = {16842912};
    private final int A;
    private boolean B;
    boolean C;
    private final CheckedTextView D;
    private FrameLayout E;
    private androidx.appcompat.view.menu.i F;
    private ColorStateList G;
    private boolean H;
    private Drawable I;
    private final c.h.k.a J;

    /* loaded from: classes2.dex */
    class a extends c.h.k.a {
        a() {
        }

        @Override // c.h.k.a
        public void g(View view, c.h.k.e0.d dVar) {
            super.g(view, dVar);
            dVar.R(NavigationMenuItemView.this.C);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B() {
        if (D()) {
            this.D.setVisibility(8);
            FrameLayout frameLayout = this.E;
            if (frameLayout != null) {
                d0.a aVar = (d0.a) frameLayout.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) aVar).width = -1;
                this.E.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.D.setVisibility(0);
        FrameLayout frameLayout2 = this.E;
        if (frameLayout2 != null) {
            d0.a aVar2 = (d0.a) frameLayout2.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) aVar2).width = -2;
            this.E.setLayoutParams(aVar2);
        }
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(c.a.a.v, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(z, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    private boolean D() {
        return this.F.getTitle() == null && this.F.getIcon() == null && this.F.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.E == null) {
                this.E = (FrameLayout) ((ViewStub) findViewById(e.g.a.f.f.f13255c)).inflate();
            }
            this.E.removeAllViews();
            this.E.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void f(androidx.appcompat.view.menu.i iVar, int i2) {
        this.F = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            v.m0(this, C());
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.getTitle());
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.getContentDescription());
        u0.a(this, iVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.n.a
    public androidx.appcompat.view.menu.i getItemData() {
        return this.F;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        androidx.appcompat.view.menu.i iVar = this.F;
        if (iVar != null && iVar.isCheckable() && this.F.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, z);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.C != z2) {
            this.C = z2;
            this.J.l(this.D, PKIFailureInfo.wrongIntegrity);
        }
    }

    public void setChecked(boolean z2) {
        refreshDrawableState();
        this.D.setChecked(z2);
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.H) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
                androidx.core.graphics.drawable.a.o(drawable, this.G);
            }
            int i2 = this.A;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.B) {
            if (this.I == null) {
                Drawable b2 = androidx.core.content.d.f.b(getResources(), e.g.a.f.e.f13253b, getContext().getTheme());
                this.I = b2;
                if (b2 != null) {
                    int i3 = this.A;
                    b2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.I;
        }
        androidx.core.widget.i.l(this.D, drawable, null, null, null);
    }

    public void setIconPadding(int i2) {
        this.D.setCompoundDrawablePadding(i2);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.G = colorStateList;
        this.H = colorStateList != null;
        androidx.appcompat.view.menu.i iVar = this.F;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.B = z2;
    }

    public void setTextAppearance(int i2) {
        androidx.core.widget.i.q(this.D, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.D.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.D.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a aVar = new a();
        this.J = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(e.g.a.f.h.f13268e, (ViewGroup) this, true);
        this.A = context.getResources().getDimensionPixelSize(e.g.a.f.d.f13252l);
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(e.g.a.f.f.f13256d);
        this.D = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        v.k0(checkedTextView, aVar);
    }
}