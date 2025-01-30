package e.j.f;

import android.text.Spanned;
import android.util.Patterns;
import com.coinbase.wallet.common.extensions.String_CommonKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

/* compiled from: StringExtensions.kt */
/* loaded from: classes2.dex */
public final class u {
    public static final String a(String str, int i2) {
        kotlin.jvm.internal.m.g(str, "<this>");
        if (str.length() <= i2) {
            return str;
        }
        String substring = str.substring(0, i2 - 3);
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return kotlin.jvm.internal.m.o(substring, "...");
    }

    public static final Spanned b(String str) {
        kotlin.jvm.internal.m.g(str, "<this>");
        return String_CommonKt.fromHtmlCompat(str);
    }

    public static final boolean c(String str) {
        CharSequence h1;
        kotlin.jvm.internal.m.g(str, "<this>");
        Pattern pattern = Patterns.WEB_URL;
        h1 = kotlin.l0.y.h1(str);
        return pattern.matcher(h1.toString()).matches();
    }

    public static final String d(String str, String salt) {
        kotlin.jvm.internal.m.g(str, "<this>");
        kotlin.jvm.internal.m.g(salt, "salt");
        String o = kotlin.jvm.internal.m.o(str, salt);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        Charset charset = kotlin.l0.d.a;
        Objects.requireNonNull(o, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = o.getBytes(charset);
        kotlin.jvm.internal.m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] digest = messageDigest.digest(bytes);
        kotlin.jvm.internal.m.f(digest, "md.digest(saltedMnemonic.toByteArray())");
        return f.a(digest);
    }

    public static final String e(String str, String searchUrlPattern) {
        kotlin.jvm.internal.m.g(str, "<this>");
        kotlin.jvm.internal.m.g(searchUrlPattern, "searchUrlPattern");
        String format = String.format(searchUrlPattern, Arrays.copyOf(new Object[]{URLEncoder.encode(str, "UTF-8")}, 1));
        kotlin.jvm.internal.m.f(format, "java.lang.String.format(this, *args)");
        return format;
    }

    public static final String f(String str, int i2, String omission) {
        kotlin.jvm.internal.m.g(str, "<this>");
        kotlin.jvm.internal.m.g(omission, "omission");
        if (str.length() > i2) {
            String substring = str.substring(0, i2);
            kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return kotlin.jvm.internal.m.o(substring, omission);
        }
        return str;
    }

    public static /* synthetic */ String g(String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
        }
        return f(str, i2, str2);
    }
}