package com.toshi.network.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.caverock.androidsvg.SVG;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SvgModule.kt */
@GlideModule
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/toshi/network/image/SvgModule;", "Lcom/bumptech/glide/module/AppGlideModule;", "Landroid/content/Context;", "context", "Lcom/bumptech/glide/Glide;", "glide", "Lcom/bumptech/glide/Registry;", "registry", "Lkotlin/x;", "registerComponents", "(Landroid/content/Context;Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/Registry;)V", "", "isManifestParsingEnabled", "()Z", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SvgModule extends AppGlideModule {
    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() {
        return false;
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(Context context, Glide glide, Registry registry) {
        m.g(context, "context");
        m.g(glide, "glide");
        m.g(registry, "registry");
        registry.register(SVG.class, Bitmap.class, new SvgDrawableTranscoder()).append(InputStream.class, Bitmap.class, new SvgDecoder(context));
    }
}