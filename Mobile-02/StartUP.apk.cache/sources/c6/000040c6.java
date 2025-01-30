package com.toshi.qr.view.custom;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.o;
import org.toshi.R;

/* compiled from: QROverlay.kt */
/* loaded from: classes2.dex */
final class d extends o implements kotlin.e0.c.a<Drawable> {
    final /* synthetic */ QROverlay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(QROverlay qROverlay) {
        super(0);
        this.a = qROverlay;
    }

    @Override // kotlin.e0.c.a
    /* renamed from: a */
    public final Drawable invoke() {
        float warningIconLeft;
        float warningIconTop;
        float warningIconRight;
        float warningIconBottom;
        Drawable drawable = this.a.getResources().getDrawable(R.drawable.ic_qr_warning, null);
        Rect rect = new Rect();
        warningIconLeft = this.a.getWarningIconLeft();
        warningIconTop = this.a.getWarningIconTop();
        warningIconRight = this.a.getWarningIconRight();
        warningIconBottom = this.a.getWarningIconBottom();
        new RectF(warningIconLeft, warningIconTop, warningIconRight, warningIconBottom).round(rect);
        drawable.setBounds(rect);
        return drawable;
    }
}