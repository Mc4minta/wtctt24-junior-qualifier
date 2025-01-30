package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: RenderingUtils.kt */
/* loaded from: classes3.dex */
public final class RenderingUtilsKt {
    public static final String render(Name name) {
        m.g(name, "<this>");
        if (!shouldBeEscaped(name)) {
            String asString = name.asString();
            m.f(asString, "asString()");
            return asString;
        }
        String asString2 = name.asString();
        m.f(asString2, "asString()");
        return m.o(String.valueOf('`') + asString2, "`");
    }

    public static final String renderFqName(List<Name> pathSegments) {
        m.g(pathSegments, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (Name name : pathSegments) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render(name));
        }
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final boolean shouldBeEscaped(Name name) {
        boolean z;
        if (name.isSpecial()) {
            return false;
        }
        String asString = name.asString();
        m.f(asString, "asString()");
        if (!KeywordStringsGenerated.KEYWORDS.contains(asString)) {
            int i2 = 0;
            while (true) {
                if (i2 >= asString.length()) {
                    z = false;
                    break;
                }
                char charAt = asString.charAt(i2);
                if ((Character.isLetterOrDigit(charAt) || charAt == '_') ? false : true) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static final String render(FqNameUnsafe fqNameUnsafe) {
        m.g(fqNameUnsafe, "<this>");
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        m.f(pathSegments, "pathSegments()");
        return renderFqName(pathSegments);
    }
}