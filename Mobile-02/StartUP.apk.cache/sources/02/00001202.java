package com.coinbase.wallet.application.repository;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.application.extensions.StoreKeys_ApplicationKt;
import com.coinbase.wallet.application.model.BiometricsProtectionType;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.authentication.AppLockType;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.toshi.exception.DeviceNotSecureException;
import com.toshi.model.local.authentication.AuthenticationMethod;
import e.j.d.g.w;
import h.c.b0;
import h.c.m0.n;
import h.c.m0.p;
import h.c.s;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: AppLockRepository.kt */
@AppCoreScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b=\u0010>J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0012J%\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u000e\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R(\u0010&\u001a\u0004\u0018\u00010\u00102\b\u0010!\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\u000bR\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070,8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R$\u00105\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\u000bR\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/coinbase/wallet/application/repository/AppLockRepository;", "Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "Lcom/coinbase/wallet/authentication/AppLockType;", "type", "", "getActiveMnemonic", "(Lcom/coinbase/wallet/authentication/AppLockType;)Ljava/lang/String;", "", "isLocked", "Lkotlin/x;", "setIsAppLocked", "(Z)V", "currentPin", "Le/j/d/a;", "permit", "Lh/c/b0;", "Lcom/toshi/model/local/authentication/AuthenticationMethod;", "switchAuthenticationMethodToBiometric", "(Ljava/lang/String;Le/j/d/a;)Lh/c/b0;", "oldPin", "newPin", "switchAuthenticationPin", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "switchAuthenticationMethodToPin", "decryptionPermit", "encryptionPermit", "changeBiometricPermit", "(Le/j/d/a;Le/j/d/a;)Lh/c/b0;", "Le/j/d/c;", "isValidPermit", "(Le/j/d/c;)Lh/c/b0;", "isBiometricProtectionEnabled", "()Z", "value", "getAuthenticationMethod", "()Lcom/toshi/model/local/authentication/AuthenticationMethod;", "setAuthenticationMethod", "(Lcom/toshi/model/local/authentication/AuthenticationMethod;)V", "authenticationMethod", "isUnlockRequiredOnAppFocus", "setUnlockRequiredOnAppFocus", "Le/j/j/e;", "lockPrefs", "Le/j/j/e;", "Lh/c/s;", "isAppLockedObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "mnemonicRepository", "Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "isTxAuthRequired", "setTxAuthRequired", "Le/j/d/g/w;", "masterSeedHandler", "Le/j/d/g/w;", "Le/j/g/a;", "keyguardManager", "Le/j/g/a;", "<init>", "(Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;Le/j/j/e;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Le/j/d/g/w;Le/j/g/a;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppLockRepository implements AppLockRepositoryInterface {
    private final e.j.g.a keyguardManager;
    private final e.j.j.e lockPrefs;
    private final w masterSeedHandler;
    private final MnemonicRepositoryInterface mnemonicRepository;
    private final StoreInterface store;

    /* compiled from: AppLockRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BiometricsProtectionType.values().length];
            iArr[BiometricsProtectionType.currentBiometrics.ordinal()] = 1;
            iArr[BiometricsProtectionType.legacy.ordinal()] = 2;
            iArr[BiometricsProtectionType.anyBiometrics.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AppLockRepository(MnemonicRepositoryInterface mnemonicRepository, e.j.j.e lockPrefs, StoreInterface store, w masterSeedHandler, e.j.g.a keyguardManager) {
        m.g(mnemonicRepository, "mnemonicRepository");
        m.g(lockPrefs, "lockPrefs");
        m.g(store, "store");
        m.g(masterSeedHandler, "masterSeedHandler");
        m.g(keyguardManager, "keyguardManager");
        this.mnemonicRepository = mnemonicRepository;
        this.lockPrefs = lockPrefs;
        this.store = store;
        this.masterSeedHandler = masterSeedHandler;
        this.keyguardManager = keyguardManager;
    }

    /* renamed from: _get_isAppLockedObservable_$lambda-0 */
    public static final Boolean m653_get_isAppLockedObservable_$lambda0(Boolean it) {
        m.g(it, "it");
        return Boolean.valueOf(!it.booleanValue());
    }

    public static /* synthetic */ Boolean a(Boolean bool) {
        return m653_get_isAppLockedObservable_$lambda0(bool);
    }

    public static /* synthetic */ Boolean b(String str) {
        return m654isValidPermit$lambda1(str);
    }

    public static /* synthetic */ Boolean c(Throwable th) {
        return m655isValidPermit$lambda2(th);
    }

    /* renamed from: isValidPermit$lambda-1 */
    public static final Boolean m654isValidPermit$lambda1(String it) {
        m.g(it, "it");
        return Boolean.TRUE;
    }

    /* renamed from: isValidPermit$lambda-2 */
    public static final Boolean m655isValidPermit$lambda2(Throwable it) {
        m.g(it, "it");
        return Boolean.FALSE;
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public b0<x> changeBiometricPermit(e.j.d.a decryptionPermit, e.j.d.a encryptionPermit) {
        m.g(decryptionPermit, "decryptionPermit");
        m.g(encryptionPermit, "encryptionPermit");
        return this.masterSeedHandler.changeBiometricPermit(decryptionPermit, encryptionPermit);
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public String getActiveMnemonic(AppLockType type) {
        boolean z;
        m.g(type, "type");
        if (type instanceof AppLockType.AppAccess) {
            z = isUnlockRequiredOnAppFocus();
        } else if (type instanceof AppLockType.Transactions) {
            z = isTxAuthRequired();
        } else if (type instanceof AppLockType.UnlockIfNeeded) {
            z = false;
        } else if (!(type instanceof AppLockType.RequireAuthentication)) {
            throw new NoWhenBranchMatchedException();
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        return this.mnemonicRepository.getActiveMnemonic();
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public AuthenticationMethod getAuthenticationMethod() {
        return this.lockPrefs.getAuthenticationMethod();
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public s<Boolean> isAppLockedObservable() {
        s map = this.store.observe(StoreKeys_ApplicationKt.isAppUnlocked(StoreKeys.INSTANCE)).filter(new p() { // from class: com.coinbase.wallet.application.repository.AppLockRepository$special$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new n() { // from class: com.coinbase.wallet.application.repository.AppLockRepository$special$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        s<Boolean> map2 = map.map(new n() { // from class: com.coinbase.wallet.application.repository.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AppLockRepository.a((Boolean) obj);
            }
        });
        m.f(map2, "store.observe(StoreKeys.isAppUnlocked).unwrap().map { !it }");
        return map2;
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public boolean isBiometricProtectionEnabled() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.mnemonicRepository.getBiometricsProtectionType().ordinal()];
        if (i2 == 1 || i2 == 2) {
            return true;
        }
        if (i2 == 3) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public boolean isTxAuthRequired() {
        return this.lockPrefs.isTxAuthRequired();
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public boolean isUnlockRequiredOnAppFocus() {
        return this.lockPrefs.b();
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public b0<Boolean> isValidPermit(e.j.d.c permit) {
        m.g(permit, "permit");
        if (!(permit instanceof e.j.d.a) || this.keyguardManager.a()) {
            b0<Boolean> onErrorReturn = this.masterSeedHandler.f(permit).map(new n() { // from class: com.coinbase.wallet.application.repository.b
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return AppLockRepository.b((String) obj);
                }
            }).onErrorReturn(new n() { // from class: com.coinbase.wallet.application.repository.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return AppLockRepository.c((Throwable) obj);
                }
            });
            m.f(onErrorReturn, "masterSeedHandler.readMasterSeed(permit)\n            .map { true }\n            .onErrorReturn { false }");
            return onErrorReturn;
        }
        throw new DeviceNotSecureException();
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public void setAuthenticationMethod(AuthenticationMethod authenticationMethod) {
        this.lockPrefs.setAuthenticationMethod(authenticationMethod);
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public void setIsAppLocked(boolean z) {
        this.store.set(StoreKeys_ApplicationKt.isAppUnlocked(StoreKeys.INSTANCE), Boolean.valueOf(!z));
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public void setTxAuthRequired(boolean z) {
        this.lockPrefs.setTxAuthRequired(z);
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public void setUnlockRequiredOnAppFocus(boolean z) {
        this.lockPrefs.a(z);
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public b0<AuthenticationMethod> switchAuthenticationMethodToBiometric(String currentPin, e.j.d.a permit) {
        m.g(currentPin, "currentPin");
        m.g(permit, "permit");
        return this.masterSeedHandler.switchAuthenticationMethodToBiometric(currentPin, permit);
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public b0<AuthenticationMethod> switchAuthenticationMethodToPin(String newPin, e.j.d.a permit) {
        m.g(newPin, "newPin");
        m.g(permit, "permit");
        return this.masterSeedHandler.switchAuthenticationMethodToPin(newPin, permit);
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface
    public b0<AuthenticationMethod> switchAuthenticationPin(String oldPin, String newPin) {
        m.g(oldPin, "oldPin");
        m.g(newPin, "newPin");
        return this.masterSeedHandler.e(oldPin, newPin);
    }
}