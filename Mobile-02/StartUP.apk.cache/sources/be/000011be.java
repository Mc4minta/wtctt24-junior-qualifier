package com.coinbase.wallet.application.extensions;

import com.coinbase.wallet.core.models.TraceKey;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: TraceKey+Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"!\u0010\n\u001a\u00020\u0003*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"!\u0010\r\u001a\u00020\u0003*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\"!\u0010\u0010\u001a\u00020\u0003*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t\"!\u0010\u0013\u001a\u00020\u0003*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"!\u0010\u0016\u001a\u00020\u0003*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/core/models/TraceKey$Companion;", "", "uuid", "Lcom/coinbase/wallet/core/models/TraceKey;", "refreshTrace", "(Lcom/coinbase/wallet/core/models/TraceKey$Companion;I)Lcom/coinbase/wallet/core/models/TraceKey;", "confirmSendKey$delegate", "Lkotlin/h;", "getConfirmSendKey", "(Lcom/coinbase/wallet/core/models/TraceKey$Companion;)Lcom/coinbase/wallet/core/models/TraceKey;", "confirmSendKey", "registerExistingUserKey$delegate", "getRegisterExistingUserKey", "registerExistingUserKey", "confirmLendKey$delegate", "getConfirmLendKey", "confirmLendKey", "registerNewUserKey$delegate", "getRegisterNewUserKey", "registerNewUserKey", "loadLendDashboardKey$delegate", "getLoadLendDashboardKey", "loadLendDashboardKey", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TraceKey_ApplicationKt {
    private static final h confirmLendKey$delegate;
    private static final h confirmSendKey$delegate;
    private static final h loadLendDashboardKey$delegate;
    private static final h registerExistingUserKey$delegate;
    private static final h registerNewUserKey$delegate;

    static {
        h b2;
        h b3;
        h b4;
        h b5;
        h b6;
        b2 = k.b(TraceKey_ApplicationKt$loadLendDashboardKey$2.INSTANCE);
        loadLendDashboardKey$delegate = b2;
        b3 = k.b(TraceKey_ApplicationKt$confirmLendKey$2.INSTANCE);
        confirmLendKey$delegate = b3;
        b4 = k.b(TraceKey_ApplicationKt$confirmSendKey$2.INSTANCE);
        confirmSendKey$delegate = b4;
        b5 = k.b(TraceKey_ApplicationKt$registerExistingUserKey$2.INSTANCE);
        registerExistingUserKey$delegate = b5;
        b6 = k.b(TraceKey_ApplicationKt$registerNewUserKey$2.INSTANCE);
        registerNewUserKey$delegate = b6;
    }

    public static final TraceKey getConfirmLendKey(TraceKey.Companion companion) {
        m.g(companion, "<this>");
        return (TraceKey) confirmLendKey$delegate.getValue();
    }

    public static final TraceKey getConfirmSendKey(TraceKey.Companion companion) {
        m.g(companion, "<this>");
        return (TraceKey) confirmSendKey$delegate.getValue();
    }

    public static final TraceKey getLoadLendDashboardKey(TraceKey.Companion companion) {
        m.g(companion, "<this>");
        return (TraceKey) loadLendDashboardKey$delegate.getValue();
    }

    public static final TraceKey getRegisterExistingUserKey(TraceKey.Companion companion) {
        m.g(companion, "<this>");
        return (TraceKey) registerExistingUserKey$delegate.getValue();
    }

    public static final TraceKey getRegisterNewUserKey(TraceKey.Companion companion) {
        m.g(companion, "<this>");
        return (TraceKey) registerNewUserKey$delegate.getValue();
    }

    public static final TraceKey refreshTrace(TraceKey.Companion companion, int i2) {
        m.g(companion, "<this>");
        return new TraceKey("refresh", i2, false, false, 12, null);
    }
}