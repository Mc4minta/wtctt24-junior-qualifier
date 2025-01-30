package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.a0.n;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.k0.h;
import kotlin.k0.p;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes3.dex */
public final class ReflectJavaClass extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaClass {
    private final Class<?> klass;

    public ReflectJavaClass(Class<?> klass) {
        m.g(klass, "klass");
        this.klass = klass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isEnumValuesOrValueOf(Method method) {
        String name = method.getName();
        if (m.c(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            m.f(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (m.c(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaClass) && m.c(this.klass, ((ReflectJavaClass) obj).klass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public FqName getFqName() {
        FqName asSingleFqName = ReflectClassUtilKt.getClassId(this.klass).asSingleFqName();
        m.f(asSingleFqName, "klass.classId.asSingleFqName()");
        return asSingleFqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public LightClassOriginKind getLightClassOriginKind() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return this.klass.getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        Name identifier = Name.identifier(this.klass.getSimpleName());
        m.f(identifier, "identifier(klass.simpleName)");
        return identifier;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public Collection<JavaClassifierType> getPermittedTypes() {
        List g2;
        g2 = r.g();
        return g2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public Collection<JavaRecordComponent> getRecordComponents() {
        List g2;
        g2 = r.g();
        return g2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public Collection<JavaClassifierType> getSupertypes() {
        Class cls;
        List<Type> j2;
        int r;
        List g2;
        cls = Object.class;
        if (m.c(this.klass, cls)) {
            g2 = r.g();
            return g2;
        }
        g0 g0Var = new g0(2);
        Object genericSuperclass = this.klass.getGenericSuperclass();
        g0Var.a(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.klass.getGenericInterfaces();
        m.f(genericInterfaces, "klass.genericInterfaces");
        g0Var.b(genericInterfaces);
        j2 = r.j(g0Var.d(new Type[g0Var.c()]));
        r = s.r(j2, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Type type : j2) {
            arrayList.add(new ReflectJavaClassifierType(type));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.klass.getTypeParameters();
        m.f(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean hasDefaultConstructor() {
        return false;
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isAnnotationType() {
        return this.klass.isAnnotation();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isEnum() {
        return this.klass.isEnum();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isInterface() {
        return this.klass.isInterface();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isRecord() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isSealed() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    public String toString() {
        return ReflectJavaClass.class.getName() + ": " + this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<ReflectJavaConstructor> getConstructors() {
        h s;
        h n;
        h v;
        List<ReflectJavaConstructor> B;
        Constructor<?>[] declaredConstructors = this.klass.getDeclaredConstructors();
        m.f(declaredConstructors, "klass.declaredConstructors");
        s = n.s(declaredConstructors);
        n = p.n(s, ReflectJavaClass$constructors$1.INSTANCE);
        v = p.v(n, ReflectJavaClass$constructors$2.INSTANCE);
        B = p.B(v);
        return B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public Class<?> getElement() {
        return this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<ReflectJavaField> getFields() {
        h s;
        h n;
        h v;
        List<ReflectJavaField> B;
        Field[] declaredFields = this.klass.getDeclaredFields();
        m.f(declaredFields, "klass.declaredFields");
        s = n.s(declaredFields);
        n = p.n(s, ReflectJavaClass$fields$1.INSTANCE);
        v = p.v(n, ReflectJavaClass$fields$2.INSTANCE);
        B = p.B(v);
        return B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<Name> getInnerClassNames() {
        h s;
        h n;
        h w;
        List<Name> B;
        Class<?>[] declaredClasses = this.klass.getDeclaredClasses();
        m.f(declaredClasses, "klass.declaredClasses");
        s = n.s(declaredClasses);
        n = p.n(s, ReflectJavaClass$innerClassNames$1.INSTANCE);
        w = p.w(n, ReflectJavaClass$innerClassNames$2.INSTANCE);
        B = p.B(w);
        return B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<ReflectJavaMethod> getMethods() {
        h s;
        h m;
        h v;
        List<ReflectJavaMethod> B;
        Method[] declaredMethods = this.klass.getDeclaredMethods();
        m.f(declaredMethods, "klass.declaredMethods");
        s = n.s(declaredMethods);
        m = p.m(s, new ReflectJavaClass$methods$1(this));
        v = p.v(m, ReflectJavaClass$methods$2.INSTANCE);
        B = p.B(v);
        return B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public ReflectJavaClass getOuterClass() {
        Class<?> declaringClass = this.klass.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new ReflectJavaClass(declaringClass);
    }
}