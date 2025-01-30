package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import org.spongycastle.pqc.math.linearalgebra.Matrix;

/* compiled from: SignatureBuildingComponents.kt */
/* loaded from: classes3.dex */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String escapeClassName(String str) {
        if (str.length() > 1) {
            return Matrix.MATRIX_TYPE_RANDOM_LT + str + ';';
        }
        return str;
    }

    public final String[] constructors(String... signatures) {
        m.g(signatures, "signatures");
        ArrayList arrayList = new ArrayList(signatures.length);
        for (String str : signatures) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public final Set<String> inClass(String internalName, String... signatures) {
        m.g(internalName, "internalName");
        m.g(signatures, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : signatures) {
            linkedHashSet.add(internalName + '.' + str);
        }
        return linkedHashSet;
    }

    public final Set<String> inJavaLang(String name, String... signatures) {
        m.g(name, "name");
        m.g(signatures, "signatures");
        String javaLang = javaLang(name);
        String[] strArr = new String[signatures.length];
        System.arraycopy(signatures, 0, strArr, 0, signatures.length);
        return inClass(javaLang, strArr);
    }

    public final Set<String> inJavaUtil(String name, String... signatures) {
        m.g(name, "name");
        m.g(signatures, "signatures");
        String javaUtil = javaUtil(name);
        String[] strArr = new String[signatures.length];
        System.arraycopy(signatures, 0, strArr, 0, signatures.length);
        return inClass(javaUtil, strArr);
    }

    public final String javaFunction(String name) {
        m.g(name, "name");
        return m.o("java/util/function/", name);
    }

    public final String javaLang(String name) {
        m.g(name, "name");
        return m.o("java/lang/", name);
    }

    public final String javaUtil(String name) {
        m.g(name, "name");
        return m.o("java/util/", name);
    }

    public final String jvmDescriptor(String name, List<String> parameters, String ret) {
        String h0;
        m.g(name, "name");
        m.g(parameters, "parameters");
        m.g(ret, "ret");
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append('(');
        h0 = z.h0(parameters, "", null, null, 0, null, new SignatureBuildingComponents$jvmDescriptor$1(this), 30, null);
        sb.append(h0);
        sb.append(')');
        sb.append(escapeClassName(ret));
        return sb.toString();
    }

    public final String signature(String internalName, String jvmDescriptor) {
        m.g(internalName, "internalName");
        m.g(jvmDescriptor, "jvmDescriptor");
        return internalName + '.' + jvmDescriptor;
    }
}