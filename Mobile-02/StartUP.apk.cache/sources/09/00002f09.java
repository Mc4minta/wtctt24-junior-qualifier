package com.facebook.react.uimanager.f1;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;

/* compiled from: LayoutAnimationController.java */
/* loaded from: classes2.dex */
public class e {
    private static Handler a;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5098f;

    /* renamed from: h  reason: collision with root package name */
    private Runnable f5100h;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.react.uimanager.f1.a f5094b = new h();

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.react.uimanager.f1.a f5095c = new k();

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.react.uimanager.f1.a f5096d = new i();

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray<j> f5097e = new SparseArray<>(0);

    /* renamed from: g  reason: collision with root package name */
    private long f5099g = -1;

    /* compiled from: LayoutAnimationController.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ Callback a;

        a(Callback callback) {
            this.a = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.invoke(Boolean.TRUE);
        }
    }

    /* compiled from: LayoutAnimationController.java */
    /* loaded from: classes2.dex */
    class b implements Animation.AnimationListener {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            e.this.f5097e.remove(this.a);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            e.this.f5097e.put(this.a, (j) animation);
        }
    }

    /* compiled from: LayoutAnimationController.java */
    /* loaded from: classes2.dex */
    class c implements Animation.AnimationListener {
        final /* synthetic */ f a;

        c(f fVar) {
            this.a = fVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.a();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    private void d(View view) {
        view.setClickable(false);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                d(viewGroup.getChildAt(i2));
            }
        }
    }

    private void g(long j2) {
        if (a == null) {
            a = new Handler(Looper.getMainLooper());
        }
        Runnable runnable = this.f5100h;
        if (runnable != null) {
            a.removeCallbacks(runnable);
            a.postDelayed(this.f5100h, j2);
        }
    }

    public void b(View view, int i2, int i3, int i4, int i5) {
        UiThreadUtil.assertOnUiThread();
        int id = view.getId();
        j jVar = this.f5097e.get(id);
        if (jVar != null) {
            jVar.b(i2, i3, i4, i5);
            return;
        }
        Animation a2 = ((view.getWidth() == 0 || view.getHeight() == 0) ? this.f5094b : this.f5095c).a(view, i2, i3, i4, i5);
        if (a2 instanceof j) {
            a2.setAnimationListener(new b(id));
        } else {
            view.layout(i2, i3, i4 + i2, i5 + i3);
        }
        if (a2 != null) {
            long duration = a2.getDuration();
            if (duration > this.f5099g) {
                this.f5099g = duration;
                g(duration);
            }
            view.startAnimation(a2);
        }
    }

    public void c(View view, f fVar) {
        UiThreadUtil.assertOnUiThread();
        Animation a2 = this.f5096d.a(view, view.getLeft(), view.getTop(), view.getWidth(), view.getHeight());
        if (a2 != null) {
            d(view);
            a2.setAnimationListener(new c(fVar));
            long duration = a2.getDuration();
            if (duration > this.f5099g) {
                g(duration);
                this.f5099g = duration;
            }
            view.startAnimation(a2);
            return;
        }
        fVar.a();
    }

    public void e(ReadableMap readableMap, Callback callback) {
        if (readableMap == null) {
            f();
            return;
        }
        this.f5098f = false;
        int i2 = readableMap.hasKey("duration") ? readableMap.getInt("duration") : 0;
        g gVar = g.CREATE;
        if (readableMap.hasKey(g.h(gVar))) {
            this.f5094b.d(readableMap.getMap(g.h(gVar)), i2);
            this.f5098f = true;
        }
        g gVar2 = g.UPDATE;
        if (readableMap.hasKey(g.h(gVar2))) {
            this.f5095c.d(readableMap.getMap(g.h(gVar2)), i2);
            this.f5098f = true;
        }
        g gVar3 = g.DELETE;
        if (readableMap.hasKey(g.h(gVar3))) {
            this.f5096d.d(readableMap.getMap(g.h(gVar3)), i2);
            this.f5098f = true;
        }
        if (!this.f5098f || callback == null) {
            return;
        }
        this.f5100h = new a(callback);
    }

    public void f() {
        this.f5094b.f();
        this.f5095c.f();
        this.f5096d.f();
        this.f5100h = null;
        this.f5098f = false;
        this.f5099g = -1L;
    }

    public boolean h(View view) {
        if (view == null) {
            return false;
        }
        return (this.f5098f && view.getParent() != null) || this.f5097e.get(view.getId()) != null;
    }
}