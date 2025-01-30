package e.j.n;

import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.cloudbackup.prompts.CloudBackupPrompt;
import com.coinbase.wallet.user.repositories.UserRepository;
import javax.inject.Provider;

/* compiled from: DisplayCoinAddressViewModel_Factory.java */
/* loaded from: classes2.dex */
public final class k2 implements f.c.d<j2> {
    private final Provider<UserRepository> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FeatureFlagsRepository> f13882b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CloudBackupPrompt> f13883c;

    public k2(Provider<UserRepository> provider, Provider<FeatureFlagsRepository> provider2, Provider<CloudBackupPrompt> provider3) {
        this.a = provider;
        this.f13882b = provider2;
        this.f13883c = provider3;
    }

    public static k2 a(Provider<UserRepository> provider, Provider<FeatureFlagsRepository> provider2, Provider<CloudBackupPrompt> provider3) {
        return new k2(provider, provider2, provider3);
    }

    public static j2 c(UserRepository userRepository, FeatureFlagsRepository featureFlagsRepository, CloudBackupPrompt cloudBackupPrompt) {
        return new j2(userRepository, featureFlagsRepository, cloudBackupPrompt);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public j2 get() {
        return c(this.a.get(), this.f13882b.get(), this.f13883c.get());
    }
}