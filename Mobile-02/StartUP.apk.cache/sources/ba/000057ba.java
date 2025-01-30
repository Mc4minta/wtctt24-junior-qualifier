package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: ClassLiteralValue.kt */
/* loaded from: classes3.dex */
public final class ClassLiteralValue {
    private final int arrayNestedness;
    private final ClassId classId;

    public ClassLiteralValue(ClassId classId, int i2) {
        m.g(classId, "classId");
        this.classId = classId;
        this.arrayNestedness = i2;
    }

    public final ClassId component1() {
        return this.classId;
    }

    public final int component2() {
        return this.arrayNestedness;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClassLiteralValue) {
            ClassLiteralValue classLiteralValue = (ClassLiteralValue) obj;
            return m.c(this.classId, classLiteralValue.classId) && this.arrayNestedness == classLiteralValue.arrayNestedness;
        }
        return false;
    }

    public final int getArrayNestedness() {
        return this.arrayNestedness;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public int hashCode() {
        return (this.classId.hashCode() * 31) + this.arrayNestedness;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int arrayNestedness = getArrayNestedness();
        for (int i2 = 0; i2 < arrayNestedness; i2++) {
            sb.append("kotlin/Array<");
        }
        sb.append(getClassId());
        int arrayNestedness2 = getArrayNestedness();
        for (int i3 = 0; i3 < arrayNestedness2; i3++) {
            sb.append(">");
        }
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}