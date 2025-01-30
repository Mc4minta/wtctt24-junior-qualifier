package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.j;
import kotlin.e0.c.a;
import kotlin.h;
import kotlin.j0.m;
import kotlin.jvm.internal.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KTypeImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Ljava/lang/reflect/Type;", "invoke", "()Ljava/lang/reflect/Type;", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1", "<no name provided>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 extends o implements a<Type> {
    final /* synthetic */ int $i;
    final /* synthetic */ h $parameterizedTypeArguments$inlined;
    final /* synthetic */ m $parameterizedTypeArguments$metadata$inlined;
    final /* synthetic */ KTypeImpl$arguments$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(int i2, KTypeImpl$arguments$2 kTypeImpl$arguments$2, h hVar, m mVar) {
        super(0);
        this.$i = i2;
        this.this$0 = kTypeImpl$arguments$2;
        this.$parameterizedTypeArguments$inlined = hVar;
        this.$parameterizedTypeArguments$metadata$inlined = mVar;
    }

    @Override // kotlin.e0.c.a
    public final Type invoke() {
        Type javaType = this.this$0.this$0.getJavaType();
        if (javaType instanceof Class) {
            Class cls = (Class) javaType;
            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            kotlin.jvm.internal.m.f(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
            return componentType;
        } else if (javaType instanceof GenericArrayType) {
            if (this.$i == 0) {
                Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                kotlin.jvm.internal.m.f(genericComponentType, "javaType.genericComponentType");
                return genericComponentType;
            }
            throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + this.this$0.this$0);
        } else if (javaType instanceof ParameterizedType) {
            Type type = (Type) ((List) this.$parameterizedTypeArguments$inlined.getValue()).get(this.$i);
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                kotlin.jvm.internal.m.f(lowerBounds, "argument.lowerBounds");
                Type type2 = (Type) j.z(lowerBounds);
                if (type2 != null) {
                    type = type2;
                } else {
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    kotlin.jvm.internal.m.f(upperBounds, "argument.upperBounds");
                    type = (Type) j.y(upperBounds);
                }
            }
            kotlin.jvm.internal.m.f(type, "if (argument !is Wildcar…ument.upperBounds.first()");
            return type;
        } else {
            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + this.this$0.this$0);
        }
    }
}