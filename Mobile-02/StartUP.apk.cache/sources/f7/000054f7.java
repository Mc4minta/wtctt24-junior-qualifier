package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* compiled from: utils.kt */
/* loaded from: classes3.dex */
public final class EnumEntry extends JavaDefaultValue {
    private final ClassDescriptor descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumEntry(ClassDescriptor descriptor) {
        super(null);
        m.g(descriptor, "descriptor");
        this.descriptor = descriptor;
    }
}