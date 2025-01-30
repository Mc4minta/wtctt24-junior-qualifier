package com.google.android.gms.internal.measurement;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class i5 extends b3<Long> implements t4, f6, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final i5 f7181b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f7182c;

    /* renamed from: d  reason: collision with root package name */
    private int f7183d;

    static {
        i5 i5Var = new i5(new long[0], 0);
        f7181b = i5Var;
        i5Var.b();
    }

    i5() {
        this(new long[10], 0);
    }

    public static i5 k() {
        return f7181b;
    }

    private final void l(int i2) {
        if (i2 < 0 || i2 >= this.f7183d) {
            throw new IndexOutOfBoundsException(m(i2));
        }
    }

    private final String m(int i2) {
        int i3 = this.f7183d;
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
        long longValue = ((Long) obj).longValue();
        h();
        if (i2 >= 0 && i2 <= (i3 = this.f7183d)) {
            long[] jArr = this.f7182c;
            if (i3 < jArr.length) {
                System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
            } else {
                long[] jArr2 = new long[((i3 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i2);
                System.arraycopy(this.f7182c, i2, jArr2, i2 + 1, this.f7183d - i2);
                this.f7182c = jArr2;
            }
            this.f7182c[i2] = longValue;
            this.f7183d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(m(i2));
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        h();
        q4.d(collection);
        if (!(collection instanceof i5)) {
            return super.addAll(collection);
        }
        i5 i5Var = (i5) collection;
        int i2 = i5Var.f7183d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f7183d;
        if (RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.f7182c;
            if (i4 > jArr.length) {
                this.f7182c = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(i5Var.f7182c, 0, this.f7182c, this.f7183d, i5Var.f7183d);
            this.f7183d = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.android.gms.internal.measurement.t4
    public final long c(int i2) {
        l(i2);
        return this.f7182c[i2];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.v4
    /* renamed from: e0 */
    public final t4 f(int i2) {
        if (i2 >= this.f7183d) {
            return new i5(Arrays.copyOf(this.f7182c, i2), this.f7183d);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i5)) {
            return super.equals(obj);
        }
        i5 i5Var = (i5) obj;
        if (this.f7183d != i5Var.f7183d) {
            return false;
        }
        long[] jArr = i5Var.f7182c;
        for (int i2 = 0; i2 < this.f7183d; i2++) {
            if (this.f7182c[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(c(i2));
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f7183d; i3++) {
            i2 = (i2 * 31) + q4.b(this.f7182c[i3]);
        }
        return i2;
    }

    public final void i(long j2) {
        h();
        int i2 = this.f7183d;
        long[] jArr = this.f7182c;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f7182c = jArr2;
        }
        long[] jArr3 = this.f7182c;
        int i3 = this.f7183d;
        this.f7183d = i3 + 1;
        jArr3[i3] = j2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f7182c[i2] == longValue) {
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
        for (int i2 = 0; i2 < this.f7183d; i2++) {
            if (obj.equals(Long.valueOf(this.f7182c[i2]))) {
                long[] jArr = this.f7182c;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f7183d - i2) - 1);
                this.f7183d--;
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
            long[] jArr = this.f7182c;
            System.arraycopy(jArr, i3, jArr, i2, this.f7183d - i3);
            this.f7183d -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        h();
        l(i2);
        long[] jArr = this.f7182c;
        long j2 = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7183d;
    }

    private i5(long[] jArr, int i2) {
        this.f7182c = jArr;
        this.f7183d = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        h();
        l(i2);
        long[] jArr = this.f7182c;
        long j2 = jArr[i2];
        if (i2 < this.f7183d - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f7183d--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        i(((Long) obj).longValue());
        return true;
    }
}