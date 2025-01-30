package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0.l0;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.i0.f;
import kotlin.jvm.internal.m;
import kotlin.k0.h;
import kotlin.k0.p;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeclaredMemberIndex.kt */
/* loaded from: classes3.dex */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    private final Map<Name, JavaRecordComponent> components;
    private final Map<Name, JavaField> fields;
    private final JavaClass jClass;
    private final l<JavaMember, Boolean> memberFilter;
    private final l<JavaMethod, Boolean> methodFilter;
    private final Map<Name, List<JavaMethod>> methods;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassDeclaredMemberIndex(JavaClass jClass, l<? super JavaMember, Boolean> memberFilter) {
        h M;
        h m;
        h M2;
        h m2;
        int r;
        int d2;
        int b2;
        m.g(jClass, "jClass");
        m.g(memberFilter, "memberFilter");
        this.jClass = jClass;
        this.memberFilter = memberFilter;
        ClassDeclaredMemberIndex$methodFilter$1 classDeclaredMemberIndex$methodFilter$1 = new ClassDeclaredMemberIndex$methodFilter$1(this);
        this.methodFilter = classDeclaredMemberIndex$methodFilter$1;
        M = z.M(jClass.getMethods());
        m = p.m(M, classDeclaredMemberIndex$methodFilter$1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : m) {
            Name name = ((JavaMethod) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.methods = linkedHashMap;
        M2 = z.M(this.jClass.getFields());
        m2 = p.m(M2, this.memberFilter);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : m2) {
            linkedHashMap2.put(((JavaField) obj3).getName(), obj3);
        }
        this.fields = linkedHashMap2;
        Collection<JavaRecordComponent> recordComponents = this.jClass.getRecordComponents();
        l<JavaMember, Boolean> lVar = this.memberFilter;
        ArrayList arrayList = new ArrayList();
        for (Object obj4 : recordComponents) {
            if (((Boolean) lVar.invoke(obj4)).booleanValue()) {
                arrayList.add(obj4);
            }
        }
        r = s.r(arrayList, 10);
        d2 = l0.d(r);
        b2 = f.b(d2, 16);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(b2);
        for (Object obj5 : arrayList) {
            linkedHashMap3.put(((JavaRecordComponent) obj5).getName(), obj5);
        }
        this.components = linkedHashMap3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaField findFieldByName(Name name) {
        m.g(name, "name");
        return this.fields.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Collection<JavaMethod> findMethodsByName(Name name) {
        List g2;
        m.g(name, "name");
        List<JavaMethod> list = this.methods.get(name);
        if (list == null) {
            g2 = r.g();
            return g2;
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaRecordComponent findRecordComponentByName(Name name) {
        m.g(name, "name");
        return this.components.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getFieldNames() {
        h M;
        h<JavaNamedElement> m;
        M = z.M(this.jClass.getFields());
        m = p.m(M, this.memberFilter);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaNamedElement javaNamedElement : m) {
            linkedHashSet.add(javaNamedElement.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getMethodNames() {
        h M;
        h<JavaNamedElement> m;
        M = z.M(this.jClass.getMethods());
        m = p.m(M, this.methodFilter);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaNamedElement javaNamedElement : m) {
            linkedHashSet.add(javaNamedElement.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getRecordComponentNames() {
        return this.components.keySet();
    }
}