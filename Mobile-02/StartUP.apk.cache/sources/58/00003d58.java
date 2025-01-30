package com.google.zxing.u.d;

import com.google.zxing.NotFoundException;
import com.google.zxing.m;

/* compiled from: BoundingBox.java */
/* loaded from: classes2.dex */
final class c {
    private com.google.zxing.q.b a;

    /* renamed from: b  reason: collision with root package name */
    private m f10079b;

    /* renamed from: c  reason: collision with root package name */
    private m f10080c;

    /* renamed from: d  reason: collision with root package name */
    private m f10081d;

    /* renamed from: e  reason: collision with root package name */
    private m f10082e;

    /* renamed from: f  reason: collision with root package name */
    private int f10083f;

    /* renamed from: g  reason: collision with root package name */
    private int f10084g;

    /* renamed from: h  reason: collision with root package name */
    private int f10085h;

    /* renamed from: i  reason: collision with root package name */
    private int f10086i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.zxing.q.b bVar, m mVar, m mVar2, m mVar3, m mVar4) throws NotFoundException {
        if ((mVar == null && mVar3 == null) || ((mVar2 == null && mVar4 == null) || ((mVar != null && mVar2 == null) || (mVar3 != null && mVar4 == null)))) {
            throw NotFoundException.a();
        }
        k(bVar, mVar, mVar2, mVar3, mVar4);
    }

    private void b() {
        if (this.f10079b == null) {
            this.f10079b = new m(0.0f, this.f10081d.d());
            this.f10080c = new m(0.0f, this.f10082e.d());
        } else if (this.f10081d == null) {
            this.f10081d = new m(this.a.n() - 1, this.f10079b.d());
            this.f10082e = new m(this.a.n() - 1, this.f10080c.d());
        }
        this.f10083f = (int) Math.min(this.f10079b.c(), this.f10080c.c());
        this.f10084g = (int) Math.max(this.f10081d.c(), this.f10082e.c());
        this.f10085h = (int) Math.min(this.f10079b.d(), this.f10081d.d());
        this.f10086i = (int) Math.max(this.f10080c.d(), this.f10082e.d());
    }

    private void k(com.google.zxing.q.b bVar, m mVar, m mVar2, m mVar3, m mVar4) {
        this.a = bVar;
        this.f10079b = mVar;
        this.f10080c = mVar2;
        this.f10081d = mVar3;
        this.f10082e = mVar4;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c l(c cVar, c cVar2) throws NotFoundException {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.a, cVar.f10079b, cVar.f10080c, cVar2.f10081d, cVar2.f10082e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.zxing.u.d.c a(int r13, int r14, boolean r15) throws com.google.zxing.NotFoundException {
        /*
            r12 = this;
            com.google.zxing.m r0 = r12.f10079b
            com.google.zxing.m r1 = r12.f10080c
            com.google.zxing.m r2 = r12.f10081d
            com.google.zxing.m r3 = r12.f10082e
            if (r13 <= 0) goto L29
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.d()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            com.google.zxing.m r13 = new com.google.zxing.m
            float r4 = r4.c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L26
            r8 = r13
            goto L2a
        L26:
            r10 = r13
            r8 = r0
            goto L2b
        L29:
            r8 = r0
        L2a:
            r10 = r2
        L2b:
            if (r14 <= 0) goto L5b
            if (r15 == 0) goto L32
            com.google.zxing.m r13 = r12.f10080c
            goto L34
        L32:
            com.google.zxing.m r13 = r12.f10082e
        L34:
            float r0 = r13.d()
            int r0 = (int) r0
            int r0 = r0 + r14
            com.google.zxing.q.b r14 = r12.a
            int r14 = r14.i()
            if (r0 < r14) goto L4a
            com.google.zxing.q.b r14 = r12.a
            int r14 = r14.i()
            int r0 = r14 + (-1)
        L4a:
            com.google.zxing.m r14 = new com.google.zxing.m
            float r13 = r13.c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L58
            r9 = r14
            goto L5c
        L58:
            r11 = r14
            r9 = r1
            goto L5d
        L5b:
            r9 = r1
        L5c:
            r11 = r3
        L5d:
            r12.b()
            com.google.zxing.u.d.c r13 = new com.google.zxing.u.d.c
            com.google.zxing.q.b r7 = r12.a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.u.d.c.a(int, int, boolean):com.google.zxing.u.d.c");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m c() {
        return this.f10080c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m d() {
        return this.f10082e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f10084g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f10086i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f10083f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f10085h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m i() {
        return this.f10079b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m j() {
        return this.f10081d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(c cVar) {
        k(cVar.a, cVar.f10079b, cVar.f10080c, cVar.f10081d, cVar.f10082e);
    }
}