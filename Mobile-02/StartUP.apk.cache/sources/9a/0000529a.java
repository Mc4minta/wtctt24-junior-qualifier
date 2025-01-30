package kotlin.l0;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class l {
    /* JADX INFO: Access modifiers changed from: private */
    public static final i f(Matcher matcher, int i2, CharSequence charSequence) {
        if (matcher.find(i2)) {
            return new j(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i g(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new j(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.i0.c h(MatchResult matchResult) {
        return kotlin.i0.d.j(matchResult.start(), matchResult.end());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.i0.c i(MatchResult matchResult, int i2) {
        return kotlin.i0.d.j(matchResult.start(i2), matchResult.end(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(Iterable<? extends f> iterable) {
        int i2 = 0;
        for (f fVar : iterable) {
            i2 |= fVar.getValue();
        }
        return i2;
    }
}