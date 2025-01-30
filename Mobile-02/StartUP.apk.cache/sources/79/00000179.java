package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Build;
import androidx.biometric.BiometricPrompt;
import java.util.concurrent.Executor;

/* compiled from: DeviceCredentialHandlerBridge.java */
/* loaded from: classes.dex */
public class c {
    private static c a;

    /* renamed from: b  reason: collision with root package name */
    private int f980b;

    /* renamed from: c  reason: collision with root package name */
    private a f981c;

    /* renamed from: d  reason: collision with root package name */
    private d f982d;

    /* renamed from: e  reason: collision with root package name */
    private e f983e;

    /* renamed from: f  reason: collision with root package name */
    private Executor f984f;

    /* renamed from: g  reason: collision with root package name */
    private DialogInterface.OnClickListener f985g;

    /* renamed from: h  reason: collision with root package name */
    private BiometricPrompt.b f986h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f987i;

    /* renamed from: j  reason: collision with root package name */
    private int f988j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f989k = 0;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c e() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c f() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiometricPrompt.b a() {
        return this.f986h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f980b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f988j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executor d() {
        return this.f984f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.f989k == 0) {
            this.f989k = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f987i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        int i2 = this.f989k;
        if (i2 == 2) {
            return;
        }
        if (i2 == 1) {
            q();
            return;
        }
        this.f980b = 0;
        this.f981c = null;
        this.f982d = null;
        this.f983e = null;
        this.f984f = null;
        this.f985g = null;
        this.f986h = null;
        this.f988j = 0;
        this.f987i = false;
        a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a aVar) {
        this.f981c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"LambdaLast"})
    public void k(Executor executor, DialogInterface.OnClickListener onClickListener, BiometricPrompt.b bVar) {
        this.f984f = executor;
        this.f985g = onClickListener;
        this.f986h = bVar;
        a aVar = this.f981c;
        if (aVar != null && Build.VERSION.SDK_INT >= 28) {
            aVar.o(executor, onClickListener, bVar);
            return;
        }
        d dVar = this.f982d;
        if (dVar == null || this.f983e == null) {
            return;
        }
        dVar.z(onClickListener);
        this.f983e.p(executor, bVar);
        this.f983e.r(this.f982d.o());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(int i2) {
        this.f980b = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z) {
        this.f987i = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i2) {
        this.f988j = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(d dVar, e eVar) {
        this.f982d = dVar;
        this.f983e = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        this.f989k = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f989k = 0;
    }
}