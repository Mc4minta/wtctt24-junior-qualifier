package com.coinbase.wallet.commonui.models;

import android.os.Bundle;
import androidx.core.os.b;
import kotlin.Metadata;
import kotlin.u;

/* compiled from: ForwardArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/commonui/models/ForwardArgs;", "", "", ForwardArgs.KEY_MODAL_SOURCE, "Landroid/os/Bundle;", "create", "(I)Landroid/os/Bundle;", "args", "modalSourceFromArgs", "(Landroid/os/Bundle;)Ljava/lang/Integer;", "", "KEY_MODAL_SOURCE", "Ljava/lang/String;", "<init>", "()V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ForwardArgs {
    public static final ForwardArgs INSTANCE = new ForwardArgs();
    private static final String KEY_MODAL_SOURCE = "modalSource";

    private ForwardArgs() {
    }

    public final Bundle create(int i2) {
        return b.a(u.a(KEY_MODAL_SOURCE, Integer.valueOf(i2)));
    }

    public final Integer modalSourceFromArgs(Bundle bundle) {
        Integer valueOf = bundle == null ? null : Integer.valueOf(bundle.getInt(KEY_MODAL_SOURCE, -1));
        if (valueOf != null && valueOf.intValue() == -1) {
            return null;
        }
        return valueOf;
    }
}