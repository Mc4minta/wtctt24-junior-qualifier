package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

/* loaded from: classes2.dex */
public class CaptureActivity extends Activity {
    private d a;

    /* renamed from: b  reason: collision with root package name */
    private DecoratedBarcodeView f10330b;

    protected DecoratedBarcodeView a() {
        setContentView(com.google.zxing.p.a.h.zxing_capture);
        return (DecoratedBarcodeView) findViewById(com.google.zxing.p.a.g.zxing_barcode_scanner);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10330b = a();
        d dVar = new d(this, this.f10330b);
        this.a = dVar;
        dVar.l(getIntent(), bundle);
        this.a.h();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.a.n();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return this.f10330b.onKeyDown(i2, keyEvent) || super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.a.o();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.a.p(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.a.q();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.a.r(bundle);
    }
}