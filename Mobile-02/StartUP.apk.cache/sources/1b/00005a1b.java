package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Objects;
import kotlin.l0.x;
import kotlin.p;

/* compiled from: StackTraceRecovery.kt */
/* loaded from: classes3.dex */
public final class n {
    private static final String a;

    /* renamed from: b */
    private static final String f17508b;

    static {
        Object a2;
        Object a3;
        try {
            p.a aVar = kotlin.p.a;
            a2 = kotlin.p.a(Class.forName("kotlin.c0.i.a.a").getCanonicalName());
        } catch (Throwable th) {
            p.a aVar2 = kotlin.p.a;
            a2 = kotlin.p.a(kotlin.q.a(th));
        }
        if (kotlin.p.b(a2) != null) {
            a2 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (String) a2;
        try {
            p.a aVar3 = kotlin.p.a;
            a3 = kotlin.p.a(Class.forName("kotlinx.coroutines.internal.n").getCanonicalName());
        } catch (Throwable th2) {
            p.a aVar4 = kotlin.p.a;
            a3 = kotlin.p.a(kotlin.q.a(th2));
        }
        if (kotlin.p.b(a3) != null) {
            a3 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f17508b = (String) a3;
    }

    public static final /* synthetic */ Throwable a(Throwable th, kotlin.c0.i.a.d dVar) {
        return j(th, dVar);
    }

    public static final StackTraceElement b(String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    private static final <E extends Throwable> kotlin.o<E, StackTraceElement[]> c(E e2) {
        boolean z;
        Throwable cause = e2.getCause();
        if (cause != null && kotlin.jvm.internal.m.c(cause.getClass(), e2.getClass())) {
            StackTraceElement[] stackTrace = e2.getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (h(stackTrace[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return kotlin.u.a(cause, stackTrace);
            }
            return kotlin.u.a(e2, new StackTraceElement[0]);
        }
        return kotlin.u.a(e2, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E d(E e2, E e3, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(b("Coroutine boundary"));
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int g2 = g(stackTrace, a);
        int i2 = 0;
        if (g2 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            e3.setStackTrace((StackTraceElement[]) array);
            return e3;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + g2];
        for (int i3 = 0; i3 < g2; i3++) {
            stackTraceElementArr[i3] = stackTrace[i3];
        }
        for (StackTraceElement stackTraceElement : arrayDeque) {
            stackTraceElementArr[g2 + i2] = stackTraceElement;
            i2++;
        }
        e3.setStackTrace(stackTraceElementArr);
        return e3;
    }

    private static final ArrayDeque<StackTraceElement> e(kotlin.c0.i.a.d dVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement d2 = dVar.d();
        if (d2 != null) {
            arrayDeque.add(d2);
        }
        while (dVar != null) {
            dVar = dVar.a();
            if (dVar == null) {
                break;
            }
            StackTraceElement d3 = dVar.d();
            if (d3 != null) {
                arrayDeque.add(d3);
            }
        }
        return arrayDeque;
    }

    private static final boolean f(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && kotlin.jvm.internal.m.c(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && kotlin.jvm.internal.m.c(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && kotlin.jvm.internal.m.c(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int g(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (kotlin.jvm.internal.m.c(str, stackTraceElementArr[i2].getClassName())) {
                return i2;
            }
        }
        return -1;
    }

    public static final boolean h(StackTraceElement stackTraceElement) {
        boolean Q;
        Q = x.Q(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
        return Q;
    }

    private static final void i(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (h(stackTraceElementArr[i2])) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i3) {
            return;
        }
        while (true) {
            if (f(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i3) {
                return;
            }
            length2--;
        }
    }

    public static final <E extends Throwable> E j(E e2, kotlin.c0.i.a.d dVar) {
        kotlin.o c2 = c(e2);
        Throwable th = (Throwable) c2.a();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) c2.b();
        Throwable e3 = f.e(th);
        if (e3 == null || (!kotlin.jvm.internal.m.c(e3.getMessage(), th.getMessage()))) {
            return e2;
        }
        ArrayDeque<StackTraceElement> e4 = e(dVar);
        if (e4.isEmpty()) {
            return e2;
        }
        if (th != e2) {
            i(stackTraceElementArr, e4);
        }
        return (E) d(th, e3, e4);
    }

    public static final <E extends Throwable> E k(E e2) {
        E e3 = (E) e2.getCause();
        if (e3 != null) {
            boolean z = true;
            if (!(!kotlin.jvm.internal.m.c(e3.getClass(), e2.getClass()))) {
                StackTraceElement[] stackTrace = e2.getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    } else if (h(stackTrace[i2])) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return e3;
                }
            }
        }
        return e2;
    }
}