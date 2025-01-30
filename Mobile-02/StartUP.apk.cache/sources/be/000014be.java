package com.coinbase.wallet.commonui.utilities;

import com.coinbase.wallet.common.utilities.Contexts;
import com.coinbase.wallet.commonui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: Colors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()I"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class Colors$errorColor$2 extends o implements kotlin.e0.c.a<Integer> {
    public static final Colors$errorColor$2 INSTANCE = new Colors$errorColor$2();

    Colors$errorColor$2() {
        super(0);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return androidx.core.content.a.d(Contexts.INSTANCE.getApp(), R.color.primary_red);
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }
}