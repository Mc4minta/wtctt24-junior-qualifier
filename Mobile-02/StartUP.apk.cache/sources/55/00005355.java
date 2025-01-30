package kotlin.reflect.jvm.internal.calls;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.e0.a;
import kotlin.e0.c.l;
import kotlin.j0.d;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: AnnotationConstructorCaller.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "other", "", "invoke", "(Ljava/lang/Object;)Z", "equals"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final class AnnotationConstructorCallerKt$createAnnotationInstance$2 extends o implements l<Object, Boolean> {
    final /* synthetic */ Class $annotationClass;
    final /* synthetic */ List $methods;
    final /* synthetic */ Map $values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationConstructorCallerKt$createAnnotationInstance$2(Class cls, List list, Map map) {
        super(1);
        this.$annotationClass = cls;
        this.$methods = list;
        this.$values = map;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2(obj));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Object obj) {
        boolean c2;
        boolean z;
        d a;
        Class cls = null;
        Annotation annotation = (Annotation) (!(obj instanceof Annotation) ? null : obj);
        if (annotation != null && (a = a.a(annotation)) != null) {
            cls = a.b(a);
        }
        if (m.c(cls, this.$annotationClass)) {
            List<Method> list = this.$methods;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (Method method : list) {
                    Object obj2 = this.$values.get(method.getName());
                    Object invoke = method.invoke(obj, new Object[0]);
                    if (obj2 instanceof boolean[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                        c2 = Arrays.equals((boolean[]) obj2, (boolean[]) invoke);
                        continue;
                    } else if (obj2 instanceof char[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.CharArray");
                        c2 = Arrays.equals((char[]) obj2, (char[]) invoke);
                        continue;
                    } else if (obj2 instanceof byte[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.ByteArray");
                        c2 = Arrays.equals((byte[]) obj2, (byte[]) invoke);
                        continue;
                    } else if (obj2 instanceof short[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.ShortArray");
                        c2 = Arrays.equals((short[]) obj2, (short[]) invoke);
                        continue;
                    } else if (obj2 instanceof int[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.IntArray");
                        c2 = Arrays.equals((int[]) obj2, (int[]) invoke);
                        continue;
                    } else if (obj2 instanceof float[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.FloatArray");
                        c2 = Arrays.equals((float[]) obj2, (float[]) invoke);
                        continue;
                    } else if (obj2 instanceof long[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.LongArray");
                        c2 = Arrays.equals((long[]) obj2, (long[]) invoke);
                        continue;
                    } else if (obj2 instanceof double[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                        c2 = Arrays.equals((double[]) obj2, (double[]) invoke);
                        continue;
                    } else if (obj2 instanceof Object[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
                        c2 = Arrays.equals((Object[]) obj2, (Object[]) invoke);
                        continue;
                    } else {
                        c2 = m.c(obj2, invoke);
                        continue;
                    }
                    if (!c2) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }
}