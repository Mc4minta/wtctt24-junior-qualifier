package com.coinbase.wallet.features.send.viewmodels;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.TxMetadata;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxSource;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.core.extensions.Map_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.extensions.TxMetadataKey_EthereumKt;
import com.coinbase.wallet.features.send.models.AddressResolution;
import com.coinbase.wallet.features.send.models.AddressSearchResult;
import com.coinbase.wallet.features.send.models.Recipient;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.features.send.models.SendDestinationPickerRow;
import com.coinbase.wallet.features.send.models.SendDestinationPickerState;
import com.coinbase.wallet.features.send.models.SendDestinationViewInfo;
import com.coinbase.wallet.features.send.repositories.RecipientRepository;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.ripple.extensions.TxMetadataKey_RippleKt;
import com.coinbase.wallet.stellar.extensions.Blockchain_StellarKt;
import com.coinbase.wallet.stellar.extensions.TxMetadataKey_StellarKt;
import com.coinbase.wallet.txhistory.models.RecipientType;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import e.j.k.a.b;
import h.c.h0;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.a0.m0;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.toshi.R;

/* compiled from: SendDestinationPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010~\u001a\u00020}\u0012\u0006\u0010U\u001a\u00020T\u0012\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001¢\u0006\u0006\bµ\u0001\u0010¶\u0001J!\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u001dJ!\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000fH\u0003¢\u0006\u0004\b)\u0010*J\u0015\u0010-\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0015\u00101\u001a\u00020\u000f2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u0019\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b030\u0016¢\u0006\u0004\b4\u00105J\u0019\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b030\u0016¢\u0006\u0004\b6\u00105J#\u00108\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b8\u00109J\u0015\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u000fH\u0007¢\u0006\u0004\b>\u0010*J%\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u000f¢\u0006\u0004\bA\u0010*J\r\u0010B\u001a\u00020\u000f¢\u0006\u0004\bB\u0010*J\r\u0010C\u001a\u00020\u000f¢\u0006\u0004\bC\u0010*J\r\u0010D\u001a\u00020\u000f¢\u0006\u0004\bD\u0010*J%\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bE\u0010@J\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010F\u001a\u00020:¢\u0006\u0004\b\u0017\u0010GJ1\u0010J\u001a\u00020\u000f2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020+0\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bJ\u0010KR\u0013\u0010N\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001f\u0010P\u001a\b\u0012\u0004\u0012\u00020\b0O8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0013\u0010X\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bW\u0010MR\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010YR$\u0010\\\u001a\u0010\u0012\f\u0012\n [*\u0004\u0018\u00010\u000f0\u000f0Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R$\u0010^\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00048\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b^\u0010_\"\u0004\b`\u0010aR!\u0010b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0O8\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010Q\u001a\u0004\bc\u0010SR$\u0010e\u001a\u0010\u0012\f\u0012\n [*\u0004\u0018\u00010\b0\b0d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u001f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u000f0O8\u0006@\u0006¢\u0006\f\n\u0004\bg\u0010Q\u001a\u0004\bh\u0010SR\u0013\u0010j\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bi\u0010MR$\u0010l\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR$\u0010r\u001a\u0010\u0012\f\u0012\n [*\u0004\u0018\u00010\b0\b0Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010]R\u001f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00040O8\u0006@\u0006¢\u0006\f\n\u0004\bs\u0010Q\u001a\u0004\bt\u0010SR$\u0010u\u001a\u0010\u0012\f\u0012\n [*\u0004\u0018\u00010\u000f0\u000f0Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010]R$\u0010v\u001a\u0010\u0012\f\u0012\n [*\u0004\u0018\u00010\b0\b0d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010fR\u001f\u0010x\u001a\b\u0012\u0004\u0012\u00020w0O8\u0006@\u0006¢\u0006\f\n\u0004\bx\u0010Q\u001a\u0004\by\u0010SR\u0013\u0010z\u001a\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\bz\u0010{R$\u0010|\u001a\u0010\u0012\f\u0012\n [*\u0004\u0018\u00010\u000f0\u000f0d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010fR\u0016\u0010~\u001a\u00020}8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR&\u0010\u0080\u0001\u001a\u0010\u0012\f\u0012\n [*\u0004\u0018\u00010\b0\b0Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010]R#\u0010\u0086\u0001\u001a\u00030\u0081\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u00100\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b0\u0010\u0087\u0001R(\u0010\u0089\u0001\u001a\u0012\u0012\u000e\u0012\f [*\u0005\u0018\u00010\u0088\u00010\u0088\u00010Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010]R&\u0010\u008a\u0001\u001a\u0010\u0012\f\u0012\n [*\u0004\u0018\u00010\u00040\u00040Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010]R#\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u00030\u0088\u00010O8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010Q\u001a\u0005\b\u008c\u0001\u0010SR\u001a\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R$\u0010\u0090\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0O8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010Q\u001a\u0005\b\u0091\u0001\u0010SR\"\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\b0O8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010Q\u001a\u0005\b\u0093\u0001\u0010SR)\u0010\u0094\u0001\u001a\u00020w2\u0006\u0010 \u001a\u00020w8\u0002@BX\u0082\u000e¢\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R0\u0010\u009e\u0001\u001a\u0010\u0012\f\u0012\n [*\u0004\u0018\u00010w0w0d8B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009b\u0001\u0010\u0083\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\"\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0O8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u009f\u0001\u0010Q\u001a\u0005\b \u0001\u0010SR\u0019\u0010¡\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\"\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0O8\u0006@\u0006¢\u0006\u000e\n\u0005\b£\u0001\u0010Q\u001a\u0005\b¤\u0001\u0010SR1\u0010§\u0001\u001a\n\u0012\u0005\u0012\u00030¦\u00010¥\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R4\u0010¯\u0001\u001a\u00030\u00ad\u00012\b\u0010®\u0001\u001a\u00030\u00ad\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001¨\u0006·\u0001"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/SendDestinationPickerViewModel;", "Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "intent", "", "isMetadata", "handleQrResult", "(Lcom/coinbase/wallet/qr/models/QRCodeScanResult;Z)Z", "", "searchQuery", "", "Lcom/coinbase/wallet/features/send/models/AddressSearchResult;", "searchResults", "isValidAddress", "isValidMemo", "Lkotlin/x;", "processSearchResults", "(Ljava/lang/String;Ljava/util/List;ZZ)V", "Lcom/coinbase/wallet/features/send/models/Recipient;", "recipient", "Lcom/coinbase/wallet/features/send/models/AddressResolution;", "resolution", "Lh/c/b0;", "confirmSend", "(Lcom/coinbase/wallet/features/send/models/Recipient;Lcom/coinbase/wallet/features/send/models/AddressResolution;)Lh/c/b0;", SendConfirmationArgs.metadataKey, "isValidMetadata", "(Ljava/lang/String;)Z", "address", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "key", "value", "", "getMetadata", "(Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;)Ljava/lang/Object;", "Lcom/coinbase/wallet/features/send/viewmodels/QrResult;", "handleMainQrResult", "(Lcom/coinbase/wallet/qr/models/QRCodeScanResult;)Lcom/coinbase/wallet/features/send/viewmodels/QrResult;", "handleMetadataResult", "(Lcom/coinbase/wallet/qr/models/QRCodeScanResult;)Ljava/lang/String;", "didSetIsSearching", "()V", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "setWallet", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", "setAmount", "(Lcom/coinbase/wallet/blockchains/models/TransferValue;)V", "Lcom/coinbase/wallet/core/util/Optional;", "getPasteboard", "()Lh/c/b0;", "pasteButtonTapped", "query", "search", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;", "item", "isValidSendDestination", "(Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;)Z", "refreshPasteboard", "nextButtonTapped", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "memoTypeButtonTapped", "userIsTyping", "presentQrScanner", "presentMetadataScanner", "confirmSendToAddress", "sendDestinationViewInfo", "(Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;)Lh/c/b0;", "results", "wallets", "finishQrScan", "(Ljava/util/List;Ljava/util/List;Z)V", "getValidationErrorText", "()Ljava/lang/String;", "validationErrorText", "Lh/c/s;", "qrScanErrorObservable", "Lh/c/s;", "getQrScanErrorObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/features/send/repositories/RecipientRepository;", "recipientRepository", "Lcom/coinbase/wallet/features/send/repositories/RecipientRepository;", "getMetadataPlaceholderText", "metadataPlaceholderText", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "launchQrScannerSubject", "Lh/c/v0/b;", "isSearching", "Z", "setSearching", "(Z)V", "recipientScanResultObservable", "getRecipientScanResultObservable", "Lh/c/v0/a;", "metadataScanResultSubject", "Lh/c/v0/a;", "destinationUpdateObservable", "getDestinationUpdateObservable", "getQrScanningErrorText", "qrScanningErrorText", "Lcom/coinbase/wallet/features/send/viewmodels/PendingRecipient;", "pendingRecipient", "Lcom/coinbase/wallet/features/send/viewmodels/PendingRecipient;", "getPendingRecipient", "()Lcom/coinbase/wallet/features/send/viewmodels/PendingRecipient;", "setPendingRecipient", "(Lcom/coinbase/wallet/features/send/viewmodels/PendingRecipient;)V", "qrScanErrorSubject", "dismissScannerObservable", "getDismissScannerObservable", "launchAddressNotFoundAlertSubject", "recipientScanResultSubject", "Lcom/coinbase/wallet/features/send/models/SendDestinationPickerState;", "stateObservable", "getStateObservable", "isMetadataAvailable", "()Z", "destinationUpdateSubject", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "metadataPlaceholderSubject", "Landroid/content/ClipboardManager;", "clipboardManager$delegate", "Lkotlin/h;", "getClipboardManager", "()Landroid/content/ClipboardManager;", "clipboardManager", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "Landroid/os/Bundle;", "launchSendConfirmSubject", "dismissScannerSubject", "launchSendConfirmObservable", "getLaunchSendConfirmObservable", "Landroid/content/Context;", "context", "Landroid/content/Context;", "metadataScanResultObservable", "getMetadataScanResultObservable", "metadataPlaceholderObservable", "getMetadataPlaceholderObservable", ApiConstants.STATE, "Lcom/coinbase/wallet/features/send/models/SendDestinationPickerState;", "setState", "(Lcom/coinbase/wallet/features/send/models/SendDestinationPickerState;)V", "Lh/c/k0/a;", "currentSearchDisposable", "Lh/c/k0/a;", "stateSubject$delegate", "getStateSubject", "()Lh/c/v0/a;", "stateSubject", "launchQrScannerObservable", "getLaunchQrScannerObservable", "currentSearchQuery", "Ljava/lang/String;", "launchAddressNotFoundAlertObservable", "getLaunchAddressNotFoundAlertObservable", "", "Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow;", "sections", "Ljava/util/List;", "getSections", "()Ljava/util/List;", "setSections", "(Ljava/util/List;)V", "Le/j/k/a/a;", "newValue", "selectedMemoType", "Le/j/k/a/a;", "getSelectedMemoType", "()Le/j/k/a/a;", "setSelectedMemoType", "(Le/j/k/a/a;)V", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;Lcom/coinbase/wallet/features/send/repositories/RecipientRepository;Landroid/content/Context;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerViewModel extends androidx.lifecycle.b0 {
    private TransferValue amount;
    private final kotlin.h clipboardManager$delegate;
    private final Context context;
    private h.c.k0.a currentSearchDisposable;
    private String currentSearchQuery;
    private final h.c.s<kotlin.x> destinationUpdateObservable;
    private final h.c.v0.a<kotlin.x> destinationUpdateSubject;
    private final h.c.s<Boolean> dismissScannerObservable;
    private final h.c.v0.b<Boolean> dismissScannerSubject;
    private boolean isSearching;
    private final h.c.s<kotlin.x> launchAddressNotFoundAlertObservable;
    private final h.c.v0.b<kotlin.x> launchAddressNotFoundAlertSubject;
    private final h.c.s<kotlin.x> launchQrScannerObservable;
    private final h.c.v0.b<kotlin.x> launchQrScannerSubject;
    private final h.c.s<Bundle> launchSendConfirmObservable;
    private final h.c.v0.b<Bundle> launchSendConfirmSubject;
    private final h.c.s<String> metadataPlaceholderObservable;
    private final h.c.v0.b<String> metadataPlaceholderSubject;
    private final h.c.s<String> metadataScanResultObservable;
    private final h.c.v0.a<String> metadataScanResultSubject;
    private PendingRecipient pendingRecipient;
    private final h.c.s<String> qrScanErrorObservable;
    private final h.c.v0.b<String> qrScanErrorSubject;
    private final RecipientRepository recipientRepository;
    private final h.c.s<String> recipientScanResultObservable;
    private final h.c.v0.a<String> recipientScanResultSubject;
    private List<SendDestinationPickerRow> sections;
    private e.j.k.a.a selectedMemoType;
    private SendDestinationPickerState state;
    private final h.c.s<SendDestinationPickerState> stateObservable;
    private final kotlin.h stateSubject$delegate;
    private final ITxRepository txRepository;
    private Wallet wallet;

    /* compiled from: SendDestinationPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecipientType.values().length];
            iArr[RecipientType.User.ordinal()] = 1;
            iArr[RecipientType.ENS.ordinal()] = 2;
            iArr[RecipientType.Coinbase.ordinal()] = 3;
            iArr[RecipientType.Address.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SendDestinationPickerViewModel(ITxRepository txRepository, RecipientRepository recipientRepository, Context context) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(txRepository, "txRepository");
        kotlin.jvm.internal.m.g(recipientRepository, "recipientRepository");
        kotlin.jvm.internal.m.g(context, "context");
        this.txRepository = txRepository;
        this.recipientRepository = recipientRepository;
        this.context = context;
        h.c.v0.a<kotlin.x> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create<Unit>()");
        this.destinationUpdateSubject = d2;
        h.c.v0.b<kotlin.x> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<Unit>()");
        this.launchQrScannerSubject = d3;
        h.c.v0.b<Bundle> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<Bundle>()");
        this.launchSendConfirmSubject = d4;
        h.c.v0.b<kotlin.x> d5 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d5, "create<Unit>()");
        this.launchAddressNotFoundAlertSubject = d5;
        h.c.v0.b<String> d6 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d6, "create<String>()");
        this.metadataPlaceholderSubject = d6;
        h.c.v0.a<String> d7 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d7, "create<String?>()");
        this.recipientScanResultSubject = d7;
        h.c.v0.a<String> d8 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d8, "create<String?>()");
        this.metadataScanResultSubject = d8;
        h.c.v0.b<Boolean> d9 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d9, "create<Boolean>()");
        this.dismissScannerSubject = d9;
        h.c.v0.b<String> d10 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d10, "create<String>()");
        this.qrScanErrorSubject = d10;
        this.currentSearchQuery = Strings_CoreKt.getEmpty(Strings.INSTANCE);
        this.currentSearchDisposable = new h.c.k0.a();
        b2 = kotlin.k.b(new SendDestinationPickerViewModel$stateSubject$2(this));
        this.stateSubject$delegate = b2;
        this.state = new SendDestinationPickerState();
        b3 = kotlin.k.b(new SendDestinationPickerViewModel$clipboardManager$2(this));
        this.clipboardManager$delegate = b3;
        h.c.s<SendDestinationPickerState> hide = getStateSubject().hide();
        kotlin.jvm.internal.m.f(hide, "stateSubject.hide()");
        this.stateObservable = hide;
        h.c.s<kotlin.x> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "launchQrScannerSubject.hide()");
        this.launchQrScannerObservable = hide2;
        h.c.s<Bundle> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "launchSendConfirmSubject.hide()");
        this.launchSendConfirmObservable = hide3;
        h.c.s<kotlin.x> hide4 = d5.hide();
        kotlin.jvm.internal.m.f(hide4, "launchAddressNotFoundAlertSubject.hide()");
        this.launchAddressNotFoundAlertObservable = hide4;
        h.c.s<String> hide5 = d7.hide();
        kotlin.jvm.internal.m.f(hide5, "recipientScanResultSubject.hide()");
        this.recipientScanResultObservable = hide5;
        h.c.s<String> hide6 = d8.hide();
        kotlin.jvm.internal.m.f(hide6, "metadataScanResultSubject.hide()");
        this.metadataScanResultObservable = hide6;
        h.c.s<kotlin.x> hide7 = d2.hide();
        kotlin.jvm.internal.m.f(hide7, "destinationUpdateSubject.hide()");
        this.destinationUpdateObservable = hide7;
        h.c.s<String> hide8 = d6.hide();
        kotlin.jvm.internal.m.f(hide8, "metadataPlaceholderSubject.hide()");
        this.metadataPlaceholderObservable = hide8;
        h.c.s<Boolean> hide9 = d9.hide();
        kotlin.jvm.internal.m.f(hide9, "dismissScannerSubject.hide()");
        this.dismissScannerObservable = hide9;
        h.c.s<String> hide10 = d10.hide();
        kotlin.jvm.internal.m.f(hide10, "qrScanErrorSubject.hide()");
        this.qrScanErrorObservable = hide10;
        this.sections = new ArrayList();
        this.selectedMemoType = e.j.k.a.a.f13694c;
    }

    public static /* synthetic */ h0 a(SendDestinationPickerViewModel sendDestinationPickerViewModel, Recipient recipient) {
        return m1374confirmSend$lambda2(sendDestinationPickerViewModel, recipient);
    }

    public static /* synthetic */ h0 b(SendDestinationPickerViewModel sendDestinationPickerViewModel, Throwable th) {
        return m1373confirmSend$lambda11(sendDestinationPickerViewModel, th);
    }

    public static /* synthetic */ kotlin.x c(SendDestinationPickerViewModel sendDestinationPickerViewModel, Throwable th) {
        return m1377confirmSend$lambda4(sendDestinationPickerViewModel, th);
    }

    /* renamed from: confirmSend$lambda-10 */
    public static final h.c.k0.b m1372confirmSend$lambda10(SendDestinationPickerViewModel this$0, AddressResolution resolution, Map metadata, Recipient recipient, kotlin.x it) {
        Map t;
        SendDestinationPickerState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(resolution, "$resolution");
        kotlin.jvm.internal.m.g(metadata, "$metadata");
        kotlin.jvm.internal.m.g(recipient, "$recipient");
        kotlin.jvm.internal.m.g(it, "it");
        Wallet wallet = this$0.wallet;
        if (wallet != null) {
            TransferValue transferValue = this$0.amount;
            if (transferValue != null) {
                String address = resolution.getAddress();
                t = m0.t(metadata);
                this$0.launchSendConfirmSubject.onNext(SendConfirmationArgs.INSTANCE.createArguments(wallet, transferValue, new TxMetadata(t), recipient, address));
                copy = r11.copy((r30 & 1) != 0 ? r11.errorMessage : null, (r30 & 2) != 0 ? r11.isNextButtonHidden : false, (r30 & 4) != 0 ? r11.isNextButtonLoading : false, (r30 & 8) != 0 ? r11.isPasteboardHidden : true, (r30 & 16) != 0 ? r11.pasteboardText : null, (r30 & 32) != 0 ? r11.isMetadataFieldHidden : false, (r30 & 64) != 0 ? r11.isMetadataButtonHidden : false, (r30 & 128) != 0 ? r11.isErrorMessageHidden : true, (r30 & 256) != 0 ? r11.emptyStateTitle : null, (r30 & 512) != 0 ? r11.emptyStateDetails : null, (r30 & 1024) != 0 ? r11.memoTypeButtonTapped : false, (r30 & PKIFailureInfo.wrongIntegrity) != 0 ? r11.isMetadataFieldErrorLabelHidden : false, (r30 & 4096) != 0 ? r11.metadataFieldErrorMessage : null, (r30 & PKIFailureInfo.certRevoked) != 0 ? this$0.state.isPasteboardLoading : false);
                this$0.setState(copy);
                AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
                RecipientType recipientType = recipient.getRecipientType();
                Wallet wallet2 = this$0.wallet;
                if (wallet2 != null) {
                    return Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.recipientSelected(companion, recipientType, wallet2.getCurrencyCode(), this$0.currentSearchQuery.length(), recipient.getSendCount()));
                }
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
            kotlin.jvm.internal.m.w("amount");
            throw null;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    /* renamed from: confirmSend$lambda-11 */
    public static final h0 m1373confirmSend$lambda11(SendDestinationPickerViewModel this$0, Throwable err) {
        SendDestinationPickerState copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(err, "err");
        copy = r3.copy((r30 & 1) != 0 ? r3.errorMessage : err.getLocalizedMessage(), (r30 & 2) != 0 ? r3.isNextButtonHidden : true, (r30 & 4) != 0 ? r3.isNextButtonLoading : false, (r30 & 8) != 0 ? r3.isPasteboardHidden : true, (r30 & 16) != 0 ? r3.pasteboardText : null, (r30 & 32) != 0 ? r3.isMetadataFieldHidden : false, (r30 & 64) != 0 ? r3.isMetadataButtonHidden : false, (r30 & 128) != 0 ? r3.isErrorMessageHidden : false, (r30 & 256) != 0 ? r3.emptyStateTitle : null, (r30 & 512) != 0 ? r3.emptyStateDetails : null, (r30 & 1024) != 0 ? r3.memoTypeButtonTapped : false, (r30 & PKIFailureInfo.wrongIntegrity) != 0 ? r3.isMetadataFieldErrorLabelHidden : false, (r30 & 4096) != 0 ? r3.metadataFieldErrorMessage : null, (r30 & PKIFailureInfo.certRevoked) != 0 ? this$0.state.isPasteboardLoading : false);
        this$0.setState(copy);
        return h.c.b0.error(err);
    }

    /* renamed from: confirmSend$lambda-2 */
    public static final h0 m1374confirmSend$lambda2(SendDestinationPickerViewModel this$0, final Recipient recipient) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(recipient, "recipient");
        return this$0.recipientRepository.resolveAddress(recipient).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.w
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SendDestinationPickerViewModel.e(Recipient.this, (AddressResolution) obj);
            }
        });
    }

    /* renamed from: confirmSend$lambda-2$lambda-1 */
    public static final kotlin.o m1375confirmSend$lambda2$lambda1(Recipient recipient, AddressResolution it) {
        kotlin.jvm.internal.m.g(recipient, "$recipient");
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.u.a(recipient, it);
    }

    /* renamed from: confirmSend$lambda-3 */
    public static final h0 m1376confirmSend$lambda3(SendDestinationPickerViewModel this$0, kotlin.o it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        Object c2 = it.c();
        kotlin.jvm.internal.m.f(c2, "it.first");
        Object d2 = it.d();
        kotlin.jvm.internal.m.f(d2, "it.second");
        return this$0.confirmSend((Recipient) c2, (AddressResolution) d2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0016, code lost:
        if (r0.contains(r2) == false) goto L7;
     */
    /* renamed from: confirmSend$lambda-4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.x m1377confirmSend$lambda4(com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel r1, java.lang.Throwable r2) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.m.g(r1, r0)
            java.lang.String r0 = "err"
            kotlin.jvm.internal.m.g(r2, r0)
            boolean r0 = r2 instanceof com.coinbase.wallet.ripple.exceptions.XrpException
            if (r0 == 0) goto L18
            java.util.List r0 = com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModelKt.access$getThrowableXRPErrors$p()
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto L1c
        L18:
            boolean r0 = r2 instanceof com.coinbase.wallet.stellar.exceptions.StellarException.RequiresMinimumBalance
            if (r0 == 0) goto L1d
        L1c:
            throw r2
        L1d:
            h.c.v0.b<kotlin.x> r1 = r1.launchAddressNotFoundAlertSubject
            kotlin.x r0 = kotlin.x.a
            r1.onNext(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel.m1377confirmSend$lambda4(com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel, java.lang.Throwable):kotlin.x");
    }

    /* renamed from: confirmSend$lambda-9 */
    public static final h0 m1378confirmSend$lambda9(Recipient recipient, SendDestinationPickerViewModel this$0, AddressResolution resolution, kotlin.x it) {
        Recipient copy;
        kotlin.jvm.internal.m.g(recipient, "$recipient");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(resolution, "$resolution");
        kotlin.jvm.internal.m.g(it, "it");
        copy = recipient.copy((r22 & 1) != 0 ? recipient.getId() : null, (r22 & 2) != 0 ? recipient.destination : null, (r22 & 4) != 0 ? recipient.blockchain : null, (r22 & 8) != 0 ? recipient.sendCount : recipient.getSendCount() + 1, (r22 & 16) != 0 ? recipient.lastUsed : new Date(), (r22 & 32) != 0 ? recipient.recipientType : null, (r22 & 64) != 0 ? recipient.currencyCode : null, (r22 & 128) != 0 ? recipient.metadataKey : null, (r22 & 256) != 0 ? recipient.metadata : null, (r22 & 512) != 0 ? recipient.network : null);
        return this$0.recipientRepository.saveRecipient(copy, resolution);
    }

    public static /* synthetic */ h0 d(SendDestinationPickerViewModel sendDestinationPickerViewModel, kotlin.o oVar) {
        return m1376confirmSend$lambda3(sendDestinationPickerViewModel, oVar);
    }

    private final void didSetIsSearching() {
        Object obj;
        boolean z;
        if (this.isSearching) {
            return;
        }
        Iterator<T> it = this.sections.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            SendDestinationPickerRow sendDestinationPickerRow = (SendDestinationPickerRow) obj;
            if ((sendDestinationPickerRow instanceof SendDestinationPickerRow.Spinner) || (sendDestinationPickerRow instanceof SendDestinationPickerRow.Destination)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        SendDestinationPickerRow sendDestinationPickerRow2 = (SendDestinationPickerRow) obj;
        if (sendDestinationPickerRow2 == null ? false : sendDestinationPickerRow2 instanceof SendDestinationPickerRow.Spinner) {
            return;
        }
        Iterator<SendDestinationPickerRow> it2 = this.sections.iterator();
        int i2 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            } else if (it2.next() instanceof SendDestinationPickerRow.Title) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            this.sections.remove(i2);
        }
        this.sections.add(0, SendDestinationPickerRow.Spinner.INSTANCE);
        this.destinationUpdateSubject.onNext(kotlin.x.a);
    }

    public static /* synthetic */ kotlin.o e(Recipient recipient, AddressResolution addressResolution) {
        return m1375confirmSend$lambda2$lambda1(recipient, addressResolution);
    }

    public static /* synthetic */ Optional f(String str, Boolean bool) {
        return m1379getPasteboard$lambda0(str, bool);
    }

    public static /* synthetic */ h0 g(Recipient recipient, SendDestinationPickerViewModel sendDestinationPickerViewModel, AddressResolution addressResolution, kotlin.x xVar) {
        return m1378confirmSend$lambda9(recipient, sendDestinationPickerViewModel, addressResolution, xVar);
    }

    private final ClipboardManager getClipboardManager() {
        return (ClipboardManager) this.clipboardManager$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.math.BigInteger] */
    private final Object getMetadata(TxMetadataKey txMetadataKey, String str) {
        e.j.k.a.a aVar;
        Wallet wallet = this.wallet;
        if (wallet != null) {
            Blockchain blockchain = wallet.getBlockchain();
            Blockchain.Companion companion = Blockchain.Companion;
            if (kotlin.jvm.internal.m.c(blockchain, Blockchain_RippleKt.getXRP(companion))) {
                return kotlin.l0.b0.b(str);
            }
            if (kotlin.jvm.internal.m.c(blockchain, Blockchain_StellarKt.getSTELLAR(companion))) {
                TxMetadataKey.Companion companion2 = TxMetadataKey.Companion;
                if (kotlin.jvm.internal.m.c(txMetadataKey, TxMetadataKey_StellarKt.getMemoId(companion2))) {
                    aVar = e.j.k.a.a.f13694c;
                } else if (kotlin.jvm.internal.m.c(txMetadataKey, TxMetadataKey_StellarKt.getMemoHash(companion2))) {
                    aVar = e.j.k.a.a.f13696e;
                } else if (kotlin.jvm.internal.m.c(txMetadataKey, TxMetadataKey_StellarKt.getMemoReturn(companion2))) {
                    aVar = e.j.k.a.a.f13695d;
                } else if (!kotlin.jvm.internal.m.c(txMetadataKey, TxMetadataKey_StellarKt.getMemoText(companion2))) {
                    return null;
                } else {
                    aVar = e.j.k.a.a.f13693b;
                }
                if (aVar.s(str) instanceof b.C0324b) {
                    if (!(kotlin.jvm.internal.m.c(txMetadataKey, TxMetadataKey_StellarKt.getMemoHash(companion2)) ? true : kotlin.jvm.internal.m.c(txMetadataKey, TxMetadataKey_StellarKt.getMemoReturn(companion2)) ? true : kotlin.jvm.internal.m.c(txMetadataKey, TxMetadataKey_StellarKt.getMemoText(companion2)))) {
                        str = kotlin.jvm.internal.m.c(txMetadataKey, TxMetadataKey_StellarKt.getMemoId(companion2)) ? new BigInteger(str) : null;
                    }
                    return str;
                }
                return null;
            }
            return null;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    /* renamed from: getPasteboard$lambda-0 */
    public static final Optional m1379getPasteboard$lambda0(String pasteboardString, Boolean isValid) {
        kotlin.jvm.internal.m.g(pasteboardString, "$pasteboardString");
        kotlin.jvm.internal.m.g(isValid, "isValid");
        if (isValid.booleanValue()) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendDestinationPasteShow(AnalyticsEvent.Companion));
            return OptionalKt.toOptional(pasteboardString);
        }
        return OptionalKt.toOptional(null);
    }

    private final h.c.v0.a<SendDestinationPickerState> getStateSubject() {
        return (h.c.v0.a) this.stateSubject$delegate.getValue();
    }

    public static /* synthetic */ h.c.k0.b h(SendDestinationPickerViewModel sendDestinationPickerViewModel, AddressResolution addressResolution, Map map, Recipient recipient, kotlin.x xVar) {
        return m1372confirmSend$lambda10(sendDestinationPickerViewModel, addressResolution, map, recipient, xVar);
    }

    private final QrResult handleMainQrResult(QRCodeScanResult qRCodeScanResult) {
        e.j.k.a.a aVar;
        List l2;
        String address = qRCodeScanResult.getAddress();
        String str = null;
        if (address == null) {
            address = null;
        }
        if (qRCodeScanResult instanceof QRCodeScanResult.XRP) {
            UInt m1623getDestinationTag0hXNFcg = ((QRCodeScanResult.XRP) qRCodeScanResult).m1623getDestinationTag0hXNFcg();
            if (m1623getDestinationTag0hXNFcg != null) {
                str = d0.a(m1623getDestinationTag0hXNFcg.B());
            }
        } else if (qRCodeScanResult instanceof QRCodeScanResult.Stellar) {
            QRCodeScanResult.Stellar stellar = (QRCodeScanResult.Stellar) qRCodeScanResult;
            BigInteger memoId = stellar.getMemoId();
            String bigInteger = memoId == null ? null : memoId.toString();
            if (stellar.getMemoText() != null) {
                aVar = e.j.k.a.a.f13693b;
            } else if (bigInteger != null) {
                aVar = e.j.k.a.a.f13694c;
            } else if (stellar.getMemoHash() != null) {
                aVar = e.j.k.a.a.f13696e;
            } else {
                aVar = stellar.getMemoReturn() != null ? e.j.k.a.a.f13695d : e.j.k.a.a.f13693b;
            }
            setSelectedMemoType(aVar);
            l2 = kotlin.a0.r.l(stellar.getMemoText(), bigInteger, stellar.getMemoHash(), stellar.getMemoReturn());
            String str2 = (String) kotlin.a0.p.a0(l2);
            if (str2 != null) {
                str = str2;
            }
        }
        return new QrResult(address, str);
    }

    private final String handleMetadataResult(QRCodeScanResult qRCodeScanResult) {
        Wallet wallet = this.wallet;
        if (wallet != null) {
            Blockchain blockchain = wallet.getBlockchain();
            Blockchain.Companion companion = Blockchain.Companion;
            if (kotlin.jvm.internal.m.c(blockchain, Blockchain_StellarKt.getSTELLAR(companion))) {
                e.j.k.a.a aVar = this.selectedMemoType;
                if (aVar == e.j.k.a.a.f13694c && (qRCodeScanResult instanceof QRCodeScanResult.UnsignedInteger)) {
                    return f0.a(((QRCodeScanResult.UnsignedInteger) qRCodeScanResult).m1622getUIntpVg5ArA());
                }
                if (aVar == e.j.k.a.a.f13696e && (qRCodeScanResult instanceof QRCodeScanResult.HexString)) {
                    QRCodeScanResult.HexString hexString = (QRCodeScanResult.HexString) qRCodeScanResult;
                    if (hexString.getFixedLength() == 64) {
                        return hexString.getText();
                    }
                }
                if (this.selectedMemoType == e.j.k.a.a.f13693b && (qRCodeScanResult instanceof QRCodeScanResult.Utf8String)) {
                    QRCodeScanResult.Utf8String utf8String = (QRCodeScanResult.Utf8String) qRCodeScanResult;
                    if (utf8String.getFixedSize() == 28) {
                        return utf8String.getString();
                    }
                }
                if (this.selectedMemoType == e.j.k.a.a.f13695d && (qRCodeScanResult instanceof QRCodeScanResult.HexString)) {
                    QRCodeScanResult.HexString hexString2 = (QRCodeScanResult.HexString) qRCodeScanResult;
                    if (hexString2.getFixedLength() == 64) {
                        return hexString2.getText();
                    }
                    return null;
                }
                return null;
            } else if (kotlin.jvm.internal.m.c(blockchain, Blockchain_RippleKt.getXRP(companion)) && (qRCodeScanResult instanceof QRCodeScanResult.UnsignedInteger)) {
                return e0.a(((QRCodeScanResult.UnsignedInteger) qRCodeScanResult).m1622getUIntpVg5ArA());
            } else {
                return null;
            }
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    @SuppressLint({"CheckResult"})
    private final boolean handleQrResult(QRCodeScanResult qRCodeScanResult, boolean z) {
        if (qRCodeScanResult == null) {
            return false;
        }
        if (z) {
            String handleMetadataResult = handleMetadataResult(qRCodeScanResult);
            if (handleMetadataResult != null) {
                this.metadataScanResultSubject.onNext(handleMetadataResult);
                return true;
            }
            return false;
        }
        QrResult handleMainQrResult = handleMainQrResult(qRCodeScanResult);
        String destination = handleMainQrResult.getDestination();
        if (destination == null) {
            return false;
        }
        if (!isMetadataAvailable()) {
            confirmSendToAddress(destination, null).subscribe();
            return true;
        }
        String metadata = handleMainQrResult.getMetadata();
        if (metadata == null) {
            this.recipientScanResultSubject.onNext(destination);
            return true;
        }
        confirmSendToAddress(destination, metadata).subscribe();
        return true;
    }

    private final h.c.b0<Boolean> isValidAddress(String str) {
        Map map;
        if (str.length() == 0) {
            h.c.b0<Boolean> just = h.c.b0.just(Boolean.FALSE);
            kotlin.jvm.internal.m.f(just, "just(false)");
            return just;
        }
        int length = str.length();
        map = SendDestinationPickerViewModelKt.blockchainMinAddressLength;
        Wallet wallet = this.wallet;
        if (wallet == null) {
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        } else if (length < ((Number) Map_CoreKt.require(map, wallet.getBlockchain())).intValue()) {
            h.c.b0<Boolean> just2 = h.c.b0.just(Boolean.FALSE);
            kotlin.jvm.internal.m.f(just2, "just(false)");
            return just2;
        } else {
            ITxRepository iTxRepository = this.txRepository;
            Wallet wallet2 = this.wallet;
            if (wallet2 == null) {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
            Blockchain blockchain = wallet2.getBlockchain();
            Wallet wallet3 = this.wallet;
            if (wallet3 != null) {
                return iTxRepository.isValidAddress(blockchain, wallet3.getNetwork(), str);
            }
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
    }

    public final boolean isValidMetadata(String str) {
        if (isMetadataAvailable()) {
            if (str == null || str.length() == 0) {
                return true;
            }
            Wallet wallet = this.wallet;
            if (wallet == null) {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
            Blockchain blockchain = wallet.getBlockchain();
            Blockchain.Companion companion = Blockchain.Companion;
            if (kotlin.jvm.internal.m.c(blockchain, Blockchain_RippleKt.getXRP(companion))) {
                return getMetadata(TxMetadataKey_RippleKt.getDestinationTag(TxMetadataKey.Companion), str) != null;
            }
            Wallet wallet2 = this.wallet;
            if (wallet2 != null) {
                return kotlin.jvm.internal.m.c(wallet2.getBlockchain(), Blockchain_StellarKt.getSTELLAR(companion)) && getMetadata(this.selectedMemoType.q(), str) != null;
            }
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0190 A[LOOP:0: B:174:0x018a->B:176:0x0190, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0234  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void processSearchResults(java.lang.String r27, java.util.List<com.coinbase.wallet.features.send.models.AddressSearchResult> r28, boolean r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel.processSearchResults(java.lang.String, java.util.List, boolean, boolean):void");
    }

    public final void setSearching(boolean z) {
        didSetIsSearching();
        this.isSearching = z;
    }

    public final void setState(SendDestinationPickerState sendDestinationPickerState) {
        getStateSubject().onNext(sendDestinationPickerState);
        this.state = sendDestinationPickerState;
    }

    public final h.c.b0<kotlin.x> confirmSend(SendDestinationViewInfo sendDestinationViewInfo) {
        kotlin.o a;
        kotlin.jvm.internal.m.g(sendDestinationViewInfo, "sendDestinationViewInfo");
        int i2 = WhenMappings.$EnumSwitchMapping$0[sendDestinationViewInfo.getRecipientType().ordinal()];
        if (i2 == 1) {
            a = kotlin.u.a(null, null);
        } else if (i2 == 2) {
            a = kotlin.u.a(null, null);
        } else if (i2 == 3) {
            a = kotlin.u.a(null, null);
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            a = kotlin.u.a(sendDestinationViewInfo.getMetadataKey(), sendDestinationViewInfo.getMetadata());
        }
        TxMetadataKey txMetadataKey = (TxMetadataKey) a.a();
        String str = (String) a.b();
        RecipientRepository recipientRepository = this.recipientRepository;
        Wallet wallet = this.wallet;
        if (wallet != null) {
            Blockchain blockchain = wallet.getBlockchain();
            Wallet wallet2 = this.wallet;
            if (wallet2 != null) {
                CurrencyCode currencyCode = wallet2.getCurrencyCode();
                Wallet wallet3 = this.wallet;
                if (wallet3 != null) {
                    h.c.b0 flatMap = recipientRepository.getRecipient(blockchain, currencyCode, wallet3.getNetwork(), sendDestinationViewInfo.getRecipientType(), sendDestinationViewInfo.getDestination(), txMetadataKey, str).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.s
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return SendDestinationPickerViewModel.a(SendDestinationPickerViewModel.this, (Recipient) obj);
                        }
                    }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.v
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return SendDestinationPickerViewModel.d(SendDestinationPickerViewModel.this, (kotlin.o) obj);
                        }
                    });
                    kotlin.jvm.internal.m.f(flatMap, "recipientRepository\n            .getRecipient(\n                blockchain = wallet.blockchain,\n                currencyCode = wallet.currencyCode,\n                network = wallet.network,\n                recipientType = sendDestinationViewInfo.recipientType,\n                destination = sendDestinationViewInfo.destination,\n                metadataKey = metadataKey,\n                metadata = metadata\n            )\n            .flatMap { recipient -> recipientRepository.resolveAddress(recipient).map { recipient to it } }\n            .flatMap { confirmSend(recipient = it.first, resolution = it.second) }");
                    h.c.b0<kotlin.x> onErrorReturn = Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null).observeOn(h.c.j0.c.a.b()).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.u
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return SendDestinationPickerViewModel.c(SendDestinationPickerViewModel.this, (Throwable) obj);
                        }
                    });
                    kotlin.jvm.internal.m.f(onErrorReturn, "recipientRepository\n            .getRecipient(\n                blockchain = wallet.blockchain,\n                currencyCode = wallet.currencyCode,\n                network = wallet.network,\n                recipientType = sendDestinationViewInfo.recipientType,\n                destination = sendDestinationViewInfo.destination,\n                metadataKey = metadataKey,\n                metadata = metadata\n            )\n            .flatMap { recipient -> recipientRepository.resolveAddress(recipient).map { recipient to it } }\n            .flatMap { confirmSend(recipient = it.first, resolution = it.second) }\n            .logError()\n            .observeOn(AndroidSchedulers.mainThread())\n            .onErrorReturn { err ->\n                if ((err is XrpException && throwableXRPErrors.contains(err)) ||\n                    err is StellarException.RequiresMinimumBalance\n                ) {\n                    throw err\n                }\n\n                launchAddressNotFoundAlertSubject.onNext(Unit)\n                throw err\n            }");
                    return onErrorReturn;
                }
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    public final h.c.b0<kotlin.x> confirmSendToAddress(String address, String str) {
        kotlin.o a;
        kotlin.jvm.internal.m.g(address, "address");
        if (str == null) {
            a = kotlin.u.a(null, null);
        } else {
            Wallet wallet = this.wallet;
            if (wallet == null) {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
            Blockchain blockchain = wallet.getBlockchain();
            Blockchain.Companion companion = Blockchain.Companion;
            if (kotlin.jvm.internal.m.c(blockchain, Blockchain_RippleKt.getXRP(companion))) {
                a = kotlin.u.a(TxMetadataKey_RippleKt.getDestinationTag(TxMetadataKey.Companion), str);
            } else {
                Wallet wallet2 = this.wallet;
                if (wallet2 != null) {
                    a = kotlin.jvm.internal.m.c(wallet2.getBlockchain(), Blockchain_StellarKt.getSTELLAR(companion)) ? kotlin.u.a(this.selectedMemoType.q(), str) : kotlin.u.a(null, null);
                } else {
                    kotlin.jvm.internal.m.w("wallet");
                    throw null;
                }
            }
        }
        return confirmSend(SendDestinationViewInfo.Companion.fromAddress(address, (TxMetadataKey) a.a(), (String) a.b()));
    }

    public final void finishQrScan(List<? extends QRCodeScanResult> results, List<Wallet> wallets, boolean z) {
        kotlin.jvm.internal.m.g(results, "results");
        kotlin.jvm.internal.m.g(wallets, "wallets");
        Object obj = null;
        if (z) {
            Iterator<T> it = results.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (handleQrResult((QRCodeScanResult) next, z)) {
                    obj = next;
                    break;
                }
            }
            if (obj != null) {
                this.dismissScannerSubject.onNext(Boolean.TRUE);
                return;
            }
            return;
        }
        Iterator<T> it2 = wallets.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            Wallet wallet = (Wallet) next2;
            Wallet wallet2 = this.wallet;
            if (wallet2 == null) {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            } else if (kotlin.jvm.internal.m.c(wallet2.getBlockchain(), wallet.getBlockchain())) {
                obj = next2;
                break;
            }
        }
        if (((Wallet) obj) != null && handleQrResult((QRCodeScanResult) kotlin.a0.p.a0(results), z)) {
            this.dismissScannerSubject.onNext(Boolean.TRUE);
        } else {
            this.qrScanErrorSubject.onNext(getQrScanningErrorText());
        }
    }

    public final h.c.s<kotlin.x> getDestinationUpdateObservable() {
        return this.destinationUpdateObservable;
    }

    public final h.c.s<Boolean> getDismissScannerObservable() {
        return this.dismissScannerObservable;
    }

    public final h.c.s<kotlin.x> getLaunchAddressNotFoundAlertObservable() {
        return this.launchAddressNotFoundAlertObservable;
    }

    public final h.c.s<kotlin.x> getLaunchQrScannerObservable() {
        return this.launchQrScannerObservable;
    }

    public final h.c.s<Bundle> getLaunchSendConfirmObservable() {
        return this.launchSendConfirmObservable;
    }

    public final h.c.s<String> getMetadataPlaceholderObservable() {
        return this.metadataPlaceholderObservable;
    }

    public final String getMetadataPlaceholderText() {
        Wallet wallet = this.wallet;
        if (wallet != null) {
            Blockchain blockchain = wallet.getBlockchain();
            Blockchain.Companion companion = Blockchain.Companion;
            return kotlin.jvm.internal.m.c(blockchain, Blockchain_RippleKt.getXRP(companion)) ? LocalizedStrings.INSTANCE.get(R.string.send_destination_metadata_xrp_placeholder) : kotlin.jvm.internal.m.c(blockchain, Blockchain_StellarKt.getSTELLAR(companion)) ? this.selectedMemoType.n() : Strings_CoreKt.getEmpty(Strings.INSTANCE);
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    public final h.c.s<String> getMetadataScanResultObservable() {
        return this.metadataScanResultObservable;
    }

    public final h.c.b0<Optional<String>> getPasteboard() {
        ClipData.Item itemAt;
        CharSequence coerceToText;
        ClipData primaryClip = getClipboardManager().getPrimaryClip();
        final String obj = (primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null || (coerceToText = itemAt.coerceToText(this.context)) == null) ? null : coerceToText.toString();
        if (obj == null) {
            h.c.b0<Optional<String>> just = h.c.b0.just(OptionalKt.toOptional(null));
            kotlin.jvm.internal.m.f(just, "just(null.toOptional())");
            return just;
        }
        ITxRepository iTxRepository = this.txRepository;
        Wallet wallet = this.wallet;
        if (wallet == null) {
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
        Blockchain blockchain = wallet.getBlockchain();
        Wallet wallet2 = this.wallet;
        if (wallet2 != null) {
            h.c.b0 map = iTxRepository.isValidAddress(blockchain, wallet2.getNetwork(), obj).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.x
                @Override // h.c.m0.n
                public final Object apply(Object obj2) {
                    return SendDestinationPickerViewModel.f(obj, (Boolean) obj2);
                }
            });
            kotlin.jvm.internal.m.f(map, "txRepository\n            .isValidAddress(blockchain = wallet.blockchain, network = wallet.network, address = pasteboardString)\n            .map { isValid ->\n                if (!isValid) return@map null.toOptional()\n\n                Analytics.log(AnalyticsEvent.sendDestinationPasteShow())\n\n                pasteboardString.toOptional()\n            }");
            return map;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    public final PendingRecipient getPendingRecipient() {
        return this.pendingRecipient;
    }

    public final h.c.s<String> getQrScanErrorObservable() {
        return this.qrScanErrorObservable;
    }

    public final String getQrScanningErrorText() {
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        Object[] objArr = new Object[1];
        Wallet wallet = this.wallet;
        if (wallet != null) {
            objArr[0] = wallet.getDisplayName();
            return localizedStrings.get(R.string.send_destination_qr_warning, objArr);
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    public final h.c.s<String> getRecipientScanResultObservable() {
        return this.recipientScanResultObservable;
    }

    public final List<SendDestinationPickerRow> getSections() {
        return this.sections;
    }

    public final e.j.k.a.a getSelectedMemoType() {
        return this.selectedMemoType;
    }

    public final h.c.s<SendDestinationPickerState> getStateObservable() {
        return this.stateObservable;
    }

    public final String getValidationErrorText() {
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        Object[] objArr = new Object[1];
        Wallet wallet = this.wallet;
        if (wallet != null) {
            objArr[0] = wallet.getDisplayName();
            return localizedStrings.get(R.string.send_destination_address_error, objArr);
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    public final boolean isMetadataAvailable() {
        Wallet wallet = this.wallet;
        if (wallet != null) {
            Blockchain blockchain = wallet.getBlockchain();
            Blockchain.Companion companion = Blockchain.Companion;
            if (kotlin.jvm.internal.m.c(blockchain, Blockchain_StellarKt.getSTELLAR(companion))) {
                return true;
            }
            return kotlin.jvm.internal.m.c(blockchain, Blockchain_RippleKt.getXRP(companion));
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    public final boolean isValidSendDestination(SendDestinationViewInfo item) {
        kotlin.jvm.internal.m.g(item, "item");
        return ((!isMetadataAvailable() || item.getMetadata() == null) && isMetadataAvailable() && item.getRecipientType() == RecipientType.Address) ? false : true;
    }

    public final void memoTypeButtonTapped() {
        SendDestinationPickerState copy;
        if (this.state.getMemoTypeButtonTapped()) {
            return;
        }
        copy = r2.copy((r30 & 1) != 0 ? r2.errorMessage : null, (r30 & 2) != 0 ? r2.isNextButtonHidden : false, (r30 & 4) != 0 ? r2.isNextButtonLoading : false, (r30 & 8) != 0 ? r2.isPasteboardHidden : false, (r30 & 16) != 0 ? r2.pasteboardText : null, (r30 & 32) != 0 ? r2.isMetadataFieldHidden : false, (r30 & 64) != 0 ? r2.isMetadataButtonHidden : true, (r30 & 128) != 0 ? r2.isErrorMessageHidden : false, (r30 & 256) != 0 ? r2.emptyStateTitle : null, (r30 & 512) != 0 ? r2.emptyStateDetails : null, (r30 & 1024) != 0 ? r2.memoTypeButtonTapped : false, (r30 & PKIFailureInfo.wrongIntegrity) != 0 ? r2.isMetadataFieldErrorLabelHidden : false, (r30 & 4096) != 0 ? r2.metadataFieldErrorMessage : null, (r30 & PKIFailureInfo.certRevoked) != 0 ? this.state.isPasteboardLoading : false);
        setState(copy);
    }

    public final h.c.b0<kotlin.x> nextButtonTapped(String address, String str) {
        SendDestinationPickerState copy;
        kotlin.jvm.internal.m.g(address, "address");
        copy = r3.copy((r30 & 1) != 0 ? r3.errorMessage : null, (r30 & 2) != 0 ? r3.isNextButtonHidden : false, (r30 & 4) != 0 ? r3.isNextButtonLoading : true, (r30 & 8) != 0 ? r3.isPasteboardHidden : false, (r30 & 16) != 0 ? r3.pasteboardText : null, (r30 & 32) != 0 ? r3.isMetadataFieldHidden : false, (r30 & 64) != 0 ? r3.isMetadataButtonHidden : false, (r30 & 128) != 0 ? r3.isErrorMessageHidden : false, (r30 & 256) != 0 ? r3.emptyStateTitle : null, (r30 & 512) != 0 ? r3.emptyStateDetails : null, (r30 & 1024) != 0 ? r3.memoTypeButtonTapped : false, (r30 & PKIFailureInfo.wrongIntegrity) != 0 ? r3.isMetadataFieldErrorLabelHidden : false, (r30 & 4096) != 0 ? r3.metadataFieldErrorMessage : null, (r30 & PKIFailureInfo.certRevoked) != 0 ? this.state.isPasteboardLoading : false);
        setState(copy);
        return confirmSendToAddress(address, str);
    }

    public final h.c.b0<Optional<String>> pasteButtonTapped() {
        SendDestinationPickerState copy;
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendDestinationPasteSelected(AnalyticsEvent.Companion));
        copy = r3.copy((r30 & 1) != 0 ? r3.errorMessage : null, (r30 & 2) != 0 ? r3.isNextButtonHidden : false, (r30 & 4) != 0 ? r3.isNextButtonLoading : false, (r30 & 8) != 0 ? r3.isPasteboardHidden : false, (r30 & 16) != 0 ? r3.pasteboardText : null, (r30 & 32) != 0 ? r3.isMetadataFieldHidden : false, (r30 & 64) != 0 ? r3.isMetadataButtonHidden : false, (r30 & 128) != 0 ? r3.isErrorMessageHidden : false, (r30 & 256) != 0 ? r3.emptyStateTitle : null, (r30 & 512) != 0 ? r3.emptyStateDetails : null, (r30 & 1024) != 0 ? r3.memoTypeButtonTapped : false, (r30 & PKIFailureInfo.wrongIntegrity) != 0 ? r3.isMetadataFieldErrorLabelHidden : false, (r30 & 4096) != 0 ? r3.metadataFieldErrorMessage : null, (r30 & PKIFailureInfo.certRevoked) != 0 ? this.state.isPasteboardLoading : true);
        setState(copy);
        return getPasteboard();
    }

    public final void presentMetadataScanner() {
        this.launchQrScannerSubject.onNext(kotlin.x.a);
    }

    public final void presentQrScanner() {
        this.launchQrScannerSubject.onNext(kotlin.x.a);
    }

    @SuppressLint({"CheckResult"})
    public final void refreshPasteboard() {
        h.c.t0.g.i(getPasteboard(), null, new SendDestinationPickerViewModel$refreshPasteboard$1(this), 1, null);
    }

    public final void search(String str, String str2) {
        if (str == null) {
            return;
        }
        RecipientRepository recipientRepository = this.recipientRepository;
        Wallet wallet = this.wallet;
        if (wallet != null) {
            h.c.b0<List<AddressSearchResult>> search = recipientRepository.search(str, wallet);
            h.c.b0<Boolean> isValidAddress = isValidAddress(str);
            this.currentSearchQuery = str;
            this.currentSearchDisposable.d();
            setSearching(true);
            h.c.b0 observeOn = h.c.t0.e.a.a(search, isValidAddress).observeOn(h.c.j0.c.a.b());
            kotlin.jvm.internal.m.f(observeOn, "Singles.zip(searchAll, validateAddress)\n            .observeOn(AndroidSchedulers.mainThread())");
            h.c.t0.a.a(h.c.t0.g.f(observeOn, new SendDestinationPickerViewModel$search$1(str, this), new SendDestinationPickerViewModel$search$2(str, this, str2)), this.currentSearchDisposable);
            return;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    public final void setAmount(TransferValue amount) {
        kotlin.jvm.internal.m.g(amount, "amount");
        this.amount = amount;
    }

    public final void setPendingRecipient(PendingRecipient pendingRecipient) {
        this.pendingRecipient = pendingRecipient;
    }

    public final void setSections(List<SendDestinationPickerRow> list) {
        kotlin.jvm.internal.m.g(list, "<set-?>");
        this.sections = list;
    }

    public final void setSelectedMemoType(e.j.k.a.a newValue) {
        kotlin.jvm.internal.m.g(newValue, "newValue");
        this.selectedMemoType = newValue;
        this.metadataPlaceholderSubject.onNext(getMetadataPlaceholderText());
    }

    public final void setWallet(Wallet wallet) {
        kotlin.jvm.internal.m.g(wallet, "wallet");
        this.wallet = wallet;
    }

    public final void userIsTyping() {
        SendDestinationPickerState copy;
        setSearching(true);
        copy = r2.copy((r30 & 1) != 0 ? r2.errorMessage : null, (r30 & 2) != 0 ? r2.isNextButtonHidden : true, (r30 & 4) != 0 ? r2.isNextButtonLoading : false, (r30 & 8) != 0 ? r2.isPasteboardHidden : false, (r30 & 16) != 0 ? r2.pasteboardText : null, (r30 & 32) != 0 ? r2.isMetadataFieldHidden : false, (r30 & 64) != 0 ? r2.isMetadataButtonHidden : false, (r30 & 128) != 0 ? r2.isErrorMessageHidden : false, (r30 & 256) != 0 ? r2.emptyStateTitle : null, (r30 & 512) != 0 ? r2.emptyStateDetails : null, (r30 & 1024) != 0 ? r2.memoTypeButtonTapped : false, (r30 & PKIFailureInfo.wrongIntegrity) != 0 ? r2.isMetadataFieldErrorLabelHidden : false, (r30 & 4096) != 0 ? r2.metadataFieldErrorMessage : null, (r30 & PKIFailureInfo.certRevoked) != 0 ? this.state.isPasteboardLoading : false);
        setState(copy);
    }

    private final h.c.b0<kotlin.x> confirmSend(final Recipient recipient, final AddressResolution addressResolution) {
        h.c.b0<kotlin.x> validateTransferTx;
        Object metadata;
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(TxMetadataKey_EthereumKt.getTxSource(TxMetadataKey.Companion), TxSource.Send.getValue());
        if (addressResolution.getMetadataKey() != null && addressResolution.getMetadata() != null && (metadata = getMetadata(addressResolution.getMetadataKey(), addressResolution.getMetadata())) != null) {
            linkedHashMap.put(addressResolution.getMetadataKey(), metadata);
        }
        Wallet wallet = this.wallet;
        if (wallet != null) {
            Blockchain blockchain = wallet.getBlockchain();
            Blockchain.Companion companion = Blockchain.Companion;
            if (!kotlin.jvm.internal.m.c(blockchain, Blockchain_StellarKt.getSTELLAR(companion))) {
                Wallet wallet2 = this.wallet;
                if (wallet2 == null) {
                    kotlin.jvm.internal.m.w("wallet");
                    throw null;
                } else if (!kotlin.jvm.internal.m.c(wallet2.getBlockchain(), Blockchain_RippleKt.getXRP(companion))) {
                    validateTransferTx = h.c.b0.just(kotlin.x.a);
                    kotlin.jvm.internal.m.f(validateTransferTx, "{\n            Single.just(Unit)\n        }");
                    h.c.b0<R> flatMap = validateTransferTx.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.y
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return SendDestinationPickerViewModel.g(Recipient.this, this, addressResolution, (kotlin.x) obj);
                        }
                    });
                    kotlin.jvm.internal.m.f(flatMap, "validationSingle\n            .flatMap {\n                val selectedRecipient = recipient.copy(\n                    sendCount = recipient.sendCount + 1,\n                    lastUsed = Date()\n                )\n                recipientRepository.saveRecipient(recipient = selectedRecipient, resolution = resolution)\n            }");
                    h.c.b0 onErrorResumeNext = Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.z
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return SendDestinationPickerViewModel.h(SendDestinationPickerViewModel.this, addressResolution, linkedHashMap, recipient, (kotlin.x) obj);
                        }
                    }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.t
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return SendDestinationPickerViewModel.b(SendDestinationPickerViewModel.this, (Throwable) obj);
                        }
                    });
                    kotlin.jvm.internal.m.f(onErrorResumeNext, "validationSingle\n            .flatMap {\n                val selectedRecipient = recipient.copy(\n                    sendCount = recipient.sendCount + 1,\n                    lastUsed = Date()\n                )\n                recipientRepository.saveRecipient(recipient = selectedRecipient, resolution = resolution)\n            }\n            .logError()\n            .observeOn(AndroidSchedulers.mainThread())\n            .map {\n                val dialog = SendConfirmationArgs.createArguments(\n                    wallet = wallet,\n                    amount = amount,\n                    recipient = recipient,\n                    recipientAddress = resolution.address,\n                    metadata = TxMetadata(metadata.toMap())\n                )\n\n                launchSendConfirmSubject.onNext(dialog)\n\n                state = state.copy(\n                    errorMessage = null,\n                    isNextButtonLoading = false,\n                    isPasteboardHidden = true,\n                    pasteboardText = null,\n                    isErrorMessageHidden = true\n                )\n\n                val event = AnalyticsEvent.recipientSelected(\n                    recipientType = recipient.recipientType,\n                    currencyCode = wallet.currencyCode,\n                    searchQueryLength = currentSearchQuery.length,\n                    sendCount = recipient.sendCount\n                )\n\n                Analytics.log(event)\n            }\n            .onErrorResumeNext { err ->\n                state = state.copy(\n                    errorMessage = err.localizedMessage,\n                    isNextButtonHidden = true,\n                    isNextButtonLoading = false,\n                    isPasteboardHidden = true,\n                    pasteboardText = null,\n                    isErrorMessageHidden = false\n                )\n                Single.error(err)\n            }");
                    return Single_CoreKt.asUnit(onErrorResumeNext);
                }
            }
            Wallet wallet3 = this.wallet;
            if (wallet3 != null) {
                String address = addressResolution.getAddress();
                TransferValue transferValue = this.amount;
                if (transferValue != null) {
                    validateTransferTx = this.txRepository.validateTransferTx(wallet3, transferValue, address, linkedHashMap);
                    h.c.b0<R> flatMap2 = validateTransferTx.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.y
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return SendDestinationPickerViewModel.g(Recipient.this, this, addressResolution, (kotlin.x) obj);
                        }
                    });
                    kotlin.jvm.internal.m.f(flatMap2, "validationSingle\n            .flatMap {\n                val selectedRecipient = recipient.copy(\n                    sendCount = recipient.sendCount + 1,\n                    lastUsed = Date()\n                )\n                recipientRepository.saveRecipient(recipient = selectedRecipient, resolution = resolution)\n            }");
                    h.c.b0 onErrorResumeNext2 = Single_AnalyticsKt.logError$default(flatMap2, null, null, 3, null).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.z
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return SendDestinationPickerViewModel.h(SendDestinationPickerViewModel.this, addressResolution, linkedHashMap, recipient, (kotlin.x) obj);
                        }
                    }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.t
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return SendDestinationPickerViewModel.b(SendDestinationPickerViewModel.this, (Throwable) obj);
                        }
                    });
                    kotlin.jvm.internal.m.f(onErrorResumeNext2, "validationSingle\n            .flatMap {\n                val selectedRecipient = recipient.copy(\n                    sendCount = recipient.sendCount + 1,\n                    lastUsed = Date()\n                )\n                recipientRepository.saveRecipient(recipient = selectedRecipient, resolution = resolution)\n            }\n            .logError()\n            .observeOn(AndroidSchedulers.mainThread())\n            .map {\n                val dialog = SendConfirmationArgs.createArguments(\n                    wallet = wallet,\n                    amount = amount,\n                    recipient = recipient,\n                    recipientAddress = resolution.address,\n                    metadata = TxMetadata(metadata.toMap())\n                )\n\n                launchSendConfirmSubject.onNext(dialog)\n\n                state = state.copy(\n                    errorMessage = null,\n                    isNextButtonLoading = false,\n                    isPasteboardHidden = true,\n                    pasteboardText = null,\n                    isErrorMessageHidden = true\n                )\n\n                val event = AnalyticsEvent.recipientSelected(\n                    recipientType = recipient.recipientType,\n                    currencyCode = wallet.currencyCode,\n                    searchQueryLength = currentSearchQuery.length,\n                    sendCount = recipient.sendCount\n                )\n\n                Analytics.log(event)\n            }\n            .onErrorResumeNext { err ->\n                state = state.copy(\n                    errorMessage = err.localizedMessage,\n                    isNextButtonHidden = true,\n                    isNextButtonLoading = false,\n                    isPasteboardHidden = true,\n                    pasteboardText = null,\n                    isErrorMessageHidden = false\n                )\n                Single.error(err)\n            }");
                    return Single_CoreKt.asUnit(onErrorResumeNext2);
                }
                kotlin.jvm.internal.m.w("amount");
                throw null;
            }
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }
}