package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* compiled from: FileLocker.java */
/* loaded from: classes2.dex */
public final class g implements Closeable {
    private final FileOutputStream a;

    /* renamed from: b  reason: collision with root package name */
    private final FileLock f5629b;

    private g(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.a = fileOutputStream;
        try {
            FileLock lock = fileOutputStream.getChannel().lock();
            if (lock == null) {
                fileOutputStream.close();
            }
            this.f5629b = lock;
        } catch (Throwable th) {
            this.a.close();
            throw th;
        }
    }

    public static g a(File file) throws IOException {
        return new g(file);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            FileLock fileLock = this.f5629b;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            this.a.close();
        }
    }
}