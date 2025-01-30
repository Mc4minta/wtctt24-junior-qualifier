package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Set;
import kotlin.a0.r0;
import kotlin.a0.s0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;

/* compiled from: DeserializedDescriptorResolver.kt */
/* loaded from: classes3.dex */
public final class DeserializedDescriptorResolver {
    public static final Companion Companion = new Companion(null);
    private static final JvmMetadataVersion KOTLIN_1_1_EAP_METADATA_VERSION;
    private static final JvmMetadataVersion KOTLIN_1_3_M1_METADATA_VERSION;
    private static final JvmMetadataVersion KOTLIN_1_3_RC_METADATA_VERSION;
    private static final Set<KotlinClassHeader.Kind> KOTLIN_CLASS;
    private static final Set<KotlinClassHeader.Kind> KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART;
    public DeserializationComponents components;

    /* compiled from: DeserializedDescriptorResolver.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JvmMetadataVersion getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return DeserializedDescriptorResolver.KOTLIN_1_3_RC_METADATA_VERSION;
        }

        public final Set<KotlinClassHeader.Kind> getKOTLIN_CLASS$descriptors_jvm() {
            return DeserializedDescriptorResolver.KOTLIN_CLASS;
        }
    }

    static {
        Set<KotlinClassHeader.Kind> a;
        Set<KotlinClassHeader.Kind> e2;
        a = r0.a(KotlinClassHeader.Kind.CLASS);
        KOTLIN_CLASS = a;
        e2 = s0.e(KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = e2;
        KOTLIN_1_1_EAP_METADATA_VERSION = new JvmMetadataVersion(1, 1, 2);
        KOTLIN_1_3_M1_METADATA_VERSION = new JvmMetadataVersion(1, 1, 11);
        KOTLIN_1_3_RC_METADATA_VERSION = new JvmMetadataVersion(1, 1, 13);
    }

    private final DeserializedContainerAbiStability getAbiStability(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        return getComponents().getConfiguration().getAllowUnstableDependencies() ? DeserializedContainerAbiStability.STABLE : kotlinJvmBinaryClass.getClassHeader().isUnstableFirBinary() ? DeserializedContainerAbiStability.FIR_UNSTABLE : kotlinJvmBinaryClass.getClassHeader().isUnstableJvmIrBinary() ? DeserializedContainerAbiStability.IR_UNSTABLE : DeserializedContainerAbiStability.STABLE;
    }

    private final IncompatibleVersionErrorData<JvmMetadataVersion> getIncompatibility(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (getSkipMetadataVersionCheck() || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
            return null;
        }
        return new IncompatibleVersionErrorData<>(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), JvmMetadataVersion.INSTANCE, kotlinJvmBinaryClass.getLocation(), kotlinJvmBinaryClass.getClassId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getSkipMetadataVersionCheck() {
        return getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    private final boolean isCompiledWith13M1(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        return !getComponents().getConfiguration().getSkipPrereleaseCheck() && kotlinJvmBinaryClass.getClassHeader().isPreRelease() && m.c(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), KOTLIN_1_3_M1_METADATA_VERSION);
    }

    private final boolean isPreReleaseInvisible(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        return (getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() && (kotlinJvmBinaryClass.getClassHeader().isPreRelease() || m.c(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), KOTLIN_1_1_EAP_METADATA_VERSION))) || isCompiledWith13M1(kotlinJvmBinaryClass);
    }

    private final String[] readData(KotlinJvmBinaryClass kotlinJvmBinaryClass, Set<? extends KotlinClassHeader.Kind> set) {
        KotlinClassHeader classHeader = kotlinJvmBinaryClass.getClassHeader();
        String[] data = classHeader.getData();
        if (data == null) {
            data = classHeader.getIncompatibleData();
        }
        if (data != null && set.contains(classHeader.getKind())) {
            return data;
        }
        return null;
    }

    public final MemberScope createKotlinPackagePartScope(PackageFragmentDescriptor descriptor, KotlinJvmBinaryClass kotlinClass) {
        String[] strings;
        o<JvmNameResolver, ProtoBuf.Package> oVar;
        m.g(descriptor, "descriptor");
        m.g(kotlinClass, "kotlinClass");
        String[] readData = readData(kotlinClass, KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART);
        if (readData == null || (strings = kotlinClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
                oVar = JvmProtoBufUtil.readPackageDataFrom(readData, strings);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException(m.o("Could not read data from ", kotlinClass.getLocation()), e2);
            }
        } catch (Throwable th) {
            if (getSkipMetadataVersionCheck() || kotlinClass.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th;
            }
            oVar = null;
        }
        if (oVar == null) {
            return null;
        }
        JvmNameResolver a = oVar.a();
        ProtoBuf.Package b2 = oVar.b();
        return new DeserializedPackageMemberScope(descriptor, b2, a, kotlinClass.getClassHeader().getMetadataVersion(), new JvmPackagePartSource(kotlinClass, b2, a, getIncompatibility(kotlinClass), isPreReleaseInvisible(kotlinClass), getAbiStability(kotlinClass)), getComponents(), DeserializedDescriptorResolver$createKotlinPackagePartScope$2.INSTANCE);
    }

    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        m.w("components");
        throw null;
    }

    public final ClassData readClassData$descriptors_jvm(KotlinJvmBinaryClass kotlinClass) {
        String[] strings;
        o<JvmNameResolver, ProtoBuf.Class> oVar;
        m.g(kotlinClass, "kotlinClass");
        String[] readData = readData(kotlinClass, Companion.getKOTLIN_CLASS$descriptors_jvm());
        if (readData == null || (strings = kotlinClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
                oVar = JvmProtoBufUtil.readClassDataFrom(readData, strings);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException(m.o("Could not read data from ", kotlinClass.getLocation()), e2);
            }
        } catch (Throwable th) {
            if (getSkipMetadataVersionCheck() || kotlinClass.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th;
            }
            oVar = null;
        }
        if (oVar == null) {
            return null;
        }
        return new ClassData(oVar.a(), oVar.b(), kotlinClass.getClassHeader().getMetadataVersion(), new KotlinJvmBinarySourceElement(kotlinClass, getIncompatibility(kotlinClass), isPreReleaseInvisible(kotlinClass), getAbiStability(kotlinClass)));
    }

    public final ClassDescriptor resolveClass(KotlinJvmBinaryClass kotlinClass) {
        m.g(kotlinClass, "kotlinClass");
        ClassData readClassData$descriptors_jvm = readClassData$descriptors_jvm(kotlinClass);
        if (readClassData$descriptors_jvm == null) {
            return null;
        }
        return getComponents().getClassDeserializer().deserializeClass(kotlinClass.getClassId(), readClassData$descriptors_jvm);
    }

    public final void setComponents(DeserializationComponents deserializationComponents) {
        m.g(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    public final void setComponents(DeserializationComponentsForJava components) {
        m.g(components, "components");
        setComponents(components.getComponents());
    }
}