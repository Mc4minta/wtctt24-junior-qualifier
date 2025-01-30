package okhttp3.internal.io;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import j.c0;
import j.e0;
import j.q;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: FileSystem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\r¨\u0006\u001b"}, d2 = {"Lokhttp3/internal/io/FileSystem;", "", "Ljava/io/File;", "file", "Lj/e0;", Payload.SOURCE, "(Ljava/io/File;)Lj/e0;", "Lj/c0;", "sink", "(Ljava/io/File;)Lj/c0;", "appendingSink", "Lkotlin/x;", "delete", "(Ljava/io/File;)V", "", "exists", "(Ljava/io/File;)Z", "", "size", "(Ljava/io/File;)J", ApiConstants.FROM, ApiConstants.TO, "rename", "(Ljava/io/File;Ljava/io/File;)V", "directory", "deleteContents", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface FileSystem {
    public static final Companion Companion = new Companion(null);
    public static final FileSystem SYSTEM = new FileSystem() { // from class: okhttp3.internal.io.FileSystem$Companion$SYSTEM$1
        @Override // okhttp3.internal.io.FileSystem
        public c0 appendingSink(File file) throws FileNotFoundException {
            m.h(file, "file");
            try {
                return q.a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return q.a(file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public void delete(File file) throws IOException {
            m.h(file, "file");
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.io.FileSystem
        public void deleteContents(File directory) throws IOException {
            m.h(directory, "directory");
            File[] listFiles = directory.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    m.d(file, "file");
                    if (file.isDirectory()) {
                        deleteContents(file);
                    }
                    if (!file.delete()) {
                        throw new IOException("failed to delete " + file);
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: " + directory);
        }

        @Override // okhttp3.internal.io.FileSystem
        public boolean exists(File file) {
            m.h(file, "file");
            return file.exists();
        }

        @Override // okhttp3.internal.io.FileSystem
        public void rename(File from, File to) throws IOException {
            m.h(from, "from");
            m.h(to, "to");
            delete(to);
            if (from.renameTo(to)) {
                return;
            }
            throw new IOException("failed to rename " + from + " to " + to);
        }

        @Override // okhttp3.internal.io.FileSystem
        public c0 sink(File file) throws FileNotFoundException {
            m.h(file, "file");
            try {
                return q.i(file, false, 1, null);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return q.i(file, false, 1, null);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public long size(File file) {
            m.h(file, "file");
            return file.length();
        }

        @Override // okhttp3.internal.io.FileSystem
        public e0 source(File file) throws FileNotFoundException {
            m.h(file, "file");
            return q.j(file);
        }
    };

    /* compiled from: FileSystem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001\u0082\u0002\u0007\n\u0005\b\u0091F0\u0001¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/io/FileSystem$Companion;", "", "Lokhttp3/internal/io/FileSystem;", "SYSTEM", "Lokhttp3/internal/io/FileSystem;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    c0 appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    c0 sink(File file) throws FileNotFoundException;

    long size(File file);

    e0 source(File file) throws FileNotFoundException;
}