package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.a0.t0;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes3.dex */
public final class DeserializedMemberScope$classifierNamesLazy$2 extends o implements a<Set<? extends Name>> {
    final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$classifierNamesLazy$2(DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.this$0 = deserializedMemberScope;
    }

    @Override // kotlin.e0.c.a
    public final Set<? extends Name> invoke() {
        DeserializedMemberScope.Implementation implementation;
        Set h2;
        Set<? extends Name> h3;
        Set<Name> nonDeclaredClassifierNames = this.this$0.getNonDeclaredClassifierNames();
        if (nonDeclaredClassifierNames == null) {
            return null;
        }
        Set<Name> classNames$deserialization = this.this$0.getClassNames$deserialization();
        implementation = this.this$0.impl;
        h2 = t0.h(classNames$deserialization, implementation.getTypeAliasNames());
        h3 = t0.h(h2, nonDeclaredClassifierNames);
        return h3;
    }
}