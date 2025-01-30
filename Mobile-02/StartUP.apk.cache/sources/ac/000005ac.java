package c.h.k;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

/* compiled from: OneShotPreDrawListener.java */
/* loaded from: classes.dex */
public final class s implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    private final View a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f3051b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f3052c;

    private s(View view, Runnable runnable) {
        this.a = view;
        this.f3051b = view.getViewTreeObserver();
        this.f3052c = runnable;
    }

    public static s a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        s sVar = new s(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(sVar);
        view.addOnAttachStateChangeListener(sVar);
        return sVar;
    }

    public void b() {
        if (this.f3051b.isAlive()) {
            this.f3051b.removeOnPreDrawListener(this);
        } else {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f3052c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f3051b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}