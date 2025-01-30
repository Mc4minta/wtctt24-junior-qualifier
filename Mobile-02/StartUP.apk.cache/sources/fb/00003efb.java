package com.rt2zz.reactnativecontacts;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import com.coinbase.ApiConstants;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class ContactsManager extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final String PERMISSION_AUTHORIZED = "authorized";
    private static final String PERMISSION_DENIED = "denied";
    private static final String PERMISSION_READ_CONTACTS = "android.permission.READ_CONTACTS";
    private static final int PERMISSION_REQUEST_CODE = 888;
    private static final int REQUEST_OPEN_CONTACT_FORM = 52941;
    private static final int REQUEST_OPEN_EXISTING_CONTACT = 52942;
    private static Callback requestCallback;
    private static Callback updateContactCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ Callback a;

        a(Callback callback) {
            this.a = callback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.a.invoke(null, new com.rt2zz.reactnativecontacts.a(ContactsManager.this.getReactApplicationContext().getContentResolver()).d());
            return null;
        }
    }

    /* loaded from: classes2.dex */
    class b extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ Callback a;

        b(Callback callback) {
            this.a = callback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.a.invoke(new com.rt2zz.reactnativecontacts.a(ContactsManager.this.getReactApplicationContext().getContentResolver()).g());
            return null;
        }
    }

    /* loaded from: classes2.dex */
    class c extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callback f10802b;

        c(String str, Callback callback) {
            this.a = str;
            this.f10802b = callback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.f10802b.invoke(null, new com.rt2zz.reactnativecontacts.a(ContactsManager.this.getReactApplicationContext().getContentResolver()).h(this.a));
            return null;
        }
    }

    /* loaded from: classes2.dex */
    class d extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callback f10804b;

        d(String str, Callback callback) {
            this.a = str;
            this.f10804b = callback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.f10804b.invoke(null, new com.rt2zz.reactnativecontacts.a(ContactsManager.this.getReactApplicationContext().getContentResolver()).f(this.a));
            return null;
        }
    }

    /* loaded from: classes2.dex */
    class e extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callback f10806b;

        e(String str, Callback callback) {
            this.a = str;
            this.f10806b = callback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.f10806b.invoke(null, new com.rt2zz.reactnativecontacts.a(ContactsManager.this.getReactApplicationContext().getContentResolver()).e(this.a));
            return null;
        }
    }

    /* loaded from: classes2.dex */
    class f extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callback f10808b;

        f(String str, Callback callback) {
            this.a = str;
            this.f10808b = callback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.f10808b.invoke(null, new com.rt2zz.reactnativecontacts.a(ContactsManager.this.getReactApplicationContext().getContentResolver()).i(this.a));
            return null;
        }
    }

    /* loaded from: classes2.dex */
    class g extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callback f10810b;

        g(String str, Callback callback) {
            this.a = str;
            this.f10810b = callback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.f10810b.invoke(null, new com.rt2zz.reactnativecontacts.a(ContactsManager.this.getReactApplicationContext().getContentResolver()).b(this.a));
            return null;
        }
    }

    /* loaded from: classes2.dex */
    class h extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10812b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Callback f10813c;

        h(String str, String str2, Callback callback) {
            this.a = str;
            this.f10812b = str2;
            this.f10813c = callback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:2|3)|(3:4|5|6)|7|9|10|11|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
            r8 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
            r8.printStackTrace();
         */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Void... r8) {
            /*
                r7 = this;
                com.rt2zz.reactnativecontacts.ContactsManager r8 = com.rt2zz.reactnativecontacts.ContactsManager.this
                com.facebook.react.bridge.ReactApplicationContext r8 = com.rt2zz.reactnativecontacts.ContactsManager.access$700(r8)
                android.content.ContentResolver r8 = r8.getContentResolver()
                android.net.Uri r0 = android.provider.ContactsContract.Contacts.CONTENT_URI
                java.lang.String r1 = r7.a
                long r1 = java.lang.Long.parseLong(r1)
                android.net.Uri r0 = android.content.ContentUris.withAppendedId(r0, r1)
                java.io.InputStream r8 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r8, r0)
                r0 = 0
                r1 = 1
                r2 = 0
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L43 java.io.FileNotFoundException -> L45
                java.lang.String r4 = r7.f10812b     // Catch: java.lang.Throwable -> L43 java.io.FileNotFoundException -> L45
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L43 java.io.FileNotFoundException -> L45
                android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r8)     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L65
                android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L65
                r6 = 100
                r4.compress(r5, r6, r3)     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L65
                com.facebook.react.bridge.Callback r4 = r7.f10813c     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L65
                r5 = 2
                java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L65
                r5[r0] = r2     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L65
                java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L65
                r5[r1] = r6     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L65
                r4.invoke(r5)     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L65
                r3.close()     // Catch: java.io.IOException -> L58
                goto L5c
            L41:
                r4 = move-exception
                goto L47
            L43:
                r8 = move-exception
                goto L67
            L45:
                r4 = move-exception
                r3 = r2
            L47:
                com.facebook.react.bridge.Callback r5 = r7.f10813c     // Catch: java.lang.Throwable -> L65
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L65
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L65
                r1[r0] = r4     // Catch: java.lang.Throwable -> L65
                r5.invoke(r1)     // Catch: java.lang.Throwable -> L65
                r3.close()     // Catch: java.io.IOException -> L58
                goto L5c
            L58:
                r0 = move-exception
                r0.printStackTrace()
            L5c:
                r8.close()     // Catch: java.io.IOException -> L60
                goto L64
            L60:
                r8 = move-exception
                r8.printStackTrace()
            L64:
                return r2
            L65:
                r8 = move-exception
                r2 = r3
            L67:
                r2.close()     // Catch: java.io.IOException -> L6b
                goto L6f
            L6b:
                r0 = move-exception
                r0.printStackTrace()
            L6f:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rt2zz.reactnativecontacts.ContactsManager.h.doInBackground(java.lang.Void[]):java.lang.Void");
        }
    }

    public ContactsManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
    }

    private void getAllContacts(Callback callback) {
        new a(callback).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    private Bitmap getThumbnailBitmap(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile == null) {
            try {
                InputStream open = getReactApplicationContext().getAssets().open(str);
                decodeFile = BitmapFactory.decodeStream(open);
                open.close();
                return decodeFile;
            } catch (IOException e2) {
                e2.printStackTrace();
                return decodeFile;
            }
        }
        return decodeFile;
    }

    private String getValueFromKey(ReadableMap readableMap, String str) {
        return readableMap.hasKey(str) ? readableMap.getString(str) : "";
    }

    private String isPermissionGranted() {
        return getReactApplicationContext().checkCallingOrSelfPermission(PERMISSION_READ_CONTACTS) == 0 ? PERMISSION_AUTHORIZED : PERMISSION_DENIED;
    }

    private int mapStringToEmailType(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1068855134:
                if (str.equals(ApiConstants.CLIENT_PLATFORM)) {
                    c2 = 0;
                    break;
                }
                break;
            case 3208415:
                if (str.equals("home")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3655441:
                if (str.equals("work")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 4;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    private int mapStringToPhoneType(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1068855134:
                if (str.equals(ApiConstants.CLIENT_PLATFORM)) {
                    c2 = 0;
                    break;
                }
                break;
            case -557528811:
                if (str.equals("work_pager")) {
                    c2 = 1;
                    break;
                }
                break;
            case -487750564:
                if (str.equals("home fax")) {
                    c2 = 2;
                    break;
                }
                break;
            case -176627312:
                if (str.equals("work_mobile")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3208415:
                if (str.equals("home")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3343801:
                if (str.equals("main")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3655441:
                if (str.equals("work")) {
                    c2 = 6;
                    break;
                }
                break;
            case 33287566:
                if (str.equals("work fax")) {
                    c2 = 7;
                    break;
                }
                break;
            case 106426307:
                if (str.equals("pager")) {
                    c2 = '\b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2;
            case 1:
                return 18;
            case 2:
                return 5;
            case 3:
                return 17;
            case 4:
                return 1;
            case 5:
                return 12;
            case 6:
                return 3;
            case 7:
                return 4;
            case '\b':
                return 6;
            default:
                return 0;
        }
    }

    private int mapStringToPostalAddressType(String str) {
        str.hashCode();
        if (str.equals("home")) {
            return 1;
        }
        return !str.equals("work") ? 0 : 2;
    }

    protected static void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Callback callback = requestCallback;
        if (callback == null) {
            return;
        }
        if (i2 != PERMISSION_REQUEST_CODE) {
            callback.invoke(null, PERMISSION_DENIED);
            return;
        }
        Hashtable hashtable = new Hashtable();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            hashtable.put(strArr[i3], Boolean.valueOf(iArr[i3] == 0));
        }
        if (hashtable.containsKey(PERMISSION_READ_CONTACTS) && ((Boolean) hashtable.get(PERMISSION_READ_CONTACTS)).booleanValue()) {
            requestCallback.invoke(null, PERMISSION_AUTHORIZED);
        } else {
            requestCallback.invoke(null, PERMISSION_DENIED);
        }
        requestCallback = null;
    }

    private void requestReadContactsPermission(Callback callback) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke(null, PERMISSION_DENIED);
        } else if (isPermissionGranted().equals(PERMISSION_AUTHORIZED)) {
            callback.invoke(null, PERMISSION_AUTHORIZED);
        } else {
            requestCallback = callback;
            androidx.core.app.a.r(currentActivity, new String[]{PERMISSION_READ_CONTACTS}, PERMISSION_REQUEST_CODE);
        }
    }

    @ReactMethod
    public void addContact(ReadableMap readableMap, Callback callback) {
        String str;
        String str2;
        String str3;
        String str4;
        String[] strArr;
        int i2;
        String[] strArr2;
        Integer[] numArr;
        String[] strArr3;
        int i3;
        String[] strArr4;
        String[] strArr5;
        int i4;
        int i5;
        Integer[] numArr2;
        String[] strArr6;
        int i6;
        Integer[] numArr3;
        String[] strArr7;
        String[] strArr8;
        String str5;
        int i7;
        String[] strArr9;
        String[] strArr10;
        ContactsManager contactsManager;
        Callback callback2;
        int i8;
        int i9;
        String string = readableMap.hasKey("givenName") ? readableMap.getString("givenName") : null;
        String string2 = readableMap.hasKey("middleName") ? readableMap.getString("middleName") : null;
        String string3 = readableMap.hasKey("familyName") ? readableMap.getString("familyName") : null;
        String string4 = readableMap.hasKey("prefix") ? readableMap.getString("prefix") : null;
        String string5 = readableMap.hasKey("suffix") ? readableMap.getString("suffix") : null;
        String string6 = readableMap.hasKey("company") ? readableMap.getString("company") : null;
        String string7 = readableMap.hasKey("jobTitle") ? readableMap.getString("jobTitle") : null;
        String string8 = readableMap.hasKey("department") ? readableMap.getString("department") : null;
        String string9 = readableMap.hasKey("note") ? readableMap.getString("note") : null;
        String string10 = readableMap.hasKey("thumbnailPath") ? readableMap.getString("thumbnailPath") : null;
        ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
        if (array != null) {
            i2 = array.size();
            strArr = new String[i2];
            str4 = string10;
            numArr = new Integer[i2];
            str3 = string8;
            strArr2 = new String[i2];
            str2 = string7;
            int i10 = 0;
            while (true) {
                int i11 = i2;
                if (i10 >= i2) {
                    break;
                }
                strArr[i10] = array.getMap(i10).getString("number");
                String string11 = array.getMap(i10).getString("label");
                numArr[i10] = Integer.valueOf(mapStringToPhoneType(string11));
                strArr2[i10] = string11;
                i10++;
                i2 = i11;
                string6 = string6;
            }
            str = string6;
        } else {
            str = string6;
            str2 = string7;
            str3 = string8;
            str4 = string10;
            strArr = null;
            i2 = 0;
            strArr2 = null;
            numArr = null;
        }
        ReadableArray array2 = readableMap.hasKey("urlAddresses") ? readableMap.getArray("urlAddresses") : null;
        if (array2 != null) {
            int size = array2.size();
            strArr4 = new String[size];
            strArr3 = strArr2;
            int i12 = 0;
            while (true) {
                i9 = size;
                if (i12 >= size) {
                    break;
                }
                strArr4[i12] = array2.getMap(i12).getString("url");
                i12++;
                size = i9;
                array2 = array2;
            }
            i3 = i9;
        } else {
            strArr3 = strArr2;
            i3 = 0;
            strArr4 = null;
        }
        ReadableArray array3 = readableMap.hasKey("emailAddresses") ? readableMap.getArray("emailAddresses") : null;
        if (array3 != null) {
            int size2 = array3.size();
            strArr6 = strArr4;
            strArr8 = new String[size2];
            i5 = i3;
            numArr3 = new Integer[size2];
            numArr2 = numArr;
            strArr7 = new String[size2];
            strArr5 = strArr;
            int i13 = 0;
            while (i13 < size2) {
                int i14 = i2;
                strArr8[i13] = array3.getMap(i13).getString("email");
                String string12 = array3.getMap(i13).getString("label");
                numArr3[i13] = Integer.valueOf(mapStringToEmailType(string12));
                strArr7[i13] = string12;
                i13++;
                size2 = size2;
                i2 = i14;
            }
            i4 = i2;
            i6 = size2;
        } else {
            strArr5 = strArr;
            i4 = i2;
            i5 = i3;
            numArr2 = numArr;
            strArr6 = strArr4;
            i6 = 0;
            numArr3 = null;
            strArr7 = null;
            strArr8 = null;
        }
        ReadableArray array4 = readableMap.hasKey("imAddresses") ? readableMap.getArray("imAddresses") : null;
        if (array4 != null) {
            int size3 = array4.size();
            strArr9 = new String[size3];
            str5 = "label";
            strArr10 = new String[size3];
            int i15 = 0;
            while (true) {
                i8 = size3;
                if (i15 >= size3) {
                    break;
                }
                strArr9[i15] = array4.getMap(i15).getString("username");
                strArr10[i15] = array4.getMap(i15).getString("service");
                i15++;
                size3 = i8;
            }
            i7 = i8;
        } else {
            str5 = "label";
            i7 = 0;
            strArr9 = null;
            strArr10 = null;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        String[] strArr11 = strArr10;
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", null).withValue("account_name", null).build());
        String[] strArr12 = strArr9;
        String str6 = "data5";
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", string).withValue("data5", string2).withValue("data3", string3).withValue("data4", string4).withValue("data6", string5).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/note").withValue("data1", string9).build());
        ContentProviderOperation.Builder withValue = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data1", str).withValue("data4", str2).withValue("data5", str3);
        arrayList.add(withValue.build());
        withValue.withYieldAllowed(true);
        int i16 = 0;
        for (int i17 = i4; i16 < i17; i17 = i17) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", strArr5[i16]).withValue("data2", numArr2[i16]).withValue("data3", strArr3[i16]).build());
            i16++;
            str6 = str6;
        }
        String str7 = str6;
        int i18 = 0;
        for (int i19 = i5; i18 < i19; i19 = i19) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", strArr6[i18]).build());
            i18++;
        }
        for (int i20 = 0; i20 < i6; i20++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", strArr8[i20]).withValue("data2", numArr3[i20]).withValue("data3", strArr7[i20]).build());
        }
        if (str4 == null || str4.isEmpty()) {
            contactsManager = this;
        } else {
            contactsManager = this;
            Bitmap thumbnailBitmap = contactsManager.getThumbnailBitmap(str4);
            if (thumbnailBitmap != null) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", contactsManager.toByteArray(thumbnailBitmap)).build());
            }
        }
        ReadableArray array5 = readableMap.hasKey("postalAddresses") ? readableMap.getArray("postalAddresses") : null;
        if (array5 != null) {
            int i21 = 0;
            while (i21 < array5.size()) {
                ReadableMap map = array5.getMap(i21);
                String str8 = str5;
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", Integer.valueOf(contactsManager.mapStringToPostalAddressType(map.getString(str8)))).withValue("data3", map.getString(str8)).withValue("data4", map.getString("street")).withValue("data7", map.getString("city")).withValue("data8", map.getString(ApiConstants.STATE)).withValue("data9", map.getString("postCode")).withValue("data10", map.getString("country")).build());
                i21++;
                contactsManager = this;
            }
        }
        for (int i22 = 0; i22 < i7; i22++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", strArr12[i22]).withValue("data2", 1).withValue(str7, "data6").withValue("data6", strArr11[i22]).build());
        }
        try {
            ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
            ContentProviderResult[] applyBatch = contentResolver.applyBatch("com.android.contacts", arrayList);
            if (applyBatch == null || applyBatch.length <= 0) {
                return;
            }
            callback2 = callback;
            try {
                callback2.invoke(null, new com.rt2zz.reactnativecontacts.a(contentResolver).c(String.valueOf(ContentUris.parseId(applyBatch[0].uri))));
            } catch (Exception e2) {
                e = e2;
                callback2.invoke(e.toString());
            }
        } catch (Exception e3) {
            e = e3;
            callback2 = callback;
        }
    }

    @ReactMethod
    public void checkPermission(Callback callback) {
        callback.invoke(null, isPermissionGranted());
    }

    @ReactMethod
    public void deleteContact(ReadableMap readableMap, Callback callback) {
        String string = readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null;
        try {
            if (getReactApplicationContext().getContentResolver().delete(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, string), null, null) > 0) {
                callback.invoke(null, string);
            } else {
                callback.invoke(null, null);
            }
        } catch (Exception e2) {
            callback.invoke(e2.toString(), null);
        }
    }

    @ReactMethod
    public void editExistingContact(ReadableMap readableMap, Callback callback) {
        int i2;
        Integer[] numArr;
        String[] strArr = null;
        try {
            Uri withAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null);
            ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
            if (array != null) {
                i2 = array.size();
                strArr = new String[i2];
                numArr = new Integer[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    strArr[i3] = array.getMap(i3).getString("number");
                    numArr[i3] = Integer.valueOf(mapStringToPhoneType(array.getMap(i3).getString("label")));
                }
            } else {
                i2 = 0;
                numArr = null;
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (int i4 = 0; i4 < i2; i4++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
                contentValues.put("data2", numArr[i4]);
                contentValues.put("data1", strArr[i4]);
                arrayList.add(contentValues);
            }
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setDataAndType(withAppendedPath, "vnd.android.cursor.item/contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            intent.putParcelableArrayListExtra("data", arrayList);
            updateContactCallback = callback;
            getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_EXISTING_CONTACT, Bundle.EMPTY);
        } catch (Exception e2) {
            callback.invoke(e2.toString());
        }
    }

    @ReactMethod
    public void getAll(Callback callback) {
        getAllContacts(callback);
    }

    @ReactMethod
    public void getAllWithoutPhotos(Callback callback) {
        getAllContacts(callback);
    }

    @ReactMethod
    public void getContactById(String str, Callback callback) {
        new g(str, callback).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getContactsByEmailAddress(String str, Callback callback) {
        new e(str, callback).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getContactsByPhoneNumber(String str, Callback callback) {
        new d(str, callback).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getContactsMatchingString(String str, Callback callback) {
        new c(str, callback).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getCount(Callback callback) {
        new b(callback).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "Contacts";
    }

    @ReactMethod
    public void getPhotoForId(String str, Callback callback) {
        new f(str, callback).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void iosEnableNotesUsage(boolean z) {
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        Callback callback;
        Uri data;
        if ((i2 == REQUEST_OPEN_CONTACT_FORM || i2 == REQUEST_OPEN_EXISTING_CONTACT) && (callback = updateContactCallback) != null) {
            if (i3 != -1) {
                callback.invoke(null, null);
                updateContactCallback = null;
            } else if (intent == null) {
                callback.invoke("Error received activity result with no data!", null);
                updateContactCallback = null;
            } else {
                try {
                    data = intent.getData();
                } catch (Exception e2) {
                    updateContactCallback.invoke(e2.getMessage(), null);
                }
                if (data == null) {
                    updateContactCallback.invoke("Error wrong data. No content uri found!", null);
                    updateContactCallback = null;
                    return;
                }
                updateContactCallback.invoke(null, new com.rt2zz.reactnativecontacts.a(getReactApplicationContext().getContentResolver()).b(data.getLastPathSegment()));
                updateContactCallback = null;
            }
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    @ReactMethod
    public void openContactForm(ReadableMap readableMap, Callback callback) {
        String str;
        String str2;
        String str3;
        int i2;
        Integer[] numArr;
        String[] strArr;
        String[] strArr2;
        int i3;
        String[] strArr3;
        int i4;
        Integer[] numArr2;
        int i5;
        String[] strArr4;
        Integer[] numArr3;
        String[] strArr5;
        int i6;
        String str4;
        Integer[] numArr4;
        String[] strArr6;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i7;
        String[] strArr7;
        String[] strArr8;
        String[] strArr9;
        String[] strArr10;
        int i8;
        String[] strArr11;
        String[] strArr12;
        int i9;
        String[] strArr13;
        String[] strArr14;
        String string = readableMap.hasKey("givenName") ? readableMap.getString("givenName") : null;
        String string2 = readableMap.hasKey("middleName") ? readableMap.getString("middleName") : null;
        String string3 = readableMap.hasKey("displayName") ? readableMap.getString("displayName") : null;
        String string4 = readableMap.hasKey("familyName") ? readableMap.getString("familyName") : null;
        String string5 = readableMap.hasKey("prefix") ? readableMap.getString("prefix") : null;
        String string6 = readableMap.hasKey("suffix") ? readableMap.getString("suffix") : null;
        String string7 = readableMap.hasKey("company") ? readableMap.getString("company") : null;
        String string8 = readableMap.hasKey("jobTitle") ? readableMap.getString("jobTitle") : null;
        String string9 = readableMap.hasKey("department") ? readableMap.getString("department") : null;
        String string10 = readableMap.hasKey("thumbnailPath") ? readableMap.getString("thumbnailPath") : null;
        ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
        if (array != null) {
            i2 = array.size();
            strArr = new String[i2];
            str = string3;
            numArr = new Integer[i2];
            str3 = string10;
            int i10 = 0;
            while (true) {
                int i11 = i2;
                if (i10 >= i2) {
                    break;
                }
                strArr[i10] = array.getMap(i10).getString("number");
                numArr[i10] = Integer.valueOf(mapStringToPhoneType(array.getMap(i10).getString("label")));
                i10++;
                i2 = i11;
                string9 = string9;
            }
            str2 = string9;
        } else {
            str = string3;
            str2 = string9;
            str3 = string10;
            i2 = 0;
            numArr = null;
            strArr = null;
        }
        ReadableArray array2 = readableMap.hasKey("urlAddresses") ? readableMap.getArray("urlAddresses") : null;
        if (array2 != null) {
            i3 = array2.size();
            strArr3 = new String[i3];
            strArr2 = strArr;
            int i12 = 0;
            while (true) {
                int i13 = i3;
                if (i12 >= i3) {
                    break;
                }
                strArr3[i12] = array2.getMap(i12).getString("url");
                i12++;
                i3 = i13;
                array2 = array2;
            }
        } else {
            strArr2 = strArr;
            i3 = 0;
            strArr3 = null;
        }
        ReadableArray array3 = readableMap.hasKey("emailAddresses") ? readableMap.getArray("emailAddresses") : null;
        if (array3 != null) {
            i6 = array3.size();
            numArr2 = numArr;
            strArr5 = new String[i6];
            i4 = i2;
            numArr3 = new Integer[i6];
            strArr4 = strArr3;
            int i14 = 0;
            while (i14 < i6) {
                strArr5[i14] = array3.getMap(i14).getString("email");
                numArr3[i14] = Integer.valueOf(mapStringToEmailType(array3.getMap(i14).getString("label")));
                i14++;
                i6 = i6;
                i3 = i3;
            }
            i5 = i3;
        } else {
            i4 = i2;
            numArr2 = numArr;
            i5 = i3;
            strArr4 = strArr3;
            numArr3 = null;
            strArr5 = null;
            i6 = 0;
        }
        ReadableArray array4 = readableMap.hasKey("postalAddresses") ? readableMap.getArray("postalAddresses") : null;
        if (array4 != null) {
            i8 = array4.size();
            strArr11 = new String[i8];
            strArr6 = strArr5;
            strArr7 = new String[i8];
            numArr4 = numArr3;
            String[] strArr15 = new String[i8];
            i7 = i6;
            strArr12 = new String[i8];
            str9 = string8;
            strArr10 = new String[i8];
            str8 = string7;
            strArr9 = new String[i8];
            str7 = string6;
            strArr8 = new String[i8];
            str6 = string5;
            Integer[] numArr5 = new Integer[i8];
            str4 = string2;
            int i15 = 0;
            while (i15 < i8) {
                strArr11[i15] = array4.getMap(i15).getString("street");
                strArr7[i15] = array4.getMap(i15).getString("city");
                strArr15[i15] = array4.getMap(i15).getString(ApiConstants.STATE);
                strArr12[i15] = array4.getMap(i15).getString("region");
                strArr10[i15] = array4.getMap(i15).getString("postCode");
                strArr9[i15] = array4.getMap(i15).getString("country");
                strArr8[i15] = array4.getMap(i15).getString("formattedAddress");
                numArr5[i15] = Integer.valueOf(mapStringToPostalAddressType(array4.getMap(i15).getString("label")));
                i15++;
                i8 = i8;
                string4 = string4;
            }
            str5 = string4;
        } else {
            str4 = string2;
            numArr4 = numArr3;
            strArr6 = strArr5;
            str5 = string4;
            str6 = string5;
            str7 = string6;
            str8 = string7;
            str9 = string8;
            i7 = i6;
            strArr7 = null;
            strArr8 = null;
            strArr9 = null;
            strArr10 = null;
            i8 = 0;
            strArr11 = null;
            strArr12 = null;
        }
        ReadableArray array5 = readableMap.hasKey("imAddresses") ? readableMap.getArray("imAddresses") : null;
        if (array5 != null) {
            i9 = array5.size();
            strArr13 = new String[i9];
            String[] strArr16 = new String[i9];
            for (int i16 = 0; i16 < i9; i16++) {
                strArr13[i16] = array5.getMap(i16).getString("username");
                strArr16[i16] = array5.getMap(i16).getString("service");
            }
            strArr14 = strArr16;
        } else {
            i9 = 0;
            strArr13 = null;
            strArr14 = null;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/identity");
        contentValues.put("data2", string);
        contentValues.put("data3", str5);
        String str10 = "data5";
        contentValues.put("data5", str4);
        contentValues.put("data4", str6);
        String[] strArr17 = strArr13;
        contentValues.put("data6", str7);
        arrayList.add(contentValues);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues2.put("data1", str8);
        contentValues2.put("data4", str9);
        contentValues2.put("data5", str2);
        arrayList.add(contentValues2);
        int i17 = i5;
        int i18 = 0;
        while (i18 < i17) {
            int i19 = i17;
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/website");
            contentValues3.put("data1", strArr4[i18]);
            arrayList.add(contentValues3);
            i18++;
            str10 = str10;
            i17 = i19;
        }
        String str11 = str10;
        int i20 = 0;
        for (int i21 = i7; i20 < i21; i21 = i21) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("mimetype", "vnd.android.cursor.item/email_v2");
            contentValues4.put("data2", numArr4[i20]);
            contentValues4.put("data1", strArr6[i20]);
            arrayList.add(contentValues4);
            i20++;
        }
        int i22 = 0;
        for (int i23 = i4; i22 < i23; i23 = i23) {
            ContentValues contentValues5 = new ContentValues();
            contentValues5.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues5.put("data2", numArr2[i22]);
            contentValues5.put("data1", strArr2[i22]);
            arrayList.add(contentValues5);
            i22++;
        }
        int i24 = 0;
        while (i24 < i8) {
            ContentValues contentValues6 = new ContentValues();
            contentValues6.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues6.put("data4", strArr11[i24]);
            contentValues6.put("data7", strArr7[i24]);
            contentValues6.put("data8", strArr12[i24]);
            contentValues6.put("data10", strArr9[i24]);
            contentValues6.put("data9", strArr10[i24]);
            contentValues6.put("data1", strArr8[i24]);
            arrayList.add(contentValues6);
            i24++;
            strArr7 = strArr7;
        }
        for (int i25 = 0; i25 < i9; i25++) {
            ContentValues contentValues7 = new ContentValues();
            contentValues7.put("mimetype", "vnd.android.cursor.item/im");
            contentValues7.put("data1", strArr17[i25]);
            contentValues7.put("data2", (Integer) 1);
            contentValues7.put(str11, "data6");
            contentValues7.put("data6", strArr14[i25]);
            arrayList.add(contentValues7);
        }
        if (str3 != null && !str3.isEmpty()) {
            Bitmap thumbnailBitmap = getThumbnailBitmap(str3);
            if (thumbnailBitmap != null) {
                ContentValues contentValues8 = new ContentValues();
                contentValues8.put("raw_contact_id", (Integer) 0);
                contentValues8.put("is_super_primary", (Integer) 1);
                contentValues8.put("data15", toByteArray(thumbnailBitmap));
                contentValues8.put("mimetype", "vnd.android.cursor.item/photo");
                arrayList.add(contentValues8);
            }
        }
        Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra(ApiConstants.NAME, str);
        intent.putExtra("finishActivityOnSaveCompleted", true);
        intent.putParcelableArrayListExtra("data", arrayList);
        updateContactCallback = callback;
        getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_CONTACT_FORM, Bundle.EMPTY);
    }

    @ReactMethod
    public void openExistingContact(ReadableMap readableMap, Callback callback) {
        try {
            Uri withAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null);
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setDataAndType(withAppendedPath, "vnd.android.cursor.item/contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            updateContactCallback = callback;
            getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_EXISTING_CONTACT, Bundle.EMPTY);
        } catch (Exception e2) {
            callback.invoke(e2.toString());
        }
    }

    @ReactMethod
    public void requestPermission(Callback callback) {
        requestReadContactsPermission(callback);
    }

    public byte[] toByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @ReactMethod
    public void updateContact(ReadableMap readableMap, Callback callback) {
        String str;
        String str2;
        ReadableArray readableArray;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String[] strArr;
        int i2;
        String[] strArr2;
        Integer[] numArr;
        String[] strArr3;
        int i3;
        String[] strArr4;
        String[] strArr5;
        String[] strArr6;
        int i4;
        ReadableArray readableArray2;
        String[] strArr7;
        String[] strArr8;
        Integer[] numArr2;
        int i5;
        Integer[] numArr3;
        String[] strArr9;
        String[] strArr10;
        String str8;
        int i6;
        int i7;
        Integer[] numArr4;
        String str9;
        String str10;
        String str11;
        String[] strArr11;
        String[] strArr12;
        int i8;
        String[] strArr13;
        String[] strArr14;
        String[] strArr15;
        String[] strArr16;
        Integer[] numArr5;
        String[] strArr17;
        String[] strArr18;
        ReadableArray readableArray3;
        String[] strArr19;
        int i9;
        String[] strArr20;
        String[] strArr21;
        String str12;
        String str13;
        String[] strArr22;
        Callback callback2;
        Bitmap thumbnailBitmap;
        int i10;
        String[] strArr23;
        ContentProviderOperation.Builder withValue;
        int i11;
        String string = readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null;
        String string2 = readableMap.hasKey("rawContactId") ? readableMap.getString("rawContactId") : null;
        if (string2 != null && string != null) {
            String string3 = readableMap.hasKey("givenName") ? readableMap.getString("givenName") : null;
            String string4 = readableMap.hasKey("middleName") ? readableMap.getString("middleName") : null;
            String string5 = readableMap.hasKey("familyName") ? readableMap.getString("familyName") : null;
            String string6 = readableMap.hasKey("prefix") ? readableMap.getString("prefix") : null;
            String string7 = readableMap.hasKey("suffix") ? readableMap.getString("suffix") : null;
            String string8 = readableMap.hasKey("company") ? readableMap.getString("company") : null;
            String string9 = readableMap.hasKey("jobTitle") ? readableMap.getString("jobTitle") : null;
            String string10 = readableMap.hasKey("department") ? readableMap.getString("department") : null;
            if (readableMap.hasKey("note")) {
                readableMap.getString("note");
            }
            String string11 = readableMap.hasKey("thumbnailPath") ? readableMap.getString("thumbnailPath") : null;
            ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
            String str14 = "label";
            if (array != null) {
                str2 = string11;
                i2 = array.size();
                str = string2;
                strArr = new String[i2];
                str7 = string10;
                numArr = new Integer[i2];
                str6 = string9;
                strArr2 = new String[i2];
                str5 = string8;
                String[] strArr24 = new String[i2];
                str4 = string7;
                int i12 = 0;
                while (true) {
                    int i13 = i2;
                    if (i12 >= i2) {
                        break;
                    }
                    ReadableMap map = array.getMap(i12);
                    ReadableArray readableArray4 = array;
                    String string12 = map.getString("number");
                    String str15 = string6;
                    String string13 = map.getString("label");
                    String string14 = map.hasKey("id") ? map.getString("id") : null;
                    strArr[i12] = string12;
                    numArr[i12] = Integer.valueOf(mapStringToPhoneType(string13));
                    strArr2[i12] = string13;
                    strArr24[i12] = string14;
                    i12++;
                    i2 = i13;
                    array = readableArray4;
                    string6 = str15;
                }
                readableArray = array;
                str3 = string6;
            } else {
                str = string2;
                str2 = string11;
                readableArray = array;
                str3 = string6;
                str4 = string7;
                str5 = string8;
                str6 = string9;
                str7 = string10;
                strArr = null;
                i2 = 0;
                strArr2 = null;
                numArr = null;
            }
            ReadableArray array2 = readableMap.hasKey("urlAddresses") ? readableMap.getArray("urlAddresses") : null;
            if (array2 != null) {
                int size = array2.size();
                strArr4 = new String[size];
                strArr5 = new String[size];
                strArr3 = strArr2;
                int i14 = 0;
                while (true) {
                    i11 = size;
                    if (i14 >= size) {
                        break;
                    }
                    ReadableMap map2 = array2.getMap(i14);
                    ReadableArray readableArray5 = array2;
                    strArr4[i14] = map2.getString("url");
                    strArr5[i14] = map2.hasKey("id") ? map2.getString("id") : null;
                    i14++;
                    size = i11;
                    array2 = readableArray5;
                }
                i3 = i11;
            } else {
                strArr3 = strArr2;
                i3 = 0;
                strArr4 = null;
                strArr5 = null;
            }
            ReadableArray array3 = readableMap.hasKey("emailAddresses") ? readableMap.getArray("emailAddresses") : null;
            if (array3 != null) {
                int size2 = array3.size();
                strArr7 = strArr4;
                strArr9 = new String[size2];
                strArr8 = strArr5;
                String[] strArr25 = new String[size2];
                i4 = i3;
                numArr3 = new Integer[size2];
                numArr2 = numArr;
                strArr10 = new String[size2];
                strArr6 = strArr;
                int i15 = 0;
                while (i15 < size2) {
                    int i16 = size2;
                    ReadableMap map3 = array3.getMap(i15);
                    ReadableArray readableArray6 = array3;
                    strArr9[i15] = map3.getString("email");
                    String string15 = map3.getString("label");
                    numArr3[i15] = Integer.valueOf(mapStringToEmailType(string15));
                    strArr10[i15] = string15;
                    strArr25[i15] = map3.hasKey("id") ? map3.getString("id") : null;
                    i15++;
                    size2 = i16;
                    array3 = readableArray6;
                }
                readableArray2 = array3;
                i5 = size2;
            } else {
                strArr6 = strArr;
                i4 = i3;
                readableArray2 = array3;
                strArr7 = strArr4;
                strArr8 = strArr5;
                numArr2 = numArr;
                i5 = 0;
                numArr3 = null;
                strArr9 = null;
                strArr10 = null;
            }
            ReadableArray array4 = readableMap.hasKey("postalAddresses") ? readableMap.getArray("postalAddresses") : null;
            if (array4 != null) {
                int size3 = array4.size();
                strArr17 = new String[size3];
                strArr12 = strArr10;
                strArr18 = new String[size3];
                numArr4 = numArr3;
                strArr15 = new String[size3];
                strArr11 = strArr9;
                String[] strArr26 = new String[size3];
                i6 = i5;
                strArr13 = new String[size3];
                i7 = i2;
                strArr14 = new String[size3];
                str11 = string5;
                numArr5 = new Integer[size3];
                str10 = string4;
                strArr16 = new String[size3];
                str9 = string3;
                int i17 = 0;
                while (i17 < size3) {
                    int i18 = size3;
                    String valueFromKey = getValueFromKey(array4.getMap(i17), str14);
                    strArr17[i17] = getValueFromKey(array4.getMap(i17), "street");
                    strArr18[i17] = getValueFromKey(array4.getMap(i17), "city");
                    strArr15[i17] = getValueFromKey(array4.getMap(i17), ApiConstants.STATE);
                    strArr26[i17] = getValueFromKey(array4.getMap(i17), "region");
                    strArr13[i17] = getValueFromKey(array4.getMap(i17), "postCode");
                    strArr14[i17] = getValueFromKey(array4.getMap(i17), "country");
                    numArr5[i17] = Integer.valueOf(mapStringToPostalAddressType(valueFromKey));
                    strArr16[i17] = valueFromKey;
                    i17++;
                    size3 = i18;
                    str14 = str14;
                    string = string;
                }
                str8 = string;
                i8 = size3;
            } else {
                str8 = string;
                i6 = i5;
                i7 = i2;
                numArr4 = numArr3;
                str9 = string3;
                str10 = string4;
                str11 = string5;
                strArr11 = strArr9;
                strArr12 = strArr10;
                i8 = 0;
                strArr13 = null;
                strArr14 = null;
                strArr15 = null;
                strArr16 = null;
                numArr5 = null;
                strArr17 = null;
                strArr18 = null;
            }
            ReadableArray array5 = readableMap.hasKey("imAddresses") ? readableMap.getArray("imAddresses") : null;
            if (array5 != null) {
                int size4 = array5.size();
                strArr20 = new String[size4];
                strArr21 = new String[size4];
                String[] strArr27 = new String[size4];
                strArr19 = strArr14;
                int i19 = 0;
                while (i19 < size4) {
                    int i20 = size4;
                    ReadableMap map4 = array5.getMap(i19);
                    ReadableArray readableArray7 = array5;
                    strArr20[i19] = map4.getString("username");
                    strArr21[i19] = map4.getString("service");
                    strArr27[i19] = map4.hasKey("id") ? map4.getString("id") : null;
                    i19++;
                    size4 = i20;
                    array5 = readableArray7;
                }
                readableArray3 = array5;
                i9 = size4;
            } else {
                readableArray3 = array5;
                strArr19 = strArr14;
                i9 = 0;
                strArr20 = null;
                strArr21 = null;
            }
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            String[] strArr28 = strArr21;
            String[] strArr29 = strArr20;
            int i21 = i9;
            String[] strArr30 = strArr13;
            String[] strArr31 = strArr15;
            arrayList.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=?", new String[]{str8}).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", str9).withValue("data5", str10).withValue("data3", str11).withValue("data4", str3).withValue("data6", str4).build());
            ContentProviderOperation.Builder withValue2 = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype = ?", new String[]{str8, "vnd.android.cursor.item/organization"}).withValue("data1", str5).withValue("data4", str6).withValue("data5", str7);
            arrayList.add(withValue2.build());
            withValue2.withYieldAllowed(true);
            if (readableArray != null) {
                str13 = "data5";
                str12 = "data4";
                strArr22 = strArr18;
                arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/phone_v2", str}).build());
                int i22 = i7;
                int i23 = 0;
                while (i23 < i22) {
                    int i24 = i22;
                    String str16 = str;
                    arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", str16).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", strArr6[i23]).withValue("data2", numArr2[i23]).withValue("data3", strArr3[i23]).build());
                    i23++;
                    strArr17 = strArr17;
                    str = str16;
                    i22 = i24;
                }
            } else {
                str12 = "data4";
                str13 = "data5";
                strArr22 = strArr18;
            }
            String str17 = str;
            String[] strArr32 = strArr17;
            int i25 = i4;
            int i26 = 0;
            while (i26 < i25) {
                if (strArr8[i26] == null) {
                    i10 = i25;
                    withValue = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", str17).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", strArr7[i26]);
                    strArr23 = strArr16;
                } else {
                    i10 = i25;
                    strArr23 = strArr16;
                    withValue = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=?", new String[]{String.valueOf(strArr8[i26])}).withValue("data1", strArr7[i26]);
                }
                arrayList.add(withValue.build());
                i26++;
                strArr16 = strArr23;
                i25 = i10;
            }
            String[] strArr33 = strArr16;
            if (readableArray2 != null) {
                arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/email_v2", str17}).build());
                int i27 = i6;
                for (int i28 = 0; i28 < i27; i28++) {
                    arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", str17).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", strArr11[i28]).withValue("data2", numArr4[i28]).withValue("data3", strArr12[i28]).build());
                }
            }
            if (str2 != null && !str2.isEmpty() && (thumbnailBitmap = getThumbnailBitmap(str2)) != null) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", toByteArray(thumbnailBitmap)).build());
            }
            if (array4 != null) {
                arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/postal-address_v2", str17}).build());
                for (int i29 = 0; i29 < i8; i29++) {
                    arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", str17).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", numArr5[i29]).withValue("data3", strArr33[i29]).withValue(str12, strArr32[i29]).withValue("data7", strArr22[i29]).withValue("data8", strArr31[i29]).withValue("data9", strArr30[i29]).withValue("data10", strArr19[i29]).build());
                }
            }
            if (readableArray3 != null) {
                arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/im", str17}).build());
                for (int i30 = 0; i30 < i21; i30++) {
                    arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", str17).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", strArr29[i30]).withValue("data2", 1).withValue(str13, "data6").withValue("data6", strArr28[i30]).build());
                }
            }
            try {
                ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
                ContentProviderResult[] applyBatch = contentResolver.applyBatch("com.android.contacts", arrayList);
                if (applyBatch == null || applyBatch.length <= 0) {
                    return;
                }
                callback2 = callback;
                try {
                    callback2.invoke(null, new com.rt2zz.reactnativecontacts.a(contentResolver).b(str8));
                } catch (Exception e2) {
                    e = e2;
                    callback2.invoke(e.toString());
                }
            } catch (Exception e3) {
                e = e3;
                callback2 = callback;
            }
        } else {
            callback.invoke("Invalid recordId or rawContactId");
        }
    }

    @ReactMethod
    public void writePhotoToPath(String str, String str2, Callback callback) {
        new h(str, str2, callback).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }
}