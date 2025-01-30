package com.facebook.react.views.viewpager;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ReactViewPager.java */
/* loaded from: classes2.dex */
public class d extends ViewPager {
    private final com.facebook.react.uimanager.events.d a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5562b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5563c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f5564d;

    /* compiled from: ReactViewPager.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.measure(View.MeasureSpec.makeMeasureSpec(dVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(d.this.getHeight(), 1073741824));
            d dVar2 = d.this;
            dVar2.layout(dVar2.getLeft(), d.this.getTop(), d.this.getRight(), d.this.getBottom());
        }
    }

    /* compiled from: ReactViewPager.java */
    /* loaded from: classes2.dex */
    private class c implements ViewPager.j {
        private c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i2) {
            String str;
            if (i2 == 0) {
                str = "idle";
            } else if (i2 == 1) {
                str = "dragging";
            } else if (i2 != 2) {
                throw new IllegalStateException("Unsupported pageScrollState");
            } else {
                str = "settling";
            }
            d.this.a.v(new com.facebook.react.views.viewpager.b(d.this.getId(), str));
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i2, float f2, int i3) {
            d.this.a.v(new com.facebook.react.views.viewpager.a(d.this.getId(), i2, f2));
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i2) {
            if (d.this.f5562b) {
                return;
            }
            d.this.a.v(new com.facebook.react.views.viewpager.c(d.this.getId(), i2));
        }

        /* synthetic */ c(d dVar, a aVar) {
            this();
        }
    }

    public d(ReactContext reactContext) {
        super(reactContext);
        this.f5563c = true;
        this.f5564d = new a();
        this.a = ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.f5562b = false;
        setOnPageChangeListener(new c(this, null));
        setAdapter(new b(this, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view, int i2) {
        getAdapter().a(view, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View e(int i2) {
        return getAdapter().b(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i2) {
        getAdapter().c(i2);
    }

    public void g(int i2, boolean z) {
        this.f5562b = true;
        setCurrentItem(i2, z);
        this.f5562b = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getViewCountInAdapter() {
        return getAdapter().getCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestLayout();
        post(this.f5564d);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f5563c) {
            try {
                if (super.onInterceptTouchEvent(motionEvent)) {
                    f.a(this, motionEvent);
                    return true;
                }
            } catch (IllegalArgumentException e2) {
                e.f.d.d.a.B("ReactNative", "Error intercepting touch event.", e2);
            }
            return false;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f5563c) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException e2) {
                e.f.d.d.a.B("ReactNative", "Error handling touch event.", e2);
                return false;
            }
        }
        return false;
    }

    public void setScrollEnabled(boolean z) {
        this.f5563c = z;
    }

    public void setViews(List<View> list) {
        getAdapter().d(list);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public b getAdapter() {
        return (b) super.getAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReactViewPager.java */
    /* loaded from: classes2.dex */
    public class b extends androidx.viewpager.widget.a {
        private final List<View> a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f5565b;

        private b() {
            this.a = new ArrayList();
            this.f5565b = false;
        }

        void a(View view, int i2) {
            this.a.add(i2, view);
            notifyDataSetChanged();
            d.this.setOffscreenPageLimit(this.a.size());
        }

        View b(int i2) {
            return this.a.get(i2);
        }

        void c(int i2) {
            this.a.remove(i2);
            notifyDataSetChanged();
            d.this.setOffscreenPageLimit(this.a.size());
        }

        void d(List<View> list) {
            this.a.clear();
            this.a.addAll(list);
            notifyDataSetChanged();
            this.f5565b = false;
        }

        @Override // androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return this.a.size();
        }

        @Override // androidx.viewpager.widget.a
        public int getItemPosition(Object obj) {
            if (this.f5565b || !this.a.contains(obj)) {
                return -2;
            }
            return this.a.indexOf(obj);
        }

        @Override // androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            View view = this.a.get(i2);
            viewGroup.addView(view, 0, d.this.generateDefaultLayoutParams());
            return view;
        }

        @Override // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        /* synthetic */ b(d dVar, a aVar) {
            this();
        }
    }
}