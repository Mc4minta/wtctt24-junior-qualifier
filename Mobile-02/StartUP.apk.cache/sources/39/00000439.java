package androidx.room.t;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: CopyLock.java */
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Lock> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final File f2302b;

    /* renamed from: c  reason: collision with root package name */
    private final Lock f2303c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2304d;

    /* renamed from: e  reason: collision with root package name */
    private FileChannel f2305e;

    public a(String str, File file, boolean z) {
        File file2 = new File(file, str + ".lck");
        this.f2302b = file2;
        this.f2303c = a(file2.getAbsolutePath());
        this.f2304d = z;
    }

    private static Lock a(String str) {
        Lock lock;
        Map<String, Lock> map = a;
        synchronized (map) {
            lock = map.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(str, lock);
            }
        }
        return lock;
    }

    public void b() {
        this.f2303c.lock();
        if (this.f2304d) {
            try {
                FileChannel channel = new FileOutputStream(this.f2302b).getChannel();
                this.f2305e = channel;
                channel.lock();
            } catch (IOException e2) {
                throw new IllegalStateException("Unable to grab copy lock.", e2);
            }
        }
    }

    public void c() {
        FileChannel fileChannel = this.f2305e;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f2303c.unlock();
    }
}