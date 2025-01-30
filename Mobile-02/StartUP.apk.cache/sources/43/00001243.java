package com.coinbase.wallet.application.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import e.j.f.c;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: ContactUsLauncher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/ActivityNotFoundException;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/content/ActivityNotFoundException;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ContactUsLauncher$launch$1 extends o implements l<ActivityNotFoundException, x> {
    final /* synthetic */ Activity $activity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactUsLauncher$launch$1(Activity activity) {
        super(1);
        this.$activity = activity;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(ActivityNotFoundException activityNotFoundException) {
        invoke2(activityNotFoundException);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ActivityNotFoundException it) {
        m.g(it, "it");
        c.h(this.$activity, R.string.cant_contact_us_message, 1);
    }
}