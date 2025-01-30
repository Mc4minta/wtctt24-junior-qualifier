package com.coinbase.wallet.commonui.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AmountsException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0007\bB\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/commonui/exceptions/AmountsException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "BigDecimalConversionFailed", "InvalidAmount", "Lcom/coinbase/wallet/commonui/exceptions/AmountsException$BigDecimalConversionFailed;", "Lcom/coinbase/wallet/commonui/exceptions/AmountsException$InvalidAmount;", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AmountsException extends Exception {

    /* compiled from: AmountsException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/commonui/exceptions/AmountsException$BigDecimalConversionFailed;", "Lcom/coinbase/wallet/commonui/exceptions/AmountsException;", "", "component1", "()Ljava/lang/String;", "value", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/commonui/exceptions/AmountsException$BigDecimalConversionFailed;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getValue", "<init>", "(Ljava/lang/String;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class BigDecimalConversionFailed extends AmountsException {
        private final String value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BigDecimalConversionFailed(String value) {
            super(m.o("Unable to convert value to BigDecimal: ", value), null);
            m.g(value, "value");
            this.value = value;
        }

        public static /* synthetic */ BigDecimalConversionFailed copy$default(BigDecimalConversionFailed bigDecimalConversionFailed, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = bigDecimalConversionFailed.value;
            }
            return bigDecimalConversionFailed.copy(str);
        }

        public final String component1() {
            return this.value;
        }

        public final BigDecimalConversionFailed copy(String value) {
            m.g(value, "value");
            return new BigDecimalConversionFailed(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BigDecimalConversionFailed) && m.c(this.value, ((BigDecimalConversionFailed) obj).value);
        }

        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "BigDecimalConversionFailed(value=" + this.value + ')';
        }
    }

    /* compiled from: AmountsException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/commonui/exceptions/AmountsException$InvalidAmount;", "Lcom/coinbase/wallet/commonui/exceptions/AmountsException;", "", "component1", "()Ljava/lang/String;", "value", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/commonui/exceptions/AmountsException$InvalidAmount;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getValue", "<init>", "(Ljava/lang/String;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InvalidAmount extends AmountsException {
        private final String value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidAmount(String value) {
            super(m.o("Entered value is invalid: ", value), null);
            m.g(value, "value");
            this.value = value;
        }

        public static /* synthetic */ InvalidAmount copy$default(InvalidAmount invalidAmount, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = invalidAmount.value;
            }
            return invalidAmount.copy(str);
        }

        public final String component1() {
            return this.value;
        }

        public final InvalidAmount copy(String value) {
            m.g(value, "value");
            return new InvalidAmount(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InvalidAmount) && m.c(this.value, ((InvalidAmount) obj).value);
        }

        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "InvalidAmount(value=" + this.value + ')';
        }
    }

    private AmountsException(String str) {
        super(str);
    }

    public /* synthetic */ AmountsException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}