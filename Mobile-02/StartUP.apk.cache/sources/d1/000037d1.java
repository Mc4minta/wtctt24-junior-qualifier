package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.i;
import c.h.k.v;
import e.g.a.f.d;
import e.g.a.f.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IndicatorViewController.java */
/* loaded from: classes2.dex */
public final class b {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f8269b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f8270c;

    /* renamed from: d  reason: collision with root package name */
    private int f8271d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f8272e;

    /* renamed from: f  reason: collision with root package name */
    private int f8273f;

    /* renamed from: g  reason: collision with root package name */
    private Animator f8274g;

    /* renamed from: h  reason: collision with root package name */
    private final float f8275h;

    /* renamed from: i  reason: collision with root package name */
    private int f8276i;

    /* renamed from: j  reason: collision with root package name */
    private int f8277j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f8278k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8279l;
    private TextView m;
    private int n;
    private CharSequence o;
    private boolean p;
    private TextView q;
    private int r;
    private Typeface s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IndicatorViewController.java */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f8280b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8281c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextView f8282d;

        a(int i2, TextView textView, int i3, TextView textView2) {
            this.a = i2;
            this.f8280b = textView;
            this.f8281c = i3;
            this.f8282d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.f8276i = this.a;
            b.this.f8274g = null;
            TextView textView = this.f8280b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f8281c != 1 || b.this.m == null) {
                    return;
                }
                b.this.m.setText((CharSequence) null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f8282d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public b(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.a = context;
        this.f8269b = textInputLayout;
        this.f8275h = context.getResources().getDimensionPixelSize(d.q);
    }

    private void F(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void H(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean I(TextView textView, CharSequence charSequence) {
        return v.S(this.f8269b) && this.f8269b.isEnabled() && !(this.f8277j == this.f8276i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void L(int i2, int i3, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f8274g = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.p, this.q, 2, i2, i3);
            h(arrayList, this.f8279l, this.m, 1, i2, i3);
            e.g.a.f.l.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i3, l(i2), i2, l(i3)));
            animatorSet.start();
        } else {
            y(i2, i3);
        }
        this.f8269b.z();
        this.f8269b.C(z);
        this.f8269b.G();
    }

    private boolean f() {
        return (this.f8270c == null || this.f8269b.getEditText() == null) ? false : true;
    }

    private void h(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView == null || !z) {
            return;
        }
        if (i2 == i4 || i2 == i3) {
            list.add(i(textView, i4 == i2));
            if (i4 == i2) {
                list.add(j(textView));
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(e.g.a.f.l.a.a);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f8275h, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(e.g.a.f.l.a.f13294d);
        return ofFloat;
    }

    private TextView l(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
            return this.q;
        }
        return this.m;
    }

    private boolean t(int i2) {
        return (i2 != 1 || this.m == null || TextUtils.isEmpty(this.f8278k)) ? false : true;
    }

    private void y(int i2, int i3) {
        TextView l2;
        TextView l3;
        if (i2 == i3) {
            return;
        }
        if (i3 != 0 && (l3 = l(i3)) != null) {
            l3.setVisibility(0);
            l3.setAlpha(1.0f);
        }
        if (i2 != 0 && (l2 = l(i2)) != null) {
            l2.setVisibility(4);
            if (i2 == 1) {
                l2.setText((CharSequence) null);
            }
        }
        this.f8276i = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i2) {
        this.n = i2;
        TextView textView = this.m;
        if (textView != null) {
            this.f8269b.w(textView, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(ColorStateList colorStateList) {
        TextView textView = this.m;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int i2) {
        this.r = i2;
        TextView textView = this.q;
        if (textView != null) {
            i.q(textView, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(boolean z) {
        if (this.p == z) {
            return;
        }
        g();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.a);
            this.q = appCompatTextView;
            appCompatTextView.setId(f.n);
            Typeface typeface = this.s;
            if (typeface != null) {
                this.q.setTypeface(typeface);
            }
            this.q.setVisibility(4);
            v.l0(this.q, 1);
            C(this.r);
            d(this.q, 1);
        } else {
            s();
            x(this.q, 1);
            this.q = null;
            this.f8269b.z();
            this.f8269b.G();
        }
        this.p = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(ColorStateList colorStateList) {
        TextView textView = this.q;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(Typeface typeface) {
        if (typeface != this.s) {
            this.s = typeface;
            F(this.m, typeface);
            F(this.q, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(CharSequence charSequence) {
        g();
        this.f8278k = charSequence;
        this.m.setText(charSequence);
        int i2 = this.f8276i;
        if (i2 != 1) {
            this.f8277j = 1;
        }
        L(i2, this.f8277j, I(this.m, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(CharSequence charSequence) {
        g();
        this.o = charSequence;
        this.q.setText(charSequence);
        int i2 = this.f8276i;
        if (i2 != 2) {
            this.f8277j = 2;
        }
        L(i2, this.f8277j, I(this.q, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView, int i2) {
        if (this.f8270c == null && this.f8272e == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            this.f8270c = linearLayout;
            linearLayout.setOrientation(0);
            this.f8269b.addView(this.f8270c, -1, -2);
            FrameLayout frameLayout = new FrameLayout(this.a);
            this.f8272e = frameLayout;
            this.f8270c.addView(frameLayout, -1, new FrameLayout.LayoutParams(-2, -2));
            this.f8270c.addView(new c.n.b.a(this.a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f8269b.getEditText() != null) {
                e();
            }
        }
        if (u(i2)) {
            this.f8272e.setVisibility(0);
            this.f8272e.addView(textView);
            this.f8273f++;
        } else {
            this.f8270c.addView(textView, i2);
        }
        this.f8270c.setVisibility(0);
        this.f8271d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            v.x0(this.f8270c, v.D(this.f8269b.getEditText()), 0, v.C(this.f8269b.getEditText()), 0);
        }
    }

    void g() {
        Animator animator = this.f8274g;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return t(this.f8277j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence m() {
        return this.f8278k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList o() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence p() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        TextView textView = this.q;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.f8278k = null;
        g();
        if (this.f8276i == 1) {
            if (this.p && !TextUtils.isEmpty(this.o)) {
                this.f8277j = 2;
            } else {
                this.f8277j = 0;
            }
        }
        L(this.f8276i, this.f8277j, I(this.m, null));
    }

    void s() {
        g();
        int i2 = this.f8276i;
        if (i2 == 2) {
            this.f8277j = 0;
        }
        L(i2, this.f8277j, I(this.q, null));
    }

    boolean u(int i2) {
        return i2 == 0 || i2 == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v() {
        return this.f8279l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.f8270c == null) {
            return;
        }
        if (u(i2) && (frameLayout = this.f8272e) != null) {
            int i3 = this.f8273f - 1;
            this.f8273f = i3;
            H(frameLayout, i3);
            this.f8272e.removeView(textView);
        } else {
            this.f8270c.removeView(textView);
        }
        int i4 = this.f8271d - 1;
        this.f8271d = i4;
        H(this.f8270c, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(boolean z) {
        if (this.f8279l == z) {
            return;
        }
        g();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.a);
            this.m = appCompatTextView;
            appCompatTextView.setId(f.m);
            Typeface typeface = this.s;
            if (typeface != null) {
                this.m.setTypeface(typeface);
            }
            A(this.n);
            this.m.setVisibility(4);
            v.l0(this.m, 1);
            d(this.m, 0);
        } else {
            r();
            x(this.m, 0);
            this.m = null;
            this.f8269b.z();
            this.f8269b.G();
        }
        this.f8279l = z;
    }
}