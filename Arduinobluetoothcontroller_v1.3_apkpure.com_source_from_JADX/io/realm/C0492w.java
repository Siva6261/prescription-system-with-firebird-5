package io.realm;

import android.content.Context;
import io.realm.internal.C0473l;
import io.realm.internal.C0475q;
import io.realm.p026a.C0421e;
import io.realm.p026a.C0422a;
import java.io.File;
import java.util.HashSet;

public class C0492w {
    private File f3010a;
    private String f3011b;
    private byte[] f3012c;
    private long f3013d;
    private C0394y f3014e;
    private boolean f3015f;
    private C0475q f3016g;
    private HashSet f3017h = new HashSet();
    private HashSet f3018i = new HashSet();
    private C0421e f3019j;

    public C0492w(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("A non-null Context must be provided");
        }
        C0473l.m5726a(context);
        m5838a(context.getFilesDir());
    }

    private void m5838a(File file) {
        if (file == null || !file.isDirectory()) {
            throw new IllegalArgumentException("An existing folder must be provided. Yours was " + (file != null ? file.getAbsolutePath() : "null"));
        } else if (file.canWrite()) {
            this.f3010a = file;
            this.f3011b = "default.realm";
            this.f3012c = null;
            this.f3013d = 0;
            this.f3014e = null;
            this.f3015f = false;
            this.f3016g = C0475q.FULL;
            if (C0490u.f2997a != null) {
                this.f3017h.add(C0490u.f2997a);
            }
        } else {
            throw new IllegalArgumentException("Folder is not writable: " + file.getAbsolutePath());
        }
    }

    public C0490u m5848a() {
        if (this.f3019j == null && C0490u.m5827l()) {
            this.f3019j = new C0422a();
        }
        return new C0490u();
    }

    public C0492w m5849a(C0394y c0394y) {
        if (c0394y == null) {
            throw new IllegalArgumentException("A non-null migration must be provided");
        }
        this.f3014e = c0394y;
        return this;
    }
}
