package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* compiled from: DeserializedMemberDescriptor.kt */
/* loaded from: classes3.dex */
public interface DeserializedMemberDescriptor extends DeserializedDescriptor, MemberDescriptor, DescriptorWithContainerSource {

    /* compiled from: DeserializedMemberDescriptor.kt */
    /* loaded from: classes3.dex */
    public enum CoroutinesCompatibilityMode {
        COMPATIBLE,
        NEEDS_WRAPPER,
        INCOMPATIBLE;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static CoroutinesCompatibilityMode[] valuesCustom() {
            CoroutinesCompatibilityMode[] valuesCustom = values();
            CoroutinesCompatibilityMode[] coroutinesCompatibilityModeArr = new CoroutinesCompatibilityMode[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, coroutinesCompatibilityModeArr, 0, valuesCustom.length);
            return coroutinesCompatibilityModeArr;
        }
    }

    /* compiled from: DeserializedMemberDescriptor.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static List<VersionRequirement> getVersionRequirements(DeserializedMemberDescriptor deserializedMemberDescriptor) {
            m.g(deserializedMemberDescriptor, "this");
            return VersionRequirement.Companion.create(deserializedMemberDescriptor.getProto(), deserializedMemberDescriptor.getNameResolver(), deserializedMemberDescriptor.getVersionRequirementTable());
        }
    }

    DeserializedContainerSource getContainerSource();

    NameResolver getNameResolver();

    MessageLite getProto();

    TypeTable getTypeTable();

    VersionRequirementTable getVersionRequirementTable();

    List<VersionRequirement> getVersionRequirements();
}