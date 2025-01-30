package com.coinbase.cipherwebview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ServiceWorkerClient;
import android.webkit.ServiceWorkerController;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.cipherwebview.CipherWebView;
import com.coinbase.cipherwebview.httpclient.HttpClient;
import com.coinbase.cipherwebview.models.AuthenticationChallenge;
import com.coinbase.cipherwebview.models.CipherWebViewConfiguration;
import com.coinbase.cipherwebview.models.JSAlert;
import com.coinbase.cipherwebview.models.JSConfirm;
import com.coinbase.cipherwebview.models.JSPrompt;
import com.coinbase.cipherwebview.models.NavigationError;
import com.coinbase.cipherwebview.models.NavigationHTTPError;
import com.coinbase.cipherwebview.models.NavigationSSLError;
import com.coinbase.cipherwebview.models.web3.call.Web3Call;
import com.coinbase.cipherwebview.models.web3.json.Web3CallResponse;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.s;
import j.e0;
import j.q;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.a0.s0;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.m;
import kotlin.x;
import okhttp3.OkHttpClient;
import okhttp3.internal.http.StatusLine;
import org.apache.http.HttpStatus;

/* compiled from: CipherWebView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 Â\u00012\u00020\u0001:\u0002Â\u0001B\u0015\b\u0016\u0012\b\u0010¸\u0001\u001a\u00030·\u0001¢\u0006\u0006\b¹\u0001\u0010º\u0001B!\b\u0016\u0012\b\u0010¸\u0001\u001a\u00030·\u0001\u0012\n\u0010¼\u0001\u001a\u0005\u0018\u00010»\u0001¢\u0006\u0006\b¹\u0001\u0010½\u0001B*\b\u0016\u0012\b\u0010¸\u0001\u001a\u00030·\u0001\u0012\n\u0010¼\u0001\u001a\u0005\u0018\u00010»\u0001\u0012\u0007\u0010¾\u0001\u001a\u00020\n¢\u0006\u0006\b¹\u0001\u0010¿\u0001B3\b\u0016\u0012\b\u0010¸\u0001\u001a\u00030·\u0001\u0012\n\u0010¼\u0001\u001a\u0005\u0018\u00010»\u0001\u0012\u0007\u0010¾\u0001\u001a\u00020\n\u0012\u0007\u0010À\u0001\u001a\u00020\n¢\u0006\u0006\b¹\u0001\u0010Á\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J[\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0019J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0004J\u001f\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0006H\u0017¢\u0006\u0004\b(\u0010)J\u001d\u0010-\u001a\u00020\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u0010\u0004R=\u00103\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010101 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010101\u0018\u000100008\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0019\u00108\u001a\u0002078\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R=\u0010=\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010<0< 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010<0<\u0018\u000100008\u0006@\u0006¢\u0006\f\n\u0004\b=\u00104\u001a\u0004\b>\u00106R=\u0010?\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u0002 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u0002\u0018\u000100008\u0006@\u0006¢\u0006\f\n\u0004\b?\u00104\u001a\u0004\b@\u00106R*\u0010C\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010B0B0A8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR=\u0010H\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010G0G 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010G0G\u0018\u000100008\u0006@\u0006¢\u0006\f\n\u0004\bH\u00104\u001a\u0004\bI\u00106R=\u0010J\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010<0< 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010<0<\u0018\u000100008\u0006@\u0006¢\u0006\f\n\u0004\bJ\u00104\u001a\u0004\bK\u00106R0\u0010N\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010M\u0012\u0004\u0012\u00020<0L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR=\u0010U\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010T0T 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010T0T\u0018\u000100008\u0006@\u0006¢\u0006\f\n\u0004\bU\u00104\u001a\u0004\bV\u00106RQ\u0010Y\u001a:\u0012\u0016\u0012\u0014 2*\n\u0018\u00010Wj\u0004\u0018\u0001`X0Wj\u0002`X 2*\u001c\u0012\u0016\u0012\u0014 2*\n\u0018\u00010Wj\u0004\u0018\u0001`X0Wj\u0002`X\u0018\u000100008\u0006@\u0006¢\u0006\f\n\u0004\bY\u00104\u001a\u0004\bZ\u00106R*\u0010\\\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010[0[0A8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\\\u0010D\u001a\u0004\b]\u0010FR=\u0010_\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010^0^ 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010^0^\u0018\u000100008\u0006@\u0006¢\u0006\f\n\u0004\b_\u00104\u001a\u0004\b`\u00106R=\u0010a\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00060\u0006 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00060\u0006\u0018\u000100008\u0006@\u0006¢\u0006\f\n\u0004\ba\u00104\u001a\u0004\bb\u00106R*\u0010d\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00060\u00060c8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR=\u0010h\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00060\u0006 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00060\u0006\u0018\u000100008\u0006@\u0006¢\u0006\f\n\u0004\bh\u00104\u001a\u0004\bi\u00106R=\u0010j\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010B0B 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010B0B\u0018\u000100008\u0006@\u0006¢\u0006\f\n\u0004\bj\u00104\u001a\u0004\bk\u00106R\u0016\u0010m\u001a\u00020l8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bm\u0010nR*\u0010p\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010o0o0A8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bp\u0010D\u001a\u0004\bq\u0010FR*\u0010s\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010r0r0A8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bs\u0010D\u001a\u0004\bt\u0010FR*\u0010u\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00060\u00060A8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bu\u0010D\u001a\u0004\bv\u0010FR=\u0010w\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010o0o 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010o0o\u0018\u000100008\u0006@\u0006¢\u0006\f\n\u0004\bw\u00104\u001a\u0004\bx\u00106R*\u0010y\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00060\u00060c8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\by\u0010e\u001a\u0004\bz\u0010gR*\u0010{\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010<0<0c8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b{\u0010e\u001a\u0004\b|\u0010gR*\u0010}\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u00020A8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b}\u0010D\u001a\u0004\b~\u0010FR\u0017\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00068F@\u0006¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001R/\u0010\u0083\u0001\u001a\u0012\u0012\u000e\u0012\f 2*\u0005\u0018\u00010\u0082\u00010\u0082\u00010A8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010D\u001a\u0005\b\u0084\u0001\u0010FR@\u0010\u0085\u0001\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u0002 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u0002\u0018\u000100008\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0085\u0001\u00104\u001a\u0005\b\u0086\u0001\u00106RD\u0010\u0088\u0001\u001a*\u0012\u000e\u0012\f 2*\u0005\u0018\u00010\u0087\u00010\u0087\u0001 2*\u0014\u0012\u000e\u0012\f 2*\u0005\u0018\u00010\u0087\u00010\u0087\u0001\u0018\u000100008\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0088\u0001\u00104\u001a\u0005\b\u0089\u0001\u00106R\u0019\u0010\u008a\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R-\u0010\u008c\u0001\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010^0^0c8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010e\u001a\u0005\b\u008d\u0001\u0010gR@\u0010\u008e\u0001\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u0002 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u0002\u0018\u000100008\u0006@\u0006¢\u0006\u000e\n\u0005\b\u008e\u0001\u00104\u001a\u0005\b\u008f\u0001\u00106R@\u0010\u0090\u0001\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010<0< 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010<0<\u0018\u000100008\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0090\u0001\u00104\u001a\u0005\b\u0091\u0001\u00106R-\u0010\u0092\u0001\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010<0<0c8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010e\u001a\u0005\b\u0093\u0001\u0010gR-\u0010\u0094\u0001\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010T0T0A8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010D\u001a\u0005\b\u0095\u0001\u0010FR\u001a\u0010\u0097\u0001\u001a\u00030\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R/\u0010\u0099\u0001\u001a\u0012\u0012\u000e\u0012\f 2*\u0005\u0018\u00010\u0087\u00010\u0087\u00010A8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u0099\u0001\u0010D\u001a\u0005\b\u009a\u0001\u0010FR\u0019\u0010\u009b\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u008b\u0001R-\u0010\u009c\u0001\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010G0G0A8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u009c\u0001\u0010D\u001a\u0005\b\u009d\u0001\u0010FR-\u0010\u009e\u0001\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u00020A8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010D\u001a\u0005\b\u009f\u0001\u0010FR@\u0010 \u0001\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00060\u0006 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00060\u0006\u0018\u000100008\u0006@\u0006¢\u0006\u000e\n\u0005\b \u0001\u00104\u001a\u0005\b¡\u0001\u00106R-\u0010¢\u0001\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010<0<0c8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b¢\u0001\u0010e\u001a\u0005\b£\u0001\u0010gR@\u0010¤\u0001\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010<0< 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010<0<\u0018\u000100008\u0006@\u0006¢\u0006\u000e\n\u0005\b¤\u0001\u00104\u001a\u0005\b¥\u0001\u00106RD\u0010¦\u0001\u001a*\u0012\u000e\u0012\f 2*\u0005\u0018\u00010\u0082\u00010\u0082\u0001 2*\u0014\u0012\u000e\u0012\f 2*\u0005\u0018\u00010\u0082\u00010\u0082\u0001\u0018\u000100008\u0006@\u0006¢\u0006\u000e\n\u0005\b¦\u0001\u00104\u001a\u0005\b§\u0001\u00106R-\u0010¨\u0001\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u000101010c8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b¨\u0001\u0010e\u001a\u0005\b©\u0001\u0010gR@\u0010ª\u0001\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010[0[ 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010[0[\u0018\u000100008\u0006@\u0006¢\u0006\u000e\n\u0005\bª\u0001\u00104\u001a\u0005\b«\u0001\u00106R(\u0010\u00ad\u0001\u001a\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R7\u0010¯\u0001\u001a\u001a\u0012\u0016\u0012\u0014 2*\n\u0018\u00010Wj\u0004\u0018\u0001`X0Wj\u0002`X0A8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b¯\u0001\u0010D\u001a\u0005\b°\u0001\u0010FR-\u0010±\u0001\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010<0<0c8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b±\u0001\u0010e\u001a\u0005\b²\u0001\u0010gR@\u0010³\u0001\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010r0r 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010r0r\u0018\u000100008\u0006@\u0006¢\u0006\u000e\n\u0005\b³\u0001\u00104\u001a\u0005\b´\u0001\u00106R-\u0010µ\u0001\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u00020A8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\bµ\u0001\u0010D\u001a\u0005\b¶\u0001\u0010F¨\u0006Ã\u0001"}, d2 = {"Lcom/coinbase/cipherwebview/CipherWebView;", "Landroid/widget/FrameLayout;", "Lkotlin/x;", "setupWebView", "()V", "publishWebViewState", "", "appName", "appVersion", "address", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "", "additionalHeaders", "userAgentString", "Lokhttp3/OkHttpClient$Builder;", "httpClientBuilder", "configure", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;Lokhttp3/OkHttpClient$Builder;)V", "Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", Payload.RESPONSE, "respondToWeb3Call", "(Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;)V", "urlString", "loadURL", "(Ljava/lang/String;)V", "htmlString", "baseURLString", "encoding", "loadHTML", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "javaScriptString", "evaluateJavaScript", "goBack", "goForward", "reload", "stopLoading", "", "obj", "interfaceName", "addJavascriptInterface", "(Ljava/lang/Object;Ljava/lang/String;)V", "", "Landroid/net/Uri;", "uris", "setFileUploadUri", "([Landroid/net/Uri;)V", "cancelFileUpload", "Lh/c/s;", "Lcom/coinbase/cipherwebview/models/web3/call/Web3Call;", "kotlin.jvm.PlatformType", "onWeb3Call", "Lh/c/s;", "getOnWeb3Call", "()Lh/c/s;", "Landroid/webkit/WebView;", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "", "onCanGoForwardChange", "getOnCanGoForwardChange", "onNavigationCommit", "getOnNavigationCommit", "Lh/c/v0/b;", "Lcom/coinbase/cipherwebview/models/NavigationError;", "navigationErrorSubject", "Lh/c/v0/b;", "getNavigationErrorSubject$cipher_webview_release", "()Lh/c/v0/b;", "Lcom/coinbase/cipherwebview/models/NavigationSSLError;", "onNavigationSSLError", "getOnNavigationSSLError", "onIsLoadingChange", "getOnIsLoadingChange", "Lkotlin/Function1;", "Landroid/webkit/WebResourceRequest;", "shouldOverrideUrlLoading", "Lkotlin/e0/c/l;", "getShouldOverrideUrlLoading", "()Lkotlin/e0/c/l;", "setShouldOverrideUrlLoading", "(Lkotlin/e0/c/l;)V", "Lcom/coinbase/cipherwebview/models/JSPrompt;", "onJSPrompt", "getOnJSPrompt", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onRequestInterceptionError", "getOnRequestInterceptionError", "Lcom/coinbase/cipherwebview/models/NavigationHTTPError;", "navigationHTTPErrorSubject", "getNavigationHTTPErrorSubject$cipher_webview_release", "", "onProgressChange", "getOnProgressChange", "onMessage", "getOnMessage", "Lh/c/v0/a;", "titleChangeSubject", "Lh/c/v0/a;", "getTitleChangeSubject$cipher_webview_release", "()Lh/c/v0/a;", "onUrlChange", "getOnUrlChange", "onNavigationError", "getOnNavigationError", "Lcom/coinbase/cipherwebview/httpclient/HttpClient;", "httpClient", "Lcom/coinbase/cipherwebview/httpclient/HttpClient;", "Lcom/coinbase/cipherwebview/models/JSConfirm;", "jsConfirmSubject", "getJsConfirmSubject$cipher_webview_release", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileUploadSubject", "getFileUploadSubject$cipher_webview_release", "messageSubject", "getMessageSubject$cipher_webview_release", "onJSConfirm", "getOnJSConfirm", "urlChangeSubject", "getUrlChangeSubject$cipher_webview_release", "isLoadingSubject", "isLoadingSubject$cipher_webview_release", "navigationStartSubject", "getNavigationStartSubject$cipher_webview_release", "getCurrentUrl", "()Ljava/lang/String;", "currentUrl", "Lcom/coinbase/cipherwebview/models/AuthenticationChallenge;", "authenticationChallengeSubject", "getAuthenticationChallengeSubject$cipher_webview_release", "onNavigationStart", "getOnNavigationStart", "Lcom/coinbase/cipherwebview/models/JSAlert;", "onJSAlert", "getOnJSAlert", "bundleJs", "Ljava/lang/String;", "progressChangeSubject", "getProgressChangeSubject$cipher_webview_release", "onNavigationFinish", "getOnNavigationFinish", "onCanGoBackChange", "getOnCanGoBackChange", "canGoBackSubject", "getCanGoBackSubject$cipher_webview_release", "jsPromptSubject", "getJsPromptSubject$cipher_webview_release", "Lcom/coinbase/cipherwebview/models/CipherWebViewConfiguration;", "configuration", "Lcom/coinbase/cipherwebview/models/CipherWebViewConfiguration;", "jsAlertSubject", "getJsAlertSubject$cipher_webview_release", "defaultUserAgentString", "navigationSSLErrorSubject", "getNavigationSSLErrorSubject$cipher_webview_release", "navigationFinishSubject", "getNavigationFinishSubject$cipher_webview_release", "onTitleChange", "getOnTitleChange", "initialPageLoadedSubject", "getInitialPageLoadedSubject$cipher_webview_release", "onInitialPageLoadedChange", "getOnInitialPageLoadedChange", "onAuthenticationChallenge", "getOnAuthenticationChallenge", "web3CallSubject", "getWeb3CallSubject$cipher_webview_release", "onNavigationHTTPError", "getOnNavigationHTTPError", "Landroid/webkit/ValueCallback;", "fileUploadCallback", "Landroid/webkit/ValueCallback;", "requestInterceptionErrorSubject", "getRequestInterceptionErrorSubject$cipher_webview_release", "canGoForwardSubject", "getCanGoForwardSubject$cipher_webview_release", "onFileUpload", "getOnFileUpload", "navigationCommitSubject", "getNavigationCommitSubject$cipher_webview_release", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class CipherWebView extends FrameLayout {
    private static final String BLANK_URL_STRING = "about:blank";
    public static final Companion Companion = new Companion(null);
    private static final Set<Integer> REDIRECT_STATUS_CODES;
    private final h.c.v0.b<AuthenticationChallenge> authenticationChallengeSubject;
    private String bundleJs;
    private final h.c.v0.a<Boolean> canGoBackSubject;
    private final h.c.v0.a<Boolean> canGoForwardSubject;
    private CipherWebViewConfiguration configuration;
    private final String defaultUserAgentString;
    private ValueCallback<Uri[]> fileUploadCallback;
    private final h.c.v0.b<WebChromeClient.FileChooserParams> fileUploadSubject;
    private HttpClient httpClient;
    private final h.c.v0.a<Boolean> initialPageLoadedSubject;
    private final h.c.v0.a<Boolean> isLoadingSubject;
    private final h.c.v0.b<JSAlert> jsAlertSubject;
    private final h.c.v0.b<JSConfirm> jsConfirmSubject;
    private final h.c.v0.b<JSPrompt> jsPromptSubject;
    private final h.c.v0.b<String> messageSubject;
    private final h.c.v0.b<x> navigationCommitSubject;
    private final h.c.v0.b<NavigationError> navigationErrorSubject;
    private final h.c.v0.b<x> navigationFinishSubject;
    private final h.c.v0.b<NavigationHTTPError> navigationHTTPErrorSubject;
    private final h.c.v0.b<NavigationSSLError> navigationSSLErrorSubject;
    private final h.c.v0.b<x> navigationStartSubject;
    private final s<AuthenticationChallenge> onAuthenticationChallenge;
    private final s<Boolean> onCanGoBackChange;
    private final s<Boolean> onCanGoForwardChange;
    private final s<WebChromeClient.FileChooserParams> onFileUpload;
    private final s<Boolean> onInitialPageLoadedChange;
    private final s<Boolean> onIsLoadingChange;
    private final s<JSAlert> onJSAlert;
    private final s<JSConfirm> onJSConfirm;
    private final s<JSPrompt> onJSPrompt;
    private final s<String> onMessage;
    private final s<x> onNavigationCommit;
    private final s<NavigationError> onNavigationError;
    private final s<x> onNavigationFinish;
    private final s<NavigationHTTPError> onNavigationHTTPError;
    private final s<NavigationSSLError> onNavigationSSLError;
    private final s<x> onNavigationStart;
    private final s<Double> onProgressChange;
    private final s<Exception> onRequestInterceptionError;
    private final s<String> onTitleChange;
    private final s<String> onUrlChange;
    private final s<Web3Call> onWeb3Call;
    private final h.c.v0.a<Double> progressChangeSubject;
    private final h.c.v0.b<Exception> requestInterceptionErrorSubject;
    private l<? super WebResourceRequest, Boolean> shouldOverrideUrlLoading;
    private final h.c.v0.a<String> titleChangeSubject;
    private final h.c.v0.a<String> urlChangeSubject;
    private final h.c.v0.a<Web3Call> web3CallSubject;
    private final WebView webView;

    /* compiled from: CipherWebView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJM\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\u0010\t\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/coinbase/cipherwebview/CipherWebView$Companion;", "", "Landroid/content/Context;", "context", "Lcom/coinbase/cipherwebview/httpclient/HttpClient;", "httpClient", "Lh/c/v0/b;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "requestInterceptionErrorSubject", "Landroid/webkit/WebView;", "webView", "Landroid/webkit/WebResourceRequest;", "request", "", "fromServiceWorker", "Landroid/webkit/WebResourceResponse;", "shouldInterceptRequest$cipher_webview_release", "(Landroid/content/Context;Lcom/coinbase/cipherwebview/httpclient/HttpClient;Lh/c/v0/b;Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Z)Landroid/webkit/WebResourceResponse;", "shouldInterceptRequest", "", "BLANK_URL_STRING", "Ljava/lang/String;", "", "", "REDIRECT_STATUS_CODES", "Ljava/util/Set;", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void a(WebView webView, d0 d0Var) {
            m611shouldInterceptRequest$lambda0(webView, d0Var);
        }

        public static /* synthetic */ WebResourceResponse shouldInterceptRequest$cipher_webview_release$default(Companion companion, Context context, HttpClient httpClient, h.c.v0.b bVar, WebView webView, WebResourceRequest webResourceRequest, boolean z, int i2, Object obj) {
            if ((i2 & 32) != 0) {
                z = false;
            }
            return companion.shouldInterceptRequest$cipher_webview_release(context, httpClient, bVar, webView, webResourceRequest, z);
        }

        /* renamed from: shouldInterceptRequest$lambda-0 */
        public static final void m611shouldInterceptRequest$lambda0(WebView webView, d0 location) {
            m.g(webView, "$webView");
            m.g(location, "$location");
            webView.loadUrl((String) location.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:64:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0089  */
        /* JADX WARN: Type inference failed for: r6v17, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v6, types: [T, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final android.webkit.WebResourceResponse shouldInterceptRequest$cipher_webview_release(android.content.Context r5, com.coinbase.cipherwebview.httpclient.HttpClient r6, h.c.v0.b<java.lang.Exception> r7, final android.webkit.WebView r8, android.webkit.WebResourceRequest r9, boolean r10) {
            /*
                r4 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.m.g(r5, r0)
                java.lang.String r0 = "httpClient"
                kotlin.jvm.internal.m.g(r6, r0)
                java.lang.String r0 = "requestInterceptionErrorSubject"
                kotlin.jvm.internal.m.g(r7, r0)
                java.lang.String r0 = "webView"
                kotlin.jvm.internal.m.g(r8, r0)
                java.lang.String r0 = "request"
                kotlin.jvm.internal.m.g(r9, r0)
                boolean r0 = r9.isForMainFrame()
                r1 = 0
                if (r0 != 0) goto L23
                if (r10 != 0) goto L23
                return r1
            L23:
                android.net.Uri r10 = r9.getUrl()
                java.lang.String r10 = r10.toString()
                java.lang.String r0 = "request.url.toString()"
                kotlin.jvm.internal.m.f(r10, r0)
                r0 = 2
                java.lang.String r2 = r9.getMethod()     // Catch: java.lang.Exception -> L4d
                java.lang.String r3 = "GET"
                boolean r2 = kotlin.jvm.internal.m.c(r2, r3)     // Catch: java.lang.Exception -> L4d
                if (r2 != 0) goto L3e
            L3d:
                goto L51
            L3e:
                java.lang.String r2 = "data:"
                r3 = 0
                boolean r10 = kotlin.l0.o.Q(r10, r2, r3, r0, r1)     // Catch: java.lang.Exception -> L4d
                if (r10 == 0) goto L48
                goto L3d
            L48:
                kotlin.o r6 = r6.makeWebRequest(r9)     // Catch: java.lang.Exception -> L4d
                goto L52
            L4d:
                r6 = move-exception
                r7.onNext(r6)
            L51:
                r6 = r1
            L52:
                if (r6 != 0) goto L56
                r7 = r1
                goto L5c
            L56:
                java.lang.Object r7 = r6.c()
                android.webkit.WebResourceResponse r7 = (android.webkit.WebResourceResponse) r7
            L5c:
                if (r6 != 0) goto L60
                r6 = r1
                goto L66
            L60:
                java.lang.Object r6 = r6.d()
                okhttp3.Response r6 = (okhttp3.Response) r6
            L66:
                if (r6 == 0) goto Ld4
                java.util.Set r10 = com.coinbase.cipherwebview.CipherWebView.access$getREDIRECT_STATUS_CODES$cp()
                int r2 = r6.code()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                boolean r10 = r10.contains(r2)
                if (r10 == 0) goto Ld4
                kotlin.jvm.internal.d0 r10 = new kotlin.jvm.internal.d0
                r10.<init>()
                java.lang.String r2 = "Location"
                java.lang.String r6 = okhttp3.Response.header$default(r6, r2, r1, r0, r1)
                r10.a = r6
                if (r6 == 0) goto Ld4
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                boolean r6 = kotlin.l0.o.D(r6)
                r6 = r6 ^ 1
                if (r6 == 0) goto Ld4
                T r6 = r10.a     // Catch: java.lang.Exception -> Ld4
                java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> Ld4
                android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch: java.lang.Exception -> Ld4
                boolean r0 = r6.isRelative()
                if (r0 == 0) goto Lc2
                android.net.Uri r9 = r9.getUrl()
                android.net.Uri$Builder r9 = r9.buildUpon()
                java.lang.String r6 = r6.getPath()
                android.net.Uri$Builder r6 = r9.path(r6)
                android.net.Uri r6 = r6.build()
                boolean r9 = r6.isAbsolute()
                if (r9 != 0) goto Lbc
                return r7
            Lbc:
                java.lang.String r6 = r6.toString()
                r10.a = r6
            Lc2:
                android.os.Handler r6 = new android.os.Handler
                android.os.Looper r5 = r5.getMainLooper()
                r6.<init>(r5)
                com.coinbase.cipherwebview.d r5 = new com.coinbase.cipherwebview.d
                r5.<init>()
                r6.post(r5)
            Ld4:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coinbase.cipherwebview.CipherWebView.Companion.shouldInterceptRequest$cipher_webview_release(android.content.Context, com.coinbase.cipherwebview.httpclient.HttpClient, h.c.v0.b, android.webkit.WebView, android.webkit.WebResourceRequest, boolean):android.webkit.WebResourceResponse");
        }
    }

    static {
        Set<Integer> e2;
        e2 = s0.e(Integer.valueOf((int) HttpStatus.SC_MOVED_PERMANENTLY), Integer.valueOf((int) HttpStatus.SC_MOVED_TEMPORARILY), Integer.valueOf((int) HttpStatus.SC_SEE_OTHER), 307, Integer.valueOf((int) StatusLine.HTTP_PERM_REDIRECT));
        REDIRECT_STATUS_CODES = e2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CipherWebView(Context context) {
        this(context, null, 0, 0);
        m.g(context, "context");
    }

    public static /* synthetic */ void a(CipherWebView cipherWebView) {
        m605goBack$lambda4(cipherWebView);
    }

    public static final /* synthetic */ ValueCallback access$getFileUploadCallback$p(CipherWebView cipherWebView) {
        return cipherWebView.fileUploadCallback;
    }

    public static final /* synthetic */ HttpClient access$getHttpClient$p(CipherWebView cipherWebView) {
        return cipherWebView.httpClient;
    }

    public static final /* synthetic */ void access$publishWebViewState(CipherWebView cipherWebView) {
        cipherWebView.publishWebViewState();
    }

    public static final /* synthetic */ void access$setFileUploadCallback$p(CipherWebView cipherWebView, ValueCallback valueCallback) {
        cipherWebView.fileUploadCallback = valueCallback;
    }

    /* renamed from: addJavascriptInterface$lambda-8 */
    public static final void m603addJavascriptInterface$lambda8(CipherWebView this$0, Object obj, String interfaceName) {
        m.g(this$0, "this$0");
        m.g(obj, "$obj");
        m.g(interfaceName, "$interfaceName");
        this$0.getWebView().addJavascriptInterface(obj, interfaceName);
    }

    public static /* synthetic */ void b(CipherWebView cipherWebView, String str, String str2, String str3) {
        m607loadHTML$lambda2(cipherWebView, str, str2, str3);
    }

    public static /* synthetic */ void c(CipherWebView cipherWebView) {
        m610stopLoading$lambda7(cipherWebView);
    }

    public static /* synthetic */ void configure$default(CipherWebView cipherWebView, String str, String str2, String str3, int i2, Map map, String str4, OkHttpClient.Builder builder, int i3, Object obj) {
        Map map2;
        Map i4;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: configure");
        }
        if ((i3 & 16) != 0) {
            i4 = m0.i();
            map2 = i4;
        } else {
            map2 = map;
        }
        cipherWebView.configure(str, str2, str3, i2, map2, (i3 & 32) != 0 ? cipherWebView.defaultUserAgentString : str4, (i3 & 64) != 0 ? new OkHttpClient.Builder() : builder);
    }

    public static /* synthetic */ void d(CipherWebView cipherWebView, Object obj, String str) {
        m603addJavascriptInterface$lambda8(cipherWebView, obj, str);
    }

    public static /* synthetic */ void e(String str, CipherWebView cipherWebView) {
        m608loadURL$lambda1(str, cipherWebView);
    }

    /* renamed from: evaluateJavaScript$lambda-3 */
    public static final void m604evaluateJavaScript$lambda3(CipherWebView this$0, String javaScriptString) {
        m.g(this$0, "this$0");
        m.g(javaScriptString, "$javaScriptString");
        this$0.getWebView().evaluateJavascript(javaScriptString, null);
    }

    public static /* synthetic */ void f(CipherWebView cipherWebView, String str) {
        m604evaluateJavaScript$lambda3(cipherWebView, str);
    }

    public static /* synthetic */ void g(CipherWebView cipherWebView) {
        m606goForward$lambda5(cipherWebView);
    }

    /* renamed from: goBack$lambda-4 */
    public static final void m605goBack$lambda4(CipherWebView this$0) {
        m.g(this$0, "this$0");
        this$0.getWebView().goBack();
    }

    /* renamed from: goForward$lambda-5 */
    public static final void m606goForward$lambda5(CipherWebView this$0) {
        m.g(this$0, "this$0");
        this$0.getWebView().goForward();
    }

    public static /* synthetic */ void h(CipherWebView cipherWebView) {
        m609reload$lambda6(cipherWebView);
    }

    public static /* synthetic */ void loadHTML$default(CipherWebView cipherWebView, String str, String str2, String str3, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadHTML");
        }
        if ((i2 & 4) != 0) {
            str3 = "UTF-8";
        }
        cipherWebView.loadHTML(str, str2, str3);
    }

    /* renamed from: loadHTML$lambda-2 */
    public static final void m607loadHTML$lambda2(CipherWebView this$0, String baseURLString, String htmlString, String encoding) {
        m.g(this$0, "this$0");
        m.g(baseURLString, "$baseURLString");
        m.g(htmlString, "$htmlString");
        m.g(encoding, "$encoding");
        this$0.getWebView().loadDataWithBaseURL(baseURLString, htmlString, "text/html", encoding, null);
    }

    /* renamed from: loadURL$lambda-1 */
    public static final void m608loadURL$lambda1(String urlString, CipherWebView this$0) {
        m.g(urlString, "$urlString");
        m.g(this$0, "this$0");
        if (m.c(urlString, this$0.getWebView().getUrl())) {
            this$0.getWebView().loadUrl("javascript:window.location.reload( true )");
        }
        this$0.getWebView().loadUrl(urlString);
    }

    public final void publishWebViewState() {
        String title = this.webView.getTitle();
        double progress = this.webView.getProgress() / 100.0d;
        String url = this.webView.getUrl();
        boolean z = progress < 1.0d;
        boolean canGoBack = this.webView.canGoBack();
        boolean canGoForward = this.webView.canGoForward();
        if (title != null && !m.c(this.titleChangeSubject.f(), title)) {
            this.titleChangeSubject.onNext(title);
        }
        if (url != null && !m.c(this.urlChangeSubject.f(), url)) {
            this.urlChangeSubject.onNext(url);
        }
        if (!m.a(this.progressChangeSubject.f(), progress)) {
            this.progressChangeSubject.onNext(Double.valueOf(progress));
        }
        if (!m.c(this.isLoadingSubject.f(), Boolean.valueOf(z))) {
            this.isLoadingSubject.onNext(Boolean.valueOf(z));
        }
        if (!m.c(this.canGoBackSubject.f(), Boolean.valueOf(canGoBack))) {
            this.canGoBackSubject.onNext(Boolean.valueOf(canGoBack));
        }
        if (!m.c(this.canGoForwardSubject.f(), Boolean.valueOf(canGoForward))) {
            this.canGoForwardSubject.onNext(Boolean.valueOf(canGoForward));
        }
        if (z) {
            return;
        }
        Boolean f2 = this.initialPageLoadedSubject.f();
        Boolean bool = Boolean.TRUE;
        if (m.c(f2, bool)) {
            return;
        }
        this.initialPageLoadedSubject.onNext(bool);
    }

    /* renamed from: reload$lambda-6 */
    public static final void m609reload$lambda6(CipherWebView this$0) {
        m.g(this$0, "this$0");
        this$0.getWebView().reload();
    }

    private final void setupWebView() {
        final WebView webView = this.webView;
        webView.setBackgroundColor(-1);
        WebSettings settings = webView.getSettings();
        settings.setDatabaseEnabled(false);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(2);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT >= 24) {
            ServiceWorkerController serviceWorkerController = ServiceWorkerController.getInstance();
            m.f(serviceWorkerController, "getInstance()");
            serviceWorkerController.setServiceWorkerClient(new ServiceWorkerClient() { // from class: com.coinbase.cipherwebview.CipherWebView$setupWebView$1$2
                @Override // android.webkit.ServiceWorkerClient
                @TargetApi(26)
                public WebResourceResponse shouldInterceptRequest(WebResourceRequest request) {
                    m.g(request, "request");
                    l.a.a.g("shouldInterceptRequest / ServiceWorkerClient", new Object[0]);
                    if (Build.VERSION.SDK_INT >= 26) {
                        CipherWebView.Companion companion = CipherWebView.Companion;
                        Context context = webView.getContext();
                        m.f(context, "context");
                        HttpClient access$getHttpClient$p = CipherWebView.access$getHttpClient$p(this);
                        if (access$getHttpClient$p == null) {
                            m.w("httpClient");
                            throw null;
                        }
                        WebResourceResponse shouldInterceptRequest$cipher_webview_release = companion.shouldInterceptRequest$cipher_webview_release(context, access$getHttpClient$p, this.getRequestInterceptionErrorSubject$cipher_webview_release(), this.getWebView(), request, true);
                        if (shouldInterceptRequest$cipher_webview_release != null) {
                            l.a.a.g("shouldInterceptRequest / ServiceWorkerClient -> return intersept response", new Object[0]);
                            return shouldInterceptRequest$cipher_webview_release;
                        }
                        l.a.a.g("shouldInterceptRequest / ServiceWorkerClient -> intercept response is null, delegating up", new Object[0]);
                    }
                    return super.shouldInterceptRequest(request);
                }
            });
        }
        webView.setWebViewClient(new WebViewClient() { // from class: com.coinbase.cipherwebview.CipherWebView$setupWebView$1$3
            @Override // android.webkit.WebViewClient
            public void onPageCommitVisible(WebView webView2, String str) {
                CipherWebView.access$publishWebViewState(CipherWebView.this);
                CipherWebView.this.getNavigationCommitSubject$cipher_webview_release().onNext(x.a);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                CipherWebView.access$publishWebViewState(CipherWebView.this);
                CipherWebView.this.getNavigationFinishSubject$cipher_webview_release().onNext(x.a);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                CipherWebView.access$publishWebViewState(CipherWebView.this);
                CipherWebView.this.getNavigationStartSubject$cipher_webview_release().onNext(x.a);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                CipherWebView.access$publishWebViewState(CipherWebView.this);
                if (webResourceRequest != null && webResourceError != null && CipherWebView.this.getNavigationErrorSubject$cipher_webview_release().e()) {
                    CipherWebView.this.getNavigationErrorSubject$cipher_webview_release().onNext(new NavigationError(webResourceRequest, webResourceError));
                } else {
                    super.onReceivedError(webView2, webResourceRequest, webResourceError);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpAuthRequest(WebView webView2, HttpAuthHandler httpAuthHandler, String str, String str2) {
                CipherWebView.access$publishWebViewState(CipherWebView.this);
                if (str != null && httpAuthHandler != null && CipherWebView.this.getAuthenticationChallengeSubject$cipher_webview_release().e()) {
                    CipherWebView.this.getAuthenticationChallengeSubject$cipher_webview_release().onNext(new AuthenticationChallenge(str, str2, httpAuthHandler));
                } else {
                    super.onReceivedHttpAuthRequest(webView2, httpAuthHandler, str, str2);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                CipherWebView.access$publishWebViewState(CipherWebView.this);
                if (webResourceRequest != null && webResourceResponse != null && CipherWebView.this.getNavigationHTTPErrorSubject$cipher_webview_release().e()) {
                    CipherWebView.this.getNavigationHTTPErrorSubject$cipher_webview_release().onNext(new NavigationHTTPError(webResourceRequest, webResourceResponse));
                } else {
                    super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                CipherWebView.access$publishWebViewState(CipherWebView.this);
                if (sslError != null && sslErrorHandler != null && CipherWebView.this.getNavigationSSLErrorSubject$cipher_webview_release().e()) {
                    CipherWebView.this.getNavigationSSLErrorSubject$cipher_webview_release().onNext(new NavigationSSLError(sslError, sslErrorHandler));
                } else {
                    super.onReceivedSslError(webView2, sslErrorHandler, sslError);
                }
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                m.g(view, "view");
                m.g(request, "request");
                CipherWebView.Companion companion = CipherWebView.Companion;
                Context context = webView.getContext();
                m.f(context, "context");
                HttpClient access$getHttpClient$p = CipherWebView.access$getHttpClient$p(CipherWebView.this);
                if (access$getHttpClient$p != null) {
                    return CipherWebView.Companion.shouldInterceptRequest$cipher_webview_release$default(companion, context, access$getHttpClient$p, CipherWebView.this.getRequestInterceptionErrorSubject$cipher_webview_release(), view, request, false, 32, null);
                }
                m.w("httpClient");
                throw null;
            }

            /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
            @Override // android.webkit.WebViewClient
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean shouldOverrideUrlLoading(android.webkit.WebView r6, java.lang.String r7) {
                /*
                    r5 = this;
                    r0 = 1
                    r1 = 0
                    if (r7 != 0) goto L6
                L4:
                    r2 = r1
                    goto L11
                L6:
                    r2 = 2
                    r3 = 0
                    java.lang.String r4 = "twitter://"
                    boolean r2 = kotlin.l0.o.Q(r7, r4, r1, r2, r3)
                    if (r2 != r0) goto L4
                    r2 = r0
                L11:
                    if (r2 == 0) goto L33
                    android.content.Intent r2 = new android.content.Intent
                    java.lang.String r3 = "android.intent.action.VIEW"
                    r2.<init>(r3)
                    android.net.Uri r3 = android.net.Uri.parse(r7)     // Catch: java.lang.Throwable -> L2b
                    r2.setData(r3)     // Catch: java.lang.Throwable -> L2b
                    android.webkit.WebView r3 = r2     // Catch: java.lang.Throwable -> L2b
                    android.content.Context r3 = r3.getContext()     // Catch: java.lang.Throwable -> L2b
                    r3.startActivity(r2)     // Catch: java.lang.Throwable -> L2b
                    return r0
                L2b:
                    r0 = move-exception
                    java.lang.Object[] r1 = new java.lang.Object[r1]
                    java.lang.String r2 = "Unable to start twitter app"
                    l.a.a.f(r0, r2, r1)
                L33:
                    boolean r6 = super.shouldOverrideUrlLoading(r6, r7)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.cipherwebview.CipherWebView$setupWebView$1$3.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                if (CipherWebView.this.getShouldOverrideUrlLoading().invoke(webResourceRequest).booleanValue()) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView2, webResourceRequest);
            }
        });
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.coinbase.cipherwebview.CipherWebView$setupWebView$1$4
            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                if (webView.getUrl() != null && jsResult != null && CipherWebView.this.getJsAlertSubject$cipher_webview_release().e()) {
                    h.c.v0.b<JSAlert> jsAlertSubject$cipher_webview_release = CipherWebView.this.getJsAlertSubject$cipher_webview_release();
                    if (str2 == null) {
                        str2 = "";
                    }
                    jsAlertSubject$cipher_webview_release.onNext(new JSAlert(str2, jsResult));
                    return true;
                }
                return super.onJsAlert(webView2, webView.getUrl(), str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView2, String str, String str2, JsResult jsResult) {
                if (str != null && jsResult != null && CipherWebView.this.getJsConfirmSubject$cipher_webview_release().e()) {
                    h.c.v0.b<JSConfirm> jsConfirmSubject$cipher_webview_release = CipherWebView.this.getJsConfirmSubject$cipher_webview_release();
                    if (str2 == null) {
                        str2 = "";
                    }
                    jsConfirmSubject$cipher_webview_release.onNext(new JSConfirm(str2, jsResult));
                    return true;
                }
                return super.onJsConfirm(webView2, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView2, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                if (str != null && jsPromptResult != null && CipherWebView.this.getJsPromptSubject$cipher_webview_release().e()) {
                    h.c.v0.b<JSPrompt> jsPromptSubject$cipher_webview_release = CipherWebView.this.getJsPromptSubject$cipher_webview_release();
                    if (str2 == null) {
                        str2 = "";
                    }
                    jsPromptSubject$cipher_webview_release.onNext(new JSPrompt(str2, str3, jsPromptResult));
                    return true;
                }
                return super.onJsPrompt(webView2, str, str2, str3, jsPromptResult);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i2) {
                CipherWebView.access$publishWebViewState(CipherWebView.this);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView2, String str) {
                CipherWebView.access$publishWebViewState(CipherWebView.this);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView2, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                ValueCallback access$getFileUploadCallback$p = CipherWebView.access$getFileUploadCallback$p(CipherWebView.this);
                if (access$getFileUploadCallback$p != null) {
                    access$getFileUploadCallback$p.onReceiveValue(null);
                }
                CipherWebView.access$setFileUploadCallback$p(CipherWebView.this, valueCallback);
                if (fileChooserParams != null) {
                    CipherWebView.this.getFileUploadSubject$cipher_webview_release().onNext(fileChooserParams);
                    return true;
                }
                return false;
            }
        });
        webView.addJavascriptInterface(new CipherWebViewJavaScriptInterface(this), "__CIPHER_BRIDGE__");
    }

    /* renamed from: stopLoading$lambda-7 */
    public static final void m610stopLoading$lambda7(CipherWebView this$0) {
        m.g(this$0, "this$0");
        this$0.getWebView().stopLoading();
    }

    public void _$_clearFindViewByIdCache() {
    }

    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(final Object obj, final String interfaceName) {
        m.g(obj, "obj");
        m.g(interfaceName, "interfaceName");
        new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.coinbase.cipherwebview.e
            @Override // java.lang.Runnable
            public final void run() {
                CipherWebView.d(CipherWebView.this, obj, interfaceName);
            }
        });
    }

    public void cancelFileUpload() {
        ValueCallback<Uri[]> valueCallback = this.fileUploadCallback;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
        }
        this.fileUploadCallback = null;
    }

    public synchronized void configure(String appName, String appVersion, String str, int i2, Map<String, String> additionalHeaders, String userAgentString, OkHttpClient.Builder httpClientBuilder) {
        m.g(appName, "appName");
        m.g(appVersion, "appVersion");
        m.g(additionalHeaders, "additionalHeaders");
        m.g(userAgentString, "userAgentString");
        m.g(httpClientBuilder, "httpClientBuilder");
        if (this.bundleJs == null) {
            InputStream openRawResource = getContext().getResources().openRawResource(R.raw.bundle);
            m.f(openRawResource, "context.resources.openRawResource(R.raw.bundle)");
            e0 k2 = q.k(openRawResource);
            String G0 = q.d(k2).G0();
            kotlin.io.a.a(k2, null);
            this.bundleJs = G0;
        }
        if (this.httpClient == null) {
            this.httpClient = new HttpClient(userAgentString, httpClientBuilder, additionalHeaders);
        }
        CipherWebViewConfiguration cipherWebViewConfiguration = new CipherWebViewConfiguration(appName, appVersion, str, i2);
        String json = CipherWebViewConfiguration.Companion.getJsonAdapter$cipher_webview_release().toJson(cipherWebViewConfiguration);
        String str2 = ";window.__initializeCipherWebView__(" + ((Object) json) + ");";
        HttpClient httpClient = this.httpClient;
        if (httpClient == null) {
            m.w("httpClient");
            throw null;
        }
        String str3 = this.bundleJs;
        if (str3 != null) {
            httpClient.setInjectionJs$cipher_webview_release(m.o(str3, str2));
            this.configuration = cipherWebViewConfiguration;
            reload();
        } else {
            m.w("bundleJs");
            throw null;
        }
    }

    public void evaluateJavaScript(final String javaScriptString) {
        m.g(javaScriptString, "javaScriptString");
        new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.coinbase.cipherwebview.g
            @Override // java.lang.Runnable
            public final void run() {
                CipherWebView.f(CipherWebView.this, javaScriptString);
            }
        });
    }

    public final h.c.v0.b<AuthenticationChallenge> getAuthenticationChallengeSubject$cipher_webview_release() {
        return this.authenticationChallengeSubject;
    }

    public final h.c.v0.a<Boolean> getCanGoBackSubject$cipher_webview_release() {
        return this.canGoBackSubject;
    }

    public final h.c.v0.a<Boolean> getCanGoForwardSubject$cipher_webview_release() {
        return this.canGoForwardSubject;
    }

    public final String getCurrentUrl() {
        return this.webView.getUrl();
    }

    public final h.c.v0.b<WebChromeClient.FileChooserParams> getFileUploadSubject$cipher_webview_release() {
        return this.fileUploadSubject;
    }

    public final h.c.v0.a<Boolean> getInitialPageLoadedSubject$cipher_webview_release() {
        return this.initialPageLoadedSubject;
    }

    public final h.c.v0.b<JSAlert> getJsAlertSubject$cipher_webview_release() {
        return this.jsAlertSubject;
    }

    public final h.c.v0.b<JSConfirm> getJsConfirmSubject$cipher_webview_release() {
        return this.jsConfirmSubject;
    }

    public final h.c.v0.b<JSPrompt> getJsPromptSubject$cipher_webview_release() {
        return this.jsPromptSubject;
    }

    public final h.c.v0.b<String> getMessageSubject$cipher_webview_release() {
        return this.messageSubject;
    }

    public final h.c.v0.b<x> getNavigationCommitSubject$cipher_webview_release() {
        return this.navigationCommitSubject;
    }

    public final h.c.v0.b<NavigationError> getNavigationErrorSubject$cipher_webview_release() {
        return this.navigationErrorSubject;
    }

    public final h.c.v0.b<x> getNavigationFinishSubject$cipher_webview_release() {
        return this.navigationFinishSubject;
    }

    public final h.c.v0.b<NavigationHTTPError> getNavigationHTTPErrorSubject$cipher_webview_release() {
        return this.navigationHTTPErrorSubject;
    }

    public final h.c.v0.b<NavigationSSLError> getNavigationSSLErrorSubject$cipher_webview_release() {
        return this.navigationSSLErrorSubject;
    }

    public final h.c.v0.b<x> getNavigationStartSubject$cipher_webview_release() {
        return this.navigationStartSubject;
    }

    public final s<AuthenticationChallenge> getOnAuthenticationChallenge() {
        return this.onAuthenticationChallenge;
    }

    public final s<Boolean> getOnCanGoBackChange() {
        return this.onCanGoBackChange;
    }

    public final s<Boolean> getOnCanGoForwardChange() {
        return this.onCanGoForwardChange;
    }

    public final s<WebChromeClient.FileChooserParams> getOnFileUpload() {
        return this.onFileUpload;
    }

    public final s<Boolean> getOnInitialPageLoadedChange() {
        return this.onInitialPageLoadedChange;
    }

    public final s<Boolean> getOnIsLoadingChange() {
        return this.onIsLoadingChange;
    }

    public final s<JSAlert> getOnJSAlert() {
        return this.onJSAlert;
    }

    public final s<JSConfirm> getOnJSConfirm() {
        return this.onJSConfirm;
    }

    public final s<JSPrompt> getOnJSPrompt() {
        return this.onJSPrompt;
    }

    public final s<String> getOnMessage() {
        return this.onMessage;
    }

    public final s<x> getOnNavigationCommit() {
        return this.onNavigationCommit;
    }

    public final s<NavigationError> getOnNavigationError() {
        return this.onNavigationError;
    }

    public final s<x> getOnNavigationFinish() {
        return this.onNavigationFinish;
    }

    public final s<NavigationHTTPError> getOnNavigationHTTPError() {
        return this.onNavigationHTTPError;
    }

    public final s<NavigationSSLError> getOnNavigationSSLError() {
        return this.onNavigationSSLError;
    }

    public final s<x> getOnNavigationStart() {
        return this.onNavigationStart;
    }

    public final s<Double> getOnProgressChange() {
        return this.onProgressChange;
    }

    public final s<Exception> getOnRequestInterceptionError() {
        return this.onRequestInterceptionError;
    }

    public final s<String> getOnTitleChange() {
        return this.onTitleChange;
    }

    public final s<String> getOnUrlChange() {
        return this.onUrlChange;
    }

    public final s<Web3Call> getOnWeb3Call() {
        return this.onWeb3Call;
    }

    public final h.c.v0.a<Double> getProgressChangeSubject$cipher_webview_release() {
        return this.progressChangeSubject;
    }

    public final h.c.v0.b<Exception> getRequestInterceptionErrorSubject$cipher_webview_release() {
        return this.requestInterceptionErrorSubject;
    }

    public final l<WebResourceRequest, Boolean> getShouldOverrideUrlLoading() {
        return this.shouldOverrideUrlLoading;
    }

    public final h.c.v0.a<String> getTitleChangeSubject$cipher_webview_release() {
        return this.titleChangeSubject;
    }

    public final h.c.v0.a<String> getUrlChangeSubject$cipher_webview_release() {
        return this.urlChangeSubject;
    }

    public final h.c.v0.a<Web3Call> getWeb3CallSubject$cipher_webview_release() {
        return this.web3CallSubject;
    }

    public final WebView getWebView() {
        return this.webView;
    }

    public void goBack() {
        new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.coinbase.cipherwebview.a
            @Override // java.lang.Runnable
            public final void run() {
                CipherWebView.a(CipherWebView.this);
            }
        });
    }

    public void goForward() {
        new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.coinbase.cipherwebview.h
            @Override // java.lang.Runnable
            public final void run() {
                CipherWebView.g(CipherWebView.this);
            }
        });
    }

    public final h.c.v0.a<Boolean> isLoadingSubject$cipher_webview_release() {
        return this.isLoadingSubject;
    }

    public void loadHTML(final String htmlString, final String baseURLString, final String encoding) {
        m.g(htmlString, "htmlString");
        m.g(baseURLString, "baseURLString");
        m.g(encoding, "encoding");
        new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.coinbase.cipherwebview.b
            @Override // java.lang.Runnable
            public final void run() {
                CipherWebView.b(CipherWebView.this, baseURLString, htmlString, encoding);
            }
        });
    }

    public void loadURL(final String urlString) {
        m.g(urlString, "urlString");
        new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.coinbase.cipherwebview.f
            @Override // java.lang.Runnable
            public final void run() {
                CipherWebView.e(urlString, this);
            }
        });
    }

    public void reload() {
        new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.coinbase.cipherwebview.i
            @Override // java.lang.Runnable
            public final void run() {
                CipherWebView.h(CipherWebView.this);
            }
        });
    }

    public void respondToWeb3Call(Web3CallResponse response) {
        m.g(response, "response");
        String json = Web3CallResponse.Companion.getJsonAdapter$cipher_webview_release().toJson(response);
        evaluateJavaScript("window.CipherProvider.respond(" + ((Object) json) + ')');
    }

    public void setFileUploadUri(Uri[] uris) {
        m.g(uris, "uris");
        ValueCallback<Uri[]> valueCallback = this.fileUploadCallback;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(uris);
        }
        this.fileUploadCallback = null;
    }

    public final void setShouldOverrideUrlLoading(l<? super WebResourceRequest, Boolean> lVar) {
        m.g(lVar, "<set-?>");
        this.shouldOverrideUrlLoading = lVar;
    }

    public void stopLoading() {
        new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.coinbase.cipherwebview.c
            @Override // java.lang.Runnable
            public final void run() {
                CipherWebView.c(CipherWebView.this);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CipherWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        m.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CipherWebView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
        m.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CipherWebView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        m.g(context, "context");
        this.configuration = new CipherWebViewConfiguration("CipherWebView", Strings.zero, null, 1);
        h.c.v0.a<String> e2 = h.c.v0.a.e("");
        m.f(e2, "createDefault<String>(\"\")");
        this.titleChangeSubject = e2;
        h.c.v0.a<Double> e3 = h.c.v0.a.e(Double.valueOf(1.0d));
        m.f(e3, "createDefault<Double>(1.0)");
        this.progressChangeSubject = e3;
        h.c.v0.a<String> e4 = h.c.v0.a.e(BLANK_URL_STRING);
        m.f(e4, "createDefault<String>(CipherWebView.BLANK_URL_STRING)");
        this.urlChangeSubject = e4;
        Boolean bool = Boolean.FALSE;
        h.c.v0.a<Boolean> e5 = h.c.v0.a.e(bool);
        m.f(e5, "createDefault<Boolean>(false)");
        this.isLoadingSubject = e5;
        h.c.v0.a<Boolean> e6 = h.c.v0.a.e(bool);
        m.f(e6, "createDefault<Boolean>(false)");
        this.initialPageLoadedSubject = e6;
        h.c.v0.a<Boolean> e7 = h.c.v0.a.e(bool);
        m.f(e7, "createDefault<Boolean>(false)");
        this.canGoBackSubject = e7;
        h.c.v0.a<Boolean> e8 = h.c.v0.a.e(bool);
        m.f(e8, "createDefault<Boolean>(false)");
        this.canGoForwardSubject = e8;
        h.c.v0.b<JSAlert> d2 = h.c.v0.b.d();
        m.f(d2, "create<JSAlert>()");
        this.jsAlertSubject = d2;
        h.c.v0.b<JSConfirm> d3 = h.c.v0.b.d();
        m.f(d3, "create<JSConfirm>()");
        this.jsConfirmSubject = d3;
        h.c.v0.b<JSPrompt> d4 = h.c.v0.b.d();
        m.f(d4, "create<JSPrompt>()");
        this.jsPromptSubject = d4;
        h.c.v0.b<x> d5 = h.c.v0.b.d();
        m.f(d5, "create<Unit>()");
        this.navigationStartSubject = d5;
        h.c.v0.b<x> d6 = h.c.v0.b.d();
        m.f(d6, "create<Unit>()");
        this.navigationCommitSubject = d6;
        h.c.v0.b<x> d7 = h.c.v0.b.d();
        m.f(d7, "create<Unit>()");
        this.navigationFinishSubject = d7;
        h.c.v0.b<NavigationError> d8 = h.c.v0.b.d();
        m.f(d8, "create<NavigationError>()");
        this.navigationErrorSubject = d8;
        h.c.v0.b<NavigationHTTPError> d9 = h.c.v0.b.d();
        m.f(d9, "create<NavigationHTTPError>()");
        this.navigationHTTPErrorSubject = d9;
        h.c.v0.b<NavigationSSLError> d10 = h.c.v0.b.d();
        m.f(d10, "create<NavigationSSLError>()");
        this.navigationSSLErrorSubject = d10;
        h.c.v0.b<Exception> d11 = h.c.v0.b.d();
        m.f(d11, "create<Exception>()");
        this.requestInterceptionErrorSubject = d11;
        h.c.v0.b<AuthenticationChallenge> d12 = h.c.v0.b.d();
        m.f(d12, "create<AuthenticationChallenge>()");
        this.authenticationChallengeSubject = d12;
        h.c.v0.b<String> d13 = h.c.v0.b.d();
        m.f(d13, "create<String>()");
        this.messageSubject = d13;
        h.c.v0.a<Web3Call> d14 = h.c.v0.a.d();
        m.f(d14, "create<Web3Call>()");
        this.web3CallSubject = d14;
        h.c.v0.b<WebChromeClient.FileChooserParams> d15 = h.c.v0.b.d();
        m.f(d15, "create<WebChromeClient.FileChooserParams>()");
        this.fileUploadSubject = d15;
        this.onTitleChange = e2.hide();
        this.onProgressChange = e3.hide();
        this.onUrlChange = e4.hide();
        this.onIsLoadingChange = e5.hide();
        this.onInitialPageLoadedChange = e6.hide();
        this.onCanGoBackChange = e7.hide();
        this.onCanGoForwardChange = e8.hide();
        this.onFileUpload = d15.hide();
        this.onJSAlert = d2.hide();
        this.onJSConfirm = d3.hide();
        this.onJSPrompt = d4.hide();
        this.onNavigationStart = d5.hide();
        this.onNavigationCommit = d6.hide();
        this.onNavigationFinish = d7.hide();
        this.onNavigationError = d8.hide();
        this.onNavigationHTTPError = d9.hide();
        this.onNavigationSSLError = d10.hide();
        this.onAuthenticationChallenge = d12.hide();
        this.onMessage = d13.hide();
        this.onRequestInterceptionError = d11.hide();
        this.onWeb3Call = d14.hide();
        this.shouldOverrideUrlLoading = CipherWebView$shouldOverrideUrlLoading$1.INSTANCE;
        WebView webView = new WebView(context, attributeSet, i2, i3);
        this.webView = webView;
        setupWebView();
        addView(webView);
        String userAgentString = webView.getSettings().getUserAgentString();
        m.f(userAgentString, "webView.settings.userAgentString");
        this.defaultUserAgentString = userAgentString;
    }
}