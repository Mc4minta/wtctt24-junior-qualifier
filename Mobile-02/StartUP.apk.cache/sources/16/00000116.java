package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* compiled from: AppCompatCheckedTextView.java */
/* loaded from: classes.dex */
public class f extends CheckedTextView {
    private static final int[] a = {16843016};

    /* renamed from: b  reason: collision with root package name */
    private final u f798b;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        u uVar = this.f798b;
        if (uVar != null) {
            uVar.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return i.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(c.a.k.a.a.d(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.s(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        u uVar = this.f798b;
        if (uVar != null) {
            uVar.q(context, i2);
        }
    }

    public f(Context context, AttributeSet attributeSet, int i2) {
        super(p0.b(context), attributeSet, i2);
        n0.a(this, getContext());
        u uVar = new u(this);
        this.f798b = uVar;
        uVar.m(attributeSet, i2);
        uVar.b();
        s0 v = s0.v(getContext(), attributeSet, a, i2, 0);
        setCheckMarkDrawable(v.g(0));
        v.w();
    }
}