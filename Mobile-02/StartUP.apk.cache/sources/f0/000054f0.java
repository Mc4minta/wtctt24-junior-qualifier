package kotlin.reflect.jvm.internal.impl.load.java;

import com.coinbase.ApiConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0.m0;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.u;

/* compiled from: BuiltinSpecialProperties.kt */
/* loaded from: classes3.dex */
public final class BuiltinSpecialProperties {
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    private static final Set<FqName> SPECIAL_FQ_NAMES;
    private static final Set<Name> SPECIAL_SHORT_NAMES;

    static {
        FqName childSafe;
        FqName childSafe2;
        FqName child;
        FqName child2;
        FqName childSafe3;
        FqName child3;
        FqName child4;
        FqName child5;
        Map<FqName, Name> l2;
        int r;
        int r2;
        Set<Name> M0;
        FqNameUnsafe fqNameUnsafe = StandardNames.FqNames._enum;
        childSafe = BuiltinSpecialPropertiesKt.childSafe(fqNameUnsafe, ApiConstants.NAME);
        childSafe2 = BuiltinSpecialPropertiesKt.childSafe(fqNameUnsafe, "ordinal");
        child = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.collection, "size");
        FqName fqName = StandardNames.FqNames.map;
        child2 = BuiltinSpecialPropertiesKt.child(fqName, "size");
        childSafe3 = BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames.charSequence, "length");
        child3 = BuiltinSpecialPropertiesKt.child(fqName, "keys");
        child4 = BuiltinSpecialPropertiesKt.child(fqName, "values");
        child5 = BuiltinSpecialPropertiesKt.child(fqName, "entries");
        l2 = m0.l(u.a(childSafe, Name.identifier(ApiConstants.NAME)), u.a(childSafe2, Name.identifier("ordinal")), u.a(child, Name.identifier("size")), u.a(child2, Name.identifier("size")), u.a(childSafe3, Name.identifier("length")), u.a(child3, Name.identifier("keySet")), u.a(child4, Name.identifier("values")), u.a(child5, Name.identifier("entrySet")));
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = l2;
        Set<Map.Entry<FqName, Name>> entrySet = l2.entrySet();
        r = s.r(entrySet, 10);
        ArrayList<o> arrayList = new ArrayList(r);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new o(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (o oVar : arrayList) {
            Name name = (Name) oVar.d();
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add((Name) oVar.c());
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = linkedHashMap;
        Set<FqName> keySet = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = keySet;
        r2 = s.r(keySet, 10);
        ArrayList arrayList2 = new ArrayList(r2);
        for (FqName fqName2 : keySet) {
            arrayList2.add(fqName2.shortName());
        }
        M0 = z.M0(arrayList2);
        SPECIAL_SHORT_NAMES = M0;
    }

    private BuiltinSpecialProperties() {
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name name1) {
        List<Name> g2;
        m.g(name1, "name1");
        List<Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name1);
        if (list == null) {
            g2 = r.g();
            return g2;
        }
        return list;
    }

    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return SPECIAL_FQ_NAMES;
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return SPECIAL_SHORT_NAMES;
    }
}