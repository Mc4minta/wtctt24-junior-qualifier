package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.e0.c.a;
import kotlin.h;
import kotlin.j0.s;
import kotlin.jvm.internal.o;
import kotlin.k;
import kotlin.m;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: KTypeImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lkotlin/j0/s;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final class KTypeImpl$arguments$2 extends o implements a<List<? extends s>> {
    final /* synthetic */ a $computeJavaType;
    final /* synthetic */ KTypeImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTypeImpl$arguments$2(KTypeImpl kTypeImpl, a aVar) {
        super(0);
        this.this$0 = kTypeImpl;
        this.$computeJavaType = aVar;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends s> invoke() {
        h a;
        int r;
        s d2;
        List<? extends s> g2;
        List<TypeProjection> arguments = this.this$0.getType().getArguments();
        if (arguments.isEmpty()) {
            g2 = r.g();
            return g2;
        }
        a = k.a(m.PUBLICATION, new KTypeImpl$arguments$2$parameterizedTypeArguments$2(this));
        r = kotlin.a0.s.r(arguments, 10);
        ArrayList arrayList = new ArrayList(r);
        int i2 = 0;
        for (Object obj : arguments) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                r.q();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            if (typeProjection.isStarProjection()) {
                d2 = s.f17294b.c();
            } else {
                KotlinType type = typeProjection.getType();
                kotlin.jvm.internal.m.f(type, "typeProjection.type");
                KTypeImpl kTypeImpl = new KTypeImpl(type, this.$computeJavaType != null ? new KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(i2, this, a, null) : null);
                int i4 = KTypeImpl.WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()];
                if (i4 == 1) {
                    d2 = s.f17294b.d(kTypeImpl);
                } else if (i4 == 2) {
                    d2 = s.f17294b.a(kTypeImpl);
                } else if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    d2 = s.f17294b.b(kTypeImpl);
                }
            }
            arrayList.add(d2);
            i2 = i3;
        }
        return arrayList;
    }
}