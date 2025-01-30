package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlin.x;

/* JADX INFO: Add missing generic type declarations: [H] */
/* compiled from: overridingUtils.kt */
/* loaded from: classes3.dex */
final class OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1<H> extends o implements l<H, x> {
    final /* synthetic */ SmartSet<H> $conflictedHandles;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(SmartSet<H> smartSet) {
        super(1);
        this.$conflictedHandles = smartSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Object obj) {
        invoke2((OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1<H>) obj);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(H it) {
        SmartSet<H> smartSet = this.$conflictedHandles;
        m.f(it, "it");
        smartSet.add(it);
    }
}