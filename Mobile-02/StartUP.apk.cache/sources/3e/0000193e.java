package com.coinbase.wallet.crypto.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EncryptionException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/crypto/exceptions/EncryptionException;", "Ljava/lang/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "UnableToDecryptData", "UnableToEncryptData", "Lcom/coinbase/wallet/crypto/exceptions/EncryptionException$UnableToEncryptData;", "Lcom/coinbase/wallet/crypto/exceptions/EncryptionException$UnableToDecryptData;", "crypto_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class EncryptionException extends Exception {

    /* compiled from: EncryptionException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/crypto/exceptions/EncryptionException$UnableToDecryptData;", "Lcom/coinbase/wallet/crypto/exceptions/EncryptionException;", "<init>", "()V", "crypto_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToDecryptData extends EncryptionException {
        public static final UnableToDecryptData INSTANCE = new UnableToDecryptData();

        private UnableToDecryptData() {
            super("Unabel to decrypt data", null);
        }
    }

    /* compiled from: EncryptionException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/crypto/exceptions/EncryptionException$UnableToEncryptData;", "Lcom/coinbase/wallet/crypto/exceptions/EncryptionException;", "<init>", "()V", "crypto_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToEncryptData extends EncryptionException {
        public static final UnableToEncryptData INSTANCE = new UnableToEncryptData();

        private UnableToEncryptData() {
            super("Unable to encrypt data", null);
        }
    }

    private EncryptionException(String str) {
        super(str);
    }

    public /* synthetic */ EncryptionException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}