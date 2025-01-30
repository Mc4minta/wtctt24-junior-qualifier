package com.journeyapps.barcodescanner;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Decoder.java */
/* loaded from: classes2.dex */
public class e implements com.google.zxing.n {
    private com.google.zxing.j a;

    /* renamed from: b  reason: collision with root package name */
    private List<com.google.zxing.m> f10369b = new ArrayList();

    public e(com.google.zxing.j jVar) {
        this.a = jVar;
    }

    @Override // com.google.zxing.n
    public void a(com.google.zxing.m mVar) {
        this.f10369b.add(mVar);
    }

    protected com.google.zxing.k b(com.google.zxing.c cVar) {
        com.google.zxing.k kVar;
        this.f10369b.clear();
        try {
            com.google.zxing.j jVar = this.a;
            if (jVar instanceof com.google.zxing.h) {
                kVar = ((com.google.zxing.h) jVar).d(cVar);
            } else {
                kVar = jVar.b(cVar);
            }
        } catch (Exception unused) {
            kVar = null;
        } catch (Throwable th) {
            this.a.reset();
            throw th;
        }
        this.a.reset();
        return kVar;
    }

    public com.google.zxing.k c(com.google.zxing.g gVar) {
        return b(e(gVar));
    }

    public List<com.google.zxing.m> d() {
        return new ArrayList(this.f10369b);
    }

    protected com.google.zxing.c e(com.google.zxing.g gVar) {
        return new com.google.zxing.c(new com.google.zxing.q.j(gVar));
    }
}