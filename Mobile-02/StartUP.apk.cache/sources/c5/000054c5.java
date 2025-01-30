package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes3.dex */
final class ReflectJavaClass$innerClassNames$2 extends o implements l<Class<?>, Name> {
    public static final ReflectJavaClass$innerClassNames$2 INSTANCE = new ReflectJavaClass$innerClassNames$2();

    ReflectJavaClass$innerClassNames$2() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final Name invoke(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        if (!Name.isValidIdentifier(simpleName)) {
            simpleName = null;
        }
        if (simpleName == null) {
            return null;
        }
        return Name.identifier(simpleName);
    }
}