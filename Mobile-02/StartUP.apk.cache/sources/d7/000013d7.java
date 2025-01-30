package com.coinbase.wallet.blockchains.exceptions;

import com.coinbase.wallet.blockchains.models.Address;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AddressException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0007\bB\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/AddressException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "UnableToSaveAddress", "UnableToSaveAddressList", "Lcom/coinbase/wallet/blockchains/exceptions/AddressException$UnableToSaveAddress;", "Lcom/coinbase/wallet/blockchains/exceptions/AddressException$UnableToSaveAddressList;", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AddressException extends Exception {

    /* compiled from: AddressException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/AddressException$UnableToSaveAddress;", "Lcom/coinbase/wallet/blockchains/exceptions/AddressException;", "Lcom/coinbase/wallet/blockchains/models/Address;", "address", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Address;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToSaveAddress extends AddressException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnableToSaveAddress(Address address) {
            super(m.o("Unable to save address ", address.getCurrencyCode()), null);
            m.g(address, "address");
        }
    }

    /* compiled from: AddressException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/AddressException$UnableToSaveAddressList;", "Lcom/coinbase/wallet/blockchains/exceptions/AddressException;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToSaveAddressList extends AddressException {
        public static final UnableToSaveAddressList INSTANCE = new UnableToSaveAddressList();

        private UnableToSaveAddressList() {
            super("Unable to save address list", null);
        }
    }

    private AddressException(String str) {
        super(str);
    }

    public /* synthetic */ AddressException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}