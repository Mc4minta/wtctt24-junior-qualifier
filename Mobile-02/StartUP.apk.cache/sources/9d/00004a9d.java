package e.j.n;

import android.os.Bundle;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.features.cloudbackup.models.BackupStatus;
import com.coinbase.wallet.features.cloudbackup.prompts.CloudBackupPrompt;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import com.google.api.services.drive.Drive;
import java.util.List;

/* compiled from: SettingsViewModel.kt */
/* loaded from: classes2.dex */
public final class b3 extends androidx.lifecycle.b0 {
    private final e.j.i.i2.d a;

    /* renamed from: b */
    private final CloudBackupPrompt f13804b;

    /* renamed from: c */
    private final h.c.s<Integer> f13805c;

    /* renamed from: d */
    private final h.c.s<FiatCurrency> f13806d;

    /* renamed from: e */
    private final h.c.s<Optional<User>> f13807e;

    /* renamed from: f */
    private final h.c.s<BackupStatus> f13808f;

    /* renamed from: g */
    private final h.c.s<EthereumChain> f13809g;

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements h.c.m0.p {
        public static final a<T> a = new a<>();

        @Override // h.c.m0.p
        /* renamed from: a */
        public final boolean test(Optional<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toNullable() != null;
        }
    }

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class b<T, R> implements h.c.m0.n {
        public static final b<T, R> a = new b<>();

        @Override // h.c.m0.n
        /* renamed from: a */
        public final T apply(Optional<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toNullable();
        }
    }

    public b3(UserRepository userRepository, e.j.i.i2.d mnemonicBackupRepository, WalletLinkRepository walletLinkRepository, IFiatCurrencyRepository fiatCurrencyRepository, CloudBackupPrompt cloudBackupPrompt, IWalletRepository walletRepository) {
        kotlin.jvm.internal.m.g(userRepository, "userRepository");
        kotlin.jvm.internal.m.g(mnemonicBackupRepository, "mnemonicBackupRepository");
        kotlin.jvm.internal.m.g(walletLinkRepository, "walletLinkRepository");
        kotlin.jvm.internal.m.g(fiatCurrencyRepository, "fiatCurrencyRepository");
        kotlin.jvm.internal.m.g(cloudBackupPrompt, "cloudBackupPrompt");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.a = mnemonicBackupRepository;
        this.f13804b = cloudBackupPrompt;
        h.c.s map = walletLinkRepository.getSessionsObservable().map(new h.c.m0.n() { // from class: e.j.n.f1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return b3.f((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletLinkRepository.sessionsObservable.map { it.size }");
        this.f13805c = map;
        this.f13806d = fiatCurrencyRepository.getActiveCurrencyObservable();
        this.f13807e = userRepository.getActiveUserObservable();
        h.c.s map2 = mnemonicBackupRepository.f().filter(a.a).map(b.a);
        kotlin.jvm.internal.m.f(map2, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        this.f13808f = map2;
        h.c.s map3 = walletRepository.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)).distinctUntilChanged().map(new h.c.m0.n() { // from class: e.j.n.g1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return b3.g((Network) obj);
            }
        });
        kotlin.jvm.internal.m.f(map3, "walletRepository.observeNetwork(Blockchain.ETHEREUM)\n        .distinctUntilChanged()\n        .map { it.asEthereumChain }");
        this.f13809g = map3;
    }

    public static final EthereumChain a(Network it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Network_EthereumKt.getAsEthereumChain(it);
    }

    public static /* synthetic */ Integer f(List list) {
        return h(list);
    }

    public static /* synthetic */ EthereumChain g(Network network) {
        return a(network);
    }

    public static final Integer h(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Integer.valueOf(it.size());
    }

    public final h.c.s<FiatCurrency> b() {
        return this.f13806d;
    }

    public final h.c.b0<Boolean> backupIfNeeded(Bundle args, kotlin.e0.c.a<kotlin.x> onPromptDismiss) {
        kotlin.jvm.internal.m.g(args, "args");
        kotlin.jvm.internal.m.g(onPromptDismiss, "onPromptDismiss");
        return CloudBackupPrompt.backupIfNeeded$default(this.f13804b, args, onPromptDismiss, null, 4, null);
    }

    public final h.c.s<EthereumChain> c() {
        return this.f13809g;
    }

    public final h.c.s<Optional<User>> d() {
        return this.f13807e;
    }

    public final h.c.s<Integer> e() {
        return this.f13805c;
    }

    public final h.c.s<BackupStatus> getBackupStatus() {
        return this.f13808f;
    }

    public final void setupGoogleDriveClient(Drive driveClient) {
        kotlin.jvm.internal.m.g(driveClient, "driveClient");
        this.a.e(driveClient);
    }
}