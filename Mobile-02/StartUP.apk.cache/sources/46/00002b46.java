package com.coinbase.walletlink;

import android.net.Uri;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.ClientMetadataKey;
import com.coinbase.walletlink.models.HostRequest;
import com.coinbase.walletlink.models.HostRequestId;
import com.coinbase.walletlink.models.Session;
import h.c.b0;
import h.c.s;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.x;
import org.apache.http.cookie.ClientCookie;

/* compiled from: WalletLinkInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0083\u0001\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0 2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u001fH&¢\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0 2\u0006\u0010#\u001a\u00020\u0003H&¢\u0006\u0004\b$\u0010%J%\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0 2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\tH&¢\u0006\u0004\b(\u0010)J%\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0 2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H&¢\u0006\u0004\b.\u0010/J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0 2\u0006\u0010+\u001a\u00020*H&¢\u0006\u0004\b0\u00101J-\u00104\u001a\b\u0012\u0004\u0012\u0002030 2\u0006\u00102\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001aH&¢\u0006\u0004\b4\u00105J#\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0 2\f\u00106\u001a\b\u0012\u0004\u0012\u00020*0\u0002H&¢\u0006\u0004\b7\u00108R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u0002030\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\b¨\u0006;"}, d2 = {"Lcom/coinbase/walletlink/WalletLinkInterface;", "", "", "Lcom/coinbase/walletlink/models/Session;", "sessions", "()Ljava/util/List;", "Lh/c/s;", "observeSessions", "()Lh/c/s;", "", "userId", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/coinbase/walletlink/models/ClientMetadataKey;", SendConfirmationArgs.metadataKey, "Lkotlin/x;", "connect", "(Ljava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;)V", "disconnect", "()V", WalletLinkPushNotification.sessionIdKey, "secret", ClientCookie.VERSION_ATTR, "", "isParent", "parentSessionId", WalletLinkCompleteArgs.DAPP_NAME, "Ljava/net/URL;", "dappImageURL", "Landroid/net/Uri;", "dappURL", "url", "", "Lh/c/b0;", "link", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/net/URL;Landroid/net/Uri;Ljava/net/URL;Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", "session", "unlink", "(Lcom/coinbase/walletlink/models/Session;)Lh/c/b0;", "key", "value", "setMetadata", "(Lcom/coinbase/walletlink/models/ClientMetadataKey;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/walletlink/models/HostRequestId;", "requestId", "", "signedData", "approve", "(Lcom/coinbase/walletlink/models/HostRequestId;[B)Lh/c/b0;", "reject", "(Lcom/coinbase/walletlink/models/HostRequestId;)Lh/c/b0;", WalletLinkPushNotification.eventIdKey, "Lcom/coinbase/walletlink/models/HostRequest;", "getRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;)Lh/c/b0;", "requestIds", "markAsSeen", "(Ljava/util/List;)Lh/c/b0;", "getRequestsObservable", "requestsObservable", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface WalletLinkInterface {
    b0<x> approve(HostRequestId hostRequestId, byte[] bArr);

    void connect(String str, ConcurrentHashMap<ClientMetadataKey, String> concurrentHashMap);

    void disconnect();

    b0<HostRequest> getRequest(String str, String str2, URL url);

    s<HostRequest> getRequestsObservable();

    b0<x> link(String str, String str2, String str3, boolean z, String str4, String str5, URL url, Uri uri, URL url2, String str6, Map<ClientMetadataKey, String> map);

    b0<x> markAsSeen(List<HostRequestId> list);

    s<List<Session>> observeSessions();

    b0<x> reject(HostRequestId hostRequestId);

    List<Session> sessions();

    b0<x> setMetadata(ClientMetadataKey clientMetadataKey, String str);

    b0<x> unlink(Session session);
}