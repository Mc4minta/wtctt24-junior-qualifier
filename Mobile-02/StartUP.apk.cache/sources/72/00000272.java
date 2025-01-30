package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    public int f1509b;

    /* renamed from: c  reason: collision with root package name */
    Object f1510c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f1511d;

    /* renamed from: e  reason: collision with root package name */
    public Parcelable f1512e;

    /* renamed from: f  reason: collision with root package name */
    public int f1513f;

    /* renamed from: g  reason: collision with root package name */
    public int f1514g;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f1515h;

    /* renamed from: i  reason: collision with root package name */
    PorterDuff.Mode f1516i;

    /* renamed from: j  reason: collision with root package name */
    public String f1517j;

    /* renamed from: k  reason: collision with root package name */
    public String f1518k;

    public IconCompat() {
        this.f1509b = -1;
        this.f1511d = null;
        this.f1512e = null;
        this.f1513f = 0;
        this.f1514g = 0;
        this.f1515h = null;
        this.f1516i = a;
        this.f1517j = null;
    }

    static Bitmap a(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = min;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat b(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(1);
            iconCompat.f1510c = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    public static IconCompat c(Resources resources, String str, int i2) {
        if (str != null) {
            if (i2 != 0) {
                IconCompat iconCompat = new IconCompat(2);
                iconCompat.f1513f = i2;
                if (resources != null) {
                    try {
                        iconCompat.f1510c = resources.getResourceName(i2);
                    } catch (Resources.NotFoundException unused) {
                        throw new IllegalArgumentException("Icon resource cannot be found");
                    }
                } else {
                    iconCompat.f1510c = str;
                }
                iconCompat.f1518k = str;
                return iconCompat;
            }
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        throw new IllegalArgumentException("Package must not be null.");
    }

    private static int f(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }

    private static String h(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    private static int j(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e2);
            return -1;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e3);
            return -1;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e4);
            return -1;
        }
    }

    private static Uri l(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon uri", e4);
            return null;
        }
    }

    private static String r(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap d() {
        int i2 = this.f1509b;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f1510c;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        } else if (i2 == 1) {
            return (Bitmap) this.f1510c;
        } else {
            if (i2 == 5) {
                return a((Bitmap) this.f1510c, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
    }

    public int e() {
        int i2 = this.f1509b;
        if (i2 != -1 || Build.VERSION.SDK_INT < 23) {
            if (i2 == 2) {
                return this.f1513f;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        return f((Icon) this.f1510c);
    }

    public String g() {
        int i2 = this.f1509b;
        if (i2 != -1 || Build.VERSION.SDK_INT < 23) {
            if (i2 == 2) {
                if (TextUtils.isEmpty(this.f1518k)) {
                    return ((String) this.f1510c).split(":", -1)[0];
                }
                return this.f1518k;
            }
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        return h((Icon) this.f1510c);
    }

    public int i() {
        int i2 = this.f1509b;
        return (i2 != -1 || Build.VERSION.SDK_INT < 23) ? i2 : j((Icon) this.f1510c);
    }

    public Uri k() {
        int i2 = this.f1509b;
        if (i2 != -1 || Build.VERSION.SDK_INT < 23) {
            if (i2 != 4 && i2 != 6) {
                throw new IllegalStateException("called getUri() on " + this);
            }
            return Uri.parse((String) this.f1510c);
        }
        return l((Icon) this.f1510c);
    }

    public InputStream m(Context context) {
        Uri k2 = k();
        String scheme = k2.getScheme();
        if (!"content".equals(scheme) && !"file".equals(scheme)) {
            try {
                return new FileInputStream(new File((String) this.f1510c));
            } catch (FileNotFoundException e2) {
                Log.w("IconCompat", "Unable to load image from path: " + k2, e2);
                return null;
            }
        }
        try {
            return context.getContentResolver().openInputStream(k2);
        } catch (Exception e3) {
            Log.w("IconCompat", "Unable to load image from URI: " + k2, e3);
            return null;
        }
    }

    public void n() {
        this.f1516i = PorterDuff.Mode.valueOf(this.f1517j);
        switch (this.f1509b) {
            case -1:
                Parcelable parcelable = this.f1512e;
                if (parcelable != null) {
                    this.f1510c = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f1512e;
                if (parcelable2 != null) {
                    this.f1510c = parcelable2;
                    return;
                }
                byte[] bArr = this.f1511d;
                this.f1510c = bArr;
                this.f1509b = 3;
                this.f1513f = 0;
                this.f1514g = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f1511d, Charset.forName(HTTP.UTF_16));
                this.f1510c = str;
                if (this.f1509b == 2 && this.f1518k == null) {
                    this.f1518k = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f1510c = this.f1511d;
                return;
        }
    }

    public void o(boolean z) {
        this.f1517j = this.f1516i.name();
        switch (this.f1509b) {
            case -1:
                if (!z) {
                    this.f1512e = (Parcelable) this.f1510c;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f1510c).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f1511d = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f1512e = (Parcelable) this.f1510c;
                return;
            case 2:
                this.f1511d = ((String) this.f1510c).getBytes(Charset.forName(HTTP.UTF_16));
                return;
            case 3:
                this.f1511d = (byte[]) this.f1510c;
                return;
            case 4:
            case 6:
                this.f1511d = this.f1510c.toString().getBytes(Charset.forName(HTTP.UTF_16));
                return;
        }
    }

    @Deprecated
    public Icon p() {
        return q(null);
    }

    public Icon q(Context context) {
        Icon createWithBitmap;
        switch (this.f1509b) {
            case -1:
                return (Icon) this.f1510c;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) this.f1510c);
                break;
            case 2:
                createWithBitmap = Icon.createWithResource(g(), this.f1513f);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) this.f1510c, this.f1513f, this.f1514g);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) this.f1510c);
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 26) {
                    createWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.f1510c);
                    break;
                } else {
                    createWithBitmap = Icon.createWithBitmap(a((Bitmap) this.f1510c, false));
                    break;
                }
            case 6:
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 30) {
                    createWithBitmap = Icon.createWithAdaptiveBitmapContentUri(k());
                    break;
                } else if (context != null) {
                    InputStream m = m(context);
                    if (m == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + k());
                    } else if (i2 >= 26) {
                        createWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(m));
                        break;
                    } else {
                        createWithBitmap = Icon.createWithBitmap(a(BitmapFactory.decodeStream(m), false));
                        break;
                    }
                } else {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + k());
                }
        }
        ColorStateList colorStateList = this.f1515h;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f1516i;
        if (mode != a) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }

    public String toString() {
        if (this.f1509b == -1) {
            return String.valueOf(this.f1510c);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(r(this.f1509b));
        switch (this.f1509b) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1510c).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f1510c).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f1518k);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(e())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f1513f);
                if (this.f1514g != 0) {
                    sb.append(" off=");
                    sb.append(this.f1514g);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1510c);
                break;
        }
        if (this.f1515h != null) {
            sb.append(" tint=");
            sb.append(this.f1515h);
        }
        if (this.f1516i != a) {
            sb.append(" mode=");
            sb.append(this.f1516i);
        }
        sb.append(")");
        return sb.toString();
    }

    private IconCompat(int i2) {
        this.f1509b = -1;
        this.f1511d = null;
        this.f1512e = null;
        this.f1513f = 0;
        this.f1514g = 0;
        this.f1515h = null;
        this.f1516i = a;
        this.f1517j = null;
        this.f1509b = i2;
    }
}