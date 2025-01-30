package com.coinbase.wallet.ethereum.exceptions;

import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ERC20ContractException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u0007\b\tB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/ERC20ContractException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "UnableToApproveTransfer", "UnableToFindEthereumRPCURL", "UnableToGetAllowance", "Lcom/coinbase/wallet/ethereum/exceptions/ERC20ContractException$UnableToFindEthereumRPCURL;", "Lcom/coinbase/wallet/ethereum/exceptions/ERC20ContractException$UnableToApproveTransfer;", "Lcom/coinbase/wallet/ethereum/exceptions/ERC20ContractException$UnableToGetAllowance;", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ERC20ContractException extends Exception {

    /* compiled from: ERC20ContractException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/ERC20ContractException$UnableToApproveTransfer;", "Lcom/coinbase/wallet/ethereum/exceptions/ERC20ContractException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToApproveTransfer extends ERC20ContractException {
        public static final UnableToApproveTransfer INSTANCE = new UnableToApproveTransfer();

        private UnableToApproveTransfer() {
            super(null, 1, null);
        }
    }

    /* compiled from: ERC20ContractException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/ERC20ContractException$UnableToFindEthereumRPCURL;", "Lcom/coinbase/wallet/ethereum/exceptions/ERC20ContractException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToFindEthereumRPCURL extends ERC20ContractException {
        public static final UnableToFindEthereumRPCURL INSTANCE = new UnableToFindEthereumRPCURL();

        private UnableToFindEthereumRPCURL() {
            super(null, 1, null);
        }
    }

    /* compiled from: ERC20ContractException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/ERC20ContractException$UnableToGetAllowance;", "Lcom/coinbase/wallet/ethereum/exceptions/ERC20ContractException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToGetAllowance extends ERC20ContractException {
        public static final UnableToGetAllowance INSTANCE = new UnableToGetAllowance();

        private UnableToGetAllowance() {
            super(null, 1, null);
        }
    }

    private ERC20ContractException(String str) {
        super(str);
    }

    public /* synthetic */ ERC20ContractException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ ERC20ContractException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, null);
    }
}