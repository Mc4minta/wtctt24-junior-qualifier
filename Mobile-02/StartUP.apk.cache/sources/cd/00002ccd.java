package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;

/* compiled from: ArtDecoder.java */
@TargetApi(21)
/* loaded from: classes2.dex */
public class a extends b {
    public a(com.facebook.imagepipeline.memory.c cVar, int i2, androidx.core.util.g gVar) {
        super(cVar, i2, gVar);
    }

    @Override // com.facebook.imagepipeline.platform.b
    public int e(int i2, int i3, BitmapFactory.Options options) {
        return com.facebook.imageutils.a.d(i2, i3, options.inPreferredConfig);
    }
}