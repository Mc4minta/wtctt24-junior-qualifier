package com.coinbase.resources.trades;

/* loaded from: classes.dex */
public final class TransferOrderBody extends PlaceTradeOrderBody<TransferOrderBody> {
    private Boolean agreeBtcAmountVaries;
    private Boolean quote;
    private String total;

    private TransferOrderBody(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    private TransferOrderBody setTotal(String str) {
        this.total = str;
        return this;
    }

    public static TransferOrderBody withAmount(String str, String str2, String str3) {
        return new TransferOrderBody(str, str2, str3);
    }

    public static TransferOrderBody withTotal(String str, String str2, String str3) {
        TransferOrderBody transferOrderBody = new TransferOrderBody(null, str2, str3);
        transferOrderBody.setTotal(str);
        return transferOrderBody;
    }

    public Boolean getAgreeBtcAmountVaries() {
        return this.agreeBtcAmountVaries;
    }

    public Boolean getQuote() {
        return this.quote;
    }

    public String getTotal() {
        return this.total;
    }

    public TransferOrderBody setAgreeBtcAmountVaries(Boolean bool) {
        this.agreeBtcAmountVaries = bool;
        return this;
    }

    public TransferOrderBody setQuote(Boolean bool) {
        this.quote = bool;
        return this;
    }
}