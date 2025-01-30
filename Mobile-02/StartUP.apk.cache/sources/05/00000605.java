package c.p;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.coinbase.resources.transactions.Transaction;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* compiled from: MultiDexExtractor.java */
/* loaded from: classes.dex */
final class b implements Closeable {
    private final File a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3189b;

    /* renamed from: c  reason: collision with root package name */
    private final File f3190c;

    /* renamed from: d  reason: collision with root package name */
    private final RandomAccessFile f3191d;

    /* renamed from: e  reason: collision with root package name */
    private final FileChannel f3192e;

    /* renamed from: f  reason: collision with root package name */
    private final FileLock f3193f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiDexExtractor.java */
    /* loaded from: classes.dex */
    public class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MultiDexExtractor.java */
    /* renamed from: c.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0084b extends File {
        public long a;

        public C0084b(File file, String str) {
            super(file, str);
            this.a = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(File file, File file2) throws IOException {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.a = file;
        this.f3190c = file2;
        this.f3189b = f(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f3191d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f3192e = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f3193f = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e2) {
                e = e2;
                b(this.f3192e);
                throw e;
            } catch (Error e3) {
                e = e3;
                b(this.f3192e);
                throw e;
            } catch (RuntimeException e4) {
                e = e4;
                b(this.f3192e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            b(this.f3191d);
            throw e5;
        }
    }

    private void a() {
        File[] listFiles = this.f3190c.listFiles(new a());
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f3190c.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            }
        }
    }

    private static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to close resource", e2);
        }
    }

    private static void c(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } finally {
            b(inputStream);
            createTempFile.delete();
        }
    }

    private static SharedPreferences d(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static long e(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long f(File file) throws IOException {
        long c2 = c.c(file);
        return c2 == -1 ? c2 - 1 : c2;
    }

    private static boolean g(Context context, File file, long j2, String str) {
        SharedPreferences d2 = d(context);
        if (d2.getLong(str + "timestamp", -1L) == e(file)) {
            if (d2.getLong(str + "crc", -1L) == j2) {
                return false;
            }
        }
        return true;
    }

    private List<C0084b> m(Context context, String str) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.a.getName() + ".classes";
        SharedPreferences d2 = d(context);
        int i2 = d2.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i2 + (-1));
        int i3 = 2;
        while (i3 <= i2) {
            C0084b c0084b = new C0084b(this.f3190c, str2 + i3 + ".zip");
            if (c0084b.isFile()) {
                c0084b.a = f(c0084b);
                long j2 = d2.getLong(str + "dex.crc." + i3, -1L);
                long j3 = d2.getLong(str + "dex.time." + i3, -1L);
                long lastModified = c0084b.lastModified();
                if (j3 == lastModified) {
                    String str3 = str2;
                    SharedPreferences sharedPreferences = d2;
                    if (j2 == c0084b.a) {
                        arrayList.add(c0084b);
                        i3++;
                        d2 = sharedPreferences;
                        str2 = str3;
                    }
                }
                throw new IOException("Invalid extracted dex: " + c0084b + " (key \"" + str + "\"), expected modification time: " + j3 + ", modification time: " + lastModified + ", expected crc: " + j2 + ", file crc: " + c0084b.a);
            }
            throw new IOException("Missing extracted secondary dex file '" + c0084b.getPath() + "'");
        }
        return arrayList;
    }

    private List<C0084b> n() throws IOException {
        boolean z;
        String str = this.a.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.a);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i2 = 2;
            while (entry != null) {
                C0084b c0084b = new C0084b(this.f3190c, str + i2 + ".zip");
                arrayList.add(c0084b);
                Log.i("MultiDex", "Extraction is needed for file " + c0084b);
                int i3 = 0;
                boolean z2 = false;
                while (i3 < 3 && !z2) {
                    int i4 = i3 + 1;
                    c(zipFile, entry, c0084b, str);
                    try {
                        c0084b.a = f(c0084b);
                        z = true;
                    } catch (IOException e2) {
                        Log.w("MultiDex", "Failed to read crc from " + c0084b.getAbsolutePath(), e2);
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "succeeded" : Transaction.STATUS_FAILED);
                    sb.append(" '");
                    sb.append(c0084b.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(c0084b.length());
                    sb.append(" - crc: ");
                    sb.append(c0084b.a);
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        c0084b.delete();
                        if (c0084b.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + c0084b.getPath() + "'");
                        }
                    }
                    z2 = z;
                    i3 = i4;
                }
                if (z2) {
                    i2++;
                    entry = zipFile.getEntry("classes" + i2 + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + c0084b.getAbsolutePath() + " for secondary dex (" + i2 + ")");
                }
            }
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to close resource", e3);
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (IOException e4) {
                Log.w("MultiDex", "Failed to close resource", e4);
            }
            throw th;
        }
    }

    private static void v(Context context, String str, long j2, long j3, List<C0084b> list) {
        SharedPreferences.Editor edit = d(context).edit();
        edit.putLong(str + "timestamp", j2);
        edit.putLong(str + "crc", j3);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i2 = 2;
        for (C0084b c0084b : list) {
            edit.putLong(str + "dex.crc." + i2, c0084b.a);
            edit.putLong(str + "dex.time." + i2, c0084b.lastModified());
            i2++;
        }
        edit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3193f.release();
        this.f3192e.close();
        this.f3191d.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends File> j(Context context, String str, boolean z) throws IOException {
        List<C0084b> n;
        List<C0084b> list;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.a.getPath() + ", " + z + ", " + str + ")");
        if (this.f3193f.isValid()) {
            if (!z && !g(context, this.a, this.f3189b, str)) {
                try {
                    list = m(context, str);
                } catch (IOException e2) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e2);
                    n = n();
                    v(context, str, e(this.a), this.f3189b, n);
                }
                Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
                return list;
            }
            if (z) {
                Log.i("MultiDex", "Forced extraction must be performed.");
            } else {
                Log.i("MultiDex", "Detected that extraction must be performed.");
            }
            n = n();
            v(context, str, e(this.a), this.f3189b, n);
            list = n;
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
}