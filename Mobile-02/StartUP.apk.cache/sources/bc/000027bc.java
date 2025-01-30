package com.coinbase.wallet.txhistory.views;

import androidx.lifecycle.b0;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.utilities.Colors;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.txhistory.R;
import com.coinbase.wallet.txhistory.daos.TxHistoryDAO;
import com.coinbase.wallet.txhistory.models.ReceiptCellViewState;
import com.coinbase.wallet.txhistory.models.RecipientType;
import com.coinbase.wallet.txhistory.models.TxHistoryDetail;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import h.c.m0.p;
import h.c.s;
import h.c.t0.g;
import h.c.v0.c;
import java.math.BigInteger;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;
import org.apache.http.HttpStatus;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: TxHistoryDetailViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\bJ\u0010KJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000ej\u0002`\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011JY\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001eH\u0014¢\u0006\u0004\b%\u0010\"R$\u0010(\u001a\u0010\u0012\f\u0012\n '*\u0004\u0018\u00010\u00160\u00160&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010*R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010+R\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u00105R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00101R\u001f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00070,8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010.\u001a\u0004\bC\u00100R$\u0010E\u001a\u0010\u0012\f\u0012\n '*\u0004\u0018\u00010\u00070\u00070D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u00105R\u0016\u0010\u0018\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010>¨\u0006L"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailViewModel;", "Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "tx", "", "cryptoAmount", "fiatAmount", "Lcom/coinbase/wallet/txhistory/models/TxHistoryDetail;", "txInformation", "(Lcom/coinbase/wallet/blockchains/models/Transaction;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/txhistory/models/TxHistoryDetail;", "", "Lcom/coinbase/wallet/txhistory/models/ReceiptCellViewState;", "cellViewStates", "(Lcom/coinbase/wallet/blockchains/models/Transaction;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Lkotlin/o;", "Lcom/coinbase/wallet/txhistory/views/FormattedAmounts;", "formattedAmounts", "(Lcom/coinbase/wallet/blockchains/models/Transaction;)Lkotlin/o;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "", "walletDecimals", "Ljava/net/URL;", "walletImageUrl", "feeDecimals", "feeWalletImageUrl", "displayName", "displayAddress", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "recipientType", "Lkotlin/x;", "init", "(Lcom/coinbase/wallet/blockchains/models/Transaction;Lcom/coinbase/wallet/blockchains/models/Blockchain;ILjava/net/URL;ILjava/net/URL;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;)V", "didTapViewButton", "()V", "updateTxInfo", "(Lcom/coinbase/wallet/blockchains/models/Transaction;)V", "onCleared", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "presentViewSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "Lh/c/s;", "presentViewObservable", "Lh/c/s;", "getPresentViewObservable", "()Lh/c/s;", "Ljava/net/URL;", "Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "txHistoryDAO", "Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "Ljava/lang/String;", "Ljava/util/List;", "getCellViewStates", "()Ljava/util/List;", "setCellViewStates", "(Ljava/util/List;)V", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "I", "Ljava/text/SimpleDateFormat;", "dateFormatter", "Ljava/text/SimpleDateFormat;", "stateObservable", "getStateObservable", "Lh/c/v0/c;", "stateSubject", "Lh/c/v0/c;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "<init>", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryDetailViewModel extends b0 {
    private Blockchain blockchain;
    private List<ReceiptCellViewState> cellViewStates;
    private final CurrencyFormatter currencyFormatter;
    private final SimpleDateFormat dateFormatter;
    private String displayAddress;
    private String displayName;
    private final h.c.k0.a disposeBag;
    private int feeDecimals;
    private URL feeWalletImageUrl;
    private final s<URL> presentViewObservable;
    private final h.c.v0.b<URL> presentViewSubject;
    private RecipientType recipientType;
    private final s<TxHistoryDetail> stateObservable;
    private final c<TxHistoryDetail> stateSubject;
    private final TxHistoryDAO txHistoryDAO;
    private int walletDecimals;
    private URL walletImageUrl;

    /* compiled from: TxHistoryDetailViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TxState.values().length];
            iArr[TxState.PENDING.ordinal()] = 1;
            iArr[TxState.CONFIRMED.ordinal()] = 2;
            iArr[TxState.FAILED.ordinal()] = 3;
            iArr[TxState.DROPPED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TxHistoryDetailViewModel(CurrencyFormatter currencyFormatter, TxHistoryDAO txHistoryDAO) {
        List<ReceiptCellViewState> g2;
        m.g(currencyFormatter, "currencyFormatter");
        m.g(txHistoryDAO, "txHistoryDAO");
        this.currencyFormatter = currencyFormatter;
        this.txHistoryDAO = txHistoryDAO;
        this.dateFormatter = new SimpleDateFormat("MMM dd", Locale.getDefault());
        this.walletDecimals = -1;
        this.feeDecimals = -1;
        g2 = r.g();
        this.cellViewStates = g2;
        c<TxHistoryDetail> d2 = c.d(1);
        m.f(d2, "createWithSize<TxHistoryDetail>(1)");
        this.stateSubject = d2;
        h.c.v0.b<URL> d3 = h.c.v0.b.d();
        m.f(d3, "create<URL>()");
        this.presentViewSubject = d3;
        this.disposeBag = new h.c.k0.a();
        s<TxHistoryDetail> hide = d2.hide();
        m.f(hide, "stateSubject.hide()");
        this.stateObservable = hide;
        s<URL> hide2 = d3.hide();
        m.f(hide2, "presentViewSubject.hide()");
        this.presentViewObservable = hide2;
    }

    public static /* synthetic */ boolean a(Transaction transaction, Transaction transaction2) {
        return m1789init$lambda0(transaction, transaction2);
    }

    private final List<ReceiptCellViewState> cellViewStates(Transaction transaction, String str, String str2) {
        String formatToFiatRange;
        String formatToCryptoRange;
        o a;
        List<ReceiptCellViewState> j2;
        boolean z = str2 != null;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        ReceiptCellViewState receiptCellViewState = new ReceiptCellViewState(localizedStrings.get(R.string.confirmation_amount), null, str2 == null ? str : str2, !z ? this.walletImageUrl : null, z ? str : null, z ? this.walletImageUrl : null, null, false, CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256, null);
        CurrencyFormatter currencyFormatter = this.currencyFormatter;
        CurrencyCode feeCurrencyCode = transaction.getFeeCurrencyCode();
        int i2 = this.feeDecimals;
        BigInteger lowerBoundFee = transaction.getLowerBoundFee();
        BigInteger fee = transaction.getFee();
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(transaction.getNetwork());
        formatToFiatRange = currencyFormatter.formatToFiatRange(feeCurrencyCode, null, i2, lowerBoundFee, fee, (r20 & 32) != 0 ? false : false, (r20 & 64) != 0 ? null : null, (r20 & 128) != 0 ? null : asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()));
        formatToCryptoRange = this.currencyFormatter.formatToCryptoRange(transaction.getFeeCurrencyCode(), this.feeDecimals, transaction.getLowerBoundFee(), transaction.getFee(), (r17 & 16) != 0, (r17 & 32) != 0 ? 4 : 0, (r17 & 64) != 0 ? 0 : 0);
        ReceiptCellViewState receiptCellViewState2 = new ReceiptCellViewState(localizedStrings.get(R.string.confirmation_estimated_network_fees), null, formatToFiatRange, null, formatToCryptoRange, this.feeWalletImageUrl, null, false, HttpStatus.SC_ACCEPTED, null);
        int i3 = WhenMappings.$EnumSwitchMapping$0[transaction.getState().ordinal()];
        if (i3 == 1) {
            a = u.a(localizedStrings.get(R.string.transaction_header_pending), this.dateFormatter.format(transaction.getCreatedAt()));
        } else if (i3 == 2) {
            String str3 = localizedStrings.get(R.string.transaction_header_complete);
            SimpleDateFormat simpleDateFormat = this.dateFormatter;
            Date confirmedAt = transaction.getConfirmedAt();
            if (confirmedAt == null) {
                confirmedAt = transaction.getCreatedAt();
            }
            a = u.a(str3, simpleDateFormat.format(confirmedAt));
        } else if (i3 != 3 && i3 != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            a = u.a(localizedStrings.get(R.string.transaction_header_failed), this.dateFormatter.format(transaction.getCreatedAt()));
        }
        j2 = r.j(receiptCellViewState, receiptCellViewState2, new ReceiptCellViewState((String) a.a(), null, (String) a.b(), null, null, null, transaction.getState() == TxState.FAILED ? Integer.valueOf(Colors.INSTANCE.getErrorColor()) : null, false, CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, null));
        return j2;
    }

    private final o<String, String> formattedAmounts(Transaction transaction) {
        String formatToFiat;
        CurrencyFormatter currencyFormatter = this.currencyFormatter;
        CurrencyCode currencyCode = transaction.getCurrencyCode();
        int i2 = this.walletDecimals;
        BigInteger amount = transaction.getAmount();
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(transaction.getNetwork());
        formatToFiat = currencyFormatter.formatToFiat(currencyCode, null, i2, amount, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()));
        return u.a(CurrencyFormatter.formatToCrypto$default(this.currencyFormatter, transaction.getCurrencyCode(), this.walletDecimals, transaction.getAmount(), false, 0, 0, 56, (Object) null), formatToFiat);
    }

    /* renamed from: init$lambda-0 */
    public static final boolean m1789init$lambda0(Transaction tx, Transaction it) {
        m.g(tx, "$tx");
        m.g(it, "it");
        return m.c(it.getId(), tx.getId());
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.coinbase.wallet.txhistory.models.TxHistoryDetail txInformation(com.coinbase.wallet.blockchains.models.Transaction r16, java.lang.String r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.views.TxHistoryDetailViewModel.txInformation(com.coinbase.wallet.blockchains.models.Transaction, java.lang.String, java.lang.String):com.coinbase.wallet.txhistory.models.TxHistoryDetail");
    }

    public final void didTapViewButton() {
        h.c.t0.a.a(g.i(Observable_CoreKt.takeSingle(this.stateObservable), null, new TxHistoryDetailViewModel$didTapViewButton$1(this), 1, null), this.disposeBag);
    }

    public final List<ReceiptCellViewState> getCellViewStates() {
        return this.cellViewStates;
    }

    public final s<URL> getPresentViewObservable() {
        return this.presentViewObservable;
    }

    public final s<TxHistoryDetail> getStateObservable() {
        return this.stateObservable;
    }

    public final void init(final Transaction tx, Blockchain blockchain, int i2, URL url, int i3, URL url2, String displayName, String displayAddress, RecipientType recipientType) {
        m.g(tx, "tx");
        m.g(blockchain, "blockchain");
        m.g(displayName, "displayName");
        m.g(displayAddress, "displayAddress");
        m.g(recipientType, "recipientType");
        this.recipientType = recipientType;
        this.displayName = displayName;
        this.displayAddress = displayAddress;
        this.blockchain = blockchain;
        this.walletDecimals = i2;
        this.walletImageUrl = url;
        this.feeDecimals = i3;
        this.feeWalletImageUrl = url2;
        updateTxInfo(tx);
        s<Transaction> filter = this.txHistoryDAO.getHistoryUpdatedObservable().filter(new p() { // from class: com.coinbase.wallet.txhistory.views.a
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return TxHistoryDetailViewModel.a(Transaction.this, (Transaction) obj);
            }
        });
        m.f(filter, "txHistoryDAO.historyUpdatedObservable\n            .filter { it.id == tx.id }");
        h.c.t0.a.a(g.h(filter, null, null, new TxHistoryDetailViewModel$init$2(this), 3, null), this.disposeBag);
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void setCellViewStates(List<ReceiptCellViewState> list) {
        m.g(list, "<set-?>");
        this.cellViewStates = list;
    }

    public final void updateTxInfo(Transaction tx) {
        m.g(tx, "tx");
        o<String, String> formattedAmounts = formattedAmounts(tx);
        this.cellViewStates = cellViewStates(tx, formattedAmounts.c(), formattedAmounts.d());
        this.stateSubject.onNext(txInformation(tx, formattedAmounts.c(), formattedAmounts.d()));
    }
}