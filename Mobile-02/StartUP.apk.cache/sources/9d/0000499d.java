package e.j.i;

import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.squareup.moshi.Moshi;
import java.text.SimpleDateFormat;
import javax.inject.Provider;

/* compiled from: MnemonicBackupRepository_Factory.java */
/* loaded from: classes2.dex */
public final class b2 implements f.c.d<a2> {
    private final Provider<e.j.j.b> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.j.l.o.a> f13611b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SimpleDateFormat> f13612c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Moshi> f13613d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<StoreInterface> f13614e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<BuildConfigWrapper> f13615f;

    public b2(Provider<e.j.j.b> provider, Provider<e.j.l.o.a> provider2, Provider<SimpleDateFormat> provider3, Provider<Moshi> provider4, Provider<StoreInterface> provider5, Provider<BuildConfigWrapper> provider6) {
        this.a = provider;
        this.f13611b = provider2;
        this.f13612c = provider3;
        this.f13613d = provider4;
        this.f13614e = provider5;
        this.f13615f = provider6;
    }

    public static b2 a(Provider<e.j.j.b> provider, Provider<e.j.l.o.a> provider2, Provider<SimpleDateFormat> provider3, Provider<Moshi> provider4, Provider<StoreInterface> provider5, Provider<BuildConfigWrapper> provider6) {
        return new b2(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static a2 c(e.j.j.b bVar, e.j.l.o.a aVar, SimpleDateFormat simpleDateFormat, Moshi moshi, StoreInterface storeInterface, BuildConfigWrapper buildConfigWrapper) {
        return new a2(bVar, aVar, simpleDateFormat, moshi, storeInterface, buildConfigWrapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public a2 get() {
        return c(this.a.get(), this.f13611b.get(), this.f13612c.get(), this.f13613d.get(), this.f13614e.get(), this.f13615f.get());
    }
}