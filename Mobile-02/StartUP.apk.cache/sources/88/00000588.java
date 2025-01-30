package c.h.k.e0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: AccessibilityClickableSpanCompat.java */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final d f3028b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3029c;

    public a(int i2, d dVar, int i3) {
        this.a = i2;
        this.f3028b = dVar;
        this.f3029c = i3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
        this.f3028b.K(this.f3029c, bundle);
    }
}