package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* compiled from: AppCompatToggleButton.java */
/* loaded from: classes.dex */
public class w extends ToggleButton {
    private final u a;

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public w(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        n0.a(this, getContext());
        u uVar = new u(this);
        this.a = uVar;
        uVar.m(attributeSet, i2);
    }
}