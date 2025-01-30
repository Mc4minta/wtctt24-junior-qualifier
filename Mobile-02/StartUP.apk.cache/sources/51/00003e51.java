package com.lwansbrough.RCTCamera;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.List;

/* compiled from: RCTCameraView.java */
/* loaded from: classes2.dex */
public class c extends ViewGroup {
    private final OrientationEventListener a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f10487b;

    /* renamed from: c  reason: collision with root package name */
    private d f10488c;

    /* renamed from: d  reason: collision with root package name */
    private int f10489d;

    /* renamed from: e  reason: collision with root package name */
    private int f10490e;

    /* renamed from: f  reason: collision with root package name */
    private int f10491f;

    /* renamed from: g  reason: collision with root package name */
    private String f10492g;

    /* renamed from: h  reason: collision with root package name */
    private int f10493h;

    /* renamed from: j  reason: collision with root package name */
    private int f10494j;

    /* renamed from: k  reason: collision with root package name */
    private int f10495k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10496l;

    /* compiled from: RCTCameraView.java */
    /* loaded from: classes2.dex */
    class a extends OrientationEventListener {
        a(Context context, int i2) {
            super(context, i2);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i2) {
            c cVar = c.this;
            if (cVar.g(cVar.f10487b)) {
                c.this.e();
            }
        }
    }

    public c(Context context) {
        super(context);
        this.f10488c = null;
        this.f10489d = -1;
        this.f10490e = 1;
        this.f10491f = 0;
        this.f10492g = RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH;
        this.f10493h = -1;
        this.f10494j = -1;
        this.f10495k = 0;
        this.f10496l = false;
        this.f10487b = context;
        com.lwansbrough.RCTCamera.a.d(d(context));
        a aVar = new a(context, 3);
        this.a = aVar;
        if (aVar.canDetectOrientation()) {
            aVar.enable();
        } else {
            aVar.disable();
        }
    }

    private int d(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getOrientation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        f(getLeft(), getTop(), getRight(), getBottom());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
        if (r0 > r2) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r0 < r2) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
        r9 = (int) (r2 / r8);
        r8 = (int) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        r8 = (int) r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f(int r6, int r7, int r8, int r9) {
        /*
            r5 = this;
            com.lwansbrough.RCTCamera.d r0 = r5.f10488c
            if (r0 != 0) goto L5
            return
        L5:
            int r8 = r8 - r6
            float r6 = (float) r8
            int r9 = r9 - r7
            float r7 = (float) r9
            int r8 = r5.f10490e
            if (r8 == 0) goto L1f
            r9 = 1
            if (r8 == r9) goto L13
            int r8 = (int) r6
        L11:
            int r9 = (int) r7
            goto L30
        L13:
            double r8 = r0.f()
            double r0 = (double) r7
            double r0 = r0 * r8
            double r2 = (double) r6
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L2e
            goto L2a
        L1f:
            double r8 = r0.f()
            double r0 = (double) r7
            double r0 = r0 * r8
            double r2 = (double) r6
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L2e
        L2a:
            double r2 = r2 / r8
            int r9 = (int) r2
            int r8 = (int) r6
            goto L30
        L2e:
            int r8 = (int) r0
            goto L11
        L30:
            float r0 = (float) r8
            float r0 = r6 - r0
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            int r0 = (int) r0
            float r2 = (float) r9
            float r2 = r7 - r2
            float r2 = r2 / r1
            int r1 = (int) r2
            com.lwansbrough.RCTCamera.a r2 = com.lwansbrough.RCTCamera.a.h()
            com.lwansbrough.RCTCamera.d r3 = r5.f10488c
            int r3 = r3.d()
            int r6 = (int) r6
            int r7 = (int) r7
            r2.A(r3, r6, r7)
            com.lwansbrough.RCTCamera.d r6 = r5.f10488c
            int r8 = r8 + r0
            int r9 = r9 + r1
            r6.layout(r0, r1, r8, r9)
            int r6 = r5.getLeft()
            int r7 = r5.getTop()
            int r8 = r5.getRight()
            int r9 = r5.getBottom()
            r5.postInvalidate(r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lwansbrough.RCTCamera.c.f(int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(Context context) {
        int d2 = d(context);
        if (this.f10489d != d2) {
            this.f10489d = d2;
            com.lwansbrough.RCTCamera.a.h().r(this.f10489d);
            return true;
        }
        return false;
    }

    public void h() {
        d dVar = this.f10488c;
        if (dVar == null) {
            return;
        }
        dVar.s();
    }

    public void i() {
        d dVar = this.f10488c;
        if (dVar == null) {
            return;
        }
        dVar.u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        f(i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        d dVar = this.f10488c;
        if (dVar == view) {
            return;
        }
        removeView(dVar);
        addView(this.f10488c, 0);
    }

    public void setAspect(int i2) {
        this.f10490e = i2;
        e();
    }

    public void setBarCodeTypes(List<String> list) {
        com.lwansbrough.RCTCamera.a.h().t(list);
    }

    public void setBarcodeScannerEnabled(boolean z) {
        com.lwansbrough.RCTCamera.a.h().u(z);
    }

    public void setCameraType(int i2) {
        d dVar = this.f10488c;
        if (dVar != null) {
            dVar.k(i2);
            com.lwansbrough.RCTCamera.a.h().c(i2);
            return;
        }
        d dVar2 = new d(this.f10487b, i2);
        this.f10488c = dVar2;
        int i3 = this.f10494j;
        if (-1 != i3) {
            dVar2.o(i3);
        }
        int i4 = this.f10493h;
        if (-1 != i4) {
            this.f10488c.p(i4);
        }
        int i5 = this.f10495k;
        if (i5 != 0) {
            this.f10488c.q(i5);
        }
        this.f10488c.n(this.f10496l);
        addView(this.f10488c);
    }

    public void setCaptureMode(int i2) {
        this.f10491f = i2;
        d dVar = this.f10488c;
        if (dVar != null) {
            dVar.l(i2);
        }
    }

    public void setCaptureQuality(String str) {
        this.f10492g = str;
        d dVar = this.f10488c;
        if (dVar != null) {
            dVar.m(str);
        }
    }

    public void setClearWindowBackground(boolean z) {
        this.f10496l = z;
        d dVar = this.f10488c;
        if (dVar != null) {
            dVar.n(z);
        }
    }

    public void setFlashMode(int i2) {
        this.f10494j = i2;
        d dVar = this.f10488c;
        if (dVar != null) {
            dVar.o(i2);
        }
    }

    public void setOrientation(int i2) {
        com.lwansbrough.RCTCamera.a.h().z(i2);
        if (this.f10488c != null) {
            e();
        }
    }

    public void setTorchMode(int i2) {
        this.f10493h = i2;
        d dVar = this.f10488c;
        if (dVar != null) {
            dVar.p(i2);
        }
    }

    public void setZoom(int i2) {
        this.f10495k = i2;
        d dVar = this.f10488c;
        if (dVar != null) {
            dVar.q(i2);
        }
    }
}