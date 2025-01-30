package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: KPropertyImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "isNotNullProperty"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final class KPropertyImplKt$computeCallerForAccessor$2 extends o implements a<Boolean> {
    final /* synthetic */ KPropertyImpl.Accessor $this_computeCallerForAccessor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImplKt$computeCallerForAccessor$2(KPropertyImpl.Accessor accessor) {
        super(0);
        this.$this_computeCallerForAccessor = accessor;
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return !TypeUtils.isNullableType(this.$this_computeCallerForAccessor.getProperty().getDescriptor().getType());
    }
}