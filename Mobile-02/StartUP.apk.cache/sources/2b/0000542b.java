package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Map;
import kotlin.a0.j0;
import kotlin.jvm.internal.m;

/* compiled from: Visibilities.kt */
/* loaded from: classes3.dex */
public final class Visibilities {
    private static final Public DEFAULT_VISIBILITY;
    public static final Visibilities INSTANCE = new Visibilities();
    private static final Map<Visibility, Integer> ORDERED_VISIBILITIES;

    /* compiled from: Visibilities.kt */
    /* loaded from: classes3.dex */
    public static final class Inherited extends Visibility {
        public static final Inherited INSTANCE = new Inherited();

        private Inherited() {
            super("inherited", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: classes3.dex */
    public static final class Internal extends Visibility {
        public static final Internal INSTANCE = new Internal();

        private Internal() {
            super("internal", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: classes3.dex */
    public static final class InvisibleFake extends Visibility {
        public static final InvisibleFake INSTANCE = new InvisibleFake();

        private InvisibleFake() {
            super("invisible_fake", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: classes3.dex */
    public static final class Local extends Visibility {
        public static final Local INSTANCE = new Local();

        private Local() {
            super("local", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: classes3.dex */
    public static final class Private extends Visibility {
        public static final Private INSTANCE = new Private();

        private Private() {
            super("private", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: classes3.dex */
    public static final class PrivateToThis extends Visibility {
        public static final PrivateToThis INSTANCE = new PrivateToThis();

        private PrivateToThis() {
            super("private_to_this", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: classes3.dex */
    public static final class Protected extends Visibility {
        public static final Protected INSTANCE = new Protected();

        private Protected() {
            super("protected", true);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: classes3.dex */
    public static final class Public extends Visibility {
        public static final Public INSTANCE = new Public();

        private Public() {
            super("public", true);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: classes3.dex */
    public static final class Unknown extends Visibility {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super("unknown", false);
        }
    }

    static {
        Map c2 = j0.c();
        c2.put(PrivateToThis.INSTANCE, 0);
        c2.put(Private.INSTANCE, 0);
        c2.put(Internal.INSTANCE, 1);
        c2.put(Protected.INSTANCE, 1);
        Public r1 = Public.INSTANCE;
        c2.put(r1, 2);
        ORDERED_VISIBILITIES = j0.b(c2);
        DEFAULT_VISIBILITY = r1;
    }

    private Visibilities() {
    }

    public final Integer compareLocal$compiler_common(Visibility first, Visibility second) {
        m.g(first, "first");
        m.g(second, "second");
        if (first == second) {
            return 0;
        }
        Map<Visibility, Integer> map = ORDERED_VISIBILITIES;
        Integer num = map.get(first);
        Integer num2 = map.get(second);
        if (num == null || num2 == null || m.c(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean isPrivate(Visibility visibility) {
        m.g(visibility, "visibility");
        return visibility == Private.INSTANCE || visibility == PrivateToThis.INSTANCE;
    }
}