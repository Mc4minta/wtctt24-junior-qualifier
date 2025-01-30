package com.coinbase.wallet.ripple.exceptions;

import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: XrpException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0004\u0007\b\t\nB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/ripple/exceptions/XrpException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "InvalidDestinationTag", "MissingDestinationTag", "RecipientDisallowsIncomingXrp", "RequiresBaseReserve", "Lcom/coinbase/wallet/ripple/exceptions/XrpException$RecipientDisallowsIncomingXrp;", "Lcom/coinbase/wallet/ripple/exceptions/XrpException$MissingDestinationTag;", "Lcom/coinbase/wallet/ripple/exceptions/XrpException$InvalidDestinationTag;", "Lcom/coinbase/wallet/ripple/exceptions/XrpException$RequiresBaseReserve;", "ripple_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class XrpException extends Exception {

    /* compiled from: XrpException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ripple/exceptions/XrpException$InvalidDestinationTag;", "Lcom/coinbase/wallet/ripple/exceptions/XrpException;", "<init>", "()V", "ripple_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class InvalidDestinationTag extends XrpException {
        public static final InvalidDestinationTag INSTANCE = new InvalidDestinationTag();

        private InvalidDestinationTag() {
            super("Invalid destination tag", null);
        }
    }

    /* compiled from: XrpException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ripple/exceptions/XrpException$MissingDestinationTag;", "Lcom/coinbase/wallet/ripple/exceptions/XrpException;", "<init>", "()V", "ripple_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class MissingDestinationTag extends XrpException {
        public static final MissingDestinationTag INSTANCE = new MissingDestinationTag();

        private MissingDestinationTag() {
            super("Missing destination tag", null);
        }
    }

    /* compiled from: XrpException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ripple/exceptions/XrpException$RecipientDisallowsIncomingXrp;", "Lcom/coinbase/wallet/ripple/exceptions/XrpException;", "<init>", "()V", "ripple_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class RecipientDisallowsIncomingXrp extends XrpException {
        public static final RecipientDisallowsIncomingXrp INSTANCE = new RecipientDisallowsIncomingXrp();

        private RecipientDisallowsIncomingXrp() {
            super("Recipient disallows incoming XRP", null);
        }
    }

    /* compiled from: XrpException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ripple/exceptions/XrpException$RequiresBaseReserve;", "Lcom/coinbase/wallet/ripple/exceptions/XrpException;", "<init>", "()V", "ripple_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class RequiresBaseReserve extends XrpException {
        public static final RequiresBaseReserve INSTANCE = new RequiresBaseReserve();

        private RequiresBaseReserve() {
            super("Requires base reserve", null);
        }
    }

    private XrpException(String str) {
        super(str);
    }

    public /* synthetic */ XrpException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ XrpException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, null);
    }
}