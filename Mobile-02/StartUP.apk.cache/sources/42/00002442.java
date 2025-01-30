package com.coinbase.wallet.lending.exceptions;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LendException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0004\u0007\b\t\nB\u0015\b\u0004\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/lending/exceptions/LendException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "UnableToGetLendService", "UnableToGetLendingData", "UnableToSupply", "UnableToWithdraw", "Lcom/coinbase/wallet/lending/exceptions/LendException$UnableToGetLendService;", "Lcom/coinbase/wallet/lending/exceptions/LendException$UnableToSupply;", "Lcom/coinbase/wallet/lending/exceptions/LendException$UnableToWithdraw;", "Lcom/coinbase/wallet/lending/exceptions/LendException$UnableToGetLendingData;", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class LendException extends Exception {

    /* compiled from: LendException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/lending/exceptions/LendException$UnableToGetLendService;", "Lcom/coinbase/wallet/lending/exceptions/LendException;", "<init>", "()V", "lending_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToGetLendService extends LendException {
        public static final UnableToGetLendService INSTANCE = new UnableToGetLendService();

        private UnableToGetLendService() {
            super(null, 1, null);
        }
    }

    /* compiled from: LendException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/lending/exceptions/LendException$UnableToGetLendingData;", "Lcom/coinbase/wallet/lending/exceptions/LendException;", "<init>", "()V", "lending_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToGetLendingData extends LendException {
        public static final UnableToGetLendingData INSTANCE = new UnableToGetLendingData();

        private UnableToGetLendingData() {
            super(null, 1, null);
        }
    }

    /* compiled from: LendException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/lending/exceptions/LendException$UnableToSupply;", "Lcom/coinbase/wallet/lending/exceptions/LendException;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToSupply extends LendException {
        public UnableToSupply() {
            this(null, 1, null);
        }

        public UnableToSupply(String str) {
            super(str, null);
        }

        public /* synthetic */ UnableToSupply(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str);
        }
    }

    /* compiled from: LendException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/lending/exceptions/LendException$UnableToWithdraw;", "Lcom/coinbase/wallet/lending/exceptions/LendException;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToWithdraw extends LendException {
        public UnableToWithdraw() {
            this(null, 1, null);
        }

        public UnableToWithdraw(String str) {
            super(str, null);
        }

        public /* synthetic */ UnableToWithdraw(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str);
        }
    }

    private LendException(String str) {
        super(str);
    }

    public /* synthetic */ LendException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ LendException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, null);
    }
}