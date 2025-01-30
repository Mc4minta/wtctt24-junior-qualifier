package kotlinx.coroutines.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public class i {
    static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_next");

    /* renamed from: b  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater f17497b = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_prev");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f17498c = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_removedRef");
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static abstract class a extends c<i> {

        /* renamed from: b  reason: collision with root package name */
        public i f17499b;

        /* renamed from: c  reason: collision with root package name */
        public final i f17500c;

        public a(i iVar) {
            this.f17500c = iVar;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: h */
        public void d(i iVar, Object obj) {
            boolean z = obj == null;
            i iVar2 = z ? this.f17500c : this.f17499b;
            if (iVar2 != null && i.a.compareAndSet(iVar, this, iVar2) && z) {
                i iVar3 = this.f17500c;
                i iVar4 = this.f17499b;
                kotlin.jvm.internal.m.e(iVar4);
                iVar3.g(iVar4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (kotlinx.coroutines.internal.i.a.compareAndSet(r3, r2, ((kotlinx.coroutines.internal.m) r4).a) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlinx.coroutines.internal.i e(kotlinx.coroutines.internal.l r7) {
        /*
            r6 = this;
        L0:
            java.lang.Object r0 = r6._prev
            kotlinx.coroutines.internal.i r0 = (kotlinx.coroutines.internal.i) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r6) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.i.f17497b
            boolean r0 = r1.compareAndSet(r6, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r6.k()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r7) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.l
            if (r5 == 0) goto L38
            if (r7 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.l r0 = (kotlinx.coroutines.internal.l) r0
            boolean r0 = r7.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.l r4 = (kotlinx.coroutines.internal.l) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.m
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.i.a
            kotlinx.coroutines.internal.m r4 = (kotlinx.coroutines.internal.m) r4
            kotlinx.coroutines.internal.i r4 = r4.a
            boolean r2 = r5.compareAndSet(r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.i r2 = (kotlinx.coroutines.internal.i) r2
            goto L7
        L52:
        */
        //  java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            java.util.Objects.requireNonNull(r4, r3)
            kotlinx.coroutines.internal.i r4 = (kotlinx.coroutines.internal.i) r4
            r3 = r2
            r2 = r4
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.i.e(kotlinx.coroutines.internal.l):kotlinx.coroutines.internal.i");
    }

    private final i f(i iVar) {
        while (iVar.k()) {
            iVar = (i) iVar._prev;
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(i iVar) {
        i iVar2;
        do {
            iVar2 = (i) iVar._prev;
            if (h() != iVar) {
                return;
            }
        } while (!f17497b.compareAndSet(iVar, iVar2, this));
        if (k()) {
            iVar.e(null);
        }
    }

    private final m o() {
        m mVar = (m) this._removedRef;
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(this);
        f17498c.lazySet(this, mVar2);
        return mVar2;
    }

    public final boolean d(i iVar) {
        f17497b.lazySet(iVar, this);
        a.lazySet(iVar, this);
        while (h() == this) {
            if (a.compareAndSet(this, this, iVar)) {
                iVar.g(this);
                return true;
            }
        }
        return false;
    }

    public final Object h() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof l)) {
                return obj;
            }
            ((l) obj).c(this);
        }
    }

    public final i i() {
        return h.b(h());
    }

    public final i j() {
        i e2 = e(null);
        return e2 != null ? e2 : f((i) this._prev);
    }

    public boolean k() {
        return h() instanceof m;
    }

    public boolean l() {
        return m() == null;
    }

    public final i m() {
        Object h2;
        i iVar;
        do {
            h2 = h();
            if (h2 instanceof m) {
                return ((m) h2).a;
            }
            if (h2 == this) {
                return (i) h2;
            }
            Objects.requireNonNull(h2, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            iVar = (i) h2;
        } while (!a.compareAndSet(this, h2, iVar.o()));
        iVar.e(null);
        return null;
    }

    public final int p(i iVar, i iVar2, a aVar) {
        f17497b.lazySet(iVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(iVar, iVar2);
        aVar.f17499b = iVar2;
        if (atomicReferenceFieldUpdater.compareAndSet(this, iVar2, aVar)) {
            return aVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
}