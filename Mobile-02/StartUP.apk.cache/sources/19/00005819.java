package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AnnotationAndConstantLoaderImpl.kt */
/* loaded from: classes3.dex */
public final class AnnotationAndConstantLoaderImpl implements AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    private final AnnotationDeserializer deserializer;
    private final SerializerExtensionProtocol protocol;

    /* compiled from: AnnotationAndConstantLoaderImpl.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AnnotationAndConstantLoaderImpl(ModuleDescriptor module, NotFoundClasses notFoundClasses, SerializerExtensionProtocol protocol) {
        m.g(module, "module");
        m.g(notFoundClasses, "notFoundClasses");
        m.g(protocol, "protocol");
        this.protocol = protocol;
        this.deserializer = new AnnotationDeserializer(module, notFoundClasses);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadCallableAnnotations(ProtoContainer container, MessageLite proto, AnnotatedCallableKind kind) {
        List<ProtoBuf.Annotation> list;
        int r;
        m.g(container, "container");
        m.g(proto, "proto");
        m.g(kind, "kind");
        if (proto instanceof ProtoBuf.Constructor) {
            list = (List) ((ProtoBuf.Constructor) proto).getExtension(this.protocol.getConstructorAnnotation());
        } else if (proto instanceof ProtoBuf.Function) {
            list = (List) ((ProtoBuf.Function) proto).getExtension(this.protocol.getFunctionAnnotation());
        } else if (!(proto instanceof ProtoBuf.Property)) {
            throw new IllegalStateException(m.o("Unknown message: ", proto).toString());
        } else {
            int i2 = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
            if (i2 == 1) {
                list = (List) ((ProtoBuf.Property) proto).getExtension(this.protocol.getPropertyAnnotation());
            } else if (i2 == 2) {
                list = (List) ((ProtoBuf.Property) proto).getExtension(this.protocol.getPropertyGetterAnnotation());
            } else if (i2 == 3) {
                list = (List) ((ProtoBuf.Property) proto).getExtension(this.protocol.getPropertySetterAnnotation());
            } else {
                throw new IllegalStateException("Unsupported callable kind with property proto".toString());
            }
        }
        if (list == null) {
            list = r.g();
        }
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.deserializer.deserializeAnnotation(annotation, container.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadClassAnnotations(ProtoContainer.Class container) {
        int r;
        m.g(container, "container");
        List<ProtoBuf.Annotation> list = (List) container.getClassProto().getExtension(this.protocol.getClassAnnotation());
        if (list == null) {
            list = r.g();
        }
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.deserializer.deserializeAnnotation(annotation, container.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadEnumEntryAnnotations(ProtoContainer container, ProtoBuf.EnumEntry proto) {
        int r;
        m.g(container, "container");
        m.g(proto, "proto");
        List<ProtoBuf.Annotation> list = (List) proto.getExtension(this.protocol.getEnumEntryAnnotation());
        if (list == null) {
            list = r.g();
        }
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.deserializer.deserializeAnnotation(annotation, container.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(ProtoContainer container, MessageLite proto, AnnotatedCallableKind kind) {
        List<AnnotationDescriptor> g2;
        m.g(container, "container");
        m.g(proto, "proto");
        m.g(kind, "kind");
        g2 = r.g();
        return g2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(ProtoContainer container, ProtoBuf.Property proto) {
        List<AnnotationDescriptor> g2;
        m.g(container, "container");
        m.g(proto, "proto");
        g2 = r.g();
        return g2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(ProtoContainer container, ProtoBuf.Property proto) {
        List<AnnotationDescriptor> g2;
        m.g(container, "container");
        m.g(proto, "proto");
        g2 = r.g();
        return g2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadTypeAnnotations(ProtoBuf.Type proto, NameResolver nameResolver) {
        int r;
        m.g(proto, "proto");
        m.g(nameResolver, "nameResolver");
        List<ProtoBuf.Annotation> list = (List) proto.getExtension(this.protocol.getTypeAnnotation());
        if (list == null) {
            list = r.g();
        }
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.deserializer.deserializeAnnotation(annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadTypeParameterAnnotations(ProtoBuf.TypeParameter proto, NameResolver nameResolver) {
        int r;
        m.g(proto, "proto");
        m.g(nameResolver, "nameResolver");
        List<ProtoBuf.Annotation> list = (List) proto.getExtension(this.protocol.getTypeParameterAnnotation());
        if (list == null) {
            list = r.g();
        }
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.deserializer.deserializeAnnotation(annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadValueParameterAnnotations(ProtoContainer container, MessageLite callableProto, AnnotatedCallableKind kind, int i2, ProtoBuf.ValueParameter proto) {
        int r;
        m.g(container, "container");
        m.g(callableProto, "callableProto");
        m.g(kind, "kind");
        m.g(proto, "proto");
        List<ProtoBuf.Annotation> list = (List) proto.getExtension(this.protocol.getParameterAnnotation());
        if (list == null) {
            list = r.g();
        }
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.deserializer.deserializeAnnotation(annotation, container.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public ConstantValue<?> loadPropertyConstant(ProtoContainer container, ProtoBuf.Property proto, KotlinType expectedType) {
        m.g(container, "container");
        m.g(proto, "proto");
        m.g(expectedType, "expectedType");
        ProtoBuf.Annotation.Argument.Value value = (ProtoBuf.Annotation.Argument.Value) ProtoBufUtilKt.getExtensionOrNull(proto, this.protocol.getCompileTimeValue());
        if (value == null) {
            return null;
        }
        return this.deserializer.resolveValue(expectedType, value, container.getNameResolver());
    }
}