package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import com.facebook.soloader.f;
import com.facebook.soloader.n;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;

/* compiled from: ApkSoSource.java */
/* loaded from: classes2.dex */
public class a extends f {

    /* renamed from: i  reason: collision with root package name */
    private final int f5611i;

    /* compiled from: ApkSoSource.java */
    /* renamed from: com.facebook.soloader.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    protected class C0128a extends f.c {

        /* renamed from: e  reason: collision with root package name */
        private File f5612e;

        /* renamed from: f  reason: collision with root package name */
        private final int f5613f;

        C0128a(f fVar) throws IOException {
            super(fVar);
            this.f5612e = new File(a.this.f5637c.getApplicationInfo().nativeLibraryDir);
            this.f5613f = a.this.f5611i;
        }

        @Override // com.facebook.soloader.f.c
        protected boolean f(ZipEntry zipEntry, String str) {
            String str2;
            String name = zipEntry.getName();
            boolean z = false;
            if (str.equals(a.this.f5638d)) {
                a.this.f5638d = null;
                str2 = String.format("allowing consideration of corrupted lib %s", str);
            } else if ((this.f5613f & 1) == 0) {
                str2 = "allowing consideration of " + name + ": self-extraction preferred";
            } else {
                File file = new File(this.f5612e, str);
                if (!file.isFile()) {
                    str2 = String.format("allowing considering of %s: %s not in system lib dir", name, str);
                } else {
                    long length = file.length();
                    long size = zipEntry.getSize();
                    if (length != size) {
                        str2 = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", file, Long.valueOf(length), Long.valueOf(size));
                    } else {
                        str2 = "not allowing consideration of " + name + ": deferring to libdir";
                        Log.d("ApkSoSource", str2);
                        return z;
                    }
                }
            }
            z = true;
            Log.d("ApkSoSource", str2);
            return z;
        }
    }

    public a(Context context, File file, String str, int i2) {
        super(context, str, file, "^lib/([^/]+)/([^/]+\\.so)$");
        this.f5611i = i2;
    }

    @Override // com.facebook.soloader.n
    protected byte[] j() throws IOException {
        File canonicalFile = this.f5621g.getCanonicalFile();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile.getPath());
            obtain.writeLong(canonicalFile.lastModified());
            obtain.writeInt(SysUtil.f(this.f5637c));
            if ((this.f5611i & 1) == 0) {
                obtain.writeByte((byte) 0);
                return obtain.marshall();
            }
            String str = this.f5637c.getApplicationInfo().nativeLibraryDir;
            if (str == null) {
                obtain.writeByte((byte) 1);
                return obtain.marshall();
            }
            File canonicalFile2 = new File(str).getCanonicalFile();
            if (!canonicalFile2.exists()) {
                obtain.writeByte((byte) 1);
                return obtain.marshall();
            }
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile2.getPath());
            obtain.writeLong(canonicalFile2.lastModified());
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    @Override // com.facebook.soloader.n
    protected n.f m() throws IOException {
        return new C0128a(this);
    }
}