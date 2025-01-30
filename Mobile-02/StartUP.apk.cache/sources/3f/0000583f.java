package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: NameResolverUtil.kt */
/* loaded from: classes3.dex */
public final class NameResolverUtilKt {
    public static final ClassId getClassId(NameResolver nameResolver, int i2) {
        m.g(nameResolver, "<this>");
        ClassId fromString = ClassId.fromString(nameResolver.getQualifiedClassName(i2), nameResolver.isLocalClassName(i2));
        m.f(fromString, "fromString(getQualifiedClassName(index), isLocalClassName(index))");
        return fromString;
    }

    public static final Name getName(NameResolver nameResolver, int i2) {
        m.g(nameResolver, "<this>");
        Name guessByFirstCharacter = Name.guessByFirstCharacter(nameResolver.getString(i2));
        m.f(guessByFirstCharacter, "guessByFirstCharacter(getString(index))");
        return guessByFirstCharacter;
    }
}