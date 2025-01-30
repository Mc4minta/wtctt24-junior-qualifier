package com.rumax.reactnative.pdfviewer;

import android.util.AttributeSet;
import android.util.Base64;
import com.coinbase.ApiConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.i0;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.rumax.reactnative.pdfviewer.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: PDFView.java */
/* loaded from: classes2.dex */
public class c extends PDFView implements OnErrorListener, OnPageChangeListener, OnPageScrollListener, OnLoadCompleteListener {
    private i0 a;

    /* renamed from: b  reason: collision with root package name */
    private String f10844b;

    /* renamed from: c  reason: collision with root package name */
    private File f10845c;

    /* renamed from: d  reason: collision with root package name */
    private com.rumax.reactnative.pdfviewer.a f10846d;

    /* renamed from: e  reason: collision with root package name */
    private String f10847e;

    /* renamed from: f  reason: collision with root package name */
    private PDFView.Configurator f10848f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10849g;

    /* renamed from: h  reason: collision with root package name */
    private ReadableMap f10850h;

    /* renamed from: i  reason: collision with root package name */
    private int f10851i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10852j;

    /* renamed from: k  reason: collision with root package name */
    private float f10853k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PDFView.java */
    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0232a {
        a() {
        }

        @Override // com.rumax.reactnative.pdfviewer.a.InterfaceC0232a
        public void a(Exception exc) {
            if (exc == null) {
                c cVar = c.this;
                cVar.n(cVar.f10845c.getAbsolutePath());
                return;
            }
            c.this.d();
            c.this.h(exc);
        }
    }

    public c(i0 i0Var) {
        super(i0Var, (AttributeSet) null);
        this.f10846d = null;
        this.f10847e = null;
        this.f10848f = null;
        this.f10849g = true;
        this.f10851i = 0;
        this.f10852j = false;
        this.f10853k = 0.0f;
        this.a = i0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        File file = this.f10845c;
        if (file != null) {
            if (!file.delete()) {
                h(new IOException(b.E_DELETE_FILE.h()));
            }
            this.f10845c = null;
        }
    }

    private void e() {
        com.rumax.reactnative.pdfviewer.a aVar = this.f10846d;
        if (aVar != null) {
            aVar.cancel(true);
        }
        d();
    }

    private static boolean f(String str, String str2) {
        if (str == null || str2 == null) {
            return true;
        }
        return !str.equals(str2);
    }

    private void i(String str, WritableMap writableMap) {
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), str, writableMap);
    }

    private void j(String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(ApiConstants.MESSAGE, str2);
        i(str, createMap);
    }

    private void m() {
        try {
            this.f10848f = fromBytes(Base64.decode(this.f10844b, 0));
            u();
        } catch (IllegalArgumentException unused) {
            h(new IOException(b.E_INVALID_BASE64.h()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        InputStream open;
        try {
            if (str.startsWith("/")) {
                open = new FileInputStream(new File(str));
            } else {
                open = this.a.getAssets().open(str, 3);
            }
            this.f10848f = fromStream(open);
            u();
        } catch (IOException e2) {
            h(e2);
        }
    }

    private void o() {
        try {
            this.f10845c = File.createTempFile("pdfDocument", "pdf", this.a.getCacheDir());
            com.rumax.reactnative.pdfviewer.a aVar = new com.rumax.reactnative.pdfviewer.a(this.a, this.f10844b, this.f10845c, this.f10850h, new a());
            this.f10846d = aVar;
            aVar.execute(new Void[0]);
        } catch (IOException e2) {
            h(e2);
        }
    }

    private void u() {
        this.f10853k = 0.0f;
        setAlpha(0.0f);
        this.f10848f.defaultPage(0).swipeHorizontal(false).onLoad(this).onError(this).onPageChange(this).onPageScroll(this).spacing(10).enableAnnotationRendering(this.f10852j).load();
        this.f10849g = false;
    }

    public void g() {
        e();
        this.f10849g = true;
    }

    public void h(Throwable th) {
        j("onError", "error: " + th.getMessage());
    }

    public void k() {
        this.f10849g = true;
        l();
    }

    public void l() {
        e();
        if (this.f10844b == null) {
            h(new IOException(b.E_NO_RESOURCE.h()));
            return;
        }
        String str = this.f10847e;
        if (str == null) {
            h(new IOException(b.E_NO_RESOURCE_TYPE.h()));
        } else if (this.f10849g) {
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1396204209:
                    if (str.equals("base64")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 116079:
                    if (str.equals("url")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3143036:
                    if (str.equals("file")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    m();
                    return;
                case 1:
                    o();
                    return;
                case 2:
                    n(this.f10844b);
                    return;
                default:
                    h(new IOException(b.E_INVALID_RESOURCE_TYPE.h() + this.f10847e));
                    return;
            }
        }
    }

    public void p(boolean z) {
        this.f10852j = z;
    }

    public void q(int i2) {
        this.f10851i = i2;
    }

    public void r(String str) {
        if (f(str, this.f10844b)) {
            this.f10849g = true;
        }
        this.f10844b = str;
    }

    public void s(String str) {
        if (f(str, this.f10847e)) {
            this.f10849g = true;
        }
        this.f10847e = str;
    }

    public void t(ReadableMap readableMap) {
        this.f10850h = readableMap;
    }
}