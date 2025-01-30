package com.coinbase.wallet.features.walletlink.viewmodels;

import android.net.Uri;
import androidx.lifecycle.b0;
import com.coinbase.wallet.features.settings.models.WalletLinkSettingRow;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.walletlink.models.Session;
import h.c.m0.n;
import h.c.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: WalletLinkSettingsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rR$\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/features/walletlink/viewmodels/WalletLinkSettingsViewModel;", "Landroidx/lifecycle/b0;", "Lkotlin/x;", "buildSections", "()V", "Lh/c/s;", "init", "()Lh/c/s;", "", "Lcom/coinbase/walletlink/models/Session;", "sessions", "Lh/c/b0;", "disconnect", "(Ljava/util/List;)Lh/c/b0;", "Lh/c/v0/b;", "", "kotlin.jvm.PlatformType", "refreshSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow;", "sections", "Ljava/util/List;", "getSections", "()Ljava/util/List;", "setSections", "(Ljava/util/List;)V", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "walletLinkRepository", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "refreshObservable", "Lh/c/s;", "getRefreshObservable", "<init>", "(Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkSettingsViewModel extends b0 {
    private final s<Boolean> refreshObservable;
    private final h.c.v0.b<Boolean> refreshSubject;
    private List<? extends WalletLinkSettingRow> sections;
    private final WalletLinkRepository walletLinkRepository;

    public WalletLinkSettingsViewModel(WalletLinkRepository walletLinkRepository) {
        m.g(walletLinkRepository, "walletLinkRepository");
        this.walletLinkRepository = walletLinkRepository;
        h.c.v0.b<Boolean> d2 = h.c.v0.b.d();
        m.f(d2, "create<Boolean>()");
        this.refreshSubject = d2;
        this.sections = new ArrayList();
        s<Boolean> hide = d2.hide();
        m.f(hide, "refreshSubject.hide()");
        this.refreshObservable = hide;
    }

    public static /* synthetic */ x a(WalletLinkSettingsViewModel walletLinkSettingsViewModel, List list) {
        return m1540init$lambda0(walletLinkSettingsViewModel, list);
    }

    public static /* synthetic */ x b(WalletLinkSettingsViewModel walletLinkSettingsViewModel, x xVar) {
        return m1539disconnect$lambda1(walletLinkSettingsViewModel, xVar);
    }

    private final void buildSections() {
        int r;
        List B0;
        List<? extends WalletLinkSettingRow> K0;
        String host;
        List<? extends WalletLinkSettingRow> g2;
        List<Session> sessions = this.walletLinkRepository.getSessions();
        if (sessions.isEmpty()) {
            g2 = r.g();
            this.sections = g2;
            this.refreshSubject.onNext(Boolean.FALSE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Session session : sessions) {
            if (session.getVersion() == null) {
                arrayList.add(session);
            } else {
                Uri dappURL = session.getDappURL();
                if (dappURL != null && (host = dappURL.getHost()) != null) {
                    List list = (List) linkedHashMap.get(host);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(session);
                    linkedHashMap.put(host, list);
                }
            }
        }
        Collection<List> values = linkedHashMap.values();
        r = kotlin.a0.s.r(values, 10);
        ArrayList arrayList2 = new ArrayList(r);
        for (List list2 : values) {
            arrayList2.add(new WalletLinkSettingRow.DApp(list2));
        }
        B0 = z.B0(arrayList2, new Comparator<T>() { // from class: com.coinbase.wallet.features.walletlink.viewmodels.WalletLinkSettingsViewModel$buildSections$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int c2;
                c2 = kotlin.b0.b.c(((WalletLinkSettingRow.DApp) t).getDappName(), ((WalletLinkSettingRow.DApp) t2).getDappName());
                return c2;
            }
        });
        K0 = z.K0(B0);
        if (!arrayList.isEmpty()) {
            K0.add(0, new WalletLinkSettingRow.WalletLinkV1(arrayList));
        }
        K0.add(0, new WalletLinkSettingRow.AllSessions(sessions.size()));
        x xVar = x.a;
        this.sections = K0;
        this.refreshSubject.onNext(Boolean.valueOf(!K0.isEmpty()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ h.c.b0 disconnect$default(WalletLinkSettingsViewModel walletLinkSettingsViewModel, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = null;
        }
        return walletLinkSettingsViewModel.disconnect(list);
    }

    /* renamed from: disconnect$lambda-1 */
    public static final x m1539disconnect$lambda1(WalletLinkSettingsViewModel this$0, x it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        this$0.buildSections();
        return x.a;
    }

    /* renamed from: init$lambda-0 */
    public static final x m1540init$lambda0(WalletLinkSettingsViewModel this$0, List it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        this$0.buildSections();
        return x.a;
    }

    public final h.c.b0<x> disconnect(List<Session> list) {
        h.c.b0<x> disconnect;
        if (list != null) {
            disconnect = this.walletLinkRepository.disconnect(list);
        } else {
            disconnect = this.walletLinkRepository.disconnect();
        }
        h.c.b0 map = disconnect.observeOn(h.c.j0.c.a.b()).map(new n() { // from class: com.coinbase.wallet.features.walletlink.viewmodels.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkSettingsViewModel.b(WalletLinkSettingsViewModel.this, (x) obj);
            }
        });
        m.f(map, "disconnectSessions\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { buildSections() }");
        return map;
    }

    public final s<Boolean> getRefreshObservable() {
        return this.refreshObservable;
    }

    public final List<WalletLinkSettingRow> getSections() {
        return this.sections;
    }

    public final s<x> init() {
        s map = this.walletLinkRepository.getSessionsObservable().observeOn(h.c.j0.c.a.b()).map(new n() { // from class: com.coinbase.wallet.features.walletlink.viewmodels.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkSettingsViewModel.a(WalletLinkSettingsViewModel.this, (List) obj);
            }
        });
        m.f(map, "walletLinkRepository.sessionsObservable\n        .observeOn(AndroidSchedulers.mainThread())\n        .map { buildSections() }");
        return map;
    }

    public final void setSections(List<? extends WalletLinkSettingRow> list) {
        m.g(list, "<set-?>");
        this.sections = list;
    }
}