package kotlin.reflect.jvm.internal.impl.types;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: KotlinTypeFactory.kt */
/* loaded from: classes3.dex */
final class KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1 extends o implements l {
    public static final KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1 INSTANCE = new KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1();

    KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final Void invoke(KotlinTypeRefiner noName_0) {
        m.g(noName_0, "$noName_0");
        return null;
    }
}