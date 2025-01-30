package com.coinbase.wallet.libraries.databases.converters;

import java.util.Date;
import kotlin.Metadata;

/* compiled from: DateConverter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/converters/DateConverter;", "", "", "timestamp", "Ljava/util/Date;", "toDate", "(Ljava/lang/Long;)Ljava/util/Date;", "date", "toTimestamp", "(Ljava/util/Date;)Ljava/lang/Long;", "<init>", "()V", "database_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class DateConverter {
    public final Date toDate(Long l2) {
        if (l2 == null) {
            return null;
        }
        return new Date(l2.longValue());
    }

    public final Long toTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return Long.valueOf(date.getTime());
    }
}