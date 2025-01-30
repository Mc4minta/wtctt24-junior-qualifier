package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;

@com.facebook.soloader.d
/* loaded from: classes2.dex */
class PreverificationHelper {
    /* JADX INFO: Access modifiers changed from: package-private */
    @com.facebook.soloader.d
    @TargetApi(26)
    public boolean shouldUseHardwareBitmapConfig(Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }
}