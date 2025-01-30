package com.coinbase.wallet.featureflags.apis;

import com.coinbase.wallet.common.exceptions.RPCException;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: RPC.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "error", "", "<anonymous>", "(Ljava/lang/Throwable;)Z"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RPC$getProtected$2 extends o implements l<Throwable, Boolean> {
    public static final RPC$getProtected$2 INSTANCE = new RPC$getProtected$2();

    public RPC$getProtected$2() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
        return Boolean.valueOf(invoke2(th));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Throwable error) {
        m.g(error, "error");
        return error instanceof RPCException;
    }
}