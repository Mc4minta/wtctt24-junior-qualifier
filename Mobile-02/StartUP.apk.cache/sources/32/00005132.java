package j;

/* compiled from: PeekSource.kt */
/* loaded from: classes3.dex */
public final class v implements e0 {
    private final f a;

    /* renamed from: b  reason: collision with root package name */
    private z f17169b;

    /* renamed from: c  reason: collision with root package name */
    private int f17170c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17171d;

    /* renamed from: e  reason: collision with root package name */
    private long f17172e;

    /* renamed from: f  reason: collision with root package name */
    private final h f17173f;

    public v(h upstream) {
        kotlin.jvm.internal.m.g(upstream, "upstream");
        this.f17173f = upstream;
        f buffer = upstream.getBuffer();
        this.a = buffer;
        z zVar = buffer.a;
        this.f17169b = zVar;
        this.f17170c = zVar != null ? zVar.f17188c : -1;
    }

    @Override // j.e0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f17171d = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r5 == r6.f17188c) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    @Override // j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long read(j.f r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.m.g(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r2 < 0) goto Lf
            r5 = r4
            goto L10
        Lf:
            r5 = r3
        L10:
            if (r5 == 0) goto L87
            boolean r5 = r8.f17171d
            r5 = r5 ^ r4
            if (r5 == 0) goto L7b
            j.z r5 = r8.f17169b
            if (r5 == 0) goto L2a
            j.f r6 = r8.a
            j.z r6 = r6.a
            if (r5 != r6) goto L2b
            int r5 = r8.f17170c
            kotlin.jvm.internal.m.e(r6)
            int r6 = r6.f17188c
            if (r5 != r6) goto L2b
        L2a:
            r3 = r4
        L2b:
            if (r3 == 0) goto L6f
            if (r2 != 0) goto L30
            return r0
        L30:
            j.h r0 = r8.f17173f
            long r1 = r8.f17172e
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L40
            r9 = -1
            return r9
        L40:
            j.z r0 = r8.f17169b
            if (r0 != 0) goto L53
            j.f r0 = r8.a
            j.z r0 = r0.a
            if (r0 == 0) goto L53
            r8.f17169b = r0
            kotlin.jvm.internal.m.e(r0)
            int r0 = r0.f17188c
            r8.f17170c = r0
        L53:
            j.f r0 = r8.a
            long r0 = r0.O0()
            long r2 = r8.f17172e
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            j.f r2 = r8.a
            long r4 = r8.f17172e
            r3 = r9
            r6 = r10
            r2.f(r3, r4, r6)
            long r0 = r8.f17172e
            long r0 = r0 + r10
            r8.f17172e = r0
            return r10
        L6f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L7b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L87:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "byteCount < 0: "
            r9.append(r0)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: j.v.read(j.f, long):long");
    }

    @Override // j.e0
    public f0 timeout() {
        return this.f17173f.timeout();
    }
}