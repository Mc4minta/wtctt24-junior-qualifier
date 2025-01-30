package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.appcompat.app.j;
import androidx.appcompat.widget.AppCompatButton;
import e.g.a.f.m.a;

@Keep
/* loaded from: classes2.dex */
public class MaterialComponentsViewInflater extends j {
    @Override // androidx.appcompat.app.j
    protected AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }
}