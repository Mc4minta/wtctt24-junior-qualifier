package com.coinbase.walletengine.services.dogecoin;

import android.util.Base64;
import com.coinbase.ApiConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.m0;
import kotlin.o;
import kotlin.u;

/* compiled from: DogecoinService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00030\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0005\u0010\b\u001a\u001f\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0001*\u00020\tH\u0002¢\u0006\u0004\b\u0005\u0010\u000b\u001a'\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\fH\u0002¢\u0006\u0004\b\u0005\u0010\r\u001a%\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0001*\u00020\u000eH\u0002¢\u0006\u0004\b\u0005\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/coinbase/walletengine/services/dogecoin/UTXO;", "", "", "", "kotlin.jvm.PlatformType", "asJSONMap", "(Lcom/coinbase/walletengine/services/dogecoin/UTXO;)Ljava/util/Map;", "Lcom/coinbase/walletengine/services/dogecoin/Output;", "(Lcom/coinbase/walletengine/services/dogecoin/Output;)Ljava/util/Map;", "Lcom/coinbase/walletengine/services/dogecoin/CoinSelection;", "", "(Lcom/coinbase/walletengine/services/dogecoin/CoinSelection;)Ljava/util/Map;", "Lcom/coinbase/walletengine/services/dogecoin/SignedTransaction;", "(Lcom/coinbase/walletengine/services/dogecoin/SignedTransaction;)Ljava/util/Map;", "Lcom/coinbase/walletengine/services/dogecoin/TransactionResult;", "(Lcom/coinbase/walletengine/services/dogecoin/TransactionResult;)Ljava/util/Map;", "wallet-engine_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DogecoinServiceKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Comparable<?>> asJSONMap(UTXO utxo) {
        Map<String, Comparable<?>> l2;
        l2 = m0.l(u.a("address", utxo.getAddress()), u.a("hash", utxo.getHash()), u.a("index", UInt.h(utxo.m2020getIndexpVg5ArA())), u.a("value", utxo.getValue().toString()), u.a("script", Base64.encodeToString(utxo.getScript(), 2)));
        return l2;
    }

    private static final Map<String, String> asJSONMap(Output output) {
        Map<String, String> l2;
        l2 = m0.l(u.a("address", output.getAddress()), u.a("value", output.getValue().toString()));
        return l2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Object> asJSONMap(CoinSelection coinSelection) {
        Map<String, Object> l2;
        o[] oVarArr = new o[3];
        List<UTXO> inputs = coinSelection.getInputs();
        ArrayList arrayList = new ArrayList();
        for (UTXO utxo : inputs) {
            Map<String, Comparable<?>> asJSONMap = asJSONMap(utxo);
            if (asJSONMap != null) {
                arrayList.add(asJSONMap);
            }
        }
        oVarArr[0] = u.a("inputs", arrayList);
        List<Output> outputs = coinSelection.getOutputs();
        ArrayList arrayList2 = new ArrayList();
        for (Output output : outputs) {
            Map<String, String> asJSONMap2 = asJSONMap(output);
            if (asJSONMap2 != null) {
                arrayList2.add(asJSONMap2);
            }
        }
        oVarArr[1] = u.a("outputs", arrayList2);
        oVarArr[2] = u.a(ApiConstants.FEE, coinSelection.getFee().toString());
        l2 = m0.l(oVarArr);
        return l2;
    }

    private static final Map<String, String> asJSONMap(SignedTransaction signedTransaction) {
        Map<String, String> l2;
        l2 = m0.l(u.a("hash", signedTransaction.getHash()), u.a("data", Base64.encodeToString(signedTransaction.getData(), 2)));
        return l2;
    }

    private static final Map<String, Comparable<?>> asJSONMap(TransactionResult transactionResult) {
        Map<String, Comparable<?>> l2;
        l2 = m0.l(u.a("status", transactionResult.getStatus().getRawValue()), u.a("blockNumber", transactionResult.m2014getBlockNumber0hXNFcg()), u.a("blockHash", transactionResult.getBlockHash()));
        return l2;
    }
}