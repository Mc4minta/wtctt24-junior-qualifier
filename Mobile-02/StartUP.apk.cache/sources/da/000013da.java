package com.coinbase.wallet.blockchains.exceptions;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: NetworkException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u0007\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/NetworkException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "InvalidNetwork", "MissingMainnetNetwork", "UnsupportedNetworkSwitch", "Lcom/coinbase/wallet/blockchains/exceptions/NetworkException$InvalidNetwork;", "Lcom/coinbase/wallet/blockchains/exceptions/NetworkException$UnsupportedNetworkSwitch;", "Lcom/coinbase/wallet/blockchains/exceptions/NetworkException$MissingMainnetNetwork;", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class NetworkException extends Exception {

    /* compiled from: NetworkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/NetworkException$InvalidNetwork;", "Lcom/coinbase/wallet/blockchains/exceptions/NetworkException;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Network;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InvalidNetwork extends NetworkException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidNetwork(Network network) {
            super(m.o("Invalid network state ", network), null);
            m.g(network, "network");
        }
    }

    /* compiled from: NetworkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/NetworkException$MissingMainnetNetwork;", "Lcom/coinbase/wallet/blockchains/exceptions/NetworkException;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class MissingMainnetNetwork extends NetworkException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingMainnetNetwork(Blockchain blockchain) {
            super(m.o("Missing network for ", blockchain), null);
            m.g(blockchain, "blockchain");
        }
    }

    /* compiled from: NetworkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/NetworkException$UnsupportedNetworkSwitch;", "Lcom/coinbase/wallet/blockchains/exceptions/NetworkException;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Network;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnsupportedNetworkSwitch extends NetworkException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnsupportedNetworkSwitch(Network network) {
            super(m.o("Unable to switch network ", network), null);
            m.g(network, "network");
        }
    }

    private NetworkException(String str) {
        super(str);
    }

    public /* synthetic */ NetworkException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}