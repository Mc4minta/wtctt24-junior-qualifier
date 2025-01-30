package com.toshi.view.custom.recoveryPhrase.keyboard.m;

import com.appsflyer.share.Constants;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: KeyboardLayout.kt */
/* loaded from: classes2.dex */
public abstract class a {
    public static final d a = new d(null);

    /* compiled from: KeyboardLayout.kt */
    /* renamed from: com.toshi.view.custom.recoveryPhrase.keyboard.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0243a extends a {
        @Override // com.toshi.view.custom.recoveryPhrase.keyboard.m.a
        public List<com.toshi.view.custom.recoveryPhrase.keyboard.m.b> a() {
            List j2;
            List j3;
            List j4;
            List j5;
            List<com.toshi.view.custom.recoveryPhrase.keyboard.m.b> j6;
            j2 = r.j("a", "b", Constants.URL_CAMPAIGN, "d", "e", "f", "g", "h", "i", "j");
            j3 = r.j("k", "l", "m", "n", "o", "p", "q", "r", "s");
            j4 = r.j(b.SHIFT, "t", "u", "v", "w", "x", "y", "z", b.BACKSPACE);
            j5 = r.j(b.LANGUAGE, b.SPACEBAR, b.RETURN);
            j6 = r.j(new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j2), new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j3), new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j4), new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j5));
            return j6;
        }

        @Override // com.toshi.view.custom.recoveryPhrase.keyboard.m.a
        public boolean b(Object key) {
            m.g(key, "key");
            return m.c(key, "j") || m.c(key, "s") || key == b.BACKSPACE || key == b.RETURN;
        }
    }

    /* compiled from: KeyboardLayout.kt */
    /* loaded from: classes2.dex */
    public enum b {
        BACKSPACE,
        SHIFT,
        SPACEBAR,
        RETURN,
        LANGUAGE
    }

    /* compiled from: KeyboardLayout.kt */
    /* loaded from: classes2.dex */
    public static final class c extends a {
        @Override // com.toshi.view.custom.recoveryPhrase.keyboard.m.a
        public List<com.toshi.view.custom.recoveryPhrase.keyboard.m.b> a() {
            List j2;
            List j3;
            List j4;
            List j5;
            List<com.toshi.view.custom.recoveryPhrase.keyboard.m.b> j6;
            j2 = r.j("a", "z", "e", "r", "t", "y", "u", "i", "o", "p");
            j3 = r.j("q", "s", "d", "f", "g", "h", "j", "k", "l");
            j4 = r.j(b.SHIFT, "m", "w", "x", Constants.URL_CAMPAIGN, "v", "b", "n", b.BACKSPACE);
            j5 = r.j(b.LANGUAGE, b.SPACEBAR, b.RETURN);
            j6 = r.j(new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j2), new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j3), new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j4), new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j5));
            return j6;
        }

        @Override // com.toshi.view.custom.recoveryPhrase.keyboard.m.a
        public boolean b(Object key) {
            m.g(key, "key");
            return m.c(key, "p") || m.c(key, "l") || key == b.BACKSPACE || key == b.RETURN;
        }
    }

    /* compiled from: KeyboardLayout.kt */
    /* loaded from: classes2.dex */
    public static final class d {

        /* compiled from: KeyboardLayout.kt */
        /* renamed from: com.toshi.view.custom.recoveryPhrase.keyboard.m.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public /* synthetic */ class C0244a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[e.values().length];
                iArr[e.QWERTY.ordinal()] = 1;
                iArr[e.ABCDEF.ordinal()] = 2;
                iArr[e.QWERTZ.ordinal()] = 3;
                iArr[e.AZERTY.ordinal()] = 4;
                a = iArr;
            }
        }

        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(e layout) {
            m.g(layout, "layout");
            int i2 = C0244a.a[layout.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return new c();
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return new g();
                }
                return new C0243a();
            }
            return new f();
        }
    }

    /* compiled from: KeyboardLayout.kt */
    /* loaded from: classes2.dex */
    public enum e {
        QWERTY,
        ABCDEF,
        QWERTZ,
        AZERTY
    }

    /* compiled from: KeyboardLayout.kt */
    /* loaded from: classes2.dex */
    public static final class f extends a {
        @Override // com.toshi.view.custom.recoveryPhrase.keyboard.m.a
        public List<com.toshi.view.custom.recoveryPhrase.keyboard.m.b> a() {
            List j2;
            List j3;
            List j4;
            List j5;
            List<com.toshi.view.custom.recoveryPhrase.keyboard.m.b> j6;
            j2 = r.j("q", "w", "e", "r", "t", "y", "u", "i", "o", "p");
            j3 = r.j("a", "s", "d", "f", "g", "h", "j", "k", "l");
            j4 = r.j(b.SHIFT, "z", "x", Constants.URL_CAMPAIGN, "v", "b", "n", "m", b.BACKSPACE);
            j5 = r.j(b.LANGUAGE, b.SPACEBAR, b.RETURN);
            j6 = r.j(new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j2), new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j3), new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j4), new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j5));
            return j6;
        }

        @Override // com.toshi.view.custom.recoveryPhrase.keyboard.m.a
        public boolean b(Object key) {
            m.g(key, "key");
            return m.c(key, "p") || m.c(key, "l") || key == b.BACKSPACE || key == b.RETURN;
        }
    }

    /* compiled from: KeyboardLayout.kt */
    /* loaded from: classes2.dex */
    public static final class g extends a {
        @Override // com.toshi.view.custom.recoveryPhrase.keyboard.m.a
        public List<com.toshi.view.custom.recoveryPhrase.keyboard.m.b> a() {
            List j2;
            List j3;
            List j4;
            List j5;
            List<com.toshi.view.custom.recoveryPhrase.keyboard.m.b> j6;
            j2 = r.j("q", "w", "e", "r", "t", "z", "u", "i", "o", "p");
            j3 = r.j("a", "s", "d", "f", "g", "h", "j", "k", "l");
            j4 = r.j(b.SHIFT, "y", "x", Constants.URL_CAMPAIGN, "v", "b", "n", "m", b.BACKSPACE);
            j5 = r.j(b.LANGUAGE, b.SPACEBAR, b.RETURN);
            j6 = r.j(new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j2), new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j3), new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j4), new com.toshi.view.custom.recoveryPhrase.keyboard.m.b(j5));
            return j6;
        }

        @Override // com.toshi.view.custom.recoveryPhrase.keyboard.m.a
        public boolean b(Object key) {
            m.g(key, "key");
            return m.c(key, "p") || m.c(key, "l") || key == b.BACKSPACE || key == b.RETURN;
        }
    }

    public abstract List<com.toshi.view.custom.recoveryPhrase.keyboard.m.b> a();

    public abstract boolean b(Object obj);
}