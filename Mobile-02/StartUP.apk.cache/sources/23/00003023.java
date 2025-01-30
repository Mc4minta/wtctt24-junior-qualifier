package com.facebook.react.views.textinput;

import android.os.Build;
import android.text.SpannableStringBuilder;
import android.widget.EditText;

/* compiled from: ReactTextInputLocalData.java */
/* loaded from: classes2.dex */
public final class k {
    private final SpannableStringBuilder a;

    /* renamed from: b  reason: collision with root package name */
    private final float f5515b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5516c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5517d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5518e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5519f;

    /* renamed from: g  reason: collision with root package name */
    private final CharSequence f5520g;

    public k(EditText editText) {
        this.a = new SpannableStringBuilder(editText.getText());
        this.f5515b = editText.getTextSize();
        this.f5518e = editText.getInputType();
        this.f5520g = editText.getHint();
        this.f5516c = editText.getMinLines();
        this.f5517d = editText.getMaxLines();
        if (Build.VERSION.SDK_INT >= 23) {
            this.f5519f = editText.getBreakStrategy();
        } else {
            this.f5519f = 0;
        }
    }

    public void a(EditText editText) {
        editText.setText(this.a);
        editText.setTextSize(0, this.f5515b);
        editText.setMinLines(this.f5516c);
        editText.setMaxLines(this.f5517d);
        editText.setInputType(this.f5518e);
        editText.setHint(this.f5520g);
        if (Build.VERSION.SDK_INT >= 23) {
            editText.setBreakStrategy(this.f5519f);
        }
    }
}