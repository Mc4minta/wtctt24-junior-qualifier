package com.coinbase.walletlink.dtos;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.walletlink.models.RequestMethod;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: Web3ResponseDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\b\u0000\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u000f\u0010\u0010B!\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0014B#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0016R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/coinbase/walletlink/dtos/Web3ResponseDTO;", "T", "", "Lcom/coinbase/walletlink/dtos/Web3Response;", Payload.RESPONSE, "Lcom/coinbase/walletlink/dtos/Web3Response;", "getResponse", "()Lcom/coinbase/walletlink/dtos/Web3Response;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "type", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/walletlink/dtos/Web3Response;)V", "Lcom/coinbase/walletlink/models/RequestMethod;", "method", "result", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/RequestMethod;Ljava/lang/Object;)V", "errorMessage", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/RequestMethod;Ljava/lang/String;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Web3ResponseDTO<T> {
    private final String id;
    private final Web3Response<T> response;
    private final String type;

    public Web3ResponseDTO(String type, String id, Web3Response<T> response) {
        m.g(type, "type");
        m.g(id, "id");
        m.g(response, "response");
        this.type = type;
        this.id = id;
        this.response = response;
    }

    public final String getId() {
        return this.id;
    }

    public final Web3Response<T> getResponse() {
        return this.response;
    }

    public final String getType() {
        return this.type;
    }

    public /* synthetic */ Web3ResponseDTO(String str, String str2, Web3Response web3Response, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "WEB3_RESPONSE" : str, str2, web3Response);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Web3ResponseDTO(String id, RequestMethod method, T t) {
        this(null, id, new Web3Response(method, t, null), 1, null);
        m.g(id, "id");
        m.g(method, "method");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Web3ResponseDTO(String id, RequestMethod method, String str) {
        this(null, id, new Web3Response(method, null, str), 1, null);
        m.g(id, "id");
        m.g(method, "method");
    }
}