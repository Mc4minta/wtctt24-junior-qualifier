package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: PlatformDependentTypeTransformer.kt */
/* loaded from: classes3.dex */
public interface PlatformDependentTypeTransformer {

    /* compiled from: PlatformDependentTypeTransformer.kt */
    /* loaded from: classes3.dex */
    public static final class None implements PlatformDependentTypeTransformer {
        public static final None INSTANCE = new None();

        private None() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer
        public SimpleType transformPlatformType(ClassId classId, SimpleType computedType) {
            m.g(classId, "classId");
            m.g(computedType, "computedType");
            return computedType;
        }
    }

    SimpleType transformPlatformType(ClassId classId, SimpleType simpleType);
}