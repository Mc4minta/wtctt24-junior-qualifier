package kotlin.a0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterables.kt */
/* loaded from: classes3.dex */
public class s extends r {
    public static <T> int r(Iterable<? extends T> collectionSizeOrDefault, int i2) {
        kotlin.jvm.internal.m.g(collectionSizeOrDefault, "$this$collectionSizeOrDefault");
        return collectionSizeOrDefault instanceof Collection ? ((Collection) collectionSizeOrDefault).size() : i2;
    }

    public static final <T> Integer s(Iterable<? extends T> collectionSizeOrNull) {
        kotlin.jvm.internal.m.g(collectionSizeOrNull, "$this$collectionSizeOrNull");
        if (collectionSizeOrNull instanceof Collection) {
            return Integer.valueOf(((Collection) collectionSizeOrNull).size());
        }
        return null;
    }

    public static final <T> Collection<T> t(Iterable<? extends T> convertToSetForSetOperationWith, Iterable<? extends T> source) {
        kotlin.jvm.internal.m.g(convertToSetForSetOperationWith, "$this$convertToSetForSetOperationWith");
        kotlin.jvm.internal.m.g(source, "source");
        if (convertToSetForSetOperationWith instanceof Set) {
            return (Collection) convertToSetForSetOperationWith;
        }
        if (convertToSetForSetOperationWith instanceof Collection) {
            if (!(source instanceof Collection) || ((Collection) source).size() >= 2) {
                Collection<T> collection = (Collection) convertToSetForSetOperationWith;
                return v(collection) ? z.G0(convertToSetForSetOperationWith) : collection;
            }
            return (Collection) convertToSetForSetOperationWith;
        }
        return z.G0(convertToSetForSetOperationWith);
    }

    public static <T> List<T> u(Iterable<? extends Iterable<? extends T>> flatten) {
        kotlin.jvm.internal.m.g(flatten, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        for (Iterable<? extends T> iterable : flatten) {
            p.y(arrayList, iterable);
        }
        return arrayList;
    }

    private static final <T> boolean v(Collection<? extends T> collection) {
        return collection.size() > 2 && (collection instanceof ArrayList);
    }
}