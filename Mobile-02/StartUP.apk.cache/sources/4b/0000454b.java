package e.f.b.b;

import com.facebook.common.file.FileUtils;
import e.f.b.a.a;
import e.f.b.b.d;
import e.f.d.c.l;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/* compiled from: DynamicDefaultDiskStorage.java */
/* loaded from: classes2.dex */
public class f implements d {
    private static final Class<?> a = f.class;

    /* renamed from: b  reason: collision with root package name */
    private final int f12050b;

    /* renamed from: c  reason: collision with root package name */
    private final l<File> f12051c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12052d;

    /* renamed from: e  reason: collision with root package name */
    private final e.f.b.a.a f12053e;

    /* renamed from: f  reason: collision with root package name */
    volatile a f12054f = new a(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DynamicDefaultDiskStorage.java */
    /* loaded from: classes2.dex */
    public static class a {
        public final d a;

        /* renamed from: b  reason: collision with root package name */
        public final File f12055b;

        a(File file, d dVar) {
            this.a = dVar;
            this.f12055b = file;
        }
    }

    public f(int i2, l<File> lVar, String str, e.f.b.a.a aVar) {
        this.f12050b = i2;
        this.f12053e = aVar;
        this.f12051c = lVar;
        this.f12052d = str;
    }

    private void j() throws IOException {
        File file = new File(this.f12051c.get(), this.f12052d);
        i(file);
        this.f12054f = new a(file, new e.f.b.b.a(file, this.f12050b, this.f12053e));
    }

    private boolean m() {
        File file;
        a aVar = this.f12054f;
        return aVar.a == null || (file = aVar.f12055b) == null || !file.exists();
    }

    @Override // e.f.b.b.d
    public void a() throws IOException {
        l().a();
    }

    @Override // e.f.b.b.d
    public void b() {
        try {
            l().b();
        } catch (IOException e2) {
            e.f.d.d.a.f(a, "purgeUnexpectedResources", e2);
        }
    }

    @Override // e.f.b.b.d
    public d.b c(String str, Object obj) throws IOException {
        return l().c(str, obj);
    }

    @Override // e.f.b.b.d
    public boolean d(String str, Object obj) throws IOException {
        return l().d(str, obj);
    }

    @Override // e.f.b.b.d
    public e.f.a.a e(String str, Object obj) throws IOException {
        return l().e(str, obj);
    }

    @Override // e.f.b.b.d
    public Collection<d.a> f() throws IOException {
        return l().f();
    }

    @Override // e.f.b.b.d
    public long g(String str) throws IOException {
        return l().g(str);
    }

    @Override // e.f.b.b.d
    public long h(d.a aVar) throws IOException {
        return l().h(aVar);
    }

    void i(File file) throws IOException {
        try {
            FileUtils.a(file);
            e.f.d.d.a.a(a, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e2) {
            this.f12053e.a(a.EnumC0260a.WRITE_CREATE_DIR, a, "createRootDirectoryIfNecessary", e2);
            throw e2;
        }
    }

    @Override // e.f.b.b.d
    public boolean isExternal() {
        try {
            return l().isExternal();
        } catch (IOException unused) {
            return false;
        }
    }

    void k() {
        if (this.f12054f.a == null || this.f12054f.f12055b == null) {
            return;
        }
        com.facebook.common.file.a.b(this.f12054f.f12055b);
    }

    synchronized d l() throws IOException {
        if (m()) {
            k();
            j();
        }
        return (d) e.f.d.c.i.g(this.f12054f.a);
    }
}