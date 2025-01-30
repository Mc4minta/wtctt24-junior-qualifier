package com.coinbase.android.apiv3.generated.authed.new_user_experience;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.b;
import com.squareup.wire.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;

/* compiled from: RecurringInterval.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/RecurringInterval;", "", "Lcom/squareup/wire/o;", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "NEVER", "HOURLY", "DAILY", "WEEKLY", "EVERY_TWO_WEEKS", "FIRST_AND_FIFTEENTH", "MONTHLY", "QUARTERLY", "YEARLY", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public enum RecurringInterval implements o {
    NEVER(0),
    HOURLY(1),
    DAILY(2),
    WEEKLY(3),
    EVERY_TWO_WEEKS(4),
    FIRST_AND_FIFTEENTH(5),
    MONTHLY(6),
    QUARTERLY(7),
    YEARLY(8);
    
    private final int value;
    public static final Companion Companion = new Companion(null);
    public static final ProtoAdapter<RecurringInterval> ADAPTER = new b<RecurringInterval>(e0.b(RecurringInterval.class)) { // from class: com.coinbase.android.apiv3.generated.authed.new_user_experience.RecurringInterval$Companion$ADAPTER$1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.b
        public RecurringInterval fromValue(int i2) {
            return RecurringInterval.Companion.fromValue(i2);
        }
    };

    /* compiled from: RecurringInterval.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/RecurringInterval$Companion;", "", "", "value", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/RecurringInterval;", "fromValue", "(I)Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/RecurringInterval;", "Lcom/squareup/wire/ProtoAdapter;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final RecurringInterval fromValue(int i2) {
            switch (i2) {
                case 0:
                    return RecurringInterval.NEVER;
                case 1:
                    return RecurringInterval.HOURLY;
                case 2:
                    return RecurringInterval.DAILY;
                case 3:
                    return RecurringInterval.WEEKLY;
                case 4:
                    return RecurringInterval.EVERY_TWO_WEEKS;
                case 5:
                    return RecurringInterval.FIRST_AND_FIFTEENTH;
                case 6:
                    return RecurringInterval.MONTHLY;
                case 7:
                    return RecurringInterval.QUARTERLY;
                case 8:
                    return RecurringInterval.YEARLY;
                default:
                    return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    RecurringInterval(int i2) {
        this.value = i2;
    }

    public static final RecurringInterval fromValue(int i2) {
        return Companion.fromValue(i2);
    }

    @Override // com.squareup.wire.o
    public int getValue() {
        return this.value;
    }
}