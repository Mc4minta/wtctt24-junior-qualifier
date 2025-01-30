package e.f.h.e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;

/* compiled from: FadeDrawable.java */
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: j  reason: collision with root package name */
    private final Drawable[] f12262j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f12263k;

    /* renamed from: l  reason: collision with root package name */
    private final int f12264l;
    int m;
    int n;
    long p;
    int[] q;
    int[] t;
    int u;
    boolean[] v;
    int w;

    public f(Drawable[] drawableArr) {
        this(drawableArr, false);
    }

    private void j(Canvas canvas, Drawable drawable, int i2) {
        if (drawable == null || i2 <= 0) {
            return;
        }
        this.w++;
        drawable.mutate().setAlpha(i2);
        this.w--;
        drawable.draw(canvas);
    }

    private void q() {
        this.m = 2;
        Arrays.fill(this.q, this.f12264l);
        this.q[0] = 255;
        Arrays.fill(this.t, this.f12264l);
        this.t[0] = 255;
        Arrays.fill(this.v, this.f12263k);
        this.v[0] = true;
    }

    private boolean s(float f2) {
        boolean z = true;
        for (int i2 = 0; i2 < this.f12262j.length; i2++) {
            boolean[] zArr = this.v;
            int i3 = zArr[i2] ? 1 : -1;
            int[] iArr = this.t;
            iArr[i2] = (int) (this.q[i2] + (i3 * 255 * f2));
            if (iArr[i2] < 0) {
                iArr[i2] = 0;
            }
            if (iArr[i2] > 255) {
                iArr[i2] = 255;
            }
            if (zArr[i2] && iArr[i2] < 255) {
                z = false;
            }
            if (!zArr[i2] && iArr[i2] > 0) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0053 A[LOOP:0: B:25:0x004e->B:27:0x0053, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0064 A[EDGE_INSN: B:31:0x0064->B:28:0x0064 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // e.f.h.e.a, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            int r0 = r8.m
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L2b
            if (r0 == r3) goto La
            goto L4e
        La:
            int r0 = r8.n
            if (r0 <= 0) goto L10
            r0 = r3
            goto L11
        L10:
            r0 = r2
        L11:
            e.f.d.c.i.i(r0)
            long r4 = r8.p()
            long r6 = r8.p
            long r4 = r4 - r6
            float r0 = (float) r4
            int r4 = r8.n
            float r4 = (float) r4
            float r0 = r0 / r4
            boolean r0 = r8.s(r0)
            if (r0 == 0) goto L27
            goto L28
        L27:
            r1 = r3
        L28:
            r8.m = r1
            goto L4d
        L2b:
            int[] r0 = r8.t
            int[] r4 = r8.q
            android.graphics.drawable.Drawable[] r5 = r8.f12262j
            int r5 = r5.length
            java.lang.System.arraycopy(r0, r2, r4, r2, r5)
            long r4 = r8.p()
            r8.p = r4
            int r0 = r8.n
            if (r0 != 0) goto L42
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L43
        L42:
            r0 = 0
        L43:
            boolean r0 = r8.s(r0)
            if (r0 == 0) goto L4a
            goto L4b
        L4a:
            r1 = r3
        L4b:
            r8.m = r1
        L4d:
            r3 = r0
        L4e:
            android.graphics.drawable.Drawable[] r0 = r8.f12262j
            int r1 = r0.length
            if (r2 >= r1) goto L64
            r0 = r0[r2]
            int[] r1 = r8.t
            r1 = r1[r2]
            int r4 = r8.u
            int r1 = r1 * r4
            int r1 = r1 / 255
            r8.j(r9, r0, r1)
            int r2 = r2 + 1
            goto L4e
        L64:
            if (r3 != 0) goto L69
            r8.invalidateSelf()
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.h.e.f.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.u;
    }

    public void i() {
        this.w++;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.w == 0) {
            super.invalidateSelf();
        }
    }

    public void k() {
        this.w--;
        invalidateSelf();
    }

    public void l() {
        this.m = 0;
        Arrays.fill(this.v, true);
        invalidateSelf();
    }

    public void m(int i2) {
        this.m = 0;
        this.v[i2] = true;
        invalidateSelf();
    }

    public void n(int i2) {
        this.m = 0;
        this.v[i2] = false;
        invalidateSelf();
    }

    public void o() {
        this.m = 2;
        for (int i2 = 0; i2 < this.f12262j.length; i2++) {
            this.t[i2] = this.v[i2] ? 255 : 0;
        }
        invalidateSelf();
    }

    protected long p() {
        return SystemClock.uptimeMillis();
    }

    public void r(int i2) {
        this.n = i2;
        if (this.m == 1) {
            this.m = 0;
        }
    }

    @Override // e.f.h.e.a, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.u != i2) {
            this.u = i2;
            invalidateSelf();
        }
    }

    public f(Drawable[] drawableArr, boolean z) {
        super(drawableArr);
        e.f.d.c.i.j(drawableArr.length >= 1, "At least one layer required!");
        this.f12262j = drawableArr;
        this.q = new int[drawableArr.length];
        this.t = new int[drawableArr.length];
        this.u = 255;
        this.v = new boolean[drawableArr.length];
        this.w = 0;
        this.f12263k = z;
        this.f12264l = z ? 255 : 0;
        q();
    }
}