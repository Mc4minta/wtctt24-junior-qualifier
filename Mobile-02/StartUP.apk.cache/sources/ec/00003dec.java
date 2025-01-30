package com.journeyapps.barcodescanner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class BarcodeView extends c {
    private b F;
    private com.journeyapps.barcodescanner.a G;
    private h H;
    private f I;
    private Handler J;
    private final Handler.Callback K;

    /* loaded from: classes2.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == com.google.zxing.p.a.g.zxing_decode_succeeded) {
                com.journeyapps.barcodescanner.b bVar = (com.journeyapps.barcodescanner.b) message.obj;
                if (bVar != null && BarcodeView.this.G != null && BarcodeView.this.F != b.NONE) {
                    BarcodeView.this.G.b(bVar);
                    if (BarcodeView.this.F == b.SINGLE) {
                        BarcodeView.this.N();
                    }
                }
                return true;
            } else if (i2 == com.google.zxing.p.a.g.zxing_decode_failed) {
                return true;
            } else {
                if (i2 == com.google.zxing.p.a.g.zxing_possible_result_points) {
                    List<com.google.zxing.m> list = (List) message.obj;
                    if (BarcodeView.this.G != null && BarcodeView.this.F != b.NONE) {
                        BarcodeView.this.G.a(list);
                    }
                    return true;
                }
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum b {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = b.NONE;
        this.G = null;
        this.K = new a();
        K();
    }

    private e G() {
        if (this.I == null) {
            this.I = H();
        }
        g gVar = new g();
        HashMap hashMap = new HashMap();
        hashMap.put(com.google.zxing.d.NEED_RESULT_POINT_CALLBACK, gVar);
        e a2 = this.I.a(hashMap);
        gVar.b(a2);
        return a2;
    }

    private void K() {
        this.I = new i();
        this.J = new Handler(this.K);
    }

    private void L() {
        M();
        if (this.F == b.NONE || !t()) {
            return;
        }
        h hVar = new h(getCameraInstance(), G(), this.J);
        this.H = hVar;
        hVar.i(getPreviewFramingRect());
        this.H.k();
    }

    private void M() {
        h hVar = this.H;
        if (hVar != null) {
            hVar.l();
            this.H = null;
        }
    }

    protected f H() {
        return new i();
    }

    public void I(com.journeyapps.barcodescanner.a aVar) {
        this.F = b.CONTINUOUS;
        this.G = aVar;
        L();
    }

    public void J(com.journeyapps.barcodescanner.a aVar) {
        this.F = b.SINGLE;
        this.G = aVar;
        L();
    }

    public void N() {
        this.F = b.NONE;
        this.G = null;
        M();
    }

    public f getDecoderFactory() {
        return this.I;
    }

    public void setDecoderFactory(f fVar) {
        p.a();
        this.I = fVar;
        h hVar = this.H;
        if (hVar != null) {
            hVar.j(G());
        }
    }

    @Override // com.journeyapps.barcodescanner.c
    public void u() {
        M();
        super.u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.journeyapps.barcodescanner.c
    public void x() {
        super.x();
        L();
    }
}