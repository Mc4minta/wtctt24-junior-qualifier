package com.dieam.reactnativepushnotification.modules;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import com.coinbase.ApiConstants;
import com.dieam.reactnativepushnotification.modules.f;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import org.apache.http.client.config.CookieSpecs;
import org.json.JSONException;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: RNPushNotificationHelper.java */
/* loaded from: classes2.dex */
public class d {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private c f4477b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f4478c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNPushNotificationHelper.java */
    /* loaded from: classes2.dex */
    public class a implements f.c {
        final /* synthetic */ Bundle a;

        a(Bundle bundle) {
            this.a = bundle;
        }

        @Override // com.dieam.reactnativepushnotification.modules.f.c
        public void a(Bitmap bitmap, Bitmap bitmap2) {
            d.this.y(this.a, bitmap, bitmap2);
        }
    }

    public d(Application application) {
        this.a = application;
        this.f4477b = new c(application);
        this.f4478c = application.getSharedPreferences("rn_push_notification", 0);
    }

    private void c(String str) {
        Log.i(RNPushNotification.LOG_TAG, "Cancelling notification: " + str);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        PendingIntent z = z(bundle);
        if (z != null) {
            l().cancel(z);
        }
        if (this.f4478c.contains(str)) {
            SharedPreferences.Editor edit = this.f4478c.edit();
            edit.remove(str);
            edit.apply();
        } else {
            Log.w(RNPushNotification.LOG_TAG, "Unable to find notification " + str);
        }
        try {
            t().cancel(Integer.parseInt(str));
        } catch (Exception e2) {
            Log.e(RNPushNotification.LOG_TAG, "Unable to parse Notification ID " + str, e2);
        }
    }

    private boolean f(NotificationManager notificationManager, String str, String str2, String str3, Uri uri, int i2, long[] jArr) {
        if (Build.VERSION.SDK_INT >= 26 && notificationManager != null) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            if ((notificationChannel != null || str2 == null || str3 == null) && (notificationChannel == null || ((str2 == null || notificationChannel.getName().equals(str2)) && (str3 == null || notificationChannel.getDescription().equals(str3))))) {
                return false;
            }
            NotificationChannel notificationChannel2 = new NotificationChannel(str, str2, i2);
            notificationChannel2.setDescription(str3);
            notificationChannel2.enableLights(true);
            notificationChannel2.enableVibration(jArr != null);
            notificationChannel2.setVibrationPattern(jArr);
            if (uri != null) {
                notificationChannel2.setSound(uri, new AudioAttributes.Builder().setContentType(4).setUsage(5).build());
            } else {
                notificationChannel2.setSound(null, null);
            }
            notificationManager.createNotificationChannel(notificationChannel2);
            return true;
        }
        return false;
    }

    private AlarmManager l() {
        return (AlarmManager) this.a.getSystemService("alarm");
    }

    private Uri p(String str) {
        int identifier;
        if (str != null && !CookieSpecs.DEFAULT.equalsIgnoreCase(str)) {
            if (this.a.getResources().getIdentifier(str, "raw", this.a.getPackageName()) != 0) {
                identifier = this.a.getResources().getIdentifier(str, "raw", this.a.getPackageName());
            } else {
                identifier = this.a.getResources().getIdentifier(str.substring(0, str.lastIndexOf(46)), "raw", this.a.getPackageName());
            }
            return Uri.parse("android.resource://" + this.a.getPackageName() + "/" + identifier);
        }
        return RingtoneManager.getDefaultUri(2);
    }

    private NotificationManager t() {
        return (NotificationManager) this.a.getSystemService("notification");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void u(Bundle bundle) {
        char c2;
        char c3;
        long j2;
        long j3;
        long j4;
        String string = bundle.getString("repeatType");
        long j5 = (long) bundle.getDouble("repeatTime");
        if (string != null) {
            long j6 = (long) bundle.getDouble("fireDate");
            if (!Arrays.asList(ApiConstants.TIME, "month", "week", "day", "hour", "minute").contains(string)) {
                Log.w(RNPushNotification.LOG_TAG, String.format("Invalid repeatType specified as %s", string));
            } else if (ApiConstants.TIME.equals(string) && j5 <= 0) {
                Log.w(RNPushNotification.LOG_TAG, "repeatType specified as time but no repeatTime has been mentioned");
            } else {
                switch (string.hashCode()) {
                    case -1074026988:
                        if (string.equals("minute")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 99228:
                        if (string.equals("day")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3208676:
                        if (string.equals("hour")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3560141:
                        if (string.equals(ApiConstants.TIME)) {
                            c3 = 3;
                            c2 = c3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3645428:
                        if (string.equals("week")) {
                            c3 = 4;
                            c2 = c3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 104080000:
                        if (string.equals("month")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        j2 = 60000;
                        j3 = j2 + j6;
                        j4 = 0;
                        break;
                    case 1:
                        j2 = 86400000;
                        j3 = j2 + j6;
                        j4 = 0;
                        break;
                    case 2:
                        j2 = 3600000;
                        j3 = j2 + j6;
                        j4 = 0;
                        break;
                    case 3:
                        j3 = j6 + j5;
                        j4 = 0;
                        break;
                    case 4:
                        j2 = 604800000;
                        j3 = j2 + j6;
                        j4 = 0;
                        break;
                    case 5:
                        GregorianCalendar gregorianCalendar = new GregorianCalendar();
                        gregorianCalendar.setTime(new Date(j6));
                        int i2 = gregorianCalendar.get(5);
                        int i3 = gregorianCalendar.get(12);
                        int i4 = gregorianCalendar.get(11);
                        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
                        gregorianCalendar2.setTime(new Date());
                        int i5 = gregorianCalendar2.get(2);
                        int i6 = i5 < 11 ? i5 + 1 : 0;
                        gregorianCalendar2.set(1, gregorianCalendar2.get(1) + (i6 == 0 ? 1 : 0));
                        gregorianCalendar2.set(2, i6);
                        gregorianCalendar2.set(5, Math.min(i2, gregorianCalendar2.getActualMaximum(5)));
                        gregorianCalendar2.set(11, i4);
                        gregorianCalendar2.set(12, i3);
                        gregorianCalendar2.set(13, 0);
                        j3 = gregorianCalendar2.getTimeInMillis();
                        j4 = 0;
                        break;
                    default:
                        j3 = 0;
                        j4 = 0;
                        break;
                }
                if (j3 != j4) {
                    Log.d(RNPushNotification.LOG_TAG, String.format("Repeating notification with id %s at time %s", bundle.getString("id"), Long.toString(j3)));
                    bundle.putDouble("fireDate", j3);
                    v(bundle);
                }
            }
        }
    }

    private PendingIntent z(Bundle bundle) {
        try {
            int parseInt = Integer.parseInt(bundle.getString("id"));
            Intent intent = new Intent(this.a, g.class);
            intent.putExtra("notificationId", parseInt);
            intent.putExtras(bundle);
            return PendingIntent.getBroadcast(this.a, parseInt, intent, 134217728);
        } catch (Exception e2) {
            Log.e(RNPushNotification.LOG_TAG, "Unable to parse Notification ID", e2);
            return null;
        }
    }

    public void a() {
        Log.i(RNPushNotification.LOG_TAG, "Cancelling all notifications");
        for (String str : this.f4478c.getAll().keySet()) {
            c(str);
        }
    }

    public void b(ReadableMap readableMap) {
        for (String str : this.f4478c.getAll().keySet()) {
            try {
                String string = this.f4478c.getString(str, null);
                if (string != null && b.a(string).i(readableMap)) {
                    c(str);
                }
            } catch (JSONException e2) {
                Log.w(RNPushNotification.LOG_TAG, "Problem dealing with scheduled notification " + str, e2);
            }
        }
    }

    public boolean d(String str) {
        NotificationManager t;
        NotificationChannel notificationChannel;
        return Build.VERSION.SDK_INT >= 26 && (t = t()) != null && (notificationChannel = t.getNotificationChannel(str)) != null && notificationChannel.getImportance() == 0;
    }

    public boolean e(String str) {
        NotificationManager t;
        return (Build.VERSION.SDK_INT < 26 || (t = t()) == null || t.getNotificationChannel(str) == null) ? false : true;
    }

    public void g(ReadableArray readableArray) {
        NotificationManager t = t();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            String string = readableArray.getString(i2);
            Log.i(RNPushNotification.LOG_TAG, "Removing notification with id " + string);
            t.cancel(Integer.parseInt(string));
        }
    }

    public void h(String str, int i2) {
        Log.i(RNPushNotification.LOG_TAG, "Clearing notification: " + i2);
        NotificationManager t = t();
        if (str != null) {
            t.cancel(str, i2);
        } else {
            t.cancel(i2);
        }
    }

    public void i() {
        Log.i(RNPushNotification.LOG_TAG, "Clearing alerts from the notification centre");
        t().cancelAll();
    }

    public boolean j(ReadableMap readableMap) {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        String string = readableMap.getString("channelId");
        String string2 = readableMap.getString("channelName");
        String string3 = readableMap.hasKey("channelDescription") ? readableMap.getString("channelDescription") : "";
        String string4 = readableMap.hasKey("soundName") ? readableMap.getString("soundName") : CookieSpecs.DEFAULT;
        int i2 = readableMap.hasKey("importance") ? readableMap.getInt("importance") : 4;
        if (readableMap.hasKey("vibrate") && readableMap.getBoolean("vibrate")) {
            z = true;
        }
        return f(t(), string, string2, string3, p(string4), i2, z ? new long[]{0, 300} : null);
    }

    public void k(String str) {
        NotificationManager t;
        if (Build.VERSION.SDK_INT >= 26 && (t = t()) != null) {
            t.deleteNotificationChannel(str);
        }
    }

    public WritableArray m() {
        StatusBarNotification[] activeNotifications = t().getActiveNotifications();
        Log.i(RNPushNotification.LOG_TAG, "Found " + activeNotifications.length + " delivered notifications");
        WritableArray createArray = Arguments.createArray();
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            Notification notification = statusBarNotification.getNotification();
            Bundle bundle = notification.extras;
            WritableMap createMap = Arguments.createMap();
            createMap.putString("identifier", "" + statusBarNotification.getId());
            createMap.putString(MessageBundle.TITLE_ENTRY, bundle.getString("android.title"));
            createMap.putString("body", bundle.getString("android.text"));
            createMap.putString("tag", statusBarNotification.getTag());
            createMap.putString("group", notification.getGroup());
            createArray.pushMap(createMap);
        }
        return createArray;
    }

    public Class n() {
        try {
            return Class.forName(this.a.getPackageManager().getLaunchIntentForPackage(this.a.getPackageName()).getComponent().getClassName());
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public WritableArray o() {
        WritableArray createArray = Arguments.createArray();
        for (Map.Entry<String, ?> entry : this.f4478c.getAll().entrySet()) {
            try {
                b a2 = b.a(entry.getValue().toString());
                WritableMap createMap = Arguments.createMap();
                createMap.putString(MessageBundle.TITLE_ENTRY, a2.h());
                createMap.putString(ApiConstants.MESSAGE, a2.d());
                createMap.putString("number", a2.e());
                createMap.putDouble("date", a2.b());
                createMap.putString("id", a2.c());
                createMap.putString("repeatInterval", a2.f());
                createMap.putString("soundName", a2.g());
                createArray.pushMap(createMap);
            } catch (JSONException e2) {
                Log.e(RNPushNotification.LOG_TAG, e2.getMessage());
            }
        }
        return createArray;
    }

    public void q(Bundle bundle) {
        try {
            Intent intent = new Intent(this.a, Class.forName(this.a.getPackageManager().getLaunchIntentForPackage(this.a.getPackageName()).getComponent().getClassName()));
            if (bundle != null) {
                intent.putExtra("notification", bundle);
            }
            intent.addFlags(268435456);
            this.a.startActivity(intent);
        } catch (Exception e2) {
            Log.e(RNPushNotification.LOG_TAG, "Class not found", e2);
        }
    }

    public boolean r() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.a.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(this.a.getPackageName()) && runningAppProcessInfo.importance == 100 && runningAppProcessInfo.pkgList.length > 0) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<String> s() {
        NotificationManager t;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 26 && (t = t()) != null) {
            for (NotificationChannel notificationChannel : t.getNotificationChannels()) {
                arrayList.add(notificationChannel.getId());
            }
            return arrayList;
        }
        return arrayList;
    }

    public void v(Bundle bundle) {
        if (n() == null) {
            Log.e(RNPushNotification.LOG_TAG, "No activity class found for the scheduled notification");
        } else if (bundle.getString(ApiConstants.MESSAGE) == null) {
            Log.e(RNPushNotification.LOG_TAG, "No message specified for the scheduled notification");
        } else if (bundle.getString("id") == null) {
            Log.e(RNPushNotification.LOG_TAG, "No notification ID specified for the scheduled notification");
        } else if (bundle.getDouble("fireDate") == 0.0d) {
            Log.e(RNPushNotification.LOG_TAG, "No date specified for the scheduled notification");
        } else {
            b bVar = new b(bundle);
            String c2 = bVar.c();
            Log.d(RNPushNotification.LOG_TAG, "Storing push notification with id " + c2);
            SharedPreferences.Editor edit = this.f4478c.edit();
            edit.putString(c2, bVar.k().toString());
            edit.apply();
            if (!this.f4478c.contains(c2)) {
                Log.e(RNPushNotification.LOG_TAG, "Failed to save " + c2);
            }
            w(bundle);
        }
    }

    public void w(Bundle bundle) {
        long j2 = (long) bundle.getDouble("fireDate");
        boolean z = bundle.getBoolean("allowWhileIdle");
        PendingIntent z2 = z(bundle);
        if (z2 == null) {
            return;
        }
        Log.d(RNPushNotification.LOG_TAG, String.format("Setting a notification with id %s at time %s", bundle.getString("id"), Long.toString(j2)));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19) {
            l().set(0, j2, z2);
        } else if (z && i2 >= 23) {
            l().setExactAndAllowWhileIdle(0, j2, z2);
        } else {
            l().setExact(0, j2, z2);
        }
    }

    public void x(Bundle bundle) {
        f fVar = new f(new a(bundle));
        fVar.f(this.a, bundle.getString("largeIconUrl"));
        fVar.d(this.a, bundle.getString("bigPictureUrl"));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:(72:228|229|230|(2:234|(2:236|(2:238|(2:240|(1:242)(1:243))(1:244))(1:245)))(1:246)|23|(2:25|(2:27|(4:29|(2:220|(66:34|(2:36|(1:38)(1:39))(1:216)|40|(1:42)|43|(1:45)|46|(1:48)|49|(4:51|(1:53)|54|(1:58))|59|(1:61)|62|63|(1:(1:214)(1:215))(1:67)|68|(1:72)|73|(3:75|(1:(1:210)(1:211))(1:79)|(47:84|(1:86)|87|(1:89)|90|(1:92)|(1:94)(1:208)|95|96|(1:98)|99|(31:104|(1:202)|108|(1:201)|112|(2:114|(1:116)(2:117|(1:119)))|120|(17:125|126|(4:128|(1:130)|131|(1:135))|136|(1:140)|141|142|143|(1:145)(1:187)|146|(3:148|(8:151|152|153|(1:155)|156|(2:158|159)(2:161|162)|160|149)|167)|168|(1:170)|171|(2:178|(1:180)(1:181))|175|177)|193|(1:195)(1:200)|196|(1:198)|199|126|(0)|136|(2:138|140)|141|142|143|(0)(0)|146|(0)|168|(0)|171|(1:173)|178|(0)(0)|175|177)|203|(1:205)(1:207)|206|(1:106)|202|108|(1:110)|201|112|(0)|120|(20:122|125|126|(0)|136|(0)|141|142|143|(0)(0)|146|(0)|168|(0)|171|(0)|178|(0)(0)|175|177)|193|(0)(0)|196|(0)|199|126|(0)|136|(0)|141|142|143|(0)(0)|146|(0)|168|(0)|171|(0)|178|(0)(0)|175|177))|212|(0)|87|(0)|90|(0)|(0)(0)|95|96|(0)|99|(34:101|104|(0)|202|108|(0)|201|112|(0)|120|(0)|193|(0)(0)|196|(0)|199|126|(0)|136|(0)|141|142|143|(0)(0)|146|(0)|168|(0)|171|(0)|178|(0)(0)|175|177)|203|(0)(0)|206|(0)|202|108|(0)|201|112|(0)|120|(0)|193|(0)(0)|196|(0)|199|126|(0)|136|(0)|141|142|143|(0)(0)|146|(0)|168|(0)|171|(0)|178|(0)(0)|175|177))|32|(0))(4:221|(2:223|(0))|32|(0)))(4:224|(2:226|(0))|32|(0)))(1:227)|217|40|(0)|43|(0)|46|(0)|49|(0)|59|(0)|62|63|(1:65)|(0)(0)|68|(2:70|72)|73|(0)|212|(0)|87|(0)|90|(0)|(0)(0)|95|96|(0)|99|(0)|203|(0)(0)|206|(0)|202|108|(0)|201|112|(0)|120|(0)|193|(0)(0)|196|(0)|199|126|(0)|136|(0)|141|142|143|(0)(0)|146|(0)|168|(0)|171|(0)|178|(0)(0)|175|177)|142|143|(0)(0)|146|(0)|168|(0)|171|(0)|178|(0)(0)|175|177) */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x039f, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x03a2, code lost:
        r11 = com.dieam.reactnativepushnotification.modules.RNPushNotification.LOG_TAG;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x03a4, code lost:
        android.util.Log.e(r11, "Exception while converting actions to JSON object.", r0);
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01aa A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01bb A[Catch: Exception -> 0x0469, TRY_ENTER, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01c8 A[Catch: Exception -> 0x0469, TRY_LEAVE, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01d4 A[Catch: Exception -> 0x0469, TRY_ENTER, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e2 A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x020e A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0220 A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x022e A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0240 A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0274 A[Catch: Exception -> 0x0469, TRY_ENTER, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x027e A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02ab A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02bc A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02f7 A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x030b A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0331 A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0365 A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x038e A[Catch: JSONException -> 0x039f, Exception -> 0x0469, TRY_LEAVE, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x042a A[Catch: Exception -> 0x0467, TryCatch #2 {Exception -> 0x0467, blocks: (B:222:0x03ab, B:224:0x03b1, B:225:0x03b5, B:227:0x03e9, B:228:0x03ec, B:230:0x03fa, B:234:0x0418, B:231:0x0409, B:233:0x040f, B:235:0x041f, B:237:0x042a, B:238:0x0436, B:240:0x043c, B:246:0x0463, B:242:0x0444, B:244:0x0456, B:245:0x0460, B:219:0x03a4, B:210:0x0386, B:212:0x038e), top: B:259:0x0386, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x043c A[Catch: Exception -> 0x0467, TryCatch #2 {Exception -> 0x0467, blocks: (B:222:0x03ab, B:224:0x03b1, B:225:0x03b5, B:227:0x03e9, B:228:0x03ec, B:230:0x03fa, B:234:0x0418, B:231:0x0409, B:233:0x040f, B:235:0x041f, B:237:0x042a, B:238:0x0436, B:240:0x043c, B:246:0x0463, B:242:0x0444, B:244:0x0456, B:245:0x0460, B:219:0x03a4, B:210:0x0386, B:212:0x038e), top: B:259:0x0386, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0456 A[Catch: Exception -> 0x0467, TryCatch #2 {Exception -> 0x0467, blocks: (B:222:0x03ab, B:224:0x03b1, B:225:0x03b5, B:227:0x03e9, B:228:0x03ec, B:230:0x03fa, B:234:0x0418, B:231:0x0409, B:233:0x040f, B:235:0x041f, B:237:0x042a, B:238:0x0436, B:240:0x043c, B:246:0x0463, B:242:0x0444, B:244:0x0456, B:245:0x0460, B:219:0x03a4, B:210:0x0386, B:212:0x038e), top: B:259:0x0386, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0460 A[Catch: Exception -> 0x0467, TryCatch #2 {Exception -> 0x0467, blocks: (B:222:0x03ab, B:224:0x03b1, B:225:0x03b5, B:227:0x03e9, B:228:0x03ec, B:230:0x03fa, B:234:0x0418, B:231:0x0409, B:233:0x040f, B:235:0x041f, B:237:0x042a, B:238:0x0436, B:240:0x043c, B:246:0x0463, B:242:0x0444, B:244:0x0456, B:245:0x0460, B:219:0x03a4, B:210:0x0386, B:212:0x038e), top: B:259:0x0386, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d8 A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012d A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016e A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x017c A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0184 A[Catch: Exception -> 0x0469, TryCatch #1 {Exception -> 0x0469, blocks: (B:21:0x007b, B:22:0x0083, B:55:0x00d0, B:57:0x00d8, B:84:0x0125, B:86:0x012d, B:87:0x0133, B:89:0x016e, B:92:0x017c, B:95:0x0184, B:97:0x018c, B:98:0x018f, B:100:0x0195, B:102:0x019b, B:103:0x01a2, B:105:0x01aa, B:106:0x01b1, B:109:0x01bb, B:111:0x01c1, B:118:0x01d4, B:121:0x01dd, B:123:0x01e2, B:125:0x01ea, B:127:0x01f0, B:135:0x0205, B:138:0x020e, B:139:0x0211, B:141:0x0220, B:142:0x0223, B:146:0x022e, B:148:0x0249, B:151:0x0274, B:152:0x0277, B:154:0x027e, B:167:0x02a3, B:169:0x02ab, B:174:0x02bc, B:176:0x02cf, B:179:0x02da, B:180:0x02dd, B:182:0x02f7, B:196:0x0331, B:198:0x0339, B:199:0x033c, B:201:0x0349, B:203:0x0351, B:204:0x0358, B:206:0x0365, B:208:0x036d, B:209:0x0374, B:210:0x0386, B:212:0x038e, B:186:0x0303, B:188:0x030b, B:193:0x031f, B:171:0x02b1, B:166:0x02a0, B:158:0x0287, B:162:0x0293, B:147:0x0240, B:129:0x01f7, B:113:0x01c8, B:64:0x00f4, B:67:0x00fe, B:70:0x0108, B:24:0x0087, B:27:0x008f, B:30:0x0099, B:33:0x00a3, B:36:0x00ad), top: B:257:0x007b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y(android.os.Bundle r26, android.graphics.Bitmap r27, android.graphics.Bitmap r28) {
        /*
            Method dump skipped, instructions count: 1164
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dieam.reactnativepushnotification.modules.d.y(android.os.Bundle, android.graphics.Bitmap, android.graphics.Bitmap):void");
    }
}