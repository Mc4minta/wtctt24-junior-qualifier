package kotlin.d0;

import java.lang.reflect.Method;
import kotlin.jvm.internal.m;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes3.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlatformImplementations.kt */
    /* renamed from: kotlin.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0415a {
        public static final Method a;

        /* renamed from: b  reason: collision with root package name */
        public static final Method f17271b;

        /* renamed from: c  reason: collision with root package name */
        public static final C0415a f17272c = new C0415a();

        /* JADX WARN: Removed duplicated region for block: B:13:0x0046 A[LOOP:0: B:3:0x0015->B:13:0x0046, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[EDGE_INSN: B:23:0x004a->B:15:0x004a ?: BREAK  , SYNTHETIC] */
        static {
            /*
                kotlin.d0.a$a r0 = new kotlin.d0.a$a
                r0.<init>()
                kotlin.d0.a.C0415a.f17272c = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.jvm.internal.m.f(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = r3
            L15:
                java.lang.String r5 = "it"
                r6 = 0
                if (r4 >= r2) goto L49
                r7 = r1[r4]
                kotlin.jvm.internal.m.f(r7, r5)
                java.lang.String r8 = r7.getName()
                java.lang.String r9 = "addSuppressed"
                boolean r8 = kotlin.jvm.internal.m.c(r8, r9)
                if (r8 == 0) goto L42
                java.lang.Class[] r8 = r7.getParameterTypes()
                java.lang.String r9 = "it.parameterTypes"
                kotlin.jvm.internal.m.f(r8, r9)
                java.lang.Object r8 = kotlin.a0.j.S(r8)
                java.lang.Class r8 = (java.lang.Class) r8
                boolean r8 = kotlin.jvm.internal.m.c(r8, r0)
                if (r8 == 0) goto L42
                r8 = 1
                goto L43
            L42:
                r8 = r3
            L43:
                if (r8 == 0) goto L46
                goto L4a
            L46:
                int r4 = r4 + 1
                goto L15
            L49:
                r7 = r6
            L4a:
                kotlin.d0.a.C0415a.a = r7
                int r0 = r1.length
            L4d:
                if (r3 >= r0) goto L65
                r2 = r1[r3]
                kotlin.jvm.internal.m.f(r2, r5)
                java.lang.String r4 = r2.getName()
                java.lang.String r7 = "getSuppressed"
                boolean r4 = kotlin.jvm.internal.m.c(r4, r7)
                if (r4 == 0) goto L62
                r6 = r2
                goto L65
            L62:
                int r3 = r3 + 1
                goto L4d
            L65:
                kotlin.d0.a.C0415a.f17271b = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.d0.a.C0415a.<clinit>():void");
        }

        private C0415a() {
        }
    }

    public void a(Throwable cause, Throwable exception) {
        m.g(cause, "cause");
        m.g(exception, "exception");
        Method method = C0415a.a;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public kotlin.h0.c b() {
        return new kotlin.h0.b();
    }
}