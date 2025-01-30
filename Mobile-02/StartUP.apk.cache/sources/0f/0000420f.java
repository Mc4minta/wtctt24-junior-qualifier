package com.toshi.view.custom;

import e.j.f.y;
import org.toshi.R;

/* compiled from: ProgressBar.kt */
/* loaded from: classes2.dex */
final class q extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Integer> {
    final /* synthetic */ ProgressBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(ProgressBar progressBar) {
        super(0);
        this.a = progressBar;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return y.b(this.a, R.color.web_view_progress_background);
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }
}