package com.coinbase.wallet.wallets.exceptions;

import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CryptoCurrencyException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0007B\u0013\b\u0004\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\b¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/wallets/exceptions/CryptoCurrencyException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "UnableToFindCryptoCurrency", "Lcom/coinbase/wallet/wallets/exceptions/CryptoCurrencyException$UnableToFindCryptoCurrency;", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class CryptoCurrencyException extends Exception {

    /* compiled from: CryptoCurrencyException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/wallets/exceptions/CryptoCurrencyException$UnableToFindCryptoCurrency;", "Lcom/coinbase/wallet/wallets/exceptions/CryptoCurrencyException;", "<init>", "()V", "wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToFindCryptoCurrency extends CryptoCurrencyException {
        public static final UnableToFindCryptoCurrency INSTANCE = new UnableToFindCryptoCurrency();

        private UnableToFindCryptoCurrency() {
            super("Unable to find cryptocurrency", null);
        }
    }

    private CryptoCurrencyException(String str) {
        super(str);
    }

    public /* synthetic */ CryptoCurrencyException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ CryptoCurrencyException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, null);
    }
}