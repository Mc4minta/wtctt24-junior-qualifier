package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.s0;
import androidx.appcompat.widget.z;
import androidx.core.widget.i;
import c.h.k.v;
import com.google.android.material.internal.CheckableImageButton;
import e.g.a.f.f;
import e.g.a.f.h;
import e.g.a.f.j;
import e.g.a.f.k;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {
    private int A;
    private final int B;
    private final int C;
    private int D;
    private int E;
    private Drawable F;
    private final Rect G;
    private final RectF H;
    private Typeface I;
    private boolean J;
    private Drawable K;
    private CharSequence L;
    private CheckableImageButton M;
    private boolean N;
    private Drawable O;
    private Drawable P;
    private ColorStateList Q;
    private boolean R;
    private PorterDuff.Mode S;
    private boolean T;
    private ColorStateList U;
    private ColorStateList V;
    private final int W;
    private final FrameLayout a;
    private final int a0;

    /* renamed from: b  reason: collision with root package name */
    EditText f8254b;
    private int b0;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f8255c;
    private final int c0;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.material.textfield.b f8256d;
    private boolean d0;

    /* renamed from: e  reason: collision with root package name */
    boolean f8257e;
    final com.google.android.material.internal.b e0;

    /* renamed from: f  reason: collision with root package name */
    private int f8258f;
    private boolean f0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8259g;
    private ValueAnimator g0;

    /* renamed from: h  reason: collision with root package name */
    private TextView f8260h;
    private boolean h0;
    private boolean i0;

    /* renamed from: j  reason: collision with root package name */
    private final int f8261j;
    private boolean j0;

    /* renamed from: k  reason: collision with root package name */
    private final int f8262k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8263l;
    private CharSequence m;
    private boolean n;
    private GradientDrawable p;
    private final int q;
    private final int t;
    private int u;
    private final int v;
    private float w;
    private float x;
    private float y;
    private float z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.C(!textInputLayout.j0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f8257e) {
                textInputLayout2.y(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextInputLayout.this.t(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.e0.P(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends c.h.k.a {

        /* renamed from: d  reason: collision with root package name */
        private final TextInputLayout f8264d;

        public d(TextInputLayout textInputLayout) {
            this.f8264d = textInputLayout;
        }

        @Override // c.h.k.a
        public void g(View view, c.h.k.e0.d dVar) {
            super.g(view, dVar);
            EditText editText = this.f8264d.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f8264d.getHint();
            CharSequence error = this.f8264d.getError();
            CharSequence counterOverflowDescription = this.f8264d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                dVar.r0(text);
            } else if (z2) {
                dVar.r0(hint);
            }
            if (z2) {
                dVar.f0(hint);
                if (!z && z2) {
                    z4 = true;
                }
                dVar.o0(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                dVar.b0(error);
                dVar.Y(true);
            }
        }

        @Override // c.h.k.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            EditText editText = this.f8264d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.f8264d.getHint();
            }
            if (TextUtils.isEmpty(text)) {
                return;
            }
            accessibilityEvent.getText().add(text);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class e extends c.j.a.a {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        CharSequence f8265c;

        /* renamed from: d  reason: collision with root package name */
        boolean f8266d;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.ClassLoaderCreator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public e[] newArray(int i2) {
                return new e[i2];
            }
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f8265c) + "}";
        }

        @Override // c.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f8265c, parcel, i2);
            parcel.writeInt(this.f8266d ? 1 : 0);
        }

        e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8265c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f8266d = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.g.a.f.b.m);
    }

    private void A() {
        Drawable background;
        EditText editText = this.f8254b;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        if (z.a(background)) {
            background = background.mutate();
        }
        com.google.android.material.internal.c.a(this, this.f8254b, new Rect());
        Rect bounds = background.getBounds();
        if (bounds.left != bounds.right) {
            Rect rect = new Rect();
            background.getPadding(rect);
            background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.f8254b.getBottom());
        }
    }

    private void B() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
        int i2 = i();
        if (i2 != layoutParams.topMargin) {
            layoutParams.topMargin = i2;
            this.a.requestLayout();
        }
    }

    private void D(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f8254b;
        boolean z3 = true;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f8254b;
        if (editText2 == null || !editText2.hasFocus()) {
            z3 = false;
        }
        boolean k2 = this.f8256d.k();
        ColorStateList colorStateList2 = this.U;
        if (colorStateList2 != null) {
            this.e0.G(colorStateList2);
            this.e0.L(this.U);
        }
        if (!isEnabled) {
            this.e0.G(ColorStateList.valueOf(this.c0));
            this.e0.L(ColorStateList.valueOf(this.c0));
        } else if (k2) {
            this.e0.G(this.f8256d.o());
        } else if (this.f8259g && (textView = this.f8260h) != null) {
            this.e0.G(textView.getTextColors());
        } else if (z3 && (colorStateList = this.V) != null) {
            this.e0.G(colorStateList);
        }
        if (!z4 && (!isEnabled() || (!z3 && !k2))) {
            if (z2 || !this.d0) {
                n(z);
            }
        } else if (z2 || this.d0) {
            k(z);
        }
    }

    private void E() {
        if (this.f8254b == null) {
            return;
        }
        if (x()) {
            if (this.M == null) {
                CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(h.f13269f, (ViewGroup) this.a, false);
                this.M = checkableImageButton;
                checkableImageButton.setImageDrawable(this.K);
                this.M.setContentDescription(this.L);
                this.a.addView(this.M);
                this.M.setOnClickListener(new b());
            }
            EditText editText = this.f8254b;
            if (editText != null && v.z(editText) <= 0) {
                this.f8254b.setMinimumHeight(v.z(this.M));
            }
            this.M.setVisibility(0);
            this.M.setChecked(this.N);
            if (this.O == null) {
                this.O = new ColorDrawable();
            }
            this.O.setBounds(0, 0, this.M.getMeasuredWidth(), 1);
            Drawable[] a2 = i.a(this.f8254b);
            Drawable drawable = a2[2];
            Drawable drawable2 = this.O;
            if (drawable != drawable2) {
                this.P = a2[2];
            }
            i.l(this.f8254b, a2[0], a2[1], drawable2, a2[3]);
            this.M.setPadding(this.f8254b.getPaddingLeft(), this.f8254b.getPaddingTop(), this.f8254b.getPaddingRight(), this.f8254b.getPaddingBottom());
            return;
        }
        CheckableImageButton checkableImageButton2 = this.M;
        if (checkableImageButton2 != null && checkableImageButton2.getVisibility() == 0) {
            this.M.setVisibility(8);
        }
        if (this.O != null) {
            Drawable[] a3 = i.a(this.f8254b);
            if (a3[2] == this.O) {
                i.l(this.f8254b, a3[0], a3[1], this.P, a3[3]);
                this.O = null;
            }
        }
    }

    private void F() {
        if (this.u == 0 || this.p == null || this.f8254b == null || getRight() == 0) {
            return;
        }
        int left = this.f8254b.getLeft();
        int g2 = g();
        int right = this.f8254b.getRight();
        int bottom = this.f8254b.getBottom() + this.q;
        if (this.u == 2) {
            int i2 = this.C;
            left += i2 / 2;
            g2 -= i2 / 2;
            right -= i2 / 2;
            bottom += i2 / 2;
        }
        this.p.setBounds(left, g2, right, bottom);
        c();
        A();
    }

    private void c() {
        int i2;
        Drawable drawable;
        if (this.p == null) {
            return;
        }
        v();
        EditText editText = this.f8254b;
        if (editText != null && this.u == 2) {
            if (editText.getBackground() != null) {
                this.F = this.f8254b.getBackground();
            }
            v.m0(this.f8254b, null);
        }
        EditText editText2 = this.f8254b;
        if (editText2 != null && this.u == 1 && (drawable = this.F) != null) {
            v.m0(editText2, drawable);
        }
        int i3 = this.A;
        if (i3 > -1 && (i2 = this.D) != 0) {
            this.p.setStroke(i3, i2);
        }
        this.p.setCornerRadii(getCornerRadiiAsArray());
        this.p.setColor(this.E);
        invalidate();
    }

    private void d(RectF rectF) {
        float f2 = rectF.left;
        int i2 = this.t;
        rectF.left = f2 - i2;
        rectF.top -= i2;
        rectF.right += i2;
        rectF.bottom += i2;
    }

    private void e() {
        Drawable drawable = this.K;
        if (drawable != null) {
            if (this.R || this.T) {
                Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
                this.K = mutate;
                if (this.R) {
                    androidx.core.graphics.drawable.a.o(mutate, this.Q);
                }
                if (this.T) {
                    androidx.core.graphics.drawable.a.p(this.K, this.S);
                }
                CheckableImageButton checkableImageButton = this.M;
                if (checkableImageButton != null) {
                    Drawable drawable2 = checkableImageButton.getDrawable();
                    Drawable drawable3 = this.K;
                    if (drawable2 != drawable3) {
                        this.M.setImageDrawable(drawable3);
                    }
                }
            }
        }
    }

    private void f() {
        int i2 = this.u;
        if (i2 == 0) {
            this.p = null;
        } else if (i2 == 2 && this.f8263l && !(this.p instanceof com.google.android.material.textfield.a)) {
            this.p = new com.google.android.material.textfield.a();
        } else if (this.p instanceof GradientDrawable) {
        } else {
            this.p = new GradientDrawable();
        }
    }

    private int g() {
        EditText editText = this.f8254b;
        if (editText == null) {
            return 0;
        }
        int i2 = this.u;
        if (i2 != 1) {
            if (i2 != 2) {
                return 0;
            }
            return editText.getTop() + i();
        }
        return editText.getTop();
    }

    private Drawable getBoxBackground() {
        int i2 = this.u;
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException();
        }
        return this.p;
    }

    private float[] getCornerRadiiAsArray() {
        if (!com.google.android.material.internal.i.a(this)) {
            float f2 = this.w;
            float f3 = this.x;
            float f4 = this.y;
            float f5 = this.z;
            return new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
        }
        float f6 = this.x;
        float f7 = this.w;
        float f8 = this.z;
        float f9 = this.y;
        return new float[]{f6, f6, f7, f7, f8, f8, f9, f9};
    }

    private int h() {
        int i2 = this.u;
        if (i2 != 1) {
            if (i2 != 2) {
                return getPaddingTop();
            }
            return getBoxBackground().getBounds().top - i();
        }
        return getBoxBackground().getBounds().top + this.v;
    }

    private int i() {
        float n;
        if (this.f8263l) {
            int i2 = this.u;
            if (i2 == 0 || i2 == 1) {
                n = this.e0.n();
            } else if (i2 != 2) {
                return 0;
            } else {
                n = this.e0.n() / 2.0f;
            }
            return (int) n;
        }
        return 0;
    }

    private void j() {
        if (l()) {
            ((com.google.android.material.textfield.a) this.p).d();
        }
    }

    private void k(boolean z) {
        ValueAnimator valueAnimator = this.g0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.g0.cancel();
        }
        if (z && this.f0) {
            b(1.0f);
        } else {
            this.e0.P(1.0f);
        }
        this.d0 = false;
        if (l()) {
            s();
        }
    }

    private boolean l() {
        return this.f8263l && !TextUtils.isEmpty(this.m) && (this.p instanceof com.google.android.material.textfield.a);
    }

    private void m() {
        Drawable background;
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 != 21 && i2 != 22) || (background = this.f8254b.getBackground()) == null || this.h0) {
            return;
        }
        Drawable newDrawable = background.getConstantState().newDrawable();
        if (background instanceof DrawableContainer) {
            this.h0 = com.google.android.material.internal.d.a((DrawableContainer) background, newDrawable.getConstantState());
        }
        if (this.h0) {
            return;
        }
        v.m0(this.f8254b, newDrawable);
        this.h0 = true;
        r();
    }

    private void n(boolean z) {
        ValueAnimator valueAnimator = this.g0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.g0.cancel();
        }
        if (z && this.f0) {
            b(0.0f);
        } else {
            this.e0.P(0.0f);
        }
        if (l() && ((com.google.android.material.textfield.a) this.p).a()) {
            j();
        }
        this.d0 = true;
    }

    private boolean o() {
        EditText editText = this.f8254b;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private void r() {
        f();
        if (this.u != 0) {
            B();
        }
        F();
    }

    private void s() {
        if (l()) {
            RectF rectF = this.H;
            this.e0.k(rectF);
            d(rectF);
            ((com.google.android.material.textfield.a) this.p).g(rectF);
        }
    }

    private void setEditText(EditText editText) {
        if (this.f8254b == null) {
            if (!(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f8254b = editText;
            r();
            setTextInputAccessibilityDelegate(new d(this));
            if (!o()) {
                this.e0.V(this.f8254b.getTypeface());
            }
            this.e0.N(this.f8254b.getTextSize());
            int gravity = this.f8254b.getGravity();
            this.e0.H((gravity & (-113)) | 48);
            this.e0.M(gravity);
            this.f8254b.addTextChangedListener(new a());
            if (this.U == null) {
                this.U = this.f8254b.getHintTextColors();
            }
            if (this.f8263l) {
                if (TextUtils.isEmpty(this.m)) {
                    CharSequence hint = this.f8254b.getHint();
                    this.f8255c = hint;
                    setHint(hint);
                    this.f8254b.setHint((CharSequence) null);
                }
                this.n = true;
            }
            if (this.f8260h != null) {
                y(this.f8254b.getText().length());
            }
            this.f8256d.e();
            E();
            D(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.m)) {
            return;
        }
        this.m = charSequence;
        this.e0.T(charSequence);
        if (this.d0) {
            return;
        }
        s();
    }

    private static void u(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                u((ViewGroup) childAt, z);
            }
        }
    }

    private void v() {
        int i2 = this.u;
        if (i2 != 1) {
            if (i2 == 2 && this.b0 == 0) {
                this.b0 = this.V.getColorForState(getDrawableState(), this.V.getDefaultColor());
                return;
            }
            return;
        }
        this.A = 0;
    }

    private boolean x() {
        return this.J && (o() || this.N);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(boolean z) {
        D(z, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        TextView textView;
        if (this.p == null || this.u == 0) {
            return;
        }
        EditText editText = this.f8254b;
        boolean z = true;
        boolean z2 = editText != null && editText.hasFocus();
        EditText editText2 = this.f8254b;
        if (editText2 == null || !editText2.isHovered()) {
            z = false;
        }
        if (this.u == 2) {
            if (!isEnabled()) {
                this.D = this.c0;
            } else if (this.f8256d.k()) {
                this.D = this.f8256d.n();
            } else if (this.f8259g && (textView = this.f8260h) != null) {
                this.D = textView.getCurrentTextColor();
            } else if (z2) {
                this.D = this.b0;
            } else if (z) {
                this.D = this.a0;
            } else {
                this.D = this.W;
            }
            if ((z || z2) && isEnabled()) {
                this.A = this.C;
            } else {
                this.A = this.B;
            }
            c();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.a.addView(view, layoutParams2);
            this.a.setLayoutParams(layoutParams);
            B();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    void b(float f2) {
        if (this.e0.t() == f2) {
            return;
        }
        if (this.g0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.g0 = valueAnimator;
            valueAnimator.setInterpolator(e.g.a.f.l.a.f13292b);
            this.g0.setDuration(167L);
            this.g0.addUpdateListener(new c());
        }
        this.g0.setFloatValues(this.e0.t(), f2);
        this.g0.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText;
        if (this.f8255c != null && (editText = this.f8254b) != null) {
            boolean z = this.n;
            this.n = false;
            CharSequence hint = editText.getHint();
            this.f8254b.setHint(this.f8255c);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
                return;
            } finally {
                this.f8254b.setHint(hint);
                this.n = z;
            }
        }
        super.dispatchProvideAutofillStructure(viewStructure, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.j0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.j0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        GradientDrawable gradientDrawable = this.p;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        super.draw(canvas);
        if (this.f8263l) {
            this.e0.i(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.i0) {
            return;
        }
        boolean z = true;
        this.i0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (!v.S(this) || !isEnabled()) {
            z = false;
        }
        C(z);
        z();
        F();
        G();
        com.google.android.material.internal.b bVar = this.e0;
        if (bVar != null ? bVar.S(drawableState) | false : false) {
            invalidate();
        }
        this.i0 = false;
    }

    public int getBoxBackgroundColor() {
        return this.E;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.y;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.z;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.x;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.w;
    }

    public int getBoxStrokeColor() {
        return this.b0;
    }

    public int getCounterMaxLength() {
        return this.f8258f;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f8257e && this.f8259g && (textView = this.f8260h) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.U;
    }

    public EditText getEditText() {
        return this.f8254b;
    }

    public CharSequence getError() {
        if (this.f8256d.v()) {
            return this.f8256d.m();
        }
        return null;
    }

    public int getErrorCurrentTextColors() {
        return this.f8256d.n();
    }

    final int getErrorTextCurrentColor() {
        return this.f8256d.n();
    }

    public CharSequence getHelperText() {
        if (this.f8256d.w()) {
            return this.f8256d.p();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f8256d.q();
    }

    public CharSequence getHint() {
        if (this.f8263l) {
            return this.m;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.e0.n();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.e0.p();
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.L;
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.K;
    }

    public Typeface getTypeface() {
        return this.I;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        EditText editText;
        super.onLayout(z, i2, i3, i4, i5);
        if (this.p != null) {
            F();
        }
        if (!this.f8263l || (editText = this.f8254b) == null) {
            return;
        }
        Rect rect = this.G;
        com.google.android.material.internal.c.a(this, editText, rect);
        int compoundPaddingLeft = rect.left + this.f8254b.getCompoundPaddingLeft();
        int compoundPaddingRight = rect.right - this.f8254b.getCompoundPaddingRight();
        int h2 = h();
        this.e0.J(compoundPaddingLeft, rect.top + this.f8254b.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.f8254b.getCompoundPaddingBottom());
        this.e0.E(compoundPaddingLeft, h2, compoundPaddingRight, (i5 - i3) - getPaddingBottom());
        this.e0.C();
        if (!l() || this.d0) {
            return;
        }
        s();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        E();
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.a());
        setError(eVar.f8265c);
        if (eVar.f8266d) {
            t(true);
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        if (this.f8256d.k()) {
            eVar.f8265c = getError();
        }
        eVar.f8266d = this.N;
        return eVar;
    }

    public boolean p() {
        return this.f8256d.w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return this.n;
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.E != i2) {
            this.E = i2;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i2) {
        setBoxBackgroundColor(androidx.core.content.a.d(getContext(), i2));
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 == this.u) {
            return;
        }
        this.u = i2;
        r();
    }

    public void setBoxStrokeColor(int i2) {
        if (this.b0 != i2) {
            this.b0 = i2;
            G();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.f8257e != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f8260h = appCompatTextView;
                appCompatTextView.setId(f.f13264l);
                Typeface typeface = this.I;
                if (typeface != null) {
                    this.f8260h.setTypeface(typeface);
                }
                this.f8260h.setMaxLines(1);
                w(this.f8260h, this.f8262k);
                this.f8256d.d(this.f8260h, 2);
                EditText editText = this.f8254b;
                if (editText == null) {
                    y(0);
                } else {
                    y(editText.getText().length());
                }
            } else {
                this.f8256d.x(this.f8260h, 2);
                this.f8260h = null;
            }
            this.f8257e = z;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.f8258f != i2) {
            if (i2 > 0) {
                this.f8258f = i2;
            } else {
                this.f8258f = -1;
            }
            if (this.f8257e) {
                EditText editText = this.f8254b;
                y(editText == null ? 0 : editText.getText().length());
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.U = colorStateList;
        this.V = colorStateList;
        if (this.f8254b != null) {
            C(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        u(this, z);
        super.setEnabled(z);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f8256d.v()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f8256d.J(charSequence);
        } else {
            this.f8256d.r();
        }
    }

    public void setErrorEnabled(boolean z) {
        this.f8256d.z(z);
    }

    public void setErrorTextAppearance(int i2) {
        this.f8256d.A(i2);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f8256d.B(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (p()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!p()) {
            setHelperTextEnabled(true);
        }
        this.f8256d.K(charSequence);
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f8256d.E(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.f8256d.D(z);
    }

    public void setHelperTextTextAppearance(int i2) {
        this.f8256d.C(i2);
    }

    public void setHint(CharSequence charSequence) {
        if (this.f8263l) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(PKIFailureInfo.wrongIntegrity);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f8263l) {
            this.f8263l = z;
            if (!z) {
                this.n = false;
                if (!TextUtils.isEmpty(this.m) && TextUtils.isEmpty(this.f8254b.getHint())) {
                    this.f8254b.setHint(this.m);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f8254b.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.m)) {
                        setHint(hint);
                    }
                    this.f8254b.setHint((CharSequence) null);
                }
                this.n = true;
            }
            if (this.f8254b != null) {
                B();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        this.e0.F(i2);
        this.V = this.e0.l();
        if (this.f8254b != null) {
            C(false);
            B();
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? c.a.k.a.a.d(getContext(), i2) : null);
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        EditText editText;
        if (this.J != z) {
            this.J = z;
            if (!z && this.N && (editText = this.f8254b) != null) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.N = false;
            E();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.Q = colorStateList;
        this.R = true;
        e();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.S = mode;
        this.T = true;
        e();
    }

    public void setTextInputAccessibilityDelegate(d dVar) {
        EditText editText = this.f8254b;
        if (editText != null) {
            v.k0(editText, dVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.I) {
            this.I = typeface;
            this.e0.V(typeface);
            this.f8256d.G(typeface);
            TextView textView = this.f8260h;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public void t(boolean z) {
        if (this.J) {
            int selectionEnd = this.f8254b.getSelectionEnd();
            if (o()) {
                this.f8254b.setTransformationMethod(null);
                this.N = true;
            } else {
                this.f8254b.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.N = false;
            }
            this.M.setChecked(this.N);
            if (z) {
                this.M.jumpDrawablesToCurrentState();
            }
            this.f8254b.setSelection(selectionEnd);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void w(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.i.q(r3, r4)     // Catch: java.lang.Exception -> L1a
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1a
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1a
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1a
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1a
        L18:
            r4 = 0
            r0 = r4
        L1a:
            if (r0 == 0) goto L2e
            int r4 = e.g.a.f.j.a
            androidx.core.widget.i.q(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = e.g.a.f.c.f13238b
            int r4 = androidx.core.content.a.d(r4, r0)
            r3.setTextColor(r4)
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.w(android.widget.TextView, int):void");
    }

    void y(int i2) {
        boolean z = this.f8259g;
        if (this.f8258f == -1) {
            this.f8260h.setText(String.valueOf(i2));
            this.f8260h.setContentDescription(null);
            this.f8259g = false;
        } else {
            if (v.m(this.f8260h) == 1) {
                v.l0(this.f8260h, 0);
            }
            boolean z2 = i2 > this.f8258f;
            this.f8259g = z2;
            if (z != z2) {
                w(this.f8260h, z2 ? this.f8261j : this.f8262k);
                if (this.f8259g) {
                    v.l0(this.f8260h, 1);
                }
            }
            this.f8260h.setText(getContext().getString(e.g.a.f.i.f13270b, Integer.valueOf(i2), Integer.valueOf(this.f8258f)));
            this.f8260h.setContentDescription(getContext().getString(e.g.a.f.i.a, Integer.valueOf(i2), Integer.valueOf(this.f8258f)));
        }
        if (this.f8254b == null || z == this.f8259g) {
            return;
        }
        C(false);
        G();
        z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        Drawable background;
        TextView textView;
        EditText editText = this.f8254b;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        m();
        if (z.a(background)) {
            background = background.mutate();
        }
        if (this.f8256d.k()) {
            background.setColorFilter(androidx.appcompat.widget.h.e(this.f8256d.n(), PorterDuff.Mode.SRC_IN));
        } else if (this.f8259g && (textView = this.f8260h) != null) {
            background.setColorFilter(androidx.appcompat.widget.h.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.a.c(background);
            this.f8254b.refreshDrawableState();
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8256d = new com.google.android.material.textfield.b(this);
        this.G = new Rect();
        this.H = new RectF();
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.e0 = bVar;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context);
        this.a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        TimeInterpolator timeInterpolator = e.g.a.f.l.a.a;
        bVar.U(timeInterpolator);
        bVar.R(timeInterpolator);
        bVar.H(8388659);
        s0 i3 = com.google.android.material.internal.h.i(context, attributeSet, k.U1, i2, j.f13278i, new int[0]);
        this.f8263l = i3.a(k.p2, true);
        setHint(i3.p(k.W1));
        this.f0 = i3.a(k.o2, true);
        this.q = context.getResources().getDimensionPixelOffset(e.g.a.f.d.r);
        this.t = context.getResources().getDimensionPixelOffset(e.g.a.f.d.s);
        this.v = i3.e(k.Z1, 0);
        this.w = i3.d(k.d2, 0.0f);
        this.x = i3.d(k.c2, 0.0f);
        this.y = i3.d(k.a2, 0.0f);
        this.z = i3.d(k.b2, 0.0f);
        this.E = i3.b(k.X1, 0);
        this.b0 = i3.b(k.e2, 0);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.g.a.f.d.t);
        this.B = dimensionPixelSize;
        this.C = context.getResources().getDimensionPixelSize(e.g.a.f.d.u);
        this.A = dimensionPixelSize;
        setBoxBackgroundMode(i3.k(k.Y1, 0));
        int i4 = k.V1;
        if (i3.s(i4)) {
            ColorStateList c2 = i3.c(i4);
            this.V = c2;
            this.U = c2;
        }
        this.W = androidx.core.content.a.d(context, e.g.a.f.c.f13239c);
        this.c0 = androidx.core.content.a.d(context, e.g.a.f.c.f13240d);
        this.a0 = androidx.core.content.a.d(context, e.g.a.f.c.f13241e);
        int i5 = k.q2;
        if (i3.n(i5, -1) != -1) {
            setHintTextAppearance(i3.n(i5, 0));
        }
        int n = i3.n(k.k2, 0);
        boolean a2 = i3.a(k.j2, false);
        int n2 = i3.n(k.n2, 0);
        boolean a3 = i3.a(k.m2, false);
        CharSequence p = i3.p(k.l2);
        boolean a4 = i3.a(k.f2, false);
        setCounterMaxLength(i3.k(k.g2, -1));
        this.f8262k = i3.n(k.i2, 0);
        this.f8261j = i3.n(k.h2, 0);
        this.J = i3.a(k.t2, false);
        this.K = i3.g(k.s2);
        this.L = i3.p(k.r2);
        int i6 = k.u2;
        if (i3.s(i6)) {
            this.R = true;
            this.Q = i3.c(i6);
        }
        int i7 = k.v2;
        if (i3.s(i7)) {
            this.T = true;
            this.S = com.google.android.material.internal.i.b(i3.k(i7, -1), null);
        }
        i3.w();
        setHelperTextEnabled(a3);
        setHelperText(p);
        setHelperTextTextAppearance(n2);
        setErrorEnabled(a2);
        setErrorTextAppearance(n);
        setCounterEnabled(a4);
        e();
        v.t0(this, 2);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.L = charSequence;
        CheckableImageButton checkableImageButton = this.M;
        if (checkableImageButton != null) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.K = drawable;
        CheckableImageButton checkableImageButton = this.M;
        if (checkableImageButton != null) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }
}