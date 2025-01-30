package com.coinbase.cipherwebview.models.web3.call;

import com.coinbase.cipherwebview.models.web3.json.Web3CallResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Web3Call.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/Web3Call;", "", "", "errorMessage", "Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "createErrorResponse", "(Ljava/lang/String;)Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "", "getId", "()I", "id", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class Web3Call {
    public final Web3CallResponse createErrorResponse(String errorMessage) {
        m.g(errorMessage, "errorMessage");
        return new Web3CallResponse(getId(), errorMessage, null);
    }

    public abstract int getId();
}