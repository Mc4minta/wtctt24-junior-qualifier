package com.coinbase.wallet.txhistory.models;

import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: ReceiptCellViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BW\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b-\u0010.Bc\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010/\u001a\u00020\u001e¢\u0006\u0004\b-\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010Jl\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0018\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0010J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010\tR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b&\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010\u000eR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b)\u0010\tR\u0019\u0010\u0018\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b+\u0010\u0010R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b,\u0010\u0004¨\u00061"}, d2 = {"Lcom/coinbase/wallet/txhistory/models/ReceiptCellViewState;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Ljava/net/URL;", "component4", "()Ljava/net/URL;", "component5", "component6", "", "component7", "()Ljava/lang/Integer;", "component8", "()I", MessageBundle.TITLE_ENTRY, "titleDetail", "value", "valueImageUrl", "valueDetail", "valueDetailImageUrl", "tintColor", "valueFont", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Ljava/lang/String;Ljava/net/URL;Ljava/lang/Integer;I)Lcom/coinbase/wallet/txhistory/models/ReceiptCellViewState;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/net/URL;", "getValueDetailImageUrl", "Ljava/lang/String;", "getTitleDetail", "getValue", "getTitle", "Ljava/lang/Integer;", "getTintColor", "getValueImageUrl", "I", "getValueFont", "getValueDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Ljava/lang/String;Ljava/net/URL;Ljava/lang/Integer;I)V", "useHighLegibilityValueFont", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Ljava/lang/String;Ljava/net/URL;Ljava/lang/Integer;Z)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ReceiptCellViewState {
    private final Integer tintColor;
    private final String title;
    private final String titleDetail;
    private final String value;
    private final String valueDetail;
    private final URL valueDetailImageUrl;
    private final int valueFont;
    private final URL valueImageUrl;

    public ReceiptCellViewState(String title, String str, String str2, URL url, String str3, URL url2, Integer num, int i2) {
        m.g(title, "title");
        this.title = title;
        this.titleDetail = str;
        this.value = str2;
        this.valueImageUrl = url;
        this.valueDetail = str3;
        this.valueDetailImageUrl = url2;
        this.tintColor = num;
        this.valueFont = i2;
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.titleDetail;
    }

    public final String component3() {
        return this.value;
    }

    public final URL component4() {
        return this.valueImageUrl;
    }

    public final String component5() {
        return this.valueDetail;
    }

    public final URL component6() {
        return this.valueDetailImageUrl;
    }

    public final Integer component7() {
        return this.tintColor;
    }

    public final int component8() {
        return this.valueFont;
    }

    public final ReceiptCellViewState copy(String title, String str, String str2, URL url, String str3, URL url2, Integer num, int i2) {
        m.g(title, "title");
        return new ReceiptCellViewState(title, str, str2, url, str3, url2, num, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReceiptCellViewState) {
            ReceiptCellViewState receiptCellViewState = (ReceiptCellViewState) obj;
            return m.c(this.title, receiptCellViewState.title) && m.c(this.titleDetail, receiptCellViewState.titleDetail) && m.c(this.value, receiptCellViewState.value) && m.c(this.valueImageUrl, receiptCellViewState.valueImageUrl) && m.c(this.valueDetail, receiptCellViewState.valueDetail) && m.c(this.valueDetailImageUrl, receiptCellViewState.valueDetailImageUrl) && m.c(this.tintColor, receiptCellViewState.tintColor) && this.valueFont == receiptCellViewState.valueFont;
        }
        return false;
    }

    public final Integer getTintColor() {
        return this.tintColor;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleDetail() {
        return this.titleDetail;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getValueDetail() {
        return this.valueDetail;
    }

    public final URL getValueDetailImageUrl() {
        return this.valueDetailImageUrl;
    }

    public final int getValueFont() {
        return this.valueFont;
    }

    public final URL getValueImageUrl() {
        return this.valueImageUrl;
    }

    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        String str = this.titleDetail;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.value;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        URL url = this.valueImageUrl;
        int hashCode4 = (hashCode3 + (url == null ? 0 : url.hashCode())) * 31;
        String str3 = this.valueDetail;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        URL url2 = this.valueDetailImageUrl;
        int hashCode6 = (hashCode5 + (url2 == null ? 0 : url2.hashCode())) * 31;
        Integer num = this.tintColor;
        return ((hashCode6 + (num != null ? num.hashCode() : 0)) * 31) + this.valueFont;
    }

    public String toString() {
        return "ReceiptCellViewState(title=" + this.title + ", titleDetail=" + ((Object) this.titleDetail) + ", value=" + ((Object) this.value) + ", valueImageUrl=" + this.valueImageUrl + ", valueDetail=" + ((Object) this.valueDetail) + ", valueDetailImageUrl=" + this.valueDetailImageUrl + ", tintColor=" + this.tintColor + ", valueFont=" + this.valueFont + ')';
    }

    public /* synthetic */ ReceiptCellViewState(String str, String str2, String str3, URL url, String str4, URL url2, Integer num, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : url, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : url2, (i2 & 64) == 0 ? num : null, (i2 & 128) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReceiptCellViewState(String title, String str, String str2, URL url, String str3, URL url2, Integer num, boolean z) {
        this(title, str, str2, url, str3, url2, num, z ? ReceiptCellViewStateKt.highLegibilityFont : ReceiptCellViewStateKt.normalFont);
        m.g(title, "title");
    }
}