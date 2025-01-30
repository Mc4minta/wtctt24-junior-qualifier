package com.bugsnag.android.ndk;

import android.os.Build;
import android.util.Log;
import com.bugsnag.android.Breadcrumb;
import com.bugsnag.android.NativeInterface;
import com.bugsnag.android.s;
import com.bugsnag.android.s0;
import java.io.File;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class NativeBridge implements Observer {
    private static final String LOG_TAG = "BugsnagNDK:NativeBridge";
    private static final int METADATA_KEY = 1;
    private static final int METADATA_SECTION = 0;
    private static final int METADATA_VALUE = 2;
    private boolean loggingEnabled;
    private final String reportDirectory;
    private static final Lock lock = new ReentrantLock();
    private static final AtomicBoolean installed = new AtomicBoolean(false);

    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NativeInterface.c.values().length];
            a = iArr;
            try {
                iArr[NativeInterface.c.INSTALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NativeInterface.c.DELIVER_PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NativeInterface.c.ADD_BREADCRUMB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[NativeInterface.c.ADD_METADATA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[NativeInterface.c.CLEAR_BREADCRUMBS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[NativeInterface.c.CLEAR_METADATA_TAB.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[NativeInterface.c.NOTIFY_HANDLED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[NativeInterface.c.NOTIFY_UNHANDLED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[NativeInterface.c.REMOVE_METADATA.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[NativeInterface.c.START_SESSION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[NativeInterface.c.STOP_SESSION.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[NativeInterface.c.UPDATE_APP_VERSION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[NativeInterface.c.UPDATE_BUILD_UUID.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[NativeInterface.c.UPDATE_CONTEXT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[NativeInterface.c.UPDATE_IN_FOREGROUND.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[NativeInterface.c.UPDATE_LOW_MEMORY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[NativeInterface.c.UPDATE_METADATA.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[NativeInterface.c.UPDATE_ORIENTATION.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[NativeInterface.c.UPDATE_RELEASE_STAGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[NativeInterface.c.UPDATE_USER_ID.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[NativeInterface.c.UPDATE_USER_NAME.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[NativeInterface.c.UPDATE_USER_EMAIL.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    public NativeBridge() {
        this.loggingEnabled = true;
        this.loggingEnabled = NativeInterface.getLoggingEnabled();
        String nativeReportPath = NativeInterface.getNativeReportPath();
        this.reportDirectory = nativeReportPath;
        File file = new File(nativeReportPath);
        if (file.exists() || file.mkdirs()) {
            return;
        }
        warn("The native reporting directory cannot be created.");
    }

    public static native void addBreadcrumb(String str, String str2, String str3, Object obj);

    public static native void addHandledEvent();

    public static native void addMetadataBoolean(String str, String str2, boolean z);

    public static native void addMetadataDouble(String str, String str2, double d2);

    public static native void addMetadataString(String str, String str2, String str3);

    public static native void addUnhandledEvent();

    public static native void clearBreadcrumbs();

    public static native void clearMetadataTab(String str);

    private void deliverPendingReports() {
        lock.lock();
        try {
            try {
                File file = new File(this.reportDirectory);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            deliverReportAtPath(file2.getAbsolutePath());
                        }
                    }
                } else {
                    warn("Report directory does not exist, cannot read pending reports");
                }
            } catch (Exception e2) {
                warn("Failed to parse/write pending reports: " + e2);
            }
        } finally {
            lock.unlock();
        }
    }

    public static native void deliverReportAtPath(String str);

    private void handleAddBreadcrumb(Object obj) {
        if (obj instanceof Breadcrumb) {
            Breadcrumb breadcrumb = (Breadcrumb) obj;
            addBreadcrumb(breadcrumb.getName(), breadcrumb.getType().toString(), breadcrumb.getTimestamp(), breadcrumb.getMetadata());
            return;
        }
        warn("Attempted to add non-breadcrumb: " + obj);
    }

    private void handleAddMetadata(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() == 3 && (list.get(0) instanceof String) && (list.get(1) instanceof String)) {
                if (list.get(2) instanceof String) {
                    addMetadataString((String) list.get(0), (String) list.get(1), (String) list.get(2));
                    return;
                } else if (list.get(2) instanceof Boolean) {
                    addMetadataBoolean((String) list.get(0), (String) list.get(1), ((Boolean) list.get(2)).booleanValue());
                    return;
                } else if (list.get(2) instanceof Number) {
                    addMetadataDouble((String) list.get(0), (String) list.get(1), ((Number) list.get(2)).doubleValue());
                    return;
                }
            } else if (list.size() == 2) {
                removeMetadata((String) list.get(0), (String) list.get(1));
                return;
            }
        }
        warn("ADD_METADATA object is invalid: " + obj);
    }

    private void handleAppVersionChange(Object obj) {
        if (obj instanceof String) {
            updateAppVersion((String) obj);
            return;
        }
        warn("UPDATE_APP_VERSION object is invalid: " + obj);
    }

    private void handleBuildUUIDChange(Object obj) {
        if (obj == null) {
            updateBuildUUID("");
        } else if (obj instanceof String) {
            updateBuildUUID((String) obj);
        } else {
            warn("UPDATE_BUILD_UUID object is invalid: " + obj);
        }
    }

    private void handleClearMetadataTab(Object obj) {
        if (obj instanceof String) {
            clearMetadataTab((String) obj);
            return;
        }
        warn("CLEAR_METADATA_TAB object is invalid: " + obj);
    }

    private void handleContextChange(Object obj) {
        if (obj == null) {
            updateContext("");
        } else if (obj instanceof String) {
            updateContext((String) obj);
        } else {
            warn("UPDATE_CONTEXT object is invalid: " + obj);
        }
    }

    private void handleForegroundActivityChange(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() == 2) {
                updateInForeground(((Boolean) list.get(0)).booleanValue(), (String) list.get(1));
                return;
            }
        }
        warn("UPDATE_IN_FOREGROUND object is invalid: " + obj);
    }

    private void handleInstallMessage(Object obj) {
        Lock lock2 = lock;
        lock2.lock();
        try {
            AtomicBoolean atomicBoolean = installed;
            if (atomicBoolean.get()) {
                warn("Received duplicate setup message with arg: " + obj);
            } else if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 0 && (list.get(0) instanceof s)) {
                    install(this.reportDirectory + UUID.randomUUID().toString() + ".crash", ((s) list.get(0)).n(), Build.VERSION.SDK_INT, is32bit());
                    atomicBoolean.set(true);
                }
            } else {
                warn("Received install message with incorrect arg: " + obj);
            }
            lock2.unlock();
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    private void handleLowMemoryChange(Object obj) {
        if (obj instanceof Boolean) {
            updateLowMemory(((Boolean) obj).booleanValue());
            return;
        }
        warn("UPDATE_LOW_MEMORY object is invalid: " + obj);
    }

    private void handleOrientationChange(Object obj) {
        if (obj instanceof Integer) {
            updateOrientation(((Integer) obj).intValue());
        } else if (obj == null) {
            warn("UPDATE_ORIENTATION object is null");
        } else {
            warn("UPDATE_ORIENTATION object is invalid: " + obj);
        }
    }

    private void handleReleaseStageChange(Object obj) {
        if (obj instanceof String) {
            updateReleaseStage((String) obj);
            return;
        }
        warn("UPDATE_RELEASE_STAGE object is invalid: " + obj);
    }

    private void handleRemoveMetadata(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() == 2) {
                removeMetadata((String) list.get(0), (String) list.get(1));
                return;
            }
        }
        warn("REMOVE_METADATA object is invalid: " + obj);
    }

    private void handleStartSession(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() == 4) {
                Object obj2 = list.get(0);
                Object obj3 = list.get(1);
                Object obj4 = list.get(2);
                Object obj5 = list.get(3);
                if ((obj2 instanceof String) && (obj3 instanceof String) && (obj4 instanceof Integer) && (obj5 instanceof Integer)) {
                    startedSession((String) obj2, (String) obj3, ((Integer) obj4).intValue(), ((Integer) obj5).intValue());
                    return;
                }
            }
        }
        warn("START_SESSION object is invalid: " + obj);
    }

    private void handleStopSession() {
        stoppedSession();
    }

    private void handleUpdateMetadata(Object obj) {
        if (obj instanceof s0) {
            updateMetadata(obj);
            return;
        }
        warn("UPDATE_METADATA object is invalid: " + obj);
    }

    private void handleUserEmailChange(Object obj) {
        if (obj == null) {
            updateUserEmail("");
        } else if (obj instanceof String) {
            updateUserEmail((String) obj);
        } else {
            warn("UPDATE_USER_EMAIL object is invalid: " + obj);
        }
    }

    private void handleUserIdChange(Object obj) {
        if (obj == null) {
            updateUserId("");
        } else if (obj instanceof String) {
            updateUserId((String) obj);
        } else {
            warn("UPDATE_USER_ID object is invalid: " + obj);
        }
    }

    private void handleUserNameChange(Object obj) {
        if (obj == null) {
            updateUserName("");
        } else if (obj instanceof String) {
            updateUserName((String) obj);
        } else {
            warn("UPDATE_USER_NAME object is invalid: " + obj);
        }
    }

    public static native void install(String str, boolean z, int i2, boolean z2);

    private boolean is32bit() {
        for (String str : NativeInterface.getCpuAbi()) {
            if (str.contains("64")) {
                return false;
            }
        }
        return true;
    }

    private NativeInterface.b parseMessage(Object obj) {
        if (!(obj instanceof NativeInterface.b)) {
            if (obj == null) {
                warn("Received observable update with null Message");
            } else {
                warn("Received observable update object which is not instance of Message: " + obj.getClass());
            }
            return null;
        }
        NativeInterface.b bVar = (NativeInterface.b) obj;
        if (bVar.a == NativeInterface.c.INSTALL || installed.get()) {
            return bVar;
        }
        warn("Received message before INSTALL: " + bVar.a);
        return null;
    }

    public static native void removeMetadata(String str, String str2);

    public static native void startedSession(String str, String str2, int i2, int i3);

    public static native void stoppedSession();

    public static native void updateAppVersion(String str);

    public static native void updateBuildUUID(String str);

    public static native void updateContext(String str);

    public static native void updateInForeground(boolean z, String str);

    public static native void updateLowMemory(boolean z);

    public static native void updateMetadata(Object obj);

    public static native void updateOrientation(int i2);

    public static native void updateReleaseStage(String str);

    public static native void updateUserEmail(String str);

    public static native void updateUserId(String str);

    public static native void updateUserName(String str);

    private void warn(String str) {
        if (this.loggingEnabled) {
            Log.w(LOG_TAG, str);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        NativeInterface.b parseMessage = parseMessage(obj);
        if (parseMessage == null) {
            return;
        }
        Object obj2 = parseMessage.f3577b;
        switch (a.a[parseMessage.a.ordinal()]) {
            case 1:
                handleInstallMessage(obj2);
                return;
            case 2:
                deliverPendingReports();
                return;
            case 3:
                handleAddBreadcrumb(obj2);
                return;
            case 4:
                handleAddMetadata(obj2);
                return;
            case 5:
                clearBreadcrumbs();
                return;
            case 6:
                handleClearMetadataTab(obj2);
                return;
            case 7:
                addHandledEvent();
                return;
            case 8:
                addUnhandledEvent();
                return;
            case 9:
                handleRemoveMetadata(obj2);
                return;
            case 10:
                handleStartSession(obj2);
                return;
            case 11:
                stoppedSession();
                return;
            case 12:
                handleAppVersionChange(obj2);
                return;
            case 13:
                handleBuildUUIDChange(obj2);
                return;
            case 14:
                handleContextChange(obj2);
                return;
            case 15:
                handleForegroundActivityChange(obj2);
                return;
            case 16:
                handleLowMemoryChange(obj2);
                return;
            case 17:
                handleUpdateMetadata(obj2);
                return;
            case 18:
                handleOrientationChange(obj2);
                return;
            case 19:
                handleReleaseStageChange(obj2);
                return;
            case 20:
                handleUserIdChange(obj2);
                return;
            case 21:
                handleUserNameChange(obj2);
                return;
            case 22:
                handleUserEmailChange(obj2);
                return;
            default:
                return;
        }
    }
}