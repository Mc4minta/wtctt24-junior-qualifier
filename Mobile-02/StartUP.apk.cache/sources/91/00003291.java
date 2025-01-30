package com.google.android.gms.internal.clearcut;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class f1 extends t<Integer> implements j1<Integer>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final f1 f6427b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f6428c;

    /* renamed from: d  reason: collision with root package name */
    private int f6429d;

    static {
        f1 f1Var = new f1();
        f6427b = f1Var;
        f1Var.j();
    }

    f1() {
        this(new int[10], 0);
    }

    private f1(int[] iArr, int i2) {
        this.f6428c = iArr;
        this.f6429d = i2;
    }

    private final void k(int i2) {
        if (i2 < 0 || i2 >= this.f6429d) {
            throw new IndexOutOfBoundsException(l(i2));
        }
    }

    private final String l(int i2) {
        int i3 = this.f6429d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    private final void m(int i2, int i3) {
        int i4;
        h();
        if (i2 < 0 || i2 > (i4 = this.f6429d)) {
            throw new IndexOutOfBoundsException(l(i2));
        }
        int[] iArr = this.f6428c;
        if (i4 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i4 - i2);
        } else {
            int[] iArr2 = new int[((i4 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f6428c, i2, iArr2, i2 + 1, this.f6429d - i2);
            this.f6428c = iArr2;
        }
        this.f6428c[i2] = i3;
        this.f6429d++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        m(i2, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        h();
        g1.a(collection);
        if (collection instanceof f1) {
            f1 f1Var = (f1) collection;
            int i2 = f1Var.f6429d;
            if (i2 == 0) {
                return false;
            }
            int i3 = this.f6429d;
            if (RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO - i3 >= i2) {
                int i4 = i3 + i2;
                int[] iArr = this.f6428c;
                if (i4 > iArr.length) {
                    this.f6428c = Arrays.copyOf(iArr, i4);
                }
                System.arraycopy(f1Var.f6428c, 0, this.f6428c, this.f6429d, f1Var.f6429d);
                this.f6429d = i4;
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
        if (obj instanceof f1) {
            f1 f1Var = (f1) obj;
            if (this.f6429d != f1Var.f6429d) {
                return false;
            }
            int[] iArr = f1Var.f6428c;
            for (int i2 = 0; i2 < this.f6429d; i2++) {
                if (this.f6428c[i2] != iArr[i2]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(getInt(i2));
    }

    public final int getInt(int i2) {
        k(i2);
        return this.f6428c[i2];
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f6429d; i3++) {
            i2 = (i2 * 31) + this.f6428c[i3];
        }
        return i2;
    }

    public final void i(int i2) {
        m(this.f6429d, i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        h();
        k(i2);
        int[] iArr = this.f6428c;
        int i3 = iArr[i2];
        int i4 = this.f6429d;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, i4 - i2);
        }
        this.f6429d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f6429d; i2++) {
            if (obj.equals(Integer.valueOf(this.f6428c[i2]))) {
                int[] iArr = this.f6428c;
                System.arraycopy(iArr, i2 + 1, iArr, i2, this.f6429d - i2);
                this.f6429d--;
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
        int[] iArr = this.f6428c;
        System.arraycopy(iArr, i3, iArr, i2, this.f6429d - i3);
        this.f6429d -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        h();
        k(i2);
        int[] iArr = this.f6428c;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6429d;
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final /* synthetic */ j1<Integer> x0(int i2) {
        if (i2 >= this.f6429d) {
            return new f1(Arrays.copyOf(this.f6428c, i2), this.f6429d);
        }
        throw new IllegalArgumentException();
    }
}