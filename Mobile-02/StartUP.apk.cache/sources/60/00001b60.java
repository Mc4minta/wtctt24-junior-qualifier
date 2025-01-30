package com.coinbase.wallet.di;

import android.net.Uri;
import com.coinbase.wallet.core.extensions.Map_CoreKt;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendAmountPickerViewModel;
import com.coinbase.wallet.qr.parsers.EthereumQrCodeParser;
import com.coinbase.wallet.qr.parsers.QRCodeIntentParser;
import com.coinbase.wallet.routing.models.EthereumPaymentRouteAction;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.util.Map;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.u;
import org.toshi.R;

/* compiled from: RouteActionModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/net/Uri;", "uri", "Lcom/coinbase/wallet/routing/models/EthereumPaymentRouteAction;", "<anonymous>", "(Landroid/net/Uri;)Lcom/coinbase/wallet/routing/models/EthereumPaymentRouteAction;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class RouteActionModule$providesPaymentRouteActions$ethereumPaymentRouteAction$1 extends o implements l<Uri, EthereumPaymentRouteAction> {
    final /* synthetic */ Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser> $parsers;
    final /* synthetic */ IWalletRepository $walletRepository;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteActionModule$providesPaymentRouteActions$ethereumPaymentRouteAction$1(Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser> map, IWalletRepository iWalletRepository) {
        super(1);
        this.$parsers = map;
        this.$walletRepository = iWalletRepository;
    }

    @Override // kotlin.e0.c.l
    public final EthereumPaymentRouteAction invoke(Uri uri) {
        m.g(uri, "uri");
        return new EthereumPaymentRouteAction((QRCodeIntentParser) Map_CoreKt.require(this.$parsers, EthereumQrCodeParser.class), uri, u.a(AmountPickerViewModel.class.getName(), SendAmountPickerViewModel.class), this.$walletRepository, R.id.action_walletFragment_to_sendDestinationPickerFragment, R.id.action_walletFragment_to_sendAmountPickerFragment);
    }
}