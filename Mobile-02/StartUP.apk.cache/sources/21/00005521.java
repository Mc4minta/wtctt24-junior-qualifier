package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.j0.m;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes3.dex */
public final class JavaDeprecatedAnnotationDescriptor extends JavaAnnotationDescriptor {
    static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(JavaDeprecatedAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final NotNullLazyValue allValueArguments$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaDeprecatedAnnotationDescriptor(JavaAnnotation javaAnnotation, LazyJavaResolverContext c2) {
        super(c2, javaAnnotation, StandardNames.FqNames.deprecated);
        kotlin.jvm.internal.m.g(c2, "c");
        this.allValueArguments$delegate = c2.getStorageManager().createLazyValue(JavaDeprecatedAnnotationDescriptor$allValueArguments$2.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return (Map) StorageKt.getValue(this.allValueArguments$delegate, this, $$delegatedProperties[0]);
    }
}