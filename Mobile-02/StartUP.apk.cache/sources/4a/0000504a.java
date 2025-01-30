package h.c.n0.j;

import h.c.z;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: QueueDrainHelper.java */
/* loaded from: classes3.dex */
public final class r {
    public static <T, U> boolean a(boolean z, boolean z2, z<?> zVar, boolean z3, h.c.n0.c.j<?> jVar, h.c.k0.b bVar, n<T, U> nVar) {
        if (nVar.cancelled()) {
            jVar.clear();
            bVar.dispose();
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    Throwable b2 = nVar.b();
                    if (b2 != null) {
                        zVar.onError(b2);
                    } else {
                        zVar.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable b3 = nVar.b();
            if (b3 != null) {
                jVar.clear();
                if (bVar != null) {
                    bVar.dispose();
                }
                zVar.onError(b3);
                return true;
            } else if (z2) {
                if (bVar != null) {
                    bVar.dispose();
                }
                zVar.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static <T, U> boolean b(boolean z, boolean z2, k.a.c<?> cVar, boolean z3, h.c.n0.c.j<?> jVar, q<T, U> qVar) {
        if (qVar.cancelled()) {
            jVar.clear();
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    Throwable b2 = qVar.b();
                    if (b2 != null) {
                        cVar.onError(b2);
                    } else {
                        cVar.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable b3 = qVar.b();
            if (b3 != null) {
                jVar.clear();
                cVar.onError(b3);
                return true;
            } else if (z2) {
                cVar.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static <T> h.c.n0.c.j<T> c(int i2) {
        if (i2 < 0) {
            return new h.c.n0.f.c(-i2);
        }
        return new h.c.n0.f.b(i2);
    }

    public static <T, U> void d(h.c.n0.c.i<T> iVar, z<? super U> zVar, boolean z, h.c.k0.b bVar, n<T, U> nVar) {
        int i2 = 1;
        while (!a(nVar.a(), iVar.isEmpty(), zVar, z, iVar, bVar, nVar)) {
            while (true) {
                boolean a = nVar.a();
                T poll = iVar.poll();
                boolean z2 = poll == null;
                if (a(a, z2, zVar, z, iVar, bVar, nVar)) {
                    return;
                }
                if (z2) {
                    i2 = nVar.c(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    nVar.d(zVar, poll);
                }
            }
        }
    }

    public static <T, U> void e(h.c.n0.c.i<T> iVar, k.a.c<? super U> cVar, boolean z, h.c.k0.b bVar, q<T, U> qVar) {
        int i2 = 1;
        while (true) {
            boolean a = qVar.a();
            T poll = iVar.poll();
            boolean z2 = poll == null;
            if (b(a, z2, cVar, z, iVar, qVar)) {
                if (bVar != null) {
                    bVar.dispose();
                    return;
                }
                return;
            } else if (z2) {
                i2 = qVar.c(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                long d2 = qVar.d();
                if (d2 != 0) {
                    if (qVar.e(cVar, poll) && d2 != Long.MAX_VALUE) {
                        qVar.f(1L);
                    }
                } else {
                    iVar.clear();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    cVar.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                }
            }
        }
    }

    static boolean f(h.c.m0.e eVar) {
        try {
            return eVar.a();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            return true;
        }
    }

    public static <T> void g(k.a.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, h.c.m0.e eVar) {
        long j2;
        long j3;
        if (queue.isEmpty()) {
            cVar.onComplete();
        } else if (h(atomicLong.get(), cVar, queue, atomicLong, eVar)) {
        } else {
            do {
                j2 = atomicLong.get();
                if ((j2 & Long.MIN_VALUE) != 0) {
                    return;
                }
                j3 = j2 | Long.MIN_VALUE;
            } while (!atomicLong.compareAndSet(j2, j3));
            if (j2 != 0) {
                h(j3, cVar, queue, atomicLong, eVar);
            }
        }
    }

    static <T> boolean h(long j2, k.a.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, h.c.m0.e eVar) {
        long j3 = j2 & Long.MIN_VALUE;
        while (true) {
            if (j3 != j2) {
                if (f(eVar)) {
                    return true;
                }
                Object obj = (T) queue.poll();
                if (obj == null) {
                    cVar.onComplete();
                    return true;
                }
                cVar.onNext(obj);
                j3++;
            } else if (f(eVar)) {
                return true;
            } else {
                if (queue.isEmpty()) {
                    cVar.onComplete();
                    return true;
                }
                j2 = atomicLong.get();
                if (j2 == j3) {
                    long addAndGet = atomicLong.addAndGet(-(j3 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j2 = addAndGet;
                    j3 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> boolean i(long j2, k.a.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, h.c.m0.e eVar) {
        long j3;
        do {
            j3 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j3, d.c(Long.MAX_VALUE & j3, j2) | (j3 & Long.MIN_VALUE)));
        if (j3 == Long.MIN_VALUE) {
            h(j2 | Long.MIN_VALUE, cVar, queue, atomicLong, eVar);
            return true;
        }
        return false;
    }

    public static void j(k.a.d dVar, int i2) {
        dVar.request(i2 < 0 ? Long.MAX_VALUE : i2);
    }
}