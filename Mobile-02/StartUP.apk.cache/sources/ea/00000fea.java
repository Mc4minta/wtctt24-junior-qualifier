package com.coinbase.ciphercore.ethereum;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ciphercore.BuildConfig;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: EthereumChain.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b'\b\u0087\u0001\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001'B\u0011\b\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000f\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0011\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0013\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0015\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u0019\u0010\u0019\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R\u0013\u0010\u001c\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000eR\u0013\u0010 \u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000eR\u0015\u0010\"\u001a\u0004\u0018\u00010\f8F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\u000eR\u0013\u0010$\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\u000ej\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:¨\u0006;"}, d2 = {"Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "getRpcUrl", "()Ljava/lang/String;", "rpcUrl", "getDisplayName", "displayName", "getBlockExplorerUrl", "blockExplorerUrl", "", "is1559Enabled", "()Z", "getEtherscanCompatibleTxHistoryApi", "etherscanCompatibleTxHistoryApi", RouteActionKey.RouteActionKeys.CHAIN_ID, "I", "getChainId", "isTestnet", "getBaseAssetCurrencyCode", "baseAssetCurrencyCode", "getBaseAssetDisplayName", "baseAssetDisplayName", "getBaseAssetImageUrl", "baseAssetImageUrl", "getEtherscanLikeApiKey", "etherscanLikeApiKey", "<init>", "(Ljava/lang/String;II)V", "Companion", "ETHEREUM_MAINNET", "OPTIMISM_MAINNET", "POLYGON_MAINNET", "ETHEREUM_CLASSIC_MAINNET", "BSC_MAINNET", "FANTOM_MAINNET", "ARBITRUM_MAINNET", "XDAI_MAINNET", "AVALANCHE_MAINNET", "ROPSTEN", "RINKEBY", "GOERLI", "KOVAN", "OPTIMISM_KOVAN", "POLYGON_TESTNET", "BSC_TESTNET", "FANTOM_TESTNET", "ARBITRUM_TESTNET", "AVALANCHE_FUJI", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public enum EthereumChain implements Parcelable {
    ETHEREUM_MAINNET(1),
    OPTIMISM_MAINNET(10),
    POLYGON_MAINNET(CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA),
    ETHEREUM_CLASSIC_MAINNET(61),
    BSC_MAINNET(56),
    FANTOM_MAINNET(250),
    ARBITRUM_MAINNET(42161),
    XDAI_MAINNET(100),
    AVALANCHE_MAINNET(43114),
    ROPSTEN(3),
    RINKEBY(4),
    GOERLI(5),
    KOVAN(42),
    OPTIMISM_KOVAN(69),
    POLYGON_TESTNET(80001),
    BSC_TESTNET(97),
    FANTOM_TESTNET(4002),
    ARBITRUM_TESTNET(421611),
    AVALANCHE_FUJI(43113);
    
    private final int chainId;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<EthereumChain> CREATOR = new Parcelable.Creator<EthereumChain>() { // from class: com.coinbase.ciphercore.ethereum.EthereumChain.Creator
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EthereumChain createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return EthereumChain.valueOf(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EthereumChain[] newArray(int i2) {
            return new EthereumChain[i2];
        }
    };

    /* compiled from: EthereumChain.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/ciphercore/ethereum/EthereumChain$Companion;", "", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "fromChainId", "(I)Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "<init>", "()V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EthereumChain fromChainId(int i2) {
            EthereumChain ethereumChain = EthereumChain.ETHEREUM_MAINNET;
            if (i2 == ethereumChain.getChainId()) {
                return ethereumChain;
            }
            EthereumChain ethereumChain2 = EthereumChain.OPTIMISM_MAINNET;
            if (i2 == ethereumChain2.getChainId()) {
                return ethereumChain2;
            }
            EthereumChain ethereumChain3 = EthereumChain.POLYGON_MAINNET;
            if (i2 == ethereumChain3.getChainId()) {
                return ethereumChain3;
            }
            EthereumChain ethereumChain4 = EthereumChain.ETHEREUM_CLASSIC_MAINNET;
            if (i2 == ethereumChain4.getChainId()) {
                return ethereumChain4;
            }
            EthereumChain ethereumChain5 = EthereumChain.BSC_MAINNET;
            if (i2 == ethereumChain5.getChainId()) {
                return ethereumChain5;
            }
            EthereumChain ethereumChain6 = EthereumChain.FANTOM_MAINNET;
            if (i2 == ethereumChain6.getChainId()) {
                return ethereumChain6;
            }
            EthereumChain ethereumChain7 = EthereumChain.ARBITRUM_MAINNET;
            if (i2 == ethereumChain7.getChainId()) {
                return ethereumChain7;
            }
            EthereumChain ethereumChain8 = EthereumChain.AVALANCHE_MAINNET;
            if (i2 == ethereumChain8.getChainId()) {
                return ethereumChain8;
            }
            EthereumChain ethereumChain9 = EthereumChain.XDAI_MAINNET;
            if (i2 == ethereumChain9.getChainId()) {
                return ethereumChain9;
            }
            EthereumChain ethereumChain10 = EthereumChain.ROPSTEN;
            if (i2 == ethereumChain10.getChainId()) {
                return ethereumChain10;
            }
            EthereumChain ethereumChain11 = EthereumChain.RINKEBY;
            if (i2 == ethereumChain11.getChainId()) {
                return ethereumChain11;
            }
            EthereumChain ethereumChain12 = EthereumChain.GOERLI;
            if (i2 == ethereumChain12.getChainId()) {
                return ethereumChain12;
            }
            EthereumChain ethereumChain13 = EthereumChain.KOVAN;
            if (i2 == ethereumChain13.getChainId()) {
                return ethereumChain13;
            }
            EthereumChain ethereumChain14 = EthereumChain.OPTIMISM_KOVAN;
            if (i2 == ethereumChain14.getChainId()) {
                return ethereumChain14;
            }
            EthereumChain ethereumChain15 = EthereumChain.POLYGON_TESTNET;
            if (i2 == ethereumChain15.getChainId()) {
                return ethereumChain15;
            }
            EthereumChain ethereumChain16 = EthereumChain.BSC_TESTNET;
            if (i2 == ethereumChain16.getChainId()) {
                return ethereumChain16;
            }
            EthereumChain ethereumChain17 = EthereumChain.FANTOM_TESTNET;
            if (i2 == ethereumChain17.getChainId()) {
                return ethereumChain17;
            }
            EthereumChain ethereumChain18 = EthereumChain.ARBITRUM_TESTNET;
            if (i2 == ethereumChain18.getChainId()) {
                return ethereumChain18;
            }
            EthereumChain ethereumChain19 = EthereumChain.AVALANCHE_FUJI;
            if (i2 == ethereumChain19.getChainId()) {
                return ethereumChain19;
            }
            return null;
        }
    }

    /* compiled from: EthereumChain.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EthereumChain.values().length];
            iArr[EthereumChain.POLYGON_TESTNET.ordinal()] = 1;
            iArr[EthereumChain.POLYGON_MAINNET.ordinal()] = 2;
            iArr[EthereumChain.BSC_MAINNET.ordinal()] = 3;
            iArr[EthereumChain.BSC_TESTNET.ordinal()] = 4;
            iArr[EthereumChain.FANTOM_MAINNET.ordinal()] = 5;
            iArr[EthereumChain.FANTOM_TESTNET.ordinal()] = 6;
            iArr[EthereumChain.XDAI_MAINNET.ordinal()] = 7;
            iArr[EthereumChain.AVALANCHE_MAINNET.ordinal()] = 8;
            iArr[EthereumChain.AVALANCHE_FUJI.ordinal()] = 9;
            iArr[EthereumChain.ETHEREUM_MAINNET.ordinal()] = 10;
            iArr[EthereumChain.OPTIMISM_MAINNET.ordinal()] = 11;
            iArr[EthereumChain.ETHEREUM_CLASSIC_MAINNET.ordinal()] = 12;
            iArr[EthereumChain.ROPSTEN.ordinal()] = 13;
            iArr[EthereumChain.RINKEBY.ordinal()] = 14;
            iArr[EthereumChain.GOERLI.ordinal()] = 15;
            iArr[EthereumChain.KOVAN.ordinal()] = 16;
            iArr[EthereumChain.OPTIMISM_KOVAN.ordinal()] = 17;
            iArr[EthereumChain.ARBITRUM_MAINNET.ordinal()] = 18;
            iArr[EthereumChain.ARBITRUM_TESTNET.ordinal()] = 19;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    EthereumChain(int i2) {
        this.chainId = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getBaseAssetCurrencyCode() {
        String str = "AVAX";
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
                str = "MATIC";
                break;
            case 3:
            case 4:
                str = "BNB";
                break;
            case 5:
            case 6:
                str = "FTM";
                break;
            case 7:
                str = "XDAI";
                break;
            case 8:
            case 9:
                break;
            default:
                str = null;
                break;
        }
        if (str == null) {
            return null;
        }
        Locale US = Locale.US;
        m.f(US, "US");
        String upperCase = str.toUpperCase(US);
        m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public final String getBaseAssetDisplayName() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "Testnet Matic";
            case 2:
                return "Matic";
            case 3:
            case 4:
                return "BNB";
            case 5:
            case 6:
                return "FTM";
            case 7:
                return "xDai";
            case 8:
                return "AVAX";
            case 9:
                return "Testnet AVAX";
            case 10:
                return "Ethereum";
            case 11:
                return "Optimistic Ethereum";
            case 12:
                return "Ethereum Classic";
            case 13:
                return "Ropsten Ethereum";
            case 14:
                return "Rinkeby Ethereum";
            case 15:
                return "Görli Ethereum";
            case 16:
                return "Kovan Ethereum";
            case 17:
                return "Optimistic Kovan";
            case 18:
                return "Arbitrum ETH";
            case 19:
                return "Arbitrum Testnet ETH";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String getBaseAssetImageUrl() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
                return "https://wallet-api-production.s3.amazonaws.com/uploads/b474d4bf3af389e5f26ed66956f1da8a/maticLogo.png";
            case 3:
            case 4:
                return "https://wallet-api-production.s3.amazonaws.com/uploads/e12b5eaa48ec08814f6b81c68e1b3fc7/bnb_logo.png";
            case 5:
            case 6:
                return "https://wallet-api-production.s3.amazonaws.com/uploads/ddbcf362d2717855adb007691745b83f/ftm_logo.png";
            case 7:
                return "https://wallet-api-production.s3.amazonaws.com/uploads/0cea7ffb3d2ab10b1f55afc83629b7a0/xdai_logo.png";
            case 8:
            case 9:
                return "https://wallet-api-production.s3.amazonaws.com/uploads/889d119cede59f72d7dae9132b2d35fc/avax_logo.png";
            default:
                return null;
        }
    }

    public final String getBlockExplorerUrl() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "https://explorer-mumbai.maticvigil.com";
            case 2:
                return "https://polygonscan.com";
            case 3:
                return "https://bscscan.com";
            case 4:
                return "https://testnet.bscscan.com";
            case 5:
                return "https://ftmscan.com";
            case 6:
                return "https://testnet.ftmscan.com";
            case 7:
                return "https://blockscout.com/xdai/mainnet";
            case 8:
                return "https://avascan.info/blockchain/c";
            case 9:
                return "https://testnet.avascan.info";
            case 10:
                return "https://etherscan.io";
            case 11:
                return "https://optimistic.etherscan.io";
            case 12:
            default:
                throw new IllegalStateException("Unsupported Ethereum network.");
            case 13:
                return "https://ropsten.etherscan.io";
            case 14:
                return "https://rinkeby.etherscan.io";
            case 15:
                return "https://goerli.etherscan.io";
            case 16:
                return "https://kovan.etherscan.io";
            case 17:
                return "https://kovan-optimistic.etherscan.io";
            case 18:
                return "https://explorer.arbitrum.io";
            case 19:
                return "https://rinkeby-explorer.arbitrum.io";
        }
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final String getDisplayName() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "Polygon Mumbai";
            case 2:
                return "Polygon";
            case 3:
                return "Binance Smart Chain";
            case 4:
                return "Binance Smart Chain Testnet";
            case 5:
                return "Fantom Opera";
            case 6:
                return "Fantom Testnet";
            case 7:
                return "xDai";
            case 8:
                return "Avalanche C-Chain";
            case 9:
                return "Avalanche Fuji";
            case 10:
                return "Ethereum";
            case 11:
                return "Optimism";
            case 12:
                return "Ethereum Classic";
            case 13:
                return "Ropsten";
            case 14:
                return "Rinkeby";
            case 15:
                return "Görli";
            case 16:
                return "Kovan";
            case 17:
                return "Optimistic Kovan";
            case 18:
                return "Arbitrum";
            case 19:
                return "Arbitrum Rinkeby";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String getEtherscanCompatibleTxHistoryApi() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "https://explorer-mumbai.maticvigil.com";
            case 2:
                return "https://api.polygonscan.com";
            case 3:
                return "https://api.bscscan.com";
            case 4:
                return "https://api-testnet.bscscan.com";
            case 5:
                return "https://api.ftmscan.com";
            case 6:
                return "https://api-testnet.ftmscan.com";
            case 7:
                return "https://blockscout.com/xdai/mainnet/api";
            case 8:
                return "https://avalanche.etherscan.io";
            case 9:
                return "https://avalanche-fuji.etherscan.io";
            case 10:
                return "https://mainnet-etherscan.wallet.coinbase.com";
            case 11:
                return "https://optimism-etherscan.wallet.coinbase.com";
            case 12:
            default:
                throw new IllegalStateException(m.o("no etherscan api for chainId ", Integer.valueOf(this.chainId)));
            case 13:
                return "https://ropsten-etherscan.wallet.coinbase.com";
            case 14:
                return "https://rinkeby-etherscan.wallet.coinbase.com";
            case 15:
                return "https://goerli-etherscan.wallet.coinbase.com";
            case 16:
                return "https://kovan-etherscan.wallet.coinbase.com";
            case 17:
                return "https://kovan-optimistic.etherscan.io";
            case 18:
                return "https://api.arbiscan.io";
            case 19:
                return "https://testnet.arbiscan.io";
        }
    }

    public final String getEtherscanLikeApiKey() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
                return BuildConfig.POLYGONSCAN_API_KEY;
            case 3:
            case 4:
                return BuildConfig.BSCSCAN_API_KEY;
            case 5:
            case 6:
                return BuildConfig.FANTOMSCAN_API_KEY;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                return BuildConfig.ETHERSCAN_API_KEY;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String getRpcUrl() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "https://polygon-mumbai-infura.wallet.coinbase.com";
            case 2:
                return "https://polygon-mainnet-infura.wallet.coinbase.com";
            case 3:
                return "https://bsc-dataseed.binance.org";
            case 4:
                return "https://data-seed-prebsc-1-s1.binance.org:8545";
            case 5:
                return "https://rpcapi.fantom.network";
            case 6:
                return "https://rpc.testnet.fantom.network";
            case 7:
                return "https://rpc.xdaichain.com";
            case 8:
                return "https://api.avax.network/ext/bc/C/rpc";
            case 9:
                return "https://api.avax-test.network/ext/bc/C/rpc";
            case 10:
                return "https://mainnet-infura.wallet.coinbase.com";
            case 11:
                return "https://optimism-mainnet.wallet.coinbase.com";
            case 12:
            default:
                throw new IllegalStateException(m.o("no node url exists for chainId ", Integer.valueOf(this.chainId)));
            case 13:
                return "https://ropsten-infura.wallet.coinbase.com";
            case 14:
                return "https://rinkeby-infura.wallet.coinbase.com";
            case 15:
                return "https://goerli-node.wallet.coinbase.com";
            case 16:
                return "https://kovan-infura.wallet.coinbase.com";
            case 17:
                return "https://optimism-node.wallet.coinbase.com";
            case 18:
                return "https://arb-mainnet.g.alchemy.com/v2/scDo-T8pbpkEy1qiGC75FnM1jVJmQQr4";
            case 19:
                return "https://rinkeby.arbitrum.io/rpc";
        }
    }

    public final boolean is1559Enabled() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        return i2 == 10 || i2 == 13;
    }

    public final boolean isTestnet() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 4:
            case 6:
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
                return true;
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 18:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(name());
    }
}