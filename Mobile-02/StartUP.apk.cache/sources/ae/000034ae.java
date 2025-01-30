package com.google.android.gms.internal.measurement;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class f3 extends b3<Boolean> implements v4<Boolean>, f6, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final f3 f7128b;

    /* renamed from: c  reason: collision with root package name */
    private boolean[] f7129c;

    /* renamed from: d  reason: collision with root package name */
    private int f7130d;

    static {
        f3 f3Var = new f3(new boolean[0], 0);
        f7128b = f3Var;
        f3Var.b();
    }

    f3() {
        this(new boolean[10], 0);
    }

    private final void k(int i2) {
        if (i2 < 0 || i2 >= this.f7130d) {
            throw new IndexOutOfBoundsException(l(i2));
        }
    }

    private final String l(int i2) {
        int i3 = this.f7130d;
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        h();
        if (i2 >= 0 && i2 <= (i3 = this.f7130d)) {
            boolean[] zArr = this.f7129c;
            if (i3 < zArr.length) {
                System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
            } else {
                boolean[] zArr2 = new boolean[((i3 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i2);
                System.arraycopy(this.f7129c, i2, zArr2, i2 + 1, this.f7130d - i2);
                this.f7129c = zArr2;
            }
            this.f7129c[i2] = booleanValue;
            this.f7130d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(l(i2));
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        h();
        q4.d(collection);
        if (!(collection instanceof f3)) {
            return super.addAll(collection);
        }
        f3 f3Var = (f3) collection;
        int i2 = f3Var.f7130d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f7130d;
        if (RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.f7129c;
            if (i4 > zArr.length) {
                this.f7129c = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(f3Var.f7129c, 0, this.f7129c, this.f7130d, f3Var.f7130d);
            this.f7130d = i4;
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
        if (!(obj instanceof f3)) {
            return super.equals(obj);
        }
        f3 f3Var = (f3) obj;
        if (this.f7130d != f3Var.f7130d) {
            return false;
        }
        boolean[] zArr = f3Var.f7129c;
        for (int i2 = 0; i2 < this.f7130d; i2++) {
            if (this.f7129c[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.v4
    public final /* synthetic */ v4<Boolean> f(int i2) {
        if (i2 >= this.f7130d) {
            return new f3(Arrays.copyOf(this.f7129c, i2), this.f7130d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        k(i2);
        return Boolean.valueOf(this.f7129c[i2]);
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f7130d; i3++) {
            i2 = (i2 * 31) + q4.c(this.f7129c[i3]);
        }
        return i2;
    }

    public final void i(boolean z) {
        h();
        int i2 = this.f7130d;
        boolean[] zArr = this.f7129c;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.f7129c = zArr2;
        }
        boolean[] zArr3 = this.f7129c;
        int i3 = this.f7130d;
        this.f7130d = i3 + 1;
        zArr3[i3] = z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f7129c[i2] == booleanValue) {
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
        for (int i2 = 0; i2 < this.f7130d; i2++) {
            if (obj.equals(Boolean.valueOf(this.f7129c[i2]))) {
                boolean[] zArr = this.f7129c;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.f7130d - i2) - 1);
                this.f7130d--;
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
            boolean[] zArr = this.f7129c;
            System.arraycopy(zArr, i3, zArr, i2, this.f7130d - i3);
            this.f7130d -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        h();
        k(i2);
        boolean[] zArr = this.f7129c;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7130d;
    }

    private f3(boolean[] zArr, int i2) {
        this.f7129c = zArr;
        this.f7130d = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        h();
        k(i2);
        boolean[] zArr = this.f7129c;
        boolean z = zArr[i2];
        if (i2 < this.f7130d - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.f7130d--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        i(((Boolean) obj).booleanValue());
        return true;
    }
}