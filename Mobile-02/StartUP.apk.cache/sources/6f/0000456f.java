package e.f.d.d;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: FLogDefaultLoggingDelegate.java */
/* loaded from: classes2.dex */
public class b implements c {
    public static final b a = new b();

    /* renamed from: b  reason: collision with root package name */
    private String f12074b = "unknown";

    /* renamed from: c  reason: collision with root package name */
    private int f12075c = 5;

    private b() {
    }

    public static b l() {
        return a;
    }

    private static String m(String str, Throwable th) {
        return str + '\n' + n(th);
    }

    private static String n(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private String o(String str) {
        if (this.f12074b != null) {
            return this.f12074b + ":" + str;
        }
        return str;
    }

    private void p(int i2, String str, String str2) {
        Log.println(i2, o(str), str2);
    }

    private void q(int i2, String str, String str2, Throwable th) {
        Log.println(i2, o(str), m(str2, th));
    }

    @Override // e.f.d.d.c
    public void a(String str, String str2, Throwable th) {
        q(6, str, str2, th);
    }

    @Override // e.f.d.d.c
    public void b(String str, String str2) {
        p(5, str, str2);
    }

    @Override // e.f.d.d.c
    public void c(String str, String str2, Throwable th) {
        q(5, str, str2, th);
    }

    @Override // e.f.d.d.c
    public void d(String str, String str2) {
        p(6, str, str2);
    }

    @Override // e.f.d.d.c
    public void e(String str, String str2) {
        p(2, str, str2);
    }

    @Override // e.f.d.d.c
    public void f(String str, String str2) {
        p(6, str, str2);
    }

    @Override // e.f.d.d.c
    public void g(String str, String str2, Throwable th) {
        q(6, str, str2, th);
    }

    @Override // e.f.d.d.c
    public void h(String str, String str2) {
        p(3, str, str2);
    }

    @Override // e.f.d.d.c
    public void i(String str, String str2, Throwable th) {
        q(3, str, str2, th);
    }

    @Override // e.f.d.d.c
    public boolean j(int i2) {
        return this.f12075c <= i2;
    }

    @Override // e.f.d.d.c
    public void k(String str, String str2) {
        p(4, str, str2);
    }
}