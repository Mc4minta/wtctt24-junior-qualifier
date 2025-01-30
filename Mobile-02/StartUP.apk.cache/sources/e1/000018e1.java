package com.coinbase.wallet.core.extensions;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: Date+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0004\"\u0017\u0010\b\u001a\u00020\u0002*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Ljava/util/Date;", "date", "", "secondsSince", "(Ljava/util/Date;Ljava/util/Date;)J", "timeIntervalSince", "getTimeIntervalSinceNow", "(Ljava/util/Date;)J", "timeIntervalSinceNow", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Date_CoreKt {
    public static final long getTimeIntervalSinceNow(Date date) {
        kotlin.jvm.internal.m.g(date, "<this>");
        return timeIntervalSince(date, new Date());
    }

    public static final long secondsSince(Date date, Date date2) {
        kotlin.jvm.internal.m.g(date, "<this>");
        kotlin.jvm.internal.m.g(date2, "date");
        return TimeUnit.MILLISECONDS.toSeconds(date.getTime() - date2.getTime());
    }

    public static final long timeIntervalSince(Date date, Date date2) {
        kotlin.jvm.internal.m.g(date, "<this>");
        kotlin.jvm.internal.m.g(date2, "date");
        long time = date.getTime() - date2.getTime();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return timeUnit.convert(time, timeUnit);
    }
}