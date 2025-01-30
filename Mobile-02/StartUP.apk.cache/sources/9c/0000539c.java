package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a0.m0;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.u;

/* compiled from: UnsignedType.kt */
/* loaded from: classes3.dex */
public final class UnsignedTypes {
    public static final UnsignedTypes INSTANCE = new UnsignedTypes();
    private static final HashMap<ClassId, ClassId> arrayClassIdToUnsignedClassId;
    private static final Set<Name> arrayClassesShortNames;
    private static final Set<Name> unsignedArrayTypeNames;
    private static final HashMap<UnsignedArrayType, Name> unsignedArrayTypeToArrayCall;
    private static final HashMap<ClassId, ClassId> unsignedClassIdToArrayClassId;
    private static final Set<Name> unsignedTypeNames;

    static {
        Set<Name> M0;
        Set<Name> M02;
        HashMap<UnsignedArrayType, Name> k2;
        UnsignedType[] values = UnsignedType.values();
        ArrayList arrayList = new ArrayList(values.length);
        int i2 = 0;
        for (UnsignedType unsignedType : values) {
            arrayList.add(unsignedType.getTypeName());
        }
        M0 = z.M0(arrayList);
        unsignedTypeNames = M0;
        UnsignedArrayType[] values2 = UnsignedArrayType.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (UnsignedArrayType unsignedArrayType : values2) {
            arrayList2.add(unsignedArrayType.getTypeName());
        }
        M02 = z.M0(arrayList2);
        unsignedArrayTypeNames = M02;
        arrayClassIdToUnsignedClassId = new HashMap<>();
        unsignedClassIdToArrayClassId = new HashMap<>();
        k2 = m0.k(u.a(UnsignedArrayType.UBYTEARRAY, Name.identifier("ubyteArrayOf")), u.a(UnsignedArrayType.USHORTARRAY, Name.identifier("ushortArrayOf")), u.a(UnsignedArrayType.UINTARRAY, Name.identifier("uintArrayOf")), u.a(UnsignedArrayType.ULONGARRAY, Name.identifier("ulongArrayOf")));
        unsignedArrayTypeToArrayCall = k2;
        UnsignedType[] values3 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UnsignedType unsignedType2 : values3) {
            linkedHashSet.add(unsignedType2.getArrayClassId().getShortClassName());
        }
        arrayClassesShortNames = linkedHashSet;
        UnsignedType[] values4 = UnsignedType.values();
        int length = values4.length;
        while (i2 < length) {
            UnsignedType unsignedType3 = values4[i2];
            i2++;
            arrayClassIdToUnsignedClassId.put(unsignedType3.getArrayClassId(), unsignedType3.getClassId());
            unsignedClassIdToArrayClassId.put(unsignedType3.getClassId(), unsignedType3.getArrayClassId());
        }
    }

    private UnsignedTypes() {
    }

    public static final boolean isUnsignedType(KotlinType type) {
        ClassifierDescriptor mo2214getDeclarationDescriptor;
        m.g(type, "type");
        if (TypeUtils.noExpectedType(type) || (mo2214getDeclarationDescriptor = type.getConstructor().mo2214getDeclarationDescriptor()) == null) {
            return false;
        }
        return INSTANCE.isUnsignedClass(mo2214getDeclarationDescriptor);
    }

    public final ClassId getUnsignedClassIdByArrayClassId(ClassId arrayClassId) {
        m.g(arrayClassId, "arrayClassId");
        return arrayClassIdToUnsignedClassId.get(arrayClassId);
    }

    public final boolean isShortNameOfUnsignedArray(Name name) {
        m.g(name, "name");
        return arrayClassesShortNames.contains(name);
    }

    public final boolean isUnsignedClass(DeclarationDescriptor descriptor) {
        m.g(descriptor, "descriptor");
        DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
        return (containingDeclaration instanceof PackageFragmentDescriptor) && m.c(((PackageFragmentDescriptor) containingDeclaration).getFqName(), StandardNames.BUILT_INS_PACKAGE_FQ_NAME) && unsignedTypeNames.contains(descriptor.getName());
    }
}