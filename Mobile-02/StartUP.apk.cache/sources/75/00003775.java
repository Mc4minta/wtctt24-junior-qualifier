package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.u0;
import c.h.k.t;
import c.h.k.v;
import com.reactnativecommunity.webview.RNCWebViewManager;
import e.g.a.f.e;
import e.g.a.f.f;
import e.g.a.f.h;

/* compiled from: BottomNavigationItemView.java */
/* loaded from: classes2.dex */
public class a extends FrameLayout implements n.a {
    private static final int[] a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private final int f8095b;

    /* renamed from: c  reason: collision with root package name */
    private float f8096c;

    /* renamed from: d  reason: collision with root package name */
    private float f8097d;

    /* renamed from: e  reason: collision with root package name */
    private float f8098e;

    /* renamed from: f  reason: collision with root package name */
    private int f8099f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8100g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f8101h;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f8102j;

    /* renamed from: k  reason: collision with root package name */
    private final TextView f8103k;

    /* renamed from: l  reason: collision with root package name */
    private int f8104l;
    private i m;
    private ColorStateList n;

    public a(Context context) {
        this(context, null);
    }

    private void a(float f2, float f3) {
        this.f8096c = f2 - f3;
        this.f8097d = (f3 * 1.0f) / f2;
        this.f8098e = (f2 * 1.0f) / f3;
    }

    private void b(View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private void c(View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void f(i iVar, int i2) {
        this.m = iVar;
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setIcon(iVar.getIcon());
        setTitle(iVar.getTitle());
        setId(iVar.getItemId());
        if (!TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(iVar.getContentDescription());
        }
        u0.a(this, iVar.getTooltipText());
        setVisibility(iVar.isVisible() ? 0 : 8);
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.m;
    }

    public int getItemPosition() {
        return this.f8104l;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        i iVar = this.m;
        if (iVar != null && iVar.isCheckable() && this.m.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, a);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        TextView textView = this.f8103k;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.f8103k;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.f8102j;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.f8102j;
        textView4.setPivotY(textView4.getBaseline());
        int i2 = this.f8099f;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z) {
                    b(this.f8101h, this.f8095b, 49);
                    c(this.f8103k, 1.0f, 1.0f, 0);
                } else {
                    b(this.f8101h, this.f8095b, 17);
                    c(this.f8103k, 0.5f, 0.5f, 4);
                }
                this.f8102j.setVisibility(4);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    b(this.f8101h, this.f8095b, 17);
                    this.f8103k.setVisibility(8);
                    this.f8102j.setVisibility(8);
                }
            } else if (z) {
                b(this.f8101h, (int) (this.f8095b + this.f8096c), 49);
                c(this.f8103k, 1.0f, 1.0f, 0);
                TextView textView5 = this.f8102j;
                float f2 = this.f8097d;
                c(textView5, f2, f2, 4);
            } else {
                b(this.f8101h, this.f8095b, 49);
                TextView textView6 = this.f8103k;
                float f3 = this.f8098e;
                c(textView6, f3, f3, 4);
                c(this.f8102j, 1.0f, 1.0f, 0);
            }
        } else if (this.f8100g) {
            if (z) {
                b(this.f8101h, this.f8095b, 49);
                c(this.f8103k, 1.0f, 1.0f, 0);
            } else {
                b(this.f8101h, this.f8095b, 17);
                c(this.f8103k, 0.5f, 0.5f, 4);
            }
            this.f8102j.setVisibility(4);
        } else if (z) {
            b(this.f8101h, (int) (this.f8095b + this.f8096c), 49);
            c(this.f8103k, 1.0f, 1.0f, 0);
            TextView textView7 = this.f8102j;
            float f4 = this.f8097d;
            c(textView7, f4, f4, 4);
        } else {
            b(this.f8101h, this.f8095b, 49);
            TextView textView8 = this.f8103k;
            float f5 = this.f8098e;
            c(textView8, f5, f5, 4);
            c(this.f8102j, 1.0f, 1.0f, 0);
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f8102j.setEnabled(z);
        this.f8103k.setEnabled(z);
        this.f8101h.setEnabled(z);
        if (z) {
            v.y0(this, t.b(getContext(), RNCWebViewManager.COMMAND_CLEAR_HISTORY));
        } else {
            v.y0(this, null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.o(drawable, this.n);
        }
        this.f8101h.setImageDrawable(drawable);
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8101h.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f8101h.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.n = colorStateList;
        i iVar = this.m;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : androidx.core.content.a.f(getContext(), i2));
    }

    public void setItemPosition(int i2) {
        this.f8104l = i2;
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f8099f != i2) {
            this.f8099f = i2;
            i iVar = this.m;
            if (iVar != null) {
                setChecked(iVar.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.f8100g != z) {
            this.f8100g = z;
            i iVar = this.m;
            if (iVar != null) {
                setChecked(iVar.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i2) {
        androidx.core.widget.i.q(this.f8103k, i2);
        a(this.f8102j.getTextSize(), this.f8103k.getTextSize());
    }

    public void setTextAppearanceInactive(int i2) {
        androidx.core.widget.i.q(this.f8102j, i2);
        a(this.f8102j.getTextSize(), this.f8103k.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f8102j.setTextColor(colorStateList);
            this.f8103k.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f8102j.setText(charSequence);
        this.f8103k.setText(charSequence);
        i iVar = this.m;
        if (iVar == null || TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8104l = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(h.a, (ViewGroup) this, true);
        setBackgroundResource(e.a);
        this.f8095b = resources.getDimensionPixelSize(e.g.a.f.d.f13247g);
        this.f8101h = (ImageView) findViewById(f.f13257e);
        TextView textView = (TextView) findViewById(f.f13261i);
        this.f8102j = textView;
        TextView textView2 = (TextView) findViewById(f.f13258f);
        this.f8103k = textView2;
        v.t0(textView, 2);
        v.t0(textView2, 2);
        setFocusable(true);
        a(textView.getTextSize(), textView2.getTextSize());
    }

    public void setItemBackground(Drawable drawable) {
        v.m0(this, drawable);
    }
}