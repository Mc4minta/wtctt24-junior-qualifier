package com.coinbase.wallet.bip44wallets.exceptions;

import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: BIP44Exception.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0005\u0007\b\t\n\u000bB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "ChangeAddressNotFound", "UnableToDeriveXpubKey", "UnableToEstimateFee", "UnableToGenerateAddressDerivationPath", "UnableToSelectCoins", "Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception$UnableToDeriveXpubKey;", "Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception$UnableToGenerateAddressDerivationPath;", "Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception$UnableToEstimateFee;", "Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception$ChangeAddressNotFound;", "Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception$UnableToSelectCoins;", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class BIP44Exception extends Exception {

    /* compiled from: BIP44Exception.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception$ChangeAddressNotFound;", "Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception;", "<init>", "()V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ChangeAddressNotFound extends BIP44Exception {
        public static final ChangeAddressNotFound INSTANCE = new ChangeAddressNotFound();

        private ChangeAddressNotFound() {
            super(null, 1, null);
        }
    }

    /* compiled from: BIP44Exception.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception$UnableToDeriveXpubKey;", "Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception;", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "addressType", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "getAddressType", "()Lcom/coinbase/wallet/blockchains/models/AddressType;", "", "isTestnet", "Z", "()Z", "<init>", "(Lcom/coinbase/wallet/blockchains/models/AddressType;Z)V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToDeriveXpubKey extends BIP44Exception {
        private final AddressType addressType;
        private final boolean isTestnet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnableToDeriveXpubKey(AddressType addressType, boolean z) {
            super("Unable to derive xpub key " + addressType + '/' + z, null);
            m.g(addressType, "addressType");
            this.addressType = addressType;
            this.isTestnet = z;
        }

        public final AddressType getAddressType() {
            return this.addressType;
        }

        public final boolean isTestnet() {
            return this.isTestnet;
        }
    }

    /* compiled from: BIP44Exception.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception$UnableToEstimateFee;", "Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception;", "<init>", "()V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToEstimateFee extends BIP44Exception {
        public static final UnableToEstimateFee INSTANCE = new UnableToEstimateFee();

        private UnableToEstimateFee() {
            super(null, 1, null);
        }
    }

    /* compiled from: BIP44Exception.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception$UnableToGenerateAddressDerivationPath;", "Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception;", "<init>", "()V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToGenerateAddressDerivationPath extends BIP44Exception {
        public static final UnableToGenerateAddressDerivationPath INSTANCE = new UnableToGenerateAddressDerivationPath();

        private UnableToGenerateAddressDerivationPath() {
            super("Unable to generate derivation path", null);
        }
    }

    /* compiled from: BIP44Exception.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception$UnableToSelectCoins;", "Lcom/coinbase/wallet/bip44wallets/exceptions/BIP44Exception;", "<init>", "()V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToSelectCoins extends BIP44Exception {
        public static final UnableToSelectCoins INSTANCE = new UnableToSelectCoins();

        private UnableToSelectCoins() {
            super(null, 1, null);
        }
    }

    private BIP44Exception(String str) {
        super(str);
    }

    public /* synthetic */ BIP44Exception(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ BIP44Exception(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, null);
    }
}