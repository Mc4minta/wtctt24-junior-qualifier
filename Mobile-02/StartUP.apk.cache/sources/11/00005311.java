package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;

/* compiled from: KPackageImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001 \u0002*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/Collection;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final class KPackageImpl$Data$members$2 extends o implements a<Collection<? extends KCallableImpl<?>>> {
    final /* synthetic */ KPackageImpl.Data this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPackageImpl$Data$members$2(KPackageImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // kotlin.e0.c.a
    public final Collection<? extends KCallableImpl<?>> invoke() {
        KPackageImpl.Data data = this.this$0;
        return KPackageImpl.this.getMembers(data.getScope(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
    }
}