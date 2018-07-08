package io.realm.internal.p028a;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class C0442b {
    private static File m5638a(Context context) {
        return context.getDir("lib", 0);
    }

    public static void m5639a(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        } else {
            try {
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError e) {
                File b = C0442b.m5642b(context, str);
                if (!b.exists()) {
                    C0442b.m5643c(context, str);
                }
                System.load(b.getAbsolutePath());
            }
        }
    }

    private static void m5640a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    private static void m5641a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static File m5642b(Context context, String str) {
        return new File(C0442b.m5638a(context), System.mapLibraryName(str));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m5643c(android.content.Context r12, java.lang.String r13) {
        /*
        r10 = 5;
        r2 = 0;
        r5 = 0;
        r4 = r12.getApplicationInfo();	 Catch:{ all -> 0x010d }
        r0 = r5;
    L_0x0008:
        r1 = r0 + 1;
        if (r0 >= r10) goto L_0x0121;
    L_0x000c:
        r3 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x0021 }
        r0 = new java.io.File;	 Catch:{ IOException -> 0x0021 }
        r6 = r4.sourceDir;	 Catch:{ IOException -> 0x0021 }
        r0.<init>(r6);	 Catch:{ IOException -> 0x0021 }
        r6 = 1;
        r3.<init>(r0, r6);	 Catch:{ IOException -> 0x0021 }
    L_0x0019:
        if (r3 != 0) goto L_0x0024;
    L_0x001b:
        if (r3 == 0) goto L_0x0020;
    L_0x001d:
        r3.close();	 Catch:{ IOException -> 0x0107 }
    L_0x0020:
        return;
    L_0x0021:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0008;
    L_0x0024:
        r0 = r5;
    L_0x0025:
        r6 = r0 + 1;
        if (r0 >= r10) goto L_0x00dc;
    L_0x0029:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x006f }
        r1 = 21;
        if (r0 < r1) goto L_0x007a;
    L_0x002f:
        r0 = android.os.Build.SUPPORTED_ABIS;	 Catch:{ all -> 0x006f }
        r0 = r0.length;	 Catch:{ all -> 0x006f }
        if (r0 <= 0) goto L_0x007a;
    L_0x0034:
        r7 = android.os.Build.SUPPORTED_ABIS;	 Catch:{ all -> 0x006f }
        r8 = r7.length;	 Catch:{ all -> 0x006f }
        r4 = r5;
        r0 = r2;
        r1 = r2;
    L_0x003a:
        if (r4 >= r8) goto L_0x0065;
    L_0x003c:
        r0 = r7[r4];	 Catch:{ all -> 0x006f }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006f }
        r1.<init>();	 Catch:{ all -> 0x006f }
        r9 = "lib/";
        r1 = r1.append(r9);	 Catch:{ all -> 0x006f }
        r0 = r1.append(r0);	 Catch:{ all -> 0x006f }
        r1 = "/";
        r0 = r0.append(r1);	 Catch:{ all -> 0x006f }
        r1 = java.lang.System.mapLibraryName(r13);	 Catch:{ all -> 0x006f }
        r0 = r0.append(r1);	 Catch:{ all -> 0x006f }
        r1 = r0.toString();	 Catch:{ all -> 0x006f }
        r0 = r3.getEntry(r1);	 Catch:{ all -> 0x006f }
        if (r0 == 0) goto L_0x0077;
    L_0x0065:
        if (r0 != 0) goto L_0x00a8;
    L_0x0067:
        if (r1 == 0) goto L_0x00a2;
    L_0x0069:
        r0 = new io.realm.internal.a.c;	 Catch:{ all -> 0x006f }
        r0.<init>(r1);	 Catch:{ all -> 0x006f }
        throw r0;	 Catch:{ all -> 0x006f }
    L_0x006f:
        r0 = move-exception;
        r2 = r3;
    L_0x0071:
        if (r2 == 0) goto L_0x0076;
    L_0x0073:
        r2.close();	 Catch:{ IOException -> 0x010a }
    L_0x0076:
        throw r0;
    L_0x0077:
        r4 = r4 + 1;
        goto L_0x003a;
    L_0x007a:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006f }
        r0.<init>();	 Catch:{ all -> 0x006f }
        r1 = "lib/";
        r0 = r0.append(r1);	 Catch:{ all -> 0x006f }
        r1 = android.os.Build.CPU_ABI;	 Catch:{ all -> 0x006f }
        r0 = r0.append(r1);	 Catch:{ all -> 0x006f }
        r1 = "/";
        r0 = r0.append(r1);	 Catch:{ all -> 0x006f }
        r1 = java.lang.System.mapLibraryName(r13);	 Catch:{ all -> 0x006f }
        r0 = r0.append(r1);	 Catch:{ all -> 0x006f }
        r1 = r0.toString();	 Catch:{ all -> 0x006f }
        r0 = r3.getEntry(r1);	 Catch:{ all -> 0x006f }
        goto L_0x0065;
    L_0x00a2:
        r0 = new io.realm.internal.a.c;	 Catch:{ all -> 0x006f }
        r0.<init>(r13);	 Catch:{ all -> 0x006f }
        throw r0;	 Catch:{ all -> 0x006f }
    L_0x00a8:
        r4 = io.realm.internal.p028a.C0442b.m5642b(r12, r13);	 Catch:{ all -> 0x006f }
        r4.delete();	 Catch:{ all -> 0x006f }
        r1 = r4.createNewFile();	 Catch:{ IOException -> 0x00b8 }
        if (r1 != 0) goto L_0x00bc;
    L_0x00b5:
        r0 = r6;
        goto L_0x0025;
    L_0x00b8:
        r0 = move-exception;
        r0 = r6;
        goto L_0x0025;
    L_0x00bc:
        r1 = r3.getInputStream(r0);	 Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00f2, all -> 0x00fe }
        r0 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x011c, IOException -> 0x0117, all -> 0x0110 }
        r0.<init>(r4);	 Catch:{ FileNotFoundException -> 0x011c, IOException -> 0x0117, all -> 0x0110 }
        io.realm.internal.p028a.C0442b.m5641a(r1, r0);	 Catch:{ FileNotFoundException -> 0x011f, IOException -> 0x011a, all -> 0x0112 }
        io.realm.internal.p028a.C0442b.m5640a(r1);	 Catch:{ all -> 0x006f }
        io.realm.internal.p028a.C0442b.m5640a(r0);	 Catch:{ all -> 0x006f }
        r0 = 1;
        r1 = 0;
        r4.setReadable(r0, r1);	 Catch:{ all -> 0x006f }
        r0 = 1;
        r1 = 0;
        r4.setExecutable(r0, r1);	 Catch:{ all -> 0x006f }
        r0 = 1;
        r4.setWritable(r0);	 Catch:{ all -> 0x006f }
    L_0x00dc:
        if (r3 == 0) goto L_0x0020;
    L_0x00de:
        r3.close();	 Catch:{ IOException -> 0x00e3 }
        goto L_0x0020;
    L_0x00e3:
        r0 = move-exception;
        goto L_0x0020;
    L_0x00e6:
        r0 = move-exception;
        r0 = r2;
        r1 = r2;
    L_0x00e9:
        io.realm.internal.p028a.C0442b.m5640a(r1);	 Catch:{ all -> 0x006f }
        io.realm.internal.p028a.C0442b.m5640a(r0);	 Catch:{ all -> 0x006f }
        r0 = r6;
        goto L_0x0025;
    L_0x00f2:
        r0 = move-exception;
        r0 = r2;
        r1 = r2;
    L_0x00f5:
        io.realm.internal.p028a.C0442b.m5640a(r1);	 Catch:{ all -> 0x006f }
        io.realm.internal.p028a.C0442b.m5640a(r0);	 Catch:{ all -> 0x006f }
        r0 = r6;
        goto L_0x0025;
    L_0x00fe:
        r0 = move-exception;
        r1 = r2;
    L_0x0100:
        io.realm.internal.p028a.C0442b.m5640a(r1);	 Catch:{ all -> 0x006f }
        io.realm.internal.p028a.C0442b.m5640a(r2);	 Catch:{ all -> 0x006f }
        throw r0;	 Catch:{ all -> 0x006f }
    L_0x0107:
        r0 = move-exception;
        goto L_0x0020;
    L_0x010a:
        r1 = move-exception;
        goto L_0x0076;
    L_0x010d:
        r0 = move-exception;
        goto L_0x0071;
    L_0x0110:
        r0 = move-exception;
        goto L_0x0100;
    L_0x0112:
        r2 = move-exception;
        r11 = r2;
        r2 = r0;
        r0 = r11;
        goto L_0x0100;
    L_0x0117:
        r0 = move-exception;
        r0 = r2;
        goto L_0x00f5;
    L_0x011a:
        r4 = move-exception;
        goto L_0x00f5;
    L_0x011c:
        r0 = move-exception;
        r0 = r2;
        goto L_0x00e9;
    L_0x011f:
        r4 = move-exception;
        goto L_0x00e9;
    L_0x0121:
        r3 = r2;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.internal.a.b.c(android.content.Context, java.lang.String):void");
    }
}
