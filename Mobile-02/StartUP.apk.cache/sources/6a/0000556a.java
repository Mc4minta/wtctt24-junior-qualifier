package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope$nestedClassIndex$1 extends o implements a<Set<? extends Name>> {
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$nestedClassIndex$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
    }

    @Override // kotlin.e0.c.a
    public final Set<? extends Name> invoke() {
        JavaClass javaClass;
        Set<? extends Name> M0;
        javaClass = this.this$0.jClass;
        M0 = z.M0(javaClass.getInnerClassNames());
        return M0;
    }
}