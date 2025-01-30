package com.coinbase.wallet.commonui.extensions;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.coinbase.wallet.commonui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ImageView+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/widget/ImageView;", "", "url", "", "placeholder", "Lcom/bumptech/glide/load/engine/DiskCacheStrategy;", "cacheStrategy", "Lkotlin/x;", "load", "(Landroid/widget/ImageView;Ljava/lang/String;ILcom/bumptech/glide/load/engine/DiskCacheStrategy;)V", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ImageView_CommonKt {
    public static final void load(ImageView imageView, String str, int i2, DiskCacheStrategy cacheStrategy) {
        m.g(imageView, "<this>");
        m.g(cacheStrategy, "cacheStrategy");
        Glide.with(imageView.getContext()).load(str).apply((BaseRequestOptions<?>) new RequestOptions().diskCacheStrategy(cacheStrategy)).apply((BaseRequestOptions<?>) new RequestOptions().error(i2)).into(imageView);
    }

    public static /* synthetic */ void load$default(ImageView imageView, String str, int i2, DiskCacheStrategy AUTOMATIC, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = R.drawable.placeholder;
        }
        if ((i3 & 4) != 0) {
            AUTOMATIC = DiskCacheStrategy.AUTOMATIC;
            m.f(AUTOMATIC, "AUTOMATIC");
        }
        load(imageView, str, i2, AUTOMATIC);
    }
}