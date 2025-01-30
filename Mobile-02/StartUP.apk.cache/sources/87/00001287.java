package com.coinbase.wallet.application.viewmodel;

import f.c.d;

/* loaded from: classes.dex */
public final class ScrolledToTopViewModel_Factory implements d<ScrolledToTopViewModel> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final ScrolledToTopViewModel_Factory INSTANCE = new ScrolledToTopViewModel_Factory();

        private InstanceHolder() {
        }
    }

    public static ScrolledToTopViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ScrolledToTopViewModel newInstance() {
        return new ScrolledToTopViewModel();
    }

    @Override // javax.inject.Provider
    public ScrolledToTopViewModel get() {
        return newInstance();
    }
}