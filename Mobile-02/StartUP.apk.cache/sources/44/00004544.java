package e.f.b.b;

import java.io.IOException;
import java.util.Collection;

/* compiled from: DiskStorage.java */
/* loaded from: classes2.dex */
public interface d {

    /* compiled from: DiskStorage.java */
    /* loaded from: classes2.dex */
    public interface a {
        long a();

        String getId();

        long getSize();
    }

    /* compiled from: DiskStorage.java */
    /* loaded from: classes2.dex */
    public interface b {
        boolean h();

        void i(e.f.b.a.j jVar, Object obj) throws IOException;

        e.f.a.a j(Object obj) throws IOException;
    }

    void a() throws IOException;

    void b();

    b c(String str, Object obj) throws IOException;

    boolean d(String str, Object obj) throws IOException;

    e.f.a.a e(String str, Object obj) throws IOException;

    Collection<a> f() throws IOException;

    long g(String str) throws IOException;

    long h(a aVar) throws IOException;

    boolean isExternal();
}