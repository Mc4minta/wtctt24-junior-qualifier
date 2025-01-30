package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.x;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes3.dex */
public final class k<E> {
    private volatile Object _next = null;
    private volatile long _state = 0;

    /* renamed from: e  reason: collision with root package name */
    private final int f17504e;

    /* renamed from: f  reason: collision with root package name */
    private AtomicReferenceArray f17505f;

    /* renamed from: g  reason: collision with root package name */
    private final int f17506g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f17507h;

    /* renamed from: d  reason: collision with root package name */
    public static final a f17503d = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static final o f17502c = new o("REMOVE_FROZEN");
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f17501b = AtomicLongFieldUpdater.newUpdater(k.class, "_state");

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final int a(long j2) {
            return (j2 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j2, int i2) {
            return d(j2, 1073741823L) | (i2 << 0);
        }

        public final long c(long j2, int i2) {
            return d(j2, 1152921503533105152L) | (i2 << 30);
        }

        public final long d(long j2, long j3) {
            return j2 & (~j3);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        public final int a;

        public b(int i2) {
            this.a = i2;
        }
    }

    public k(int i2, boolean z) {
        this.f17506g = i2;
        this.f17507h = z;
        int i3 = i2 - 1;
        this.f17504e = i3;
        this.f17505f = new AtomicReferenceArray(i2);
        if (!(i3 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i2 & i3) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final k<E> b(long j2) {
        k<E> kVar = new k<>(this.f17506g * 2, this.f17507h);
        int i2 = (int) ((1073741823 & j2) >> 0);
        int i3 = (int) ((1152921503533105152L & j2) >> 30);
        while (true) {
            int i4 = this.f17504e;
            if ((i2 & i4) != (i3 & i4)) {
                Object obj = this.f17505f.get(i4 & i2);
                if (obj == null) {
                    obj = new b(i2);
                }
                kVar.f17505f.set(kVar.f17504e & i2, obj);
                i2++;
            } else {
                kVar._state = f17503d.d(j2, 1152921504606846976L);
                return kVar;
            }
        }
    }

    private final k<E> c(long j2) {
        while (true) {
            k<E> kVar = (k) this._next;
            if (kVar != null) {
                return kVar;
            }
            a.compareAndSet(this, null, b(j2));
        }
    }

    private final k<E> e(int i2, E e2) {
        Object obj = this.f17505f.get(this.f17504e & i2);
        if ((obj instanceof b) && ((b) obj).a == i2) {
            this.f17505f.set(i2 & this.f17504e, e2);
            return this;
        }
        return null;
    }

    private final long h() {
        long j2;
        long j3;
        do {
            j2 = this._state;
            if ((j2 & 1152921504606846976L) != 0) {
                return j2;
            }
            j3 = j2 | 1152921504606846976L;
        } while (!f17501b.compareAndSet(this, j2, j3));
        return j3;
    }

    private final k<E> k(int i2, int i3) {
        long j2;
        a aVar;
        int i4;
        do {
            j2 = this._state;
            aVar = f17503d;
            i4 = (int) ((1073741823 & j2) >> 0);
            if (x.a()) {
                if (!(i4 == i2)) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j2) != 0) {
                return i();
            }
        } while (!f17501b.compareAndSet(this, j2, aVar.b(j2, i3)));
        this.f17505f.set(this.f17504e & i4, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(E r14) {
        /*
            r13 = this;
        L0:
            long r2 = r13._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 == 0) goto L12
            kotlinx.coroutines.internal.k$a r14 = kotlinx.coroutines.internal.k.f17503d
            int r14 = r14.a(r2)
            return r14
        L12:
            kotlinx.coroutines.internal.k$a r0 = kotlinx.coroutines.internal.k.f17503d
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            r8 = 0
            long r4 = r4 >> r8
            int r1 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r9 = 30
            long r4 = r4 >> r9
            int r9 = (int) r4
            int r10 = r13.f17504e
            int r4 = r9 + 2
            r4 = r4 & r10
            r5 = r1 & r10
            r11 = 1
            if (r4 != r5) goto L30
            return r11
        L30:
            boolean r4 = r13.f17507h
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r13.f17505f
            r12 = r9 & r10
            java.lang.Object r4 = r4.get(r12)
            if (r4 == 0) goto L4f
            int r0 = r13.f17506g
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4e:
            return r11
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = kotlinx.coroutines.internal.k.f17501b
            long r11 = r0.c(r2, r1)
            r0 = r4
            r1 = r13
            r4 = r11
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.f17505f
            r1 = r9 & r10
            r0.set(r1, r14)
            r0 = r13
        L69:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 != 0) goto L73
            goto L7e
        L73:
            kotlinx.coroutines.internal.k r0 = r0.i()
            kotlinx.coroutines.internal.k r0 = r0.e(r9, r14)
            if (r0 == 0) goto L7e
            goto L69
        L7e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.k.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j2;
        do {
            j2 = this._state;
            if ((j2 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j2) != 0) {
                return false;
            }
        } while (!f17501b.compareAndSet(this, j2, j2 | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j2 = this._state;
        return (((int) ((j2 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j2) >> 0))) & 1073741823;
    }

    public final boolean g() {
        long j2 = this._state;
        return ((int) ((1073741823 & j2) >> 0)) == ((int) ((j2 & 1152921503533105152L) >> 30));
    }

    public final k<E> i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j2 = this._state;
            if ((1152921504606846976L & j2) != 0) {
                return f17502c;
            }
            a aVar = f17503d;
            int i2 = (int) ((1073741823 & j2) >> 0);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            int i4 = this.f17504e;
            if ((i3 & i4) == (i2 & i4)) {
                return null;
            }
            Object obj = this.f17505f.get(i4 & i2);
            if (obj == null) {
                if (this.f17507h) {
                    return null;
                }
            } else if (obj instanceof b) {
                return null;
            } else {
                int i5 = (i2 + 1) & 1073741823;
                if (f17501b.compareAndSet(this, j2, aVar.b(j2, i5))) {
                    this.f17505f.set(this.f17504e & i2, null);
                    return obj;
                } else if (this.f17507h) {
                    k<E> kVar = this;
                    do {
                        kVar = kVar.k(i2, i5);
                    } while (kVar != null);
                    return obj;
                }
            }
        }
    }
}