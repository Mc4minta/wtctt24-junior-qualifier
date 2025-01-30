package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.s;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KTypeParameterImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KTypeParameterImpl$upperBounds$2 extends o implements a<List<? extends KTypeImpl>> {
    final /* synthetic */ KTypeParameterImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTypeParameterImpl$upperBounds$2(KTypeParameterImpl kTypeParameterImpl) {
        super(0);
        this.this$0 = kTypeParameterImpl;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends KTypeImpl> invoke() {
        int r;
        List<KotlinType> upperBounds = this.this$0.getDescriptor().getUpperBounds();
        m.f(upperBounds, "descriptor.upperBounds");
        r = s.r(upperBounds, 10);
        ArrayList arrayList = new ArrayList(r);
        for (KotlinType kotlinType : upperBounds) {
            arrayList.add(new KTypeImpl(kotlinType, null, 2, null));
        }
        return arrayList;
    }
}