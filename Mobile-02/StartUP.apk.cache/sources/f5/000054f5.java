package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* compiled from: utils.kt */
/* loaded from: classes3.dex */
public final class DeprecationCausedByFunctionN {
    private final DeclarationDescriptor target;

    public DeprecationCausedByFunctionN(DeclarationDescriptor target) {
        m.g(target, "target");
        this.target = target;
    }
}