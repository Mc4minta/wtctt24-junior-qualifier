package e.a.a.v;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import e.a.a.h;
import e.a.a.z.d;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: ImageAssetManager.java */
/* loaded from: classes.dex */
public class b {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Context f11735b;

    /* renamed from: c  reason: collision with root package name */
    private String f11736c;

    /* renamed from: d  reason: collision with root package name */
    private e.a.a.b f11737d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, h> f11738e;

    public b(Drawable.Callback callback, String str, e.a.a.b bVar, Map<String, h> map) {
        String str2;
        this.f11736c = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f11736c.charAt(str2.length() - 1) != '/') {
                this.f11736c += '/';
            }
        }
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.f11738e = new HashMap();
            this.f11735b = null;
            return;
        }
        this.f11735b = ((View) callback).getContext();
        this.f11738e = map;
        d(bVar);
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (a) {
            this.f11738e.get(str).f(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        h hVar = this.f11738e.get(str);
        if (hVar == null) {
            return null;
        }
        Bitmap a2 = hVar.a();
        if (a2 != null) {
            return a2;
        }
        e.a.a.b bVar = this.f11737d;
        if (bVar != null) {
            Bitmap a3 = bVar.a(hVar);
            if (a3 != null) {
                c(str, a3);
            }
            return a3;
        }
        String b2 = hVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256;
        if (b2.startsWith("data:") && b2.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(b2.substring(b2.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e2) {
                d.d("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.f11736c)) {
                AssetManager assets = this.f11735b.getAssets();
                return c(str, e.a.a.z.h.l(BitmapFactory.decodeStream(assets.open(this.f11736c + b2), null, options), hVar.e(), hVar.c()));
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e3) {
            d.d("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f11735b == null) || this.f11735b.equals(context);
    }

    public void d(e.a.a.b bVar) {
        this.f11737d = bVar;
    }
}