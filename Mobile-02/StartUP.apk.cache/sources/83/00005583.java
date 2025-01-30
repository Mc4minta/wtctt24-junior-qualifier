package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaScope.kt */
/* loaded from: classes3.dex */
public final class LazyJavaScope$functions$1 extends o implements l<Name, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$functions$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.this$0 = lazyJavaScope;
    }

    @Override // kotlin.e0.c.l
    public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
        MemoizedFunctionToNotNull memoizedFunctionToNotNull;
        List I0;
        m.g(name, "name");
        memoizedFunctionToNotNull = this.this$0.declaredFunctions;
        LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) memoizedFunctionToNotNull.invoke(name));
        this.this$0.retainMostSpecificMethods(linkedHashSet);
        this.this$0.computeNonDeclaredFunctions(linkedHashSet, name);
        I0 = z.I0(this.this$0.getC().getComponents().getSignatureEnhancement().enhanceSignatures(this.this$0.getC(), linkedHashSet));
        return I0;
    }
}