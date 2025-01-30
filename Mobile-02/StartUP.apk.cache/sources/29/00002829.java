package com.coinbase.wallet.user.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.ByteArray_CipherCoreKt;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.KeyPair;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.authentication.AppLockType;
import com.coinbase.wallet.authentication.AuthenticationHelperInterface;
import com.coinbase.wallet.authentication.AuthenticationResult;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.ethereum.extensions.CipherCore_EthereumKt;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.user.apis.AccessTokenApi;
import com.coinbase.wallet.user.dtos.CreateAccessTokenResponseDTO;
import com.coinbase.wallet.user.exceptions.AccessTokenException;
import com.coinbase.wallet.user.extensions.StoreKeys_UserKt;
import com.coinbase.wallet.user.models.Signature;
import h.c.h0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: AccessTokenRepository.kt */
@AppCoreScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b+\u0010,J5\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R'\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\f0\f0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/user/repositories/AccessTokenRepository;", "", "", "header", AdjustableMinerFeeArgs.NONCE, OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "", "index", "Lh/c/b0;", "Lcom/coinbase/wallet/user/models/Signature;", "signature", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lh/c/b0;", "Lcom/coinbase/wallet/user/dtos/CreateAccessTokenResponseDTO;", "accessTokenResponse", "Lkotlin/x;", "setAccessToken", "(Lcom/coinbase/wallet/user/dtos/CreateAccessTokenResponseDTO;)V", "username", "", "isPublic", "Lh/c/c;", "createUser", "(Ljava/lang/String;ZLjava/lang/String;)Lh/c/c;", "signIn", "(Ljava/lang/String;)Lh/c/b0;", "kotlin.jvm.PlatformType", "signInHandler", "Lh/c/b0;", "getSignInHandler", "()Lh/c/b0;", "hostname", "Ljava/lang/String;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "Lcom/coinbase/wallet/user/apis/AccessTokenApi;", "accessTokenApi", "Lcom/coinbase/wallet/user/apis/AccessTokenApi;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/authentication/AuthenticationHelperInterface;", "authenticationHelper", "<init>", "(Lcom/coinbase/wallet/authentication/AuthenticationHelperInterface;Lcom/coinbase/wallet/user/apis/AccessTokenApi;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AccessTokenRepository {
    private final AccessTokenApi accessTokenApi;
    private final CipherCoreInterface cipherCore;
    private final String hostname;
    private final h.c.b0<CreateAccessTokenResponseDTO> signInHandler;
    private final StoreInterface store;

    public AccessTokenRepository(AuthenticationHelperInterface authenticationHelper, AccessTokenApi accessTokenApi, CipherCoreInterface cipherCore, StoreInterface store) {
        kotlin.jvm.internal.m.g(authenticationHelper, "authenticationHelper");
        kotlin.jvm.internal.m.g(accessTokenApi, "accessTokenApi");
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(store, "store");
        this.accessTokenApi = accessTokenApi;
        this.cipherCore = cipherCore;
        this.store = store;
        this.hostname = "api.wallet.coinbase.com";
        h.c.b0<CreateAccessTokenResponseDTO> flatMap = authenticationHelper.unlock(new AppLockType.UnlockIfNeeded(false)).subscribeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.l((AuthenticationResult) obj);
            }
        }).retry().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.k(AccessTokenRepository.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "authenticationHelper\n        .unlock(AppLockType.UnlockIfNeeded(false))\n        .subscribeOn(AndroidSchedulers.mainThread())\n        .map { result ->\n            when (result) {\n                is AuthenticationResult.RecoveryPhrase -> result.recoveryPhrase\n                else -> throw AccessTokenException.UnlockFailed\n            }\n        }\n        .retry()\n        .flatMap { signIn(it) }");
        this.signInHandler = flatMap;
    }

    public static /* synthetic */ h0 a(Throwable th) {
        return m1813signIn$lambda7(th);
    }

    public static final /* synthetic */ void access$setAccessToken(AccessTokenRepository accessTokenRepository, CreateAccessTokenResponseDTO createAccessTokenResponseDTO) {
        accessTokenRepository.setAccessToken(createAccessTokenResponseDTO);
    }

    public static /* synthetic */ h0 b(AccessTokenRepository accessTokenRepository, String str, String str2) {
        return m1811signIn$lambda5(accessTokenRepository, str, str2);
    }

    public static /* synthetic */ h0 c(AccessTokenRepository accessTokenRepository, String str, String str2) {
        return m1808createUser$lambda2(accessTokenRepository, str, str2);
    }

    /* renamed from: createUser$lambda-2 */
    public static final h0 m1808createUser$lambda2(AccessTokenRepository this$0, String mnemonic, String nonce) {
        h.c.b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(mnemonic, "$mnemonic");
        kotlin.jvm.internal.m.g(nonce, "nonce");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            arrayList.add(this$0.signature("Coinbase Wallet Registration", nonce, mnemonic, i2));
            if (i3 >= 10) {
                break;
            }
            i2 = i3;
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just = h.c.b0.just(nonce);
        kotlin.jvm.internal.m.f(just, "just(nonce)");
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.AccessTokenRepository$createUser$lambda-2$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : it) {
                        if (obj instanceof Signature) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return eVar.a(just, zip);
    }

    /* renamed from: createUser$lambda-3 */
    public static final h0 m1809createUser$lambda3(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return h.c.b0.error(AccessTokenException.UnableToCreateUser.INSTANCE);
    }

    /* renamed from: createUser$lambda-4 */
    public static final h0 m1810createUser$lambda4(AccessTokenRepository this$0, String username, boolean z, kotlin.o dstr$nonce$signatures) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(username, "$username");
        kotlin.jvm.internal.m.g(dstr$nonce$signatures, "$dstr$nonce$signatures");
        String nonce = (String) dstr$nonce$signatures.a();
        List<Signature> signatures = (List) dstr$nonce$signatures.b();
        AccessTokenApi accessTokenApi = this$0.accessTokenApi;
        kotlin.jvm.internal.m.f(nonce, "nonce");
        kotlin.jvm.internal.m.f(signatures, "signatures");
        return accessTokenApi.createUser(username, z, nonce, signatures);
    }

    public static /* synthetic */ CreateAccessTokenResponseDTO d(AccessTokenRepository accessTokenRepository, CreateAccessTokenResponseDTO createAccessTokenResponseDTO) {
        return m1815signIn$lambda9(accessTokenRepository, createAccessTokenResponseDTO);
    }

    public static /* synthetic */ h0 e(AccessTokenRepository accessTokenRepository, String str, boolean z, kotlin.o oVar) {
        return m1810createUser$lambda4(accessTokenRepository, str, z, oVar);
    }

    public static /* synthetic */ Signature f(String str, byte[] bArr) {
        return m1822signature$lambda14$lambda13(str, bArr);
    }

    public static /* synthetic */ h0 g(AccessTokenRepository accessTokenRepository, KeyPair keyPair) {
        return m1818signature$lambda11(accessTokenRepository, keyPair);
    }

    public static /* synthetic */ h0 h(AccessTokenRepository accessTokenRepository, KeyPair keyPair, byte[] bArr) {
        return m1821signature$lambda14$lambda12(accessTokenRepository, keyPair, bArr);
    }

    public static /* synthetic */ h0 i(Throwable th) {
        return m1809createUser$lambda3(th);
    }

    public static /* synthetic */ kotlin.o j(KeyPair keyPair, String str) {
        return m1819signature$lambda11$lambda10(keyPair, str);
    }

    public static /* synthetic */ h0 k(AccessTokenRepository accessTokenRepository, String str) {
        return m1817signInHandler$lambda1(accessTokenRepository, str);
    }

    public static /* synthetic */ String l(AuthenticationResult authenticationResult) {
        return m1816signInHandler$lambda0(authenticationResult);
    }

    public static /* synthetic */ h0 m(String str, String str2, AccessTokenRepository accessTokenRepository, kotlin.o oVar) {
        return m1820signature$lambda14(str, str2, accessTokenRepository, oVar);
    }

    public static /* synthetic */ h0 n(AccessTokenRepository accessTokenRepository, kotlin.o oVar) {
        return m1814signIn$lambda8(accessTokenRepository, oVar);
    }

    public static /* synthetic */ void o(Throwable th) {
        l.a.a.e(th);
    }

    public final void setAccessToken(CreateAccessTokenResponseDTO createAccessTokenResponseDTO) {
        StoreInterface storeInterface = this.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        storeInterface.set(StoreKeys_UserKt.getAccessToken(storeKeys), createAccessTokenResponseDTO.getToken());
        this.store.set(StoreKeys_UserKt.getRefreshToken(storeKeys), createAccessTokenResponseDTO.getRefreshToken());
    }

    /* renamed from: signIn$lambda-5 */
    public static final h0 m1811signIn$lambda5(AccessTokenRepository this$0, String mnemonic, String nonce) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(mnemonic, "$mnemonic");
        kotlin.jvm.internal.m.g(nonce, "nonce");
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just = h.c.b0.just(nonce);
        kotlin.jvm.internal.m.f(just, "just(nonce)");
        return eVar.a(just, this$0.signature("Coinbase Wallet Sign In", nonce, mnemonic, 0));
    }

    /* renamed from: signIn$lambda-7 */
    public static final h0 m1813signIn$lambda7(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return h.c.b0.error(AccessTokenException.UnableToCreateAccessToken.INSTANCE);
    }

    /* renamed from: signIn$lambda-8 */
    public static final h0 m1814signIn$lambda8(AccessTokenRepository this$0, kotlin.o dstr$nonce$signature) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$nonce$signature, "$dstr$nonce$signature");
        String nonce = (String) dstr$nonce$signature.a();
        Signature signature = (Signature) dstr$nonce$signature.b();
        AccessTokenApi accessTokenApi = this$0.accessTokenApi;
        kotlin.jvm.internal.m.f(nonce, "nonce");
        return accessTokenApi.createAccessToken(nonce, signature.getAddress(), signature.getSignature());
    }

    /* renamed from: signIn$lambda-9 */
    public static final CreateAccessTokenResponseDTO m1815signIn$lambda9(AccessTokenRepository this$0, CreateAccessTokenResponseDTO accessTokenResponseDTO) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(accessTokenResponseDTO, "accessTokenResponseDTO");
        this$0.setAccessToken(accessTokenResponseDTO);
        return accessTokenResponseDTO;
    }

    /* renamed from: signInHandler$lambda-0 */
    public static final String m1816signInHandler$lambda0(AuthenticationResult result) {
        kotlin.jvm.internal.m.g(result, "result");
        if (result instanceof AuthenticationResult.RecoveryPhrase) {
            return ((AuthenticationResult.RecoveryPhrase) result).getRecoveryPhrase();
        }
        throw AccessTokenException.UnlockFailed.INSTANCE;
    }

    /* renamed from: signInHandler$lambda-1 */
    public static final h0 m1817signInHandler$lambda1(AccessTokenRepository this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.signIn(it);
    }

    private final h.c.b0<Signature> signature(final String str, final String str2, String str3, int i2) {
        h.c.b0<Signature> flatMap = CipherCore_EthereumKt.getEthereumWalletKeyPair(this.cipherCore, i2, str3).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.g(AccessTokenRepository.this, (KeyPair) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.m(str, str2, this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "cipherCore.getEthereumWalletKeyPair(index, mnemonic)\n            .flatMap { keyPair ->\n                cipherCore.ethereumAddressFromPublicKey(keyPair.publicKey).map { Pair(it, keyPair) }\n            }\n            .flatMap { (address, keyPair) ->\n                val message = \"$header\\n\\nAddress: $address\\nNonce: $nonce\\nHost: $hostname\"\n                val messageData = message.toByteArray()\n\n                cipherCore.keccak256Hash(messageData)\n                    .flatMap { data ->\n                        cipherCore.signEthereumMessage(\n                            message = data,\n                            privateKey = keyPair.privateKey,\n                            addPrefix = false\n                        )\n                    }\n                    .map { Signature(it.toHexEncodedString(addPrefix = true), address) }\n            }");
        return flatMap;
    }

    /* renamed from: signature$lambda-11 */
    public static final h0 m1818signature$lambda11(AccessTokenRepository this$0, final KeyPair keyPair) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(keyPair, "keyPair");
        return this$0.cipherCore.ethereumAddressFromPublicKey(keyPair.getPublicKey()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.j(KeyPair.this, (String) obj);
            }
        });
    }

    /* renamed from: signature$lambda-11$lambda-10 */
    public static final kotlin.o m1819signature$lambda11$lambda10(KeyPair keyPair, String it) {
        kotlin.jvm.internal.m.g(keyPair, "$keyPair");
        kotlin.jvm.internal.m.g(it, "it");
        return new kotlin.o(it, keyPair);
    }

    /* renamed from: signature$lambda-14 */
    public static final h0 m1820signature$lambda14(String header, String nonce, AccessTokenRepository this$0, kotlin.o dstr$address$keyPair) {
        kotlin.jvm.internal.m.g(header, "$header");
        kotlin.jvm.internal.m.g(nonce, "$nonce");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$address$keyPair, "$dstr$address$keyPair");
        final String str = (String) dstr$address$keyPair.a();
        final KeyPair keyPair = (KeyPair) dstr$address$keyPair.b();
        String str2 = header + "\n\nAddress: " + str + "\nNonce: " + nonce + "\nHost: " + this$0.hostname;
        Charset charset = kotlin.l0.d.a;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str2.getBytes(charset);
        kotlin.jvm.internal.m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        return this$0.cipherCore.keccak256Hash(bytes).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.h(AccessTokenRepository.this, keyPair, (byte[]) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.f(str, (byte[]) obj);
            }
        });
    }

    /* renamed from: signature$lambda-14$lambda-12 */
    public static final h0 m1821signature$lambda14$lambda12(AccessTokenRepository this$0, KeyPair keyPair, byte[] data) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(keyPair, "$keyPair");
        kotlin.jvm.internal.m.g(data, "data");
        return this$0.cipherCore.signEthereumMessage(data, keyPair.getPrivateKey(), false);
    }

    /* renamed from: signature$lambda-14$lambda-13 */
    public static final Signature m1822signature$lambda14$lambda13(String address, byte[] it) {
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(it, "it");
        return new Signature(ByteArray_CipherCoreKt.toHexEncodedString(it, true), address);
    }

    public final h.c.c createUser(final String username, final boolean z, final String mnemonic) {
        kotlin.jvm.internal.m.g(username, "username");
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        h.c.b0<R> flatMap = this.accessTokenApi.createNonce().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.c(AccessTokenRepository.this, mnemonic, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "accessTokenApi.createNonce()\n        .flatMap { nonce ->\n            val signatureSingles = mutableListOf<Single<Signature>>()\n\n            for (index in 0 until 10) {\n                signatureSingles.add(\n                    signature(\n                        header = \"Coinbase Wallet Registration\",\n                        nonce = nonce,\n                        mnemonic = mnemonic,\n                        index = index\n                    )\n                )\n            }\n\n            Singles.zip(Single.just(nonce), Singles.zipOrEmpty(signatureSingles))\n        }");
        h.c.c ignoreElement = Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.i((Throwable) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.e(AccessTokenRepository.this, username, z, (kotlin.o) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.AccessTokenRepository$createUser$4
            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                apply((CreateAccessTokenResponseDTO) obj);
                return kotlin.x.a;
            }

            public final void apply(CreateAccessTokenResponseDTO p0) {
                kotlin.jvm.internal.m.g(p0, "p0");
                AccessTokenRepository.access$setAccessToken(AccessTokenRepository.this, p0);
            }
        }).ignoreElement();
        kotlin.jvm.internal.m.f(ignoreElement, "accessTokenApi.createNonce()\n        .flatMap { nonce ->\n            val signatureSingles = mutableListOf<Single<Signature>>()\n\n            for (index in 0 until 10) {\n                signatureSingles.add(\n                    signature(\n                        header = \"Coinbase Wallet Registration\",\n                        nonce = nonce,\n                        mnemonic = mnemonic,\n                        index = index\n                    )\n                )\n            }\n\n            Singles.zip(Single.just(nonce), Singles.zipOrEmpty(signatureSingles))\n        }\n        .logError()\n        .onErrorResumeNext { Single.error(AccessTokenException.UnableToCreateUser) }\n        .flatMap { (nonce, signatures) -> accessTokenApi.createUser(username, isPublic, nonce, signatures) }\n        .map(::setAccessToken)\n        .ignoreElement()");
        return ignoreElement;
    }

    public final h.c.b0<CreateAccessTokenResponseDTO> getSignInHandler() {
        return this.signInHandler;
    }

    public final h.c.b0<CreateAccessTokenResponseDTO> signIn(final String mnemonic) {
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        h.c.b0<CreateAccessTokenResponseDTO> map = this.accessTokenApi.createNonce().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.b(AccessTokenRepository.this, mnemonic, (String) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.user.repositories.o
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                AccessTokenRepository.o((Throwable) obj);
            }
        }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.a((Throwable) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.n(AccessTokenRepository.this, (kotlin.o) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.repositories.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AccessTokenRepository.d(AccessTokenRepository.this, (CreateAccessTokenResponseDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "accessTokenApi.createNonce()\n        .flatMap { nonce ->\n            Singles.zip(\n                Single.just(nonce),\n                signature(\n                    header = \"Coinbase Wallet Sign In\",\n                    nonce = nonce,\n                    mnemonic = mnemonic,\n                    index = 0\n                )\n            )\n        }\n        .doOnError { Timber.e(it) }\n        .onErrorResumeNext { Single.error(AccessTokenException.UnableToCreateAccessToken) }\n        .flatMap { (nonce, signature) ->\n            accessTokenApi.createAccessToken(nonce, signature.address, signature.signature)\n        }\n        .map { accessTokenResponseDTO ->\n            setAccessToken(accessTokenResponseDTO)\n            accessTokenResponseDTO\n        }");
        return map;
    }
}