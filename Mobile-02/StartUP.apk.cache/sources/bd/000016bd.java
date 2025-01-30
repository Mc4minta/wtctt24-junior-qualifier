package com.coinbase.wallet.consumer.repositories;

import android.annotation.TargetApi;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.consumer.models.AppToAppConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* compiled from: AppToAppAuthRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/consumer/repositories/AppToAppAuthRepository;", "", "", "callingPackage", "", "getSigners", "(Ljava/lang/String;)Ljava/util/List;", "", "Landroid/content/pm/Signature;", "getSignersApi28", "(Ljava/lang/String;)[Landroid/content/pm/Signature;", "targetPackage", "", "checkTargetPackageSigner", "(Ljava/lang/String;)Z", "isInstalled", "Landroid/content/pm/PackageManager;", "pm", "Landroid/content/pm/PackageManager;", "Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "buildConfigWrapper", "Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "<init>", "(Landroid/content/pm/PackageManager;Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppToAppAuthRepository {
    private final BuildConfigWrapper buildConfigWrapper;
    private final PackageManager pm;

    public AppToAppAuthRepository(PackageManager pm, BuildConfigWrapper buildConfigWrapper) {
        kotlin.jvm.internal.m.g(pm, "pm");
        kotlin.jvm.internal.m.g(buildConfigWrapper, "buildConfigWrapper");
        this.pm = pm;
        this.buildConfigWrapper = buildConfigWrapper;
    }

    private final List<String> getSigners(String str) {
        Signature[] signatureArr;
        if (this.buildConfigWrapper.getSdkInt() >= 28) {
            signatureArr = getSignersApi28(str);
        } else {
            signatureArr = this.pm.getPackageInfo(str, 64).signatures;
        }
        kotlin.jvm.internal.m.f(signatureArr, "if (buildConfigWrapper.sdkInt >= Build.VERSION_CODES.P) {\n            getSignersApi28(callingPackage)\n        } else {\n            @Suppress(\"DEPRECATION\")\n            pm.getPackageInfo(callingPackage, PackageManager.GET_SIGNATURES).signatures\n        }");
        ArrayList arrayList = new ArrayList(signatureArr.length);
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toCharsString());
        }
        return arrayList;
    }

    @TargetApi(28)
    private final Signature[] getSignersApi28(String str) {
        SigningInfo signingInfo = this.pm.getPackageInfo(str, 134217728).signingInfo;
        if (signingInfo.hasMultipleSigners()) {
            Signature[] apkContentsSigners = signingInfo.getApkContentsSigners();
            kotlin.jvm.internal.m.f(apkContentsSigners, "{\n            signingInfo.apkContentsSigners\n        }");
            return apkContentsSigners;
        }
        Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
        kotlin.jvm.internal.m.f(signingCertificateHistory, "{\n            signingInfo.signingCertificateHistory\n        }");
        return signingCertificateHistory;
    }

    public final boolean checkTargetPackageSigner(String targetPackage) {
        kotlin.jvm.internal.m.g(targetPackage, "targetPackage");
        List<String> signers = getSigners(targetPackage);
        return (signers.size() == 1 && kotlin.jvm.internal.m.c(kotlin.a0.p.Y(signers), AppToAppConfig.INSTANCE.getWhiteListedSigner())) || this.buildConfigWrapper.isDebug();
    }

    public final boolean isInstalled(String targetPackage) {
        kotlin.jvm.internal.m.g(targetPackage, "targetPackage");
        List<PackageInfo> installedPackages = this.pm.getInstalledPackages(0);
        kotlin.jvm.internal.m.f(installedPackages, "pm.getInstalledPackages(0)");
        if ((installedPackages instanceof Collection) && installedPackages.isEmpty()) {
            return false;
        }
        for (PackageInfo packageInfo : installedPackages) {
            if (kotlin.jvm.internal.m.c(packageInfo.packageName, targetPackage)) {
                return true;
            }
        }
        return false;
    }
}