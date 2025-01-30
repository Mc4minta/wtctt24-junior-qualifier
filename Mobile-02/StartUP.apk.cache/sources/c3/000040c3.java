package com.toshi.qr.view.custom;

import android.graphics.Bitmap;
import kotlin.jvm.internal.o;

/* compiled from: QROverlay.kt */
/* loaded from: classes2.dex */
final class a extends o implements kotlin.e0.c.a<Bitmap> {
    final /* synthetic */ QROverlay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(QROverlay qROverlay) {
        super(0);
        this.a = qROverlay;
    }

    @Override // kotlin.e0.c.a
    /* renamed from: a */
    public final Bitmap invoke() {
        return Bitmap.createBitmap(this.a.getWidth(), this.a.getHeight(), Bitmap.Config.ARGB_8888);
    }
}