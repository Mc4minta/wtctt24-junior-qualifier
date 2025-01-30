package androidx.room;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/* compiled from: SQLiteCopyOpenHelper.java */
/* loaded from: classes.dex */
class o implements c.r.a.c {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2291b;

    /* renamed from: c  reason: collision with root package name */
    private final File f2292c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2293d;

    /* renamed from: e  reason: collision with root package name */
    private final c.r.a.c f2294e;

    /* renamed from: f  reason: collision with root package name */
    private a f2295f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2296g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context, String str, File file, int i2, c.r.a.c cVar) {
        this.a = context;
        this.f2291b = str;
        this.f2292c = file;
        this.f2293d = i2;
        this.f2294e = cVar;
    }

    private void d(File file) throws IOException {
        ReadableByteChannel channel;
        if (this.f2291b != null) {
            channel = Channels.newChannel(this.a.getAssets().open(this.f2291b));
        } else if (this.f2292c != null) {
            channel = new FileInputStream(this.f2292c).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.a.getCacheDir());
        createTempFile.deleteOnExit();
        androidx.room.t.d.a(channel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        } else if (createTempFile.renameTo(file)) {
        } else {
            throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
        }
    }

    private void f() {
        String c2 = c();
        File databasePath = this.a.getDatabasePath(c2);
        a aVar = this.f2295f;
        androidx.room.t.a aVar2 = new androidx.room.t.a(c2, this.a.getFilesDir(), aVar == null || aVar.f2229j);
        try {
            aVar2.b();
            if (!databasePath.exists()) {
                try {
                    d(databasePath);
                    aVar2.c();
                    return;
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to copy database file.", e2);
                }
            } else if (this.f2295f == null) {
                aVar2.c();
                return;
            } else {
                try {
                    int c3 = androidx.room.t.c.c(databasePath);
                    int i2 = this.f2293d;
                    if (c3 == i2) {
                        aVar2.c();
                        return;
                    } else if (this.f2295f.a(c3, i2)) {
                        aVar2.c();
                        return;
                    } else {
                        if (this.a.deleteDatabase(c2)) {
                            try {
                                d(databasePath);
                            } catch (IOException e3) {
                                Log.w("ROOM", "Unable to copy database file.", e3);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + c2 + ") for a copy destructive migration.");
                        }
                        aVar2.c();
                        return;
                    }
                } catch (IOException e4) {
                    Log.w("ROOM", "Unable to read database version.", e4);
                    aVar2.c();
                    return;
                }
            }
        } catch (Throwable th) {
            aVar2.c();
            throw th;
        }
        aVar2.c();
        throw th;
    }

    @Override // c.r.a.c
    public void a(boolean z) {
        this.f2294e.a(z);
    }

    @Override // c.r.a.c
    public synchronized c.r.a.b b() {
        if (!this.f2296g) {
            f();
            this.f2296g = true;
        }
        return this.f2294e.b();
    }

    @Override // c.r.a.c
    public String c() {
        return this.f2294e.c();
    }

    @Override // c.r.a.c
    public synchronized void close() {
        this.f2294e.close();
        this.f2296g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(a aVar) {
        this.f2295f = aVar;
    }
}