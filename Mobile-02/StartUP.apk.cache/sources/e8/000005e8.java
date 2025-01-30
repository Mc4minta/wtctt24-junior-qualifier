package c.o.a;

import android.os.Bundle;
import androidx.lifecycle.g0;
import androidx.lifecycle.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: LoaderManager.java */
    /* renamed from: c.o.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0077a<D> {
        void a(c.o.b.b<D> bVar, D d2);

        c.o.b.b<D> b(int i2, Bundle bundle);

        void c(c.o.b.b<D> bVar);
    }

    public static <T extends o & g0> a b(T t) {
        return new b(t, t.getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> c.o.b.b<D> c(int i2, Bundle bundle, InterfaceC0077a<D> interfaceC0077a);

    public abstract void d();
}