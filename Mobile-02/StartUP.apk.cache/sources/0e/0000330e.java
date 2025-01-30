package com.google.android.gms.internal.clearcut;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class x extends t<Boolean> implements j1<Boolean>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final x f6608b;

    /* renamed from: c  reason: collision with root package name */
    private boolean[] f6609c;

    /* renamed from: d  reason: collision with root package name */
    private int f6610d;

    static {
        x xVar = new x();
        f6608b = xVar;
        xVar.j();
    }

    x() {
        this(new boolean[10], 0);
    }

    private x(boolean[] zArr, int i2) {
        this.f6609c = zArr;
        this.f6610d = i2;
    }

    private final void k(int i2, boolean z) {
        int i3;
        h();
        if (i2 < 0 || i2 > (i3 = this.f6610d)) {
            throw new IndexOutOfBoundsException(m(i2));
        }
        boolean[] zArr = this.f6609c;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[((i3 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f6609c, i2, zArr2, i2 + 1, this.f6610d - i2);
            this.f6609c = zArr2;
        }
        this.f6609c[i2] = z;
        this.f6610d++;
        ((AbstractList) this).modCount++;
    }

    private final void l(int i2) {
        if (i2 < 0 || i2 >= this.f6610d) {
            throw new IndexOutOfBoundsException(m(i2));
        }
    }

    private final String m(int i2) {
        int i3 = this.f6610d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        k(i2, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        h();
        g1.a(collection);
        if (collection instanceof x) {
            x xVar = (x) collection;
            int i2 = xVar.f6610d;
            if (i2 == 0) {
                return false;
            }
            int i3 = this.f6610d;
            if (RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO - i3 >= i2) {
                int i4 = i3 + i2;
                boolean[] zArr = this.f6609c;
                if (i4 > zArr.length) {
                    this.f6609c = Arrays.copyOf(zArr, i4);
                }
                System.arraycopy(xVar.f6609c, 0, this.f6609c, this.f6610d, xVar.f6610d);
                this.f6610d = i4;
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
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.f6610d != xVar.f6610d) {
                return false;
            }
            boolean[] zArr = xVar.f6609c;
            for (int i2 = 0; i2 < this.f6610d; i2++) {
                if (this.f6609c[i2] != zArr[i2]) {
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
        return Boolean.valueOf(this.f6609c[i2]);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f6610d; i3++) {
            i2 = (i2 * 31) + g1.f(this.f6609c[i3]);
        }
        return i2;
    }

    public final void i(boolean z) {
        k(this.f6610d, z);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        h();
        l(i2);
        boolean[] zArr = this.f6609c;
        boolean z = zArr[i2];
        int i3 = this.f6610d;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, i3 - i2);
        }
        this.f6610d--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f6610d; i2++) {
            if (obj.equals(Boolean.valueOf(this.f6609c[i2]))) {
                boolean[] zArr = this.f6609c;
                System.arraycopy(zArr, i2 + 1, zArr, i2, this.f6610d - i2);
                this.f6610d--;
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
        boolean[] zArr = this.f6609c;
        System.arraycopy(zArr, i3, zArr, i2, this.f6610d - i3);
        this.f6610d -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        h();
        l(i2);
        boolean[] zArr = this.f6609c;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6610d;
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final /* synthetic */ j1<Boolean> x0(int i2) {
        if (i2 >= this.f6610d) {
            return new x(Arrays.copyOf(this.f6609c, i2), this.f6610d);
        }
        throw new IllegalArgumentException();
    }
}