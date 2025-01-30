package com.coinbase.wallet.txhistory.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.a;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetHdWalletTxsResponse.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJb\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b&\u0010\u0007R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010\u000eR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b)\u0010\u000eR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b*\u0010\u0007¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsResponse;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()D", "component3", "component4", "component5", "", "Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsInputOutput;", "component6", "()Ljava/util/List;", "component7", "hash", "height", "block", "confirmations", ApiConstants.TIME, "inputs", "outputs", "copy", "(Ljava/lang/String;DLjava/lang/String;DDLjava/util/List;Ljava/util/List;)Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBlock", "D", "getConfirmations", "getHash", "getTime", "Ljava/util/List;", "getInputs", "getOutputs", "getHeight", "<init>", "(Ljava/lang/String;DLjava/lang/String;DDLjava/util/List;Ljava/util/List;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetHdWalletTxsResponse {
    private final String block;
    private final double confirmations;
    private final String hash;
    private final double height;
    private final List<GetHdWalletTxsInputOutput> inputs;
    private final List<GetHdWalletTxsInputOutput> outputs;
    private final double time;

    public GetHdWalletTxsResponse(String hash, double d2, String block, double d3, double d4, List<GetHdWalletTxsInputOutput> inputs, List<GetHdWalletTxsInputOutput> outputs) {
        m.g(hash, "hash");
        m.g(block, "block");
        m.g(inputs, "inputs");
        m.g(outputs, "outputs");
        this.hash = hash;
        this.height = d2;
        this.block = block;
        this.confirmations = d3;
        this.time = d4;
        this.inputs = inputs;
        this.outputs = outputs;
    }

    public final String component1() {
        return this.hash;
    }

    public final double component2() {
        return this.height;
    }

    public final String component3() {
        return this.block;
    }

    public final double component4() {
        return this.confirmations;
    }

    public final double component5() {
        return this.time;
    }

    public final List<GetHdWalletTxsInputOutput> component6() {
        return this.inputs;
    }

    public final List<GetHdWalletTxsInputOutput> component7() {
        return this.outputs;
    }

    public final GetHdWalletTxsResponse copy(String hash, double d2, String block, double d3, double d4, List<GetHdWalletTxsInputOutput> inputs, List<GetHdWalletTxsInputOutput> outputs) {
        m.g(hash, "hash");
        m.g(block, "block");
        m.g(inputs, "inputs");
        m.g(outputs, "outputs");
        return new GetHdWalletTxsResponse(hash, d2, block, d3, d4, inputs, outputs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetHdWalletTxsResponse) {
            GetHdWalletTxsResponse getHdWalletTxsResponse = (GetHdWalletTxsResponse) obj;
            return m.c(this.hash, getHdWalletTxsResponse.hash) && m.c(Double.valueOf(this.height), Double.valueOf(getHdWalletTxsResponse.height)) && m.c(this.block, getHdWalletTxsResponse.block) && m.c(Double.valueOf(this.confirmations), Double.valueOf(getHdWalletTxsResponse.confirmations)) && m.c(Double.valueOf(this.time), Double.valueOf(getHdWalletTxsResponse.time)) && m.c(this.inputs, getHdWalletTxsResponse.inputs) && m.c(this.outputs, getHdWalletTxsResponse.outputs);
        }
        return false;
    }

    public final String getBlock() {
        return this.block;
    }

    public final double getConfirmations() {
        return this.confirmations;
    }

    public final String getHash() {
        return this.hash;
    }

    public final double getHeight() {
        return this.height;
    }

    public final List<GetHdWalletTxsInputOutput> getInputs() {
        return this.inputs;
    }

    public final List<GetHdWalletTxsInputOutput> getOutputs() {
        return this.outputs;
    }

    public final double getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((((((((((this.hash.hashCode() * 31) + a.a(this.height)) * 31) + this.block.hashCode()) * 31) + a.a(this.confirmations)) * 31) + a.a(this.time)) * 31) + this.inputs.hashCode()) * 31) + this.outputs.hashCode();
    }

    public String toString() {
        return "GetHdWalletTxsResponse(hash=" + this.hash + ", height=" + this.height + ", block=" + this.block + ", confirmations=" + this.confirmations + ", time=" + this.time + ", inputs=" + this.inputs + ", outputs=" + this.outputs + ')';
    }
}