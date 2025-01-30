package com.coinbase.wallet.application;

import android.content.DialogInterface;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MainActivity$showEnjoyingTheAppPrompt$enjoyingAppActions$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, x> {
    final /* synthetic */ List<PromptDialogHelper.Action> $rateItActions;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.application.MainActivity$showEnjoyingTheAppPrompt$enjoyingAppActions$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, x> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(DialogInterface it) {
            kotlin.jvm.internal.m.g(it, "it");
            it.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$showEnjoyingTheAppPrompt$enjoyingAppActions$1(MainActivity mainActivity, List<PromptDialogHelper.Action> list) {
        super(1);
        this.this$0 = mainActivity;
        this.$rateItActions = list;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
        invoke2(dialogInterface);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DialogInterface it) {
        kotlin.jvm.internal.m.g(it, "it");
        PromptDialogHelper promptDialogHelper = PromptDialogHelper.INSTANCE;
        MainActivity mainActivity = this.this$0;
        CharSequence text = mainActivity.getText(R.string.action_hooray_title);
        kotlin.jvm.internal.m.f(text, "getText(R.string.action_hooray_title)");
        promptDialogHelper.show(mainActivity, new PromptDialogHelper.Properties(null, text, this.this$0.getText(R.string.action_hooray_desc), null, Integer.valueOf((int) R.drawable.illustration_celebrate), this.$rateItActions, null, false, null, null, AnonymousClass1.INSTANCE, null, null, false, 15305, null));
        it.dismiss();
    }
}