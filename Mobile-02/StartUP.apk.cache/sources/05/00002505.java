package com.coinbase.wallet.qr.di;

import com.coinbase.wallet.qr.models.WalletConstants;
import com.coinbase.wallet.qr.parsers.BitcoinCashQrCodeParser;
import com.coinbase.wallet.qr.parsers.BitcoinQrCodeParser;
import com.coinbase.wallet.qr.parsers.DogecoinQrCodeParser;
import com.coinbase.wallet.qr.parsers.ERC20QRCodeParser;
import com.coinbase.wallet.qr.parsers.EthereumClassicQrCodeParser;
import com.coinbase.wallet.qr.parsers.EthereumQrCodeParser;
import com.coinbase.wallet.qr.parsers.HexStringFixedLengthQrCodeParser;
import com.coinbase.wallet.qr.parsers.LitecoinQrCodeParser;
import com.coinbase.wallet.qr.parsers.QRCodeIntentParser;
import com.coinbase.wallet.qr.parsers.StellarQrCodeParser;
import com.coinbase.wallet.qr.parsers.UnsignedIntegerQrCodeParser;
import com.coinbase.wallet.qr.parsers.Utf8StringFixedLengthQrCodeParser;
import com.coinbase.wallet.qr.parsers.WalletLinkQrParser;
import com.coinbase.wallet.qr.parsers.XRPQrCodeParser;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: QrCodeParsersModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b7\u00108J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H'¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H'¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+H'¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H'¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203H'¢\u0006\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/coinbase/wallet/qr/di/QrCodeParsersModule;", "", "Lcom/coinbase/wallet/qr/parsers/EthereumQrCodeParser;", "ethereumQrCodeParser", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", WalletConstants.URIPrefixes.ETH, "(Lcom/coinbase/wallet/qr/parsers/EthereumQrCodeParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "Lcom/coinbase/wallet/qr/parsers/EthereumClassicQrCodeParser;", "ethereumClassicQrCodeParser", "ethereumClassic", "(Lcom/coinbase/wallet/qr/parsers/EthereumClassicQrCodeParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "Lcom/coinbase/wallet/qr/parsers/ERC20QRCodeParser;", "erc20QrCodeParser", "erc20", "(Lcom/coinbase/wallet/qr/parsers/ERC20QRCodeParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "Lcom/coinbase/wallet/qr/parsers/StellarQrCodeParser;", "stellarQrCodeParser", WalletConstants.URIPrefixes.XLM_ALT, "(Lcom/coinbase/wallet/qr/parsers/StellarQrCodeParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "Lcom/coinbase/wallet/qr/parsers/XRPQrCodeParser;", "xrpQrParser", WalletConstants.URIPrefixes.XRP_ALT, "(Lcom/coinbase/wallet/qr/parsers/XRPQrCodeParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "Lcom/coinbase/wallet/qr/parsers/BitcoinQrCodeParser;", "bitcoinQrCodeParser", "bitcoin", "(Lcom/coinbase/wallet/qr/parsers/BitcoinQrCodeParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "Lcom/coinbase/wallet/qr/parsers/BitcoinCashQrCodeParser;", "bitcoinCashQrCodeParser", "bitcoinCash", "(Lcom/coinbase/wallet/qr/parsers/BitcoinCashQrCodeParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "Lcom/coinbase/wallet/qr/parsers/LitecoinQrCodeParser;", "litecoinQrCodeParser", "litecoin", "(Lcom/coinbase/wallet/qr/parsers/LitecoinQrCodeParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "Lcom/coinbase/wallet/qr/parsers/DogecoinQrCodeParser;", "dogecoinQrCodeParser", "dogecoin", "(Lcom/coinbase/wallet/qr/parsers/DogecoinQrCodeParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "Lcom/coinbase/wallet/qr/parsers/Utf8StringFixedLengthQrCodeParser;", "utf8StringFixedLengthQrCodeParser", "utf8", "(Lcom/coinbase/wallet/qr/parsers/Utf8StringFixedLengthQrCodeParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "Lcom/coinbase/wallet/qr/parsers/HexStringFixedLengthQrCodeParser;", "hexStringFixedLengthQrCodeParser", "hexString", "(Lcom/coinbase/wallet/qr/parsers/HexStringFixedLengthQrCodeParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "Lcom/coinbase/wallet/qr/parsers/UnsignedIntegerQrCodeParser;", "unsignedIntegerQrCodeParser", "unsignedInt", "(Lcom/coinbase/wallet/qr/parsers/UnsignedIntegerQrCodeParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "Lcom/coinbase/wallet/qr/parsers/WalletLinkQrParser;", "walletLinkQrCodeParser", "walletLink", "(Lcom/coinbase/wallet/qr/parsers/WalletLinkQrParser;)Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "<init>", "()V", "Companion", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class QrCodeParsersModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: QrCodeParsersModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u001a\u0010\u0005\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/qr/di/QrCodeParsersModule$Companion;", "", "", "Ljava/lang/Class;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "map", "", "providesQrParsers", "(Ljava/util/Map;)Ljava/util/Set;", "<init>", "()V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<QRCodeIntentParser> providesQrParsers(Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser> map) {
            Set<QRCodeIntentParser> M0;
            m.g(map, "map");
            M0 = z.M0(map.values());
            return M0;
        }
    }

    public static final Set<QRCodeIntentParser> providesQrParsers(Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser> map) {
        return Companion.providesQrParsers(map);
    }

    @QrParserMapKey(BitcoinQrCodeParser.class)
    public abstract QRCodeIntentParser bitcoin(BitcoinQrCodeParser bitcoinQrCodeParser);

    @QrParserMapKey(BitcoinCashQrCodeParser.class)
    public abstract QRCodeIntentParser bitcoinCash(BitcoinCashQrCodeParser bitcoinCashQrCodeParser);

    @QrParserMapKey(DogecoinQrCodeParser.class)
    public abstract QRCodeIntentParser dogecoin(DogecoinQrCodeParser dogecoinQrCodeParser);

    @QrParserMapKey(ERC20QRCodeParser.class)
    public abstract QRCodeIntentParser erc20(ERC20QRCodeParser eRC20QRCodeParser);

    @QrParserMapKey(EthereumQrCodeParser.class)
    public abstract QRCodeIntentParser ethereum(EthereumQrCodeParser ethereumQrCodeParser);

    @QrParserMapKey(EthereumClassicQrCodeParser.class)
    public abstract QRCodeIntentParser ethereumClassic(EthereumClassicQrCodeParser ethereumClassicQrCodeParser);

    @QrParserMapKey(HexStringFixedLengthQrCodeParser.class)
    public abstract QRCodeIntentParser hexString(HexStringFixedLengthQrCodeParser hexStringFixedLengthQrCodeParser);

    @QrParserMapKey(LitecoinQrCodeParser.class)
    public abstract QRCodeIntentParser litecoin(LitecoinQrCodeParser litecoinQrCodeParser);

    @QrParserMapKey(StellarQrCodeParser.class)
    public abstract QRCodeIntentParser stellar(StellarQrCodeParser stellarQrCodeParser);

    @QrParserMapKey(UnsignedIntegerQrCodeParser.class)
    public abstract QRCodeIntentParser unsignedInt(UnsignedIntegerQrCodeParser unsignedIntegerQrCodeParser);

    @QrParserMapKey(Utf8StringFixedLengthQrCodeParser.class)
    public abstract QRCodeIntentParser utf8(Utf8StringFixedLengthQrCodeParser utf8StringFixedLengthQrCodeParser);

    @QrParserMapKey(WalletLinkQrParser.class)
    public abstract QRCodeIntentParser walletLink(WalletLinkQrParser walletLinkQrParser);

    @QrParserMapKey(XRPQrCodeParser.class)
    public abstract QRCodeIntentParser xrp(XRPQrCodeParser xRPQrCodeParser);
}