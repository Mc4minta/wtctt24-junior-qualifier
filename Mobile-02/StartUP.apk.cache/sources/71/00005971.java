package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.CheckResult;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public abstract class AbstractModifierChecks {
    public final CheckResult check(FunctionDescriptor functionDescriptor) {
        m.g(functionDescriptor, "functionDescriptor");
        for (Checks checks : getChecks$descriptors()) {
            if (checks.isApplicable(functionDescriptor)) {
                return checks.checkAll(functionDescriptor);
            }
        }
        return CheckResult.IllegalFunctionName.INSTANCE;
    }

    public abstract List<Checks> getChecks$descriptors();
}