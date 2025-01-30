package com.coinbase.wallet.features.signer.views;

import android.content.Context;
import android.view.View;
import com.toshi.view.custom.SpinnerOverlayLayout;
import kotlin.Metadata;

/* compiled from: SignerViewFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/toshi/view/custom/SpinnerOverlayLayout;", "<anonymous>", "()Lcom/toshi/view/custom/SpinnerOverlayLayout;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SignerViewFragment$spinnerOverlay$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<SpinnerOverlayLayout> {
    final /* synthetic */ SignerViewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignerViewFragment$spinnerOverlay$2(SignerViewFragment signerViewFragment) {
        super(0);
        this.this$0 = signerViewFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final SpinnerOverlayLayout invoke() {
        Context requireContext = this.this$0.requireContext();
        kotlin.jvm.internal.m.f(requireContext, "requireContext()");
        SpinnerOverlayLayout spinnerOverlayLayout = new SpinnerOverlayLayout(requireContext, null, 0, 6, null);
        spinnerOverlayLayout.setId(View.generateViewId());
        spinnerOverlayLayout.setZ(Float.MAX_VALUE);
        return spinnerOverlayLayout;
    }
}