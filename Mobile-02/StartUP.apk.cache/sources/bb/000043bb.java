package com.toshi.view.fragment.toplevel;

import android.net.Uri;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.routing.models.RouteAction;
import com.coinbase.wallet.routing.models.RouteScheme;
import com.coinbase.wallet.routing.repositories.DeepLinkRepository;
import com.squareup.moshi.Moshi;
import e.j.n.h2;
import java.util.Map;
import okhttp3.OkHttpClient;

/* compiled from: DappsFragment_MembersInjector.java */
/* loaded from: classes2.dex */
public final class d0 implements f.b<DappsFragment> {
    public static void a(DappsFragment dappsFragment, AuthenticationHelper authenticationHelper) {
        dappsFragment.q = authenticationHelper;
    }

    public static void b(DappsFragment dappsFragment, e.j.l.o.a aVar) {
        dappsFragment.u = aVar;
    }

    public static void c(DappsFragment dappsFragment, DeepLinkRepository deepLinkRepository) {
        dappsFragment.x = deepLinkRepository;
    }

    public static void d(DappsFragment dappsFragment, Moshi moshi) {
        dappsFragment.t = moshi;
    }

    public static void e(DappsFragment dappsFragment, OkHttpClient okHttpClient) {
        dappsFragment.v = okHttpClient;
    }

    public static void f(DappsFragment dappsFragment, Map<RouteScheme, kotlin.e0.c.l<Uri, RouteAction>> map) {
        dappsFragment.w = map;
    }

    public static void g(DappsFragment dappsFragment, GenericViewModelFactory<h2> genericViewModelFactory) {
        dappsFragment.p = genericViewModelFactory;
    }
}