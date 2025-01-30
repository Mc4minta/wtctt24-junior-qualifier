package com.toshi.network.image;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.apache.http.HttpHeaders;

/* compiled from: ForceLoadGlideUrl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/toshi/network/image/ForceLoadGlideUrl;", "Lcom/bumptech/glide/load/model/GlideUrl;", "", "url", "<init>", "(Ljava/lang/String;)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ForceLoadGlideUrl extends GlideUrl {
    public static final Companion Companion = new Companion(null);
    private static final LazyHeaders FORCE_ETAG_CHECK = new LazyHeaders.Builder().addHeader(HttpHeaders.CACHE_CONTROL, "max-age=0").build();

    /* compiled from: ForceLoadGlideUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/toshi/network/image/ForceLoadGlideUrl$Companion;", "", "Lcom/bumptech/glide/load/model/LazyHeaders;", "kotlin.jvm.PlatformType", "FORCE_ETAG_CHECK", "Lcom/bumptech/glide/load/model/LazyHeaders;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForceLoadGlideUrl(String url) {
        super(url, FORCE_ETAG_CHECK);
        m.g(url, "url");
    }
}