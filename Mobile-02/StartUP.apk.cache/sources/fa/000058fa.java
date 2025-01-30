package kotlin.reflect.jvm.internal.impl.types;

import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StarProjectionImpl.kt */
/* loaded from: classes3.dex */
public final class StarProjectionImpl$_type$2 extends o implements a<KotlinType> {
    final /* synthetic */ StarProjectionImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarProjectionImpl$_type$2(StarProjectionImpl starProjectionImpl) {
        super(0);
        this.this$0 = starProjectionImpl;
    }

    @Override // kotlin.e0.c.a
    public final KotlinType invoke() {
        TypeParameterDescriptor typeParameterDescriptor;
        typeParameterDescriptor = this.this$0.typeParameter;
        return StarProjectionImplKt.starProjectionType(typeParameterDescriptor);
    }
}