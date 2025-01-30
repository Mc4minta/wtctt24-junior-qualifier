package e.g.a.b;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.OrientationEventListener;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: DisplayOrientationDetector.java */
/* loaded from: classes2.dex */
abstract class h {
    static final SparseIntArray a;

    /* renamed from: b  reason: collision with root package name */
    private final OrientationEventListener f12958b;

    /* renamed from: c  reason: collision with root package name */
    Display f12959c;

    /* renamed from: d  reason: collision with root package name */
    private int f12960d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f12961e = 0;

    /* compiled from: DisplayOrientationDetector.java */
    /* loaded from: classes2.dex */
    class a extends OrientationEventListener {
        private int a;

        a(Context context) {
            super(context);
            this.a = -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // android.view.OrientationEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onOrientationChanged(int r6) {
            /*
                r5 = this;
                r0 = -1
                if (r6 == r0) goto L58
                e.g.a.b.h r0 = e.g.a.b.h.this
                android.view.Display r1 = r0.f12959c
                if (r1 != 0) goto La
                goto L58
            La:
                r1 = 315(0x13b, float:4.41E-43)
                r2 = 0
                if (r6 > r1) goto L2d
                r3 = 45
                if (r6 >= r3) goto L14
                goto L2d
            L14:
                r4 = 135(0x87, float:1.89E-43)
                if (r6 <= r3) goto L1d
                if (r6 >= r4) goto L1d
                r6 = 90
                goto L2e
            L1d:
                r3 = 225(0xe1, float:3.15E-43)
                if (r6 <= r4) goto L26
                if (r6 >= r3) goto L26
                r6 = 180(0xb4, float:2.52E-43)
                goto L2e
            L26:
                if (r6 <= r3) goto L2d
                if (r6 >= r1) goto L2d
                r6 = 270(0x10e, float:3.78E-43)
                goto L2e
            L2d:
                r6 = r2
            L2e:
                int r0 = e.g.a.b.h.a(r0)
                r1 = 1
                if (r0 == r6) goto L3b
                e.g.a.b.h r0 = e.g.a.b.h.this
                e.g.a.b.h.b(r0, r6)
                r2 = r1
            L3b:
                e.g.a.b.h r6 = e.g.a.b.h.this
                android.view.Display r6 = r6.f12959c
                int r6 = r6.getRotation()
                int r0 = r5.a
                if (r0 == r6) goto L4a
                r5.a = r6
                goto L4b
            L4a:
                r1 = r2
            L4b:
                if (r1 == 0) goto L58
                e.g.a.b.h r0 = e.g.a.b.h.this
                android.util.SparseIntArray r1 = e.g.a.b.h.a
                int r6 = r1.get(r6)
                r0.d(r6)
            L58:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.g.a.b.h.a.onOrientationChanged(int):void");
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        a = sparseIntArray;
        sparseIntArray.put(0, 0);
        sparseIntArray.put(1, 90);
        sparseIntArray.put(2, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256);
        sparseIntArray.put(3, 270);
    }

    public h(Context context) {
        this.f12958b = new a(context);
    }

    public void c() {
        this.f12958b.disable();
        this.f12959c = null;
    }

    void d(int i2) {
        this.f12960d = i2;
        g(i2, this.f12961e);
    }

    public void e(Display display) {
        this.f12959c = display;
        this.f12958b.enable();
        d(a.get(display.getRotation()));
    }

    public int f() {
        return this.f12960d;
    }

    public abstract void g(int i2, int i3);
}