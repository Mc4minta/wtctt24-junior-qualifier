package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public interface h9 extends IInterface {
    void beginAdUnitExposure(String str, long j2) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void endAdUnitExposure(String str, long j2) throws RemoteException;

    void generateEventId(rc rcVar) throws RemoteException;

    void getAppInstanceId(rc rcVar) throws RemoteException;

    void getCachedAppInstanceId(rc rcVar) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, rc rcVar) throws RemoteException;

    void getCurrentScreenClass(rc rcVar) throws RemoteException;

    void getCurrentScreenName(rc rcVar) throws RemoteException;

    void getGmpAppId(rc rcVar) throws RemoteException;

    void getMaxUserProperties(String str, rc rcVar) throws RemoteException;

    void getTestFlag(rc rcVar, int i2) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z, rc rcVar) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(com.google.android.gms.dynamic.a aVar, zc zcVar, long j2) throws RemoteException;

    void isDataCollectionEnabled(rc rcVar) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, rc rcVar, long j2) throws RemoteException;

    void logHealthData(int i2, String str, com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2, com.google.android.gms.dynamic.a aVar3) throws RemoteException;

    void onActivityCreated(com.google.android.gms.dynamic.a aVar, Bundle bundle, long j2) throws RemoteException;

    void onActivityDestroyed(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException;

    void onActivityPaused(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException;

    void onActivityResumed(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException;

    void onActivitySaveInstanceState(com.google.android.gms.dynamic.a aVar, rc rcVar, long j2) throws RemoteException;

    void onActivityStarted(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException;

    void onActivityStopped(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException;

    void performAction(Bundle bundle, rc rcVar, long j2) throws RemoteException;

    void registerOnMeasurementEventListener(sc scVar) throws RemoteException;

    void resetAnalyticsData(long j2) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j2) throws RemoteException;

    void setCurrentScreen(com.google.android.gms.dynamic.a aVar, String str, String str2, long j2) throws RemoteException;

    void setDataCollectionEnabled(boolean z) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(sc scVar) throws RemoteException;

    void setInstanceIdProvider(xc xcVar) throws RemoteException;

    void setMeasurementEnabled(boolean z, long j2) throws RemoteException;

    void setMinimumSessionDuration(long j2) throws RemoteException;

    void setSessionTimeoutDuration(long j2) throws RemoteException;

    void setUserId(String str, long j2) throws RemoteException;

    void setUserProperty(String str, String str2, com.google.android.gms.dynamic.a aVar, boolean z, long j2) throws RemoteException;

    void unregisterOnMeasurementEventListener(sc scVar) throws RemoteException;
}