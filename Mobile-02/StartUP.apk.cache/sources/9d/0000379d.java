package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import c.h.k.v;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* loaded from: classes2.dex */
public class CheckableImageButton extends androidx.appcompat.widget.j implements Checkable {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f8174c = {16842912};

    /* renamed from: d  reason: collision with root package name */
    private boolean f8175d;

    /* loaded from: classes2.dex */
    class a extends c.h.k.a {
        a() {
        }

        @Override // c.h.k.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // c.h.k.a
        public void g(View view, c.h.k.e0.d dVar) {
            super.g(view, dVar);
            dVar.R(true);
            dVar.S(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.C);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f8175d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        if (this.f8175d) {
            int[] iArr = f8174c;
            return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i2 + iArr.length), iArr);
        }
        return super.onCreateDrawableState(i2);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f8175d != z) {
            this.f8175d = z;
            refreshDrawableState();
            sendAccessibilityEvent(PKIFailureInfo.wrongIntegrity);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f8175d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        v.k0(this, new a());
    }
}