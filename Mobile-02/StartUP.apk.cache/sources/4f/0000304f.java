package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.facebook.soloader.i;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public final class SysUtil {

    @d
    @TargetApi(21)
    /* loaded from: classes2.dex */
    private static final class LollipopSysdeps {
        private LollipopSysdeps() {
        }

        @d
        public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j2) throws IOException {
            int i2;
            try {
                Os.posix_fallocate(fileDescriptor, 0L, j2);
            } catch (ErrnoException e2) {
                if (e2.errno != OsConstants.EOPNOTSUPP && (i2 = e2.errno) != OsConstants.ENOSYS && i2 != OsConstants.EINVAL) {
                    throw new IOException(e2.toString(), e2);
                }
            }
        }

        @d
        public static String[] getSupportedAbis() {
            String[] strArr = Build.SUPPORTED_ABIS;
            TreeSet treeSet = new TreeSet();
            try {
                if (Os.readlink("/proc/self/exe").contains("64")) {
                    treeSet.add(i.b.AARCH64.toString());
                    treeSet.add(i.b.X86_64.toString());
                } else {
                    treeSet.add(i.b.ARM.toString());
                    treeSet.add(i.b.X86.toString());
                }
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (treeSet.contains(str)) {
                        arrayList.add(str);
                    }
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            } catch (ErrnoException e2) {
                Log.e("SysUtil", String.format("Could not read /proc/self/exe. Falling back to default ABI list: %s. errno: %d Err msg: %s", Arrays.toString(strArr), Integer.valueOf(e2.errno), e2.getMessage()));
                return Build.SUPPORTED_ABIS;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RandomAccessFile randomAccessFile, InputStream inputStream, int i2, byte[] bArr) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, 0, Math.min(bArr.length, i2 - i3));
            if (read == -1) {
                break;
            }
            randomAccessFile.write(bArr, 0, read);
            i3 += read;
        }
        return i3;
    }

    public static void b(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                b(file2);
            }
        }
        if (file.delete() || !file.exists()) {
            return;
        }
        throw new IOException("could not delete: " + file);
    }

    public static void c(FileDescriptor fileDescriptor, long j2) throws IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            LollipopSysdeps.fallocateIfSupported(fileDescriptor, j2);
        }
    }

    public static int d(String[] strArr, String str) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2] != null && str.equals(strArr[i2])) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    e(file2);
                }
                return;
            }
            throw new IOException("cannot list directory " + file);
        } else if (!file.getPath().endsWith("_lock")) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
    }

    public static int f(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                return packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return 0;
    }

    public static String[] g() {
        return Build.VERSION.SDK_INT < 21 ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : LollipopSysdeps.getSupportedAbis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(File file) throws IOException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        throw new IOException("cannot mkdir: " + file);
    }
}