package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BuiltInAnnotationDescriptor.kt */
/* loaded from: classes3.dex */
public final class BuiltInAnnotationDescriptor$type$2 extends o implements a<SimpleType> {
    final /* synthetic */ BuiltInAnnotationDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuiltInAnnotationDescriptor$type$2(BuiltInAnnotationDescriptor builtInAnnotationDescriptor) {
        super(0);
        this.this$0 = builtInAnnotationDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final SimpleType invoke() {
        KotlinBuiltIns kotlinBuiltIns;
        kotlinBuiltIns = this.this$0.builtIns;
        return kotlinBuiltIns.getBuiltInClassByFqName(this.this$0.getFqName()).getDefaultType();
    }
}