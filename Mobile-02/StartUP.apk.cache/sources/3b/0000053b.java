package c.h.e;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.d.c;
import c.h.i.f;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpStatus;

/* compiled from: TypefaceCompatApi29Impl.java */
/* loaded from: classes.dex */
public class i extends j {
    @Override // c.h.e.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i2) {
        try {
            c.C0027c[] a = bVar.a();
            int length = a.length;
            FontFamily.Builder builder = null;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    break;
                }
                c.C0027c c0027c = a[i3];
                try {
                    Font.Builder weight = new Font.Builder(resources, c0027c.b()).setWeight(c0027c.e());
                    if (!c0027c.f()) {
                        i4 = 0;
                    }
                    Font build = weight.setSlant(i4).setTtcIndex(c0027c.c()).setFontVariationSettings(c0027c.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
                i3++;
            }
            if (builder == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : HttpStatus.SC_BAD_REQUEST, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // c.h.e.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = bVarArr.length;
            FontFamily.Builder builder = null;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    if (builder == null) {
                        return null;
                    }
                    return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : HttpStatus.SC_BAD_REQUEST, (i2 & 2) != 0 ? 1 : 0)).build();
                }
                f.b bVar = bVarArr[i3];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(bVar.d(), "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (openFileDescriptor != null) {
                    try {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(bVar.e());
                        if (!bVar.f()) {
                            i4 = 0;
                        }
                        Font build = weight.setSlant(i4).setTtcIndex(bVar.c()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                        break;
                    }
                } else if (openFileDescriptor == null) {
                    i3++;
                }
                openFileDescriptor.close();
                i3++;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.h.e.j
    public Typeface d(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // c.h.e.j
    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        try {
            Font build = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.h.e.j
    public f.b h(f.b[] bVarArr, int i2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}