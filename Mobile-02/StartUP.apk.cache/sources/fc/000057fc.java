package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: MemberScope.kt */
/* loaded from: classes3.dex */
final class MemberScope$Companion$ALL_NAME_FILTER$1 extends o implements l<Name, Boolean> {
    public static final MemberScope$Companion$ALL_NAME_FILTER$1 INSTANCE = new MemberScope$Companion$ALL_NAME_FILTER$1();

    MemberScope$Companion$ALL_NAME_FILTER$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(Name name) {
        return Boolean.valueOf(invoke2(name));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Name it) {
        m.g(it, "it");
        return true;
    }
}