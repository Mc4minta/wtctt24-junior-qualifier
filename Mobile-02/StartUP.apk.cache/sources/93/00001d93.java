package com.coinbase.wallet.features.cloudbackup.view;

import android.view.View;
import com.google.android.material.textfield.TextInputEditText;
import com.toshi.view.custom.ProgressBarButton;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: CreatePasswordFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class CreatePasswordFragment$initObservers$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
    final /* synthetic */ CreatePasswordFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreatePasswordFragment$initObservers$1(CreatePasswordFragment createPasswordFragment) {
        super(1);
        this.this$0 = createPasswordFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
        invoke2(th);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        View view = this.this$0.getView();
        ((TextInputEditText) (view == null ? null : view.findViewById(e.j.a.passwordInput))).setError(this.this$0.getString(R.string.error_invalid_password_generic));
        View view2 = this.this$0.getView();
        ((ProgressBarButton) (view2 != null ? view2.findViewById(e.j.a.createPasswordBtn) : null)).setEnabled(false);
    }
}