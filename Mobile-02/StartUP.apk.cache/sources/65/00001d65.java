package com.coinbase.wallet.features.cloudbackup.util;

import android.content.Context;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RecoveryPhraseClipboardWrapper_Factory implements d<RecoveryPhraseClipboardWrapper> {
    private final Provider<Context> contextProvider;

    public RecoveryPhraseClipboardWrapper_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static RecoveryPhraseClipboardWrapper_Factory create(Provider<Context> provider) {
        return new RecoveryPhraseClipboardWrapper_Factory(provider);
    }

    public static RecoveryPhraseClipboardWrapper newInstance(Context context) {
        return new RecoveryPhraseClipboardWrapper(context);
    }

    @Override // javax.inject.Provider
    public RecoveryPhraseClipboardWrapper get() {
        return newInstance(this.contextProvider.get());
    }
}