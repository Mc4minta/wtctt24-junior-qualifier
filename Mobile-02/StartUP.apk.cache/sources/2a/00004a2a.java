package e.j.l;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.application.BaseApplication;
import com.google.zxing.WriterException;
import com.toshi.network.image.CachedGlideUrl;
import com.toshi.network.image.ForceLoadGlideUrl;
import h.c.a0;
import h.c.b0;
import java.util.HashMap;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: ImageUtil.kt */
/* loaded from: classes2.dex */
public final class h {
    public static final h a = new h();

    /* renamed from: b */
    private static final a0 f13705b = h.c.j0.c.a.b();

    /* renamed from: c */
    private static final a0 f13706c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageUtil.kt */
    /* loaded from: classes2.dex */
    public static final class a extends o implements kotlin.e0.c.l<Bitmap, x> {
        final /* synthetic */ ImageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ImageView imageView) {
            super(1);
            this.a = imageView;
        }

        public final void a(Bitmap bitmap) {
            this.a.setImageBitmap(bitmap);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Bitmap bitmap) {
            a(bitmap);
            return x.a;
        }
    }

    static {
        a0 c2 = h.c.u0.a.c();
        m.f(c2, "io()");
        f13706c = c2;
    }

    private h() {
    }

    public static final Bitmap b(String value) {
        m.g(value, "$value");
        try {
            return a.c(value);
        } catch (WriterException e2) {
            throw new com.toshi.exception.a(e2);
        }
    }

    private final Bitmap c(String str) throws WriterException {
        com.google.zxing.v.b bVar = new com.google.zxing.v.b();
        int dimensionPixelSize = BaseApplication.Companion.getInstance().getResources().getDimensionPixelSize(R.dimen.qr_code_size);
        HashMap hashMap = new HashMap();
        hashMap.put(com.google.zxing.e.MARGIN, 0);
        com.google.zxing.q.b a2 = bVar.a(str, com.google.zxing.a.QR_CODE, dimensionPixelSize, dimensionPixelSize, hashMap);
        int n = a2.n();
        int i2 = a2.i();
        Bitmap bmp = Bitmap.createBitmap(n, i2, Bitmap.Config.RGB_565);
        if (n > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i2 > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        bmp.setPixel(i3, i5, a2.e(i3, i5) ? -16777216 : -1);
                        if (i6 >= i2) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                if (i4 >= n) {
                    break;
                }
                i3 = i4;
            }
        }
        m.f(bmp, "bmp");
        return bmp;
    }

    public static /* synthetic */ Bitmap d(String str) {
        return m(str);
    }

    public static /* synthetic */ Target e(String str, ImageView imageView) {
        return i(str, imageView);
    }

    public static /* synthetic */ void f(String str, ImageView imageView, h.c.k0.b bVar) {
        j(str, imageView, bVar);
    }

    public static /* synthetic */ Bitmap g(String str) {
        return b(str);
    }

    public static final Target i(String str, ImageView imageView) {
        return a.k(str, imageView);
    }

    public static final void j(String str, ImageView imageView, h.c.k0.b bVar) {
        a.o(str, imageView);
    }

    public static final Bitmap m(String str) {
        return e.j.l.r.c.a(str);
    }

    private final void o(String str, ImageView imageView) {
        try {
            Glide.with(imageView.getContext()).load((Object) new CachedGlideUrl(str)).into(imageView);
        } catch (IllegalArgumentException e2) {
            l.a.a.c(e2, "Tried to render into a now destroyed view.", new Object[0]);
        }
    }

    public final b0<Bitmap> a(final String value) {
        m.g(value, "value");
        b0<Bitmap> subscribeOn = b0.fromCallable(new Callable() { // from class: e.j.l.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return h.g(value);
            }
        }).subscribeOn(f13706c);
        m.f(subscribeOn, "fromCallable {\n            try {\n                generateQrCodeBitmap(value)\n            } catch (e: WriterException) {\n                throw QrCodeException(e)\n            }\n        }\n        .subscribeOn(concurrentScheduler)");
        return subscribeOn;
    }

    public final h.c.k0.b h(final String str, final ImageView imageView) {
        if (str != null) {
            if (!(str.length() == 0) && imageView != null) {
                b0 doOnSubscribe = b0.fromCallable(new Callable() { // from class: e.j.l.b
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return h.e(str, imageView);
                    }
                }).doOnSubscribe(new h.c.m0.f() { // from class: e.j.l.c
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        h.f(str, imageView, (h.c.k0.b) obj);
                    }
                });
                m.f(doOnSubscribe, "fromCallable { loadFromNetwork(url, imageView) }\n            .doOnSubscribe { renderFromCache(url, imageView) }");
                return Single_AnalyticsKt.logError$default(doOnSubscribe, null, null, 3, null).subscribe();
            }
        }
        return null;
    }

    public final Target<?> k(String str, ImageView imageView) {
        m.g(imageView, "imageView");
        if (str != null) {
            if (str.length() == 0) {
                return null;
            }
            try {
                return Glide.with(imageView.getContext()).load((Object) new ForceLoadGlideUrl(str)).into(imageView);
            } catch (IllegalArgumentException e2) {
                l.a.a.c(e2, "Tried to render into a now destroyed view.", new Object[0]);
                return null;
            }
        }
        return null;
    }

    public final h.c.k0.b l(final String str, ImageView imageView) {
        if (str == null || imageView == null) {
            return null;
        }
        b0 observeOn = b0.fromCallable(new Callable() { // from class: e.j.l.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return h.d(str);
            }
        }).subscribeOn(f13706c).observeOn(f13705b);
        m.f(observeOn, "fromCallable { createIdenticon(value) }\n            .subscribeOn(concurrentScheduler)\n            .observeOn(mainScheduler)");
        return h.c.t0.g.i(Single_AnalyticsKt.logError$default(observeOn, null, null, 3, null), null, new a(imageView), 1, null);
    }

    public final void n(ImageView imageView, String str) {
        m.g(imageView, "imageView");
        if (str == null || str.length() == 0) {
            imageView.setImageResource(R.drawable.placeholder);
        } else {
            h(str, imageView);
        }
    }
}