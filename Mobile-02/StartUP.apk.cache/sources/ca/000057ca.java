package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntegerLiteralTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class IntegerLiteralTypeConstructor$supertypes$2 extends o implements a<List<SimpleType>> {
    final /* synthetic */ IntegerLiteralTypeConstructor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntegerLiteralTypeConstructor$supertypes$2(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        super(0);
        this.this$0 = integerLiteralTypeConstructor;
    }

    @Override // kotlin.e0.c.a
    public final List<SimpleType> invoke() {
        SimpleType simpleType;
        List b2;
        List<SimpleType> m;
        boolean isContainsOnlyUnsignedTypes;
        SimpleType defaultType = this.this$0.getBuiltIns().getComparable().getDefaultType();
        m.f(defaultType, "builtIns.comparable.defaultType");
        Variance variance = Variance.IN_VARIANCE;
        simpleType = this.this$0.type;
        b2 = q.b(new TypeProjectionImpl(variance, simpleType));
        m = r.m(TypeSubstitutionKt.replace$default(defaultType, b2, null, 2, null));
        isContainsOnlyUnsignedTypes = this.this$0.isContainsOnlyUnsignedTypes();
        if (!isContainsOnlyUnsignedTypes) {
            m.add(this.this$0.getBuiltIns().getNumberType());
        }
        return m;
    }
}