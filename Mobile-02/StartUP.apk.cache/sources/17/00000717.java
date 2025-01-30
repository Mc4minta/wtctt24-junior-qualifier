package com.appsflyer.internal;

import android.content.Context;
import android.util.Log;
import com.appsflyer.AppsFlyerLibCore;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class aa {

    /* renamed from: ɩ  reason: contains not printable characters */
    private static aa f162 = new aa();

    private aa() {
    }

    /* renamed from: ı  reason: contains not printable characters */
    public static j m115(File file) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
                char[] cArr = new char[(int) file.length()];
                fileReader.read(cArr);
                j jVar = new j(cArr);
                jVar.f265 = file.getName();
                try {
                    fileReader.close();
                } catch (IOException unused) {
                }
                return jVar;
            } catch (Exception unused2) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public static aa m116() {
        return f162;
    }

    /* renamed from: ι  reason: contains not printable characters */
    public static File m119(Context context) {
        return new File(context.getFilesDir(), "AFRequestCache");
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public static List<j> m117(Context context) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(context.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
            } else {
                for (File file2 : file.listFiles()) {
                    StringBuilder sb = new StringBuilder("Found cached request");
                    sb.append(file2.getName());
                    Log.i(AppsFlyerLibCore.LOG_TAG, sb.toString());
                    arrayList.add(m115(file2));
                }
            }
        } catch (Exception unused) {
            Log.i(AppsFlyerLibCore.LOG_TAG, "Could not cache request");
        }
        return arrayList;
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public static void m118(String str, Context context) {
        File file = new File(new File(context.getFilesDir(), "AFRequestCache"), str);
        StringBuilder sb = new StringBuilder("Deleting ");
        sb.append(str);
        sb.append(" from cache");
        Log.i(AppsFlyerLibCore.LOG_TAG, sb.toString());
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder("Could not delete ");
                sb2.append(str);
                sb2.append(" from cache");
                Log.i(AppsFlyerLibCore.LOG_TAG, sb2.toString(), e2);
            }
        }
    }
}