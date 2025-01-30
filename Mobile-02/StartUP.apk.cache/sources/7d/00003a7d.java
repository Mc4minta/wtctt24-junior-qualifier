package com.google.firebase.crashlytics.c.m;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class b extends FileOutputStream {
    public static final FilenameFilter a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final String f8992b;

    /* renamed from: c  reason: collision with root package name */
    private File f8993c;

    /* renamed from: d  reason: collision with root package name */
    private File f8994d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8995e;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    }

    public b(File file, String str) throws FileNotFoundException {
        super(new File(file, str + ".cls_temp"));
        this.f8995e = false;
        String str2 = file + File.separator + str;
        this.f8992b = str2;
        this.f8993c = new File(str2 + ".cls_temp");
    }

    public void a() throws IOException {
        if (this.f8995e) {
            return;
        }
        this.f8995e = true;
        super.flush();
        super.close();
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f8995e) {
            return;
        }
        this.f8995e = true;
        super.flush();
        super.close();
        File file = new File(this.f8992b + ".cls");
        if (this.f8993c.renameTo(file)) {
            this.f8993c = null;
            this.f8994d = file;
            return;
        }
        String str = "";
        if (file.exists()) {
            str = " (target already exists)";
        } else if (!this.f8993c.exists()) {
            str = " (source does not exist)";
        }
        throw new IOException("Could not rename temp file: " + this.f8993c + " -> " + file + str);
    }
}