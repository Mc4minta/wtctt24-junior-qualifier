package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ConstantValueFactory.kt */
/* loaded from: classes3.dex */
final class ConstantValueFactory$createArrayValue$1 extends o implements l<ModuleDescriptor, KotlinType> {
    final /* synthetic */ KotlinType $type;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstantValueFactory$createArrayValue$1(KotlinType kotlinType) {
        super(1);
        this.$type = kotlinType;
    }

    @Override // kotlin.e0.c.l
    public final KotlinType invoke(ModuleDescriptor it) {
        m.g(it, "it");
        return this.$type;
    }
}