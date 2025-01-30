package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionSpecificBehaviorKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.apache.http.message.TokenParser;

/* compiled from: context.kt */
/* loaded from: classes3.dex */
public final class DeserializationContext {
    private final DeserializationComponents components;
    private final DeserializedContainerSource containerSource;
    private final DeclarationDescriptor containingDeclaration;
    private final MemberDeserializer memberDeserializer;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;
    private final TypeDeserializer typeDeserializer;
    private final TypeTable typeTable;
    private final VersionRequirementTable versionRequirementTable;

    public DeserializationContext(DeserializationComponents components, NameResolver nameResolver, DeclarationDescriptor containingDeclaration, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion metadataVersion, DeserializedContainerSource deserializedContainerSource, TypeDeserializer typeDeserializer, List<ProtoBuf.TypeParameter> typeParameters) {
        String presentableString;
        m.g(components, "components");
        m.g(nameResolver, "nameResolver");
        m.g(containingDeclaration, "containingDeclaration");
        m.g(typeTable, "typeTable");
        m.g(versionRequirementTable, "versionRequirementTable");
        m.g(metadataVersion, "metadataVersion");
        m.g(typeParameters, "typeParameters");
        this.components = components;
        this.nameResolver = nameResolver;
        this.containingDeclaration = containingDeclaration;
        this.typeTable = typeTable;
        this.versionRequirementTable = versionRequirementTable;
        this.metadataVersion = metadataVersion;
        this.containerSource = deserializedContainerSource;
        this.typeDeserializer = new TypeDeserializer(this, typeDeserializer, typeParameters, "Deserializer for \"" + containingDeclaration.getName() + TokenParser.DQUOTE, (deserializedContainerSource == null || (presentableString = deserializedContainerSource.getPresentableString()) == null) ? "[container not found]" : presentableString, false, 32, null);
        this.memberDeserializer = new MemberDeserializer(this);
    }

    public static /* synthetic */ DeserializationContext childContext$default(DeserializationContext deserializationContext, DeclarationDescriptor declarationDescriptor, List list, NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion binaryVersion, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            nameResolver = deserializationContext.nameResolver;
        }
        NameResolver nameResolver2 = nameResolver;
        if ((i2 & 8) != 0) {
            typeTable = deserializationContext.typeTable;
        }
        TypeTable typeTable2 = typeTable;
        if ((i2 & 16) != 0) {
            versionRequirementTable = deserializationContext.versionRequirementTable;
        }
        VersionRequirementTable versionRequirementTable2 = versionRequirementTable;
        if ((i2 & 32) != 0) {
            binaryVersion = deserializationContext.metadataVersion;
        }
        return deserializationContext.childContext(declarationDescriptor, list, nameResolver2, typeTable2, versionRequirementTable2, binaryVersion);
    }

    public final DeserializationContext childContext(DeclarationDescriptor descriptor, List<ProtoBuf.TypeParameter> typeParameterProtos, NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion metadataVersion) {
        m.g(descriptor, "descriptor");
        m.g(typeParameterProtos, "typeParameterProtos");
        m.g(nameResolver, "nameResolver");
        m.g(typeTable, "typeTable");
        VersionRequirementTable versionRequirementTable2 = versionRequirementTable;
        m.g(versionRequirementTable2, "versionRequirementTable");
        m.g(metadataVersion, "metadataVersion");
        DeserializationComponents deserializationComponents = this.components;
        if (!VersionSpecificBehaviorKt.isVersionRequirementTableWrittenCorrectly(metadataVersion)) {
            versionRequirementTable2 = this.versionRequirementTable;
        }
        return new DeserializationContext(deserializationComponents, nameResolver, descriptor, typeTable, versionRequirementTable2, metadataVersion, this.containerSource, this.typeDeserializer, typeParameterProtos);
    }

    public final DeserializationComponents getComponents() {
        return this.components;
    }

    public final DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    public final DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    public final MemberDeserializer getMemberDeserializer() {
        return this.memberDeserializer;
    }

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final StorageManager getStorageManager() {
        return this.components.getStorageManager();
    }

    public final TypeDeserializer getTypeDeserializer() {
        return this.typeDeserializer;
    }

    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    public final VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }
}