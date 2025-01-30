package e.f.a;

import e.f.d.c.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileBinaryResource.java */
/* loaded from: classes2.dex */
public class b implements a {
    private final File a;

    private b(File file) {
        this.a = (File) i.g(file);
    }

    public static b b(File file) {
        if (file != null) {
            return new b(file);
        }
        return null;
    }

    @Override // e.f.a.a
    public InputStream a() throws IOException {
        return new FileInputStream(this.a);
    }

    public File c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        return this.a.equals(((b) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // e.f.a.a
    public long size() {
        return this.a.length();
    }
}