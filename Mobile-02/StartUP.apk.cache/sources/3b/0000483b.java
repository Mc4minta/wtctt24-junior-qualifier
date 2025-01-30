package e.g.a.e.f;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public class b extends com.google.android.gms.common.internal.safeparcel.a {

    /* renamed from: b  reason: collision with root package name */
    private String f13175b;

    /* renamed from: c  reason: collision with root package name */
    private DataHolder f13176c;

    /* renamed from: d  reason: collision with root package name */
    private ParcelFileDescriptor f13177d;

    /* renamed from: e  reason: collision with root package name */
    private long f13178e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f13179f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f13180g;

    /* renamed from: h  reason: collision with root package name */
    private File f13181h;
    private static final String a = b.class.getSimpleName();
    public static final Parcelable.Creator<b> CREATOR = new o();

    public b() {
        this(null, null, null, 0L, null);
    }

    public b(String str, DataHolder dataHolder, ParcelFileDescriptor parcelFileDescriptor, long j2, byte[] bArr) {
        this.f13175b = str;
        this.f13176c = dataHolder;
        this.f13177d = parcelFileDescriptor;
        this.f13178e = j2;
        this.f13179f = bArr;
    }

    private final FileOutputStream n1() {
        Throwable th;
        File file;
        File file2 = this.f13181h;
        if (file2 == null) {
            return null;
        }
        try {
            file = File.createTempFile("xlb", ".tmp", file2);
        } catch (IOException unused) {
            file = null;
        } catch (Throwable th2) {
            th = th2;
            file = null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.f13177d = ParcelFileDescriptor.open(file, 268435456);
            if (file != null) {
                file.delete();
            }
            return fileOutputStream;
        } catch (IOException unused2) {
            if (file != null) {
                file.delete();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (file != null) {
                file.delete();
            }
            throw th;
        }
    }

    private static void o1(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public DataHolder i1() {
        return this.f13176c;
    }

    public ParcelFileDescriptor j1() {
        return this.f13177d;
    }

    public long k1() {
        return this.f13178e;
    }

    public String l1() {
        return this.f13175b;
    }

    public byte[] m1() {
        return this.f13179f;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    @Override // android.os.Parcelable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeToParcel(android.os.Parcel r4, int r5) {
        /*
            r3 = this;
            android.os.ParcelFileDescriptor r0 = r3.f13177d
            r1 = 1
            if (r0 != 0) goto L31
            byte[] r0 = r3.f13180g
            if (r0 == 0) goto L31
            java.io.FileOutputStream r0 = r3.n1()
            if (r0 == 0) goto L31
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream
            r2.<init>(r0)
            java.io.DataOutputStream r0 = new java.io.DataOutputStream
            r0.<init>(r2)
            byte[] r2 = r3.f13180g     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            int r2 = r2.length     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            r0.writeInt(r2)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            byte[] r2 = r3.f13180g     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            r0.write(r2)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            o1(r0)
            r0 = r1
            goto L32
        L29:
            r4 = move-exception
            o1(r0)
            throw r4
        L2e:
            o1(r0)
        L31:
            r0 = 0
        L32:
            if (r0 != 0) goto L35
            goto L36
        L35:
            r5 = r5 | r1
        L36:
            e.g.a.e.f.o.a(r3, r4, r5)
            r4 = 0
            r3.f13177d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.a.e.f.b.writeToParcel(android.os.Parcel, int):void");
    }
}