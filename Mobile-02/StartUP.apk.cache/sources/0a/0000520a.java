package kotlin.j0.b0;

import kotlin.Metadata;
import kotlin.e0.c.p;
import kotlin.j0.f;
import kotlin.j0.g;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.EmptyContainerForLocal;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;

/* compiled from: reflectLambda.kt */
/* loaded from: classes3.dex */
public final class d {

    /* compiled from: reflectLambda.kt */
    /* loaded from: classes3.dex */
    static final /* synthetic */ class a extends j implements p<MemberDeserializer, ProtoBuf.Function, SimpleFunctionDescriptor> {
        public static final a a = new a();

        a() {
            super(2);
        }

        @Override // kotlin.e0.c.p
        /* renamed from: a */
        public final SimpleFunctionDescriptor invoke(MemberDeserializer p1, ProtoBuf.Function p2) {
            m.g(p1, "p1");
            m.g(p2, "p2");
            return p1.loadFunction(p2);
        }

        @Override // kotlin.jvm.internal.c, kotlin.j0.c
        public final String getName() {
            return "loadFunction";
        }

        @Override // kotlin.jvm.internal.c
        public final f getOwner() {
            return e0.b(MemberDeserializer.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }
    }

    public static final <R> g<R> a(kotlin.d<? extends R> reflect) {
        m.g(reflect, "$this$reflect");
        Metadata metadata = (Metadata) reflect.getClass().getAnnotation(Metadata.class);
        if (metadata != null) {
            String[] d1 = metadata.d1();
            if (d1.length == 0) {
                d1 = null;
            }
            if (d1 != null) {
                o<JvmNameResolver, ProtoBuf.Function> readFunctionDataFrom = JvmProtoBufUtil.readFunctionDataFrom(d1, metadata.d2());
                JvmNameResolver a2 = readFunctionDataFrom.a();
                ProtoBuf.Function b2 = readFunctionDataFrom.b();
                JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(metadata.mv(), (metadata.xi() & 8) != 0);
                Class<?> cls = reflect.getClass();
                ProtoBuf.TypeTable typeTable = b2.getTypeTable();
                m.f(typeTable, "proto.typeTable");
                SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) UtilKt.deserializeToDescriptor(cls, b2, a2, new TypeTable(typeTable), jvmMetadataVersion, a.a);
                if (simpleFunctionDescriptor != null) {
                    return new KFunctionImpl(EmptyContainerForLocal.INSTANCE, simpleFunctionDescriptor);
                }
            }
        }
        return null;
    }
}