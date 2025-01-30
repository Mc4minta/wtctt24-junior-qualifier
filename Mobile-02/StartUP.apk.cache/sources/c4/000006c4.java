package com.amplitude.api;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* compiled from: DeviceInfo.java */
/* loaded from: classes.dex */
public class h {
    private boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    private Context f3550b;

    /* renamed from: c  reason: collision with root package name */
    private b f3551c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeviceInfo.java */
    /* loaded from: classes.dex */
    public class b {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f3552b;

        /* renamed from: c  reason: collision with root package name */
        private String f3553c;

        /* renamed from: d  reason: collision with root package name */
        private String f3554d;

        /* renamed from: e  reason: collision with root package name */
        private String f3555e;

        /* renamed from: f  reason: collision with root package name */
        private String f3556f;

        /* renamed from: g  reason: collision with root package name */
        private String f3557g;

        /* renamed from: h  reason: collision with root package name */
        private String f3558h;

        /* renamed from: i  reason: collision with root package name */
        private String f3559i;

        /* renamed from: j  reason: collision with root package name */
        private String f3560j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f3561k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f3562l;

        private String A() {
            return Build.VERSION.RELEASE;
        }

        private String B() {
            try {
                return h.this.f3550b.getPackageManager().getPackageInfo(h.this.f3550b.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                i.d().f("Failed to get version name", e2);
                return null;
            }
        }

        private boolean m() {
            try {
                Integer num = (Integer) Class.forName("com.google.android.gms.common.g").getMethod("isGooglePlayServicesAvailable", Context.class).invoke(null, h.this.f3550b);
                if (num != null) {
                    return num.intValue() == 0;
                }
                return false;
            } catch (ClassNotFoundException e2) {
                d.d().f("com.amplitude.api.DeviceInfo", "Google Play Services Util not found!");
                i.d().f("Failed to check GPS enabled", e2);
                return false;
            } catch (IllegalAccessException e3) {
                d.d().f("com.amplitude.api.DeviceInfo", "Google Play Services not available");
                i.d().f("Failed to check GPS enabled", e3);
                return false;
            } catch (NoClassDefFoundError e4) {
                d.d().f("com.amplitude.api.DeviceInfo", "Google Play Services Util not found!");
                i.d().f("Failed to check GPS enabled", e4);
                return false;
            } catch (NoSuchMethodException e5) {
                d.d().f("com.amplitude.api.DeviceInfo", "Google Play Services not available");
                i.d().f("Failed to check GPS enabled", e5);
                return false;
            } catch (InvocationTargetException e6) {
                d.d().f("com.amplitude.api.DeviceInfo", "Google Play Services not available");
                i.d().f("Failed to check GPS enabled", e6);
                return false;
            } catch (Exception e7) {
                d d2 = d.d();
                d2.f("com.amplitude.api.DeviceInfo", "Error when checking for Google Play Services: " + e7);
                i.d().f("Failed to check GPS enabled", e7);
                return false;
            }
        }

        private String n() {
            if ("Amazon".equals(x())) {
                return o();
            }
            return p();
        }

        private String o() {
            ContentResolver contentResolver = h.this.f3550b.getContentResolver();
            this.f3561k = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 0) == 1;
            String string = Settings.Secure.getString(contentResolver, "advertising_id");
            this.a = string;
            return string;
        }

        private String p() {
            try {
                boolean z = true;
                Object invoke = Class.forName("e.g.a.e.a.a.a").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, h.this.f3550b);
                Boolean bool = (Boolean) invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0]);
                if (bool == null || !bool.booleanValue()) {
                    z = false;
                }
                this.f3561k = z;
                this.a = (String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
            } catch (ClassNotFoundException e2) {
                d.d().f("com.amplitude.api.DeviceInfo", "Google Play Services SDK not found!");
                i.d().f("Failed to get ADID", e2);
            } catch (InvocationTargetException e3) {
                d.d().f("com.amplitude.api.DeviceInfo", "Google Play Services not available");
                i.d().f("Failed to get ADID", e3);
            } catch (Exception e4) {
                d.d().c("com.amplitude.api.DeviceInfo", "Encountered an error connecting to Google Play Services", e4);
                i.d().f("Failed to get ADID", e4);
            }
            return this.a;
        }

        private String q() {
            return Build.BRAND;
        }

        private String r() {
            try {
                return ((TelephonyManager) h.this.f3550b.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception e2) {
                i.d().f("Failed to get carrier", e2);
                return null;
            }
        }

        private String s() {
            String u = u();
            if (l.b(u)) {
                String v = v();
                return !l.b(v) ? v : t();
            }
            return u;
        }

        private String t() {
            return Locale.getDefault().getCountry();
        }

        private String u() {
            Location l2;
            List<Address> fromLocation;
            if (h.this.r() && (l2 = h.this.l()) != null) {
                try {
                    if (Geocoder.isPresent() && (fromLocation = h.this.h().getFromLocation(l2.getLatitude(), l2.getLongitude(), 1)) != null) {
                        for (Address address : fromLocation) {
                            if (address != null) {
                                return address.getCountryCode();
                            }
                        }
                    }
                } catch (IOException e2) {
                    i.d().f("Failed to get country from location", e2);
                } catch (IllegalArgumentException e3) {
                    i.d().f("Failed to get country from location", e3);
                } catch (IllegalStateException e4) {
                    i.d().f("Failed to get country from location", e4);
                } catch (NoSuchMethodError e5) {
                    i.d().f("Failed to get country from location", e5);
                } catch (NullPointerException e6) {
                    i.d().f("Failed to get country from location", e6);
                }
            }
            return null;
        }

        private String v() {
            String networkCountryIso;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) h.this.f3550b.getSystemService("phone");
                if (telephonyManager.getPhoneType() == 2 || (networkCountryIso = telephonyManager.getNetworkCountryIso()) == null) {
                    return null;
                }
                return networkCountryIso.toUpperCase(Locale.US);
            } catch (Exception e2) {
                i.d().f("Failed to get country from network", e2);
                return null;
            }
        }

        private String w() {
            return Locale.getDefault().getLanguage();
        }

        private String x() {
            return Build.MANUFACTURER;
        }

        private String y() {
            return Build.MODEL;
        }

        private String z() {
            return "android";
        }

        private b() {
            this.a = n();
            this.f3553c = B();
            this.f3554d = z();
            this.f3555e = A();
            this.f3556f = q();
            this.f3557g = x();
            this.f3558h = y();
            this.f3559i = r();
            this.f3552b = s();
            this.f3560j = w();
            this.f3562l = m();
        }
    }

    public h(Context context) {
        this.f3550b = context;
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    private b e() {
        if (this.f3551c == null) {
            this.f3551c = new b();
        }
        return this.f3551c;
    }

    public String c() {
        return e().a;
    }

    public String d() {
        return e().f3556f;
    }

    public String f() {
        return e().f3559i;
    }

    public String g() {
        return e().f3552b;
    }

    protected Geocoder h() {
        return new Geocoder(this.f3550b, Locale.ENGLISH);
    }

    public String i() {
        return e().f3560j;
    }

    public String j() {
        return e().f3557g;
    }

    public String k() {
        return e().f3558h;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0032 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.location.Location l() {
        /*
            r7 = this;
            java.lang.String r0 = "Failed to get most recent location"
            boolean r1 = r7.r()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            android.content.Context r1 = r7.f3550b
            java.lang.String r3 = "location"
            java.lang.Object r1 = r1.getSystemService(r3)
            android.location.LocationManager r1 = (android.location.LocationManager) r1
            if (r1 != 0) goto L17
            return r2
        L17:
            r3 = 1
            java.util.List r3 = r1.getProviders(r3)     // Catch: java.lang.SecurityException -> L1d
            goto L26
        L1d:
            r3 = move-exception
            com.amplitude.api.i r4 = com.amplitude.api.i.d()
            r4.f(r0, r3)
            r3 = r2
        L26:
            if (r3 != 0) goto L29
            return r2
        L29:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r3 = r3.iterator()
        L32:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L5b
            java.lang.Object r5 = r3.next()
            java.lang.String r5 = (java.lang.String) r5
            android.location.Location r5 = r1.getLastKnownLocation(r5)     // Catch: java.lang.SecurityException -> L43 java.lang.IllegalArgumentException -> L4c
            goto L55
        L43:
            r5 = move-exception
            com.amplitude.api.i r6 = com.amplitude.api.i.d()
            r6.f(r0, r5)
            goto L54
        L4c:
            r5 = move-exception
            com.amplitude.api.i r6 = com.amplitude.api.i.d()
            r6.f(r0, r5)
        L54:
            r5 = r2
        L55:
            if (r5 == 0) goto L32
            r4.add(r5)
            goto L32
        L5b:
            r0 = -1
            java.util.Iterator r3 = r4.iterator()
        L61:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L7b
            java.lang.Object r4 = r3.next()
            android.location.Location r4 = (android.location.Location) r4
            long r5 = r4.getTime()
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 <= 0) goto L61
            long r0 = r4.getTime()
            r2 = r4
            goto L61
        L7b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.h.l():android.location.Location");
    }

    public String m() {
        return e().f3554d;
    }

    public String n() {
        return e().f3555e;
    }

    public String o() {
        return e().f3553c;
    }

    public boolean p() {
        return e().f3562l;
    }

    public boolean q() {
        return e().f3561k;
    }

    public boolean r() {
        return this.a;
    }

    public void s() {
        e();
    }
}