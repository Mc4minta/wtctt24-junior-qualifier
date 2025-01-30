package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0.j0;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.a0.s;
import kotlin.a0.s0;
import kotlin.a0.t0;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.u;

/* compiled from: SpecialGenericSignatures.kt */
/* loaded from: classes3.dex */
public class SpecialGenericSignatures {
    public static final Companion Companion = new Companion(null);
    private static final List<String> ERASED_COLLECTION_PARAMETER_NAMES;
    private static final List<Companion.NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
    private static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES;
    private static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    private static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES;
    private static final Map<Companion.NameAndSignature, TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
    private static final Map<Name, List<Name>> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
    private static final Map<Companion.NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
    private static final List<Name> ORIGINAL_SHORT_NAMES;
    private static final Companion.NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE;
    private static final Map<String, TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP;
    private static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME;

    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* compiled from: SpecialGenericSignatures.kt */
        /* loaded from: classes3.dex */
        public static final class NameAndSignature {
            private final Name name;
            private final String signature;

            public NameAndSignature(Name name, String signature) {
                m.g(name, "name");
                m.g(signature, "signature");
                this.name = name;
                this.signature = signature;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof NameAndSignature) {
                    NameAndSignature nameAndSignature = (NameAndSignature) obj;
                    return m.c(this.name, nameAndSignature.name) && m.c(this.signature, nameAndSignature.signature);
                }
                return false;
            }

            public final Name getName() {
                return this.name;
            }

            public final String getSignature() {
                return this.signature;
            }

            public int hashCode() {
                return (this.name.hashCode() * 31) + this.signature.hashCode();
            }

            public String toString() {
                return "NameAndSignature(name=" + this.name + ", signature=" + this.signature + ')';
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final NameAndSignature method(String str, String str2, String str3, String str4) {
            Name identifier = Name.identifier(str2);
            m.f(identifier, "identifier(name)");
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            return new NameAndSignature(identifier, signatureBuildingComponents.signature(str, str2 + '(' + str3 + ')' + str4));
        }

        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return SpecialGenericSignatures.ERASED_COLLECTION_PARAMETER_SIGNATURES;
        }

        public final Set<Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SHORT_NAMES;
        }

        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SIGNATURES;
        }

        public final Map<Name, List<Name>> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return SpecialGenericSignatures.JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
        }

        public final List<Name> getORIGINAL_SHORT_NAMES() {
            return SpecialGenericSignatures.ORIGINAL_SHORT_NAMES;
        }

        public final NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return SpecialGenericSignatures.REMOVE_AT_NAME_AND_SIGNATURE;
        }

        public final Map<String, TypeSafeBarrierDescription> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SpecialGenericSignatures.SIGNATURE_TO_DEFAULT_VALUES_MAP;
        }

        public final Map<String, Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SpecialGenericSignatures.SIGNATURE_TO_JVM_REPRESENTATION_NAME;
        }

        public final SpecialSignatureInfo getSpecialSignatureInfo(String builtinSignature) {
            m.g(builtinSignature, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(builtinSignature)) {
                return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            if (((TypeSafeBarrierDescription) j0.j(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), builtinSignature)) == TypeSafeBarrierDescription.NULL) {
                return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
            }
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: classes3.dex */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        SpecialSignatureInfo(String str, boolean z) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z;
        }

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SpecialSignatureInfo[] valuesCustom() {
            SpecialSignatureInfo[] valuesCustom = values();
            SpecialSignatureInfo[] specialSignatureInfoArr = new SpecialSignatureInfo[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, specialSignatureInfoArr, 0, valuesCustom.length);
            return specialSignatureInfoArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: classes3.dex */
    public static final class TypeSafeBarrierDescription {
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES;
        public static final TypeSafeBarrierDescription FALSE;
        public static final TypeSafeBarrierDescription INDEX;
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT;
        public static final TypeSafeBarrierDescription NULL;
        private final Object defaultValue;

        /* compiled from: SpecialGenericSignatures.kt */
        /* loaded from: classes3.dex */
        static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            MAP_GET_OR_DEFAULT(String str, int i2) {
                super(str, i2, null, null);
            }
        }

        static {
            TypeSafeBarrierDescription typeSafeBarrierDescription = new TypeSafeBarrierDescription("NULL", 0, null);
            NULL = typeSafeBarrierDescription;
            TypeSafeBarrierDescription typeSafeBarrierDescription2 = new TypeSafeBarrierDescription("INDEX", 1, -1);
            INDEX = typeSafeBarrierDescription2;
            TypeSafeBarrierDescription typeSafeBarrierDescription3 = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
            FALSE = typeSafeBarrierDescription3;
            MAP_GET_OR_DEFAULT map_get_or_default = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
            MAP_GET_OR_DEFAULT = map_get_or_default;
            $VALUES = new TypeSafeBarrierDescription[]{typeSafeBarrierDescription, typeSafeBarrierDescription2, typeSafeBarrierDescription3, map_get_or_default};
        }

        private TypeSafeBarrierDescription(String str, int i2, Object obj) {
            this.defaultValue = obj;
        }

        public /* synthetic */ TypeSafeBarrierDescription(String str, int i2, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i2, obj);
        }

        public static TypeSafeBarrierDescription valueOf(String value) {
            m.g(value, "value");
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, value);
        }

        public static TypeSafeBarrierDescription[] values() {
            TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArr = $VALUES;
            TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArr2 = new TypeSafeBarrierDescription[typeSafeBarrierDescriptionArr.length];
            System.arraycopy(typeSafeBarrierDescriptionArr, 0, typeSafeBarrierDescriptionArr2, 0, typeSafeBarrierDescriptionArr.length);
            return typeSafeBarrierDescriptionArr2;
        }
    }

    static {
        Set<String> e2;
        int r;
        int r2;
        int r3;
        Map<Companion.NameAndSignature, TypeSafeBarrierDescription> l2;
        int d2;
        Set<Companion.NameAndSignature> h2;
        int r4;
        Set<Name> M0;
        int r5;
        Set<String> M02;
        Map<Companion.NameAndSignature, Name> l3;
        int d3;
        int r6;
        int r7;
        e2 = s0.e("containsAll", "removeAll", "retainAll");
        r = s.r(e2, 10);
        ArrayList<Companion.NameAndSignature> arrayList = new ArrayList(r);
        for (String str : e2) {
            Companion companion = Companion;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            m.f(desc, "BOOLEAN.desc");
            arrayList.add(companion.method("java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = arrayList;
        r2 = s.r(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(r2);
        for (Companion.NameAndSignature nameAndSignature : arrayList) {
            arrayList2.add(nameAndSignature.getSignature());
        }
        ERASED_COLLECTION_PARAMETER_SIGNATURES = arrayList2;
        List<Companion.NameAndSignature> list = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        r3 = s.r(list, 10);
        ArrayList arrayList3 = new ArrayList(r3);
        for (Companion.NameAndSignature nameAndSignature2 : list) {
            arrayList3.add(nameAndSignature2.getName().asString());
        }
        ERASED_COLLECTION_PARAMETER_NAMES = arrayList3;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        Companion companion2 = Companion;
        String javaUtil = signatureBuildingComponents.javaUtil("Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String desc2 = jvmPrimitiveType.getDesc();
        m.f(desc2, "BOOLEAN.desc");
        Companion.NameAndSignature method = companion2.method(javaUtil, "contains", "Ljava/lang/Object;", desc2);
        TypeSafeBarrierDescription typeSafeBarrierDescription = TypeSafeBarrierDescription.FALSE;
        String javaUtil2 = signatureBuildingComponents.javaUtil("Collection");
        String desc3 = jvmPrimitiveType.getDesc();
        m.f(desc3, "BOOLEAN.desc");
        String javaUtil3 = signatureBuildingComponents.javaUtil("Map");
        String desc4 = jvmPrimitiveType.getDesc();
        m.f(desc4, "BOOLEAN.desc");
        String javaUtil4 = signatureBuildingComponents.javaUtil("Map");
        String desc5 = jvmPrimitiveType.getDesc();
        m.f(desc5, "BOOLEAN.desc");
        String javaUtil5 = signatureBuildingComponents.javaUtil("Map");
        String desc6 = jvmPrimitiveType.getDesc();
        m.f(desc6, "BOOLEAN.desc");
        Companion.NameAndSignature method2 = companion2.method(signatureBuildingComponents.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription typeSafeBarrierDescription2 = TypeSafeBarrierDescription.NULL;
        String javaUtil6 = signatureBuildingComponents.javaUtil("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String desc7 = jvmPrimitiveType2.getDesc();
        m.f(desc7, "INT.desc");
        Companion.NameAndSignature method3 = companion2.method(javaUtil6, "indexOf", "Ljava/lang/Object;", desc7);
        TypeSafeBarrierDescription typeSafeBarrierDescription3 = TypeSafeBarrierDescription.INDEX;
        String javaUtil7 = signatureBuildingComponents.javaUtil("List");
        String desc8 = jvmPrimitiveType2.getDesc();
        m.f(desc8, "INT.desc");
        l2 = m0.l(u.a(method, typeSafeBarrierDescription), u.a(companion2.method(javaUtil2, "remove", "Ljava/lang/Object;", desc3), typeSafeBarrierDescription), u.a(companion2.method(javaUtil3, "containsKey", "Ljava/lang/Object;", desc4), typeSafeBarrierDescription), u.a(companion2.method(javaUtil4, "containsValue", "Ljava/lang/Object;", desc5), typeSafeBarrierDescription), u.a(companion2.method(javaUtil5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), typeSafeBarrierDescription), u.a(companion2.method(signatureBuildingComponents.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), u.a(method2, typeSafeBarrierDescription2), u.a(companion2.method(signatureBuildingComponents.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), typeSafeBarrierDescription2), u.a(method3, typeSafeBarrierDescription3), u.a(companion2.method(javaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8), typeSafeBarrierDescription3));
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = l2;
        d2 = l0.d(l2.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(d2);
        Iterator<T> it = l2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(((Companion.NameAndSignature) entry.getKey()).getSignature(), entry.getValue());
        }
        SIGNATURE_TO_DEFAULT_VALUES_MAP = linkedHashMap;
        h2 = t0.h(GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        r4 = s.r(h2, 10);
        ArrayList arrayList4 = new ArrayList(r4);
        for (Companion.NameAndSignature nameAndSignature3 : h2) {
            arrayList4.add(nameAndSignature3.getName());
        }
        M0 = z.M0(arrayList4);
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = M0;
        r5 = s.r(h2, 10);
        ArrayList arrayList5 = new ArrayList(r5);
        for (Companion.NameAndSignature nameAndSignature4 : h2) {
            arrayList5.add(nameAndSignature4.getSignature());
        }
        M02 = z.M0(arrayList5);
        ERASED_VALUE_PARAMETERS_SIGNATURES = M02;
        Companion companion3 = Companion;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String desc9 = jvmPrimitiveType3.getDesc();
        m.f(desc9, "INT.desc");
        REMOVE_AT_NAME_AND_SIGNATURE = companion3.method("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.INSTANCE;
        String javaLang = signatureBuildingComponents2.javaLang("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        m.f(desc10, "BYTE.desc");
        String javaLang2 = signatureBuildingComponents2.javaLang("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        m.f(desc11, "SHORT.desc");
        String javaLang3 = signatureBuildingComponents2.javaLang("Number");
        String desc12 = jvmPrimitiveType3.getDesc();
        m.f(desc12, "INT.desc");
        String javaLang4 = signatureBuildingComponents2.javaLang("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        m.f(desc13, "LONG.desc");
        String javaLang5 = signatureBuildingComponents2.javaLang("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        m.f(desc14, "FLOAT.desc");
        String javaLang6 = signatureBuildingComponents2.javaLang("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        m.f(desc15, "DOUBLE.desc");
        String javaLang7 = signatureBuildingComponents2.javaLang("CharSequence");
        String desc16 = jvmPrimitiveType3.getDesc();
        m.f(desc16, "INT.desc");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        m.f(desc17, "CHAR.desc");
        l3 = m0.l(u.a(companion3.method(javaLang, "toByte", "", desc10), Name.identifier("byteValue")), u.a(companion3.method(javaLang2, "toShort", "", desc11), Name.identifier("shortValue")), u.a(companion3.method(javaLang3, "toInt", "", desc12), Name.identifier("intValue")), u.a(companion3.method(javaLang4, "toLong", "", desc13), Name.identifier("longValue")), u.a(companion3.method(javaLang5, "toFloat", "", desc14), Name.identifier("floatValue")), u.a(companion3.method(javaLang6, "toDouble", "", desc15), Name.identifier("doubleValue")), u.a(companion3.getREMOVE_AT_NAME_AND_SIGNATURE(), Name.identifier("remove")), u.a(companion3.method(javaLang7, "get", desc16, desc17), Name.identifier("charAt")));
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = l3;
        d3 = l0.d(l3.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(d3);
        Iterator<T> it2 = l3.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(((Companion.NameAndSignature) entry2.getKey()).getSignature(), entry2.getValue());
        }
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = linkedHashMap2;
        Set<Companion.NameAndSignature> keySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        r6 = s.r(keySet, 10);
        ArrayList arrayList6 = new ArrayList(r6);
        for (Companion.NameAndSignature nameAndSignature5 : keySet) {
            arrayList6.add(nameAndSignature5.getName());
        }
        ORIGINAL_SHORT_NAMES = arrayList6;
        Set<Map.Entry<Companion.NameAndSignature, Name>> entrySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        r7 = s.r(entrySet, 10);
        ArrayList<o> arrayList7 = new ArrayList(r7);
        Iterator<T> it3 = entrySet.iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            arrayList7.add(new o(((Companion.NameAndSignature) entry3.getKey()).getName(), entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (o oVar : arrayList7) {
            Name name = (Name) oVar.d();
            Object obj = linkedHashMap3.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap3.put(name, obj);
            }
            ((List) obj).add((Name) oVar.c());
        }
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = linkedHashMap3;
    }
}