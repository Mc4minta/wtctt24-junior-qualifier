package com.coinbase.wallet.commonui.viewmodels;

import android.os.Bundle;
import androidx.lifecycle.b0;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ViewModelWithArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/commonui/viewmodels/ViewModelWithArgs;", "Landroidx/lifecycle/b0;", "Landroid/os/Bundle;", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "setArgs", "(Landroid/os/Bundle;)V", "<init>", "()V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ViewModelWithArgs extends b0 {
    public Bundle args;

    public final Bundle getArgs() {
        Bundle bundle = this.args;
        if (bundle != null) {
            return bundle;
        }
        m.w("args");
        throw null;
    }

    public final void setArgs(Bundle bundle) {
        m.g(bundle, "<set-?>");
        this.args = bundle;
    }
}