package com.coinbase.wallet.application.viewmodel;

import f.c.d;

/* loaded from: classes.dex */
public final class LoadingPillViewModel_Factory implements d<LoadingPillViewModel> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final LoadingPillViewModel_Factory INSTANCE = new LoadingPillViewModel_Factory();

        private InstanceHolder() {
        }
    }

    public static LoadingPillViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LoadingPillViewModel newInstance() {
        return new LoadingPillViewModel();
    }

    @Override // javax.inject.Provider
    public LoadingPillViewModel get() {
        return newInstance();
    }
}