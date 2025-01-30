package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes3.dex */
final class DeserializedMemberScope$classNames$2 extends o implements a<Set<? extends Name>> {
    final /* synthetic */ a<Collection<Name>> $classNames;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DeserializedMemberScope$classNames$2(a<? extends Collection<Name>> aVar) {
        super(0);
        this.$classNames = aVar;
    }

    @Override // kotlin.e0.c.a
    public final Set<? extends Name> invoke() {
        Set<? extends Name> M0;
        M0 = z.M0(this.$classNames.invoke());
        return M0;
    }
}