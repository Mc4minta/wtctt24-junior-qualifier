package com.google.zxing.p.a.l;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import com.journeyapps.barcodescanner.q.d;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import org.apache.http.HttpStatus;
import org.apache.http.message.TokenParser;

/* compiled from: CameraConfigurationUtils.java */
/* loaded from: classes2.dex */
public final class a {
    private static final Pattern a = Pattern.compile(";");

    @TargetApi(15)
    private static List<Camera.Area> a(int i2) {
        int i3 = -i2;
        return Collections.singletonList(new Camera.Area(new Rect(i3, i3, i2, i2), 1));
    }

    private static String b(String str, Collection<String> collection, String... strArr) {
        Log.i("CameraConfiguration", "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        Log.i("CameraConfiguration", "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i("CameraConfiguration", "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i("CameraConfiguration", "No supported values match");
        return null;
    }

    public static void c(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i("CameraConfiguration", "Barcode scene mode already set");
            return;
        }
        String b2 = b("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (b2 != null) {
            parameters.setSceneMode(b2);
        }
    }

    public static void d(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            if (exposureCompensationStep > 0.0f) {
                int round = Math.round((z ? 0.0f : 1.5f) / exposureCompensationStep);
                float f2 = exposureCompensationStep * round;
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    Log.i("CameraConfiguration", "Exposure compensation already set to " + max + " / " + f2);
                    return;
                }
                Log.i("CameraConfiguration", "Setting exposure compensation to " + max + " / " + f2);
                parameters.setExposureCompensation(max);
                return;
            }
        }
        Log.i("CameraConfiguration", "Camera does not support exposure compensation");
    }

    public static void e(Camera.Parameters parameters) {
        f(parameters, 10, 20);
    }

    public static void f(Camera.Parameters parameters, int i2, int i3) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Log.i("CameraConfiguration", "Supported FPS ranges: " + n(supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        int[] iArr = null;
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int[] next = it.next();
            int i4 = next[0];
            int i5 = next[1];
            if (i4 >= i2 * RNCWebViewManager.COMMAND_CLEAR_FORM_DATA && i5 <= i3 * RNCWebViewManager.COMMAND_CLEAR_FORM_DATA) {
                iArr = next;
                break;
            }
        }
        if (iArr == null) {
            Log.i("CameraConfiguration", "No suitable FPS range?");
            return;
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (Arrays.equals(iArr2, iArr)) {
            Log.i("CameraConfiguration", "FPS range already set to " + Arrays.toString(iArr));
            return;
        }
        Log.i("CameraConfiguration", "Setting FPS range to " + Arrays.toString(iArr));
        parameters.setPreviewFpsRange(iArr[0], iArr[1]);
    }

    public static void g(Camera.Parameters parameters, d.a aVar, boolean z) {
        String b2;
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (!z && aVar != d.a.AUTO) {
            if (aVar == d.a.CONTINUOUS) {
                b2 = b("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto");
            } else if (aVar == d.a.INFINITY) {
                b2 = b("focus mode", supportedFocusModes, "infinity");
            } else {
                b2 = aVar == d.a.MACRO ? b("focus mode", supportedFocusModes, "macro") : null;
            }
        } else {
            b2 = b("focus mode", supportedFocusModes, "auto");
        }
        if (!z && b2 == null) {
            b2 = b("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (b2 != null) {
            if (b2.equals(parameters.getFocusMode())) {
                Log.i("CameraConfiguration", "Focus mode already set to " + b2);
                return;
            }
            parameters.setFocusMode(b2);
        }
    }

    @TargetApi(15)
    public static void h(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            Log.i("CameraConfiguration", "Old focus areas: " + m(parameters.getFocusAreas()));
            List<Camera.Area> a2 = a(HttpStatus.SC_BAD_REQUEST);
            Log.i("CameraConfiguration", "Setting focus area to : " + m(a2));
            parameters.setFocusAreas(a2);
            return;
        }
        Log.i("CameraConfiguration", "Device does not support focus areas");
    }

    public static void i(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i("CameraConfiguration", "Negative effect already set");
            return;
        }
        String b2 = b("color effect", parameters.getSupportedColorEffects(), "negative");
        if (b2 != null) {
            parameters.setColorEffect(b2);
        }
    }

    @TargetApi(15)
    public static void j(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            Log.i("CameraConfiguration", "Old metering areas: " + parameters.getMeteringAreas());
            List<Camera.Area> a2 = a(HttpStatus.SC_BAD_REQUEST);
            Log.i("CameraConfiguration", "Setting metering area to : " + m(a2));
            parameters.setMeteringAreas(a2);
            return;
        }
        Log.i("CameraConfiguration", "Device does not support metering areas");
    }

    public static void k(Camera.Parameters parameters, boolean z) {
        String b2;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            b2 = b("flash mode", supportedFlashModes, "torch", "on");
        } else {
            b2 = b("flash mode", supportedFlashModes, "off");
        }
        if (b2 != null) {
            if (b2.equals(parameters.getFlashMode())) {
                Log.i("CameraConfiguration", "Flash mode already set to " + b2);
                return;
            }
            Log.i("CameraConfiguration", "Setting flash mode to " + b2);
            parameters.setFlashMode(b2);
        }
    }

    @TargetApi(15)
    public static void l(Camera.Parameters parameters) {
        if (parameters.isVideoStabilizationSupported()) {
            if (parameters.getVideoStabilization()) {
                Log.i("CameraConfiguration", "Video stabilization already enabled");
                return;
            }
            Log.i("CameraConfiguration", "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
            return;
        }
        Log.i("CameraConfiguration", "This device does not support video stabilization");
    }

    @TargetApi(15)
    private static String m(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area area : iterable) {
            sb.append(area.rect);
            sb.append(':');
            sb.append(area.weight);
            sb.append(TokenParser.SP);
        }
        return sb.toString();
    }

    private static String n(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<int[]> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(Arrays.toString(it.next()));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}