package org.reactnative.camera;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.c;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i0;
import e.g.a.b.j;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes3.dex */
public class CameraViewManager extends ViewGroupManager<d> {
    private static final String REACT_CLASS = "RNCamera";

    /* loaded from: classes3.dex */
    public enum a {
        EVENT_CAMERA_READY("onCameraReady"),
        EVENT_ON_MOUNT_ERROR("onMountError"),
        EVENT_ON_BAR_CODE_READ("onBarCodeRead"),
        EVENT_ON_FACES_DETECTED("onFacesDetected"),
        EVENT_ON_BARCODES_DETECTED("onGoogleVisionBarcodesDetected"),
        EVENT_ON_FACE_DETECTION_ERROR("onFaceDetectionError"),
        EVENT_ON_BARCODE_DETECTION_ERROR("onGoogleVisionBarcodeDetectionError"),
        EVENT_ON_TEXT_RECOGNIZED("onTextRecognized"),
        EVENT_ON_PICTURE_TAKEN("onPictureTaken"),
        EVENT_ON_PICTURE_SAVED("onPictureSaved"),
        EVENT_ON_RECORDING_START("onRecordingStart"),
        EVENT_ON_RECORDING_END("onRecordingEnd"),
        EVENT_ON_TOUCH("onTouch");
        
        private final String q;

        a(String str) {
            this.q = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.q;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        a[] values;
        c.b a2 = com.facebook.react.common.c.a();
        for (a aVar : a.values()) {
            a2.b(aVar.toString(), com.facebook.react.common.c.d("registrationName", aVar.toString()));
        }
        return a2.a();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @com.facebook.react.uimanager.c1.a(name = "autoFocus")
    public void setAutoFocus(d dVar, boolean z) {
        dVar.setAutoFocus(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "autoFocusPointOfInterest")
    public void setAutoFocusPointOfInterest(d dVar, ReadableMap readableMap) {
        if (readableMap != null) {
            dVar.v((float) readableMap.getDouble("x"), (float) readableMap.getDouble("y"));
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "barCodeScannerEnabled")
    public void setBarCodeScanning(d dVar, boolean z) {
        dVar.setShouldScanBarCodes(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "barCodeTypes")
    public void setBarCodeTypes(d dVar, ReadableArray readableArray) {
        if (readableArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            arrayList.add(readableArray.getString(i2));
        }
        dVar.setBarCodeTypes(arrayList);
    }

    @com.facebook.react.uimanager.c1.a(name = "cameraId")
    public void setCameraId(d dVar, String str) {
        dVar.setCameraId(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "cameraViewDimensions")
    public void setCameraViewDimensions(d dVar, ReadableMap readableMap) {
        if (readableMap != null) {
            dVar.p0((int) readableMap.getDouble("width"), (int) readableMap.getDouble("height"));
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "detectedImageInEvent")
    public void setDetectedImageInEvent(d dVar, boolean z) {
        dVar.setDetectedImageInEvent(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "exposure")
    public void setExposureCompensation(d dVar, float f2) {
        dVar.setExposureCompensation(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "faceDetectorEnabled")
    public void setFaceDetecting(d dVar, boolean z) {
        dVar.setShouldDetectFaces(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "faceDetectionClassifications")
    public void setFaceDetectionClassifications(d dVar, int i2) {
        dVar.setFaceDetectionClassifications(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "faceDetectionLandmarks")
    public void setFaceDetectionLandmarks(d dVar, int i2) {
        dVar.setFaceDetectionLandmarks(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "faceDetectionMode")
    public void setFaceDetectionMode(d dVar, int i2) {
        dVar.setFaceDetectionMode(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "flashMode")
    public void setFlashMode(d dVar, int i2) {
        dVar.setFlash(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "focusDepth")
    public void setFocusDepth(d dVar, float f2) {
        dVar.setFocusDepth(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "googleVisionBarcodeDetectorEnabled")
    public void setGoogleVisionBarcodeDetecting(d dVar, boolean z) {
        dVar.setShouldGoogleDetectBarcodes(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "googleVisionBarcodeMode")
    public void setGoogleVisionBarcodeMode(d dVar, int i2) {
        dVar.setGoogleVisionBarcodeMode(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "googleVisionBarcodeType")
    public void setGoogleVisionBarcodeType(d dVar, int i2) {
        dVar.setGoogleVisionBarcodeType(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "pictureSize")
    public void setPictureSize(d dVar, String str) {
        dVar.setPictureSize(str.equals("None") ? null : j.n(str));
    }

    @com.facebook.react.uimanager.c1.a(name = "playSoundOnCapture")
    public void setPlaySoundOnCapture(d dVar, boolean z) {
        dVar.setPlaySoundOnCapture(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "ratio")
    public void setRatio(d dVar, String str) {
        dVar.setAspectRatio(e.g.a.b.a.C(str));
    }

    @com.facebook.react.uimanager.c1.a(name = "rectOfInterest")
    public void setRectOfInterest(d dVar, ReadableMap readableMap) {
        if (readableMap != null) {
            dVar.q0((float) readableMap.getDouble("x"), (float) readableMap.getDouble("y"), (float) readableMap.getDouble("width"), (float) readableMap.getDouble("height"));
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "textRecognizerEnabled")
    public void setTextRecognizing(d dVar, boolean z) {
        dVar.setShouldRecognizeText(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "touchDetectorEnabled")
    public void setTouchDetectorEnabled(d dVar, boolean z) {
        dVar.setShouldDetectTouches(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "trackingEnabled")
    public void setTracking(d dVar, boolean z) {
        dVar.setTracking(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "type")
    public void setType(d dVar, int i2) {
        dVar.setFacing(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "useCamera2Api")
    public void setUseCamera2Api(d dVar, boolean z) {
        dVar.setUsingCamera2Api(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "useNativeZoom")
    public void setUseNativeZoom(d dVar, boolean z) {
        dVar.setUseNativeZoom(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "whiteBalance")
    public void setWhiteBalance(d dVar, int i2) {
        dVar.setWhiteBalance(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "zoom")
    public void setZoom(d dVar, float f2) {
        dVar.setZoom(f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public d createViewInstance(i0 i0Var) {
        return new d(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(d dVar) {
        dVar.onHostDestroy();
        super.onDropViewInstance((CameraViewManager) dVar);
    }
}