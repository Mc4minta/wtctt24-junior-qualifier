package com.google.android.gms.internal.clearcut;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class o0 extends t<Double> implements j1<Double>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final o0 f6522b;

    /* renamed from: c  reason: collision with root package name */
    private double[] f6523c;

    /* renamed from: d  reason: collision with root package name */
    private int f6524d;

    static {
        o0 o0Var = new o0();
        f6522b = o0Var;
        o0Var.j();
    }

    o0() {
        this(new double[10], 0);
    }

    private o0(double[] dArr, int i2) {
        this.f6523c = dArr;
        this.f6524d = i2;
    }

    private final void k(int i2, double d2) {
        int i3;
        h();
        if (i2 < 0 || i2 > (i3 = this.f6524d)) {
            throw new IndexOutOfBoundsException(m(i2));
        }
        double[] dArr = this.f6523c;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[((i3 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f6523c, i2, dArr2, i2 + 1, this.f6524d - i2);
            this.f6523c = dArr2;
        }
        this.f6523c[i2] = d2;
        this.f6524d++;
        ((AbstractList) this).modCount++;
    }

    private final void l(int i2) {
        if (i2 < 0 || i2 >= this.f6524d) {
            throw new IndexOutOfBoundsException(m(i2));
        }
    }

    private final String m(int i2) {
        int i3 = this.f6524d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        k(i2, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        h();
        g1.a(collection);
        if (collection instanceof o0) {
            o0 o0Var = (o0) collection;
            int i2 = o0Var.f6524d;
            if (i2 == 0) {
                return false;
            }
            int i3 = this.f6524d;
            if (RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO - i3 >= i2) {
                int i4 = i3 + i2;
                double[] dArr = this.f6523c;
                if (i4 > dArr.length) {
                    this.f6523c = Arrays.copyOf(dArr, i4);
                }
                System.arraycopy(o0Var.f6523c, 0, this.f6523c, this.f6524d, o0Var.f6524d);
                this.f6524d = i4;
                ((AbstractList) this).modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
        return super.addAll(collection);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o0) {
            o0 o0Var = (o0) obj;
            if (this.f6524d != o0Var.f6524d) {
                return false;
            }
            double[] dArr = o0Var.f6523c;
            for (int i2 = 0; i2 < this.f6524d; i2++) {
                if (this.f6523c[i2] != dArr[i2]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        l(i2);
        return Double.valueOf(this.f6523c[i2]);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f6524d; i3++) {
            i2 = (i2 * 31) + g1.j(Double.doubleToLongBits(this.f6523c[i3]));
        }
        return i2;
    }

    public final void i(double d2) {
        k(this.f6524d, d2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        h();
        l(i2);
        double[] dArr = this.f6523c;
        double d2 = dArr[i2];
        int i3 = this.f6524d;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, i3 - i2);
        }
        this.f6524d--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f6524d; i2++) {
            if (obj.equals(Double.valueOf(this.f6523c[i2]))) {
                double[] dArr = this.f6523c;
                System.arraycopy(dArr, i2 + 1, dArr, i2, this.f6524d - i2);
                this.f6524d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        h();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f6523c;
        System.arraycopy(dArr, i3, dArr, i2, this.f6524d - i3);
        this.f6524d -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        h();
        l(i2);
        double[] dArr = this.f6523c;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6524d;
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final /* synthetic */ j1<Double> x0(int i2) {
        if (i2 >= this.f6524d) {
            return new o0(Arrays.copyOf(this.f6523c, i2), this.f6524d);
        }
        throw new IllegalArgumentException();
    }
}