package com.th3rdwave.safeareacontext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SafeAreaView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class g extends com.facebook.react.views.view.f implements ViewTreeObserver.OnPreDrawListener {
    private j w;
    private com.th3rdwave.safeareacontext.a x;
    private EnumSet<h> y;
    private View z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeAreaView.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ AtomicBoolean a;

        a(AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a) {
                if (this.a.compareAndSet(false, true)) {
                    this.a.notify();
                }
            }
        }
    }

    public g(Context context) {
        super(context);
        this.w = j.PADDING;
    }

    private boolean A() {
        com.th3rdwave.safeareacontext.a c2;
        com.th3rdwave.safeareacontext.a aVar;
        View view = this.z;
        if (view == null || (c2 = f.c(view)) == null || ((aVar = this.x) != null && aVar.a(c2))) {
            return false;
        }
        this.x = c2;
        B();
        return true;
    }

    private void B() {
        if (this.x != null) {
            EnumSet<h> enumSet = this.y;
            if (enumSet == null) {
                enumSet = EnumSet.allOf(h.class);
            }
            i iVar = new i(this.x, this.w, enumSet);
            UIManagerModule uIManagerModule = (UIManagerModule) z(this).getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null) {
                uIManagerModule.setViewLocalData(getId(), iVar);
                C();
            }
        }
    }

    private void C() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        long nanoTime = System.nanoTime();
        z(this).runOnNativeModulesQueueThread(new a(atomicBoolean));
        synchronized (atomicBoolean) {
            long j2 = 0;
            while (!atomicBoolean.get() && j2 < 500000000) {
                try {
                    atomicBoolean.wait(500L);
                } catch (InterruptedException unused) {
                    atomicBoolean.set(true);
                }
                j2 += System.nanoTime() - nanoTime;
            }
            if (j2 >= 500000000) {
                Log.w("SafeAreaView", "Timed out waiting for layout.");
            }
        }
    }

    private View y() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof e) {
                return (View) parent;
            }
        }
        return this;
    }

    private static ReactContext z(View view) {
        Context context = view.getContext();
        if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.views.view.f, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View y = y();
        this.z = y;
        y.getViewTreeObserver().addOnPreDrawListener(this);
        A();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View view = this.z;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.z = null;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean A = A();
        if (A) {
            requestLayout();
        }
        return !A;
    }

    public void setEdges(EnumSet<h> enumSet) {
        this.y = enumSet;
        B();
    }

    public void setMode(j jVar) {
        this.w = jVar;
        B();
    }
}