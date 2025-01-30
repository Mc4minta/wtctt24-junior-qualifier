package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import com.facebook.react.bridge.SoftAssertions;

/* compiled from: TouchEvent.java */
/* loaded from: classes2.dex */
public class g extends c<g> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<g> f5069f = new androidx.core.util.g<>(3);

    /* renamed from: g  reason: collision with root package name */
    private MotionEvent f5070g;

    /* renamed from: h  reason: collision with root package name */
    private i f5071h;

    /* renamed from: i  reason: collision with root package name */
    private short f5072i;

    /* renamed from: j  reason: collision with root package name */
    private float f5073j;

    /* renamed from: k  reason: collision with root package name */
    private float f5074k;

    /* compiled from: TouchEvent.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.values().length];
            a = iArr;
            try {
                iArr[i.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.MOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private g() {
    }

    private void p(int i2, i iVar, MotionEvent motionEvent, long j2, float f2, float f3, h hVar) {
        super.j(i2);
        short s = 0;
        SoftAssertions.assertCondition(j2 != Long.MIN_VALUE, "Gesture start time must be initialized");
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            hVar.a(j2);
        } else if (action == 1) {
            hVar.e(j2);
        } else if (action == 2) {
            s = hVar.b(j2);
        } else if (action == 3) {
            hVar.e(j2);
        } else if (action != 5 && action != 6) {
            throw new RuntimeException("Unhandled MotionEvent action: " + action);
        } else {
            hVar.d(j2);
        }
        this.f5071h = iVar;
        this.f5070g = MotionEvent.obtain(motionEvent);
        this.f5072i = s;
        this.f5073j = f2;
        this.f5074k = f3;
    }

    public static g q(int i2, i iVar, MotionEvent motionEvent, long j2, float f2, float f3, h hVar) {
        g acquire = f5069f.acquire();
        if (acquire == null) {
            acquire = new g();
        }
        acquire.p(i2, iVar, motionEvent, j2, f2, f3, hVar);
        return acquire;
    }

    @Override // com.facebook.react.uimanager.events.c
    public boolean a() {
        int i2 = a.a[((i) e.f.k.a.a.c(this.f5071h)).ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return false;
        }
        if (i2 == 4) {
            return true;
        }
        throw new RuntimeException("Unknown touch event type: " + this.f5071h);
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        j.b(rCTEventEmitter, (i) e.f.k.a.a.c(this.f5071h), i(), this);
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return this.f5072i;
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return i.h((i) e.f.k.a.a.c(this.f5071h));
    }

    @Override // com.facebook.react.uimanager.events.c
    public void l() {
        ((MotionEvent) e.f.k.a.a.c(this.f5070g)).recycle();
        this.f5070g = null;
        f5069f.release(this);
    }

    public MotionEvent m() {
        e.f.k.a.a.c(this.f5070g);
        return this.f5070g;
    }

    public float n() {
        return this.f5073j;
    }

    public float o() {
        return this.f5074k;
    }
}