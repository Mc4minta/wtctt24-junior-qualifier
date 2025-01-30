package com.toshi.qr.view.custom;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import kotlin.jvm.internal.o;

/* compiled from: QROverlay.kt */
/* loaded from: classes2.dex */
final class c extends o implements kotlin.e0.c.a<Canvas> {
    final /* synthetic */ QROverlay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(QROverlay qROverlay) {
        super(0);
        this.a = qROverlay;
    }

    @Override // kotlin.e0.c.a
    /* renamed from: a */
    public final Canvas invoke() {
        Bitmap bitmap;
        bitmap = this.a.getBitmap();
        return new Canvas(bitmap);
    }
}