package com.toshi.network.image;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import org.apache.http.HttpHeaders;

/* loaded from: classes2.dex */
public class CachedGlideUrl extends GlideUrl {
    private static final Headers CACHE_HEADERS_OFFLINE = new LazyHeaders.Builder().addHeader(HttpHeaders.CACHE_CONTROL, String.format("max-age=%s, max-stale=%s", 1209600000, 1209600000)).build();

    public CachedGlideUrl(String str) {
        super(str, CACHE_HEADERS_OFFLINE);
    }
}