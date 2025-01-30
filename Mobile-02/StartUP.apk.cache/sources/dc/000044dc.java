package e.a.a.x;

import android.content.Context;
import androidx.core.util.e;
import e.a.a.z.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkCache.java */
/* loaded from: classes.dex */
public class b {
    private final Context a;

    public b(Context context) {
        this.a = context.getApplicationContext();
    }

    private static String b(String str, a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? aVar.h() : aVar.f11915d);
        return sb.toString();
    }

    private File c(String str) throws FileNotFoundException {
        File file = new File(d(), b(str, a.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(d(), b(str, a.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File d() {
        File file = new File(this.a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e<a, InputStream> a(String str) {
        a aVar;
        try {
            File c2 = c(str);
            if (c2 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(c2);
            if (c2.getAbsolutePath().endsWith(".zip")) {
                aVar = a.ZIP;
            } else {
                aVar = a.JSON;
            }
            d.a("Cache hit for " + str + " at " + c2.getAbsolutePath());
            return new e<>(aVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, a aVar) {
        File file = new File(d(), b(str, aVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        d.a("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        d.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File f(String str, InputStream inputStream, a aVar) throws IOException {
        File file = new File(d(), b(str, aVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file;
                }
            }
        } finally {
            inputStream.close();
        }
    }
}