package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* loaded from: classes.dex */
public class AppCompatButton extends Button implements c.h.k.u, androidx.core.widget.b, androidx.core.widget.k {
    private final e a;

    /* renamed from: b  reason: collision with root package name */
    private final u f680b;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.q);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.a;
        if (eVar != null) {
            eVar.b();
        }
        u uVar = this.f680b;
        if (uVar != null) {
            uVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.b.f1574i) {
            return super.getAutoSizeMaxTextSize();
        }
        u uVar = this.f680b;
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
        u uVar = this.f680b;
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
        u uVar = this.f680b;
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
        u uVar = this.f680b;
        return uVar != null ? uVar.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.b.f1574i) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        u uVar = this.f680b;
        if (uVar != null) {
            return uVar.i();
        }
        return 0;
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
        return this.f680b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f680b.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        u uVar = this.f680b;
        if (uVar != null) {
            uVar.o(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        u uVar = this.f680b;
        if (uVar == null || androidx.core.widget.b.f1574i || !uVar.l()) {
            return;
        }
        this.f680b.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (androidx.core.widget.b.f1574i) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        u uVar = this.f680b;
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
        u uVar = this.f680b;
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
        u uVar = this.f680b;
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
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.s(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        u uVar = this.f680b;
        if (uVar != null) {
            uVar.r(z);
        }
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
        this.f680b.v(colorStateList);
        this.f680b.b();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f680b.w(mode);
        this.f680b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        u uVar = this.f680b;
        if (uVar != null) {
            uVar.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (androidx.core.widget.b.f1574i) {
            super.setTextSize(i2, f2);
            return;
        }
        u uVar = this.f680b;
        if (uVar != null) {
            uVar.z(i2, f2);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i2) {
        super(p0.b(context), attributeSet, i2);
        n0.a(this, getContext());
        e eVar = new e(this);
        this.a = eVar;
        eVar.e(attributeSet, i2);
        u uVar = new u(this);
        this.f680b = uVar;
        uVar.m(attributeSet, i2);
        uVar.b();
    }
}