package com.journeyapps.barcodescanner;

/* compiled from: DecoderResultPointCallback.java */
/* loaded from: classes2.dex */
public class g implements com.google.zxing.n {
    private e a;

    @Override // com.google.zxing.n
    public void a(com.google.zxing.m mVar) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a(mVar);
        }
    }

    public void b(e eVar) {
        this.a = eVar;
    }
}