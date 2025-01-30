package e.f.d.h;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
import org.spongycastle.math.ec.Tnaf;

/* compiled from: WebpSupportStatus.java */
/* loaded from: classes2.dex */
public class c {
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f12091b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f12092c;

    /* renamed from: d  reason: collision with root package name */
    public static b f12093d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f12094e;

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f12095f;

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f12096g;

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f12097h;

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f12098i;

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f12099j;

    static {
        int i2 = Build.VERSION.SDK_INT;
        a = i2 <= 17;
        f12091b = i2 >= 14;
        f12092c = e();
        f12093d = null;
        f12094e = false;
        f12095f = a("RIFF");
        f12096g = a("WEBP");
        f12097h = a("VP8 ");
        f12098i = a("VP8L");
        f12099j = a("VP8X");
    }

    private static byte[] a(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static boolean b(byte[] bArr, int i2) {
        return j(bArr, i2 + 12, f12099j) && ((bArr[i2 + 20] & 2) == 2);
    }

    public static boolean c(byte[] bArr, int i2, int i3) {
        return i3 >= 21 && j(bArr, i2 + 12, f12099j);
    }

    public static boolean d(byte[] bArr, int i2) {
        return j(bArr, i2 + 12, f12099j) && ((bArr[i2 + 20] & Tnaf.POW_2_WIDTH) == 16);
    }

    private static boolean e() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 17) {
            return false;
        }
        if (i2 == 17) {
            byte[] decode = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            if (options.outHeight != 1 || options.outWidth != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(byte[] bArr, int i2) {
        return j(bArr, i2 + 12, f12098i);
    }

    public static boolean g(byte[] bArr, int i2) {
        return j(bArr, i2 + 12, f12097h);
    }

    public static boolean h(byte[] bArr, int i2, int i3) {
        return i3 >= 20 && j(bArr, i2, f12095f) && j(bArr, i2 + 8, f12096g);
    }

    public static b i() {
        if (f12094e) {
            return f12093d;
        }
        b bVar = null;
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable unused) {
        }
        f12094e = true;
        return bVar;
    }

    private static boolean j(byte[] bArr, int i2, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i2 > bArr.length) {
            return false;
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (bArr[i3 + i2] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }
}