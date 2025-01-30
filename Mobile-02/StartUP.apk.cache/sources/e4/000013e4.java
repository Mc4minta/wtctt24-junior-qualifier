package com.coinbase.wallet.blockchains.exceptions;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: WalletException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0007\u0007\b\t\n\u000b\f\rB\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/WalletException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "MissingRepository", "UnableFetchBalance", "UnableToFindPrimaryAddress", "UnableToSaveWallet", "UnableToSaveWallets", "UnableToWatchAddress", "UnsupportedIndexSwitch", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException$UnableToSaveWallet;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException$UnableToSaveWallets;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException$UnableFetchBalance;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException$UnsupportedIndexSwitch;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException$MissingRepository;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException$UnableToWatchAddress;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException$UnableToFindPrimaryAddress;", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class WalletException extends Exception {

    /* compiled from: WalletException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/WalletException$MissingRepository;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class MissingRepository extends WalletException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingRepository(Blockchain blockchain) {
            super(m.o("Unable to find repository for ", blockchain), null);
            m.g(blockchain, "blockchain");
        }
    }

    /* compiled from: WalletException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/WalletException$UnableFetchBalance;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableFetchBalance extends WalletException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnableFetchBalance(Blockchain blockchain) {
            super(m.o("Unable to fetch balance ", blockchain), null);
            m.g(blockchain, "blockchain");
        }
    }

    /* compiled from: WalletException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/WalletException$UnableToFindPrimaryAddress;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToFindPrimaryAddress extends WalletException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnableToFindPrimaryAddress(Blockchain blockchain) {
            super(m.o("Unable to find primary address for ", blockchain), null);
            m.g(blockchain, "blockchain");
        }
    }

    /* compiled from: WalletException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/WalletException$UnableToSaveWallet;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToSaveWallet extends WalletException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnableToSaveWallet(Wallet wallet) {
            super(m.o("Unable to save wallet ", wallet.getCurrencyCode()), null);
            m.g(wallet, "wallet");
        }
    }

    /* compiled from: WalletException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/WalletException$UnableToSaveWallets;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallets", "<init>", "(Ljava/util/List;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToSaveWallets extends WalletException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnableToSaveWallets(List<Wallet> wallets) {
            super(m.o("Unable to save wallets ", wallets), null);
            m.g(wallets, "wallets");
        }
    }

    /* compiled from: WalletException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/WalletException$UnableToWatchAddress;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToWatchAddress extends WalletException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnableToWatchAddress(Blockchain blockchain) {
            super(m.o("Unable to watch address for ", blockchain.getRawValue()), null);
            m.g(blockchain, "blockchain");
        }
    }

    /* compiled from: WalletException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/WalletException$UnsupportedIndexSwitch;", "Lcom/coinbase/wallet/blockchains/exceptions/WalletException;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnsupportedIndexSwitch extends WalletException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnsupportedIndexSwitch(Blockchain blockchain) {
            super(m.o("Unsupported index switching ", blockchain), null);
            m.g(blockchain, "blockchain");
        }
    }

    private WalletException(String str) {
        super(str);
    }

    public /* synthetic */ WalletException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}