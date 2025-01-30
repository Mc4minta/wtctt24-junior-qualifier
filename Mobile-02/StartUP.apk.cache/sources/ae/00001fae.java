package com.coinbase.wallet.features.send.models;

import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.o;

/* compiled from: ConfirmationSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0016\u0010\u001c\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001a\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u0019\u0010\u0015\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R)\u0010\u001c\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000bR\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/features/send/models/ConfirmationSettings;", "", "", "containerViewColor", "I", "getContainerViewColor", "()I", "", "toLabelText", "Ljava/lang/String;", "getToLabelText", "()Ljava/lang/String;", "", "hideAnnualInterest", "Z", "getHideAnnualInterest", "()Z", "cryptoAmountTextColor", "getCryptoAmountTextColor", "modeText", "getModeText", "isLend", "recipientTextColor", "getRecipientTextColor", "fiatAmountTextColor", "getFiatAmountTextColor", "Lkotlin/o;", "Ljava/net/URL;", "iconImage", "Lkotlin/o;", "getIconImage", "()Lkotlin/o;", "proceedButtonText", "getProceedButtonText", "proceedButtonBackground", "getProceedButtonBackground", "<init>", "(Ljava/lang/String;ZZIIILjava/lang/String;Lkotlin/o;ILjava/lang/String;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConfirmationSettings {
    private final int containerViewColor;
    private final int cryptoAmountTextColor;
    private final int fiatAmountTextColor;
    private final boolean hideAnnualInterest;
    private final o<URL, Integer> iconImage;
    private final boolean isLend;
    private final String modeText;
    private final int proceedButtonBackground;
    private final String proceedButtonText;
    private final int recipientTextColor;
    private final String toLabelText;

    public ConfirmationSettings(String modeText, boolean z, boolean z2, int i2, int i3, int i4, String toLabelText, o<URL, Integer> iconImage, int i5, String proceedButtonText, int i6) {
        m.g(modeText, "modeText");
        m.g(toLabelText, "toLabelText");
        m.g(iconImage, "iconImage");
        m.g(proceedButtonText, "proceedButtonText");
        this.modeText = modeText;
        this.isLend = z;
        this.hideAnnualInterest = z2;
        this.fiatAmountTextColor = i2;
        this.cryptoAmountTextColor = i3;
        this.recipientTextColor = i4;
        this.toLabelText = toLabelText;
        this.iconImage = iconImage;
        this.containerViewColor = i5;
        this.proceedButtonText = proceedButtonText;
        this.proceedButtonBackground = i6;
    }

    public final int getContainerViewColor() {
        return this.containerViewColor;
    }

    public final int getCryptoAmountTextColor() {
        return this.cryptoAmountTextColor;
    }

    public final int getFiatAmountTextColor() {
        return this.fiatAmountTextColor;
    }

    public final boolean getHideAnnualInterest() {
        return this.hideAnnualInterest;
    }

    public final o<URL, Integer> getIconImage() {
        return this.iconImage;
    }

    public final String getModeText() {
        return this.modeText;
    }

    public final int getProceedButtonBackground() {
        return this.proceedButtonBackground;
    }

    public final String getProceedButtonText() {
        return this.proceedButtonText;
    }

    public final int getRecipientTextColor() {
        return this.recipientTextColor;
    }

    public final String getToLabelText() {
        return this.toLabelText;
    }

    public final boolean isLend() {
        return this.isLend;
    }
}