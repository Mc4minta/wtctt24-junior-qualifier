package e.i.a;

import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import e.i.a.b;
import java.util.Arrays;

/* compiled from: GestureHandler.java */
/* loaded from: classes2.dex */
public class b<T extends b> {
    private static int a = 12;

    /* renamed from: b  reason: collision with root package name */
    private static MotionEvent.PointerProperties[] f13474b;

    /* renamed from: c  reason: collision with root package name */
    private static MotionEvent.PointerCoords[] f13475c;

    /* renamed from: d  reason: collision with root package name */
    private static short f13476d;
    boolean A;

    /* renamed from: g  reason: collision with root package name */
    private int f13479g;

    /* renamed from: h  reason: collision with root package name */
    private View f13480h;

    /* renamed from: j  reason: collision with root package name */
    private float f13482j;

    /* renamed from: k  reason: collision with root package name */
    private float f13483k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13484l;
    private float[] n;
    private short o;
    private float p;
    private float q;
    private float r;
    private float s;
    private boolean t;
    private d v;
    private i<T> w;
    private c x;
    int y;
    boolean z;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f13477e = new int[a];

    /* renamed from: f  reason: collision with root package name */
    private int f13478f = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f13481i = 0;
    private boolean m = true;
    private int u = 0;

    /* compiled from: GestureHandler.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.d();
        }
    }

    private boolean A(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != this.f13478f) {
            return true;
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.f13477e;
            if (i2 >= iArr.length) {
                return false;
            }
            if (iArr[i2] != -1 && iArr[i2] != i2) {
                return true;
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.MotionEvent b(android.view.MotionEvent r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            boolean r2 = r26.A(r27)
            if (r2 != 0) goto Lb
            return r1
        Lb:
            int r2 = r27.getActionMasked()
            r3 = 2
            r4 = 5
            r5 = 0
            r6 = -1
            r7 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L19
            goto L37
        L19:
            r4 = 6
            if (r2 == r7) goto L21
            if (r2 != r4) goto L1f
            goto L21
        L1f:
            r3 = r6
            goto L50
        L21:
            int r2 = r27.getActionIndex()
            int r8 = r1.getPointerId(r2)
            int[] r9 = r0.f13477e
            r8 = r9[r8]
            if (r8 == r6) goto L4b
            int r3 = r0.f13478f
            if (r3 != r7) goto L34
            r4 = r7
        L34:
            r3 = r2
            r2 = r4
            goto L50
        L37:
            int r2 = r27.getActionIndex()
            int r8 = r1.getPointerId(r2)
            int[] r9 = r0.f13477e
            r8 = r9[r8]
            if (r8 == r6) goto L4b
            int r3 = r0.f13478f
            if (r3 != r7) goto L4a
            r4 = r5
        L4a:
            r3 = r4
        L4b:
            r25 = r3
            r3 = r2
            r2 = r25
        L50:
            int r4 = r0.f13478f
            v(r4)
            float r4 = r27.getX()
            float r7 = r27.getY()
            float r8 = r27.getRawX()
            float r9 = r27.getRawY()
            r1.setLocation(r8, r9)
            int r8 = r27.getPointerCount()
            r13 = r2
            r14 = r5
        L6e:
            if (r5 >= r8) goto L9c
            int r2 = r1.getPointerId(r5)
            int[] r9 = r0.f13477e
            r9 = r9[r2]
            if (r9 == r6) goto L99
            android.view.MotionEvent$PointerProperties[] r9 = e.i.a.b.f13474b
            r9 = r9[r14]
            r1.getPointerProperties(r5, r9)
            android.view.MotionEvent$PointerProperties[] r9 = e.i.a.b.f13474b
            r9 = r9[r14]
            int[] r10 = r0.f13477e
            r2 = r10[r2]
            r9.id = r2
            android.view.MotionEvent$PointerCoords[] r2 = e.i.a.b.f13475c
            r2 = r2[r14]
            r1.getPointerCoords(r5, r2)
            if (r5 != r3) goto L97
            int r2 = r14 << 8
            r13 = r13 | r2
        L97:
            int r14 = r14 + 1
        L99:
            int r5 = r5 + 1
            goto L6e
        L9c:
            long r9 = r27.getDownTime()
            long r11 = r27.getEventTime()
            android.view.MotionEvent$PointerProperties[] r15 = e.i.a.b.f13474b
            android.view.MotionEvent$PointerCoords[] r16 = e.i.a.b.f13475c
            int r17 = r27.getMetaState()
            int r18 = r27.getButtonState()
            float r19 = r27.getXPrecision()
            float r20 = r27.getYPrecision()
            int r21 = r27.getDeviceId()
            int r22 = r27.getEdgeFlags()
            int r23 = r27.getSource()
            int r24 = r27.getFlags()
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r1.setLocation(r4, r7)
            r2.setLocation(r4, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.b.b(android.view.MotionEvent):android.view.MotionEvent");
    }

    private int i() {
        int[] iArr;
        int i2 = 0;
        while (i2 < this.f13478f) {
            int i3 = 0;
            while (true) {
                iArr = this.f13477e;
                if (i3 >= iArr.length || iArr[i3] == i2) {
                    break;
                }
                i3++;
            }
            if (i3 == iArr.length) {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    private static boolean u(float f2) {
        return !Float.isNaN(f2);
    }

    private static void v(int i2) {
        if (f13474b == null) {
            int i3 = a;
            f13474b = new MotionEvent.PointerProperties[i3];
            f13475c = new MotionEvent.PointerCoords[i3];
        }
        while (i2 > 0) {
            MotionEvent.PointerProperties[] pointerPropertiesArr = f13474b;
            int i4 = i2 - 1;
            if (pointerPropertiesArr[i4] != null) {
                return;
            }
            pointerPropertiesArr[i4] = new MotionEvent.PointerProperties();
            f13475c[i4] = new MotionEvent.PointerCoords();
            i2--;
        }
    }

    private void z(int i2) {
        UiThreadUtil.assertOnUiThread();
        int i3 = this.f13481i;
        if (i3 == i2) {
            return;
        }
        this.f13481i = i2;
        if (i2 == 4) {
            short s = f13476d;
            f13476d = (short) (s + 1);
            this.o = s;
        }
        this.v.r(this, i2, i3);
        E(i2, i3);
    }

    protected void B() {
    }

    protected void C(MotionEvent motionEvent) {
        z(1);
    }

    protected void D() {
    }

    protected void E(int i2, int i3) {
    }

    public final void F(View view, d dVar) {
        if (this.f13480h == null && this.v == null) {
            Arrays.fill(this.f13477e, -1);
            this.f13478f = 0;
            this.f13481i = 0;
            this.f13480h = view;
            this.v = dVar;
            return;
        }
        throw new IllegalStateException("Already prepared or hasn't been reset");
    }

    public final void G() {
        this.f13480h = null;
        this.v = null;
        Arrays.fill(this.f13477e, -1);
        this.f13478f = 0;
        D();
    }

    public T H(boolean z) {
        if (this.f13480h != null) {
            UiThreadUtil.runOnUiThread(new a());
        }
        this.m = z;
        return this;
    }

    public T I(float f2, float f3, float f4, float f5, float f6, float f7) {
        if (this.n == null) {
            this.n = new float[6];
        }
        float[] fArr = this.n;
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f7;
        if (u(f6) && u(f2) && u(f4)) {
            throw new IllegalArgumentException("Cannot have all of left, right and width defined");
        }
        if (u(f6) && !u(f2) && !u(f4)) {
            throw new IllegalArgumentException("When width is set one of left or right pads need to be defined");
        }
        if (u(f7) && u(f5) && u(f3)) {
            throw new IllegalArgumentException("Cannot have all of top, bottom and height defined");
        }
        if (!u(f7) || u(f5) || u(f3)) {
            return this;
        }
        throw new IllegalArgumentException("When height is set one of top or bottom pads need to be defined");
    }

    public T J(c cVar) {
        this.x = cVar;
        return this;
    }

    public b K(i<T> iVar) {
        this.w = iVar;
        return this;
    }

    public T L(boolean z) {
        this.t = z;
        return this;
    }

    public void M(int i2) {
        this.f13479g = i2;
    }

    public boolean N(b bVar) {
        c cVar;
        if (bVar == this || (cVar = this.x) == null) {
            return false;
        }
        return cVar.a(this, bVar);
    }

    public boolean O(b bVar) {
        if (bVar == this) {
            return true;
        }
        c cVar = this.x;
        if (cVar != null) {
            return cVar.b(this, bVar);
        }
        return false;
    }

    public boolean P(b bVar) {
        c cVar;
        if (bVar == this || (cVar = this.x) == null) {
            return false;
        }
        return cVar.d(this, bVar);
    }

    public boolean Q(b bVar) {
        c cVar;
        if (bVar == this || (cVar = this.x) == null) {
            return false;
        }
        return cVar.c(this, bVar);
    }

    public void R(int i2) {
        int[] iArr = this.f13477e;
        if (iArr[i2] == -1) {
            iArr[i2] = i();
            this.f13478f++;
        }
    }

    public void S(int i2) {
        int[] iArr = this.f13477e;
        if (iArr[i2] != -1) {
            iArr[i2] = -1;
            this.f13478f--;
        }
    }

    public boolean T() {
        int i2;
        return (!this.m || (i2 = this.f13481i) == 1 || i2 == 3 || i2 == 5 || this.f13478f <= 0) ? false : true;
    }

    public final void a() {
        int i2 = this.f13481i;
        if (i2 == 0 || i2 == 2) {
            z(4);
        }
    }

    public final void c() {
        if (this.f13481i == 0) {
            z(2);
        }
    }

    public final void d() {
        int i2 = this.f13481i;
        if (i2 == 4 || i2 == 0 || i2 == 2) {
            B();
            z(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i2, int i3) {
        i<T> iVar = this.w;
        if (iVar != null) {
            iVar.a(this, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MotionEvent motionEvent) {
        i<T> iVar = this.w;
        if (iVar != null) {
            iVar.b(this, motionEvent);
        }
    }

    public final void g() {
        int i2 = this.f13481i;
        if (i2 == 2 || i2 == 4) {
            z(5);
        }
    }

    public final void h() {
        int i2 = this.f13481i;
        if (i2 == 4 || i2 == 0 || i2 == 2) {
            z(1);
        }
    }

    public short j() {
        return this.o;
    }

    public float k() {
        return this.p;
    }

    public float l() {
        return this.q;
    }

    public float m() {
        return this.p - this.r;
    }

    public float n() {
        return this.q - this.s;
    }

    public int o() {
        return this.u;
    }

    public int p() {
        return this.f13481i;
    }

    public int q() {
        return this.f13479g;
    }

    public View r() {
        return this.f13480h;
    }

    public final void s(MotionEvent motionEvent) {
        int i2;
        if (!this.m || (i2 = this.f13481i) == 3 || i2 == 1 || i2 == 5 || this.f13478f < 1) {
            return;
        }
        MotionEvent b2 = b(motionEvent);
        this.f13482j = b2.getX();
        this.f13483k = b2.getY();
        this.u = b2.getPointerCount();
        boolean y = y(this.f13480h, this.f13482j, this.f13483k);
        this.f13484l = y;
        if (this.t && !y) {
            int i3 = this.f13481i;
            if (i3 == 4) {
                d();
                return;
            } else if (i3 == 2) {
                h();
                return;
            } else {
                return;
            }
        }
        this.p = f.a(b2, true);
        this.q = f.b(b2, true);
        this.r = b2.getRawX() - b2.getX();
        this.s = b2.getRawY() - b2.getY();
        C(b2);
        if (b2 != motionEvent) {
            b2.recycle();
        }
    }

    public boolean t(b bVar) {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f13477e;
            if (i2 >= iArr.length) {
                return false;
            }
            if (iArr[i2] != -1 && bVar.f13477e[i2] != -1) {
                return true;
            }
            i2++;
        }
    }

    public String toString() {
        View view = this.f13480h;
        String simpleName = view == null ? null : view.getClass().getSimpleName();
        return getClass().getSimpleName() + "@[" + this.f13479g + "]:" + simpleName;
    }

    public boolean w() {
        return this.m;
    }

    public boolean x() {
        return this.f13484l;
    }

    public boolean y(View view, float f2, float f3) {
        float f4;
        float width = view.getWidth();
        float height = view.getHeight();
        float[] fArr = this.n;
        if (fArr != null) {
            float f5 = fArr[0];
            float f6 = fArr[1];
            float f7 = fArr[2];
            float f8 = fArr[3];
            float f9 = u(f5) ? 0.0f - f5 : 0.0f;
            r4 = u(f6) ? 0.0f - f8 : 0.0f;
            if (u(f7)) {
                width += f7;
            }
            if (u(f8)) {
                height += f8;
            }
            float[] fArr2 = this.n;
            float f10 = fArr2[4];
            float f11 = fArr2[5];
            if (u(f10)) {
                if (!u(f5)) {
                    f9 = width - f10;
                } else if (!u(f7)) {
                    width = f10 + f9;
                }
            }
            if (u(f11)) {
                if (!u(r4)) {
                    r4 = height - f11;
                } else if (!u(height)) {
                    height = r4 + f11;
                }
            }
            f4 = r4;
            r4 = f9;
        } else {
            f4 = 0.0f;
        }
        return f2 >= r4 && f2 <= width && f3 >= f4 && f3 <= height;
    }
}