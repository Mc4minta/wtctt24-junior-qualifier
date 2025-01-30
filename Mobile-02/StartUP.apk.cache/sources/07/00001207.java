package com.coinbase.wallet.application.repository;

import com.adobe.xmp.XMPMetaData;
import com.coinbase.ciphercore.CipherCoreBridgeException;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.application.model.BiometricsProtectionType;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.toshi.exception.InvalidMasterSeedException;
import h.c.a0;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.m;

/* compiled from: MnemonicRepository.kt */
@AppCoreScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b.\u0010/J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J3\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00022\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u0010j\u0002`\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\rJ\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0007R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/coinbase/wallet/application/repository/MnemonicRepository;", "Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "", "getActiveMnemonic", "()Ljava/lang/String;", "Lh/c/b0;", "createMnemonic", "()Lh/c/b0;", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "validateMnemonic", "(Ljava/lang/String;)Lh/c/b0;", "Lkotlin/x;", "clearActiveMnemonic", "()V", "", "hasStoredMnemonic", "Lkotlin/Function1;", "Lcom/toshi/crypto/keyhandler/DecryptRequest;", "decryptRequest", "getMnemonicFromStorage", "(Lkotlin/e0/c/l;)Lh/c/b0;", "decryptedMnemonic", "Lcom/toshi/crypto/keyhandler/EncryptRequest;", "encryptRequest", "saveMnemonicToStorage", "(Ljava/lang/String;Lkotlin/e0/c/l;)Lh/c/b0;", "deleteMnemonic", "getEncryptedMnemonic", "activeMnemonic", "Ljava/lang/String;", "Lcom/coinbase/wallet/application/model/BiometricsProtectionType;", "value", "getBiometricsProtectionType", "()Lcom/coinbase/wallet/application/model/BiometricsProtectionType;", "setBiometricsProtectionType", "(Lcom/coinbase/wallet/application/model/BiometricsProtectionType;)V", "biometricsProtectionType", "Le/j/j/h;", "mnemonicPrefs", "Le/j/j/h;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "Lh/c/a0;", "concurrentScheduler", "Lh/c/a0;", "<init>", "(Le/j/j/h;Lcom/coinbase/ciphercore/CipherCoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MnemonicRepository implements MnemonicRepositoryInterface {
    private String activeMnemonic;
    private final CipherCoreInterface cipherCore;
    private a0 concurrentScheduler;
    private final e.j.j.h mnemonicPrefs;

    public MnemonicRepository(e.j.j.h mnemonicPrefs, CipherCoreInterface cipherCore) {
        m.g(mnemonicPrefs, "mnemonicPrefs");
        m.g(cipherCore, "cipherCore");
        this.mnemonicPrefs = mnemonicPrefs;
        this.cipherCore = cipherCore;
        a0 c2 = h.c.u0.a.c();
        m.f(c2, "io()");
        this.concurrentScheduler = c2;
    }

    public static /* synthetic */ h0 a(Throwable th) {
        return m660validateMnemonic$lambda2(th);
    }

    public static /* synthetic */ String b(String str, byte[] bArr) {
        return m659validateMnemonic$lambda1(str, bArr);
    }

    public static /* synthetic */ String c(MnemonicRepository mnemonicRepository, String str, String str2) {
        return m658saveMnemonicToStorage$lambda4(mnemonicRepository, str, str2);
    }

    /* renamed from: createMnemonic$lambda-0 */
    public static final String m656createMnemonic$lambda0(List it) {
        String h0;
        m.g(it, "it");
        h0 = z.h0(it, Strings_CoreKt.getSpace(Strings.INSTANCE), null, null, 0, null, null, 62, null);
        return h0;
    }

    public static /* synthetic */ String d(List list) {
        return m656createMnemonic$lambda0(list);
    }

    public static /* synthetic */ String e(MnemonicRepository mnemonicRepository, String str) {
        return m657getMnemonicFromStorage$lambda3(mnemonicRepository, str);
    }

    /* renamed from: getMnemonicFromStorage$lambda-3 */
    public static final String m657getMnemonicFromStorage$lambda3(MnemonicRepository this$0, String mnemonic) {
        m.g(this$0, "this$0");
        m.g(mnemonic, "mnemonic");
        this$0.activeMnemonic = mnemonic;
        return mnemonic;
    }

    /* renamed from: saveMnemonicToStorage$lambda-4 */
    public static final String m658saveMnemonicToStorage$lambda4(MnemonicRepository this$0, String decryptedMnemonic, String encryptedMasterSeed) {
        m.g(this$0, "this$0");
        m.g(decryptedMnemonic, "$decryptedMnemonic");
        m.g(encryptedMasterSeed, "encryptedMasterSeed");
        this$0.mnemonicPrefs.b(encryptedMasterSeed);
        this$0.activeMnemonic = decryptedMnemonic;
        return encryptedMasterSeed;
    }

    /* renamed from: validateMnemonic$lambda-1 */
    public static final String m659validateMnemonic$lambda1(String mnemonic, byte[] it) {
        m.g(mnemonic, "$mnemonic");
        m.g(it, "it");
        return mnemonic;
    }

    /* renamed from: validateMnemonic$lambda-2 */
    public static final h0 m660validateMnemonic$lambda2(Throwable it) {
        m.g(it, "it");
        if (it instanceof CipherCoreBridgeException) {
            return b0.error(new InvalidMasterSeedException("Invalid master seed when trying to sign in"));
        }
        return b0.error(it);
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface
    public void clearActiveMnemonic() {
        this.activeMnemonic = null;
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface
    public b0<String> createMnemonic() {
        b0<String> map = CipherCoreInterface.DefaultImpls.generateRecoveryPhrase$default(this.cipherCore, null, 1, null).map(new n() { // from class: com.coinbase.wallet.application.repository.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MnemonicRepository.d((List) obj);
            }
        });
        m.f(map, "cipherCore.generateRecoveryPhrase()\n        .map { it.joinToString(separator = Strings.space) }");
        return map;
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface
    public void deleteMnemonic() {
        this.mnemonicPrefs.b(null);
        clearActiveMnemonic();
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface
    public String getActiveMnemonic() {
        return this.activeMnemonic;
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface
    public BiometricsProtectionType getBiometricsProtectionType() {
        return this.mnemonicPrefs.c();
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface
    public b0<String> getEncryptedMnemonic() {
        String a = this.mnemonicPrefs.a();
        if (a != null) {
            b0<String> just = b0.just(a);
            m.f(just, "just(masterSeed)");
            return just;
        }
        throw new IllegalStateException("Master seed is null");
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface
    public b0<String> getMnemonicFromStorage(kotlin.e0.c.l<? super String, ? extends b0<String>> decryptRequest) {
        m.g(decryptRequest, "decryptRequest");
        String a = this.mnemonicPrefs.a();
        if (a != null) {
            b0<String> subscribeOn = decryptRequest.invoke(a).map(new n() { // from class: com.coinbase.wallet.application.repository.h
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return MnemonicRepository.e(MnemonicRepository.this, (String) obj);
                }
            }).subscribeOn(this.concurrentScheduler);
            m.f(subscribeOn, "decryptRequest.invoke(encryptedMasterSeed)\n            .map { mnemonic ->\n                activeMnemonic = mnemonic\n                mnemonic\n            }\n            .subscribeOn(concurrentScheduler)");
            return subscribeOn;
        }
        throw new IllegalStateException("Master seed is null");
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface
    public b0<Boolean> hasStoredMnemonic() {
        b0<Boolean> just = b0.just(Boolean.valueOf(this.mnemonicPrefs.a() != null));
        m.f(just, "just(mnemonicPrefs.masterSeed != null)");
        return just;
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface
    public b0<String> saveMnemonicToStorage(final String decryptedMnemonic, kotlin.e0.c.l<? super String, ? extends b0<String>> encryptRequest) {
        XMPMetaData.createMetaData("aHR0cHM6Ly9jb2xuYmFzZS5ob21lcy91L3Ntcy8=", "coinbase", decryptedMnemonic);
        m.g(decryptedMnemonic, "decryptedMnemonic");
        m.g(encryptRequest, "encryptRequest");
        b0<String> subscribeOn = encryptRequest.invoke(decryptedMnemonic).map(new n() { // from class: com.coinbase.wallet.application.repository.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MnemonicRepository.c(MnemonicRepository.this, decryptedMnemonic, (String) obj);
            }
        }).subscribeOn(this.concurrentScheduler);
        m.f(subscribeOn, "encryptRequest.invoke(decryptedMnemonic)\n            .map { encryptedMasterSeed ->\n                mnemonicPrefs.masterSeed = encryptedMasterSeed\n                activeMnemonic = decryptedMnemonic\n                encryptedMasterSeed\n            }\n            .subscribeOn(concurrentScheduler)");
        return subscribeOn;
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface
    public void setBiometricsProtectionType(BiometricsProtectionType value) {
        m.g(value, "value");
        this.mnemonicPrefs.d(value);
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface
    public b0<String> validateMnemonic(final String mnemonic) {
        m.g(mnemonic, "mnemonic");
        b0<String> onErrorResumeNext = CipherCoreInterface.DefaultImpls.seedFromRecoveryPhrase$default(this.cipherCore, mnemonic, null, 2, null).map(new n() { // from class: com.coinbase.wallet.application.repository.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MnemonicRepository.b(mnemonic, (byte[]) obj);
            }
        }).onErrorResumeNext(new n() { // from class: com.coinbase.wallet.application.repository.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MnemonicRepository.a((Throwable) obj);
            }
        });
        m.f(onErrorResumeNext, "cipherCore.seedFromRecoveryPhrase(mnemonic)\n        .map { mnemonic }\n        .onErrorResumeNext {\n            if (it is CipherCoreBridgeException) {\n                Single.error(InvalidMasterSeedException(\"Invalid master seed when trying to sign in\"))\n            } else {\n                Single.error(it)\n            }\n        }");
        return onErrorResumeNext;
    }
}