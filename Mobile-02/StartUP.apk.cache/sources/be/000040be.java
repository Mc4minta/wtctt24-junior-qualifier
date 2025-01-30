package com.toshi.network.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.appsflyer.internal.referrer.Payload;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: SvgDecoder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/toshi/network/image/SvgDecoder;", "Lcom/bumptech/glide/load/ResourceDecoder;", "Ljava/io/InputStream;", "Landroid/graphics/Bitmap;", "", "width", "height", "findBitmap", "(II)Landroid/graphics/Bitmap;", Payload.SOURCE, "Lcom/bumptech/glide/load/Options;", "options", "Lcom/bumptech/glide/load/engine/Resource;", "decode", "(Ljava/io/InputStream;IILcom/bumptech/glide/load/Options;)Lcom/bumptech/glide/load/engine/Resource;", "", "handles", "(Ljava/io/InputStream;Lcom/bumptech/glide/load/Options;)Z", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "bitmapPool$delegate", "Lkotlin/h;", "getBitmapPool", "()Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "bitmapPool", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SvgDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final h bitmapPool$delegate;

    public SvgDecoder(Context context) {
        h b2;
        m.g(context, "context");
        b2 = k.b(new SvgDecoder$bitmapPool$2(context));
        this.bitmapPool$delegate = b2;
    }

    private final Bitmap findBitmap(int i2, int i3) {
        Bitmap bitmap = getBitmapPool().get(i2, i3, Bitmap.Config.ARGB_8888);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
        Objects.requireNonNull(bitmap);
        return bitmap;
    }

    private final BitmapPool getBitmapPool() {
        return (BitmapPool) this.bitmapPool$delegate.getValue();
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(InputStream source, Options options) {
        m.g(source, "source");
        m.g(options, "options");
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(InputStream source, int i2, int i3, Options options) {
        m.g(source, "source");
        m.g(options, "options");
        try {
            SVG fromInputStream = SVG.getFromInputStream(source);
            if (i2 == Integer.MIN_VALUE && i3 == Integer.MIN_VALUE) {
                i2 = (int) fromInputStream.getDocumentWidth();
                i3 = (int) fromInputStream.getDocumentHeight();
                if (i2 <= 0 || i3 <= 0) {
                    RectF documentViewBox = fromInputStream.getDocumentViewBox();
                    int width = (int) documentViewBox.width();
                    i3 = (int) documentViewBox.height();
                    i2 = width;
                }
            } else {
                if (i2 == Integer.MIN_VALUE) {
                    i2 = (int) (i3 * fromInputStream.getDocumentAspectRatio());
                }
                if (i3 == Integer.MIN_VALUE) {
                    i3 = (int) (i2 / fromInputStream.getDocumentAspectRatio());
                }
            }
            if (i2 > 0 && i3 > 0) {
                Bitmap findBitmap = findBitmap(i2, i3);
                fromInputStream.renderToCanvas(new Canvas(findBitmap));
                return BitmapResource.obtain(findBitmap, getBitmapPool());
            }
            throw new IllegalArgumentException("Either the Target or the SVG document must declare a size.");
        } catch (SVGParseException e2) {
            throw new IOException("Cannot load SVG from stream", e2);
        }
    }
}