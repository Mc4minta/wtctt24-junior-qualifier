package com.toshi.qr.view.custom;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.o;
import org.toshi.R;

/* compiled from: QROverlay.kt */
/* loaded from: classes2.dex */
final class b extends o implements kotlin.e0.c.a<Drawable> {
    final /* synthetic */ QROverlay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(QROverlay qROverlay) {
        super(0);
        this.a = qROverlay;
    }

    @Override // kotlin.e0.c.a
    /* renamed from: a */
    public final Drawable invoke() {
        float left;
        float top;
        float right;
        float bottom;
        Drawable f2 = androidx.core.content.a.f(this.a.getContext(), R.drawable.ic_bracket);
        if (f2 == null) {
            return null;
        }
        QROverlay qROverlay = this.a;
        left = qROverlay.getLeft();
        top = qROverlay.getTop();
        right = qROverlay.getRight();
        bottom = qROverlay.getBottom();
        f2.setBounds((int) left, (int) top, (int) right, (int) bottom);
        return f2;
    }
}