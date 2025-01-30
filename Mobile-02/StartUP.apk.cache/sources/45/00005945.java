package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Set;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: IntersectionType.kt */
/* loaded from: classes3.dex */
final class TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1 extends o implements a<String> {
    final /* synthetic */ Set<SimpleType> $inputTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(Set<? extends SimpleType> set) {
        super(0);
        this.$inputTypes = set;
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        String h0;
        h0 = z.h0(this.$inputTypes, null, null, null, 0, null, null, 63, null);
        return m.o("This collections cannot be empty! input types: ", h0);
    }
}