package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Map;
import java.util.Set;
import kotlin.a0.t0;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes3.dex */
public final class DeserializedMemberScope$OptimizedImplementation$variableNames$2 extends o implements a<Set<? extends Name>> {
    final /* synthetic */ DeserializedMemberScope.OptimizedImplementation this$0;
    final /* synthetic */ DeserializedMemberScope this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$OptimizedImplementation$variableNames$2(DeserializedMemberScope.OptimizedImplementation optimizedImplementation, DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.this$0 = optimizedImplementation;
        this.this$1 = deserializedMemberScope;
    }

    @Override // kotlin.e0.c.a
    public final Set<? extends Name> invoke() {
        Map map;
        Set<? extends Name> h2;
        map = this.this$0.propertyProtosBytes;
        h2 = t0.h(map.keySet(), this.this$1.getNonDeclaredVariableNames());
        return h2;
    }
}