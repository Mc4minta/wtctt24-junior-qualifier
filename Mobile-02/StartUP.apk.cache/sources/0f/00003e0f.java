package com.journeyapps.barcodescanner;

/* compiled from: MixedDecoder.java */
/* loaded from: classes2.dex */
public class k extends e {

    /* renamed from: c  reason: collision with root package name */
    private boolean f10383c;

    public k(com.google.zxing.j jVar) {
        super(jVar);
        this.f10383c = true;
    }

    @Override // com.journeyapps.barcodescanner.e
    protected com.google.zxing.c e(com.google.zxing.g gVar) {
        if (this.f10383c) {
            this.f10383c = false;
            return new com.google.zxing.c(new com.google.zxing.q.j(gVar.e()));
        }
        this.f10383c = true;
        return new com.google.zxing.c(new com.google.zxing.q.j(gVar));
    }
}