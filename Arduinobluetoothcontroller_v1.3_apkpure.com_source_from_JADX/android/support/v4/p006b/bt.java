package android.support.v4.p006b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p008c.C0066a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class bt implements Iterable {
    private static final bv f731a;
    private final ArrayList f732b = new ArrayList();
    private final Context f733c;

    static {
        if (VERSION.SDK_INT >= 11) {
            f731a = new bx();
        } else {
            f731a = new bw();
        }
    }

    private bt(Context context) {
        this.f733c = context;
    }

    public static bt m1241a(Context context) {
        return new bt(context);
    }

    public bt m1242a(Activity activity) {
        Intent intent = null;
        if (activity instanceof bu) {
            intent = ((bu) activity).mo570a();
        }
        Intent a = intent == null ? bl.m1214a(activity) : intent;
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f733c.getPackageManager());
            }
            m1243a(component);
            m1244a(a);
        }
        return this;
    }

    public bt m1243a(ComponentName componentName) {
        int size = this.f732b.size();
        try {
            Intent a = bl.m1215a(this.f733c, componentName);
            while (a != null) {
                this.f732b.add(size, a);
                a = bl.m1215a(this.f733c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public bt m1244a(Intent intent) {
        this.f732b.add(intent);
        return this;
    }

    public void m1245a() {
        m1246a(null);
    }

    public void m1246a(Bundle bundle) {
        if (this.f732b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f732b.toArray(new Intent[this.f732b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!C0066a.m959a(this.f733c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f733c.startActivity(intent);
        }
    }

    public Iterator iterator() {
        return this.f732b.iterator();
    }
}
