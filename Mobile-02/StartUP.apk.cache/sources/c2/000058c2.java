package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.a0.q;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;

/* compiled from: AbstractTypeConstructor.kt */
/* loaded from: classes3.dex */
final class AbstractTypeConstructor$supertypes$2 extends o implements l<Boolean, AbstractTypeConstructor.Supertypes> {
    public static final AbstractTypeConstructor$supertypes$2 INSTANCE = new AbstractTypeConstructor$supertypes$2();

    AbstractTypeConstructor$supertypes$2() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ AbstractTypeConstructor.Supertypes invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }

    public final AbstractTypeConstructor.Supertypes invoke(boolean z) {
        List b2;
        b2 = q.b(ErrorUtils.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES);
        return new AbstractTypeConstructor.Supertypes(b2);
    }
}