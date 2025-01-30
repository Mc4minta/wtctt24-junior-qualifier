package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PrimitiveType.kt */
/* loaded from: classes3.dex */
final class PrimitiveType$arrayTypeFqName$2 extends o implements a<FqName> {
    final /* synthetic */ PrimitiveType this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimitiveType$arrayTypeFqName$2(PrimitiveType primitiveType) {
        super(0);
        this.this$0 = primitiveType;
    }

    @Override // kotlin.e0.c.a
    public final FqName invoke() {
        FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(this.this$0.getArrayTypeName());
        m.f(child, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
        return child;
    }
}