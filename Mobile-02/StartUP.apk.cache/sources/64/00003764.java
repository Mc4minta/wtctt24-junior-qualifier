package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.h.k.v;
import c.j.b.a;

/* loaded from: classes2.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {
    c.j.b.a a;

    /* renamed from: b  reason: collision with root package name */
    b f8069b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8070c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8072e;

    /* renamed from: d  reason: collision with root package name */
    private float f8071d = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    int f8073f = 2;

    /* renamed from: g  reason: collision with root package name */
    float f8074g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    float f8075h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    float f8076i = 0.5f;

    /* renamed from: j  reason: collision with root package name */
    private final a.c f8077j = new a();

    /* loaded from: classes2.dex */
    class a extends a.c {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f8078b = -1;

        a() {
        }

        private boolean n(View view, float f2) {
            int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i2 == 0) {
                return Math.abs(view.getLeft() - this.a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f8074g);
            }
            boolean z = v.y(view) == 1;
            int i3 = SwipeDismissBehavior.this.f8073f;
            if (i3 == 2) {
                return true;
            }
            if (i3 == 0) {
                if (z) {
                    if (f2 >= 0.0f) {
                        return false;
                    }
                } else if (i2 <= 0) {
                    return false;
                }
                return true;
            } else if (i3 == 1) {
                if (z) {
                    if (i2 <= 0) {
                        return false;
                    }
                } else if (f2 >= 0.0f) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        @Override // c.j.b.a.c
        public int a(View view, int i2, int i3) {
            int width;
            int width2;
            int width3;
            boolean z = v.y(view) == 1;
            int i4 = SwipeDismissBehavior.this.f8073f;
            if (i4 == 0) {
                if (z) {
                    width = this.a - view.getWidth();
                    width2 = this.a;
                } else {
                    width = this.a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i4 != 1) {
                width = this.a - view.getWidth();
                width2 = view.getWidth() + this.a;
            } else if (z) {
                width = this.a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.a - view.getWidth();
                width2 = this.a;
            }
            return SwipeDismissBehavior.F(width, i2, width2);
        }

        @Override // c.j.b.a.c
        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // c.j.b.a.c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // c.j.b.a.c
        public void i(View view, int i2) {
            this.f8078b = i2;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // c.j.b.a.c
        public void j(int i2) {
            b bVar = SwipeDismissBehavior.this.f8069b;
            if (bVar != null) {
                bVar.b(i2);
            }
        }

        @Override // c.j.b.a.c
        public void k(View view, int i2, int i3, int i4, int i5) {
            float width = this.a + (view.getWidth() * SwipeDismissBehavior.this.f8075h);
            float width2 = this.a + (view.getWidth() * SwipeDismissBehavior.this.f8076i);
            float f2 = i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.E(0.0f, 1.0f - SwipeDismissBehavior.H(width, width2, f2), 1.0f));
            }
        }

        @Override // c.j.b.a.c
        public void l(View view, float f2, float f3) {
            int i2;
            boolean z;
            b bVar;
            this.f8078b = -1;
            int width = view.getWidth();
            if (n(view, f2)) {
                int left = view.getLeft();
                int i3 = this.a;
                i2 = left < i3 ? i3 - width : i3 + width;
                z = true;
            } else {
                i2 = this.a;
                z = false;
            }
            if (SwipeDismissBehavior.this.a.O(i2, view.getTop())) {
                v.c0(view, new c(view, z));
            } else if (!z || (bVar = SwipeDismissBehavior.this.f8069b) == null) {
            } else {
                bVar.a(view);
            }
        }

        @Override // c.j.b.a.c
        public boolean m(View view, int i2) {
            return this.f8078b == -1 && SwipeDismissBehavior.this.D(view);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view);

        void b(int i2);
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private final View a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f8080b;

        c(View view, boolean z) {
            this.a = view;
            this.f8080b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            c.j.b.a aVar = SwipeDismissBehavior.this.a;
            if (aVar != null && aVar.m(true)) {
                v.c0(this.a, this);
            } else if (!this.f8080b || (bVar = SwipeDismissBehavior.this.f8069b) == null) {
            } else {
                bVar.a(this.a);
            }
        }
    }

    static float E(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int F(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }

    private void G(ViewGroup viewGroup) {
        c.j.b.a o;
        if (this.a == null) {
            if (this.f8072e) {
                o = c.j.b.a.n(viewGroup, this.f8071d, this.f8077j);
            } else {
                o = c.j.b.a.o(viewGroup, this.f8077j);
            }
            this.a = o;
        }
    }

    static float H(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean C(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        c.j.b.a aVar = this.a;
        if (aVar != null) {
            aVar.F(motionEvent);
            return true;
        }
        return false;
    }

    public boolean D(View view) {
        return true;
    }

    public void I(float f2) {
        this.f8076i = E(0.0f, f2, 1.0f);
    }

    public void J(float f2) {
        this.f8075h = E(0.0f, f2, 1.0f);
    }

    public void K(int i2) {
        this.f8073f = i2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f8070c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.v(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f8070c = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f8070c = false;
        }
        if (z) {
            G(coordinatorLayout);
            return this.a.P(motionEvent);
        }
        return false;
    }
}