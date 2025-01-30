package com.facebook.react.modules.fresco;

import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: ReactNetworkImageRequest.java */
/* loaded from: classes2.dex */
public class a extends com.facebook.imagepipeline.request.b {
    private final ReadableMap s;

    protected a(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap) {
        super(imageRequestBuilder);
        this.s = readableMap;
    }

    public static a w(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap) {
        return new a(imageRequestBuilder, readableMap);
    }

    public ReadableMap x() {
        return this.s;
    }
}