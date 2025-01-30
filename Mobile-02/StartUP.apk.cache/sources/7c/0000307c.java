package com.facebook.yoga;

import java.util.ArrayList;
import java.util.List;

@e.f.l.a.a
/* loaded from: classes2.dex */
public abstract class YogaNodeJNIBase extends p implements Cloneable {
    private YogaNodeJNIBase a;
    @e.f.l.a.a
    private float[] arr;

    /* renamed from: b  reason: collision with root package name */
    private List<YogaNodeJNIBase> f5659b;

    /* renamed from: c  reason: collision with root package name */
    private m f5660c;

    /* renamed from: d  reason: collision with root package name */
    private b f5661d;

    /* renamed from: e  reason: collision with root package name */
    protected long f5662e;

    /* renamed from: f  reason: collision with root package name */
    private Object f5663f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5664g;
    @e.f.l.a.a
    private int mLayoutDirection;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j.values().length];
            a = iArr;
            try {
                iArr[j.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[j.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[j.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[j.START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[j.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private YogaNodeJNIBase(long j2) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.f5664g = true;
        if (j2 != 0) {
            this.f5662e = j2;
            return;
        }
        throw new IllegalStateException("Failed to allocate native memory");
    }

    @e.f.l.a.a
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i2) {
        List<YogaNodeJNIBase> list = this.f5659b;
        if (list != null) {
            list.remove(i2);
            this.f5659b.add(i2, yogaNodeJNIBase);
            yogaNodeJNIBase.a = this;
            return yogaNodeJNIBase.f5662e;
        }
        throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
    }

    private static v u0(long j2) {
        return new v(Float.intBitsToFloat((int) j2), (int) (j2 >> 32));
    }

    @Override // com.facebook.yoga.p
    public void A(j jVar, float f2) {
        YogaNative.jni_YGNodeStyleSetBorderJNI(this.f5662e, jVar.n(), f2);
    }

    @Override // com.facebook.yoga.p
    public void B(Object obj) {
        this.f5663f = obj;
    }

    @Override // com.facebook.yoga.p
    public void C(h hVar) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.f5662e, hVar.n());
    }

    @Override // com.facebook.yoga.p
    public void D(i iVar) {
        YogaNative.jni_YGNodeStyleSetDisplayJNI(this.f5662e, iVar.h());
    }

    @Override // com.facebook.yoga.p
    public void E(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void F(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void G() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.f5662e);
    }

    @Override // com.facebook.yoga.p
    public void H(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexBasisPercentJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void I(k kVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.f5662e, kVar.h());
    }

    @Override // com.facebook.yoga.p
    public void J(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void K(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void L(float f2) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void M() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.f5662e);
    }

    @Override // com.facebook.yoga.p
    public void N(float f2) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void P(l lVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.f5662e, lVar.h());
    }

    @Override // com.facebook.yoga.p
    public void Q(j jVar, float f2) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.f5662e, jVar.n(), f2);
    }

    @Override // com.facebook.yoga.p
    public void R(j jVar) {
        YogaNative.jni_YGNodeStyleSetMarginAutoJNI(this.f5662e, jVar.n());
    }

    @Override // com.facebook.yoga.p
    public void S(j jVar, float f2) {
        YogaNative.jni_YGNodeStyleSetMarginPercentJNI(this.f5662e, jVar.n(), f2);
    }

    @Override // com.facebook.yoga.p
    public void T(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void U(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxHeightPercentJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void W(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void X(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxWidthPercentJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void Y(m mVar) {
        this.f5660c = mVar;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.f5662e, mVar != null);
    }

    @Override // com.facebook.yoga.p
    public void Z(float f2) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void b(p pVar, int i2) {
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) pVar;
        if (yogaNodeJNIBase.a == null) {
            if (this.f5659b == null) {
                this.f5659b = new ArrayList(4);
            }
            this.f5659b.add(i2, yogaNodeJNIBase);
            yogaNodeJNIBase.a = this;
            YogaNative.jni_YGNodeInsertChildJNI(this.f5662e, yogaNodeJNIBase.f5662e, i2);
            return;
        }
        throw new IllegalStateException("Child already has a parent, it must be removed first.");
    }

    @Override // com.facebook.yoga.p
    public void b0(float f2) {
        YogaNative.jni_YGNodeStyleSetMinHeightPercentJNI(this.f5662e, f2);
    }

    @e.f.l.a.a
    public final float baseline(float f2, float f3) {
        return this.f5661d.a(this, f2, f3);
    }

    @Override // com.facebook.yoga.p
    public void c(float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i2)).f5659b;
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i3 = 0; i3 < yogaNodeJNIBaseArr.length; i3++) {
            jArr[i3] = yogaNodeJNIBaseArr[i3].f5662e;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.f5662e, f2, f3, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.facebook.yoga.p
    public void c0(float f2) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public void d() {
        YogaNative.jni_YGNodeMarkDirtyJNI(this.f5662e);
    }

    @Override // com.facebook.yoga.p
    public v e() {
        return u0(YogaNative.jni_YGNodeStyleGetHeightJNI(this.f5662e));
    }

    @Override // com.facebook.yoga.p
    public void e0(float f2) {
        YogaNative.jni_YGNodeStyleSetMinWidthPercentJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public h f() {
        float[] fArr = this.arr;
        return h.h(fArr != null ? (int) fArr[5] : this.mLayoutDirection);
    }

    @Override // com.facebook.yoga.p
    public void f0(s sVar) {
        YogaNative.jni_YGNodeStyleSetOverflowJNI(this.f5662e, sVar.h());
    }

    @Override // com.facebook.yoga.p
    public float h() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.p
    public void h0(j jVar, float f2) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.f5662e, jVar.n(), f2);
    }

    @Override // com.facebook.yoga.p
    public float i(j jVar) {
        float[] fArr = this.arr;
        if (fArr != null) {
            if ((((int) fArr[0]) & 2) == 2) {
                int i2 = 10 - ((((int) fArr[0]) & 1) != 1 ? 4 : 0);
                switch (a.a[jVar.ordinal()]) {
                    case 1:
                        return this.arr[i2];
                    case 2:
                        return this.arr[i2 + 1];
                    case 3:
                        return this.arr[i2 + 2];
                    case 4:
                        return this.arr[i2 + 3];
                    case 5:
                        return f() == h.RTL ? this.arr[i2 + 2] : this.arr[i2];
                    case 6:
                        return f() == h.RTL ? this.arr[i2] : this.arr[i2 + 2];
                    default:
                        throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
                }
            }
            return 0.0f;
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.p
    public void i0(j jVar, float f2) {
        YogaNative.jni_YGNodeStyleSetPaddingPercentJNI(this.f5662e, jVar.n(), f2);
    }

    @Override // com.facebook.yoga.p
    public void j0(j jVar, float f2) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.f5662e, jVar.n(), f2);
    }

    @Override // com.facebook.yoga.p
    public float k() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.p
    public float l() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.p
    public void l0(j jVar, float f2) {
        YogaNative.jni_YGNodeStyleSetPositionPercentJNI(this.f5662e, jVar.n(), f2);
    }

    @Override // com.facebook.yoga.p
    public void m0(t tVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.f5662e, tVar.h());
    }

    @e.f.l.a.a
    public final long measure(float f2, int i2, float f3, int i3) {
        if (r()) {
            return this.f5660c.T(this, f2, n.h(i2), f3, n.h(i3));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    @Override // com.facebook.yoga.p
    public float n() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.p
    public void n0(float f2) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public v o() {
        return u0(YogaNative.jni_YGNodeStyleGetWidthJNI(this.f5662e));
    }

    @Override // com.facebook.yoga.p
    public boolean p() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return (((int) fArr[0]) & 16) == 16;
        }
        return this.f5664g;
    }

    @Override // com.facebook.yoga.p
    public void p0() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.f5662e);
    }

    @Override // com.facebook.yoga.p
    public boolean q() {
        return YogaNative.jni_YGNodeIsDirtyJNI(this.f5662e);
    }

    @Override // com.facebook.yoga.p
    public void q0(float f2) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.f5662e, f2);
    }

    @Override // com.facebook.yoga.p
    public boolean r() {
        return this.f5660c != null;
    }

    @Override // com.facebook.yoga.p
    public void r0(w wVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.f5662e, wVar.h());
    }

    @Override // com.facebook.yoga.p
    public void s() {
        float[] fArr = this.arr;
        if (fArr != null) {
            fArr[0] = ((int) fArr[0]) & (-17);
        }
        this.f5664g = false;
    }

    @Override // com.facebook.yoga.p
    /* renamed from: t0 */
    public YogaNodeJNIBase t(int i2) {
        List<YogaNodeJNIBase> list = this.f5659b;
        if (list != null) {
            YogaNodeJNIBase remove = list.remove(i2);
            remove.a = null;
            YogaNative.jni_YGNodeRemoveChildJNI(this.f5662e, remove.f5662e);
            return remove;
        }
        throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
    }

    @Override // com.facebook.yoga.p
    public void u() {
        this.f5660c = null;
        this.f5661d = null;
        this.f5663f = null;
        this.arr = null;
        this.f5664g = true;
        this.mLayoutDirection = 0;
        YogaNative.jni_YGNodeResetJNI(this.f5662e);
    }

    @Override // com.facebook.yoga.p
    public void v(com.facebook.yoga.a aVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.f5662e, aVar.h());
    }

    @Override // com.facebook.yoga.p
    public void w(com.facebook.yoga.a aVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.f5662e, aVar.h());
    }

    @Override // com.facebook.yoga.p
    public void x(com.facebook.yoga.a aVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.f5662e, aVar.h());
    }

    @Override // com.facebook.yoga.p
    public void y(float f2) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.f5662e, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public YogaNodeJNIBase(c cVar) {
        this(YogaNative.jni_YGNodeNewWithConfigJNI(((e) cVar).a));
    }
}