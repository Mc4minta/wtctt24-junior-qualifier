package kotlin.l0;

import java.util.List;

/* compiled from: MatchResult.kt */
/* loaded from: classes3.dex */
public interface i {

    /* compiled from: MatchResult.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static b a(i iVar) {
            return new b(iVar);
        }
    }

    /* compiled from: MatchResult.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private final i a;

        public b(i match) {
            kotlin.jvm.internal.m.g(match, "match");
            this.a = match;
        }

        public final i a() {
            return this.a;
        }
    }

    b a();

    List<String> b();

    h c();

    kotlin.i0.c d();

    String getValue();
}