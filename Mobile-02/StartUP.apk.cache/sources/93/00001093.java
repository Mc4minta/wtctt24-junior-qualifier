package com.coinbase.network.adapter;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: NetworkResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u0001*\n\b\u0001\u0010\u0003 \u0001*\u00020\u00012\u00020\u0001:\u0003\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ<\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0002\u0010\u0004*\u00020\u00012\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005H\u0086\b¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/coinbase/network/adapter/NetworkResponse;", "", "T", "E", "U", "Lkotlin/Function1;", "mapper", "map", "(Lkotlin/e0/c/l;)Lcom/coinbase/network/adapter/NetworkResponse;", "<init>", "()V", "NetworkError", "ServerError", "Success", "Lcom/coinbase/network/adapter/NetworkResponse$Success;", "Lcom/coinbase/network/adapter/NetworkResponse$ServerError;", "Lcom/coinbase/network/adapter/NetworkResponse$NetworkError;", "kotlin-rxjava"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public abstract class NetworkResponse<T, E> {

    /* compiled from: NetworkResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/coinbase/network/adapter/NetworkResponse$NetworkError;", "", "T", "E", "Lcom/coinbase/network/adapter/NetworkResponse;", "Ljava/io/IOException;", "component1", "()Ljava/io/IOException;", "error", "copy", "(Ljava/io/IOException;)Lcom/coinbase/network/adapter/NetworkResponse$NetworkError;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/io/IOException;", "getError", "<init>", "(Ljava/io/IOException;)V", "kotlin-rxjava"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class NetworkError<T, E> extends NetworkResponse<T, E> {
        private final IOException error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkError(IOException error) {
            super(null);
            m.h(error, "error");
            this.error = error;
        }

        public static /* synthetic */ NetworkError copy$default(NetworkError networkError, IOException iOException, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                iOException = networkError.error;
            }
            return networkError.copy(iOException);
        }

        public final IOException component1() {
            return this.error;
        }

        public final NetworkError<T, E> copy(IOException error) {
            m.h(error, "error");
            return new NetworkError<>(error);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof NetworkError) && m.c(this.error, ((NetworkError) obj).error);
            }
            return true;
        }

        public final IOException getError() {
            return this.error;
        }

        public int hashCode() {
            IOException iOException = this.error;
            if (iOException != null) {
                return iOException.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "NetworkError(error=" + this.error + ")";
        }
    }

    /* compiled from: NetworkResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u0019\u0012\b\u0010\n\u001a\u0004\u0018\u00018\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0003HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ2\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00018\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u001b\u0010\n\u001a\u0004\u0018\u00018\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/coinbase/network/adapter/NetworkResponse$ServerError;", "", "T", "E", "Lcom/coinbase/network/adapter/NetworkResponse;", "component1", "()Ljava/lang/Object;", "", "component2", "()I", "body", "code", "copy", "(Ljava/lang/Object;I)Lcom/coinbase/network/adapter/NetworkResponse$ServerError;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCode", "Ljava/lang/Object;", "getBody", "<init>", "(Ljava/lang/Object;I)V", "kotlin-rxjava"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class ServerError<T, E> extends NetworkResponse<T, E> {
        private final E body;
        private final int code;

        public ServerError(E e2, int i2) {
            super(null);
            this.body = e2;
            this.code = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ServerError copy$default(ServerError serverError, Object obj, int i2, int i3, Object obj2) {
            if ((i3 & 1) != 0) {
                obj = serverError.body;
            }
            if ((i3 & 2) != 0) {
                i2 = serverError.code;
            }
            return serverError.copy(obj, i2);
        }

        public final E component1() {
            return this.body;
        }

        public final int component2() {
            return this.code;
        }

        public final ServerError<T, E> copy(E e2, int i2) {
            return new ServerError<>(e2, i2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof ServerError) {
                    ServerError serverError = (ServerError) obj;
                    if (m.c(this.body, serverError.body)) {
                        if (this.code == serverError.code) {
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public final E getBody() {
            return this.body;
        }

        public final int getCode() {
            return this.code;
        }

        public int hashCode() {
            E e2 = this.body;
            return ((e2 != null ? e2.hashCode() : 0) * 31) + this.code;
        }

        public String toString() {
            return "ServerError(body=" + this.body + ", code=" + this.code + ")";
        }
    }

    /* compiled from: NetworkResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u000f\u0012\u0006\u0010\u0007\u001a\u00028\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/coinbase/network/adapter/NetworkResponse$Success;", "", "T", "E", "Lcom/coinbase/network/adapter/NetworkResponse;", "component1", "()Ljava/lang/Object;", "body", "copy", "(Ljava/lang/Object;)Lcom/coinbase/network/adapter/NetworkResponse$Success;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getBody", "<init>", "(Ljava/lang/Object;)V", "kotlin-rxjava"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Success<T, E> extends NetworkResponse<T, E> {
        private final T body;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(T body) {
            super(null);
            m.h(body, "body");
            this.body = body;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = success.body;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.body;
        }

        public final Success<T, E> copy(T body) {
            m.h(body, "body");
            return new Success<>(body);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Success) && m.c(this.body, ((Success) obj).body);
            }
            return true;
        }

        public final T getBody() {
            return this.body;
        }

        public int hashCode() {
            T t = this.body;
            if (t != null) {
                return t.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Success(body=" + this.body + ")";
        }
    }

    private NetworkResponse() {
    }

    public final <U> NetworkResponse<U, E> map(l<? super T, ? extends U> mapper) {
        m.h(mapper, "mapper");
        if (this instanceof Success) {
            return new Success(mapper.invoke((Object) ((Success) this).getBody()));
        }
        if (this instanceof ServerError) {
            ServerError serverError = (ServerError) this;
            return new ServerError(serverError.getBody(), serverError.getCode());
        } else if (this instanceof NetworkError) {
            return new NetworkError(((NetworkError) this).getError());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public /* synthetic */ NetworkResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}