package com.coinbase.wallet.features.ethereum.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CollectiblesException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0007\bB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/ethereum/exceptions/CollectiblesException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "UnableToGetCollectibleTypes", "UnableToGetErc721Tokens", "Lcom/coinbase/wallet/features/ethereum/exceptions/CollectiblesException$UnableToGetCollectibleTypes;", "Lcom/coinbase/wallet/features/ethereum/exceptions/CollectiblesException$UnableToGetErc721Tokens;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class CollectiblesException extends Exception {

    /* compiled from: CollectiblesException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/ethereum/exceptions/CollectiblesException$UnableToGetCollectibleTypes;", "Lcom/coinbase/wallet/features/ethereum/exceptions/CollectiblesException;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToGetCollectibleTypes extends CollectiblesException {
        public static final UnableToGetCollectibleTypes INSTANCE = new UnableToGetCollectibleTypes();

        private UnableToGetCollectibleTypes() {
            super("Unable to get collectible types", null);
        }
    }

    /* compiled from: CollectiblesException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/ethereum/exceptions/CollectiblesException$UnableToGetErc721Tokens;", "Lcom/coinbase/wallet/features/ethereum/exceptions/CollectiblesException;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToGetErc721Tokens extends CollectiblesException {
        public static final UnableToGetErc721Tokens INSTANCE = new UnableToGetErc721Tokens();

        private UnableToGetErc721Tokens() {
            super("Unable to get ERC721 tokens", null);
        }
    }

    private CollectiblesException(String str) {
        super(str);
    }

    public /* synthetic */ CollectiblesException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ CollectiblesException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, null);
    }
}