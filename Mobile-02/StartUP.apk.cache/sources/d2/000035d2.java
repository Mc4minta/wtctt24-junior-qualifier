package com.google.android.gms.internal.measurement;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class y3 extends b3<Double> implements v4<Double>, f6, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final y3 f7426b;

    /* renamed from: c  reason: collision with root package name */
    private double[] f7427c;

    /* renamed from: d  reason: collision with root package name */
    private int f7428d;

    static {
        y3 y3Var = new y3(new double[0], 0);
        f7426b = y3Var;
        y3Var.b();
    }

    y3() {
        this(new double[10], 0);
    }

    private final void k(int i2) {
        if (i2 < 0 || i2 >= this.f7428d) {
            throw new IndexOutOfBoundsException(l(i2));
        }
    }

    private final String l(int i2) {
        int i3 = this.f7428d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        double doubleValue = ((Double) obj).doubleValue();
        h();
        if (i2 >= 0 && i2 <= (i3 = this.f7428d)) {
            double[] dArr = this.f7427c;
            if (i3 < dArr.length) {
                System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
            } else {
                double[] dArr2 = new double[((i3 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i2);
                System.arraycopy(this.f7427c, i2, dArr2, i2 + 1, this.f7428d - i2);
                this.f7427c = dArr2;
            }
            this.f7427c[i2] = doubleValue;
            this.f7428d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(l(i2));
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        h();
        q4.d(collection);
        if (!(collection instanceof y3)) {
            return super.addAll(collection);
        }
        y3 y3Var = (y3) collection;
        int i2 = y3Var.f7428d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f7428d;
        if (RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.f7427c;
            if (i4 > dArr.length) {
                this.f7427c = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(y3Var.f7427c, 0, this.f7427c, this.f7428d, y3Var.f7428d);
            this.f7428d = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y3)) {
            return super.equals(obj);
        }
        y3 y3Var = (y3) obj;
        if (this.f7428d != y3Var.f7428d) {
            return false;
        }
        double[] dArr = y3Var.f7427c;
        for (int i2 = 0; i2 < this.f7428d; i2++) {
            if (Double.doubleToLongBits(this.f7427c[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.v4
    public final /* synthetic */ v4<Double> f(int i2) {
        if (i2 >= this.f7428d) {
            return new y3(Arrays.copyOf(this.f7427c, i2), this.f7428d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        k(i2);
        return Double.valueOf(this.f7427c[i2]);
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f7428d; i3++) {
            i2 = (i2 * 31) + q4.b(Double.doubleToLongBits(this.f7427c[i3]));
        }
        return i2;
    }

    public final void i(double d2) {
        h();
        int i2 = this.f7428d;
        double[] dArr = this.f7427c;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.f7427c = dArr2;
        }
        double[] dArr3 = this.f7427c;
        int i3 = this.f7428d;
        this.f7428d = i3 + 1;
        dArr3[i3] = d2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f7427c[i2] == doubleValue) {
                    return i2;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f7428d; i2++) {
            if (obj.equals(Double.valueOf(this.f7427c[i2]))) {
                double[] dArr = this.f7427c;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.f7428d - i2) - 1);
                this.f7428d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        h();
        if (i3 >= i2) {
            double[] dArr = this.f7427c;
            System.arraycopy(dArr, i3, dArr, i2, this.f7428d - i3);
            this.f7428d -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        h();
        k(i2);
        double[] dArr = this.f7427c;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7428d;
    }

    private y3(double[] dArr, int i2) {
        this.f7427c = dArr;
        this.f7428d = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        h();
        k(i2);
        double[] dArr = this.f7427c;
        double d2 = dArr[i2];
        if (i2 < this.f7428d - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.f7428d--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        i(((Double) obj).doubleValue());
        return true;
    }
}