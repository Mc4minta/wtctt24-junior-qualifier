package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a0.l0;
import kotlin.a0.s;
import kotlin.e0.c.a;
import kotlin.i0.f;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes3.dex */
public final class DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2 extends o implements a<Map<Name, ? extends TypeAliasDescriptor>> {
    final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.this$0 = noReorderImplementation;
    }

    @Override // kotlin.e0.c.a
    public final Map<Name, ? extends TypeAliasDescriptor> invoke() {
        List allTypeAliases;
        int r;
        int d2;
        int b2;
        allTypeAliases = this.this$0.getAllTypeAliases();
        r = s.r(allTypeAliases, 10);
        d2 = l0.d(r);
        b2 = f.b(d2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
        for (Object obj : allTypeAliases) {
            Name name = ((TypeAliasDescriptor) obj).getName();
            m.f(name, "it.name");
            linkedHashMap.put(name, obj);
        }
        return linkedHashMap;
    }
}