package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public interface Check {

    /* compiled from: modifierChecks.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static String invoke(Check check, FunctionDescriptor functionDescriptor) {
            m.g(check, "this");
            m.g(functionDescriptor, "functionDescriptor");
            if (check.check(functionDescriptor)) {
                return null;
            }
            return check.getDescription();
        }
    }

    boolean check(FunctionDescriptor functionDescriptor);

    String getDescription();

    String invoke(FunctionDescriptor functionDescriptor);
}