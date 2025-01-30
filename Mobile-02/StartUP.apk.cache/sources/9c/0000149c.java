package com.coinbase.wallet.commonui.extensions;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: View+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b&\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/commonui/extensions/OnSingleClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "Lkotlin/x;", "onClick", "(Landroid/view/View;)V", "onSingleClick", "", "delayMs", "J", "<init>", "(J)V", "Companion", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class OnSingleClickListener implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final long LONG_DELAY_MS = 2500;
    public static final long SHORT_DELAY_MS = 500;
    private static long nextAllowedClickTime;
    private final long delayMs;

    /* compiled from: View+Common.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/commonui/extensions/OnSingleClickListener$Companion;", "", "", "LONG_DELAY_MS", "J", "SHORT_DELAY_MS", "nextAllowedClickTime", "<init>", "()V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OnSingleClickListener() {
        this(0L, 1, null);
    }

    public OnSingleClickListener(long j2) {
        this.delayMs = j2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View v) {
        m.g(v, "v");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= nextAllowedClickTime) {
            nextAllowedClickTime = currentTimeMillis + this.delayMs;
            onSingleClick(v);
        }
    }

    public abstract void onSingleClick(View view);

    public /* synthetic */ OnSingleClickListener(long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 500L : j2);
    }
}