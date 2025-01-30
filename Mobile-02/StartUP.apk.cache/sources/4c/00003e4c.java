package com.lwansbrough.RCTCamera;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i0;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public class RCTCameraViewManager extends ViewGroupManager<c> {
    public static final int COMMAND_START_PREVIEW = 2;
    public static final int COMMAND_STOP_PREVIEW = 1;
    private static final String REACT_CLASS = "RCTCamera";

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return com.facebook.react.common.c.e("stopPreview", 1, "startPreview", 2);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @com.facebook.react.uimanager.c1.a(name = "aspect")
    public void setAspect(c cVar, int i2) {
        cVar.setAspect(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "barCodeTypes")
    public void setBarCodeTypes(c cVar, ReadableArray readableArray) {
        if (readableArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            arrayList.add(readableArray.getString(i2));
        }
        cVar.setBarCodeTypes(arrayList);
    }

    @com.facebook.react.uimanager.c1.a(name = "barcodeScannerEnabled")
    public void setBarcodeScannerEnabled(c cVar, boolean z) {
        cVar.setBarcodeScannerEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "captureAudio")
    public void setCaptureAudio(c cVar, boolean z) {
    }

    @com.facebook.react.uimanager.c1.a(name = "captureMode")
    public void setCaptureMode(c cVar, int i2) {
        cVar.setCaptureMode(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "captureQuality")
    public void setCaptureQuality(c cVar, String str) {
        cVar.setCaptureQuality(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "captureTarget")
    public void setCaptureTarget(c cVar, int i2) {
    }

    @com.facebook.react.uimanager.c1.a(name = "clearWindowBackground")
    public void setClearWindowBackground(c cVar, boolean z) {
        cVar.setClearWindowBackground(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "flashMode")
    public void setFlashMode(c cVar, int i2) {
        cVar.setFlashMode(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "orientation")
    public void setOrientation(c cVar, int i2) {
        cVar.setOrientation(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "torchMode")
    public void setTorchMode(c cVar, int i2) {
        cVar.setTorchMode(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "type")
    public void setType(c cVar, int i2) {
        cVar.setCameraType(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "zoom")
    public void setZoom(c cVar, int i2) {
        cVar.setZoom(i2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public c createViewInstance(i0 i0Var) {
        return new c(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(c cVar, int i2, ReadableArray readableArray) {
        if (cVar == null) {
            throw new AssertionError();
        }
        if (i2 == 1) {
            cVar.i();
        } else if (i2 == 2) {
            cVar.h();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", Integer.valueOf(i2), getClass().getSimpleName()));
        }
    }
}