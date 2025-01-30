package com.coinbase.walletlink.daos;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.walletlink.extensions.StoreKeys_WalletLinkKt;
import com.coinbase.walletlink.models.Session;
import h.c.s;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.a0.n;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import org.apache.http.cookie.ClientCookie;

/* compiled from: SessionDAO.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b,\u0010-J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJg\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020!¢\u0006\u0004\b\"\u0010#J!\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020!2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0019\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005¨\u0006."}, d2 = {"Lcom/coinbase/walletlink/daos/SessionDAO;", "", "", "Lcom/coinbase/walletlink/models/Session;", "getStoredSessions", "()Ljava/util/List;", "Ljava/net/URL;", "url", "getSessions", "(Ljava/net/URL;)Ljava/util/List;", "", "id", "getSession", "(Ljava/lang/String;Ljava/net/URL;)Lcom/coinbase/walletlink/models/Session;", WalletLinkPushNotification.sessionIdKey, "secret", ClientCookie.VERSION_ATTR, "", "isParent", "isApproved", "parentSessionId", WalletLinkCompleteArgs.DAPP_NAME, "dappImageURL", "Landroid/net/Uri;", "dappURL", "Lkotlin/x;", "save", "(Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/net/URL;Landroid/net/Uri;)V", "session", "update", "(Lcom/coinbase/walletlink/models/Session;)V", "delete", "(Ljava/net/URL;Ljava/lang/String;)V", "Lh/c/s;", "observeSessions", "()Lh/c/s;", "(Ljava/net/URL;)Lh/c/s;", "Ljava/util/concurrent/locks/ReentrantLock;", "accessLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "sessions", "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SessionDAO {
    private final ReentrantLock accessLock;
    private final StoreInterface store;

    public SessionDAO(StoreInterface store) {
        m.g(store, "store");
        this.store = store;
        this.accessLock = new ReentrantLock();
    }

    public static /* synthetic */ List a(Optional optional) {
        return m2182observeSessions$lambda9(optional);
    }

    public static /* synthetic */ List b(URL url, Optional optional) {
        return m2181observeSessions$lambda12(url, optional);
    }

    private final List<Session> getStoredSessions() {
        List<Session> B0;
        ReentrantLock reentrantLock = this.accessLock;
        reentrantLock.lock();
        try {
            Session[] sessionArr = (Session[]) this.store.get(StoreKeys_WalletLinkKt.getSessions(StoreKeys.INSTANCE));
            List e0 = sessionArr == null ? null : n.e0(sessionArr);
            if (e0 == null) {
                e0 = r.g();
            }
            reentrantLock.unlock();
            B0 = z.B0(e0, new Comparator<T>() { // from class: com.coinbase.walletlink.daos.SessionDAO$getStoredSessions$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int c2;
                    c2 = kotlin.b0.b.c(((Session) t).getId(), ((Session) t2).getId());
                    return c2;
                }
            });
            return B0;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* renamed from: observeSessions$lambda-12 */
    public static final List m2181observeSessions$lambda12(URL url, Optional list) {
        List B0;
        List g2;
        m.g(url, "$url");
        m.g(list, "list");
        Session[] sessionArr = (Session[]) list.toNullable();
        if (sessionArr == null) {
            B0 = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Session session : sessionArr) {
                if (m.c(session.getUrl(), url)) {
                    arrayList.add(session);
                }
            }
            B0 = z.B0(arrayList, new Comparator<T>() { // from class: com.coinbase.walletlink.daos.SessionDAO$observeSessions$lambda-12$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int c2;
                    c2 = kotlin.b0.b.c(((Session) t).getId(), ((Session) t2).getId());
                    return c2;
                }
            });
        }
        if (B0 == null) {
            g2 = r.g();
            return g2;
        }
        return B0;
    }

    /* renamed from: observeSessions$lambda-9 */
    public static final List m2182observeSessions$lambda9(Optional it) {
        List g2;
        m.g(it, "it");
        Session[] sessionArr = (Session[]) it.toNullable();
        List e0 = sessionArr == null ? null : n.e0(sessionArr);
        if (e0 == null) {
            g2 = r.g();
            return g2;
        }
        return e0;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0047 A[Catch: all -> 0x0072, TryCatch #0 {all -> 0x0072, blocks: (B:35:0x000f, B:37:0x0020, B:38:0x0022, B:40:0x002b, B:42:0x0037, B:48:0x0047, B:49:0x004a, B:50:0x004d, B:52:0x0061, B:55:0x006a, B:56:0x0071), top: B:60:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void delete(java.net.URL r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.m.g(r9, r0)
            java.lang.String r0 = "sessionId"
            kotlin.jvm.internal.m.g(r10, r0)
            java.util.concurrent.locks.ReentrantLock r0 = r8.accessLock
            r0.lock()
            com.coinbase.wallet.store.interfaces.StoreInterface r1 = r8.store     // Catch: java.lang.Throwable -> L72
            com.coinbase.wallet.store.models.StoreKeys r2 = com.coinbase.wallet.store.models.StoreKeys.INSTANCE     // Catch: java.lang.Throwable -> L72
            com.coinbase.wallet.store.models.EncryptedSharedPrefsStoreKey r2 = com.coinbase.walletlink.extensions.StoreKeys_WalletLinkKt.getSessions(r2)     // Catch: java.lang.Throwable -> L72
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L72
            com.coinbase.walletlink.models.Session[] r1 = (com.coinbase.walletlink.models.Session[]) r1     // Catch: java.lang.Throwable -> L72
            r2 = 0
            if (r1 != 0) goto L22
            com.coinbase.walletlink.models.Session[] r1 = new com.coinbase.walletlink.models.Session[r2]     // Catch: java.lang.Throwable -> L72
        L22:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L72
            r3.<init>()     // Catch: java.lang.Throwable -> L72
            int r4 = r1.length     // Catch: java.lang.Throwable -> L72
            r5 = r2
        L29:
            if (r5 >= r4) goto L4d
            r6 = r1[r5]     // Catch: java.lang.Throwable -> L72
            java.lang.String r7 = r6.getId()     // Catch: java.lang.Throwable -> L72
            boolean r7 = kotlin.jvm.internal.m.c(r7, r10)     // Catch: java.lang.Throwable -> L72
            if (r7 == 0) goto L44
            java.net.URL r7 = r6.getUrl()     // Catch: java.lang.Throwable -> L72
            boolean r7 = kotlin.jvm.internal.m.c(r7, r9)     // Catch: java.lang.Throwable -> L72
            if (r7 != 0) goto L42
            goto L44
        L42:
            r7 = r2
            goto L45
        L44:
            r7 = 1
        L45:
            if (r7 == 0) goto L4a
            r3.add(r6)     // Catch: java.lang.Throwable -> L72
        L4a:
            int r5 = r5 + 1
            goto L29
        L4d:
            java.util.List r9 = kotlin.a0.p.K0(r3)     // Catch: java.lang.Throwable -> L72
            com.coinbase.wallet.store.interfaces.StoreInterface r10 = r8.store     // Catch: java.lang.Throwable -> L72
            com.coinbase.wallet.store.models.StoreKeys r1 = com.coinbase.wallet.store.models.StoreKeys.INSTANCE     // Catch: java.lang.Throwable -> L72
            com.coinbase.wallet.store.models.EncryptedSharedPrefsStoreKey r1 = com.coinbase.walletlink.extensions.StoreKeys_WalletLinkKt.getSessions(r1)     // Catch: java.lang.Throwable -> L72
            com.coinbase.walletlink.models.Session[] r2 = new com.coinbase.walletlink.models.Session[r2]     // Catch: java.lang.Throwable -> L72
            java.lang.Object[] r9 = r9.toArray(r2)     // Catch: java.lang.Throwable -> L72
            if (r9 == 0) goto L6a
            r10.set(r1, r9)     // Catch: java.lang.Throwable -> L72
            kotlin.x r9 = kotlin.x.a     // Catch: java.lang.Throwable -> L72
            r0.unlock()
            return
        L6a:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L72
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.Array<T>"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L72
            throw r9     // Catch: java.lang.Throwable -> L72
        L72:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.walletlink.daos.SessionDAO.delete(java.net.URL, java.lang.String):void");
    }

    public final Session getSession(String id, URL url) {
        Object obj;
        boolean z;
        m.g(id, "id");
        m.g(url, "url");
        Iterator<T> it = getStoredSessions().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Session session = (Session) obj;
            if (m.c(session.getUrl(), url) && m.c(session.getId(), id)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return (Session) obj;
    }

    public final List<Session> getSessions() {
        return getStoredSessions();
    }

    public final s<List<Session>> observeSessions() {
        s<List<Session>> distinctUntilChanged = this.store.observe(StoreKeys_WalletLinkKt.getSessions(StoreKeys.INSTANCE)).map(new h.c.m0.n() { // from class: com.coinbase.walletlink.daos.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SessionDAO.a((Optional) obj);
            }
        }).distinctUntilChanged();
        m.f(distinctUntilChanged, "store.observe(StoreKeys.sessions)\n        .map { it.toNullable()?.toList() ?: emptyList() }\n        .distinctUntilChanged()");
        return distinctUntilChanged;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0053, code lost:
        r5.add(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void save(java.net.URL r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, boolean r23, boolean r24, java.lang.String r25, java.lang.String r26, java.net.URL r27, android.net.Uri r28) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.walletlink.daos.SessionDAO.save(java.net.URL, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, java.lang.String, java.net.URL, android.net.Uri):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x004a A[Catch: all -> 0x0078, TryCatch #0 {all -> 0x0078, blocks: (B:35:0x000a, B:37:0x001b, B:38:0x001d, B:40:0x0026, B:42:0x0036, B:48:0x004a, B:49:0x004d, B:50:0x0050, B:52:0x0067, B:55:0x0070, B:56:0x0077), top: B:60:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void update(com.coinbase.walletlink.models.Session r10) {
        /*
            r9 = this;
            java.lang.String r0 = "session"
            kotlin.jvm.internal.m.g(r10, r0)
            java.util.concurrent.locks.ReentrantLock r0 = r9.accessLock
            r0.lock()
            com.coinbase.wallet.store.interfaces.StoreInterface r1 = r9.store     // Catch: java.lang.Throwable -> L78
            com.coinbase.wallet.store.models.StoreKeys r2 = com.coinbase.wallet.store.models.StoreKeys.INSTANCE     // Catch: java.lang.Throwable -> L78
            com.coinbase.wallet.store.models.EncryptedSharedPrefsStoreKey r2 = com.coinbase.walletlink.extensions.StoreKeys_WalletLinkKt.getSessions(r2)     // Catch: java.lang.Throwable -> L78
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L78
            com.coinbase.walletlink.models.Session[] r1 = (com.coinbase.walletlink.models.Session[]) r1     // Catch: java.lang.Throwable -> L78
            r2 = 0
            if (r1 != 0) goto L1d
            com.coinbase.walletlink.models.Session[] r1 = new com.coinbase.walletlink.models.Session[r2]     // Catch: java.lang.Throwable -> L78
        L1d:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L78
            r3.<init>()     // Catch: java.lang.Throwable -> L78
            int r4 = r1.length     // Catch: java.lang.Throwable -> L78
            r5 = r2
        L24:
            if (r5 >= r4) goto L50
            r6 = r1[r5]     // Catch: java.lang.Throwable -> L78
            java.lang.String r7 = r6.getId()     // Catch: java.lang.Throwable -> L78
            java.lang.String r8 = r10.getId()     // Catch: java.lang.Throwable -> L78
            boolean r7 = kotlin.jvm.internal.m.c(r7, r8)     // Catch: java.lang.Throwable -> L78
            if (r7 == 0) goto L47
            java.net.URL r7 = r6.getUrl()     // Catch: java.lang.Throwable -> L78
            java.net.URL r8 = r10.getUrl()     // Catch: java.lang.Throwable -> L78
            boolean r7 = kotlin.jvm.internal.m.c(r7, r8)     // Catch: java.lang.Throwable -> L78
            if (r7 != 0) goto L45
            goto L47
        L45:
            r7 = r2
            goto L48
        L47:
            r7 = 1
        L48:
            if (r7 == 0) goto L4d
            r3.add(r6)     // Catch: java.lang.Throwable -> L78
        L4d:
            int r5 = r5 + 1
            goto L24
        L50:
            java.util.List r1 = kotlin.a0.p.K0(r3)     // Catch: java.lang.Throwable -> L78
            r1.add(r10)     // Catch: java.lang.Throwable -> L78
            com.coinbase.wallet.store.interfaces.StoreInterface r10 = r9.store     // Catch: java.lang.Throwable -> L78
            com.coinbase.wallet.store.models.StoreKeys r3 = com.coinbase.wallet.store.models.StoreKeys.INSTANCE     // Catch: java.lang.Throwable -> L78
            com.coinbase.wallet.store.models.EncryptedSharedPrefsStoreKey r3 = com.coinbase.walletlink.extensions.StoreKeys_WalletLinkKt.getSessions(r3)     // Catch: java.lang.Throwable -> L78
            com.coinbase.walletlink.models.Session[] r2 = new com.coinbase.walletlink.models.Session[r2]     // Catch: java.lang.Throwable -> L78
            java.lang.Object[] r1 = r1.toArray(r2)     // Catch: java.lang.Throwable -> L78
            if (r1 == 0) goto L70
            r10.set(r3, r1)     // Catch: java.lang.Throwable -> L78
            kotlin.x r10 = kotlin.x.a     // Catch: java.lang.Throwable -> L78
            r0.unlock()
            return
        L70:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L78
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
            r10.<init>(r1)     // Catch: java.lang.Throwable -> L78
            throw r10     // Catch: java.lang.Throwable -> L78
        L78:
            r10 = move-exception
            r0.unlock()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.walletlink.daos.SessionDAO.update(com.coinbase.walletlink.models.Session):void");
    }

    public final List<Session> getSessions(URL url) {
        m.g(url, "url");
        List<Session> storedSessions = getStoredSessions();
        ArrayList arrayList = new ArrayList();
        for (Object obj : storedSessions) {
            if (m.c(((Session) obj).getUrl(), url)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final s<List<Session>> observeSessions(final URL url) {
        m.g(url, "url");
        s<List<Session>> distinctUntilChanged = this.store.observe(StoreKeys_WalletLinkKt.getSessions(StoreKeys.INSTANCE)).map(new h.c.m0.n() { // from class: com.coinbase.walletlink.daos.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SessionDAO.b(url, (Optional) obj);
            }
        }).distinctUntilChanged();
        m.f(distinctUntilChanged, "store.observe(StoreKeys.sessions)\n        .map { list -> list.toNullable()?.filter { it.url == url }?.sortedBy { it.id } ?: emptyList() }\n        .distinctUntilChanged()");
        return distinctUntilChanged;
    }
}