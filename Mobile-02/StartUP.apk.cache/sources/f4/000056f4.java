package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.d0.c;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import org.spongycastle.pqc.math.linearalgebra.Matrix;

/* compiled from: ClassMapperLite.kt */
/* loaded from: classes3.dex */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f17402kotlin;
    private static final Map<String, String> map;

    static {
        List j2;
        String h0;
        List j3;
        List<String> j4;
        List<String> j5;
        List<String> j6;
        int i2 = 0;
        j2 = r.j('k', 'o', 't', 'l', 'i', 'n');
        h0 = z.h0(j2, "", null, null, 0, null, null, 62, null);
        f17402kotlin = h0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        j3 = r.j("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int b2 = c.b(0, j3.size() - 1, 2);
        if (b2 >= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 2;
                StringBuilder sb = new StringBuilder();
                String str = f17402kotlin;
                sb.append(str);
                sb.append('/');
                sb.append((String) j3.get(i3));
                int i5 = i3 + 1;
                linkedHashMap.put(sb.toString(), j3.get(i5));
                linkedHashMap.put(str + '/' + ((String) j3.get(i3)) + "Array", m.o("[", j3.get(i5)));
                if (i3 == b2) {
                    break;
                }
                i3 = i4;
            }
        }
        linkedHashMap.put(m.o(f17402kotlin, "/Unit"), "V");
        m2212map$lambda0$add(linkedHashMap, "Any", "java/lang/Object");
        m2212map$lambda0$add(linkedHashMap, "Nothing", "java/lang/Void");
        m2212map$lambda0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        j4 = r.j("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum");
        for (String str2 : j4) {
            m2212map$lambda0$add(linkedHashMap, str2, m.o("java/lang/", str2));
        }
        j5 = r.j("Iterator", "Collection", "List", "Set", "Map", "ListIterator");
        for (String str3 : j5) {
            m2212map$lambda0$add(linkedHashMap, m.o("collections/", str3), m.o("java/util/", str3));
            m2212map$lambda0$add(linkedHashMap, m.o("collections/Mutable", str3), m.o("java/util/", str3));
        }
        m2212map$lambda0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        m2212map$lambda0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        m2212map$lambda0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        m2212map$lambda0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        while (true) {
            int i6 = i2 + 1;
            String o = m.o("Function", Integer.valueOf(i2));
            StringBuilder sb2 = new StringBuilder();
            String str4 = f17402kotlin;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i2);
            m2212map$lambda0$add(linkedHashMap, o, sb2.toString());
            m2212map$lambda0$add(linkedHashMap, m.o("reflect/KFunction", Integer.valueOf(i2)), m.o(str4, "/reflect/KFunction"));
            if (i6 > 22) {
                break;
            }
            i2 = i6;
        }
        j6 = r.j("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum");
        for (String str5 : j6) {
            m2212map$lambda0$add(linkedHashMap, m.o(str5, ".Companion"), f17402kotlin + "/jvm/internal/" + str5 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    private ClassMapperLite() {
    }

    /* renamed from: map$lambda-0$add  reason: not valid java name */
    private static final void m2212map$lambda0$add(Map<String, String> map2, String str, String str2) {
        map2.put(f17402kotlin + '/' + str, Matrix.MATRIX_TYPE_RANDOM_LT + str2 + ';');
    }

    public static final String mapClass(String classId) {
        String J;
        m.g(classId, "classId");
        String str = map.get(classId);
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Matrix.MATRIX_TYPE_RANDOM_LT);
            J = x.J(classId, '.', '$', false, 4, null);
            sb.append(J);
            sb.append(';');
            return sb.toString();
        }
        return str;
    }
}