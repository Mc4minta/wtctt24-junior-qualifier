package com.coinbase.wallet.application.extensions;

import com.coinbase.wallet.analytics.models.EventFeature;
import com.coinbase.wallet.routing.models.SendDestinationPickerArgs;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: EventFeature+Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"!\u0010\f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005\"!\u0010\u000f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005\"!\u0010\u0012\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"!\u0010\u0015\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0005\"!\u0010\u0018\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0005\"!\u0010\u001b\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u0005\"!\u0010\u001e\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u0005\"!\u0010!\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\u0005\"!\u0010$\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u0005¨\u0006%"}, d2 = {"Lcom/coinbase/wallet/analytics/models/EventFeature$Companion;", "Lcom/coinbase/wallet/analytics/models/EventFeature;", "AdjustableMinerFee$delegate", "Lkotlin/h;", "getAdjustableMinerFee", "(Lcom/coinbase/wallet/analytics/models/EventFeature$Companion;)Lcom/coinbase/wallet/analytics/models/EventFeature;", "AdjustableMinerFee", "Onboarding$delegate", "getOnboarding", "Onboarding", "Settings$delegate", "getSettings", "Settings", "Swap$delegate", "getSwap", "Swap", "KeyBackup$delegate", "getKeyBackup", "KeyBackup", "Lend$delegate", "getLend", "Lend", "DApps$delegate", "getDApps", "DApps", "Send$delegate", "getSend", "Send", "SecurityNotifications$delegate", "getSecurityNotifications", "SecurityNotifications", "Wallet$delegate", "getWallet", SendDestinationPickerArgs.WALLET, "WalletLink$delegate", "getWalletLink", "WalletLink", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EventFeature_ApplicationKt {
    private static final h AdjustableMinerFee$delegate;
    private static final h DApps$delegate;
    private static final h KeyBackup$delegate;
    private static final h Lend$delegate;
    private static final h Onboarding$delegate;
    private static final h SecurityNotifications$delegate;
    private static final h Send$delegate;
    private static final h Settings$delegate;
    private static final h Swap$delegate;
    private static final h Wallet$delegate;
    private static final h WalletLink$delegate;

    static {
        h b2;
        h b3;
        h b4;
        h b5;
        h b6;
        h b7;
        h b8;
        h b9;
        h b10;
        h b11;
        h b12;
        b2 = k.b(EventFeature_ApplicationKt$Wallet$2.INSTANCE);
        Wallet$delegate = b2;
        b3 = k.b(EventFeature_ApplicationKt$Onboarding$2.INSTANCE);
        Onboarding$delegate = b3;
        b4 = k.b(EventFeature_ApplicationKt$KeyBackup$2.INSTANCE);
        KeyBackup$delegate = b4;
        b5 = k.b(EventFeature_ApplicationKt$SecurityNotifications$2.INSTANCE);
        SecurityNotifications$delegate = b5;
        b6 = k.b(EventFeature_ApplicationKt$Settings$2.INSTANCE);
        Settings$delegate = b6;
        b7 = k.b(EventFeature_ApplicationKt$DApps$2.INSTANCE);
        DApps$delegate = b7;
        b8 = k.b(EventFeature_ApplicationKt$Send$2.INSTANCE);
        Send$delegate = b8;
        b9 = k.b(EventFeature_ApplicationKt$WalletLink$2.INSTANCE);
        WalletLink$delegate = b9;
        b10 = k.b(EventFeature_ApplicationKt$Lend$2.INSTANCE);
        Lend$delegate = b10;
        b11 = k.b(EventFeature_ApplicationKt$Swap$2.INSTANCE);
        Swap$delegate = b11;
        b12 = k.b(EventFeature_ApplicationKt$AdjustableMinerFee$2.INSTANCE);
        AdjustableMinerFee$delegate = b12;
    }

    public static final EventFeature getAdjustableMinerFee(EventFeature.Companion companion) {
        m.g(companion, "<this>");
        return (EventFeature) AdjustableMinerFee$delegate.getValue();
    }

    public static final EventFeature getDApps(EventFeature.Companion companion) {
        m.g(companion, "<this>");
        return (EventFeature) DApps$delegate.getValue();
    }

    public static final EventFeature getKeyBackup(EventFeature.Companion companion) {
        m.g(companion, "<this>");
        return (EventFeature) KeyBackup$delegate.getValue();
    }

    public static final EventFeature getLend(EventFeature.Companion companion) {
        m.g(companion, "<this>");
        return (EventFeature) Lend$delegate.getValue();
    }

    public static final EventFeature getOnboarding(EventFeature.Companion companion) {
        m.g(companion, "<this>");
        return (EventFeature) Onboarding$delegate.getValue();
    }

    public static final EventFeature getSecurityNotifications(EventFeature.Companion companion) {
        m.g(companion, "<this>");
        return (EventFeature) SecurityNotifications$delegate.getValue();
    }

    public static final EventFeature getSend(EventFeature.Companion companion) {
        m.g(companion, "<this>");
        return (EventFeature) Send$delegate.getValue();
    }

    public static final EventFeature getSettings(EventFeature.Companion companion) {
        m.g(companion, "<this>");
        return (EventFeature) Settings$delegate.getValue();
    }

    public static final EventFeature getSwap(EventFeature.Companion companion) {
        m.g(companion, "<this>");
        return (EventFeature) Swap$delegate.getValue();
    }

    public static final EventFeature getWallet(EventFeature.Companion companion) {
        m.g(companion, "<this>");
        return (EventFeature) Wallet$delegate.getValue();
    }

    public static final EventFeature getWalletLink(EventFeature.Companion companion) {
        m.g(companion, "<this>");
        return (EventFeature) WalletLink$delegate.getValue();
    }
}