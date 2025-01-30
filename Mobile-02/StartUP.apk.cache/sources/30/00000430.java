package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: RoomSQLiteQuery.java */
/* loaded from: classes.dex */
public class m implements c.r.a.e, c.r.a.d {
    static final TreeMap<Integer, m> a = new TreeMap<>();

    /* renamed from: b  reason: collision with root package name */
    private volatile String f2283b;

    /* renamed from: c  reason: collision with root package name */
    final long[] f2284c;

    /* renamed from: d  reason: collision with root package name */
    final double[] f2285d;

    /* renamed from: e  reason: collision with root package name */
    final String[] f2286e;

    /* renamed from: f  reason: collision with root package name */
    final byte[][] f2287f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f2288g;

    /* renamed from: h  reason: collision with root package name */
    final int f2289h;

    /* renamed from: j  reason: collision with root package name */
    int f2290j;

    private m(int i2) {
        this.f2289h = i2;
        int i3 = i2 + 1;
        this.f2288g = new int[i3];
        this.f2284c = new long[i3];
        this.f2285d = new double[i3];
        this.f2286e = new String[i3];
        this.f2287f = new byte[i3];
    }

    public static m c(String str, int i2) {
        TreeMap<Integer, m> treeMap = a;
        synchronized (treeMap) {
            Map.Entry<Integer, m> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                m value = ceilingEntry.getValue();
                value.d(str, i2);
                return value;
            }
            m mVar = new m(i2);
            mVar.d(str, i2);
            return mVar;
        }
    }

    private static void e() {
        TreeMap<Integer, m> treeMap = a;
        if (treeMap.size() <= 15) {
            return;
        }
        int size = treeMap.size() - 10;
        Iterator<Integer> it = treeMap.descendingKeySet().iterator();
        while (true) {
            int i2 = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i2;
        }
    }

    @Override // c.r.a.d
    public void B0(int i2) {
        this.f2288g[i2] = 1;
    }

    @Override // c.r.a.d
    public void I(int i2, double d2) {
        this.f2288g[i2] = 3;
        this.f2285d[i2] = d2;
    }

    @Override // c.r.a.e
    public String a() {
        return this.f2283b;
    }

    @Override // c.r.a.e
    public void b(c.r.a.d dVar) {
        for (int i2 = 1; i2 <= this.f2290j; i2++) {
            int i3 = this.f2288g[i2];
            if (i3 == 1) {
                dVar.B0(i2);
            } else if (i3 == 2) {
                dVar.b0(i2, this.f2284c[i2]);
            } else if (i3 == 3) {
                dVar.I(i2, this.f2285d[i2]);
            } else if (i3 == 4) {
                dVar.u(i2, this.f2286e[i2]);
            } else if (i3 == 5) {
                dVar.f0(i2, this.f2287f[i2]);
            }
        }
    }

    @Override // c.r.a.d
    public void b0(int i2, long j2) {
        this.f2288g[i2] = 2;
        this.f2284c[i2] = j2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    void d(String str, int i2) {
        this.f2283b = str;
        this.f2290j = i2;
    }

    public void f() {
        TreeMap<Integer, m> treeMap = a;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f2289h), this);
            e();
        }
    }

    @Override // c.r.a.d
    public void f0(int i2, byte[] bArr) {
        this.f2288g[i2] = 5;
        this.f2287f[i2] = bArr;
    }

    @Override // c.r.a.d
    public void u(int i2, String str) {
        this.f2288g[i2] = 4;
        this.f2286e[i2] = str;
    }
}