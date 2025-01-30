package e.i.a;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: GestureHandlerOrchestrator.java */
/* loaded from: classes2.dex */
public class d {
    private static final PointF a = new PointF();

    /* renamed from: b  reason: collision with root package name */
    private static final float[] f13485b = new float[2];

    /* renamed from: c  reason: collision with root package name */
    private static final Matrix f13486c = new Matrix();

    /* renamed from: d  reason: collision with root package name */
    private static final float[] f13487d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator<b> f13488e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final ViewGroup f13489f;

    /* renamed from: g  reason: collision with root package name */
    private final e f13490g;

    /* renamed from: h  reason: collision with root package name */
    private final p f13491h;

    /* renamed from: i  reason: collision with root package name */
    private final b[] f13492i = new b[20];

    /* renamed from: j  reason: collision with root package name */
    private final b[] f13493j = new b[20];

    /* renamed from: k  reason: collision with root package name */
    private final b[] f13494k = new b[20];

    /* renamed from: l  reason: collision with root package name */
    private final b[] f13495l = new b[20];
    private int m = 0;
    private int n = 0;
    private boolean o = false;
    private int p = 0;
    private boolean q = false;
    private int r = 0;
    private float s = 0.0f;

    /* compiled from: GestureHandlerOrchestrator.java */
    /* loaded from: classes2.dex */
    static class a implements Comparator<b> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            boolean z;
            boolean z2 = bVar.z;
            if ((z2 && bVar2.z) || ((z = bVar.A) && bVar2.A)) {
                return Integer.signum(bVar2.y - bVar.y);
            }
            if (z2) {
                return -1;
            }
            if (bVar2.z) {
                return 1;
            }
            if (z) {
                return -1;
            }
            return bVar2.A ? 1 : 0;
        }
    }

    public d(ViewGroup viewGroup, e eVar, p pVar) {
        this.f13489f = viewGroup;
        this.f13490g = eVar;
        this.f13491h = pVar;
    }

    private static void A(float f2, float f3, ViewGroup viewGroup, View view, PointF pointF) {
        float scrollX = (f2 + viewGroup.getScrollX()) - view.getLeft();
        float scrollY = (f3 + viewGroup.getScrollY()) - view.getTop();
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            float[] fArr = f13485b;
            fArr[0] = scrollX;
            fArr[1] = scrollY;
            Matrix matrix2 = f13486c;
            matrix.invert(matrix2);
            matrix2.mapPoints(fArr);
            float f4 = fArr[0];
            scrollY = fArr[1];
            scrollX = f4;
        }
        pointF.set(scrollX, scrollY);
    }

    private boolean B(View view, float[] fArr, int i2) {
        l a2 = this.f13491h.a(view);
        if (a2 == l.NONE) {
            return false;
        }
        if (a2 == l.BOX_ONLY) {
            return u(view, fArr, i2) || z(view, fArr);
        } else if (a2 == l.BOX_NONE) {
            if (view instanceof ViewGroup) {
                return k((ViewGroup) view, fArr, i2);
            }
            return false;
        } else if (a2 == l.AUTO) {
            return u(view, fArr, i2) || (view instanceof ViewGroup ? k((ViewGroup) view, fArr, i2) : false) || z(view, fArr);
        } else {
            throw new IllegalArgumentException("Unknown pointer event type: " + a2.toString());
        }
    }

    private void C(b bVar) {
        if (l(bVar)) {
            a(bVar);
            return;
        }
        q(bVar);
        bVar.A = false;
    }

    private void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.n;
            if (i2 < i3) {
                if (this.f13493j[i2] == bVar) {
                    return;
                }
                i2++;
            } else {
                b[] bVarArr = this.f13493j;
                if (i3 < bVarArr.length) {
                    this.n = i3 + 1;
                    bVarArr[i3] = bVar;
                    bVar.A = true;
                    int i4 = this.r;
                    this.r = i4 + 1;
                    bVar.y = i4;
                    return;
                }
                throw new IllegalStateException("Too many recognizers");
            }
        }
    }

    private boolean b(View view) {
        return view.getVisibility() == 0 && view.getAlpha() >= this.s;
    }

    private static boolean c(b bVar, b bVar2) {
        return bVar == bVar2 || bVar.O(bVar2) || bVar2.O(bVar);
    }

    private void d() {
        for (int i2 = this.n - 1; i2 >= 0; i2--) {
            this.f13493j[i2].d();
        }
        int i3 = this.m;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f13494k[i4] = this.f13492i[i4];
        }
        for (int i5 = i3 - 1; i5 >= 0; i5--) {
            this.f13494k[i5].d();
        }
    }

    private void e() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.n; i3++) {
            b[] bVarArr = this.f13493j;
            if (bVarArr[i3].A) {
                bVarArr[i2] = bVarArr[i3];
                i2++;
            }
        }
        this.n = i2;
    }

    private void f() {
        boolean z = false;
        for (int i2 = this.m - 1; i2 >= 0; i2--) {
            b bVar = this.f13492i[i2];
            if (n(bVar.p()) && !bVar.A) {
                this.f13492i[i2] = null;
                bVar.G();
                bVar.z = false;
                bVar.A = false;
                bVar.y = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
                z = true;
            }
        }
        if (z) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.m; i4++) {
                b[] bVarArr = this.f13492i;
                if (bVarArr[i4] != null) {
                    bVarArr[i3] = bVarArr[i4];
                    i3++;
                }
            }
            this.m = i3;
        }
        this.q = false;
    }

    private void g(b bVar, MotionEvent motionEvent) {
        if (!p(bVar.r())) {
            bVar.d();
        } else if (bVar.T()) {
            int actionMasked = motionEvent.getActionMasked();
            if (bVar.A && actionMasked == 2) {
                return;
            }
            float[] fArr = f13487d;
            i(bVar.r(), motionEvent, fArr);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            motionEvent.setLocation(fArr[0], fArr[1]);
            bVar.s(motionEvent);
            if (bVar.z) {
                bVar.f(motionEvent);
            }
            motionEvent.setLocation(x, y);
            if (actionMasked == 1 || actionMasked == 6) {
                bVar.S(motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
    }

    private void i(View view, MotionEvent motionEvent, float[] fArr) {
        if (view == this.f13489f) {
            fArr[0] = motionEvent.getX();
            fArr[1] = motionEvent.getY();
        } else if (view != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            i(viewGroup, motionEvent, fArr);
            PointF pointF = a;
            A(fArr[0], fArr[1], viewGroup, view, pointF);
            fArr[0] = pointF.x;
            fArr[1] = pointF.y;
        } else {
            throw new IllegalArgumentException("Parent is null? View is no longer in the tree");
        }
    }

    private void j(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float[] fArr = f13487d;
        fArr[0] = motionEvent.getX(actionIndex);
        fArr[1] = motionEvent.getY(actionIndex);
        B(this.f13489f, fArr, pointerId);
        k(this.f13489f, fArr, pointerId);
    }

    private boolean k(ViewGroup viewGroup, float[] fArr, int i2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View c2 = this.f13491h.c(viewGroup, childCount);
            if (b(c2)) {
                PointF pointF = a;
                A(fArr[0], fArr[1], viewGroup, c2, pointF);
                float f2 = fArr[0];
                float f3 = fArr[1];
                fArr[0] = pointF.x;
                fArr[1] = pointF.y;
                boolean B = (!m(c2) || o(fArr[0], fArr[1], c2)) ? B(c2, fArr, i2) : false;
                fArr[0] = f2;
                fArr[1] = f3;
                if (B) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean l(b bVar) {
        for (int i2 = 0; i2 < this.m; i2++) {
            b bVar2 = this.f13492i[i2];
            if (!n(bVar2.p()) && y(bVar, bVar2)) {
                return true;
            }
        }
        return false;
    }

    private boolean m(View view) {
        return !(view instanceof ViewGroup) || this.f13491h.b((ViewGroup) view);
    }

    private static boolean n(int i2) {
        return i2 == 3 || i2 == 1 || i2 == 5;
    }

    private static boolean o(float f2, float f3, View view) {
        return f2 >= 0.0f && f2 <= ((float) view.getWidth()) && f3 >= 0.0f && f3 < ((float) view.getHeight());
    }

    private boolean p(View view) {
        if (view == null) {
            return false;
        }
        if (view == this.f13489f) {
            return true;
        }
        ViewParent parent = view.getParent();
        while (parent != null && parent != this.f13489f) {
            parent = parent.getParent();
        }
        return parent == this.f13489f;
    }

    private void q(b bVar) {
        int p = bVar.p();
        bVar.A = false;
        bVar.z = true;
        int i2 = this.r;
        this.r = i2 + 1;
        bVar.y = i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.m; i4++) {
            b bVar2 = this.f13492i[i4];
            if (x(bVar2, bVar)) {
                this.f13495l[i3] = bVar2;
                i3++;
            }
        }
        for (int i5 = i3 - 1; i5 >= 0; i5--) {
            this.f13495l[i5].d();
        }
        for (int i6 = this.n - 1; i6 >= 0; i6--) {
            b bVar3 = this.f13493j[i6];
            if (x(bVar3, bVar)) {
                bVar3.d();
                bVar3.A = false;
            }
        }
        e();
        bVar.e(4, 2);
        if (p != 4) {
            bVar.e(5, 4);
            if (p != 5) {
                bVar.e(0, 5);
            }
        }
    }

    private void t(b bVar, View view) {
        int i2 = 0;
        while (true) {
            int i3 = this.m;
            if (i2 < i3) {
                if (this.f13492i[i2] == bVar) {
                    return;
                }
                i2++;
            } else {
                b[] bVarArr = this.f13492i;
                if (i3 < bVarArr.length) {
                    this.m = i3 + 1;
                    bVarArr[i3] = bVar;
                    bVar.z = false;
                    bVar.A = false;
                    bVar.y = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
                    bVar.F(view, this);
                    return;
                }
                throw new IllegalStateException("Too many recognizers");
            }
        }
    }

    private boolean u(View view, float[] fArr, int i2) {
        ArrayList<b> a2 = this.f13490g.a(view);
        if (a2 != null) {
            int size = a2.size();
            boolean z = false;
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = a2.get(i3);
                if (bVar.w() && bVar.y(view, fArr[0], fArr[1])) {
                    t(bVar, view);
                    bVar.R(i2);
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    private void v() {
        if (!this.o && this.p == 0) {
            f();
        } else {
            this.q = true;
        }
    }

    private static boolean x(b bVar, b bVar2) {
        if (bVar.t(bVar2) && !c(bVar, bVar2)) {
            if (bVar != bVar2) {
                if (bVar.A || bVar.p() == 4) {
                    return bVar.N(bVar2);
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private static boolean y(b bVar, b bVar2) {
        return bVar != bVar2 && (bVar.Q(bVar2) || bVar2.P(bVar));
    }

    private static boolean z(View view, float[] fArr) {
        return (!(view instanceof ViewGroup) || view.getBackground() != null) && o(fArr[0], fArr[1], view);
    }

    public void h(MotionEvent motionEvent) {
        int i2 = this.m;
        System.arraycopy(this.f13492i, 0, this.f13494k, 0, i2);
        Arrays.sort(this.f13494k, 0, i2, f13488e);
        for (int i3 = 0; i3 < i2; i3++) {
            g(this.f13494k[i3], motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(b bVar, int i2, int i3) {
        this.p++;
        if (n(i2)) {
            for (int i4 = 0; i4 < this.n; i4++) {
                b bVar2 = this.f13493j[i4];
                if (y(bVar2, bVar)) {
                    if (i2 == 5) {
                        bVar2.d();
                        bVar2.A = false;
                    } else {
                        C(bVar2);
                    }
                }
            }
            e();
        }
        if (i2 == 4) {
            C(bVar);
        } else if (i3 != 4 && i3 != 5) {
            bVar.e(i2, i3);
        } else if (bVar.z) {
            bVar.e(i2, i3);
        }
        this.p--;
        v();
    }

    public boolean s(MotionEvent motionEvent) {
        this.o = true;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            j(motionEvent);
        } else if (actionMasked == 3) {
            d();
        }
        h(motionEvent);
        this.o = false;
        if (this.q && this.p == 0) {
            f();
        }
        return true;
    }

    public void w(float f2) {
        this.s = f2;
    }
}