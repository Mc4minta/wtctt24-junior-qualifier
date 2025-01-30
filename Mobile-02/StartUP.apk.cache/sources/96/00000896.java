package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
interface LruPoolStrategy {
    Bitmap get(int i2, int i3, Bitmap.Config config);

    int getSize(Bitmap bitmap);

    String logBitmap(int i2, int i3, Bitmap.Config config);

    String logBitmap(Bitmap bitmap);

    void put(Bitmap bitmap);

    Bitmap removeLast();
}