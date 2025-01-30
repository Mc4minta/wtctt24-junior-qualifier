package kotlin.a0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: _ArraysJvm.kt */
/* loaded from: classes3.dex */
public class m extends l {

    /* compiled from: _ArraysJvm.kt */
    /* loaded from: classes3.dex */
    public static final class a extends d<Integer> implements RandomAccess {

        /* renamed from: b */
        final /* synthetic */ int[] f17216b;

        a(int[] iArr) {
            this.f17216b = iArr;
        }

        @Override // kotlin.a0.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return k(((Number) obj).intValue());
            }
            return false;
        }

        @Override // kotlin.a0.a
        public int i() {
            return this.f17216b.length;
        }

        @Override // kotlin.a0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return m(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // kotlin.a0.a, java.util.Collection
        public boolean isEmpty() {
            return this.f17216b.length == 0;
        }

        public boolean k(int i2) {
            return n.t(this.f17216b, i2);
        }

        @Override // kotlin.a0.d, java.util.List
        /* renamed from: l */
        public Integer get(int i2) {
            return Integer.valueOf(this.f17216b[i2]);
        }

        @Override // kotlin.a0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return o(((Number) obj).intValue());
            }
            return -1;
        }

        public int m(int i2) {
            return n.E(this.f17216b, i2);
        }

        public int o(int i2) {
            return n.O(this.f17216b, i2);
        }
    }

    public static List<Integer> b(int[] asList) {
        kotlin.jvm.internal.m.g(asList, "$this$asList");
        return new a(asList);
    }

    public static <T> List<T> c(T[] asList) {
        kotlin.jvm.internal.m.g(asList, "$this$asList");
        List<T> a2 = o.a(asList);
        kotlin.jvm.internal.m.f(a2, "ArraysUtilJVM.asList(this)");
        return a2;
    }

    public static byte[] d(byte[] copyInto, byte[] destination, int i2, int i3, int i4) {
        kotlin.jvm.internal.m.g(copyInto, "$this$copyInto");
        kotlin.jvm.internal.m.g(destination, "destination");
        System.arraycopy(copyInto, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static final <T> T[] e(T[] copyInto, T[] destination, int i2, int i3, int i4) {
        kotlin.jvm.internal.m.g(copyInto, "$this$copyInto");
        kotlin.jvm.internal.m.g(destination, "destination");
        System.arraycopy(copyInto, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ byte[] f(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, Object obj) {
        byte[] d2;
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = bArr.length;
        }
        d2 = d(bArr, bArr2, i2, i3, i4);
        return d2;
    }

    public static /* synthetic */ Object[] g(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return e(objArr, objArr2, i2, i3, i4);
    }

    public static byte[] h(byte[] copyOfRangeImpl, int i2, int i3) {
        kotlin.jvm.internal.m.g(copyOfRangeImpl, "$this$copyOfRangeImpl");
        k.a(i3, copyOfRangeImpl.length);
        byte[] copyOfRange = Arrays.copyOfRange(copyOfRangeImpl, i2, i3);
        kotlin.jvm.internal.m.f(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static <T> T[] i(T[] copyOfRangeImpl, int i2, int i3) {
        kotlin.jvm.internal.m.g(copyOfRangeImpl, "$this$copyOfRangeImpl");
        k.a(i3, copyOfRangeImpl.length);
        T[] tArr = (T[]) Arrays.copyOfRange(copyOfRangeImpl, i2, i3);
        kotlin.jvm.internal.m.f(tArr, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr;
    }

    public static void j(int[] fill, int i2, int i3, int i4) {
        kotlin.jvm.internal.m.g(fill, "$this$fill");
        Arrays.fill(fill, i3, i4, i2);
    }

    public static <T> void k(T[] fill, T t, int i2, int i3) {
        kotlin.jvm.internal.m.g(fill, "$this$fill");
        Arrays.fill(fill, i2, i3, t);
    }

    public static /* synthetic */ void l(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        j(iArr, i2, i3, i4);
    }

    public static /* synthetic */ void m(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        k(objArr, obj, i2, i3);
    }

    public static byte[] n(byte[] plus, byte[] elements) {
        kotlin.jvm.internal.m.g(plus, "$this$plus");
        kotlin.jvm.internal.m.g(elements, "elements");
        int length = plus.length;
        int length2 = elements.length;
        byte[] result = Arrays.copyOf(plus, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.m.f(result, "result");
        return result;
    }

    public static final <T> void o(T[] sort) {
        kotlin.jvm.internal.m.g(sort, "$this$sort");
        if (sort.length > 1) {
            Arrays.sort(sort);
        }
    }

    public static final <T> void p(T[] sortWith, Comparator<? super T> comparator) {
        kotlin.jvm.internal.m.g(sortWith, "$this$sortWith");
        kotlin.jvm.internal.m.g(comparator, "comparator");
        if (sortWith.length > 1) {
            Arrays.sort(sortWith, comparator);
        }
    }

    public static Byte[] q(byte[] toTypedArray) {
        kotlin.jvm.internal.m.g(toTypedArray, "$this$toTypedArray");
        Byte[] bArr = new Byte[toTypedArray.length];
        int length = toTypedArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = Byte.valueOf(toTypedArray[i2]);
        }
        return bArr;
    }
}