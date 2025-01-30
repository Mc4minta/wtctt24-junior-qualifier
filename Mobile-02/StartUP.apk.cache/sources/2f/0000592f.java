package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewCapturedType.kt */
/* loaded from: classes3.dex */
public final class NewCapturedTypeConstructor$_supertypes$2 extends o implements a<List<? extends UnwrappedType>> {
    final /* synthetic */ NewCapturedTypeConstructor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewCapturedTypeConstructor$_supertypes$2(NewCapturedTypeConstructor newCapturedTypeConstructor) {
        super(0);
        this.this$0 = newCapturedTypeConstructor;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends UnwrappedType> invoke() {
        a aVar;
        aVar = this.this$0.supertypesComputation;
        if (aVar == null) {
            return null;
        }
        return (List) aVar.invoke();
    }
}