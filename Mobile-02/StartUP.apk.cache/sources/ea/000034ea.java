package com.google.android.gms.internal.measurement;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class j4 extends b3<Float> implements v4<Float>, f6, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final j4 f7195b;

    /* renamed from: c  reason: collision with root package name */
    private float[] f7196c;

    /* renamed from: d  reason: collision with root package name */
    private int f7197d;

    static {
        j4 j4Var = new j4(new float[0], 0);
        f7195b = j4Var;
        j4Var.b();
    }

    j4() {
        this(new float[10], 0);
    }

    private final void k(int i2) {
        if (i2 < 0 || i2 >= this.f7197d) {
            throw new IndexOutOfBoundsException(l(i2));
        }
    }

    private final String l(int i2) {
        int i3 = this.f7197d;
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
        float floatValue = ((Float) obj).floatValue();
        h();
        if (i2 >= 0 && i2 <= (i3 = this.f7197d)) {
            float[] fArr = this.f7196c;
            if (i3 < fArr.length) {
                System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
            } else {
                float[] fArr2 = new float[((i3 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i2);
                System.arraycopy(this.f7196c, i2, fArr2, i2 + 1, this.f7197d - i2);
                this.f7196c = fArr2;
            }
            this.f7196c[i2] = floatValue;
            this.f7197d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(l(i2));
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        h();
        q4.d(collection);
        if (!(collection instanceof j4)) {
            return super.addAll(collection);
        }
        j4 j4Var = (j4) collection;
        int i2 = j4Var.f7197d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f7197d;
        if (RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.f7196c;
            if (i4 > fArr.length) {
                this.f7196c = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(j4Var.f7196c, 0, this.f7196c, this.f7197d, j4Var.f7197d);
            this.f7197d = i4;
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
        if (!(obj instanceof j4)) {
            return super.equals(obj);
        }
        j4 j4Var = (j4) obj;
        if (this.f7197d != j4Var.f7197d) {
            return false;
        }
        float[] fArr = j4Var.f7196c;
        for (int i2 = 0; i2 < this.f7197d; i2++) {
            if (Float.floatToIntBits(this.f7196c[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.v4
    public final /* synthetic */ v4<Float> f(int i2) {
        if (i2 >= this.f7197d) {
            return new j4(Arrays.copyOf(this.f7196c, i2), this.f7197d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        k(i2);
        return Float.valueOf(this.f7196c[i2]);
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f7197d; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.f7196c[i3]);
        }
        return i2;
    }

    public final void i(float f2) {
        h();
        int i2 = this.f7197d;
        float[] fArr = this.f7196c;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.f7196c = fArr2;
        }
        float[] fArr3 = this.f7196c;
        int i3 = this.f7197d;
        this.f7197d = i3 + 1;
        fArr3[i3] = f2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f7196c[i2] == floatValue) {
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
        for (int i2 = 0; i2 < this.f7197d; i2++) {
            if (obj.equals(Float.valueOf(this.f7196c[i2]))) {
                float[] fArr = this.f7196c;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.f7197d - i2) - 1);
                this.f7197d--;
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
            float[] fArr = this.f7196c;
            System.arraycopy(fArr, i3, fArr, i2, this.f7197d - i3);
            this.f7197d -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        h();
        k(i2);
        float[] fArr = this.f7196c;
        float f2 = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7197d;
    }

    private j4(float[] fArr, int i2) {
        this.f7196c = fArr;
        this.f7197d = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        h();
        k(i2);
        float[] fArr = this.f7196c;
        float f2 = fArr[i2];
        if (i2 < this.f7197d - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.f7197d--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        i(((Float) obj).floatValue());
        return true;
    }
}