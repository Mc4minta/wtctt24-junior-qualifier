package kotlin.a0;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReversedViews.kt */
/* loaded from: classes3.dex */
public class x extends w {
    public static <T> List<T> H(List<T> asReversed) {
        kotlin.jvm.internal.m.g(asReversed, "$this$asReversed");
        return new o0(asReversed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int I(List<?> list, int i2) {
        int i3;
        int i4;
        int i5;
        i3 = r.i(list);
        if (i2 >= 0 && i3 >= i2) {
            i5 = r.i(list);
            return i5 - i2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Element index ");
        sb.append(i2);
        sb.append(" must be in range [");
        i4 = r.i(list);
        sb.append(new kotlin.i0.c(0, i4));
        sb.append("].");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int J(List<?> list, int i2) {
        int size = list.size();
        if (i2 < 0 || size < i2) {
            throw new IndexOutOfBoundsException("Position index " + i2 + " must be in range [" + new kotlin.i0.c(0, list.size()) + "].");
        }
        return list.size() - i2;
    }
}