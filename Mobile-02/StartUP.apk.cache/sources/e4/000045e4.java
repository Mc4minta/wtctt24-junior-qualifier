package e.f.h.g;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: GestureDetector.java */
/* loaded from: classes2.dex */
public class a {
    InterfaceC0269a a;

    /* renamed from: b  reason: collision with root package name */
    final float f12358b;

    /* renamed from: c  reason: collision with root package name */
    boolean f12359c;

    /* renamed from: d  reason: collision with root package name */
    boolean f12360d;

    /* renamed from: e  reason: collision with root package name */
    long f12361e;

    /* renamed from: f  reason: collision with root package name */
    float f12362f;

    /* renamed from: g  reason: collision with root package name */
    float f12363g;

    /* compiled from: GestureDetector.java */
    /* renamed from: e.f.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0269a {
        boolean e();
    }

    public a(Context context) {
        this.f12358b = ViewConfiguration.get(context).getScaledTouchSlop();
        a();
    }

    public static a c(Context context) {
        return new a(context);
    }

    public void a() {
        this.a = null;
        e();
    }

    public boolean b() {
        return this.f12359c;
    }

    public boolean d(MotionEvent motionEvent) {
        InterfaceC0269a interfaceC0269a;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f12359c = true;
            this.f12360d = true;
            this.f12361e = motionEvent.getEventTime();
            this.f12362f = motionEvent.getX();
            this.f12363g = motionEvent.getY();
        } else if (action == 1) {
            this.f12359c = false;
            if (Math.abs(motionEvent.getX() - this.f12362f) > this.f12358b || Math.abs(motionEvent.getY() - this.f12363g) > this.f12358b) {
                this.f12360d = false;
            }
            if (this.f12360d && motionEvent.getEventTime() - this.f12361e <= ViewConfiguration.getLongPressTimeout() && (interfaceC0269a = this.a) != null) {
                interfaceC0269a.e();
            }
            this.f12360d = false;
        } else if (action != 2) {
            if (action == 3) {
                this.f12359c = false;
                this.f12360d = false;
            }
        } else if (Math.abs(motionEvent.getX() - this.f12362f) > this.f12358b || Math.abs(motionEvent.getY() - this.f12363g) > this.f12358b) {
            this.f12360d = false;
        }
        return true;
    }

    public void e() {
        this.f12359c = false;
        this.f12360d = false;
    }

    public void f(InterfaceC0269a interfaceC0269a) {
        this.a = interfaceC0269a;
    }
}