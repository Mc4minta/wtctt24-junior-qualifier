package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* compiled from: OverridingStrategy.kt */
/* loaded from: classes3.dex */
public abstract class NonReportingOverrideStrategy extends OverridingStrategy {
    protected abstract void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void inheritanceConflict(CallableMemberDescriptor first, CallableMemberDescriptor second) {
        m.g(first, "first");
        m.g(second, "second");
        conflict(first, second);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void overrideConflict(CallableMemberDescriptor fromSuper, CallableMemberDescriptor fromCurrent) {
        m.g(fromSuper, "fromSuper");
        m.g(fromCurrent, "fromCurrent");
        conflict(fromSuper, fromCurrent);
    }
}