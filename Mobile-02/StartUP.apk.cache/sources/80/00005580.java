package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaScope.kt */
/* loaded from: classes3.dex */
public final class LazyJavaScope$declaredFunctions$1 extends o implements l<Name, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$declaredFunctions$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.this$0 = lazyJavaScope;
    }

    @Override // kotlin.e0.c.l
    public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
        MemoizedFunctionToNotNull memoizedFunctionToNotNull;
        m.g(name, "name");
        if (this.this$0.getMainScope() != null) {
            memoizedFunctionToNotNull = this.this$0.getMainScope().declaredFunctions;
            return (Collection) memoizedFunctionToNotNull.invoke(name);
        }
        ArrayList arrayList = new ArrayList();
        for (JavaMethod javaMethod : ((DeclaredMemberIndex) this.this$0.getDeclaredMemberIndex().invoke()).findMethodsByName(name)) {
            JavaMethodDescriptor resolveMethodToFunctionDescriptor = this.this$0.resolveMethodToFunctionDescriptor(javaMethod);
            if (this.this$0.isVisibleAsFunction(resolveMethodToFunctionDescriptor)) {
                this.this$0.getC().getComponents().getJavaResolverCache().recordMethod(javaMethod, resolveMethodToFunctionDescriptor);
                arrayList.add(resolveMethodToFunctionDescriptor);
            }
        }
        this.this$0.computeImplicitlyDeclaredFunctions(arrayList, name);
        return arrayList;
    }
}