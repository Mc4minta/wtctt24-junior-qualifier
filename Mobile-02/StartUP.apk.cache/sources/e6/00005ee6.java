package org.reactnative.camera.h;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/* compiled from: RNFileUtils.java */
/* loaded from: classes3.dex */
public class c {
    public static File a(File file) throws IOException {
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Couldn't create directory '" + file + "'");
    }

    public static String b(File file, String str) throws IOException {
        a(file);
        String uuid = UUID.randomUUID().toString();
        return file + File.separator + uuid + str;
    }

    public static Uri c(File file) {
        return Uri.fromFile(file);
    }
}