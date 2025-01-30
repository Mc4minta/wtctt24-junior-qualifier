package e.f.j.e;

import com.facebook.common.references.SharedReference;
import com.facebook.common.references.a;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: CloseableReferenceFactory.java */
/* loaded from: classes2.dex */
public class a {
    private final a.c a;

    /* compiled from: CloseableReferenceFactory.java */
    /* renamed from: e.f.j.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0275a implements a.c {
        final /* synthetic */ e.f.j.g.a a;

        C0275a(e.f.j.g.a aVar) {
            this.a = aVar;
        }

        @Override // com.facebook.common.references.a.c
        public void a(SharedReference<Object> sharedReference, Throwable th) {
            this.a.b(sharedReference, th);
            e.f.d.d.a.C("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), sharedReference.f().getClass().getName(), a.d(th));
        }

        @Override // com.facebook.common.references.a.c
        public boolean b() {
            return this.a.a();
        }
    }

    public a(e.f.j.g.a aVar) {
        this.a = new C0275a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public <U extends Closeable> com.facebook.common.references.a<U> b(U u) {
        return com.facebook.common.references.a.N(u, this.a);
    }

    public <T> com.facebook.common.references.a<T> c(T t, com.facebook.common.references.c<T> cVar) {
        return com.facebook.common.references.a.n0(t, cVar, this.a);
    }
}