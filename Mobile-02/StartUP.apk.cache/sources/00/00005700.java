package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* compiled from: JvmProtoBufUtil.kt */
/* loaded from: classes3.dex */
public final class JvmProtoBufUtil {
    private static final ExtensionRegistryLite EXTENSION_REGISTRY;
    public static final JvmProtoBufUtil INSTANCE = new JvmProtoBufUtil();

    static {
        ExtensionRegistryLite newInstance = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(newInstance);
        m.f(newInstance, "newInstance().apply(JvmProtoBuf::registerAllExtensions)");
        EXTENSION_REGISTRY = newInstance;
    }

    private JvmProtoBufUtil() {
    }

    public static /* synthetic */ JvmMemberSignature.Field getJvmFieldSignature$default(JvmProtoBufUtil jvmProtoBufUtil, ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        return jvmProtoBufUtil.getJvmFieldSignature(property, nameResolver, typeTable, z);
    }

    public static final boolean isMovedFromInterfaceCompanion(ProtoBuf.Property proto) {
        m.g(proto, "proto");
        Flags.BooleanFlagField is_moved_from_interface_companion = JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object extension = proto.getExtension(JvmProtoBuf.flags);
        m.f(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean bool = is_moved_from_interface_companion.get(((Number) extension).intValue());
        m.f(bool, "JvmFlags.IS_MOVED_FROM_INTERFACE_COMPANION.get(proto.getExtension(JvmProtoBuf.flags))");
        return bool.booleanValue();
    }

    private final String mapTypeDefault(ProtoBuf.Type type, NameResolver nameResolver) {
        if (type.hasClassName()) {
            ClassMapperLite classMapperLite = ClassMapperLite.INSTANCE;
            return ClassMapperLite.mapClass(nameResolver.getQualifiedClassName(type.getClassName()));
        }
        return null;
    }

    public static final o<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(String[] data, String[] strings) {
        m.g(data, "data");
        m.g(strings, "strings");
        byte[] decodeBytes = BitEncoding.decodeBytes(data);
        m.f(decodeBytes, "decodeBytes(data)");
        return readClassDataFrom(decodeBytes, strings);
    }

    public static final o<JvmNameResolver, ProtoBuf.Function> readFunctionDataFrom(String[] data, String[] strings) {
        m.g(data, "data");
        m.g(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(BitEncoding.decodeBytes(data));
        return new o<>(INSTANCE.readNameResolver(byteArrayInputStream, strings), ProtoBuf.Function.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    private final JvmNameResolver readNameResolver(InputStream inputStream, String[] strArr) {
        JvmProtoBuf.StringTableTypes parseDelimitedFrom = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, EXTENSION_REGISTRY);
        m.f(parseDelimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new JvmNameResolver(parseDelimitedFrom, strArr);
    }

    public static final o<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(String[] data, String[] strings) {
        m.g(data, "data");
        m.g(strings, "strings");
        byte[] decodeBytes = BitEncoding.decodeBytes(data);
        m.f(decodeBytes, "decodeBytes(data)");
        return readPackageDataFrom(decodeBytes, strings);
    }

    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    public final JvmMemberSignature.Method getJvmConstructorSignature(ProtoBuf.Constructor proto, NameResolver nameResolver, TypeTable typeTable) {
        int r;
        String h0;
        m.g(proto, "proto");
        m.g(nameResolver, "nameResolver");
        m.g(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmProtoBuf.JvmMethodSignature> constructorSignature = JvmProtoBuf.constructorSignature;
        m.f(constructorSignature, "constructorSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(proto, constructorSignature);
        String string = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? "<init>" : nameResolver.getString(jvmMethodSignature.getName());
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            h0 = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
            m.f(valueParameterList, "proto.valueParameterList");
            r = s.r(valueParameterList, 10);
            ArrayList arrayList = new ArrayList(r);
            for (ProtoBuf.ValueParameter it : valueParameterList) {
                m.f(it, "it");
                String mapTypeDefault = mapTypeDefault(ProtoTypeTableUtilKt.type(it, typeTable), nameResolver);
                if (mapTypeDefault == null) {
                    return null;
                }
                arrayList.add(mapTypeDefault);
            }
            h0 = z.h0(arrayList, "", "(", ")V", 0, null, null, 56, null);
        }
        return new JvmMemberSignature.Method(string, h0);
    }

    public final JvmMemberSignature.Field getJvmFieldSignature(ProtoBuf.Property proto, NameResolver nameResolver, TypeTable typeTable, boolean z) {
        String mapTypeDefault;
        m.g(proto, "proto");
        m.g(nameResolver, "nameResolver");
        m.g(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
        m.f(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        JvmProtoBuf.JvmFieldSignature field = jvmPropertySignature.hasField() ? jvmPropertySignature.getField() : null;
        if (field == null && z) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? proto.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            mapTypeDefault = mapTypeDefault(ProtoTypeTableUtilKt.returnType(proto, typeTable), nameResolver);
            if (mapTypeDefault == null) {
                return null;
            }
        } else {
            mapTypeDefault = nameResolver.getString(field.getDesc());
        }
        return new JvmMemberSignature.Field(nameResolver.getString(name), mapTypeDefault);
    }

    public final JvmMemberSignature.Method getJvmMethodSignature(ProtoBuf.Function proto, NameResolver nameResolver, TypeTable typeTable) {
        List k2;
        int r;
        List<ProtoBuf.Type> t0;
        int r2;
        String h0;
        String o;
        m.g(proto, "proto");
        m.g(nameResolver, "nameResolver");
        m.g(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmProtoBuf.JvmMethodSignature> methodSignature = JvmProtoBuf.methodSignature;
        m.f(methodSignature, "methodSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(proto, methodSignature);
        int name = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? proto.getName() : jvmMethodSignature.getName();
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            o = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            k2 = r.k(ProtoTypeTableUtilKt.receiverType(proto, typeTable));
            List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
            m.f(valueParameterList, "proto.valueParameterList");
            r = s.r(valueParameterList, 10);
            ArrayList arrayList = new ArrayList(r);
            for (ProtoBuf.ValueParameter it : valueParameterList) {
                m.f(it, "it");
                arrayList.add(ProtoTypeTableUtilKt.type(it, typeTable));
            }
            t0 = z.t0(k2, arrayList);
            r2 = s.r(t0, 10);
            ArrayList arrayList2 = new ArrayList(r2);
            for (ProtoBuf.Type type : t0) {
                String mapTypeDefault = mapTypeDefault(type, nameResolver);
                if (mapTypeDefault == null) {
                    return null;
                }
                arrayList2.add(mapTypeDefault);
            }
            String mapTypeDefault2 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(proto, typeTable), nameResolver);
            if (mapTypeDefault2 == null) {
                return null;
            }
            h0 = z.h0(arrayList2, "", "(", ")", 0, null, null, 56, null);
            o = m.o(h0, mapTypeDefault2);
        }
        return new JvmMemberSignature.Method(nameResolver.getString(name), o);
    }

    public static final o<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(byte[] bytes, String[] strings) {
        m.g(bytes, "bytes");
        m.g(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new o<>(INSTANCE.readNameResolver(byteArrayInputStream, strings), ProtoBuf.Class.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    public static final o<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(byte[] bytes, String[] strings) {
        m.g(bytes, "bytes");
        m.g(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new o<>(INSTANCE.readNameResolver(byteArrayInputStream, strings), ProtoBuf.Package.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }
}