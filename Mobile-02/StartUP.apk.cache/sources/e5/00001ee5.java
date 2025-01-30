package com.coinbase.wallet.features.lend.views;

import android.content.DialogInterface;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.toshi.model.local.room.Prompt;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: LendProviderPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/toshi/model/local/room/Prompt;", "kotlin.jvm.PlatformType", "prompt", "Lkotlin/x;", "<anonymous>", "(Lcom/toshi/model/local/room/Prompt;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendProviderPickerFragment$setupObservers$2 extends o implements l<Prompt, x> {
    final /* synthetic */ LendProviderPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LendProviderPickerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.lend.views.LendProviderPickerFragment$setupObservers$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends o implements l<DialogInterface, x> {
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
            m.g(it, "it");
            it.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LendProviderPickerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.lend.views.LendProviderPickerFragment$setupObservers$2$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends o implements l<DialogInterface, x> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(DialogInterface it) {
            m.g(it, "it");
            it.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendProviderPickerFragment$setupObservers$2(LendProviderPickerFragment lendProviderPickerFragment) {
        super(1);
        this.this$0 = lendProviderPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Prompt prompt) {
        invoke2(prompt);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Prompt prompt) {
        List b2;
        PromptDialogHelper promptDialogHelper = PromptDialogHelper.INSTANCE;
        LendProviderPickerFragment lendProviderPickerFragment = this.this$0;
        String string = lendProviderPickerFragment.getString(prompt.getTitle());
        String string2 = this.this$0.getString(prompt.getMessage());
        Integer imageResource = prompt.getImageResource();
        String string3 = this.this$0.getString(R.string.got_it);
        m.f(string3, "getString(R.string.got_it)");
        b2 = q.b(new PromptDialogHelper.Action(string3, ActionStyle.POSITIVE, AnonymousClass1.INSTANCE));
        m.f(string, "getString(prompt.title)");
        promptDialogHelper.show(lendProviderPickerFragment, new PromptDialogHelper.Properties(null, string, string2, null, imageResource, b2, Integer.valueOf((int) R.style.DialogFadeScaleAnimation), false, null, null, AnonymousClass2.INSTANCE, null, null, false, 15241, null));
    }
}