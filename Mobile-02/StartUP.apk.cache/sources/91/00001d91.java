package com.coinbase.wallet.features.cloudbackup.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import kotlin.Metadata;

/* compiled from: CreatePasswordFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class CreatePasswordFragment$initClickListeners$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
    final /* synthetic */ CreatePasswordFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreatePasswordFragment$initClickListeners$2(CreatePasswordFragment createPasswordFragment) {
        super(1);
        this.this$0 = createPasswordFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
        invoke2(view);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        kotlin.jvm.internal.m.g(it, "it");
        InputMethodManager c2 = e.j.f.m.c(this.this$0);
        if (c2 != null) {
            View view = this.this$0.getView();
            c2.hideSoftInputFromWindow(((LinearLayout) (view == null ? null : view.findViewById(e.j.a.userAgreementHolder))).getWindowToken(), 0);
        }
        View view2 = this.this$0.getView();
        ((AppCompatCheckBox) (view2 != null ? view2.findViewById(e.j.a.n0) : null)).toggle();
    }
}