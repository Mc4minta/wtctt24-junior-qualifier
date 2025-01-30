package com.toshi.network.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.PictureDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.caverock.androidsvg.SVG;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SvgDrawableTranscoder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/toshi/network/image/SvgDrawableTranscoder;", "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;", "Lcom/caverock/androidsvg/SVG;", "Landroid/graphics/Bitmap;", "Lcom/bumptech/glide/load/engine/Resource;", "toTranscode", "Lcom/bumptech/glide/load/Options;", "options", "transcode", "(Lcom/bumptech/glide/load/engine/Resource;Lcom/bumptech/glide/load/Options;)Lcom/bumptech/glide/load/engine/Resource;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SvgDrawableTranscoder implements ResourceTranscoder<SVG, Bitmap> {
    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<Bitmap> transcode(Resource<SVG> toTranscode, Options options) {
        m.g(toTranscode, "toTranscode");
        m.g(options, "options");
        SVG svg = toTranscode.get();
        m.f(svg, "toTranscode.get()");
        PictureDrawable pictureDrawable = new PictureDrawable(svg.renderToPicture());
        Bitmap createBitmap = Bitmap.createBitmap(pictureDrawable.getIntrinsicWidth(), pictureDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawPicture(pictureDrawable.getPicture());
        return new SimpleResource(createBitmap);
    }
}