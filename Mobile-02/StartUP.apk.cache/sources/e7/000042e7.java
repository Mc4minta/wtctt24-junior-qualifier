package com.toshi.view.fragment;

import android.os.Bundle;
import com.coinbase.wallet.application.extensions.BigInteger_ApplicationKt;
import com.coinbase.wallet.bitcoin.extensions.AddressKind_BitcoinKt;
import com.coinbase.wallet.bitcoin.extensions.CurrencyCode_BitcoinKt;
import com.coinbase.wallet.bitcoincash.extensions.AddressKind_BitcoinCashKt;
import com.coinbase.wallet.bitcoincash.extensions.CurrencyCode_BitcoinCashKt;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.dogecoin.extensions.AddressKind_DogecoinKt;
import com.coinbase.wallet.dogecoin.extensions.CurrencyCode_DogecoinKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.litecoin.extensions.AddressKind_LitecoinKt;
import com.coinbase.wallet.litecoin.extensions.CurrencyCode_LitecoinKt;
import com.coinbase.wallet.qr.models.WalletConstants;
import com.coinbase.wallet.ripple.extensions.CurrencyCode_RippleKt;
import com.coinbase.wallet.stellar.extensions.CurrencyCode_StellarKt;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.toshi.model.local.room.Prompt;
import com.toshi.view.fragment.DisplayCoinAddressFragment;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import org.toshi.R;

/* compiled from: DisplayCoinAddressFragmentFactory.kt */
@ApplicationScoped
/* loaded from: classes2.dex */
public final class h0 {
    private final Moshi a;

    public h0(Moshi moshi) {
        kotlin.jvm.internal.m.g(moshi, "moshi");
        this.a = moshi;
    }

    private final String b(DisplayCoinAddressFragment.DisplayCoinAddress[] displayCoinAddressArr) {
        List e0;
        JsonAdapter adapter = this.a.adapter(Types.newParameterizedType(List.class, DisplayCoinAddressFragment.DisplayCoinAddress.class));
        e0 = kotlin.a0.n.e0(displayCoinAddressArr);
        String json = adapter.toJson(e0);
        kotlin.jvm.internal.m.f(json, "adapter.toJson(addresses.toList())");
        return json;
    }

    private final Bundle d(DisplayCoinAddressFragment.DisplayCoinAddress[] displayCoinAddressArr, String str, Prompt prompt, Integer num, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_ADDRESS", b(displayCoinAddressArr));
        bundle.putString("EXTRA_CRYPTO", str);
        if (num != null) {
            num.intValue();
            bundle.putInt("EXTRA_PROMPT_MESSAGE", num.intValue());
        }
        bundle.putBoolean("EXTRA_IS_PROMPT_WARNING", z);
        if (prompt != null) {
            bundle.putString("EXTRA_PROMPT", n(prompt));
        }
        return bundle;
    }

    static /* synthetic */ Bundle e(h0 h0Var, DisplayCoinAddressFragment.DisplayCoinAddress[] displayCoinAddressArr, String str, Prompt prompt, Integer num, boolean z, int i2, Object obj) {
        Prompt prompt2 = (i2 & 4) != 0 ? null : prompt;
        Integer num2 = (i2 & 8) != 0 ? null : num;
        if ((i2 & 16) != 0) {
            z = false;
        }
        return h0Var.d(displayCoinAddressArr, str, prompt2, num2, z);
    }

    private final Bundle f(List<WalletAddress> list) {
        Object obj;
        Object obj2;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.m.c(((WalletAddress) obj).getType(), AddressKind_BitcoinKt.getBitcoinSegWit(AddressType.Companion))) {
                break;
            }
        }
        WalletAddress walletAddress = (WalletAddress) obj;
        String address = walletAddress == null ? null : walletAddress.getAddress();
        if (address != null) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (kotlin.jvm.internal.m.c(((WalletAddress) obj2).getType(), AddressKind_BitcoinKt.getBitcoinLegacy(AddressType.Companion))) {
                    break;
                }
            }
            WalletAddress walletAddress2 = (WalletAddress) obj2;
            String address2 = walletAddress2 != null ? walletAddress2.getAddress() : null;
            if (address2 != null) {
                return e(this, new DisplayCoinAddressFragment.DisplayCoinAddress[]{new DisplayCoinAddressFragment.DisplayCoinAddress(address, kotlin.jvm.internal.m.o("bitcoin:", address), Integer.valueOf((int) R.string.segwit), R.string.copy_segwit_address), new DisplayCoinAddressFragment.DisplayCoinAddress(address2, kotlin.jvm.internal.m.o("bitcoin:", address2), Integer.valueOf((int) R.string.legacy), R.string.copy_legacy_address)}, CurrencyCode_BitcoinKt.getBTC(CurrencyCode.Companion).getRawValue(), new Prompt(Prompt.Id.BTC_SEGWIT_LEGACY_ADDRESS, R.string.info_did_you_know_btc_title, R.string.info_did_you_know_btc_desc, null, Integer.valueOf((int) R.drawable.info_did_you_know_btc), null, null, null, 232, null), null, false, 24, null);
            }
            throw new IllegalStateException("Couldn't get value for legacy address");
        }
        throw new IllegalStateException("Couldn't get value for segwit address");
    }

    private final Bundle g(List<WalletAddress> list, Wallet wallet) {
        Boolean bool;
        Object obj;
        Object obj2;
        Network network;
        Iterator<T> it = list.iterator();
        while (true) {
            bool = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.m.c(((WalletAddress) obj).getType(), AddressKind_BitcoinCashKt.getBitcoinCashAddr(AddressType.Companion))) {
                break;
            }
        }
        WalletAddress walletAddress = (WalletAddress) obj;
        String address = walletAddress == null ? null : walletAddress.getAddress();
        if (address != null) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (kotlin.jvm.internal.m.c(((WalletAddress) obj2).getType(), AddressKind_BitcoinCashKt.getBitcoinCashLegacy(AddressType.Companion))) {
                    break;
                }
            }
            WalletAddress walletAddress2 = (WalletAddress) obj2;
            String address2 = walletAddress2 == null ? null : walletAddress2.getAddress();
            if (address2 != null) {
                if (wallet != null && (network = wallet.getNetwork()) != null) {
                    bool = Boolean.valueOf(network.isTestnet());
                }
                if (bool != null) {
                    return e(this, new DisplayCoinAddressFragment.DisplayCoinAddress[]{new DisplayCoinAddressFragment.DisplayCoinAddress(address, address, Integer.valueOf((int) R.string.cashaddr), R.string.copy_cashaddr_address), new DisplayCoinAddressFragment.DisplayCoinAddress(address2, (bool.booleanValue() ? WalletConstants.URIPrefixes.Testnet.BCH : WalletConstants.URIPrefixes.BCH) + ':' + address2, Integer.valueOf((int) R.string.legacy), R.string.copy_legacy_address)}, CurrencyCode_BitcoinCashKt.getBCH(CurrencyCode.Companion).getRawValue(), new Prompt(Prompt.Id.BCH_CASHADDR_LEGACY_ADDRESS, R.string.info_did_you_know_bch_title, R.string.info_did_you_know_bch_desc, null, Integer.valueOf((int) R.drawable.info_did_you_know_bch), null, null, null, 232, null), null, false, 24, null);
                }
                throw new IllegalStateException("Wallet must not be null for bch");
            }
            throw new IllegalStateException("Couldn't get value for legacy address");
        }
        throw new IllegalStateException("Couldn't get value for cashaddr address");
    }

    private final Bundle h(List<WalletAddress> list) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.m.c(((WalletAddress) obj).getType(), AddressKind_DogecoinKt.getDogecoin(AddressType.Companion))) {
                break;
            }
        }
        WalletAddress walletAddress = (WalletAddress) obj;
        String address = walletAddress != null ? walletAddress.getAddress() : null;
        if (address != null) {
            return e(this, new DisplayCoinAddressFragment.DisplayCoinAddress[]{new DisplayCoinAddressFragment.DisplayCoinAddress(address, kotlin.jvm.internal.m.o("dogecoin:", address), null, R.string.copy, 4, null)}, CurrencyCode_DogecoinKt.getDOGE(CurrencyCode.Companion).getRawValue(), null, null, false, 28, null);
        }
        throw new IllegalStateException("Couldn't get value for segwit address");
    }

    private final Bundle i(String str, CurrencyCode currencyCode, Blockchain blockchain) {
        return e(this, new DisplayCoinAddressFragment.DisplayCoinAddress[]{new DisplayCoinAddressFragment.DisplayCoinAddress(str, kotlin.jvm.internal.m.o("ethereum:", str), null, R.string.copy, 4, null)}, currencyCode.getRawValue(), (!kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) || kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion))) ? null : new Prompt(Prompt.Id.ERC20_ADDRESS_INFO, R.string.info_did_you_know_erc20_title, R.string.info_did_you_know_erc20_desc, null, Integer.valueOf((int) R.drawable.illustration_celebrate), null, null, null, 232, null), null, false, 24, null);
    }

    private final Bundle j(List<WalletAddress> list) {
        Object obj;
        Object obj2;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.m.c(((WalletAddress) obj).getType(), AddressKind_LitecoinKt.getLiteCoinSegWit(AddressType.Companion))) {
                break;
            }
        }
        WalletAddress walletAddress = (WalletAddress) obj;
        String address = walletAddress == null ? null : walletAddress.getAddress();
        if (address != null) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (kotlin.jvm.internal.m.c(((WalletAddress) obj2).getType(), AddressKind_LitecoinKt.getLitecoinLegacy(AddressType.Companion))) {
                    break;
                }
            }
            WalletAddress walletAddress2 = (WalletAddress) obj2;
            String address2 = walletAddress2 != null ? walletAddress2.getAddress() : null;
            if (address2 != null) {
                return e(this, new DisplayCoinAddressFragment.DisplayCoinAddress[]{new DisplayCoinAddressFragment.DisplayCoinAddress(address, kotlin.jvm.internal.m.o("litecoin:", address), Integer.valueOf((int) R.string.segwit), R.string.copy_segwit_address), new DisplayCoinAddressFragment.DisplayCoinAddress(address2, kotlin.jvm.internal.m.o("litecoin:", address2), Integer.valueOf((int) R.string.legacy), R.string.copy_legacy_address)}, CurrencyCode_LitecoinKt.getLTC(CurrencyCode.Companion).getRawValue(), new Prompt(Prompt.Id.LTC_SEGWIT_LEGACY_ADDRESS, R.string.info_did_you_know_ltc_title, R.string.info_did_you_know_ltc_desc, null, Integer.valueOf((int) R.drawable.info_did_you_know_ltc), null, null, null, 232, null), null, false, 24, null);
            }
            throw new IllegalStateException("Couldn't get value for legacy address");
        }
        throw new IllegalStateException("Couldn't get value for segwit address");
    }

    private final Bundle k(String str, Wallet wallet) {
        Prompt prompt;
        Prompt prompt2;
        if (wallet == null) {
            prompt2 = null;
        } else {
            BigInteger minimumBalance = wallet.getMinimumBalance();
            if (minimumBalance != null && minimumBalance.compareTo(wallet.getBalance()) > 0) {
                String bigDecimal = BigInteger_ApplicationKt.asBigDecimal(minimumBalance, wallet.getDecimals()).toString();
                kotlin.jvm.internal.m.f(bigDecimal, "balanceToShow.toString()");
                prompt = new Prompt(Prompt.Id.XLM_RECEIVE_MINIMUM_BALANCE_WARNING, R.string.stellar_minimum_balance, R.string.stellar_minimum_balance_explanation, new String[]{bigDecimal}, null, null, null, null, 240, null);
            } else {
                prompt = null;
            }
            prompt2 = prompt;
        }
        return d(new DisplayCoinAddressFragment.DisplayCoinAddress[]{new DisplayCoinAddressFragment.DisplayCoinAddress(str, kotlin.jvm.internal.m.o("web+stellar:pay?destination=", str), null, R.string.copy, 4, null)}, CurrencyCode_StellarKt.getXLM(CurrencyCode.Companion).getRawValue(), prompt2, prompt2 != null ? Integer.valueOf((int) R.string.info_minimum_balance_warning) : null, true);
    }

    private final Bundle l(String str, Wallet wallet) {
        Prompt prompt;
        Prompt prompt2;
        if (wallet == null) {
            prompt2 = null;
        } else {
            BigInteger minimumBalance = wallet.getMinimumBalance();
            if (minimumBalance != null && minimumBalance.compareTo(wallet.getBalance()) > 0) {
                String bigDecimal = BigInteger_ApplicationKt.asBigDecimal(minimumBalance, wallet.getDecimals()).toString();
                kotlin.jvm.internal.m.f(bigDecimal, "balanceToShow.toString()");
                prompt = new Prompt(Prompt.Id.XRP_RECEIVE_MINIMUM_BALANCE_WARNING, R.string.xrp_minimum_balance, R.string.xrp_minimum_balance_explanation, new String[]{bigDecimal}, null, null, null, null, 240, null);
            } else {
                prompt = null;
            }
            prompt2 = prompt;
        }
        return d(new DisplayCoinAddressFragment.DisplayCoinAddress[]{new DisplayCoinAddressFragment.DisplayCoinAddress(str, kotlin.jvm.internal.m.o("ripple:", str), null, R.string.copy, 4, null)}, CurrencyCode_RippleKt.getXRP(CurrencyCode.Companion).getRawValue(), prompt2, prompt2 != null ? Integer.valueOf((int) R.string.info_minimum_balance_warning) : null, true);
    }

    private final String n(Prompt prompt) {
        String json = this.a.adapter(Prompt.class).toJson(prompt);
        kotlin.jvm.internal.m.f(json, "adapter.toJson(infoPrompt)");
        return json;
    }

    public final List<DisplayCoinAddressFragment.DisplayCoinAddress> a(String addresses) {
        List<DisplayCoinAddressFragment.DisplayCoinAddress> g2;
        kotlin.jvm.internal.m.g(addresses, "addresses");
        List<DisplayCoinAddressFragment.DisplayCoinAddress> list = (List) this.a.adapter(Types.newParameterizedType(List.class, DisplayCoinAddressFragment.DisplayCoinAddress.class)).fromJson(addresses);
        if (list == null) {
            g2 = kotlin.a0.r.g();
            return g2;
        }
        return list;
    }

    public final Bundle c(List<WalletAddress> addresses, CurrencyCode currencyCode, Blockchain blockchain, Wallet wallet) {
        kotlin.jvm.internal.m.g(addresses, "addresses");
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        CurrencyCode.Companion companion = CurrencyCode.Companion;
        return kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_BitcoinKt.getBTC(companion)) ? f(addresses) : kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_LitecoinKt.getLTC(companion)) ? j(addresses) : kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_DogecoinKt.getDOGE(companion)) ? h(addresses) : kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_BitcoinCashKt.getBCH(companion)) ? g(addresses, wallet) : kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_RippleKt.getXRP(companion)) ? l(addresses.get(0).getAddress(), wallet) : kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_StellarKt.getXLM(companion)) ? k(addresses.get(0).getAddress(), wallet) : i(addresses.get(0).getAddress(), currencyCode, blockchain);
    }

    public final Prompt m(String str) {
        if (str == null) {
            return null;
        }
        return (Prompt) this.a.adapter(Prompt.class).fromJson(str);
    }
}