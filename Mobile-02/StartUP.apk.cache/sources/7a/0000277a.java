package com.coinbase.wallet.txhistory.operations;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: SyncXrpTxHistoryOperation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/text/SimpleDateFormat;", "<anonymous>", "()Ljava/text/SimpleDateFormat;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class SyncXrpTxHistoryOperation$dateFormatter$2 extends o implements kotlin.e0.c.a<SimpleDateFormat> {
    public static final SyncXrpTxHistoryOperation$dateFormatter$2 INSTANCE = new SyncXrpTxHistoryOperation$dateFormatter$2();

    SyncXrpTxHistoryOperation$dateFormatter$2() {
        super(0);
    }

    @Override // kotlin.e0.c.a
    public final SimpleDateFormat invoke() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    }
}