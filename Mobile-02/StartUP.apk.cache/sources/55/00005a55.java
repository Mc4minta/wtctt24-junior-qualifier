package l.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: Timber.java */
/* loaded from: classes3.dex */
public final class a {
    private static final b[] a;

    /* renamed from: c  reason: collision with root package name */
    static volatile b[] f17550c;

    /* renamed from: b  reason: collision with root package name */
    private static final List<b> f17549b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private static final b f17551d = new C0424a();

    /* compiled from: Timber.java */
    /* renamed from: l.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0424a extends b {
        C0424a() {
        }

        @Override // l.a.a.b
        public void a(String str, Object... objArr) {
            for (b bVar : a.f17550c) {
                bVar.a(str, objArr);
            }
        }

        @Override // l.a.a.b
        public void b(Throwable th) {
            for (b bVar : a.f17550c) {
                bVar.b(th);
            }
        }

        @Override // l.a.a.b
        public void c(Throwable th, String str, Object... objArr) {
            for (b bVar : a.f17550c) {
                bVar.c(th, str, objArr);
            }
        }

        @Override // l.a.a.b
        public void d(String str, Object... objArr) {
            for (b bVar : a.f17550c) {
                bVar.d(str, objArr);
            }
        }

        @Override // l.a.a.b
        public void e(Throwable th) {
            for (b bVar : a.f17550c) {
                bVar.e(th);
            }
        }

        @Override // l.a.a.b
        public void f(Throwable th, String str, Object... objArr) {
            for (b bVar : a.f17550c) {
                bVar.f(th, str, objArr);
            }
        }

        @Override // l.a.a.b
        public void j(String str, Object... objArr) {
            for (b bVar : a.f17550c) {
                bVar.j(str, objArr);
            }
        }

        @Override // l.a.a.b
        protected void m(int i2, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }

        @Override // l.a.a.b
        public void o(String str, Object... objArr) {
            for (b bVar : a.f17550c) {
                bVar.o(str, objArr);
            }
        }
    }

    /* compiled from: Timber.java */
    /* loaded from: classes3.dex */
    public static abstract class b {
        final ThreadLocal<String> a = new ThreadLocal<>();

        private String h(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private void n(int i2, Throwable th, String str, Object... objArr) {
            String i3 = i();
            if (l(i3, i2)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = g(str, objArr);
                    }
                    if (th != null) {
                        str = str + "\n" + h(th);
                    }
                } else if (th == null) {
                    return;
                } else {
                    str = h(th);
                }
                m(i2, i3, str, th);
            }
        }

        public void a(String str, Object... objArr) {
            n(3, null, str, objArr);
        }

        public void b(Throwable th) {
            n(3, th, null, new Object[0]);
        }

        public void c(Throwable th, String str, Object... objArr) {
            n(3, th, str, objArr);
        }

        public void d(String str, Object... objArr) {
            n(6, null, str, objArr);
        }

        public void e(Throwable th) {
            n(6, th, null, new Object[0]);
        }

        public void f(Throwable th, String str, Object... objArr) {
            n(6, th, str, objArr);
        }

        protected String g(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        String i() {
            String str = this.a.get();
            if (str != null) {
                this.a.remove();
            }
            return str;
        }

        public void j(String str, Object... objArr) {
            n(4, null, str, objArr);
        }

        @Deprecated
        protected boolean k(int i2) {
            return true;
        }

        protected boolean l(String str, int i2) {
            return k(i2);
        }

        protected abstract void m(int i2, String str, String str2, Throwable th);

        public void o(String str, Object... objArr) {
            n(5, null, str, objArr);
        }
    }

    static {
        b[] bVarArr = new b[0];
        a = bVarArr;
        f17550c = bVarArr;
    }

    public static void a(String str, Object... objArr) {
        f17551d.a(str, objArr);
    }

    public static void b(Throwable th) {
        f17551d.b(th);
    }

    public static void c(Throwable th, String str, Object... objArr) {
        f17551d.c(th, str, objArr);
    }

    public static void d(String str, Object... objArr) {
        f17551d.d(str, objArr);
    }

    public static void e(Throwable th) {
        f17551d.e(th);
    }

    public static void f(Throwable th, String str, Object... objArr) {
        f17551d.f(th, str, objArr);
    }

    public static void g(String str, Object... objArr) {
        f17551d.j(str, objArr);
    }

    public static void h(b bVar) {
        Objects.requireNonNull(bVar, "tree == null");
        if (bVar != f17551d) {
            List<b> list = f17549b;
            synchronized (list) {
                list.add(bVar);
                f17550c = (b[]) list.toArray(new b[list.size()]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot plant Timber into itself.");
    }

    public static void i(String str, Object... objArr) {
        f17551d.o(str, objArr);
    }
}