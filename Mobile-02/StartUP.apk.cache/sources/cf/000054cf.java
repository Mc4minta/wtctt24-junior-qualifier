package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;

/* compiled from: ReflectJavaMember.kt */
/* loaded from: classes3.dex */
public abstract class ReflectJavaMember extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaMember) && m.c(getMember(), ((ReflectJavaMember) obj).getMember());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        return (AnnotatedElement) getMember();
    }

    public abstract Member getMember();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return getMember().getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        String name = getMember().getName();
        Name identifier = name == null ? null : Name.identifier(name);
        if (identifier == null) {
            Name NO_NAME_PROVIDED = SpecialNames.NO_NAME_PROVIDED;
            m.f(NO_NAME_PROVIDED, "NO_NAME_PROVIDED");
            return NO_NAME_PROVIDED;
        }
        return identifier;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0068 A[LOOP:0: B:13:0x0038->B:26:0x0068, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ae A[EDGE_INSN: B:30:0x00ae->B:29:0x00ae ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter> getValueParameters(java.lang.reflect.Type[] r13, java.lang.annotation.Annotation[][] r14, boolean r15) {
        /*
            r12 = this;
            java.lang.String r0 = "parameterTypes"
            kotlin.jvm.internal.m.g(r13, r0)
            java.lang.String r0 = "parameterAnnotations"
            kotlin.jvm.internal.m.g(r14, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r13.length
            r0.<init>(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader r1 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader.INSTANCE
            java.lang.reflect.Member r2 = r12.getMember()
            java.util.List r1 = r1.loadParameterNames(r2)
            r2 = 0
            if (r1 != 0) goto L1f
            r3 = r2
            goto L27
        L1f:
            int r3 = r1.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L27:
            r4 = 0
            if (r3 != 0) goto L2c
            r3 = r4
            goto L32
        L2c:
            int r3 = r3.intValue()
            int r5 = r13.length
            int r3 = r3 - r5
        L32:
            int r5 = r13.length
            int r5 = r5 + (-1)
            if (r5 < 0) goto Lae
            r6 = r4
        L38:
            int r7 = r6 + 1
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType$Factory r8 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory
            r9 = r13[r6]
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType r8 = r8.create(r9)
            if (r1 != 0) goto L46
            r9 = r2
            goto L50
        L46:
            int r9 = r6 + r3
            java.lang.Object r9 = kotlin.a0.p.b0(r1, r9)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L6a
        L50:
            if (r15 == 0) goto L5a
            int r10 = kotlin.a0.j.B(r13)
            if (r6 != r10) goto L5a
            r10 = 1
            goto L5b
        L5a:
            r10 = r4
        L5b:
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaValueParameter r11 = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaValueParameter
            r6 = r14[r6]
            r11.<init>(r8, r6, r9, r10)
            r0.add(r11)
            if (r7 <= r5) goto L68
            goto Lae
        L68:
            r6 = r7
            goto L38
        L6a:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "No parameter with index "
            r13.append(r14)
            r13.append(r6)
            r14 = 43
            r13.append(r14)
            r13.append(r3)
            java.lang.String r14 = " (name="
            r13.append(r14)
            kotlin.reflect.jvm.internal.impl.name.Name r14 = r12.getName()
            r13.append(r14)
            java.lang.String r14 = " type="
            r13.append(r14)
            r13.append(r8)
            java.lang.String r14 = ") in "
            r13.append(r14)
            r13.append(r1)
            java.lang.String r14 = "@ReflectJavaMember"
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r13 = r13.toString()
            r14.<init>(r13)
            throw r14
        Lae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember.getValueParameters(java.lang.reflect.Type[], java.lang.annotation.Annotation[][], boolean):java.util.List");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    public String toString() {
        return getClass().getName() + ": " + getMember();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    public ReflectJavaClass getContainingClass() {
        Class<?> declaringClass = getMember().getDeclaringClass();
        m.f(declaringClass, "member.declaringClass");
        return new ReflectJavaClass(declaringClass);
    }
}