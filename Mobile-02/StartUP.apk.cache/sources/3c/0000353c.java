package com.google.android.gms.internal.measurement;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class o4 extends b3<Integer> implements u4, f6, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final o4 f7279b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f7280c;

    /* renamed from: d  reason: collision with root package name */
    private int f7281d;

    static {
        o4 o4Var = new o4(new int[0], 0);
        f7279b = o4Var;
        o4Var.b();
    }

    o4() {
        this(new int[10], 0);
    }

    public static o4 k() {
        return f7279b;
    }

    private final void m(int i2) {
        if (i2 < 0 || i2 >= this.f7281d) {
            throw new IndexOutOfBoundsException(o(i2));
        }
    }

    private final String o(int i2) {
        int i3 = this.f7281d;
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
        int intValue = ((Integer) obj).intValue();
        h();
        if (i2 >= 0 && i2 <= (i3 = this.f7281d)) {
            int[] iArr = this.f7280c;
            if (i3 < iArr.length) {
                System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
            } else {
                int[] iArr2 = new int[((i3 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                System.arraycopy(this.f7280c, i2, iArr2, i2 + 1, this.f7281d - i2);
                this.f7280c = iArr2;
            }
            this.f7280c[i2] = intValue;
            this.f7281d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(o(i2));
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        h();
        q4.d(collection);
        if (!(collection instanceof o4)) {
            return super.addAll(collection);
        }
        o4 o4Var = (o4) collection;
        int i2 = o4Var.f7281d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f7281d;
        if (RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.f7280c;
            if (i4 > iArr.length) {
                this.f7280c = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(o4Var.f7280c, 0, this.f7280c, this.f7281d, o4Var.f7281d);
            this.f7281d = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.android.gms.internal.measurement.v4
    /* renamed from: c */
    public final u4 f(int i2) {
        if (i2 >= this.f7281d) {
            return new o4(Arrays.copyOf(this.f7280c, i2), this.f7281d);
        }
        throw new IllegalArgumentException();
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
        if (!(obj instanceof o4)) {
            return super.equals(obj);
        }
        o4 o4Var = (o4) obj;
        if (this.f7281d != o4Var.f7281d) {
            return false;
        }
        int[] iArr = o4Var.f7280c;
        for (int i2 = 0; i2 < this.f7281d; i2++) {
            if (this.f7280c[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(i(i2));
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f7281d; i3++) {
            i2 = (i2 * 31) + this.f7280c[i3];
        }
        return i2;
    }

    public final int i(int i2) {
        m(i2);
        return this.f7280c[i2];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f7280c[i2] == intValue) {
                    return i2;
                }
            }
            return -1;
        }
        return -1;
    }

    public final void l(int i2) {
        h();
        int i3 = this.f7281d;
        int[] iArr = this.f7280c;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f7280c = iArr2;
        }
        int[] iArr3 = this.f7280c;
        int i4 = this.f7281d;
        this.f7281d = i4 + 1;
        iArr3[i4] = i2;
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f7281d; i2++) {
            if (obj.equals(Integer.valueOf(this.f7280c[i2]))) {
                int[] iArr = this.f7280c;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f7281d - i2) - 1);
                this.f7281d--;
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
            int[] iArr = this.f7280c;
            System.arraycopy(iArr, i3, iArr, i2, this.f7281d - i3);
            this.f7281d -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        h();
        m(i2);
        int[] iArr = this.f7280c;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7281d;
    }

    private o4(int[] iArr, int i2) {
        this.f7280c = iArr;
        this.f7281d = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        h();
        m(i2);
        int[] iArr = this.f7280c;
        int i4 = iArr[i2];
        if (i2 < this.f7281d - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i3 - i2) - 1);
        }
        this.f7281d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i4);
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        l(((Integer) obj).intValue());
        return true;
    }
}