package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewCapturedType.kt */
/* loaded from: classes3.dex */
final class NewCapturedTypeConstructor$initializeSupertypes$2 extends o implements a<List<? extends UnwrappedType>> {
    final /* synthetic */ List<UnwrappedType> $supertypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NewCapturedTypeConstructor$initializeSupertypes$2(List<? extends UnwrappedType> list) {
        super(0);
        this.$supertypes = list;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends UnwrappedType> invoke() {
        return this.$supertypes;
    }
}