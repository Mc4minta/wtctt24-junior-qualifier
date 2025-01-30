package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.m;
import kotlin.l0.k;

/* compiled from: NameUtils.kt */
/* loaded from: classes3.dex */
public final class NameUtils {
    public static final NameUtils INSTANCE = new NameUtils();
    private static final k SANITIZE_AS_JAVA_INVALID_CHARACTERS = new k("[^\\p{L}\\p{Digit}]");

    private NameUtils() {
    }

    public static final String sanitizeAsJavaIdentifier(String name) {
        m.g(name, "name");
        return SANITIZE_AS_JAVA_INVALID_CHARACTERS.e(name, "_");
    }
}