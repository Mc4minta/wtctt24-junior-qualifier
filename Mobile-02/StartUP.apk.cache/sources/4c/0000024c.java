package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.j;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatBuilder.java */
/* loaded from: classes.dex */
class k implements i {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final Notification.Builder f1448b;

    /* renamed from: c  reason: collision with root package name */
    private final j.e f1449c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f1450d;

    /* renamed from: e  reason: collision with root package name */
    private RemoteViews f1451e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Bundle> f1452f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f1453g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    private int f1454h;

    /* renamed from: i  reason: collision with root package name */
    private RemoteViews f1455i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j.e eVar) {
        Icon icon;
        List<String> list;
        List<String> e2;
        this.f1449c = eVar;
        this.a = eVar.a;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f1448b = new Notification.Builder(eVar.a, eVar.K);
        } else {
            this.f1448b = new Notification.Builder(eVar.a);
        }
        Notification notification = eVar.S;
        this.f1448b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f1441i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f1437e).setContentText(eVar.f1438f).setContentInfo(eVar.f1443k).setContentIntent(eVar.f1439g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f1440h, (notification.flags & 128) != 0).setLargeIcon(eVar.f1442j).setNumber(eVar.f1444l).setProgress(eVar.t, eVar.u, eVar.v);
        if (i2 < 21) {
            this.f1448b.setSound(notification.sound, notification.audioStreamType);
        }
        if (i2 >= 16) {
            this.f1448b.setSubText(eVar.q).setUsesChronometer(eVar.o).setPriority(eVar.m);
            Iterator<j.a> it = eVar.f1434b.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            Bundle bundle = eVar.D;
            if (bundle != null) {
                this.f1453g.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (eVar.z) {
                    this.f1453g.putBoolean("android.support.localOnly", true);
                }
                String str = eVar.w;
                if (str != null) {
                    this.f1453g.putString("android.support.groupKey", str);
                    if (eVar.x) {
                        this.f1453g.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f1453g.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = eVar.y;
                if (str2 != null) {
                    this.f1453g.putString("android.support.sortKey", str2);
                }
            }
            this.f1450d = eVar.H;
            this.f1451e = eVar.I;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 17) {
            this.f1448b.setShowWhen(eVar.n);
        }
        if (i3 >= 19 && i3 < 21 && (e2 = e(g(eVar.f1435c), eVar.V)) != null && !e2.isEmpty()) {
            this.f1453g.putStringArray("android.people", (String[]) e2.toArray(new String[e2.size()]));
        }
        if (i3 >= 20) {
            this.f1448b.setLocalOnly(eVar.z).setGroup(eVar.w).setGroupSummary(eVar.x).setSortKey(eVar.y);
            this.f1454h = eVar.P;
        }
        if (i3 >= 21) {
            this.f1448b.setCategory(eVar.C).setColor(eVar.E).setVisibility(eVar.F).setPublicVersion(eVar.G).setSound(notification.sound, notification.audioAttributes);
            if (i3 < 28) {
                list = e(g(eVar.f1435c), eVar.V);
            } else {
                list = eVar.V;
            }
            if (list != null && !list.isEmpty()) {
                for (String str3 : list) {
                    this.f1448b.addPerson(str3);
                }
            }
            this.f1455i = eVar.J;
            if (eVar.f1436d.size() > 0) {
                Bundle bundle2 = eVar.d().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i4 = 0; i4 < eVar.f1436d.size(); i4++) {
                    bundle4.putBundle(Integer.toString(i4), l.b(eVar.f1436d.get(i4)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                eVar.d().putBundle("android.car.EXTENSIONS", bundle2);
                this.f1453g.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 23 && (icon = eVar.U) != null) {
            this.f1448b.setSmallIcon(icon);
        }
        if (i5 >= 24) {
            this.f1448b.setExtras(eVar.D).setRemoteInputHistory(eVar.s);
            RemoteViews remoteViews = eVar.H;
            if (remoteViews != null) {
                this.f1448b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = eVar.I;
            if (remoteViews2 != null) {
                this.f1448b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = eVar.J;
            if (remoteViews3 != null) {
                this.f1448b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i5 >= 26) {
            this.f1448b.setBadgeIconType(eVar.L).setSettingsText(eVar.r).setShortcutId(eVar.M).setTimeoutAfter(eVar.O).setGroupAlertBehavior(eVar.P);
            if (eVar.B) {
                this.f1448b.setColorized(eVar.A);
            }
            if (!TextUtils.isEmpty(eVar.K)) {
                this.f1448b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i5 >= 28) {
            Iterator<n> it2 = eVar.f1435c.iterator();
            while (it2.hasNext()) {
                this.f1448b.addPerson(it2.next().h());
            }
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            this.f1448b.setAllowSystemGeneratedContextualActions(eVar.Q);
            this.f1448b.setBubbleMetadata(j.d.a(eVar.R));
            if (eVar.N != null) {
                throw null;
            }
        }
        if (eVar.T) {
            if (this.f1449c.x) {
                this.f1454h = 2;
            } else {
                this.f1454h = 1;
            }
            this.f1448b.setVibrate(null);
            this.f1448b.setSound(null);
            int i7 = notification.defaults & (-2);
            notification.defaults = i7;
            int i8 = i7 & (-3);
            notification.defaults = i8;
            this.f1448b.setDefaults(i8);
            if (i6 >= 26) {
                if (TextUtils.isEmpty(this.f1449c.w)) {
                    this.f1448b.setGroup("silent");
                }
                this.f1448b.setGroupAlertBehavior(this.f1454h);
            }
        }
    }

    private void b(j.a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 20) {
            if (i2 >= 16) {
                this.f1452f.add(l.f(this.f1448b, aVar));
                return;
            }
            return;
        }
        IconCompat e2 = aVar.e();
        if (i2 >= 23) {
            builder = new Notification.Action.Builder(e2 != null ? e2.p() : null, aVar.i(), aVar.a());
        } else {
            builder = new Notification.Action.Builder(e2 != null ? e2.e() : 0, aVar.i(), aVar.a());
        }
        if (aVar.f() != null) {
            for (RemoteInput remoteInput : o.b(aVar.f())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            builder.setAllowGeneratedReplies(aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.g());
        if (i3 >= 28) {
            builder.setSemanticAction(aVar.g());
        }
        if (i3 >= 29) {
            builder.setContextual(aVar.j());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
        builder.addExtras(bundle);
        this.f1448b.addAction(builder.build());
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        c.e.b bVar = new c.e.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> g(List<n> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (n nVar : list) {
            arrayList.add(nVar.g());
        }
        return arrayList;
    }

    private void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i2 = notification.defaults & (-2);
        notification.defaults = i2;
        notification.defaults = i2 & (-3);
    }

    @Override // androidx.core.app.i
    public Notification.Builder a() {
        return this.f1448b;
    }

    public Notification c() {
        Bundle a;
        RemoteViews f2;
        RemoteViews d2;
        j.f fVar = this.f1449c.p;
        if (fVar != null) {
            fVar.b(this);
        }
        RemoteViews e2 = fVar != null ? fVar.e(this) : null;
        Notification d3 = d();
        if (e2 != null) {
            d3.contentView = e2;
        } else {
            RemoteViews remoteViews = this.f1449c.H;
            if (remoteViews != null) {
                d3.contentView = remoteViews;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16 && fVar != null && (d2 = fVar.d(this)) != null) {
            d3.bigContentView = d2;
        }
        if (i2 >= 21 && fVar != null && (f2 = this.f1449c.p.f(this)) != null) {
            d3.headsUpContentView = f2;
        }
        if (i2 >= 16 && fVar != null && (a = j.a(d3)) != null) {
            fVar.a(a);
        }
        return d3;
    }

    protected Notification d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.f1448b.build();
        }
        if (i2 >= 24) {
            Notification build = this.f1448b.build();
            if (this.f1454h != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f1454h == 2) {
                    h(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f1454h == 1) {
                    h(build);
                }
            }
            return build;
        } else if (i2 >= 21) {
            this.f1448b.setExtras(this.f1453g);
            Notification build2 = this.f1448b.build();
            RemoteViews remoteViews = this.f1450d;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f1451e;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f1455i;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f1454h != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.f1454h == 2) {
                    h(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f1454h == 1) {
                    h(build2);
                }
            }
            return build2;
        } else if (i2 >= 20) {
            this.f1448b.setExtras(this.f1453g);
            Notification build3 = this.f1448b.build();
            RemoteViews remoteViews4 = this.f1450d;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f1451e;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f1454h != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.f1454h == 2) {
                    h(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f1454h == 1) {
                    h(build3);
                }
            }
            return build3;
        } else if (i2 >= 19) {
            SparseArray<Bundle> a = l.a(this.f1452f);
            if (a != null) {
                this.f1453g.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f1448b.setExtras(this.f1453g);
            Notification build4 = this.f1448b.build();
            RemoteViews remoteViews6 = this.f1450d;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f1451e;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i2 >= 16) {
            Notification build5 = this.f1448b.build();
            Bundle a2 = j.a(build5);
            Bundle bundle = new Bundle(this.f1453g);
            for (String str : this.f1453g.keySet()) {
                if (a2.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a2.putAll(bundle);
            SparseArray<Bundle> a3 = l.a(this.f1452f);
            if (a3 != null) {
                j.a(build5).putSparseParcelableArray("android.support.actionExtras", a3);
            }
            RemoteViews remoteViews8 = this.f1450d;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f1451e;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        } else {
            return this.f1448b.getNotification();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context f() {
        return this.a;
    }
}