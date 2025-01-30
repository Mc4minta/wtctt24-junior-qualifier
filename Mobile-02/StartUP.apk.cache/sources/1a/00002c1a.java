package com.facebook.common.file;

import java.io.File;

/* compiled from: FileTree.java */
/* loaded from: classes2.dex */
public class a {
    public static boolean a(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                z &= b(file2);
            }
        }
        return z;
    }

    public static boolean b(File file) {
        if (file.isDirectory()) {
            a(file);
        }
        return file.delete();
    }

    public static void c(File file, b bVar) {
        bVar.b(file);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    c(file2, bVar);
                } else {
                    bVar.a(file2);
                }
            }
        }
        bVar.c(file);
    }
}