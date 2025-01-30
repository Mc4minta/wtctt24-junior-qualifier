package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import c.h.k.e0.c;
import c.h.k.v;
import e.g.a.f.k;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes2.dex */
public class d extends FrameLayout {
    private final AccessibilityManager a;

    /* renamed from: b  reason: collision with root package name */
    private final c.a f8201b;

    /* renamed from: c  reason: collision with root package name */
    private c f8202c;

    /* renamed from: d  reason: collision with root package name */
    private b f8203d;

    /* compiled from: BaseTransientBottomBar.java */
    /* loaded from: classes2.dex */
    class a implements c.a {
        a() {
        }

        @Override // c.h.k.e0.c.a
        public void onTouchExplorationStateChanged(boolean z) {
            d.this.setClickableOrFocusableBasedOnAccessibility(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.m1);
        int i2 = k.o1;
        if (obtainStyledAttributes.hasValue(i2)) {
            v.q0(this, obtainStyledAttributes.getDimensionPixelSize(i2, 0));
        }
        obtainStyledAttributes.recycle();
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        this.a = accessibilityManager;
        a aVar = new a();
        this.f8201b = aVar;
        c.h.k.e0.c.a(accessibilityManager, aVar);
        setClickableOrFocusableBasedOnAccessibility(accessibilityManager.isTouchExplorationEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClickableOrFocusableBasedOnAccessibility(boolean z) {
        setClickable(!z);
        setFocusable(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f8203d;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        v.h0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f8203d;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
        c.h.k.e0.c.b(this.a, this.f8201b);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        c cVar = this.f8202c;
        if (cVar != null) {
            cVar.a(this, i2, i3, i4, i5);
        }
    }

    void setOnAttachStateChangeListener(b bVar) {
        this.f8203d = bVar;
    }

    void setOnLayoutChangeListener(c cVar) {
        this.f8202c = cVar;
    }
}