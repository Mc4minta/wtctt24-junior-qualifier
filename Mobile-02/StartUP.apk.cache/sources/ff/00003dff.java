package com.journeyapps.barcodescanner;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.appsflyer.internal.referrer.Payload;
import com.journeyapps.barcodescanner.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: CaptureManager.java */
/* loaded from: classes2.dex */
public class d {
    private static final String a = "d";

    /* renamed from: b  reason: collision with root package name */
    private static int f10357b = 250;

    /* renamed from: c  reason: collision with root package name */
    private Activity f10358c;

    /* renamed from: d  reason: collision with root package name */
    private DecoratedBarcodeView f10359d;

    /* renamed from: h  reason: collision with root package name */
    private com.google.zxing.p.a.e f10363h;

    /* renamed from: i  reason: collision with root package name */
    private com.google.zxing.p.a.b f10364i;

    /* renamed from: j  reason: collision with root package name */
    private Handler f10365j;
    private final c.f m;
    private boolean n;

    /* renamed from: e  reason: collision with root package name */
    private int f10360e = -1;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10361f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10362g = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10366k = false;

    /* renamed from: l  reason: collision with root package name */
    private com.journeyapps.barcodescanner.a f10367l = new a();

    /* compiled from: CaptureManager.java */
    /* loaded from: classes2.dex */
    class a implements com.journeyapps.barcodescanner.a {

        /* compiled from: CaptureManager.java */
        /* renamed from: com.journeyapps.barcodescanner.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0216a implements Runnable {
            final /* synthetic */ com.journeyapps.barcodescanner.b a;

            RunnableC0216a(com.journeyapps.barcodescanner.b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.u(this.a);
            }
        }

        a() {
        }

        @Override // com.journeyapps.barcodescanner.a
        public void a(List<com.google.zxing.m> list) {
        }

        @Override // com.journeyapps.barcodescanner.a
        public void b(com.journeyapps.barcodescanner.b bVar) {
            d.this.f10359d.e();
            d.this.f10364i.c();
            d.this.f10365j.post(new RunnableC0216a(bVar));
        }
    }

    /* compiled from: CaptureManager.java */
    /* loaded from: classes2.dex */
    class b implements c.f {
        b() {
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void a() {
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void b(Exception exc) {
            d.this.i();
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void c() {
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void d() {
            if (d.this.f10366k) {
                Log.d(d.a, "Camera closed; finishing activity");
                d.this.j();
            }
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void e() {
        }
    }

    /* compiled from: CaptureManager.java */
    /* loaded from: classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d(d.a, "Finishing due to inactivity");
            d.this.j();
        }
    }

    /* compiled from: CaptureManager.java */
    /* renamed from: com.journeyapps.barcodescanner.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0217d implements Runnable {
        RunnableC0217d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CaptureManager.java */
    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CaptureManager.java */
    /* loaded from: classes2.dex */
    public class f implements DialogInterface.OnCancelListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            d.this.j();
        }
    }

    public d(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        b bVar = new b();
        this.m = bVar;
        this.n = false;
        this.f10358c = activity;
        this.f10359d = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().i(bVar);
        this.f10365j = new Handler();
        this.f10363h = new com.google.zxing.p.a.e(activity, new c());
        this.f10364i = new com.google.zxing.p.a.b(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f10358c.finish();
    }

    private String k(com.journeyapps.barcodescanner.b bVar) {
        if (this.f10361f) {
            Bitmap b2 = bVar.b();
            try {
                File createTempFile = File.createTempFile("barcodeimage", ".jpg", this.f10358c.getCacheDir());
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                b2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                return createTempFile.getAbsolutePath();
            } catch (IOException e2) {
                String str = a;
                Log.w(str, "Unable to create temporary file and store bitmap! " + e2);
            }
        }
        return null;
    }

    @TargetApi(23)
    private void s() {
        if (androidx.core.content.a.a(this.f10358c, "android.permission.CAMERA") == 0) {
            this.f10359d.g();
        } else if (this.n) {
        } else {
            androidx.core.app.a.r(this.f10358c, new String[]{"android.permission.CAMERA"}, f10357b);
            this.n = true;
        }
    }

    public static Intent t(com.journeyapps.barcodescanner.b bVar, String str) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.addFlags(PKIFailureInfo.signerNotTrusted);
        intent.putExtra("SCAN_RESULT", bVar.toString());
        intent.putExtra("SCAN_RESULT_FORMAT", bVar.a().toString());
        byte[] c2 = bVar.c();
        if (c2 != null && c2.length > 0) {
            intent.putExtra("SCAN_RESULT_BYTES", c2);
        }
        Map<com.google.zxing.l, Object> d2 = bVar.d();
        if (d2 != null) {
            com.google.zxing.l lVar = com.google.zxing.l.UPC_EAN_EXTENSION;
            if (d2.containsKey(lVar)) {
                intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", d2.get(lVar).toString());
            }
            Number number = (Number) d2.get(com.google.zxing.l.ORIENTATION);
            if (number != null) {
                intent.putExtra("SCAN_RESULT_ORIENTATION", number.intValue());
            }
            String str2 = (String) d2.get(com.google.zxing.l.ERROR_CORRECTION_LEVEL);
            if (str2 != null) {
                intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", str2);
            }
            Iterable<byte[]> iterable = (Iterable) d2.get(com.google.zxing.l.BYTE_SEGMENTS);
            if (iterable != null) {
                int i2 = 0;
                for (byte[] bArr : iterable) {
                    intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i2, bArr);
                    i2++;
                }
            }
        }
        if (str != null) {
            intent.putExtra("SCAN_RESULT_IMAGE_PATH", str);
        }
        return intent;
    }

    protected void g() {
        if (this.f10359d.getBarcodeView().s()) {
            j();
        } else {
            this.f10366k = true;
        }
        this.f10359d.e();
        this.f10363h.d();
    }

    public void h() {
        this.f10359d.b(this.f10367l);
    }

    protected void i() {
        if (this.f10358c.isFinishing() || this.f10362g || this.f10366k) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f10358c);
        builder.setTitle(this.f10358c.getString(com.google.zxing.p.a.j.zxing_app_name));
        builder.setMessage(this.f10358c.getString(com.google.zxing.p.a.j.zxing_msg_camera_framework_bug));
        builder.setPositiveButton(com.google.zxing.p.a.j.zxing_button_ok, new e());
        builder.setOnCancelListener(new f());
        builder.show();
    }

    public void l(Intent intent, Bundle bundle) {
        this.f10358c.getWindow().addFlags(128);
        if (bundle != null) {
            this.f10360e = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
        }
        if (intent != null) {
            if (intent.getBooleanExtra("SCAN_ORIENTATION_LOCKED", true)) {
                m();
            }
            if ("com.google.zxing.client.android.SCAN".equals(intent.getAction())) {
                this.f10359d.d(intent);
            }
            if (!intent.getBooleanExtra("BEEP_ENABLED", true)) {
                this.f10364i.d(false);
            }
            if (intent.hasExtra(Payload.RESPONSE_TIMEOUT)) {
                this.f10365j.postDelayed(new RunnableC0217d(), intent.getLongExtra(Payload.RESPONSE_TIMEOUT, 0L));
            }
            if (intent.getBooleanExtra("BARCODE_IMAGE_ENABLED", false)) {
                this.f10361f = true;
            }
        }
    }

    protected void m() {
        if (this.f10360e == -1) {
            int rotation = this.f10358c.getWindowManager().getDefaultDisplay().getRotation();
            int i2 = this.f10358c.getResources().getConfiguration().orientation;
            int i3 = 0;
            if (i2 == 2) {
                if (rotation != 0 && rotation != 1) {
                    i3 = 8;
                }
            } else if (i2 == 1) {
                i3 = (rotation == 0 || rotation == 3) ? 1 : 9;
            }
            this.f10360e = i3;
        }
        this.f10358c.setRequestedOrientation(this.f10360e);
    }

    public void n() {
        this.f10362g = true;
        this.f10363h.d();
        this.f10365j.removeCallbacksAndMessages(null);
    }

    public void o() {
        this.f10363h.d();
        this.f10359d.f();
    }

    public void p(int i2, String[] strArr, int[] iArr) {
        if (i2 == f10357b) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.f10359d.g();
            } else {
                i();
            }
        }
    }

    public void q() {
        if (Build.VERSION.SDK_INT >= 23) {
            s();
        } else {
            this.f10359d.g();
        }
        this.f10363h.h();
    }

    public void r(Bundle bundle) {
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.f10360e);
    }

    protected void u(com.journeyapps.barcodescanner.b bVar) {
        this.f10358c.setResult(-1, t(bVar, k(bVar)));
        g();
    }

    protected void v() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra(Payload.RESPONSE_TIMEOUT, true);
        this.f10358c.setResult(0, intent);
        g();
    }
}