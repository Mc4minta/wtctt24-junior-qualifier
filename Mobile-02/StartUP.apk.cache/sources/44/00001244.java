package com.coinbase.wallet.application.util;

import f.c.d;

/* loaded from: classes.dex */
public final class ContactUsLauncher_Factory implements d<ContactUsLauncher> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final ContactUsLauncher_Factory INSTANCE = new ContactUsLauncher_Factory();

        private InstanceHolder() {
        }
    }

    public static ContactUsLauncher_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ContactUsLauncher newInstance() {
        return new ContactUsLauncher();
    }

    @Override // javax.inject.Provider
    public ContactUsLauncher get() {
        return newInstance();
    }
}