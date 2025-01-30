package com.coinbase.wallet.features.cloudbackup.models;

import android.os.Bundle;
import androidx.core.os.b;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: OnboardingBackupRecoveryPhraseArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/OnboardingBackupRecoveryPhraseArgs;", "", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Landroid/os/Bundle;", "createArguments", "(Ljava/lang/String;)Landroid/os/Bundle;", "mnemonicKey", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class OnboardingBackupRecoveryPhraseArgs {
    public static final OnboardingBackupRecoveryPhraseArgs INSTANCE = new OnboardingBackupRecoveryPhraseArgs();
    public static final String mnemonicKey = "mnemonic";

    private OnboardingBackupRecoveryPhraseArgs() {
    }

    public final Bundle createArguments(String mnemonic) {
        m.g(mnemonic, "mnemonic");
        return b.a(u.a(mnemonicKey, mnemonic));
    }
}