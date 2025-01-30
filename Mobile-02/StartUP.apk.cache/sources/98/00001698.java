package com.coinbase.wallet.consumer.models;

import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: ConsumerTransferConfirmationViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\bE\b\u0086\b\u0018\u00002\u00020\u0001Bÿ\u0001\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\b\b\u0002\u0010&\u001a\u00020\u0006\u0012\b\b\u0002\u0010'\u001a\u00020\u0006\u0012\b\b\u0002\u0010(\u001a\u00020\u0006\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010,\u001a\u00020\u0003\u0012\b\b\u0002\u0010-\u001a\u00020\u0006\u0012\b\b\u0002\u0010.\u001a\u00020\u0006\u0012\b\b\u0002\u0010/\u001a\u00020\u0006\u0012\b\b\u0002\u00100\u001a\u00020\u0006\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u00102\u001a\u00020\u0006\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00107\u001a\u00020\u0003\u0012\b\b\u0002\u00108\u001a\u00020\u0006\u0012\b\b\u0002\u00109\u001a\u00020\u0003\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b]\u0010^J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0013\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0015\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\bJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0017\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\bJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0019\u0010\bJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001d\u0010\bJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b \u0010\u0012J\u0010\u0010!\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b!\u0010\bJ\u0010\u0010\"\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\"\u0010\u0012J\u0012\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b#\u0010\bJ\u0010\u0010$\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b$\u0010\u0012J\u0088\u0002\u0010;\u001a\u00020\u00002\b\b\u0002\u0010%\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020\u00062\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u00062\b\b\u0002\u00100\u001a\u00020\u00062\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u00102\u001a\u00020\u00062\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00107\u001a\u00020\u00032\b\b\u0002\u00108\u001a\u00020\u00062\b\b\u0002\u00109\u001a\u00020\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b=\u0010\bJ\u0010\u0010>\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b>\u0010?J\u001a\u0010@\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b@\u0010AR\u0019\u0010/\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010B\u001a\u0004\bC\u0010\bR\u0019\u0010,\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010D\u001a\u0004\b,\u0010\u0012R\u0019\u0010%\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010B\u001a\u0004\bE\u0010\bR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010D\u001a\u0004\bF\u0010\u0012R\u0019\u00109\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010D\u001a\u0004\bG\u0010\u0012R\u0019\u0010'\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010B\u001a\u0004\bH\u0010\bR\u001b\u00106\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010I\u001a\u0004\bJ\u0010\u001fR\u0019\u0010-\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010B\u001a\u0004\bK\u0010\bR\u001b\u0010)\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010B\u001a\u0004\bL\u0010\bR\u001b\u0010:\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010B\u001a\u0004\bM\u0010\bR\u001b\u00105\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010B\u001a\u0004\bN\u0010\bR\u0019\u00107\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010D\u001a\u0004\bO\u0010\u0012R\u0019\u00108\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010B\u001a\u0004\bP\u0010\bR\u001b\u0010+\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010B\u001a\u0004\bQ\u0010\bR\u001b\u00101\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010B\u001a\u0004\bR\u0010\bR\u0019\u00100\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010B\u001a\u0004\bS\u0010\bR\u0019\u0010&\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010B\u001a\u0004\bT\u0010\bR\u0019\u0010.\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010B\u001a\u0004\bU\u0010\bR\u001b\u0010*\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010V\u001a\u0004\bW\u0010\u000fR\u0019\u00102\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010B\u001a\u0004\bX\u0010\bR\u001b\u00104\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010Y\u001a\u0004\bZ\u0010\u001cR\u0019\u0010(\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010B\u001a\u0004\b[\u0010\bR\u001b\u00103\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010B\u001a\u0004\b\\\u0010\b¨\u0006_"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTransferConfirmationViewState;", "", "other", "", "detailsChanged", "(Lcom/coinbase/wallet/consumer/models/ConsumerTransferConfirmationViewState;)Z", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()Ljava/lang/Integer;", "component7", "component8", "()Z", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "component16", "()Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "component17", "component18", "()Ljava/lang/Boolean;", "component19", "component20", "component21", "component22", "component23", "modeText", "progressButtonText", "fromLabel", "fromPrimaryText", "fromSecondaryText", "fromImage", "fromImageUrl", "isDetailsShowing", "primaryAmount", "secondaryAmount", "minerFeePrimaryAmount", "minerFeeSecondaryAmount", "totalPrimaryAmount", "totalSecondaryAmount", "coinbaseFeeAmount", "selectedTransferMethod", "selectedTransferMethodText", "loading", "onrampEnabled", "transferExplanation", "showWorldpay", "errorText", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/consumer/models/AvailableTransfer;Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/String;ZLjava/lang/String;Z)Lcom/coinbase/wallet/consumer/models/ConsumerTransferConfirmationViewState;", "toString", "hashCode", "()I", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMinerFeePrimaryAmount", "Z", "getModeText", "getDetailsChanged", "getShowWorldpay", "getFromLabel", "Ljava/lang/Boolean;", "getLoading", "getPrimaryAmount", "getFromSecondaryText", "getErrorText", "getSelectedTransferMethodText", "getOnrampEnabled", "getTransferExplanation", "getFromImageUrl", "getTotalPrimaryAmount", "getMinerFeeSecondaryAmount", "getProgressButtonText", "getSecondaryAmount", "Ljava/lang/Integer;", "getFromImage", "getTotalSecondaryAmount", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "getSelectedTransferMethod", "getFromPrimaryText", "getCoinbaseFeeAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/consumer/models/AvailableTransfer;Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/String;ZLjava/lang/String;Z)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferConfirmationViewState {
    private final String coinbaseFeeAmount;
    private final boolean detailsChanged;
    private final String errorText;
    private final Integer fromImage;
    private final String fromImageUrl;
    private final String fromLabel;
    private final String fromPrimaryText;
    private final String fromSecondaryText;
    private final boolean isDetailsShowing;
    private final Boolean loading;
    private final String minerFeePrimaryAmount;
    private final String minerFeeSecondaryAmount;
    private final String modeText;
    private final boolean onrampEnabled;
    private final String primaryAmount;
    private final String progressButtonText;
    private final String secondaryAmount;
    private final AvailableTransfer selectedTransferMethod;
    private final String selectedTransferMethodText;
    private final boolean showWorldpay;
    private final String totalPrimaryAmount;
    private final String totalSecondaryAmount;
    private final String transferExplanation;

    public ConsumerTransferConfirmationViewState() {
        this(null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, false, null, false, null, false, 8388607, null);
    }

    public ConsumerTransferConfirmationViewState(String modeText, String progressButtonText, String fromLabel, String fromPrimaryText, String str, Integer num, String str2, boolean z, String primaryAmount, String secondaryAmount, String minerFeePrimaryAmount, String minerFeeSecondaryAmount, String str3, String totalSecondaryAmount, String str4, AvailableTransfer availableTransfer, String str5, Boolean bool, boolean z2, String transferExplanation, boolean z3, String str6, boolean z4) {
        m.g(modeText, "modeText");
        m.g(progressButtonText, "progressButtonText");
        m.g(fromLabel, "fromLabel");
        m.g(fromPrimaryText, "fromPrimaryText");
        m.g(primaryAmount, "primaryAmount");
        m.g(secondaryAmount, "secondaryAmount");
        m.g(minerFeePrimaryAmount, "minerFeePrimaryAmount");
        m.g(minerFeeSecondaryAmount, "minerFeeSecondaryAmount");
        m.g(totalSecondaryAmount, "totalSecondaryAmount");
        m.g(transferExplanation, "transferExplanation");
        this.modeText = modeText;
        this.progressButtonText = progressButtonText;
        this.fromLabel = fromLabel;
        this.fromPrimaryText = fromPrimaryText;
        this.fromSecondaryText = str;
        this.fromImage = num;
        this.fromImageUrl = str2;
        this.isDetailsShowing = z;
        this.primaryAmount = primaryAmount;
        this.secondaryAmount = secondaryAmount;
        this.minerFeePrimaryAmount = minerFeePrimaryAmount;
        this.minerFeeSecondaryAmount = minerFeeSecondaryAmount;
        this.totalPrimaryAmount = str3;
        this.totalSecondaryAmount = totalSecondaryAmount;
        this.coinbaseFeeAmount = str4;
        this.selectedTransferMethod = availableTransfer;
        this.selectedTransferMethodText = str5;
        this.loading = bool;
        this.onrampEnabled = z2;
        this.transferExplanation = transferExplanation;
        this.showWorldpay = z3;
        this.errorText = str6;
        this.detailsChanged = z4;
    }

    public final String component1() {
        return this.modeText;
    }

    public final String component10() {
        return this.secondaryAmount;
    }

    public final String component11() {
        return this.minerFeePrimaryAmount;
    }

    public final String component12() {
        return this.minerFeeSecondaryAmount;
    }

    public final String component13() {
        return this.totalPrimaryAmount;
    }

    public final String component14() {
        return this.totalSecondaryAmount;
    }

    public final String component15() {
        return this.coinbaseFeeAmount;
    }

    public final AvailableTransfer component16() {
        return this.selectedTransferMethod;
    }

    public final String component17() {
        return this.selectedTransferMethodText;
    }

    public final Boolean component18() {
        return this.loading;
    }

    public final boolean component19() {
        return this.onrampEnabled;
    }

    public final String component2() {
        return this.progressButtonText;
    }

    public final String component20() {
        return this.transferExplanation;
    }

    public final boolean component21() {
        return this.showWorldpay;
    }

    public final String component22() {
        return this.errorText;
    }

    public final boolean component23() {
        return this.detailsChanged;
    }

    public final String component3() {
        return this.fromLabel;
    }

    public final String component4() {
        return this.fromPrimaryText;
    }

    public final String component5() {
        return this.fromSecondaryText;
    }

    public final Integer component6() {
        return this.fromImage;
    }

    public final String component7() {
        return this.fromImageUrl;
    }

    public final boolean component8() {
        return this.isDetailsShowing;
    }

    public final String component9() {
        return this.primaryAmount;
    }

    public final ConsumerTransferConfirmationViewState copy(String modeText, String progressButtonText, String fromLabel, String fromPrimaryText, String str, Integer num, String str2, boolean z, String primaryAmount, String secondaryAmount, String minerFeePrimaryAmount, String minerFeeSecondaryAmount, String str3, String totalSecondaryAmount, String str4, AvailableTransfer availableTransfer, String str5, Boolean bool, boolean z2, String transferExplanation, boolean z3, String str6, boolean z4) {
        m.g(modeText, "modeText");
        m.g(progressButtonText, "progressButtonText");
        m.g(fromLabel, "fromLabel");
        m.g(fromPrimaryText, "fromPrimaryText");
        m.g(primaryAmount, "primaryAmount");
        m.g(secondaryAmount, "secondaryAmount");
        m.g(minerFeePrimaryAmount, "minerFeePrimaryAmount");
        m.g(minerFeeSecondaryAmount, "minerFeeSecondaryAmount");
        m.g(totalSecondaryAmount, "totalSecondaryAmount");
        m.g(transferExplanation, "transferExplanation");
        return new ConsumerTransferConfirmationViewState(modeText, progressButtonText, fromLabel, fromPrimaryText, str, num, str2, z, primaryAmount, secondaryAmount, minerFeePrimaryAmount, minerFeeSecondaryAmount, str3, totalSecondaryAmount, str4, availableTransfer, str5, bool, z2, transferExplanation, z3, str6, z4);
    }

    public final boolean detailsChanged(ConsumerTransferConfirmationViewState other) {
        m.g(other, "other");
        return (this.isDetailsShowing == other.isDetailsShowing && m.c(this.minerFeePrimaryAmount, other.minerFeePrimaryAmount) && m.c(this.minerFeeSecondaryAmount, other.minerFeeSecondaryAmount) && m.c(this.coinbaseFeeAmount, other.coinbaseFeeAmount) && m.c(this.transferExplanation, other.transferExplanation) && this.showWorldpay == other.showWorldpay && m.c(this.errorText, other.errorText)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerTransferConfirmationViewState) {
            ConsumerTransferConfirmationViewState consumerTransferConfirmationViewState = (ConsumerTransferConfirmationViewState) obj;
            return m.c(this.modeText, consumerTransferConfirmationViewState.modeText) && m.c(this.progressButtonText, consumerTransferConfirmationViewState.progressButtonText) && m.c(this.fromLabel, consumerTransferConfirmationViewState.fromLabel) && m.c(this.fromPrimaryText, consumerTransferConfirmationViewState.fromPrimaryText) && m.c(this.fromSecondaryText, consumerTransferConfirmationViewState.fromSecondaryText) && m.c(this.fromImage, consumerTransferConfirmationViewState.fromImage) && m.c(this.fromImageUrl, consumerTransferConfirmationViewState.fromImageUrl) && this.isDetailsShowing == consumerTransferConfirmationViewState.isDetailsShowing && m.c(this.primaryAmount, consumerTransferConfirmationViewState.primaryAmount) && m.c(this.secondaryAmount, consumerTransferConfirmationViewState.secondaryAmount) && m.c(this.minerFeePrimaryAmount, consumerTransferConfirmationViewState.minerFeePrimaryAmount) && m.c(this.minerFeeSecondaryAmount, consumerTransferConfirmationViewState.minerFeeSecondaryAmount) && m.c(this.totalPrimaryAmount, consumerTransferConfirmationViewState.totalPrimaryAmount) && m.c(this.totalSecondaryAmount, consumerTransferConfirmationViewState.totalSecondaryAmount) && m.c(this.coinbaseFeeAmount, consumerTransferConfirmationViewState.coinbaseFeeAmount) && m.c(this.selectedTransferMethod, consumerTransferConfirmationViewState.selectedTransferMethod) && m.c(this.selectedTransferMethodText, consumerTransferConfirmationViewState.selectedTransferMethodText) && m.c(this.loading, consumerTransferConfirmationViewState.loading) && this.onrampEnabled == consumerTransferConfirmationViewState.onrampEnabled && m.c(this.transferExplanation, consumerTransferConfirmationViewState.transferExplanation) && this.showWorldpay == consumerTransferConfirmationViewState.showWorldpay && m.c(this.errorText, consumerTransferConfirmationViewState.errorText) && this.detailsChanged == consumerTransferConfirmationViewState.detailsChanged;
        }
        return false;
    }

    public final String getCoinbaseFeeAmount() {
        return this.coinbaseFeeAmount;
    }

    public final boolean getDetailsChanged() {
        return this.detailsChanged;
    }

    public final String getErrorText() {
        return this.errorText;
    }

    public final Integer getFromImage() {
        return this.fromImage;
    }

    public final String getFromImageUrl() {
        return this.fromImageUrl;
    }

    public final String getFromLabel() {
        return this.fromLabel;
    }

    public final String getFromPrimaryText() {
        return this.fromPrimaryText;
    }

    public final String getFromSecondaryText() {
        return this.fromSecondaryText;
    }

    public final Boolean getLoading() {
        return this.loading;
    }

    public final String getMinerFeePrimaryAmount() {
        return this.minerFeePrimaryAmount;
    }

    public final String getMinerFeeSecondaryAmount() {
        return this.minerFeeSecondaryAmount;
    }

    public final String getModeText() {
        return this.modeText;
    }

    public final boolean getOnrampEnabled() {
        return this.onrampEnabled;
    }

    public final String getPrimaryAmount() {
        return this.primaryAmount;
    }

    public final String getProgressButtonText() {
        return this.progressButtonText;
    }

    public final String getSecondaryAmount() {
        return this.secondaryAmount;
    }

    public final AvailableTransfer getSelectedTransferMethod() {
        return this.selectedTransferMethod;
    }

    public final String getSelectedTransferMethodText() {
        return this.selectedTransferMethodText;
    }

    public final boolean getShowWorldpay() {
        return this.showWorldpay;
    }

    public final String getTotalPrimaryAmount() {
        return this.totalPrimaryAmount;
    }

    public final String getTotalSecondaryAmount() {
        return this.totalSecondaryAmount;
    }

    public final String getTransferExplanation() {
        return this.transferExplanation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.modeText.hashCode() * 31) + this.progressButtonText.hashCode()) * 31) + this.fromLabel.hashCode()) * 31) + this.fromPrimaryText.hashCode()) * 31;
        String str = this.fromSecondaryText;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.fromImage;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.fromImageUrl;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.isDetailsShowing;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int hashCode5 = (((((((((hashCode4 + i2) * 31) + this.primaryAmount.hashCode()) * 31) + this.secondaryAmount.hashCode()) * 31) + this.minerFeePrimaryAmount.hashCode()) * 31) + this.minerFeeSecondaryAmount.hashCode()) * 31;
        String str3 = this.totalPrimaryAmount;
        int hashCode6 = (((hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.totalSecondaryAmount.hashCode()) * 31;
        String str4 = this.coinbaseFeeAmount;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        AvailableTransfer availableTransfer = this.selectedTransferMethod;
        int hashCode8 = (hashCode7 + (availableTransfer == null ? 0 : availableTransfer.hashCode())) * 31;
        String str5 = this.selectedTransferMethodText;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.loading;
        int hashCode10 = (hashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        boolean z2 = this.onrampEnabled;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int hashCode11 = (((hashCode10 + i3) * 31) + this.transferExplanation.hashCode()) * 31;
        boolean z3 = this.showWorldpay;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (hashCode11 + i4) * 31;
        String str6 = this.errorText;
        int hashCode12 = (i5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z4 = this.detailsChanged;
        return hashCode12 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final boolean isDetailsShowing() {
        return this.isDetailsShowing;
    }

    public String toString() {
        return "ConsumerTransferConfirmationViewState(modeText=" + this.modeText + ", progressButtonText=" + this.progressButtonText + ", fromLabel=" + this.fromLabel + ", fromPrimaryText=" + this.fromPrimaryText + ", fromSecondaryText=" + ((Object) this.fromSecondaryText) + ", fromImage=" + this.fromImage + ", fromImageUrl=" + ((Object) this.fromImageUrl) + ", isDetailsShowing=" + this.isDetailsShowing + ", primaryAmount=" + this.primaryAmount + ", secondaryAmount=" + this.secondaryAmount + ", minerFeePrimaryAmount=" + this.minerFeePrimaryAmount + ", minerFeeSecondaryAmount=" + this.minerFeeSecondaryAmount + ", totalPrimaryAmount=" + ((Object) this.totalPrimaryAmount) + ", totalSecondaryAmount=" + this.totalSecondaryAmount + ", coinbaseFeeAmount=" + ((Object) this.coinbaseFeeAmount) + ", selectedTransferMethod=" + this.selectedTransferMethod + ", selectedTransferMethodText=" + ((Object) this.selectedTransferMethodText) + ", loading=" + this.loading + ", onrampEnabled=" + this.onrampEnabled + ", transferExplanation=" + this.transferExplanation + ", showWorldpay=" + this.showWorldpay + ", errorText=" + ((Object) this.errorText) + ", detailsChanged=" + this.detailsChanged + ')';
    }

    public /* synthetic */ ConsumerTransferConfirmationViewState(String str, String str2, String str3, String str4, String str5, Integer num, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, String str12, String str13, AvailableTransfer availableTransfer, String str14, Boolean bool, boolean z2, String str15, boolean z3, String str16, boolean z4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, (i2 & 2) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str2, (i2 & 4) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str3, (i2 & 8) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : num, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str7, (i2 & 512) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str8, (i2 & 1024) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str9, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str10, (i2 & 4096) != 0 ? null : str11, (i2 & PKIFailureInfo.certRevoked) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str12, (i2 & 16384) != 0 ? null : str13, (i2 & 32768) != 0 ? null : availableTransfer, (i2 & 65536) != 0 ? null : str14, (i2 & PKIFailureInfo.unsupportedVersion) != 0 ? null : bool, (i2 & PKIFailureInfo.transactionIdInUse) != 0 ? true : z2, (i2 & PKIFailureInfo.signerNotTrusted) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str15, (i2 & PKIFailureInfo.badCertTemplate) != 0 ? false : z3, (i2 & PKIFailureInfo.badSenderNonce) != 0 ? null : str16, (i2 & 4194304) != 0 ? false : z4);
    }
}