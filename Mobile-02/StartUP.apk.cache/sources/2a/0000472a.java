package e.f.m.z;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: JSResponderHandler.java */
/* loaded from: classes2.dex */
public class a implements b {
    private volatile int a = -1;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f12911b;

    private void c() {
        ViewParent viewParent = this.f12911b;
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(false);
            this.f12911b = null;
        }
    }

    @Override // e.f.m.z.b
    public boolean a(ViewGroup viewGroup, MotionEvent motionEvent) {
        int i2 = this.a;
        return (i2 == -1 || motionEvent.getAction() == 1 || viewGroup.getId() != i2) ? false : true;
    }

    public void b() {
        this.a = -1;
        c();
    }

    public void d(int i2, ViewParent viewParent) {
        this.a = i2;
        c();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
            this.f12911b = viewParent;
        }
    }
}