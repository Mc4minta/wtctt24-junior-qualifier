package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.a;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class kc extends j1 implements h9 {
    public kc() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static h9 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof h9) {
            return (h9) queryLocalInterface;
        }
        return new jb(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.j1
    protected final boolean n(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        rc tcVar;
        rc rcVar;
        rc rcVar2 = null;
        rc rcVar3 = null;
        rc rcVar4 = null;
        sc scVar = null;
        sc scVar2 = null;
        sc scVar3 = null;
        rc rcVar5 = null;
        rc rcVar6 = null;
        rc rcVar7 = null;
        rc rcVar8 = null;
        rc rcVar9 = null;
        rc rcVar10 = null;
        xc xcVar = null;
        rc rcVar11 = null;
        rc rcVar12 = null;
        rc rcVar13 = null;
        rc rcVar14 = null;
        switch (i2) {
            case 1:
                initialize(a.AbstractBinderC0144a.p(parcel.readStrongBinder()), (zc) r.a(parcel, zc.CREATOR), parcel.readLong());
                break;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) r.a(parcel, Bundle.CREATOR), r.e(parcel), r.e(parcel), parcel.readLong());
                break;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) r.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    rcVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface instanceof rc) {
                        tcVar = (rc) queryLocalInterface;
                    } else {
                        tcVar = new tc(readStrongBinder);
                    }
                    rcVar = tcVar;
                }
                logEventAndBundle(readString, readString2, bundle, rcVar, parcel.readLong());
                break;
            case 4:
                setUserProperty(parcel.readString(), parcel.readString(), a.AbstractBinderC0144a.p(parcel.readStrongBinder()), r.e(parcel), parcel.readLong());
                break;
            case 5:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                boolean e2 = r.e(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface2 instanceof rc) {
                        rcVar2 = (rc) queryLocalInterface2;
                    } else {
                        rcVar2 = new tc(readStrongBinder2);
                    }
                }
                getUserProperties(readString3, readString4, e2, rcVar2);
                break;
            case 6:
                String readString5 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface3 instanceof rc) {
                        rcVar14 = (rc) queryLocalInterface3;
                    } else {
                        rcVar14 = new tc(readStrongBinder3);
                    }
                }
                getMaxUserProperties(readString5, rcVar14);
                break;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                break;
            case 8:
                setConditionalUserProperty((Bundle) r.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) r.a(parcel, Bundle.CREATOR));
                break;
            case 10:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface4 instanceof rc) {
                        rcVar13 = (rc) queryLocalInterface4;
                    } else {
                        rcVar13 = new tc(readStrongBinder4);
                    }
                }
                getConditionalUserProperties(readString6, readString7, rcVar13);
                break;
            case 11:
                setMeasurementEnabled(r.e(parcel), parcel.readLong());
                break;
            case 12:
                resetAnalyticsData(parcel.readLong());
                break;
            case 13:
                setMinimumSessionDuration(parcel.readLong());
                break;
            case 14:
                setSessionTimeoutDuration(parcel.readLong());
                break;
            case 15:
                setCurrentScreen(a.AbstractBinderC0144a.p(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                break;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface5 instanceof rc) {
                        rcVar12 = (rc) queryLocalInterface5;
                    } else {
                        rcVar12 = new tc(readStrongBinder5);
                    }
                }
                getCurrentScreenName(rcVar12);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface6 instanceof rc) {
                        rcVar11 = (rc) queryLocalInterface6;
                    } else {
                        rcVar11 = new tc(readStrongBinder6);
                    }
                }
                getCurrentScreenClass(rcVar11);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (queryLocalInterface7 instanceof xc) {
                        xcVar = (xc) queryLocalInterface7;
                    } else {
                        xcVar = new wc(readStrongBinder7);
                    }
                }
                setInstanceIdProvider(xcVar);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface8 instanceof rc) {
                        rcVar10 = (rc) queryLocalInterface8;
                    } else {
                        rcVar10 = new tc(readStrongBinder8);
                    }
                }
                getCachedAppInstanceId(rcVar10);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface9 instanceof rc) {
                        rcVar9 = (rc) queryLocalInterface9;
                    } else {
                        rcVar9 = new tc(readStrongBinder9);
                    }
                }
                getAppInstanceId(rcVar9);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface10 instanceof rc) {
                        rcVar8 = (rc) queryLocalInterface10;
                    } else {
                        rcVar8 = new tc(readStrongBinder10);
                    }
                }
                getGmpAppId(rcVar8);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface11 instanceof rc) {
                        rcVar7 = (rc) queryLocalInterface11;
                    } else {
                        rcVar7 = new tc(readStrongBinder11);
                    }
                }
                generateEventId(rcVar7);
                break;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 25:
                onActivityStarted(a.AbstractBinderC0144a.p(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 26:
                onActivityStopped(a.AbstractBinderC0144a.p(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 27:
                onActivityCreated(a.AbstractBinderC0144a.p(parcel.readStrongBinder()), (Bundle) r.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 28:
                onActivityDestroyed(a.AbstractBinderC0144a.p(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 29:
                onActivityPaused(a.AbstractBinderC0144a.p(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 30:
                onActivityResumed(a.AbstractBinderC0144a.p(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 31:
                com.google.android.gms.dynamic.a p = a.AbstractBinderC0144a.p(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface12 instanceof rc) {
                        rcVar6 = (rc) queryLocalInterface12;
                    } else {
                        rcVar6 = new tc(readStrongBinder12);
                    }
                }
                onActivitySaveInstanceState(p, rcVar6, parcel.readLong());
                break;
            case 32:
                Bundle bundle2 = (Bundle) r.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface13 instanceof rc) {
                        rcVar5 = (rc) queryLocalInterface13;
                    } else {
                        rcVar5 = new tc(readStrongBinder13);
                    }
                }
                performAction(bundle2, rcVar5, parcel.readLong());
                break;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), a.AbstractBinderC0144a.p(parcel.readStrongBinder()), a.AbstractBinderC0144a.p(parcel.readStrongBinder()), a.AbstractBinderC0144a.p(parcel.readStrongBinder()));
                break;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface14 instanceof sc) {
                        scVar3 = (sc) queryLocalInterface14;
                    } else {
                        scVar3 = new uc(readStrongBinder14);
                    }
                }
                setEventInterceptor(scVar3);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface15 instanceof sc) {
                        scVar2 = (sc) queryLocalInterface15;
                    } else {
                        scVar2 = new uc(readStrongBinder15);
                    }
                }
                registerOnMeasurementEventListener(scVar2);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface16 instanceof sc) {
                        scVar = (sc) queryLocalInterface16;
                    } else {
                        scVar = new uc(readStrongBinder16);
                    }
                }
                unregisterOnMeasurementEventListener(scVar);
                break;
            case 37:
                initForTests(r.f(parcel));
                break;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface17 instanceof rc) {
                        rcVar4 = (rc) queryLocalInterface17;
                    } else {
                        rcVar4 = new tc(readStrongBinder17);
                    }
                }
                getTestFlag(rcVar4, parcel.readInt());
                break;
            case 39:
                setDataCollectionEnabled(r.e(parcel));
                break;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface18 instanceof rc) {
                        rcVar3 = (rc) queryLocalInterface18;
                    } else {
                        rcVar3 = new tc(readStrongBinder18);
                    }
                }
                isDataCollectionEnabled(rcVar3);
                break;
            case 41:
            default:
                return false;
            case 42:
                setDefaultEventParameters((Bundle) r.a(parcel, Bundle.CREATOR));
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}