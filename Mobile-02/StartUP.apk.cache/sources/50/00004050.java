package com.th3rdwave.safeareacontext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* compiled from: SafeAreaProvider.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class e extends com.facebook.react.views.view.f implements ViewTreeObserver.OnPreDrawListener {
    private a w;
    private com.th3rdwave.safeareacontext.a x;
    private c y;

    /* compiled from: SafeAreaProvider.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(e eVar, com.th3rdwave.safeareacontext.a aVar, c cVar);
    }

    public e(Context context) {
        super(context);
    }

    private void y() {
        com.th3rdwave.safeareacontext.a c2 = f.c(this);
        c a2 = f.a((ViewGroup) getRootView(), this);
        if (c2 == null || a2 == null) {
            return;
        }
        com.th3rdwave.safeareacontext.a aVar = this.x;
        if (aVar == null || this.y == null || !aVar.a(c2) || !this.y.a(a2)) {
            ((a) e.f.k.a.a.c(this.w)).a(this, c2, a2);
            this.x = c2;
            this.y = a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.views.view.f, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
        y();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        y();
        return true;
    }

    public void setOnInsetsChangeListener(a aVar) {
        this.w = aVar;
    }
}