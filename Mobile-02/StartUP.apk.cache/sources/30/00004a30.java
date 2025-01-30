package e.j.l;

import kotlin.jvm.internal.m;
import org.apache.http.message.TokenParser;

/* compiled from: ViewUtil.kt */
/* loaded from: classes2.dex */
public final class l {
    public static final l a = new l();

    private l() {
    }

    public final CharSequence a(int i2, String base) {
        StringBuilder sb;
        m.g(base, "base");
        if (i2 == -1 || i2 == 1) {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append(TokenParser.SP);
            sb.append(base);
        } else {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append(TokenParser.SP);
            sb.append(base);
            sb.append('s');
        }
        return sb.toString();
    }
}