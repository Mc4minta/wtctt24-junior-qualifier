package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.s;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KClassImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$typeParameters$2 extends o implements a<List<? extends KTypeParameterImpl>> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$typeParameters$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends KTypeParameterImpl> invoke() {
        int r;
        List<TypeParameterDescriptor> declaredTypeParameters = this.this$0.getDescriptor().getDeclaredTypeParameters();
        m.f(declaredTypeParameters, "descriptor.declaredTypeParameters");
        r = s.r(declaredTypeParameters, 10);
        ArrayList arrayList = new ArrayList(r);
        for (TypeParameterDescriptor descriptor : declaredTypeParameters) {
            KClassImpl kClassImpl = KClassImpl.this;
            m.f(descriptor, "descriptor");
            arrayList.add(new KTypeParameterImpl(kClassImpl, descriptor));
        }
        return arrayList;
    }
}