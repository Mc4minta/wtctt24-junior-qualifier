package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.j0.d;
import kotlin.j0.g;
import kotlin.j0.o;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* compiled from: KClasses.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final <T> Collection<o<T, ?>> a(d<T> memberProperties) {
        m.g(memberProperties, "$this$memberProperties");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl) memberProperties).getData().invoke().getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (d(kCallableImpl) && (kCallableImpl instanceof o)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> g<T> b(d<T> primaryConstructor) {
        T t;
        m.g(primaryConstructor, "$this$primaryConstructor");
        Iterator<T> it = ((KClassImpl) primaryConstructor).getConstructors().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            g gVar = (g) t;
            Objects.requireNonNull(gVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
            FunctionDescriptor descriptor = ((KFunctionImpl) gVar).getDescriptor();
            Objects.requireNonNull(descriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
            if (((ConstructorDescriptor) descriptor).isPrimary()) {
                break;
            }
        }
        return (g) t;
    }

    private static final boolean c(KCallableImpl<?> kCallableImpl) {
        return kCallableImpl.getDescriptor().getExtensionReceiverParameter() != null;
    }

    private static final boolean d(KCallableImpl<?> kCallableImpl) {
        return !c(kCallableImpl);
    }
}