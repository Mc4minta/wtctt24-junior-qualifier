package com.coinbase.android.apiv3.generated.authed.new_user_experience;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.b;
import com.squareup.wire.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;

/* compiled from: Step.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;", "", "Lcom/squareup/wire/o;", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "NONE", "SIMPLIFIED_BUY_PRE_PROOFING", "SIMPLIFIED_BUY_POST_PROOFING", "PLAID", "CARD_3DS", "CRYPTO_DEPOSIT", "CRYPTO_INCENTIVES", "SEPA", "NOTIFICATION_OPT_IN", "SIMPLIFIED_BUY_POST_PROOFING_REFERRAL", "SIMPLIFIED_BUY_POST_PROOFING_REFERRAL_NOT_ELIGIBLE", "POST_PROOFING_COMPLETION", "FASTER_PAYMENTS", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public enum Step implements o {
    NONE(0),
    SIMPLIFIED_BUY_PRE_PROOFING(1),
    SIMPLIFIED_BUY_POST_PROOFING(2),
    PLAID(3),
    CARD_3DS(4),
    CRYPTO_DEPOSIT(5),
    CRYPTO_INCENTIVES(6),
    SEPA(7),
    NOTIFICATION_OPT_IN(8),
    SIMPLIFIED_BUY_POST_PROOFING_REFERRAL(9),
    SIMPLIFIED_BUY_POST_PROOFING_REFERRAL_NOT_ELIGIBLE(10),
    POST_PROOFING_COMPLETION(11),
    FASTER_PAYMENTS(12);
    
    private final int value;
    public static final Companion Companion = new Companion(null);
    public static final ProtoAdapter<Step> ADAPTER = new b<Step>(e0.b(Step.class)) { // from class: com.coinbase.android.apiv3.generated.authed.new_user_experience.Step$Companion$ADAPTER$1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.b
        public Step fromValue(int i2) {
            return Step.Companion.fromValue(i2);
        }
    };

    /* compiled from: Step.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step$Companion;", "", "", "value", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;", "fromValue", "(I)Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;", "Lcom/squareup/wire/ProtoAdapter;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final Step fromValue(int i2) {
            switch (i2) {
                case 0:
                    return Step.NONE;
                case 1:
                    return Step.SIMPLIFIED_BUY_PRE_PROOFING;
                case 2:
                    return Step.SIMPLIFIED_BUY_POST_PROOFING;
                case 3:
                    return Step.PLAID;
                case 4:
                    return Step.CARD_3DS;
                case 5:
                    return Step.CRYPTO_DEPOSIT;
                case 6:
                    return Step.CRYPTO_INCENTIVES;
                case 7:
                    return Step.SEPA;
                case 8:
                    return Step.NOTIFICATION_OPT_IN;
                case 9:
                    return Step.SIMPLIFIED_BUY_POST_PROOFING_REFERRAL;
                case 10:
                    return Step.SIMPLIFIED_BUY_POST_PROOFING_REFERRAL_NOT_ELIGIBLE;
                case 11:
                    return Step.POST_PROOFING_COMPLETION;
                case 12:
                    return Step.FASTER_PAYMENTS;
                default:
                    return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    Step(int i2) {
        this.value = i2;
    }

    public static final Step fromValue(int i2) {
        return Companion.fromValue(i2);
    }

    @Override // com.squareup.wire.o
    public int getValue() {
        return this.value;
    }
}