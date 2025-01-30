package com.coinbase.wallet.features.cloudbackup.view;

import android.view.View;
import android.widget.TextView;
import com.coinbase.wallet.features.cloudbackup.models.PasswordState;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: CreatePasswordFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/PasswordState;", "kotlin.jvm.PlatformType", "passwordState", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/cloudbackup/models/PasswordState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class CreatePasswordFragment$initObservers$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<PasswordState, kotlin.x> {
    final /* synthetic */ CreatePasswordFragment this$0;

    /* compiled from: CreatePasswordFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PasswordState.values().length];
            iArr[PasswordState.VALID.ordinal()] = 1;
            iArr[PasswordState.INVALID_LENGTH.ordinal()] = 2;
            iArr[PasswordState.REQUIREMENTS_NOT_MET.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreatePasswordFragment$initObservers$2(CreatePasswordFragment createPasswordFragment) {
        super(1);
        this.this$0 = createPasswordFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(PasswordState passwordState) {
        invoke2(passwordState);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(PasswordState passwordState) {
        View findViewById;
        int i2 = passwordState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[passwordState.ordinal()];
        if (i2 == 1) {
            View view = this.this$0.getView();
            ((TextInputLayout) (view == null ? null : view.findViewById(e.j.a.verifyPasswordInputLayout))).setVisibility(0);
            View view2 = this.this$0.getView();
            ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.verifyPasswordInputStatusLabel))).setVisibility(0);
            View view3 = this.this$0.getView();
            ((TextView) (view3 != null ? view3.findViewById(e.j.a.passwordInputStatusLabel) : null)).setTextColor(e.j.f.m.m(this.this$0, R.color.primary_green));
        } else if (i2 == 2) {
            View view4 = this.this$0.getView();
            findViewById = view4 != null ? view4.findViewById(e.j.a.passwordInputStatusLabel) : null;
            CreatePasswordFragment createPasswordFragment = this.this$0;
            TextView textView = (TextView) findViewById;
            textView.setText(R.string.error_invalid_password_length);
            textView.setTextColor(e.j.f.m.m(createPasswordFragment, R.color.primary_red));
        } else if (i2 != 3) {
            View view5 = this.this$0.getView();
            findViewById = view5 != null ? view5.findViewById(e.j.a.passwordInputStatusLabel) : null;
            CreatePasswordFragment createPasswordFragment2 = this.this$0;
            TextView textView2 = (TextView) findViewById;
            textView2.setText(R.string.error_invalid_password_generic);
            textView2.setTextColor(e.j.f.m.m(createPasswordFragment2, R.color.primary_red));
        } else {
            View view6 = this.this$0.getView();
            findViewById = view6 != null ? view6.findViewById(e.j.a.passwordInputStatusLabel) : null;
            CreatePasswordFragment createPasswordFragment3 = this.this$0;
            TextView textView3 = (TextView) findViewById;
            textView3.setText(R.string.error_invalid_password_requirements_not_met);
            textView3.setTextColor(e.j.f.m.m(createPasswordFragment3, R.color.primary_red));
        }
    }
}