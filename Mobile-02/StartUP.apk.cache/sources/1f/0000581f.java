package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Set;
import kotlin.a0.r0;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: ClassDeserializer.kt */
/* loaded from: classes3.dex */
public final class ClassDeserializer {
    private static final Set<ClassId> BLACK_LIST;
    public static final Companion Companion = new Companion(null);
    private final l<ClassKey, ClassDescriptor> classes;
    private final DeserializationComponents components;

    /* compiled from: ClassDeserializer.kt */
    /* loaded from: classes3.dex */
    public static final class ClassKey {
        private final ClassData classData;
        private final ClassId classId;

        public ClassKey(ClassId classId, ClassData classData) {
            m.g(classId, "classId");
            this.classId = classId;
            this.classData = classData;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ClassKey) && m.c(this.classId, ((ClassKey) obj).classId);
        }

        public final ClassData getClassData() {
            return this.classData;
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public int hashCode() {
            return this.classId.hashCode();
        }
    }

    /* compiled from: ClassDeserializer.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.BLACK_LIST;
        }
    }

    static {
        Set<ClassId> a;
        a = r0.a(ClassId.topLevel(StandardNames.FqNames.cloneable.toSafe()));
        BLACK_LIST = a;
    }

    public ClassDeserializer(DeserializationComponents components) {
        m.g(components, "components");
        this.components = components;
        this.classes = components.getStorageManager().createMemoizedFunctionWithNullableValues(new ClassDeserializer$classes$1(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00bd A[EDGE_INSN: B:104:0x00bd->B:96:0x00bd ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor createClass(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey r13) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.createClass(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$ClassKey):kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor");
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassData classData, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            classData = null;
        }
        return classDeserializer.deserializeClass(classId, classData);
    }

    public final ClassDescriptor deserializeClass(ClassId classId, ClassData classData) {
        m.g(classId, "classId");
        return this.classes.invoke(new ClassKey(classId, classData));
    }
}