package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: resolvers.kt */
/* loaded from: classes3.dex */
public final class LazyJavaTypeParameterResolver$resolve$1 extends o implements l<JavaTypeParameter, LazyJavaTypeParameterDescriptor> {
    final /* synthetic */ LazyJavaTypeParameterResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaTypeParameterResolver$resolve$1(LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver) {
        super(1);
        this.this$0 = lazyJavaTypeParameterResolver;
    }

    @Override // kotlin.e0.c.l
    public final LazyJavaTypeParameterDescriptor invoke(JavaTypeParameter typeParameter) {
        Map map;
        LazyJavaResolverContext lazyJavaResolverContext;
        DeclarationDescriptor declarationDescriptor;
        int i2;
        DeclarationDescriptor declarationDescriptor2;
        m.g(typeParameter, "typeParameter");
        map = this.this$0.typeParameters;
        Integer num = (Integer) map.get(typeParameter);
        if (num == null) {
            return null;
        }
        LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = this.this$0;
        int intValue = num.intValue();
        lazyJavaResolverContext = lazyJavaTypeParameterResolver.f17394c;
        LazyJavaResolverContext child = ContextKt.child(lazyJavaResolverContext, lazyJavaTypeParameterResolver);
        declarationDescriptor = lazyJavaTypeParameterResolver.containingDeclaration;
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(child, declarationDescriptor.getAnnotations());
        i2 = lazyJavaTypeParameterResolver.typeParametersIndexOffset;
        int i3 = i2 + intValue;
        declarationDescriptor2 = lazyJavaTypeParameterResolver.containingDeclaration;
        return new LazyJavaTypeParameterDescriptor(copyWithNewDefaultTypeQualifiers, typeParameter, i3, declarationDescriptor2);
    }
}