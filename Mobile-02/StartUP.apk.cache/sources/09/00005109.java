package j;

import java.util.concurrent.atomic.AtomicReference;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: SegmentPool.kt */
/* loaded from: classes3.dex */
public final class a0 {

    /* renamed from: c  reason: collision with root package name */
    private static final int f17137c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReference<z>[] f17138d;

    /* renamed from: e  reason: collision with root package name */
    public static final a0 f17139e = new a0();
    private static final int a = 65536;

    /* renamed from: b  reason: collision with root package name */
    private static final z f17136b = new z(new byte[0], 0, 0, false, false);

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f17137c = highestOneBit;
        AtomicReference<z>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i2 = 0; i2 < highestOneBit; i2++) {
            atomicReferenceArr[i2] = new AtomicReference<>();
        }
        f17138d = atomicReferenceArr;
    }

    private a0() {
    }

    private final AtomicReference<z> a() {
        Thread currentThread = Thread.currentThread();
        kotlin.jvm.internal.m.f(currentThread, "Thread.currentThread()");
        return f17138d[(int) (currentThread.getId() & (f17137c - 1))];
    }

    public static final void b(z segment) {
        AtomicReference<z> a2;
        z zVar;
        kotlin.jvm.internal.m.g(segment, "segment");
        if (segment.f17192g == null && segment.f17193h == null) {
            if (segment.f17190e || (zVar = (a2 = f17139e.a()).get()) == f17136b) {
                return;
            }
            int i2 = zVar != null ? zVar.f17189d : 0;
            if (i2 >= a) {
                return;
            }
            segment.f17192g = zVar;
            segment.f17188c = 0;
            segment.f17189d = i2 + PKIFailureInfo.certRevoked;
            if (a2.compareAndSet(zVar, segment)) {
                return;
            }
            segment.f17192g = null;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final z c() {
        AtomicReference<z> a2 = f17139e.a();
        z zVar = f17136b;
        z andSet = a2.getAndSet(zVar);
        if (andSet == zVar) {
            return new z();
        }
        if (andSet == null) {
            a2.set(null);
            return new z();
        }
        a2.set(andSet.f17192g);
        andSet.f17192g = null;
        andSet.f17189d = 0;
        return andSet;
    }
}