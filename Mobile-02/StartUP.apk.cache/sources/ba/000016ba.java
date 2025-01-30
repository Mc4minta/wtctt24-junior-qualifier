package com.coinbase.wallet.consumer.networking.interceptor;

import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: DeviceInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019Bo\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\tR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\tR\u001e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\tR\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/consumer/networking/interceptor/DeviceInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", "osVersion", "Ljava/lang/String;", "model", "product", "brand", "systemBoard", "androidId", "manufacturer", "systemBootloader", "Lkotlin/Function0;", "advertisingIdProvider", "Lkotlin/e0/c/a;", "systemVersion", "systemName", "osName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/e0/c/a;)V", "Companion", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class DeviceInterceptor implements Interceptor {
    private static final String ACCEPT = "Accept";
    private static final String ADVERTISING_ID = "X-Advertising-Id";
    private static final String ANDROID_ID = "X-Android-Id";
    private static final String BRAND = "X-Device-Brand";
    public static final Companion Companion = new Companion(null);
    private static final String MANUFACTURER = "X-Device-Manufacturer";
    private static final String MODEL = "X-Device-Model";
    private static final String OS_NAME = "X-Os-Name";
    private static final String OS_VERSION = "X-Os-Version";
    private static final String PRODUCT = "X-Device-Product";
    private static final String SYSTEM_BOARD = "X-System-Board";
    private static final String SYSTEM_BOOTLOADER = "X-System-BOOTLOADER";
    private static final String SYSTEM_NAME = "X-System-Name";
    private static final String SYSTEM_VERSION = "X-System-Version";
    private final a<String> advertisingIdProvider;
    private final String androidId;
    private final String brand;
    private final String manufacturer;
    private final String model;
    private final String osName;
    private final String osVersion;
    private final String product;
    private final String systemBoard;
    private final String systemBootloader;
    private final String systemName;
    private final String systemVersion;

    /* compiled from: DeviceInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/consumer/networking/interceptor/DeviceInterceptor$Companion;", "", "", "ACCEPT", "Ljava/lang/String;", "ADVERTISING_ID", "ANDROID_ID", "BRAND", "MANUFACTURER", "MODEL", "OS_NAME", "OS_VERSION", "PRODUCT", "SYSTEM_BOARD", "SYSTEM_BOOTLOADER", "SYSTEM_NAME", "SYSTEM_VERSION", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DeviceInterceptor(String model, String product, String brand, String manufacturer, String systemName, String systemVersion, String systemBoard, String systemBootloader, String osVersion, String osName, String androidId, a<String> advertisingIdProvider) {
        m.g(model, "model");
        m.g(product, "product");
        m.g(brand, "brand");
        m.g(manufacturer, "manufacturer");
        m.g(systemName, "systemName");
        m.g(systemVersion, "systemVersion");
        m.g(systemBoard, "systemBoard");
        m.g(systemBootloader, "systemBootloader");
        m.g(osVersion, "osVersion");
        m.g(osName, "osName");
        m.g(androidId, "androidId");
        m.g(advertisingIdProvider, "advertisingIdProvider");
        this.model = model;
        this.product = product;
        this.brand = brand;
        this.manufacturer = manufacturer;
        this.systemName = systemName;
        this.systemVersion = systemVersion;
        this.systemBoard = systemBoard;
        this.systemBootloader = systemBootloader;
        this.osVersion = osVersion;
        this.osName = osName;
        this.androidId = androidId;
        this.advertisingIdProvider = advertisingIdProvider;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Request.Builder replaceHeader;
        Request.Builder replaceHeader2;
        Request.Builder replaceHeader3;
        Request.Builder replaceHeader4;
        Request.Builder replaceHeader5;
        Request.Builder replaceHeader6;
        Request.Builder replaceHeader7;
        Request.Builder replaceHeader8;
        Request.Builder replaceHeader9;
        Request.Builder replaceHeader10;
        Request.Builder replaceHeader11;
        Request.Builder replaceHeader12;
        m.g(chain, "chain");
        replaceHeader = DeviceInterceptorKt.replaceHeader(chain.request().newBuilder(), MODEL, this.model);
        replaceHeader2 = DeviceInterceptorKt.replaceHeader(replaceHeader, PRODUCT, this.product);
        replaceHeader3 = DeviceInterceptorKt.replaceHeader(replaceHeader2, BRAND, this.brand);
        replaceHeader4 = DeviceInterceptorKt.replaceHeader(replaceHeader3, MANUFACTURER, this.manufacturer);
        replaceHeader5 = DeviceInterceptorKt.replaceHeader(replaceHeader4, SYSTEM_NAME, this.systemName);
        replaceHeader6 = DeviceInterceptorKt.replaceHeader(replaceHeader5, SYSTEM_VERSION, this.systemVersion);
        replaceHeader7 = DeviceInterceptorKt.replaceHeader(replaceHeader6, SYSTEM_BOARD, this.systemBoard);
        replaceHeader8 = DeviceInterceptorKt.replaceHeader(replaceHeader7, SYSTEM_BOOTLOADER, this.systemBootloader);
        replaceHeader9 = DeviceInterceptorKt.replaceHeader(replaceHeader8, OS_VERSION, this.osVersion);
        replaceHeader10 = DeviceInterceptorKt.replaceHeader(replaceHeader9, OS_NAME, this.osName);
        replaceHeader11 = DeviceInterceptorKt.replaceHeader(replaceHeader10, ANDROID_ID, this.androidId);
        replaceHeader12 = DeviceInterceptorKt.replaceHeader(replaceHeader11, "Accept", "application/json");
        String invoke = this.advertisingIdProvider.invoke();
        if (invoke != null) {
            DeviceInterceptorKt.replaceHeader(replaceHeader12, ADVERTISING_ID, invoke);
        }
        return chain.proceed(replaceHeader12.build());
    }
}