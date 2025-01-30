package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import c.h.k.g;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlexboxHelper.java */
/* loaded from: classes2.dex */
public class d {
    private final com.google.android.flexbox.a a;

    /* renamed from: b  reason: collision with root package name */
    private boolean[] f5927b;

    /* renamed from: c  reason: collision with root package name */
    int[] f5928c;

    /* renamed from: d  reason: collision with root package name */
    long[] f5929d;

    /* renamed from: e  reason: collision with root package name */
    private long[] f5930e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlexboxHelper.java */
    /* loaded from: classes2.dex */
    public static class b {
        List<com.google.android.flexbox.c> a;

        /* renamed from: b  reason: collision with root package name */
        int f5931b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            this.a = null;
            this.f5931b = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FlexboxHelper.java */
    /* loaded from: classes2.dex */
    public static class c implements Comparable<c> {
        int a;

        /* renamed from: b  reason: collision with root package name */
        int f5932b;

        private c() {
        }

        @Override // java.lang.Comparable
        /* renamed from: h */
        public int compareTo(c cVar) {
            int i2 = this.f5932b;
            int i3 = cVar.f5932b;
            return i2 != i3 ? i2 - i3 : this.a - cVar.a;
        }

        public String toString() {
            return "Order{order=" + this.f5932b + ", index=" + this.a + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.google.android.flexbox.a aVar) {
        this.a = aVar;
    }

    private int A(int i2, com.google.android.flexbox.b bVar, int i3) {
        com.google.android.flexbox.a aVar = this.a;
        int e2 = aVar.e(i2, aVar.getPaddingLeft() + this.a.getPaddingRight() + bVar.g0() + bVar.I0() + i3, bVar.getWidth());
        int size = View.MeasureSpec.getSize(e2);
        if (size > bVar.f1()) {
            return View.MeasureSpec.makeMeasureSpec(bVar.f1(), View.MeasureSpec.getMode(e2));
        }
        return size < bVar.V() ? View.MeasureSpec.makeMeasureSpec(bVar.V(), View.MeasureSpec.getMode(e2)) : e2;
    }

    private int B(com.google.android.flexbox.b bVar, boolean z) {
        if (z) {
            return bVar.d0();
        }
        return bVar.I0();
    }

    private int C(com.google.android.flexbox.b bVar, boolean z) {
        if (z) {
            return bVar.I0();
        }
        return bVar.d0();
    }

    private int D(com.google.android.flexbox.b bVar, boolean z) {
        if (z) {
            return bVar.o0();
        }
        return bVar.g0();
    }

    private int E(com.google.android.flexbox.b bVar, boolean z) {
        if (z) {
            return bVar.g0();
        }
        return bVar.o0();
    }

    private int F(com.google.android.flexbox.b bVar, boolean z) {
        if (z) {
            return bVar.getHeight();
        }
        return bVar.getWidth();
    }

    private int G(com.google.android.flexbox.b bVar, boolean z) {
        if (z) {
            return bVar.getWidth();
        }
        return bVar.getHeight();
    }

    private int H(boolean z) {
        if (z) {
            return this.a.getPaddingBottom();
        }
        return this.a.getPaddingEnd();
    }

    private int I(boolean z) {
        if (z) {
            return this.a.getPaddingEnd();
        }
        return this.a.getPaddingBottom();
    }

    private int J(boolean z) {
        if (z) {
            return this.a.getPaddingTop();
        }
        return this.a.getPaddingStart();
    }

    private int K(boolean z) {
        if (z) {
            return this.a.getPaddingStart();
        }
        return this.a.getPaddingTop();
    }

    private int L(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int M(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private boolean N(int i2, int i3, com.google.android.flexbox.c cVar) {
        return i2 == i3 - 1 && cVar.c() != 0;
    }

    private boolean P(View view, int i2, int i3, int i4, int i5, com.google.android.flexbox.b bVar, int i6, int i7, int i8) {
        if (this.a.getFlexWrap() == 0) {
            return false;
        }
        if (bVar.O0()) {
            return true;
        }
        if (i2 == 0) {
            return false;
        }
        int maxLine = this.a.getMaxLine();
        if (maxLine == -1 || maxLine > i8 + 1) {
            int h2 = this.a.h(view, i6, i7);
            if (h2 > 0) {
                i5 += h2;
            }
            return i3 < i4 + i5;
        }
        return false;
    }

    private void T(int i2, int i3, com.google.android.flexbox.c cVar, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int i8;
        int i9 = cVar.f5919e;
        float f2 = cVar.f5925k;
        float f3 = 0.0f;
        if (f2 <= 0.0f || i4 > i9) {
            return;
        }
        float f4 = (i9 - i4) / f2;
        cVar.f5919e = i5 + cVar.f5920f;
        if (!z) {
            cVar.f5921g = Integer.MIN_VALUE;
        }
        int i10 = 0;
        boolean z2 = false;
        int i11 = 0;
        float f5 = 0.0f;
        while (i10 < cVar.f5922h) {
            int i12 = cVar.o + i10;
            View d2 = this.a.d(i12);
            if (d2 == null || d2.getVisibility() == 8) {
                i6 = i9;
                i7 = i10;
            } else {
                com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) d2.getLayoutParams();
                int flexDirection = this.a.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = d2.getMeasuredHeight();
                    long[] jArr = this.f5930e;
                    if (jArr != null) {
                        measuredHeight = x(jArr[i12]);
                    }
                    int measuredWidth = d2.getMeasuredWidth();
                    long[] jArr2 = this.f5930e;
                    if (jArr2 != null) {
                        measuredWidth = y(jArr2[i12]);
                    }
                    if (this.f5927b[i12] || bVar.O() <= f3) {
                        i6 = i9;
                        i7 = i10;
                    } else {
                        float O = measuredHeight - (bVar.O() * f4);
                        if (i10 == cVar.f5922h - 1) {
                            O += f5;
                            f5 = f3;
                        }
                        int round = Math.round(O);
                        if (round < bVar.M0()) {
                            round = bVar.M0();
                            this.f5927b[i12] = true;
                            cVar.f5925k -= bVar.O();
                            i6 = i9;
                            i7 = i10;
                            z2 = true;
                        } else {
                            f5 += O - round;
                            i6 = i9;
                            i7 = i10;
                            double d3 = f5;
                            if (d3 > 1.0d) {
                                round++;
                                f5 -= 1.0f;
                            } else if (d3 < -1.0d) {
                                round--;
                                f5 += 1.0f;
                            }
                        }
                        int A = A(i2, bVar, cVar.m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        d2.measure(A, makeMeasureSpec);
                        measuredWidth = d2.getMeasuredWidth();
                        int measuredHeight2 = d2.getMeasuredHeight();
                        Z(i12, A, makeMeasureSpec, d2);
                        this.a.f(i12, d2);
                        measuredHeight = measuredHeight2;
                    }
                    i8 = Math.max(i11, measuredWidth + bVar.g0() + bVar.I0() + this.a.k(d2));
                    cVar.f5919e += measuredHeight + bVar.o0() + bVar.d0();
                } else {
                    i6 = i9;
                    int i13 = i10;
                    int measuredWidth2 = d2.getMeasuredWidth();
                    long[] jArr3 = this.f5930e;
                    if (jArr3 != null) {
                        measuredWidth2 = y(jArr3[i12]);
                    }
                    int measuredHeight3 = d2.getMeasuredHeight();
                    long[] jArr4 = this.f5930e;
                    if (jArr4 != null) {
                        measuredHeight3 = x(jArr4[i12]);
                    }
                    if (this.f5927b[i12] || bVar.O() <= 0.0f) {
                        i7 = i13;
                    } else {
                        float O2 = measuredWidth2 - (bVar.O() * f4);
                        i7 = i13;
                        if (i7 == cVar.f5922h - 1) {
                            O2 += f5;
                            f5 = 0.0f;
                        }
                        int round2 = Math.round(O2);
                        if (round2 < bVar.V()) {
                            round2 = bVar.V();
                            this.f5927b[i12] = true;
                            cVar.f5925k -= bVar.O();
                            z2 = true;
                        } else {
                            f5 += O2 - round2;
                            double d4 = f5;
                            if (d4 > 1.0d) {
                                round2++;
                                f5 -= 1.0f;
                            } else if (d4 < -1.0d) {
                                round2--;
                                f5 += 1.0f;
                            }
                        }
                        int z3 = z(i3, bVar, cVar.m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        d2.measure(makeMeasureSpec2, z3);
                        int measuredWidth3 = d2.getMeasuredWidth();
                        int measuredHeight4 = d2.getMeasuredHeight();
                        Z(i12, makeMeasureSpec2, z3, d2);
                        this.a.f(i12, d2);
                        measuredWidth2 = measuredWidth3;
                        measuredHeight3 = measuredHeight4;
                    }
                    int max = Math.max(i11, measuredHeight3 + bVar.o0() + bVar.d0() + this.a.k(d2));
                    cVar.f5919e += measuredWidth2 + bVar.g0() + bVar.I0();
                    i8 = max;
                }
                cVar.f5921g = Math.max(cVar.f5921g, i8);
                i11 = i8;
            }
            i10 = i7 + 1;
            i9 = i6;
            f3 = 0.0f;
        }
        int i14 = i9;
        if (!z2 || i14 == cVar.f5919e) {
            return;
        }
        T(i2, i3, cVar, i4, i5, true);
    }

    private int[] U(int i2, List<c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i2];
        int i3 = 0;
        for (c cVar : list) {
            int i4 = cVar.a;
            iArr[i3] = i4;
            sparseIntArray.append(i4, cVar.f5932b);
            i3++;
        }
        return iArr;
    }

    private void V(View view, int i2, int i3) {
        int measuredHeight;
        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) view.getLayoutParams();
        int min = Math.min(Math.max(((i2 - bVar.g0()) - bVar.I0()) - this.a.k(view), bVar.V()), bVar.f1());
        long[] jArr = this.f5930e;
        if (jArr != null) {
            measuredHeight = x(jArr[i3]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        Z(i3, makeMeasureSpec2, makeMeasureSpec, view);
        this.a.f(i3, view);
    }

    private void W(View view, int i2, int i3) {
        int measuredWidth;
        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) view.getLayoutParams();
        int min = Math.min(Math.max(((i2 - bVar.o0()) - bVar.d0()) - this.a.k(view), bVar.M0()), bVar.W0());
        long[] jArr = this.f5930e;
        if (jArr != null) {
            measuredWidth = y(jArr[i3]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        Z(i3, makeMeasureSpec, makeMeasureSpec2, view);
        this.a.f(i3, view);
    }

    private void Z(int i2, int i3, int i4, View view) {
        long[] jArr = this.f5929d;
        if (jArr != null) {
            jArr[i2] = S(i3, i4);
        }
        long[] jArr2 = this.f5930e;
        if (jArr2 != null) {
            jArr2[i2] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void a(List<com.google.android.flexbox.c> list, com.google.android.flexbox.c cVar, int i2, int i3) {
        cVar.m = i3;
        this.a.c(cVar);
        cVar.p = i2;
        list.add(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.b r0 = (com.google.android.flexbox.b) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.V()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.V()
        L19:
            r3 = r4
            goto L27
        L1b:
            int r3 = r0.f1()
            if (r1 <= r3) goto L26
            int r1 = r0.f1()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.M0()
            if (r2 >= r5) goto L32
            int r2 = r0.M0()
            goto L3e
        L32:
            int r5 = r0.W0()
            if (r2 <= r5) goto L3d
            int r2 = r0.W0()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.Z(r8, r1, r0, r7)
            com.google.android.flexbox.a r0 = r6.a
            r0.f(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.d.i(android.view.View, int):void");
    }

    private List<com.google.android.flexbox.c> k(List<com.google.android.flexbox.c> list, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        com.google.android.flexbox.c cVar = new com.google.android.flexbox.c();
        cVar.f5921g = (i2 - i3) / 2;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(cVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    private List<c> l(int i2) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            c cVar = new c();
            cVar.f5932b = ((com.google.android.flexbox.b) this.a.g(i3).getLayoutParams()).getOrder();
            cVar.a = i3;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private void r(int i2) {
        boolean[] zArr = this.f5927b;
        if (zArr == null) {
            this.f5927b = new boolean[Math.max(i2, 10)];
        } else if (zArr.length < i2) {
            this.f5927b = new boolean[Math.max(zArr.length * 2, i2)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void v(CompoundButton compoundButton) {
        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) compoundButton.getLayoutParams();
        int V = bVar.V();
        int M0 = bVar.M0();
        Drawable a2 = androidx.core.widget.c.a(compoundButton);
        int minimumWidth = a2 == null ? 0 : a2.getMinimumWidth();
        int minimumHeight = a2 != null ? a2.getMinimumHeight() : 0;
        if (V == -1) {
            V = minimumWidth;
        }
        bVar.a0(V);
        if (M0 == -1) {
            M0 = minimumHeight;
        }
        bVar.s0(M0);
    }

    private void w(int i2, int i3, com.google.android.flexbox.c cVar, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int i8;
        double d2;
        int i9;
        double d3;
        float f2 = cVar.f5924j;
        float f3 = 0.0f;
        if (f2 <= 0.0f || i4 < (i6 = cVar.f5919e)) {
            return;
        }
        float f4 = (i4 - i6) / f2;
        cVar.f5919e = i5 + cVar.f5920f;
        if (!z) {
            cVar.f5921g = Integer.MIN_VALUE;
        }
        int i10 = 0;
        boolean z2 = false;
        int i11 = 0;
        float f5 = 0.0f;
        while (i10 < cVar.f5922h) {
            int i12 = cVar.o + i10;
            View d4 = this.a.d(i12);
            if (d4 == null || d4.getVisibility() == 8) {
                i7 = i6;
            } else {
                com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) d4.getLayoutParams();
                int flexDirection = this.a.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = d4.getMeasuredHeight();
                    long[] jArr = this.f5930e;
                    if (jArr != null) {
                        measuredHeight = x(jArr[i12]);
                    }
                    int measuredWidth = d4.getMeasuredWidth();
                    long[] jArr2 = this.f5930e;
                    if (jArr2 != null) {
                        measuredWidth = y(jArr2[i12]);
                    }
                    if (this.f5927b[i12] || bVar.w0() <= f3) {
                        i9 = i6;
                    } else {
                        float w0 = measuredHeight + (bVar.w0() * f4);
                        if (i10 == cVar.f5922h - 1) {
                            w0 += f5;
                            f5 = f3;
                        }
                        int round = Math.round(w0);
                        if (round > bVar.W0()) {
                            round = bVar.W0();
                            this.f5927b[i12] = true;
                            cVar.f5924j -= bVar.w0();
                            i9 = i6;
                            z2 = true;
                        } else {
                            f5 += w0 - round;
                            i9 = i6;
                            double d5 = f5;
                            if (d5 > 1.0d) {
                                round++;
                                d3 = d5 - 1.0d;
                            } else if (d5 < -1.0d) {
                                round--;
                                d3 = d5 + 1.0d;
                            }
                            f5 = (float) d3;
                        }
                        int A = A(i2, bVar, cVar.m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        d4.measure(A, makeMeasureSpec);
                        measuredWidth = d4.getMeasuredWidth();
                        int measuredHeight2 = d4.getMeasuredHeight();
                        Z(i12, A, makeMeasureSpec, d4);
                        this.a.f(i12, d4);
                        measuredHeight = measuredHeight2;
                    }
                    i8 = Math.max(i11, measuredWidth + bVar.g0() + bVar.I0() + this.a.k(d4));
                    cVar.f5919e += measuredHeight + bVar.o0() + bVar.d0();
                    i7 = i9;
                } else {
                    int i13 = i6;
                    int measuredWidth2 = d4.getMeasuredWidth();
                    long[] jArr3 = this.f5930e;
                    if (jArr3 != null) {
                        measuredWidth2 = y(jArr3[i12]);
                    }
                    int measuredHeight3 = d4.getMeasuredHeight();
                    long[] jArr4 = this.f5930e;
                    i7 = i13;
                    if (jArr4 != null) {
                        measuredHeight3 = x(jArr4[i12]);
                    }
                    if (!this.f5927b[i12] && bVar.w0() > 0.0f) {
                        float w02 = measuredWidth2 + (bVar.w0() * f4);
                        if (i10 == cVar.f5922h - 1) {
                            w02 += f5;
                            f5 = 0.0f;
                        }
                        int round2 = Math.round(w02);
                        if (round2 > bVar.f1()) {
                            round2 = bVar.f1();
                            this.f5927b[i12] = true;
                            cVar.f5924j -= bVar.w0();
                            z2 = true;
                        } else {
                            f5 += w02 - round2;
                            double d6 = f5;
                            if (d6 > 1.0d) {
                                round2++;
                                d2 = d6 - 1.0d;
                            } else if (d6 < -1.0d) {
                                round2--;
                                d2 = d6 + 1.0d;
                            }
                            f5 = (float) d2;
                        }
                        int z3 = z(i3, bVar, cVar.m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        d4.measure(makeMeasureSpec2, z3);
                        int measuredWidth3 = d4.getMeasuredWidth();
                        int measuredHeight4 = d4.getMeasuredHeight();
                        Z(i12, makeMeasureSpec2, z3, d4);
                        this.a.f(i12, d4);
                        measuredWidth2 = measuredWidth3;
                        measuredHeight3 = measuredHeight4;
                    }
                    int max = Math.max(i11, measuredHeight3 + bVar.o0() + bVar.d0() + this.a.k(d4));
                    cVar.f5919e += measuredWidth2 + bVar.g0() + bVar.I0();
                    i8 = max;
                }
                cVar.f5921g = Math.max(cVar.f5921g, i8);
                i11 = i8;
            }
            i10++;
            i6 = i7;
            f3 = 0.0f;
        }
        int i14 = i6;
        if (!z2 || i14 == cVar.f5919e) {
            return;
        }
        w(i2, i3, cVar, i4, i5, true);
    }

    private int z(int i2, com.google.android.flexbox.b bVar, int i3) {
        com.google.android.flexbox.a aVar = this.a;
        int i4 = aVar.i(i2, aVar.getPaddingTop() + this.a.getPaddingBottom() + bVar.o0() + bVar.d0() + i3, bVar.getHeight());
        int size = View.MeasureSpec.getSize(i4);
        if (size > bVar.W0()) {
            return View.MeasureSpec.makeMeasureSpec(bVar.W0(), View.MeasureSpec.getMode(i4));
        }
        return size < bVar.M0() ? View.MeasureSpec.makeMeasureSpec(bVar.M0(), View.MeasureSpec.getMode(i4)) : i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i2 = 0; i2 < flexItemCount; i2++) {
            View g2 = this.a.g(i2);
            if (g2 != null && ((com.google.android.flexbox.b) g2.getLayoutParams()).getOrder() != sparseIntArray.get(i2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(View view, com.google.android.flexbox.c cVar, int i2, int i3, int i4, int i5) {
        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (bVar.z() != -1) {
            alignItems = bVar.z();
        }
        int i6 = cVar.f5921g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.a.getFlexWrap() != 2) {
                    int i7 = i3 + i6;
                    view.layout(i2, (i7 - view.getMeasuredHeight()) - bVar.d0(), i4, i7 - bVar.d0());
                    return;
                }
                view.layout(i2, (i3 - i6) + view.getMeasuredHeight() + bVar.o0(), i4, (i5 - i6) + view.getMeasuredHeight() + bVar.o0());
                return;
            } else if (alignItems == 2) {
                int measuredHeight = (((i6 - view.getMeasuredHeight()) + bVar.o0()) - bVar.d0()) / 2;
                if (this.a.getFlexWrap() != 2) {
                    int i8 = i3 + measuredHeight;
                    view.layout(i2, i8, i4, view.getMeasuredHeight() + i8);
                    return;
                }
                int i9 = i3 - measuredHeight;
                view.layout(i2, i9, i4, view.getMeasuredHeight() + i9);
                return;
            } else if (alignItems == 3) {
                if (this.a.getFlexWrap() != 2) {
                    int max = Math.max(cVar.f5926l - view.getBaseline(), bVar.o0());
                    view.layout(i2, i3 + max, i4, i5 + max);
                    return;
                }
                int max2 = Math.max((cVar.f5926l - view.getMeasuredHeight()) + view.getBaseline(), bVar.d0());
                view.layout(i2, i3 - max2, i4, i5 - max2);
                return;
            } else if (alignItems != 4) {
                return;
            }
        }
        if (this.a.getFlexWrap() != 2) {
            view.layout(i2, i3 + bVar.o0(), i4, i5 + bVar.o0());
        } else {
            view.layout(i2, i3 - bVar.d0(), i4, i5 - bVar.d0());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(View view, com.google.android.flexbox.c cVar, boolean z, int i2, int i3, int i4, int i5) {
        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (bVar.z() != -1) {
            alignItems = bVar.z();
        }
        int i6 = cVar.f5921g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i2 + i6) - view.getMeasuredWidth()) - bVar.I0(), i3, ((i4 + i6) - view.getMeasuredWidth()) - bVar.I0(), i5);
                    return;
                } else {
                    view.layout((i2 - i6) + view.getMeasuredWidth() + bVar.g0(), i3, (i4 - i6) + view.getMeasuredWidth() + bVar.g0(), i5);
                    return;
                }
            } else if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i6 - view.getMeasuredWidth()) + g.b(marginLayoutParams)) - g.a(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i2 + measuredWidth, i3, i4 + measuredWidth, i5);
                    return;
                } else {
                    view.layout(i2 - measuredWidth, i3, i4 - measuredWidth, i5);
                    return;
                }
            } else if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z) {
            view.layout(i2 + bVar.g0(), i3, i4 + bVar.g0(), i5);
        } else {
            view.layout(i2 - bVar.I0(), i3, i4 - bVar.I0(), i5);
        }
    }

    long S(int i2, int i3) {
        return (i2 & 4294967295L) | (i3 << 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X() {
        Y(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(int i2) {
        View d2;
        if (i2 >= this.a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.a.getFlexDirection();
        if (this.a.getAlignItems() == 4) {
            int[] iArr = this.f5928c;
            List<com.google.android.flexbox.c> flexLinesInternal = this.a.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i3 = iArr != null ? iArr[i2] : 0; i3 < size; i3++) {
                com.google.android.flexbox.c cVar = flexLinesInternal.get(i3);
                int i4 = cVar.f5922h;
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = cVar.o + i5;
                    if (i5 < this.a.getFlexItemCount() && (d2 = this.a.d(i6)) != null && d2.getVisibility() != 8) {
                        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) d2.getLayoutParams();
                        if (bVar.z() == -1 || bVar.z() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                W(d2, cVar.f5921g, i6);
                            } else if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            } else {
                                V(d2, cVar.f5921g, i6);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (com.google.android.flexbox.c cVar2 : this.a.getFlexLinesInternal()) {
            for (Integer num : cVar2.n) {
                View d3 = this.a.d(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    W(d3, cVar2.f5921g, num.intValue());
                } else if (flexDirection != 2 && flexDirection != 3) {
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                } else {
                    V(d3, cVar2.f5921g, num.intValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(b bVar, int i2, int i3, int i4, int i5, int i6, List<com.google.android.flexbox.c> list) {
        int i7;
        b bVar2;
        int i8;
        int i9;
        int i10;
        List<com.google.android.flexbox.c> list2;
        int i11;
        View view;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i2;
        int i19 = i3;
        int i20 = i6;
        boolean j2 = this.a.j();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        ArrayList arrayList = list == null ? new ArrayList() : list;
        bVar.a = arrayList;
        boolean z = i20 == -1;
        int K = K(j2);
        int I = I(j2);
        int J = J(j2);
        int H = H(j2);
        com.google.android.flexbox.c cVar = new com.google.android.flexbox.c();
        int i21 = i5;
        cVar.o = i21;
        int i22 = I + K;
        cVar.f5919e = i22;
        int flexItemCount = this.a.getFlexItemCount();
        boolean z2 = z;
        int i23 = Integer.MIN_VALUE;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        while (true) {
            if (i21 >= flexItemCount) {
                i7 = i25;
                bVar2 = bVar;
                break;
            }
            View d2 = this.a.d(i21);
            if (d2 == null) {
                if (N(i21, flexItemCount, cVar)) {
                    a(arrayList, cVar, i21, i24);
                }
            } else if (d2.getVisibility() == 8) {
                cVar.f5923i++;
                cVar.f5922h++;
                if (N(i21, flexItemCount, cVar)) {
                    a(arrayList, cVar, i21, i24);
                }
            } else {
                if (d2 instanceof CompoundButton) {
                    v((CompoundButton) d2);
                }
                com.google.android.flexbox.b bVar3 = (com.google.android.flexbox.b) d2.getLayoutParams();
                int i27 = flexItemCount;
                if (bVar3.z() == 4) {
                    cVar.n.add(Integer.valueOf(i21));
                }
                int G = G(bVar3, j2);
                if (bVar3.z0() != -1.0f && mode == 1073741824) {
                    G = Math.round(size * bVar3.z0());
                }
                if (j2) {
                    int e2 = this.a.e(i18, i22 + E(bVar3, true) + C(bVar3, true), G);
                    i8 = size;
                    i9 = mode;
                    int i28 = this.a.i(i19, J + H + D(bVar3, true) + B(bVar3, true) + i24, F(bVar3, true));
                    d2.measure(e2, i28);
                    Z(i21, e2, i28, d2);
                    i10 = e2;
                } else {
                    i8 = size;
                    i9 = mode;
                    int e3 = this.a.e(i19, J + H + D(bVar3, false) + B(bVar3, false) + i24, F(bVar3, false));
                    int i29 = this.a.i(i18, E(bVar3, false) + i22 + C(bVar3, false), G);
                    d2.measure(e3, i29);
                    Z(i21, e3, i29, d2);
                    i10 = i29;
                }
                this.a.f(i21, d2);
                i(d2, i21);
                i25 = View.combineMeasuredStates(i25, d2.getMeasuredState());
                int i30 = i24;
                int i31 = i22;
                com.google.android.flexbox.c cVar2 = cVar;
                int i32 = i21;
                list2 = arrayList;
                int i33 = i10;
                if (P(d2, i9, i8, cVar.f5919e, C(bVar3, j2) + M(d2, j2) + E(bVar3, j2), bVar3, i32, i26, arrayList.size())) {
                    if (cVar2.c() > 0) {
                        a(list2, cVar2, i32 > 0 ? i32 - 1 : 0, i30);
                        i24 = cVar2.f5921g + i30;
                    } else {
                        i24 = i30;
                    }
                    if (j2) {
                        if (bVar3.getHeight() == -1) {
                            com.google.android.flexbox.a aVar = this.a;
                            i11 = i3;
                            i21 = i32;
                            view = d2;
                            view.measure(i33, aVar.i(i11, aVar.getPaddingTop() + this.a.getPaddingBottom() + bVar3.o0() + bVar3.d0() + i24, bVar3.getHeight()));
                            i(view, i21);
                        } else {
                            i11 = i3;
                            view = d2;
                            i21 = i32;
                        }
                    } else {
                        i11 = i3;
                        view = d2;
                        i21 = i32;
                        if (bVar3.getWidth() == -1) {
                            com.google.android.flexbox.a aVar2 = this.a;
                            view.measure(aVar2.e(i11, aVar2.getPaddingLeft() + this.a.getPaddingRight() + bVar3.g0() + bVar3.I0() + i24, bVar3.getWidth()), i33);
                            i(view, i21);
                        }
                    }
                    cVar = new com.google.android.flexbox.c();
                    cVar.f5922h = 1;
                    i12 = i31;
                    cVar.f5919e = i12;
                    cVar.o = i21;
                    i14 = Integer.MIN_VALUE;
                    i13 = 0;
                } else {
                    i11 = i3;
                    view = d2;
                    i21 = i32;
                    cVar = cVar2;
                    i12 = i31;
                    cVar.f5922h++;
                    i13 = i26 + 1;
                    i24 = i30;
                    i14 = i23;
                }
                cVar.q |= bVar3.w0() != 0.0f;
                cVar.r |= bVar3.O() != 0.0f;
                int[] iArr = this.f5928c;
                if (iArr != null) {
                    iArr[i21] = list2.size();
                }
                cVar.f5919e += M(view, j2) + E(bVar3, j2) + C(bVar3, j2);
                cVar.f5924j += bVar3.w0();
                cVar.f5925k += bVar3.O();
                this.a.b(view, i21, i13, cVar);
                int max = Math.max(i14, L(view, j2) + D(bVar3, j2) + B(bVar3, j2) + this.a.k(view));
                cVar.f5921g = Math.max(cVar.f5921g, max);
                if (j2) {
                    if (this.a.getFlexWrap() != 2) {
                        cVar.f5926l = Math.max(cVar.f5926l, view.getBaseline() + bVar3.o0());
                    } else {
                        cVar.f5926l = Math.max(cVar.f5926l, (view.getMeasuredHeight() - view.getBaseline()) + bVar3.d0());
                    }
                }
                i15 = i27;
                if (N(i21, i15, cVar)) {
                    a(list2, cVar, i21, i24);
                    i24 += cVar.f5921g;
                }
                i16 = i6;
                if (i16 != -1 && list2.size() > 0) {
                    if (list2.get(list2.size() - 1).p >= i16 && i21 >= i16 && !z2) {
                        i24 = -cVar.a();
                        i17 = i4;
                        z2 = true;
                        if (i24 <= i17 && z2) {
                            bVar2 = bVar;
                            i7 = i25;
                            break;
                        }
                        i26 = i13;
                        i23 = max;
                        i21++;
                        i18 = i2;
                        flexItemCount = i15;
                        i19 = i11;
                        i22 = i12;
                        arrayList = list2;
                        mode = i9;
                        i20 = i16;
                        size = i8;
                    }
                }
                i17 = i4;
                if (i24 <= i17) {
                }
                i26 = i13;
                i23 = max;
                i21++;
                i18 = i2;
                flexItemCount = i15;
                i19 = i11;
                i22 = i12;
                arrayList = list2;
                mode = i9;
                i20 = i16;
                size = i8;
            }
            i8 = size;
            i9 = mode;
            i11 = i19;
            i16 = i20;
            list2 = arrayList;
            i12 = i22;
            i15 = flexItemCount;
            i21++;
            i18 = i2;
            flexItemCount = i15;
            i19 = i11;
            i22 = i12;
            arrayList = list2;
            mode = i9;
            i20 = i16;
            size = i8;
        }
        bVar2.f5931b = i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(b bVar, int i2, int i3) {
        b(bVar, i2, i3, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(b bVar, int i2, int i3, int i4, int i5, List<com.google.android.flexbox.c> list) {
        b(bVar, i2, i3, i4, i5, -1, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(b bVar, int i2, int i3, int i4, int i5, List<com.google.android.flexbox.c> list) {
        b(bVar, i2, i3, i4, 0, i5, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(b bVar, int i2, int i3) {
        b(bVar, i3, i2, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(b bVar, int i2, int i3, int i4, int i5, List<com.google.android.flexbox.c> list) {
        b(bVar, i3, i2, i4, i5, -1, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(b bVar, int i2, int i3, int i4, int i5, List<com.google.android.flexbox.c> list) {
        b(bVar, i3, i2, i4, 0, i5, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(List<com.google.android.flexbox.c> list, int i2) {
        int i3 = this.f5928c[i2];
        if (i3 == -1) {
            i3 = 0;
        }
        if (list.size() > i3) {
            list.subList(i3, list.size()).clear();
        }
        int[] iArr = this.f5928c;
        int length = iArr.length - 1;
        if (i2 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i2, length, -1);
        }
        long[] jArr = this.f5929d;
        int length2 = jArr.length - 1;
        if (i2 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i2, length2, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] n(View view, int i2, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        List<c> l2 = l(flexItemCount);
        c cVar = new c();
        if (view != null && (layoutParams instanceof com.google.android.flexbox.b)) {
            cVar.f5932b = ((com.google.android.flexbox.b) layoutParams).getOrder();
        } else {
            cVar.f5932b = 1;
        }
        if (i2 != -1 && i2 != flexItemCount) {
            if (i2 < this.a.getFlexItemCount()) {
                cVar.a = i2;
                while (i2 < flexItemCount) {
                    l2.get(i2).a++;
                    i2++;
                }
            } else {
                cVar.a = flexItemCount;
            }
        } else {
            cVar.a = flexItemCount;
        }
        l2.add(cVar);
        return U(flexItemCount + 1, l2, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i2, int i3, int i4) {
        int i5;
        int i6;
        int flexDirection = this.a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            i5 = mode;
            i6 = size;
        } else if (flexDirection != 2 && flexDirection != 3) {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        } else {
            i5 = View.MeasureSpec.getMode(i2);
            i6 = View.MeasureSpec.getSize(i2);
        }
        List<com.google.android.flexbox.c> flexLinesInternal = this.a.getFlexLinesInternal();
        if (i5 == 1073741824) {
            int sumOfCrossSize = this.a.getSumOfCrossSize() + i4;
            int i7 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f5921g = i6 - i4;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = this.a.getAlignContent();
                if (alignContent == 1) {
                    int i8 = i6 - sumOfCrossSize;
                    com.google.android.flexbox.c cVar = new com.google.android.flexbox.c();
                    cVar.f5921g = i8;
                    flexLinesInternal.add(0, cVar);
                } else if (alignContent == 2) {
                    this.a.setFlexLines(k(flexLinesInternal, i6, sumOfCrossSize));
                } else if (alignContent == 3) {
                    if (sumOfCrossSize >= i6) {
                        return;
                    }
                    float size2 = (i6 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size3 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i7 < size3) {
                        arrayList.add(flexLinesInternal.get(i7));
                        if (i7 != flexLinesInternal.size() - 1) {
                            com.google.android.flexbox.c cVar2 = new com.google.android.flexbox.c();
                            if (i7 == flexLinesInternal.size() - 2) {
                                cVar2.f5921g = Math.round(f2 + size2);
                                f2 = 0.0f;
                            } else {
                                cVar2.f5921g = Math.round(size2);
                            }
                            int i9 = cVar2.f5921g;
                            f2 += size2 - i9;
                            if (f2 > 1.0f) {
                                cVar2.f5921g = i9 + 1;
                                f2 -= 1.0f;
                            } else if (f2 < -1.0f) {
                                cVar2.f5921g = i9 - 1;
                                f2 += 1.0f;
                            }
                            arrayList.add(cVar2);
                        }
                        i7++;
                    }
                    this.a.setFlexLines(arrayList);
                } else if (alignContent == 4) {
                    if (sumOfCrossSize >= i6) {
                        this.a.setFlexLines(k(flexLinesInternal, i6, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i6 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    com.google.android.flexbox.c cVar3 = new com.google.android.flexbox.c();
                    cVar3.f5921g = size4;
                    for (com.google.android.flexbox.c cVar4 : flexLinesInternal) {
                        arrayList2.add(cVar3);
                        arrayList2.add(cVar4);
                        arrayList2.add(cVar3);
                    }
                    this.a.setFlexLines(arrayList2);
                } else if (alignContent == 5 && sumOfCrossSize < i6) {
                    float size5 = (i6 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f3 = 0.0f;
                    while (i7 < size6) {
                        com.google.android.flexbox.c cVar5 = flexLinesInternal.get(i7);
                        float f4 = cVar5.f5921g + size5;
                        if (i7 == flexLinesInternal.size() - 1) {
                            f4 += f3;
                            f3 = 0.0f;
                        }
                        int round = Math.round(f4);
                        f3 += f4 - round;
                        if (f3 > 1.0f) {
                            round++;
                            f3 -= 1.0f;
                        } else if (f3 < -1.0f) {
                            round--;
                            f3 += 1.0f;
                        }
                        cVar5.f5921g = round;
                        i7++;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i2, int i3) {
        q(i2, i3, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i2, int i3, int i4) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.a.getFlexItemCount());
        if (i4 >= this.a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.a.getFlexDirection();
        int flexDirection2 = this.a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            int largestMainSize = this.a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.a.getPaddingLeft();
            paddingRight = this.a.getPaddingRight();
        } else if (flexDirection2 != 2 && flexDirection2 != 3) {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        } else {
            int mode2 = View.MeasureSpec.getMode(i3);
            size = View.MeasureSpec.getSize(i3);
            if (mode2 != 1073741824) {
                size = this.a.getLargestMainSize();
            }
            paddingLeft = this.a.getPaddingTop();
            paddingRight = this.a.getPaddingBottom();
        }
        int i5 = paddingLeft + paddingRight;
        int[] iArr = this.f5928c;
        int i6 = iArr != null ? iArr[i4] : 0;
        List<com.google.android.flexbox.c> flexLinesInternal = this.a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i7 = i6; i7 < size2; i7++) {
            com.google.android.flexbox.c cVar = flexLinesInternal.get(i7);
            int i8 = cVar.f5919e;
            if (i8 < size && cVar.q) {
                w(i2, i3, cVar, size, i5, false);
            } else if (i8 > size && cVar.r) {
                T(i2, i3, cVar, size, i5, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i2) {
        int[] iArr = this.f5928c;
        if (iArr == null) {
            this.f5928c = new int[Math.max(i2, 10)];
        } else if (iArr.length < i2) {
            this.f5928c = Arrays.copyOf(this.f5928c, Math.max(iArr.length * 2, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i2) {
        long[] jArr = this.f5929d;
        if (jArr == null) {
            this.f5929d = new long[Math.max(i2, 10)];
        } else if (jArr.length < i2) {
            this.f5929d = Arrays.copyOf(this.f5929d, Math.max(jArr.length * 2, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i2) {
        long[] jArr = this.f5930e;
        if (jArr == null) {
            this.f5930e = new long[Math.max(i2, 10)];
        } else if (jArr.length < i2) {
            this.f5930e = Arrays.copyOf(this.f5930e, Math.max(jArr.length * 2, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x(long j2) {
        return (int) (j2 >> 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y(long j2) {
        return (int) j2;
    }
}