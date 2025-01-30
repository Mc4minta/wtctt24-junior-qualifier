package com.toshi.network.image;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: SvgDecoder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "<anonymous>", "()Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class SvgDecoder$bitmapPool$2 extends o implements a<BitmapPool> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SvgDecoder$bitmapPool$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final BitmapPool invoke() {
        BitmapPool bitmapPool = Glide.get(this.$context).getBitmapPool();
        m.f(bitmapPool, "get(context).bitmapPool");
        return bitmapPool;
    }
}