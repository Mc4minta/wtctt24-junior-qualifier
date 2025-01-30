package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;

/* compiled from: BuiltInSerializerProtocol.kt */
/* loaded from: classes3.dex */
public final class BuiltInSerializerProtocol extends SerializerExtensionProtocol {
    public static final BuiltInSerializerProtocol INSTANCE = new BuiltInSerializerProtocol();

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private BuiltInSerializerProtocol() {
        /*
            r14 = this;
            kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r1 = kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite.newInstance()
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.registerAllExtensions(r1)
            kotlin.x r0 = kotlin.x.a
            java.lang.String r0 = "newInstance().apply(BuiltInsProtoBuf::registerAllExtensions)"
            kotlin.jvm.internal.m.f(r1, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, java.lang.Integer> r2 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.packageFqName
            java.lang.String r0 = "packageFqName"
            kotlin.jvm.internal.m.f(r2, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r3 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.constructorAnnotation
            java.lang.String r0 = "constructorAnnotation"
            kotlin.jvm.internal.m.f(r3, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r4 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.classAnnotation
            java.lang.String r0 = "classAnnotation"
            kotlin.jvm.internal.m.f(r4, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r5 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.functionAnnotation
            java.lang.String r0 = "functionAnnotation"
            kotlin.jvm.internal.m.f(r5, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r6 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.propertyAnnotation
            java.lang.String r0 = "propertyAnnotation"
            kotlin.jvm.internal.m.f(r6, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r7 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.propertyGetterAnnotation
            java.lang.String r0 = "propertyGetterAnnotation"
            kotlin.jvm.internal.m.f(r7, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r8 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.propertySetterAnnotation
            java.lang.String r0 = "propertySetterAnnotation"
            kotlin.jvm.internal.m.f(r8, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r9 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.enumEntryAnnotation
            java.lang.String r0 = "enumEntryAnnotation"
            kotlin.jvm.internal.m.f(r9, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value> r10 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.compileTimeValue
            java.lang.String r0 = "compileTimeValue"
            kotlin.jvm.internal.m.f(r10, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r11 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.parameterAnnotation
            java.lang.String r0 = "parameterAnnotation"
            kotlin.jvm.internal.m.f(r11, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r12 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.typeAnnotation
            java.lang.String r0 = "typeAnnotation"
            kotlin.jvm.internal.m.f(r12, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r13 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.typeParameterAnnotation
            java.lang.String r0 = "typeParameterAnnotation"
            kotlin.jvm.internal.m.f(r13, r0)
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol.<init>():void");
    }

    private final String shortName(FqName fqName) {
        if (fqName.isRoot()) {
            return "default-package";
        }
        String asString = fqName.shortName().asString();
        m.f(asString, "fqName.shortName().asString()");
        return asString;
    }

    public final String getBuiltInsFileName(FqName fqName) {
        m.g(fqName, "fqName");
        return m.o(shortName(fqName), ".kotlin_builtins");
    }

    public final String getBuiltInsFilePath(FqName fqName) {
        String J;
        m.g(fqName, "fqName");
        StringBuilder sb = new StringBuilder();
        String asString = fqName.asString();
        m.f(asString, "fqName.asString()");
        J = x.J(asString, '.', '/', false, 4, null);
        sb.append(J);
        sb.append('/');
        sb.append(getBuiltInsFileName(fqName));
        return sb.toString();
    }
}