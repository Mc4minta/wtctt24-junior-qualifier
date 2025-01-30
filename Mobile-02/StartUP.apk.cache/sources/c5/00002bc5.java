package com.coinbase.walletlink.exceptions;

import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: WalletLinkException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\t\u0007\b\t\n\u000b\f\r\u000e\u000fB\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\t\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/coinbase/walletlink/exceptions/WalletLinkException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "ChildSecurityException", "EventNotFound", "InvalidSession", "NoConnectionFound", "SessionNotAuthorizedException", "SessionNotFound", "UnableToEncryptData", "UnableToSendSignatureRequestConfirmation", "UnsupportedRequestMethodApproval", "Lcom/coinbase/walletlink/exceptions/WalletLinkException$UnableToEncryptData;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException$InvalidSession;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException$NoConnectionFound;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException$SessionNotFound;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException$EventNotFound;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException$UnsupportedRequestMethodApproval;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException$UnableToSendSignatureRequestConfirmation;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException$ChildSecurityException;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException$SessionNotAuthorizedException;", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class WalletLinkException extends Exception {

    /* compiled from: WalletLinkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletlink/exceptions/WalletLinkException$ChildSecurityException;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class ChildSecurityException extends WalletLinkException {
        public static final ChildSecurityException INSTANCE = new ChildSecurityException();

        private ChildSecurityException() {
            super("Only parent id is allowed to create child request", null);
        }
    }

    /* compiled from: WalletLinkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletlink/exceptions/WalletLinkException$EventNotFound;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class EventNotFound extends WalletLinkException {
        public static final EventNotFound INSTANCE = new EventNotFound();

        private EventNotFound() {
            super("Event not found", null);
        }
    }

    /* compiled from: WalletLinkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletlink/exceptions/WalletLinkException$InvalidSession;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class InvalidSession extends WalletLinkException {
        public static final InvalidSession INSTANCE = new InvalidSession();

        private InvalidSession() {
            super("Unable to encrypt data", null);
        }
    }

    /* compiled from: WalletLinkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/walletlink/exceptions/WalletLinkException$NoConnectionFound;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException;", "Ljava/net/URL;", "url", "Ljava/net/URL;", "getUrl", "()Ljava/net/URL;", "<init>", "(Ljava/net/URL;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class NoConnectionFound extends WalletLinkException {
        private final URL url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoConnectionFound(URL url) {
            super(m.o("Unable to find for url ", url), null);
            m.g(url, "url");
            this.url = url;
        }

        public final URL getUrl() {
            return this.url;
        }
    }

    /* compiled from: WalletLinkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletlink/exceptions/WalletLinkException$SessionNotAuthorizedException;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class SessionNotAuthorizedException extends WalletLinkException {
        public static final SessionNotAuthorizedException INSTANCE = new SessionNotAuthorizedException();

        private SessionNotAuthorizedException() {
            super("Request received but session not yet authorized", null);
        }
    }

    /* compiled from: WalletLinkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletlink/exceptions/WalletLinkException$SessionNotFound;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class SessionNotFound extends WalletLinkException {
        public static final SessionNotFound INSTANCE = new SessionNotFound();

        private SessionNotFound() {
            super("Unable to find session", null);
        }
    }

    /* compiled from: WalletLinkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletlink/exceptions/WalletLinkException$UnableToEncryptData;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToEncryptData extends WalletLinkException {
        public static final UnableToEncryptData INSTANCE = new UnableToEncryptData();

        private UnableToEncryptData() {
            super("Unable to encrypt data", null);
        }
    }

    /* compiled from: WalletLinkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletlink/exceptions/WalletLinkException$UnableToSendSignatureRequestConfirmation;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToSendSignatureRequestConfirmation extends WalletLinkException {
        public static final UnableToSendSignatureRequestConfirmation INSTANCE = new UnableToSendSignatureRequestConfirmation();

        private UnableToSendSignatureRequestConfirmation() {
            super("Unable to send signature confirmation", null);
        }
    }

    /* compiled from: WalletLinkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletlink/exceptions/WalletLinkException$UnsupportedRequestMethodApproval;", "Lcom/coinbase/walletlink/exceptions/WalletLinkException;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnsupportedRequestMethodApproval extends WalletLinkException {
        public static final UnsupportedRequestMethodApproval INSTANCE = new UnsupportedRequestMethodApproval();

        private UnsupportedRequestMethodApproval() {
            super("Unsupported request method approval", null);
        }
    }

    private WalletLinkException(String str) {
        super(str);
    }

    public /* synthetic */ WalletLinkException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}