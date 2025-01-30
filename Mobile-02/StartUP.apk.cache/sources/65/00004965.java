package e.j.f;

import java.util.List;
import kotlin.a0.e0;
import org.apache.http.message.TokenParser;

/* compiled from: CollectionExtensions.kt */
/* loaded from: classes2.dex */
public final class g {

    /* compiled from: CollectionExtensions.kt */
    /* loaded from: classes2.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, CharSequence> {
        public static final a a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public final CharSequence invoke(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            return TokenParser.DQUOTE + it + TokenParser.DQUOTE;
        }
    }

    public static final <T> Iterable<e0<T>> a(Iterable<? extends T> iterable) {
        Iterable<e0<T>> P0;
        kotlin.jvm.internal.m.g(iterable, "<this>");
        P0 = kotlin.a0.z.P0(iterable);
        return P0;
    }

    public static final String b(List<String> list) {
        String h0;
        kotlin.jvm.internal.m.g(list, "<this>");
        h0 = kotlin.a0.z.h0(list, ",", "[", "]", 0, null, a.a, 24, null);
        return h0;
    }
}