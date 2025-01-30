package com.coinbase.android.apiv3.generated.authed.loans;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.b;
import com.squareup.wire.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;

/* compiled from: UpcomingPaymentType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPaymentType;", "", "Lcom/squareup/wire/o;", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "DUE", "OVERDUE", "AUTOPAY", "PROCESSING", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public enum UpcomingPaymentType implements o {
    DUE(0),
    OVERDUE(1),
    AUTOPAY(2),
    PROCESSING(3);
    
    private final int value;
    public static final Companion Companion = new Companion(null);
    public static final ProtoAdapter<UpcomingPaymentType> ADAPTER = new b<UpcomingPaymentType>(e0.b(UpcomingPaymentType.class)) { // from class: com.coinbase.android.apiv3.generated.authed.loans.UpcomingPaymentType$Companion$ADAPTER$1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.b
        public UpcomingPaymentType fromValue(int i2) {
            return UpcomingPaymentType.Companion.fromValue(i2);
        }
    };

    /* compiled from: UpcomingPaymentType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPaymentType$Companion;", "", "", "value", "Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPaymentType;", "fromValue", "(I)Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPaymentType;", "Lcom/squareup/wire/ProtoAdapter;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final UpcomingPaymentType fromValue(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return null;
                        }
                        return UpcomingPaymentType.PROCESSING;
                    }
                    return UpcomingPaymentType.AUTOPAY;
                }
                return UpcomingPaymentType.OVERDUE;
            }
            return UpcomingPaymentType.DUE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    UpcomingPaymentType(int i2) {
        this.value = i2;
    }

    public static final UpcomingPaymentType fromValue(int i2) {
        return Companion.fromValue(i2);
    }

    @Override // com.squareup.wire.o
    public int getValue() {
        return this.value;
    }
}