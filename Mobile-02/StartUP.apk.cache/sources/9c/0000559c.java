package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: RawType.kt */
/* loaded from: classes3.dex */
final class RawTypeImpl$render$newArgs$1 extends o implements l<String, CharSequence> {
    public static final RawTypeImpl$render$newArgs$1 INSTANCE = new RawTypeImpl$render$newArgs$1();

    RawTypeImpl$render$newArgs$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final CharSequence invoke(String it) {
        m.g(it, "it");
        return m.o("(raw) ", it);
    }
}