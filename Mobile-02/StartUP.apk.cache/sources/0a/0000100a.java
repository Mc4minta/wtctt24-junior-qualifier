package com.coinbase.cipherwebview;

import android.webkit.JavascriptInterface;
import com.coinbase.ApiConstants;
import com.coinbase.cipherwebview.models.web3.Web3CallMethod;
import com.coinbase.cipherwebview.models.web3.call.EthereumAddressFromSignedMessageCall;
import com.coinbase.cipherwebview.models.web3.call.MakeEthereumJSONRPCRequestCall;
import com.coinbase.cipherwebview.models.web3.call.ScanQRCodeCall;
import com.coinbase.cipherwebview.models.web3.call.SignEthereumMessageCall;
import com.coinbase.cipherwebview.models.web3.call.SignEthereumTransactionCall;
import com.coinbase.cipherwebview.models.web3.call.SubmitEthereumTransactionCall;
import com.coinbase.cipherwebview.models.web3.call.SwitchEthereumChainCall;
import com.coinbase.cipherwebview.models.web3.call.Web3Call;
import com.coinbase.cipherwebview.models.web3.json.EthereumAddressFromSignedMessageCallJson;
import com.coinbase.cipherwebview.models.web3.json.MakeEthereumJSONRPCRequestCallJson;
import com.coinbase.cipherwebview.models.web3.json.ScanQRCodeCallJson;
import com.coinbase.cipherwebview.models.web3.json.SignEthereumMessageCallJson;
import com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallJson;
import com.coinbase.cipherwebview.models.web3.json.SubmitEthereumTransactionCallJson;
import com.coinbase.cipherwebview.models.web3.json.SwitchEthereumCallJson;
import com.coinbase.cipherwebview.models.web3.json.Web3CallJson;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CipherWebViewJavaScriptInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/cipherwebview/CipherWebViewJavaScriptInterface;", "", "", ApiConstants.MESSAGE, "Lkotlin/x;", "postMessage", "(Ljava/lang/String;)V", "Lcom/coinbase/cipherwebview/CipherWebView;", "cipherWebView", "Lcom/coinbase/cipherwebview/CipherWebView;", "getCipherWebView", "()Lcom/coinbase/cipherwebview/CipherWebView;", "<init>", "(Lcom/coinbase/cipherwebview/CipherWebView;)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CipherWebViewJavaScriptInterface {
    private final CipherWebView cipherWebView;

    /* compiled from: CipherWebViewJavaScriptInterface.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Web3CallMethod.values().length];
            iArr[Web3CallMethod.SignEthereumMessage.ordinal()] = 1;
            iArr[Web3CallMethod.SignEthereumTransaction.ordinal()] = 2;
            iArr[Web3CallMethod.SubmitEthereumTransaction.ordinal()] = 3;
            iArr[Web3CallMethod.EthereumAddressFromSignedMessage.ordinal()] = 4;
            iArr[Web3CallMethod.MakeEthereumJSONRPCRequest.ordinal()] = 5;
            iArr[Web3CallMethod.ScanQRCode.ordinal()] = 6;
            iArr[Web3CallMethod.SwitchEthereumChain.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CipherWebViewJavaScriptInterface(CipherWebView cipherWebView) {
        m.g(cipherWebView, "cipherWebView");
        this.cipherWebView = cipherWebView;
    }

    public final CipherWebView getCipherWebView() {
        return this.cipherWebView;
    }

    @JavascriptInterface
    public final void postMessage(String message) {
        Web3CallJson web3CallJson;
        m.g(message, "message");
        Web3Call web3Call = null;
        try {
            web3CallJson = Web3CallJson.Companion.getJsonAdapter$cipher_webview_release().fromJson(message);
        } catch (Throwable unused) {
            this.cipherWebView.getMessageSubject$cipher_webview_release().onNext(message);
            web3CallJson = null;
        }
        if (web3CallJson == null) {
            return;
        }
        Web3CallMethod fromValue = Web3CallMethod.Companion.fromValue(web3CallJson.getMethod());
        switch (fromValue == null ? -1 : WhenMappings.$EnumSwitchMapping$0[fromValue.ordinal()]) {
            case 1:
                web3Call = SignEthereumMessageCall.Companion.fromJson$cipher_webview_release(SignEthereumMessageCallJson.Companion.getJsonAdapter$cipher_webview_release().fromJson(message));
                break;
            case 2:
                web3Call = SignEthereumTransactionCall.Companion.fromJson$cipher_webview_release(SignEthereumTransactionCallJson.Companion.getJsonAdapter$cipher_webview_release().fromJson(message));
                break;
            case 3:
                web3Call = SubmitEthereumTransactionCall.Companion.fromJson$cipher_webview_release(SubmitEthereumTransactionCallJson.Companion.getJsonAdapter$cipher_webview_release().fromJson(message));
                break;
            case 4:
                web3Call = EthereumAddressFromSignedMessageCall.Companion.fromJson$cipher_webview_release(EthereumAddressFromSignedMessageCallJson.Companion.getJsonAdapter$cipher_webview_release().fromJson(message));
                break;
            case 5:
                web3Call = MakeEthereumJSONRPCRequestCall.Companion.fromJson$cipher_webview_release(MakeEthereumJSONRPCRequestCallJson.Companion.getJsonAdapter$cipher_webview_release().fromJson(message));
                break;
            case 6:
                web3Call = ScanQRCodeCall.Companion.fromJson$cipher_webview_release(ScanQRCodeCallJson.Companion.getJsonAdapter$cipher_webview_release().fromJson(message));
                break;
            case 7:
                web3Call = SwitchEthereumChainCall.Companion.fromJson$cipher_webview_release(SwitchEthereumCallJson.Companion.getJsonAdapter$cipher_webview_release().fromJson(message));
                break;
        }
        if (web3Call != null) {
            this.cipherWebView.getWeb3CallSubject$cipher_webview_release().onNext(web3Call);
            return;
        }
        throw new IllegalStateException(m.o("Invalid web 3 call JSON received: ", message));
    }
}