package com.toshi.view.fragment;

import android.os.Bundle;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;

/* compiled from: FundActionSheetArgs.kt */
/* loaded from: classes2.dex */
public final class k0 {
    public static final k0 a = new k0();

    private k0() {
    }

    public final Bundle a(String title, boolean z, ConsumerConnectionStatus connectionStatus) {
        kotlin.jvm.internal.m.g(title, "title");
        kotlin.jvm.internal.m.g(connectionStatus, "connectionStatus");
        return androidx.core.os.b.a(kotlin.u.a("dialogTitleKey", title), kotlin.u.a("showCryptoActionKey", Boolean.valueOf(z)), kotlin.u.a("connectionStatusKey", connectionStatus));
    }
}