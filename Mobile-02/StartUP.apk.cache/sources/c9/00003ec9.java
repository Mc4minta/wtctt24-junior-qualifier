package com.reactnativecommunity.netinfo;

import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Locale;
import org.spongycastle.i18n.ErrorBundle;

/* compiled from: ConnectivityReceiver.java */
/* loaded from: classes2.dex */
abstract class c {
    private final ConnectivityManager a;

    /* renamed from: b  reason: collision with root package name */
    private final WifiManager f10724b;

    /* renamed from: c  reason: collision with root package name */
    private final TelephonyManager f10725c;

    /* renamed from: d  reason: collision with root package name */
    private final ReactApplicationContext f10726d;

    /* renamed from: e  reason: collision with root package name */
    private com.reactnativecommunity.netinfo.g.b f10727e = com.reactnativecommunity.netinfo.g.b.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    private com.reactnativecommunity.netinfo.g.a f10728f = null;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10729g = false;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f10730h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ReactApplicationContext reactApplicationContext) {
        this.f10726d = reactApplicationContext;
        this.a = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
        this.f10724b = (WifiManager) reactApplicationContext.getApplicationContext().getSystemService("wifi");
        this.f10725c = (TelephonyManager) reactApplicationContext.getSystemService("phone");
    }

    private WritableMap a(String str) {
        WritableMap createMap = Arguments.createMap();
        if (e.a(e())) {
            createMap.putBoolean("isWifiEnabled", this.f10724b.isWifiEnabled());
        }
        createMap.putString("type", str != null ? str : this.f10727e.f10746k);
        boolean z = true;
        boolean z2 = (this.f10727e.equals(com.reactnativecommunity.netinfo.g.b.NONE) || this.f10727e.equals(com.reactnativecommunity.netinfo.g.b.UNKNOWN)) ? false : true;
        createMap.putBoolean("isConnected", z2);
        if (!this.f10729g || (str != null && !str.equals(this.f10727e.f10746k))) {
            z = false;
        }
        createMap.putBoolean("isInternetReachable", z);
        if (str == null) {
            str = this.f10727e.f10746k;
        }
        WritableMap b2 = b(str);
        if (z2) {
            b2.putBoolean("isConnectionExpensive", androidx.core.net.a.a(c()));
        }
        createMap.putMap(ErrorBundle.DETAIL_ENTRY, b2);
        return createMap;
    }

    private WritableMap b(String str) {
        WifiInfo connectionInfo;
        WritableMap createMap = Arguments.createMap();
        str.hashCode();
        if (!str.equals("cellular")) {
            if (str.equals("wifi") && e.a(e()) && (connectionInfo = this.f10724b.getConnectionInfo()) != null) {
                try {
                    String ssid = connectionInfo.getSSID();
                    if (ssid != null && !ssid.contains("<unknown ssid>")) {
                        createMap.putString("ssid", ssid.replace("\"", ""));
                    }
                } catch (Exception unused) {
                }
                try {
                    String bssid = connectionInfo.getBSSID();
                    if (bssid != null) {
                        createMap.putString("bssid", bssid);
                    }
                } catch (Exception unused2) {
                }
                try {
                    createMap.putInt("strength", WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 100));
                } catch (Exception unused3) {
                }
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        createMap.putInt("frequency", connectionInfo.getFrequency());
                    }
                } catch (Exception unused4) {
                }
                try {
                    byte[] byteArray = BigInteger.valueOf(connectionInfo.getIpAddress()).toByteArray();
                    e.b(byteArray);
                    createMap.putString("ipAddress", InetAddress.getByAddress(byteArray).getHostAddress());
                } catch (Exception unused5) {
                }
                try {
                    byte[] byteArray2 = BigInteger.valueOf(connectionInfo.getIpAddress()).toByteArray();
                    e.b(byteArray2);
                    int networkPrefixLength = (-1) << (32 - NetworkInterface.getByInetAddress(InetAddress.getByAddress(byteArray2)).getInterfaceAddresses().get(1).getNetworkPrefixLength());
                    createMap.putString("subnet", String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf((networkPrefixLength >> 24) & 255), Integer.valueOf((networkPrefixLength >> 16) & 255), Integer.valueOf((networkPrefixLength >> 8) & 255), Integer.valueOf(networkPrefixLength & 255)));
                } catch (Exception unused6) {
                }
            }
        } else {
            com.reactnativecommunity.netinfo.g.a aVar = this.f10728f;
            if (aVar != null) {
                createMap.putString("cellularGeneration", aVar.f10737e);
            }
            String networkOperatorName = this.f10725c.getNetworkOperatorName();
            if (networkOperatorName != null) {
                createMap.putString("carrier", networkOperatorName);
            }
        }
        return createMap;
    }

    private void g() {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) e().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("netInfo.networkStatusDidChange", a(null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectivityManager c() {
        return this.a;
    }

    public void d(String str, Promise promise) {
        promise.resolve(a(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReactApplicationContext e() {
        return this.f10726d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    public void h(boolean z) {
        this.f10730h = Boolean.valueOf(z);
        j(this.f10727e, this.f10728f, this.f10729g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void i();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(com.reactnativecommunity.netinfo.g.b bVar, com.reactnativecommunity.netinfo.g.a aVar, boolean z) {
        Boolean bool = this.f10730h;
        if (bool != null) {
            z = bool.booleanValue();
        }
        boolean z2 = bVar != this.f10727e;
        boolean z3 = aVar != this.f10728f;
        boolean z4 = z != this.f10729g;
        if (z2 || z3 || z4) {
            this.f10727e = bVar;
            this.f10728f = aVar;
            this.f10729g = z;
            g();
        }
    }
}