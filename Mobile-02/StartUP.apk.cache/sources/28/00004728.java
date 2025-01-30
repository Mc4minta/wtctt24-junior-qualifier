package e.f.m.y;

import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.BlobModule;
import com.facebook.react.modules.blob.FileReaderModule;
import com.facebook.react.modules.camera.CameraRollManager;
import com.facebook.react.modules.camera.ImageEditingManager;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.sound.SoundManagerModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.storage.AsyncStorageModule;
import com.facebook.react.modules.timepicker.TimePickerDialogModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.art.ARTRenderableViewManager;
import com.facebook.react.views.art.ARTSurfaceViewManager;
import com.facebook.react.views.checkbox.ReactCheckBoxManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.picker.ReactDialogPickerManager;
import com.facebook.react.views.picker.ReactDropdownPickerManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.slider.ReactSliderManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.react.views.viewpager.ReactViewPagerManager;
import e.f.m.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.message.TokenParser;

/* compiled from: MainReactPackage.java */
/* loaded from: classes2.dex */
public class b extends t {
    private e.f.m.y.a a;

    /* compiled from: MainReactPackage.java */
    /* loaded from: classes2.dex */
    class a implements com.facebook.react.module.model.a {
        final /* synthetic */ Map a;

        a(Map map) {
            this.a = map;
        }

        @Override // com.facebook.react.module.model.a
        public Map<String, ReactModuleInfo> a() {
            return this.a;
        }
    }

    @Override // e.f.m.t
    public NativeModule c(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2115067288:
                if (str.equals(ToastModule.NAME)) {
                    c2 = 0;
                    break;
                }
                break;
            case -2033388651:
                if (str.equals(AsyncStorageModule.NAME)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1962922905:
                if (str.equals(ImageStoreManager.NAME)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1850625090:
                if (str.equals(SoundManagerModule.NAME)) {
                    c2 = 3;
                    break;
                }
                break;
            case -1654566518:
                if (str.equals(DialogModule.NAME)) {
                    c2 = 4;
                    break;
                }
                break;
            case -1505215509:
                if (str.equals(CameraRollManager.NAME)) {
                    c2 = 5;
                    break;
                }
                break;
            case -1399423980:
                if (str.equals(TimePickerDialogModule.FRAGMENT_TAG)) {
                    c2 = 6;
                    break;
                }
                break;
            case -1344126773:
                if (str.equals(FileReaderModule.NAME)) {
                    c2 = 7;
                    break;
                }
                break;
            case -1062061717:
                if (str.equals(PermissionsModule.NAME)) {
                    c2 = '\b';
                    break;
                }
                break;
            case -657277650:
                if (str.equals(ImageLoaderModule.NAME)) {
                    c2 = '\t';
                    break;
                }
                break;
            case -570370161:
                if (str.equals(I18nManagerModule.NAME)) {
                    c2 = '\n';
                    break;
                }
                break;
            case -504784764:
                if (str.equals(AppearanceModule.NAME)) {
                    c2 = 11;
                    break;
                }
                break;
            case -457866500:
                if (str.equals(AccessibilityInfoModule.NAME)) {
                    c2 = '\f';
                    break;
                }
                break;
            case -382654004:
                if (str.equals(StatusBarModule.NAME)) {
                    c2 = TokenParser.CR;
                    break;
                }
                break;
            case -254310125:
                if (str.equals("WebSocketModule")) {
                    c2 = 14;
                    break;
                }
                break;
            case 163245714:
                if (str.equals(FrescoModule.NAME)) {
                    c2 = 15;
                    break;
                }
                break;
            case 174691539:
                if (str.equals(DatePickerDialogModule.FRAGMENT_TAG)) {
                    c2 = 16;
                    break;
                }
                break;
            case 283572496:
                if (str.equals(ImageEditingManager.NAME)) {
                    c2 = 17;
                    break;
                }
                break;
            case 403570038:
                if (str.equals(ClipboardModule.NAME)) {
                    c2 = 18;
                    break;
                }
                break;
            case 563961875:
                if (str.equals(IntentModule.NAME)) {
                    c2 = 19;
                    break;
                }
                break;
            case 1221389072:
                if (str.equals(AppStateModule.NAME)) {
                    c2 = 20;
                    break;
                }
                break;
            case 1515242260:
                if (str.equals(NetworkingModule.NAME)) {
                    c2 = 21;
                    break;
                }
                break;
            case 1547941001:
                if (str.equals(BlobModule.NAME)) {
                    c2 = 22;
                    break;
                }
                break;
            case 1555425035:
                if (str.equals(ShareModule.NAME)) {
                    c2 = 23;
                    break;
                }
                break;
            case 1721274886:
                if (str.equals(NativeAnimatedModule.NAME)) {
                    c2 = 24;
                    break;
                }
                break;
            case 1922110066:
                if (str.equals(VibrationModule.NAME)) {
                    c2 = 25;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new ToastModule(reactApplicationContext);
            case 1:
                return new AsyncStorageModule(reactApplicationContext);
            case 2:
                return new ImageStoreManager(reactApplicationContext);
            case 3:
                return new SoundManagerModule(reactApplicationContext);
            case 4:
                return new DialogModule(reactApplicationContext);
            case 5:
                return new CameraRollManager(reactApplicationContext);
            case 6:
                return new TimePickerDialogModule(reactApplicationContext);
            case 7:
                return new FileReaderModule(reactApplicationContext);
            case '\b':
                return new PermissionsModule(reactApplicationContext);
            case '\t':
                return new ImageLoaderModule(reactApplicationContext);
            case '\n':
                return new I18nManagerModule(reactApplicationContext);
            case 11:
                return new AppearanceModule(reactApplicationContext);
            case '\f':
                return new AccessibilityInfoModule(reactApplicationContext);
            case '\r':
                return new StatusBarModule(reactApplicationContext);
            case 14:
                return new WebSocketModule(reactApplicationContext);
            case 15:
                if (this.a == null) {
                    return new FrescoModule(reactApplicationContext, true, null);
                }
                throw null;
            case 16:
                return new DatePickerDialogModule(reactApplicationContext);
            case 17:
                return new ImageEditingManager(reactApplicationContext);
            case 18:
                return new ClipboardModule(reactApplicationContext);
            case 19:
                return new IntentModule(reactApplicationContext);
            case 20:
                return new AppStateModule(reactApplicationContext);
            case 21:
                return new NetworkingModule(reactApplicationContext);
            case 22:
                return new BlobModule(reactApplicationContext);
            case 23:
                return new ShareModule(reactApplicationContext);
            case 24:
                return new NativeAnimatedModule(reactApplicationContext);
            case 25:
                return new VibrationModule(reactApplicationContext);
            default:
                return null;
        }
    }

    @Override // e.f.m.t, e.f.m.p
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ARTRenderableViewManager.createARTGroupViewManager());
        arrayList.add(ARTRenderableViewManager.createARTShapeViewManager());
        arrayList.add(ARTRenderableViewManager.createARTTextViewManager());
        arrayList.add(new ReactCheckBoxManager());
        arrayList.add(new ReactDialogPickerManager());
        arrayList.add(new ReactDrawerLayoutManager());
        arrayList.add(new ReactDropdownPickerManager());
        arrayList.add(new ReactHorizontalScrollViewManager());
        arrayList.add(new ReactHorizontalScrollContainerViewManager());
        arrayList.add(new ReactProgressBarViewManager());
        arrayList.add(new ReactScrollViewManager());
        arrayList.add(new ReactSliderManager());
        arrayList.add(new ReactSwitchManager());
        arrayList.add(new SwipeRefreshLayoutManager());
        arrayList.add(new ARTSurfaceViewManager());
        arrayList.add(new FrescoBasedReactTextInlineImageViewManager());
        arrayList.add(new ReactImageManager());
        arrayList.add(new ReactModalHostManager());
        arrayList.add(new ReactRawTextManager());
        arrayList.add(new ReactTextInputManager());
        arrayList.add(new ReactTextViewManager());
        arrayList.add(new ReactViewManager());
        arrayList.add(new ReactViewPagerManager());
        arrayList.add(new ReactVirtualTextViewManager());
        return arrayList;
    }

    @Override // e.f.m.t
    public com.facebook.react.module.model.a e() {
        try {
            return (com.facebook.react.module.model.a) Class.forName("com.facebook.react.shell.MainReactPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            Class[] clsArr = {AccessibilityInfoModule.class, AppearanceModule.class, AppStateModule.class, BlobModule.class, FileReaderModule.class, AsyncStorageModule.class, CameraRollManager.class, ClipboardModule.class, DatePickerDialogModule.class, DialogModule.class, FrescoModule.class, I18nManagerModule.class, ImageEditingManager.class, ImageLoaderModule.class, ImageStoreManager.class, IntentModule.class, NativeAnimatedModule.class, NetworkingModule.class, PermissionsModule.class, ShareModule.class, StatusBarModule.class, SoundManagerModule.class, TimePickerDialogModule.class, ToastModule.class, VibrationModule.class, WebSocketModule.class};
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < 26; i2++) {
                Class cls = clsArr[i2];
                e.f.m.x.a.a aVar = (e.f.m.x.a.a) cls.getAnnotation(e.f.m.x.a.a.class);
                hashMap.put(aVar.name(), new ReactModuleInfo(aVar.name(), cls.getName(), aVar.canOverrideExistingModule(), aVar.needsEagerInit(), aVar.hasConstants(), aVar.isCxxModule(), com.facebook.react.turbomodule.core.interfaces.a.class.isAssignableFrom(cls)));
            }
            return new a(hashMap);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e3);
        }
    }
}