package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class DecoratedBarcodeView extends FrameLayout {
    private BarcodeView a;

    /* renamed from: b  reason: collision with root package name */
    private ViewfinderView f10331b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f10332c;

    /* renamed from: d  reason: collision with root package name */
    private a f10333d;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    private class b implements com.journeyapps.barcodescanner.a {
        private com.journeyapps.barcodescanner.a a;

        public b(com.journeyapps.barcodescanner.a aVar) {
            this.a = aVar;
        }

        @Override // com.journeyapps.barcodescanner.a
        public void a(List<com.google.zxing.m> list) {
            for (com.google.zxing.m mVar : list) {
                DecoratedBarcodeView.this.f10331b.a(mVar);
            }
            this.a.a(list);
        }

        @Override // com.journeyapps.barcodescanner.a
        public void b(com.journeyapps.barcodescanner.b bVar) {
            this.a.b(bVar);
        }
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.google.zxing.p.a.k.f9910k);
        int resourceId = obtainStyledAttributes.getResourceId(com.google.zxing.p.a.k.f9911l, com.google.zxing.p.a.h.zxing_barcode_scanner);
        obtainStyledAttributes.recycle();
        FrameLayout.inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(com.google.zxing.p.a.g.zxing_barcode_surface);
        this.a = barcodeView;
        if (barcodeView != null) {
            barcodeView.q(attributeSet);
            ViewfinderView viewfinderView = (ViewfinderView) findViewById(com.google.zxing.p.a.g.zxing_viewfinder_view);
            this.f10331b = viewfinderView;
            if (viewfinderView != null) {
                viewfinderView.setCameraPreview(this.a);
                this.f10332c = (TextView) findViewById(com.google.zxing.p.a.g.zxing_status_view);
                return;
            }
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
    }

    public void b(com.journeyapps.barcodescanner.a aVar) {
        this.a.J(new b(aVar));
    }

    public void d(Intent intent) {
        int intExtra;
        Set<com.google.zxing.a> a2 = com.google.zxing.p.a.c.a(intent);
        Map<com.google.zxing.d, ?> a3 = com.google.zxing.p.a.d.a(intent);
        com.journeyapps.barcodescanner.q.d dVar = new com.journeyapps.barcodescanner.q.d();
        if (intent.hasExtra("SCAN_CAMERA_ID") && (intExtra = intent.getIntExtra("SCAN_CAMERA_ID", -1)) >= 0) {
            dVar.i(intExtra);
        }
        String stringExtra = intent.getStringExtra("PROMPT_MESSAGE");
        if (stringExtra != null) {
            setStatusText(stringExtra);
        }
        int intExtra2 = intent.getIntExtra("SCAN_TYPE", 0);
        String stringExtra2 = intent.getStringExtra("CHARACTER_SET");
        new com.google.zxing.h().e(a3);
        this.a.setCameraSettings(dVar);
        this.a.setDecoderFactory(new i(a2, a3, stringExtra2, intExtra2));
    }

    public void e() {
        this.a.u();
    }

    public void f() {
        this.a.v();
    }

    public void g() {
        this.a.y();
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(com.google.zxing.p.a.g.zxing_barcode_surface);
    }

    public TextView getStatusView() {
        return this.f10332c;
    }

    public ViewfinderView getViewFinder() {
        return this.f10331b;
    }

    public void h() {
        this.a.setTorch(false);
        a aVar = this.f10333d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void i() {
        this.a.setTorch(true);
        a aVar = this.f10333d;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 24) {
            i();
            return true;
        } else if (i2 == 25) {
            h();
            return true;
        } else if (i2 == 27 || i2 == 80) {
            return true;
        } else {
            return super.onKeyDown(i2, keyEvent);
        }
    }

    public void setStatusText(String str) {
        TextView textView = this.f10332c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTorchListener(a aVar) {
        this.f10333d = aVar;
    }
}