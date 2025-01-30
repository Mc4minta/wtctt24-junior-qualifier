package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a0.l0;
import kotlin.a0.s;
import kotlin.e0.c.l;
import kotlin.i0.f;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: ProtoBasedClassDataFinder.kt */
/* loaded from: classes3.dex */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {
    private final Map<ClassId, ProtoBuf.Class> classIdToProto;
    private final l<ClassId, SourceElement> classSource;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBasedClassDataFinder(ProtoBuf.PackageFragment proto, NameResolver nameResolver, BinaryVersion metadataVersion, l<? super ClassId, ? extends SourceElement> classSource) {
        int r;
        int d2;
        int b2;
        m.g(proto, "proto");
        m.g(nameResolver, "nameResolver");
        m.g(metadataVersion, "metadataVersion");
        m.g(classSource, "classSource");
        this.nameResolver = nameResolver;
        this.metadataVersion = metadataVersion;
        this.classSource = classSource;
        List<ProtoBuf.Class> class_List = proto.getClass_List();
        m.f(class_List, "proto.class_List");
        r = s.r(class_List, 10);
        d2 = l0.d(r);
        b2 = f.b(d2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
        for (Object obj : class_List) {
            linkedHashMap.put(NameResolverUtilKt.getClassId(this.nameResolver, ((ProtoBuf.Class) obj).getFqName()), obj);
        }
        this.classIdToProto = linkedHashMap;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId classId) {
        m.g(classId, "classId");
        ProtoBuf.Class r0 = this.classIdToProto.get(classId);
        if (r0 == null) {
            return null;
        }
        return new ClassData(this.nameResolver, r0, this.metadataVersion, this.classSource.invoke(classId));
    }

    public final Collection<ClassId> getAllClassIds() {
        return this.classIdToProto.keySet();
    }
}