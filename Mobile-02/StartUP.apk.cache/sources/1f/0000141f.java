package com.coinbase.wallet.blockchains.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TxState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxState;", "", "", "rawValue", "I", "getRawValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "PENDING", "FAILED", "CONFIRMED", "DROPPED", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public enum TxState {
    PENDING(1),
    FAILED(2),
    CONFIRMED(3),
    DROPPED(4);
    
    public static final Companion Companion = new Companion(null);
    private final int rawValue;

    /* compiled from: TxState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxState$Companion;", "", "", "rawValue", "Lcom/coinbase/wallet/blockchains/models/TxState;", "create", "(I)Lcom/coinbase/wallet/blockchains/models/TxState;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TxState create(int i2) {
            TxState[] values;
            for (TxState txState : TxState.values()) {
                if (txState.getRawValue() == i2) {
                    return txState;
                }
            }
            return null;
        }
    }

    TxState(int i2) {
        this.rawValue = i2;
    }

    public static final TxState create(int i2) {
        return Companion.create(i2);
    }

    public final int getRawValue() {
        return this.rawValue;
    }
}