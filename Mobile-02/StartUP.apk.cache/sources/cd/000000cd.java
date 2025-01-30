package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import c.h.j.b;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class AppCompatTextView extends TextView implements c.h.k.u, androidx.core.widget.k, androidx.core.widget.b {
    private final e a;

    /* renamed from: b  reason: collision with root package name */
    private final u f685b;

    /* renamed from: c  reason: collision with root package name */
    private final t f686c;

    /* renamed from: d  reason: collision with root package name */
    private Future<c.h.j.b> f687d;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    private void g() {
        Future<c.h.j.b> future = this.f687d;
        if (future != null) {
            try {
                this.f687d = null;
                androidx.core.widget.i.p(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.a;
        if (eVar != null) {
            eVar.b();
        }
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.b.f1574i) {
            return super.getAutoSizeMaxTextSize();
        }
        u uVar = this.f685b;
        if (uVar != null) {
            return uVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (androidx.core.widget.b.f1574i) {
            return super.getAutoSizeMinTextSize();
        }
        u uVar = this.f685b;
        if (uVar != null) {
            return uVar.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (androidx.core.widget.b.f1574i) {
            return super.getAutoSizeStepGranularity();
        }
        u uVar = this.f685b;
        if (uVar != null) {
            return uVar.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (androidx.core.widget.b.f1574i) {
            return super.getAutoSizeTextAvailableSizes();
        }
        u uVar = this.f685b;
        return uVar != null ? uVar.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.b.f1574i) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        u uVar = this.f685b;
        if (uVar != null) {
            return uVar.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.i.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.i.c(this);
    }

    @Override // c.h.k.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // c.h.k.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.a;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f685b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f685b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        g();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        t tVar;
        if (Build.VERSION.SDK_INT < 28 && (tVar = this.f686c) != null) {
            return tVar.a();
        }
        return super.getTextClassifier();
    }

    public b.a getTextMetricsParamsCompat() {
        return androidx.core.widget.i.g(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return i.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.o(z, i2, i3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        g();
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        u uVar = this.f685b;
        if (uVar == null || androidx.core.widget.b.f1574i || !uVar.l()) {
            return;
        }
        this.f685b.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (androidx.core.widget.b.f1574i) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.s(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (androidx.core.widget.b.f1574i) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.t(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (androidx.core.widget.b.f1574i) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.u(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.a;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.a;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.s(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i2);
        } else {
            androidx.core.widget.i.m(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i2);
        } else {
            androidx.core.widget.i.n(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i2) {
        androidx.core.widget.i.o(this, i2);
    }

    public void setPrecomputedText(c.h.j.b bVar) {
        androidx.core.widget.i.p(this, bVar);
    }

    @Override // c.h.k.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // c.h.k.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f685b.v(colorStateList);
        this.f685b.b();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f685b.w(mode);
        this.f685b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        t tVar;
        if (Build.VERSION.SDK_INT < 28 && (tVar = this.f686c) != null) {
            tVar.b(textClassifier);
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    public void setTextFuture(Future<c.h.j.b> future) {
        this.f687d = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(b.a aVar) {
        androidx.core.widget.i.r(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (androidx.core.widget.b.f1574i) {
            super.setTextSize(i2, f2);
            return;
        }
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.z(i2, f2);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i2) {
        Typeface a = (typeface == null || i2 <= 0) ? null : c.h.e.d.a(getContext(), typeface, i2);
        if (a != null) {
            typeface = a;
        }
        super.setTypeface(typeface, i2);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i2) {
        super(p0.b(context), attributeSet, i2);
        n0.a(this, getContext());
        e eVar = new e(this);
        this.a = eVar;
        eVar.e(attributeSet, i2);
        u uVar = new u(this);
        this.f685b = uVar;
        uVar.m(attributeSet, i2);
        uVar.b();
        this.f686c = new t(this);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i2 != 0 ? c.a.k.a.a.d(context, i2) : null, i3 != 0 ? c.a.k.a.a.d(context, i3) : null, i4 != 0 ? c.a.k.a.a.d(context, i4) : null, i5 != 0 ? c.a.k.a.a.d(context, i5) : null);
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i2 != 0 ? c.a.k.a.a.d(context, i2) : null, i3 != 0 ? c.a.k.a.a.d(context, i3) : null, i4 != 0 ? c.a.k.a.a.d(context, i4) : null, i5 != 0 ? c.a.k.a.a.d(context, i5) : null);
        u uVar = this.f685b;
        if (uVar != null) {
            uVar.p();
        }
    }
}