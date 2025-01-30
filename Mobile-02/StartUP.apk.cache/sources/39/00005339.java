package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KTypeImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/lang/reflect/Type;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KTypeImpl$arguments$2$parameterizedTypeArguments$2 extends o implements a<List<? extends Type>> {
    final /* synthetic */ KTypeImpl$arguments$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTypeImpl$arguments$2$parameterizedTypeArguments$2(KTypeImpl$arguments$2 kTypeImpl$arguments$2) {
        super(0);
        this.this$0 = kTypeImpl$arguments$2;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends Type> invoke() {
        Type javaType = this.this$0.this$0.getJavaType();
        m.e(javaType);
        return ReflectClassUtilKt.getParameterizedTypeArguments(javaType);
    }
}