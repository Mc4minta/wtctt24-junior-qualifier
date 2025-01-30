package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UnpackingSoSource.java */
/* loaded from: classes2.dex */
public abstract class n extends com.facebook.soloader.c {

    /* renamed from: c  reason: collision with root package name */
    protected final Context f5637c;

    /* renamed from: d  reason: collision with root package name */
    protected String f5638d;

    /* renamed from: e  reason: collision with root package name */
    private String[] f5639e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Object> f5640f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnpackingSoSource.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ File a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ byte[] f5641b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f5642c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ File f5643d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g f5644e;

        a(File file, byte[] bArr, c cVar, File file2, g gVar) {
            this.a = file;
            this.f5641b = bArr;
            this.f5642c = cVar;
            this.f5643d = file2;
            this.f5644e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.v("fb-UnpackingSoSource", "starting syncer worker");
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.a, "rw");
                try {
                    randomAccessFile.write(this.f5641b);
                    randomAccessFile.setLength(randomAccessFile.getFilePointer());
                    randomAccessFile.close();
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File(n.this.a, "dso_manifest"), "rw");
                    try {
                        this.f5642c.b(randomAccessFile2);
                        randomAccessFile2.close();
                        SysUtil.e(n.this.a);
                        n.r(this.f5643d, (byte) 1);
                        Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + n.this.a + " (from syncer thread)");
                        this.f5644e.close();
                    } finally {
                    }
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
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* compiled from: UnpackingSoSource.java */
    /* loaded from: classes2.dex */
    public static class b {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5646b;

        public b(String str, String str2) {
            this.a = str;
            this.f5646b = str2;
        }
    }

    /* compiled from: UnpackingSoSource.java */
    /* loaded from: classes2.dex */
    public static final class c {
        public final b[] a;

        public c(b[] bVarArr) {
            this.a = bVarArr;
        }

        static final c a(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    b[] bVarArr = new b[readInt];
                    for (int i2 = 0; i2 < readInt; i2++) {
                        bVarArr[i2] = new b(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new c(bVarArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void b(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.a.length);
            int i2 = 0;
            while (true) {
                b[] bVarArr = this.a;
                if (i2 >= bVarArr.length) {
                    return;
                }
                dataOutput.writeUTF(bVarArr[i2].a);
                dataOutput.writeUTF(this.a[i2].f5646b);
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: UnpackingSoSource.java */
    /* loaded from: classes2.dex */
    public static final class d implements Closeable {
        public final b a;

        /* renamed from: b  reason: collision with root package name */
        public final InputStream f5647b;

        public d(b bVar, InputStream inputStream) {
            this.a = bVar;
            this.f5647b = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f5647b.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: UnpackingSoSource.java */
    /* loaded from: classes2.dex */
    public static abstract class e implements Closeable {
        public abstract boolean a();

        public abstract d b() throws IOException;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: UnpackingSoSource.java */
    /* loaded from: classes2.dex */
    public static abstract class f implements Closeable {
        protected abstract c a() throws IOException;

        protected abstract e b() throws IOException;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public n(Context context, String str) {
        super(l(context, str), 1);
        this.f5640f = new HashMap();
        this.f5637c = context;
    }

    private void h(b[] bVarArr) throws IOException {
        String[] list = this.a.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals("dso_state") && !str.equals("dso_lock") && !str.equals("dso_deps") && !str.equals("dso_manifest")) {
                    boolean z = false;
                    for (int i2 = 0; !z && i2 < bVarArr.length; i2++) {
                        if (bVarArr[i2].a.equals(str)) {
                            z = true;
                        }
                    }
                    if (!z) {
                        File file = new File(this.a, str);
                        Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + file);
                        SysUtil.b(file);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + this.a);
    }

    private void i(d dVar, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        Log.i("fb-UnpackingSoSource", "extracting DSO " + dVar.a.a);
        if (this.a.setWritable(true, true)) {
            File file = new File(this.a, dVar.a.a);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException e2) {
                Log.w("fb-UnpackingSoSource", "error overwriting " + file + " trying to delete and start over", e2);
                SysUtil.b(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            try {
                try {
                    int available = dVar.f5647b.available();
                    if (available > 1) {
                        SysUtil.c(randomAccessFile.getFD(), available);
                    }
                    SysUtil.a(randomAccessFile, dVar.f5647b, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, bArr);
                    randomAccessFile.setLength(randomAccessFile.getFilePointer());
                    if (file.setExecutable(true, false)) {
                        return;
                    }
                    throw new IOException("cannot make file executable: " + file);
                } catch (IOException e3) {
                    SysUtil.b(file);
                    throw e3;
                }
            } finally {
                randomAccessFile.close();
            }
        }
        throw new IOException("cannot make directory writable for us: " + this.a);
    }

    private Object k(String str) {
        Object obj;
        synchronized (this.f5640f) {
            obj = this.f5640f.get(str);
            if (obj == null) {
                obj = new Object();
                this.f5640f.put(str, obj);
            }
        }
        return obj;
    }

    public static File l(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean o(com.facebook.soloader.g r12, int r13, byte[] r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.n.o(com.facebook.soloader.g, int, byte[]):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[Catch: all -> 0x0036, TryCatch #5 {all -> 0x0036, blocks: (B:4:0x0031, B:13:0x0043, B:14:0x004a, B:15:0x0054, B:17:0x005a, B:42:0x00a0, B:9:0x003a, B:20:0x0062, B:22:0x0067, B:24:0x0075, B:27:0x0086, B:31:0x008d), top: B:53:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #5 {all -> 0x0036, blocks: (B:4:0x0031, B:13:0x0043, B:14:0x004a, B:15:0x0054, B:17:0x005a, B:42:0x00a0, B:9:0x003a, B:20:0x0062, B:22:0x0067, B:24:0x0075, B:27:0x0086, B:31:0x008d), top: B:53:0x0031 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void p(byte r10, com.facebook.soloader.n.c r11, com.facebook.soloader.n.e r12) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "regenerating DSO store "
            r0.append(r1)
            java.lang.Class r1 = r9.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "fb-UnpackingSoSource"
            android.util.Log.v(r1, r0)
            java.io.File r0 = new java.io.File
            java.io.File r2 = r9.a
            java.lang.String r3 = "dso_manifest"
            r0.<init>(r2, r3)
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile
            java.lang.String r3 = "rw"
            r2.<init>(r0, r3)
            r0 = 1
            if (r10 != r0) goto L3f
            com.facebook.soloader.n$c r10 = com.facebook.soloader.n.c.a(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            goto L40
        L36:
            r10 = move-exception
            goto Lc4
        L39:
            r10 = move-exception
            java.lang.String r3 = "error reading existing DSO manifest"
            android.util.Log.i(r1, r3, r10)     // Catch: java.lang.Throwable -> L36
        L3f:
            r10 = 0
        L40:
            r3 = 0
            if (r10 != 0) goto L4a
            com.facebook.soloader.n$c r10 = new com.facebook.soloader.n$c     // Catch: java.lang.Throwable -> L36
            com.facebook.soloader.n$b[] r4 = new com.facebook.soloader.n.b[r3]     // Catch: java.lang.Throwable -> L36
            r10.<init>(r4)     // Catch: java.lang.Throwable -> L36
        L4a:
            com.facebook.soloader.n$b[] r11 = r11.a     // Catch: java.lang.Throwable -> L36
            r9.h(r11)     // Catch: java.lang.Throwable -> L36
            r11 = 32768(0x8000, float:4.5918E-41)
            byte[] r11 = new byte[r11]     // Catch: java.lang.Throwable -> L36
        L54:
            boolean r4 = r12.a()     // Catch: java.lang.Throwable -> L36
            if (r4 == 0) goto La4
            com.facebook.soloader.n$d r4 = r12.b()     // Catch: java.lang.Throwable -> L36
            r5 = r0
            r6 = r3
        L60:
            if (r5 == 0) goto L8b
            com.facebook.soloader.n$b[] r7 = r10.a     // Catch: java.lang.Throwable -> L89
            int r8 = r7.length     // Catch: java.lang.Throwable -> L89
            if (r6 >= r8) goto L8b
            r7 = r7[r6]     // Catch: java.lang.Throwable -> L89
            java.lang.String r7 = r7.a     // Catch: java.lang.Throwable -> L89
            com.facebook.soloader.n$b r8 = r4.a     // Catch: java.lang.Throwable -> L89
            java.lang.String r8 = r8.a     // Catch: java.lang.Throwable -> L89
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Throwable -> L89
            if (r7 == 0) goto L86
            com.facebook.soloader.n$b[] r7 = r10.a     // Catch: java.lang.Throwable -> L89
            r7 = r7[r6]     // Catch: java.lang.Throwable -> L89
            java.lang.String r7 = r7.f5646b     // Catch: java.lang.Throwable -> L89
            com.facebook.soloader.n$b r8 = r4.a     // Catch: java.lang.Throwable -> L89
            java.lang.String r8 = r8.f5646b     // Catch: java.lang.Throwable -> L89
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Throwable -> L89
            if (r7 == 0) goto L86
            r5 = r3
        L86:
            int r6 = r6 + 1
            goto L60
        L89:
            r10 = move-exception
            goto L91
        L8b:
            if (r5 == 0) goto L9e
            r9.i(r4, r11)     // Catch: java.lang.Throwable -> L89
            goto L9e
        L91:
            throw r10     // Catch: java.lang.Throwable -> L92
        L92:
            r11 = move-exception
            if (r4 == 0) goto L9d
            r4.close()     // Catch: java.lang.Throwable -> L99
            goto L9d
        L99:
            r12 = move-exception
            r10.addSuppressed(r12)     // Catch: java.lang.Throwable -> L36
        L9d:
            throw r11     // Catch: java.lang.Throwable -> L36
        L9e:
            if (r4 == 0) goto L54
            r4.close()     // Catch: java.lang.Throwable -> L36
            goto L54
        La4:
            r2.close()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Finished regenerating DSO store "
            r10.append(r11)
            java.lang.Class r11 = r9.getClass()
            java.lang.String r11 = r11.getName()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.util.Log.v(r1, r10)
            return
        Lc4:
            throw r10     // Catch: java.lang.Throwable -> Lc5
        Lc5:
            r11 = move-exception
            r2.close()     // Catch: java.lang.Throwable -> Lca
            goto Lce
        Lca:
            r12 = move-exception
            r10.addSuppressed(r12)
        Lce:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.n.p(byte, com.facebook.soloader.n$c, com.facebook.soloader.n$e):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(File file, byte b2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            randomAccessFile.seek(0L);
            randomAccessFile.write(b2);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
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

    @Override // com.facebook.soloader.c, com.facebook.soloader.l
    public int a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int f2;
        synchronized (k(str)) {
            f2 = f(str, i2, this.a, threadPolicy);
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.soloader.l
    public void b(int i2) throws IOException {
        SysUtil.h(this.a);
        g a2 = g.a(new File(this.a, "dso_lock"));
        try {
            Log.v("fb-UnpackingSoSource", "locked dso store " + this.a);
            if (o(a2, i2, j())) {
                a2 = null;
            } else {
                Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.a);
            }
        } finally {
            if (a2 != null) {
                Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.a);
                a2.close();
            } else {
                Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.a + " (syncer thread started)");
            }
        }
    }

    protected byte[] j() throws IOException {
        Parcel obtain = Parcel.obtain();
        f m = m();
        try {
            b[] bVarArr = m.a().a;
            obtain.writeByte((byte) 1);
            obtain.writeInt(bVarArr.length);
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                obtain.writeString(bVarArr[i2].a);
                obtain.writeString(bVarArr[i2].f5646b);
            }
            m.close();
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (m != null) {
                    try {
                        m.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    protected abstract f m() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void n(String str) throws IOException {
        synchronized (k(str)) {
            this.f5638d = str;
            b(2);
        }
    }

    public void q(String[] strArr) {
        this.f5639e = strArr;
    }
}