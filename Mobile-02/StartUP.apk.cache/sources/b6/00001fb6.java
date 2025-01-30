package com.coinbase.wallet.features.send.models;

import android.os.Bundle;
import android.os.Parcelable;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.m;

/* compiled from: SendCoinPickerArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J9\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0019\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendCoinPickerArgs;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "initialSelection", "", "walletFilters", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "qrCodeScanResults", "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/util/List;Ljava/util/List;)Landroid/os/Bundle;", "", "EXTRA_FILTERED_WALLETS", "Ljava/lang/String;", "getEXTRA_FILTERED_WALLETS", "()Ljava/lang/String;", "EXTRA_INITIAL_SELECTION", "getEXTRA_INITIAL_SELECTION", "QR_CODE_RESULTS", "getQR_CODE_RESULTS", "kotlin.jvm.PlatformType", "CNAME", "PICKED_WALLET_RESULT", "getPICKED_WALLET_RESULT", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendCoinPickerArgs {
    private static final String CNAME;
    private static final String EXTRA_FILTERED_WALLETS;
    private static final String EXTRA_INITIAL_SELECTION;
    public static final SendCoinPickerArgs INSTANCE = new SendCoinPickerArgs();
    private static final String PICKED_WALLET_RESULT;
    private static final String QR_CODE_RESULTS;

    static {
        String canonicalName = SendCoinPickerArgs.class.getCanonicalName();
        CNAME = canonicalName;
        EXTRA_INITIAL_SELECTION = m.o(canonicalName, ".InitialSelection");
        EXTRA_FILTERED_WALLETS = m.o(canonicalName, ".FilteredWallets");
        QR_CODE_RESULTS = m.o(canonicalName, ".QRCodeScanResult");
        PICKED_WALLET_RESULT = m.o(canonicalName, ".CoinPickerResult");
    }

    private SendCoinPickerArgs() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Bundle createArguments$default(SendCoinPickerArgs sendCoinPickerArgs, Wallet wallet, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            wallet = null;
        }
        if ((i2 & 2) != 0) {
            list = r.g();
        }
        if ((i2 & 4) != 0) {
            list2 = r.g();
        }
        return sendCoinPickerArgs.createArguments(wallet, list, list2);
    }

    public final Bundle createArguments(Wallet wallet, List<Wallet> walletFilters, List<? extends QRCodeScanResult> qrCodeScanResults) {
        m.g(walletFilters, "walletFilters");
        m.g(qrCodeScanResults, "qrCodeScanResults");
        Bundle bundle = new Bundle();
        SendCoinPickerArgs sendCoinPickerArgs = INSTANCE;
        bundle.putParcelable(sendCoinPickerArgs.getEXTRA_INITIAL_SELECTION(), wallet);
        String extra_filtered_wallets = sendCoinPickerArgs.getEXTRA_FILTERED_WALLETS();
        Object[] array = walletFilters.toArray(new Wallet[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        bundle.putParcelableArray(extra_filtered_wallets, (Parcelable[]) array);
        String qr_code_results = sendCoinPickerArgs.getQR_CODE_RESULTS();
        Object[] array2 = qrCodeScanResults.toArray(new QRCodeScanResult[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        bundle.putParcelableArray(qr_code_results, (Parcelable[]) array2);
        return bundle;
    }

    public final String getEXTRA_FILTERED_WALLETS() {
        return EXTRA_FILTERED_WALLETS;
    }

    public final String getEXTRA_INITIAL_SELECTION() {
        return EXTRA_INITIAL_SELECTION;
    }

    public final String getPICKED_WALLET_RESULT() {
        return PICKED_WALLET_RESULT;
    }

    public final String getQR_CODE_RESULTS() {
        return QR_CODE_RESULTS;
    }
}