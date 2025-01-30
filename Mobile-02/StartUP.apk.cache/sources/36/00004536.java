package e.f.b.b;

import android.os.Environment;
import com.coinbase.ApiConstants;
import com.facebook.common.file.FileUtils;
import e.f.b.a.a;
import e.f.b.b.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: DefaultDiskStorage.java */
/* loaded from: classes2.dex */
public class a implements e.f.b.b.d {
    private static final Class<?> a = a.class;

    /* renamed from: b  reason: collision with root package name */
    static final long f11998b = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: c  reason: collision with root package name */
    private final File f11999c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f12000d;

    /* renamed from: e  reason: collision with root package name */
    private final File f12001e;

    /* renamed from: f  reason: collision with root package name */
    private final e.f.b.a.a f12002f;

    /* renamed from: g  reason: collision with root package name */
    private final com.facebook.common.time.a f12003g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultDiskStorage.java */
    /* loaded from: classes2.dex */
    public class b implements com.facebook.common.file.b {
        private final List<d.a> a;

        private b() {
            this.a = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void a(File file) {
            d u = a.this.u(file);
            if (u == null || u.a != ".cnt") {
                return;
            }
            this.a.add(new c(u.f12008b, file));
        }

        @Override // com.facebook.common.file.b
        public void b(File file) {
        }

        @Override // com.facebook.common.file.b
        public void c(File file) {
        }

        public List<d.a> d() {
            return Collections.unmodifiableList(this.a);
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    /* loaded from: classes2.dex */
    static class c implements d.a {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final e.f.a.b f12005b;

        /* renamed from: c  reason: collision with root package name */
        private long f12006c;

        /* renamed from: d  reason: collision with root package name */
        private long f12007d;

        @Override // e.f.b.b.d.a
        public long a() {
            if (this.f12007d < 0) {
                this.f12007d = this.f12005b.c().lastModified();
            }
            return this.f12007d;
        }

        public e.f.a.b b() {
            return this.f12005b;
        }

        @Override // e.f.b.b.d.a
        public String getId() {
            return this.a;
        }

        @Override // e.f.b.b.d.a
        public long getSize() {
            if (this.f12006c < 0) {
                this.f12006c = this.f12005b.size();
            }
            return this.f12006c;
        }

        private c(String str, File file) {
            e.f.d.c.i.g(file);
            this.a = (String) e.f.d.c.i.g(str);
            this.f12005b = e.f.a.b.b(file);
            this.f12006c = -1L;
            this.f12007d = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultDiskStorage.java */
    /* loaded from: classes2.dex */
    public static class d {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final String f12008b;

        public static d b(File file) {
            String s;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (s = a.s(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (s.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new d(s, substring);
            }
            return null;
        }

        public File a(File file) throws IOException {
            return File.createTempFile(this.f12008b + ".", ".tmp", file);
        }

        public String c(String str) {
            return str + File.separator + this.f12008b + this.a;
        }

        public String toString() {
            return this.a + "(" + this.f12008b + ")";
        }

        private d(String str, String str2) {
            this.a = str;
            this.f12008b = str2;
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    /* loaded from: classes2.dex */
    private static class e extends IOException {
        public final long a;

        /* renamed from: b  reason: collision with root package name */
        public final long f12009b;

        public e(long j2, long j3) {
            super("File was not written completely. Expected: " + j2 + ", found: " + j3);
            this.a = j2;
            this.f12009b = j3;
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    /* loaded from: classes2.dex */
    class f implements d.b {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        final File f12010b;

        public f(String str, File file) {
            this.a = str;
            this.f12010b = file;
        }

        @Override // e.f.b.b.d.b
        public boolean h() {
            return !this.f12010b.exists() || this.f12010b.delete();
        }

        @Override // e.f.b.b.d.b
        public void i(e.f.b.a.j jVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f12010b);
                try {
                    e.f.d.c.c cVar = new e.f.d.c.c(fileOutputStream);
                    jVar.a(cVar);
                    cVar.flush();
                    long a = cVar.a();
                    fileOutputStream.close();
                    if (this.f12010b.length() != a) {
                        throw new e(a, this.f12010b.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                a.this.f12002f.a(a.EnumC0260a.WRITE_UPDATE_FILE_NOT_FOUND, a.a, "updateResource", e2);
                throw e2;
            }
        }

        @Override // e.f.b.b.d.b
        public e.f.a.a j(Object obj) throws IOException {
            a.EnumC0260a enumC0260a;
            File q = a.this.q(this.a);
            try {
                FileUtils.b(this.f12010b, q);
                if (q.exists()) {
                    q.setLastModified(a.this.f12003g.now());
                }
                return e.f.a.b.b(q);
            } catch (FileUtils.RenameException e2) {
                Throwable cause = e2.getCause();
                if (cause != null) {
                    if (!(cause instanceof FileUtils.ParentDirNotFoundException)) {
                        if (cause instanceof FileNotFoundException) {
                            enumC0260a = a.EnumC0260a.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                        } else {
                            enumC0260a = a.EnumC0260a.WRITE_RENAME_FILE_OTHER;
                        }
                    } else {
                        enumC0260a = a.EnumC0260a.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                    }
                } else {
                    enumC0260a = a.EnumC0260a.WRITE_RENAME_FILE_OTHER;
                }
                a.this.f12002f.a(enumC0260a, a.a, ApiConstants.COMMIT, e2);
                throw e2;
            }
        }
    }

    /* compiled from: DefaultDiskStorage.java */
    /* loaded from: classes2.dex */
    private class g implements com.facebook.common.file.b {
        private boolean a;

        private g() {
        }

        private boolean d(File file) {
            d u = a.this.u(file);
            if (u == null) {
                return false;
            }
            String str = u.a;
            if (str == ".tmp") {
                return e(file);
            }
            e.f.d.c.i.i(str == ".cnt");
            return true;
        }

        private boolean e(File file) {
            return file.lastModified() > a.this.f12003g.now() - a.f11998b;
        }

        @Override // com.facebook.common.file.b
        public void a(File file) {
            if (this.a && d(file)) {
                return;
            }
            file.delete();
        }

        @Override // com.facebook.common.file.b
        public void b(File file) {
            if (this.a || !file.equals(a.this.f12001e)) {
                return;
            }
            this.a = true;
        }

        @Override // com.facebook.common.file.b
        public void c(File file) {
            if (!a.this.f11999c.equals(file) && !this.a) {
                file.delete();
            }
            if (this.a && file.equals(a.this.f12001e)) {
                this.a = false;
            }
        }
    }

    public a(File file, int i2, e.f.b.a.a aVar) {
        e.f.d.c.i.g(file);
        this.f11999c = file;
        this.f12000d = y(file, aVar);
        this.f12001e = new File(file, x(i2));
        this.f12002f = aVar;
        B();
        this.f12003g = com.facebook.common.time.c.a();
    }

    private boolean A(String str, boolean z) {
        File q = q(str);
        boolean exists = q.exists();
        if (z && exists) {
            q.setLastModified(this.f12003g.now());
        }
        return exists;
    }

    private void B() {
        boolean z = true;
        if (this.f11999c.exists()) {
            if (this.f12001e.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.b(this.f11999c);
            }
        }
        if (z) {
            try {
                FileUtils.a(this.f12001e);
            } catch (FileUtils.CreateDirectoryException unused) {
                e.f.b.a.a aVar = this.f12002f;
                a.EnumC0260a enumC0260a = a.EnumC0260a.WRITE_CREATE_DIR;
                Class<?> cls = a;
                aVar.a(enumC0260a, cls, "version directory could not be created: " + this.f12001e, null);
            }
        }
    }

    private long p(File file) {
        if (file.exists()) {
            long length = file.length();
            if (file.delete()) {
                return length;
            }
            return -1L;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String s(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    private String t(String str) {
        d dVar = new d(".cnt", str);
        return dVar.c(w(dVar.f12008b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d u(File file) {
        d b2 = d.b(file);
        if (b2 != null && v(b2.f12008b).equals(file.getParentFile())) {
            return b2;
        }
        return null;
    }

    private File v(String str) {
        return new File(w(str));
    }

    private String w(String str) {
        String valueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        return this.f12001e + File.separator + valueOf;
    }

    static String x(int i2) {
        return String.format(null, "%s.ols%d.%d", ApiConstants.SERVER_VERSION, 100, Integer.valueOf(i2));
    }

    private static boolean y(File file, e.f.b.a.a aVar) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                return false;
            }
            try {
                try {
                    return file.getCanonicalPath().contains(externalStorageDirectory.toString());
                } catch (IOException e2) {
                    e = e2;
                    a.EnumC0260a enumC0260a = a.EnumC0260a.OTHER;
                    Class<?> cls = a;
                    aVar.a(enumC0260a, cls, "failed to read folder to check if external: " + ((String) null), e);
                    return false;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Exception e4) {
            aVar.a(a.EnumC0260a.OTHER, a, "failed to get the external storage directory!", e4);
            return false;
        }
    }

    private void z(File file, String str) throws IOException {
        try {
            FileUtils.a(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.f12002f.a(a.EnumC0260a.WRITE_CREATE_DIR, a, str, e2);
            throw e2;
        }
    }

    @Override // e.f.b.b.d
    public void a() {
        com.facebook.common.file.a.a(this.f11999c);
    }

    @Override // e.f.b.b.d
    public void b() {
        com.facebook.common.file.a.c(this.f11999c, new g());
    }

    @Override // e.f.b.b.d
    public d.b c(String str, Object obj) throws IOException {
        d dVar = new d(".tmp", str);
        File v = v(dVar.f12008b);
        if (!v.exists()) {
            z(v, "insert");
        }
        try {
            return new f(str, dVar.a(v));
        } catch (IOException e2) {
            this.f12002f.a(a.EnumC0260a.WRITE_CREATE_TEMPFILE, a, "insert", e2);
            throw e2;
        }
    }

    @Override // e.f.b.b.d
    public boolean d(String str, Object obj) {
        return A(str, false);
    }

    @Override // e.f.b.b.d
    public e.f.a.a e(String str, Object obj) {
        File q = q(str);
        if (q.exists()) {
            q.setLastModified(this.f12003g.now());
            return e.f.a.b.b(q);
        }
        return null;
    }

    @Override // e.f.b.b.d
    public long g(String str) {
        return p(q(str));
    }

    @Override // e.f.b.b.d
    public long h(d.a aVar) {
        return p(((c) aVar).b().c());
    }

    @Override // e.f.b.b.d
    public boolean isExternal() {
        return this.f12000d;
    }

    File q(String str) {
        return new File(t(str));
    }

    @Override // e.f.b.b.d
    /* renamed from: r */
    public List<d.a> f() throws IOException {
        b bVar = new b();
        com.facebook.common.file.a.c(this.f12001e, bVar);
        return bVar.d();
    }
}