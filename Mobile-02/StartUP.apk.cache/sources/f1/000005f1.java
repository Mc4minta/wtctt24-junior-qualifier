package c.o.b;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader.java */
/* loaded from: classes.dex */
public class b<D> {
    int a;

    /* renamed from: b  reason: collision with root package name */
    InterfaceC0080b<D> f3165b;

    /* renamed from: c  reason: collision with root package name */
    a<D> f3166c;

    /* renamed from: d  reason: collision with root package name */
    Context f3167d;

    /* renamed from: e  reason: collision with root package name */
    boolean f3168e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f3169f = false;

    /* renamed from: g  reason: collision with root package name */
    boolean f3170g = true;

    /* renamed from: h  reason: collision with root package name */
    boolean f3171h = false;

    /* renamed from: i  reason: collision with root package name */
    boolean f3172i = false;

    /* compiled from: Loader.java */
    /* loaded from: classes.dex */
    public interface a<D> {
        void a(b<D> bVar);
    }

    /* compiled from: Loader.java */
    /* renamed from: c.o.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0080b<D> {
        void a(b<D> bVar, D d2);
    }

    public b(Context context) {
        this.f3167d = context.getApplicationContext();
    }

    public void a() {
        this.f3169f = true;
        j();
    }

    public boolean b() {
        return k();
    }

    public void c() {
        this.f3172i = false;
    }

    public String d(D d2) {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.util.b.a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    public void e() {
        a<D> aVar = this.f3166c;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void f(D d2) {
        InterfaceC0080b<D> interfaceC0080b = this.f3165b;
        if (interfaceC0080b != null) {
            interfaceC0080b.a(this, d2);
        }
    }

    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.f3165b);
        if (this.f3168e || this.f3171h || this.f3172i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f3168e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f3171h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f3172i);
        }
        if (this.f3169f || this.f3170g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f3169f);
            printWriter.print(" mReset=");
            printWriter.println(this.f3170g);
        }
    }

    public void h() {
        m();
    }

    public boolean i() {
        return this.f3169f;
    }

    protected void j() {
    }

    protected boolean k() {
        throw null;
    }

    public void l() {
        if (this.f3168e) {
            h();
        } else {
            this.f3171h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
    }

    protected void n() {
    }

    protected void o() {
        throw null;
    }

    protected void p() {
    }

    public void q(int i2, InterfaceC0080b<D> interfaceC0080b) {
        if (this.f3165b == null) {
            this.f3165b = interfaceC0080b;
            this.a = i2;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void r() {
        n();
        this.f3170g = true;
        this.f3168e = false;
        this.f3169f = false;
        this.f3171h = false;
        this.f3172i = false;
    }

    public void s() {
        if (this.f3172i) {
            l();
        }
    }

    public final void t() {
        this.f3168e = true;
        this.f3170g = false;
        this.f3169f = false;
        o();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.util.b.a(this, sb);
        sb.append(" id=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }

    public void u() {
        this.f3168e = false;
        p();
    }

    public void v(InterfaceC0080b<D> interfaceC0080b) {
        InterfaceC0080b<D> interfaceC0080b2 = this.f3165b;
        if (interfaceC0080b2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0080b2 == interfaceC0080b) {
            this.f3165b = null;
            return;
        }
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
}