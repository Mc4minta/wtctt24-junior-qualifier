package com.coinbase.wallet.features.cloudbackup.view;

import androidx.appcompat.app.c;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: BackupRecoveryPhraseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/appcompat/app/c$a;", "Lcom/toshi/extensions/DialogBuilder;", "Lkotlin/x;", "<anonymous>", "(Landroidx/appcompat/app/c$a;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class BackupRecoveryPhraseFragment$createAndShowScreenshotDialog$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<c.a, kotlin.x> {
    public static final BackupRecoveryPhraseFragment$createAndShowScreenshotDialog$1 INSTANCE = new BackupRecoveryPhraseFragment$createAndShowScreenshotDialog$1();

    BackupRecoveryPhraseFragment$createAndShowScreenshotDialog$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(c.a aVar) {
        invoke2(aVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(c.a showDialog) {
        kotlin.jvm.internal.m.g(showDialog, "$this$showDialog");
        showDialog.n(R.string.screenshot_warning_title);
        showDialog.f(R.string.screenshot_warning_message);
        e.j.f.k.b(showDialog, R.string.got_it);
    }
}