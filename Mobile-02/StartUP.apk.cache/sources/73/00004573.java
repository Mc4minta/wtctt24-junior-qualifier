package e.f.d.f;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import e.f.d.c.n;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: StatFsHelper.java */
/* loaded from: classes2.dex */
public class a {
    private static a a;

    /* renamed from: b  reason: collision with root package name */
    private static final long f12078b = TimeUnit.MINUTES.toMillis(2);

    /* renamed from: d  reason: collision with root package name */
    private volatile File f12080d;

    /* renamed from: f  reason: collision with root package name */
    private volatile File f12082f;

    /* renamed from: g  reason: collision with root package name */
    private long f12083g;

    /* renamed from: c  reason: collision with root package name */
    private volatile StatFs f12079c = null;

    /* renamed from: e  reason: collision with root package name */
    private volatile StatFs f12081e = null;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f12085i = false;

    /* renamed from: h  reason: collision with root package name */
    private final Lock f12084h = new ReentrantLock();

    /* compiled from: StatFsHelper.java */
    /* renamed from: e.f.d.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0262a {
        INTERNAL,
        EXTERNAL
    }

    protected a() {
    }

    protected static StatFs a(String str) {
        return new StatFs(str);
    }

    private void b() {
        if (this.f12085i) {
            return;
        }
        this.f12084h.lock();
        try {
            if (!this.f12085i) {
                this.f12080d = Environment.getDataDirectory();
                this.f12082f = Environment.getExternalStorageDirectory();
                g();
                this.f12085i = true;
            }
        } finally {
            this.f12084h.unlock();
        }
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    private void e() {
        if (this.f12084h.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.f12083g > f12078b) {
                    g();
                }
            } finally {
                this.f12084h.unlock();
            }
        }
    }

    private void g() {
        this.f12079c = h(this.f12079c, this.f12080d);
        this.f12081e = h(this.f12081e, this.f12082f);
        this.f12083g = SystemClock.uptimeMillis();
    }

    private StatFs h(StatFs statFs, File file) {
        StatFs statFs2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = a(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            statFs2 = statFs;
            return statFs2;
        } catch (IllegalArgumentException unused) {
            return statFs2;
        } catch (Throwable th) {
            throw n.a(th);
        }
    }

    @SuppressLint({"DeprecatedMethod"})
    public long c(EnumC0262a enumC0262a) {
        long blockSize;
        long availableBlocks;
        b();
        e();
        StatFs statFs = enumC0262a == EnumC0262a.INTERNAL ? this.f12079c : this.f12081e;
        if (statFs != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        }
        return 0L;
    }

    public boolean f(EnumC0262a enumC0262a, long j2) {
        b();
        long c2 = c(enumC0262a);
        return c2 <= 0 || c2 < j2;
    }
}