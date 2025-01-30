package com.google.android.gms.internal.clearcut;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class c1 extends t<Float> implements j1<Float>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final c1 f6386b;

    /* renamed from: c  reason: collision with root package name */
    private float[] f6387c;

    /* renamed from: d  reason: collision with root package name */
    private int f6388d;

    static {
        c1 c1Var = new c1();
        f6386b = c1Var;
        c1Var.j();
    }

    c1() {
        this(new float[10], 0);
    }

    private c1(float[] fArr, int i2) {
        this.f6387c = fArr;
        this.f6388d = i2;
    }

    private final void k(int i2, float f2) {
        int i3;
        h();
        if (i2 < 0 || i2 > (i3 = this.f6388d)) {
            throw new IndexOutOfBoundsException(m(i2));
        }
        float[] fArr = this.f6387c;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[((i3 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.f6387c, i2, fArr2, i2 + 1, this.f6388d - i2);
            this.f6387c = fArr2;
        }
        this.f6387c[i2] = f2;
        this.f6388d++;
        ((AbstractList) this).modCount++;
    }

    private final void l(int i2) {
        if (i2 < 0 || i2 >= this.f6388d) {
            throw new IndexOutOfBoundsException(m(i2));
        }
    }

    private final String m(int i2) {
        int i3 = this.f6388d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        k(i2, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        h();
        g1.a(collection);
        if (collection instanceof c1) {
            c1 c1Var = (c1) collection;
            int i2 = c1Var.f6388d;
            if (i2 == 0) {
                return false;
            }
            int i3 = this.f6388d;
            if (RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO - i3 >= i2) {
                int i4 = i3 + i2;
                float[] fArr = this.f6387c;
                if (i4 > fArr.length) {
                    this.f6387c = Arrays.copyOf(fArr, i4);
                }
                System.arraycopy(c1Var.f6387c, 0, this.f6387c, this.f6388d, c1Var.f6388d);
                this.f6388d = i4;
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
        if (obj instanceof c1) {
            c1 c1Var = (c1) obj;
            if (this.f6388d != c1Var.f6388d) {
                return false;
            }
            float[] fArr = c1Var.f6387c;
            for (int i2 = 0; i2 < this.f6388d; i2++) {
                if (this.f6387c[i2] != fArr[i2]) {
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
        return Float.valueOf(this.f6387c[i2]);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f6388d; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.f6387c[i3]);
        }
        return i2;
    }

    public final void i(float f2) {
        k(this.f6388d, f2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        h();
        l(i2);
        float[] fArr = this.f6387c;
        float f2 = fArr[i2];
        int i3 = this.f6388d;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, i3 - i2);
        }
        this.f6388d--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f6388d; i2++) {
            if (obj.equals(Float.valueOf(this.f6387c[i2]))) {
                float[] fArr = this.f6387c;
                System.arraycopy(fArr, i2 + 1, fArr, i2, this.f6388d - i2);
                this.f6388d--;
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
        float[] fArr = this.f6387c;
        System.arraycopy(fArr, i3, fArr, i2, this.f6388d - i3);
        this.f6388d -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        h();
        l(i2);
        float[] fArr = this.f6387c;
        float f2 = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6388d;
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final /* synthetic */ j1<Float> x0(int i2) {
        if (i2 >= this.f6388d) {
            return new c1(Arrays.copyOf(this.f6387c, i2), this.f6388d);
        }
        throw new IllegalArgumentException();
    }
}