package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.support.v4.p002f.C0136a;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class C0372z extends DataSetObservable {
    private static final String f2460a = C0372z.class.getSimpleName();
    private static final Object f2461b = new Object();
    private static final Map f2462c = new HashMap();
    private final Object f2463d;
    private final List f2464e;
    private final List f2465f;
    private final Context f2466g;
    private final String f2467h;
    private Intent f2468i;
    private ac f2469j;
    private int f2470k;
    private boolean f2471l;
    private boolean f2472m;
    private boolean f2473n;
    private boolean f2474o;
    private ae f2475p;

    private boolean m4942a(ad adVar) {
        boolean add = this.f2465f.add(adVar);
        if (add) {
            this.f2473n = true;
            m4951i();
            m4946d();
            m4948f();
            notifyChanged();
        }
        return add;
    }

    private void m4946d() {
        if (!this.f2472m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f2473n) {
            this.f2473n = false;
            if (!TextUtils.isEmpty(this.f2467h)) {
                C0136a.m1457a(new af(), new ArrayList(this.f2465f), this.f2467h);
            }
        }
    }

    private void m4947e() {
        int g = m4949g() | m4950h();
        m4951i();
        if (g != 0) {
            m4948f();
            notifyChanged();
        }
    }

    private boolean m4948f() {
        if (this.f2469j == null || this.f2468i == null || this.f2464e.isEmpty() || this.f2465f.isEmpty()) {
            return false;
        }
        this.f2469j.m4008a(this.f2468i, this.f2464e, Collections.unmodifiableList(this.f2465f));
        return true;
    }

    private boolean m4949g() {
        if (!this.f2474o || this.f2468i == null) {
            return false;
        }
        this.f2474o = false;
        this.f2464e.clear();
        List queryIntentActivities = this.f2466g.getPackageManager().queryIntentActivities(this.f2468i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f2464e.add(new ab(this, (ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean m4950h() {
        if (!this.f2471l || !this.f2473n || TextUtils.isEmpty(this.f2467h)) {
            return false;
        }
        this.f2471l = false;
        this.f2472m = true;
        m4952j();
        return true;
    }

    private void m4951i() {
        int size = this.f2465f.size() - this.f2470k;
        if (size > 0) {
            this.f2473n = true;
            for (int i = 0; i < size; i++) {
                ad adVar = (ad) this.f2465f.remove(0);
            }
        }
    }

    private void m4952j() {
        try {
            InputStream openFileInput = this.f2466g.openFileInput(this.f2467h);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.f2465f;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new ad(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(f2460a, "Error reading historical recrod file: " + this.f2467h, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(f2460a, "Error reading historical recrod file: " + this.f2467h, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }

    public int m4953a() {
        int size;
        synchronized (this.f2463d) {
            m4947e();
            size = this.f2464e.size();
        }
        return size;
    }

    public int m4954a(ResolveInfo resolveInfo) {
        synchronized (this.f2463d) {
            m4947e();
            List list = this.f2464e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((ab) list.get(i)).f1904a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo m4955a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f2463d) {
            m4947e();
            resolveInfo = ((ab) this.f2464e.get(i)).f1904a;
        }
        return resolveInfo;
    }

    public Intent m4956b(int i) {
        synchronized (this.f2463d) {
            if (this.f2468i == null) {
                return null;
            }
            m4947e();
            ab abVar = (ab) this.f2464e.get(i);
            ComponentName componentName = new ComponentName(abVar.f1904a.activityInfo.packageName, abVar.f1904a.activityInfo.name);
            Intent intent = new Intent(this.f2468i);
            intent.setComponent(componentName);
            if (this.f2475p != null) {
                if (this.f2475p.m4009a(this, new Intent(intent))) {
                    return null;
                }
            }
            m4942a(new ad(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo m4957b() {
        synchronized (this.f2463d) {
            m4947e();
            if (this.f2464e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((ab) this.f2464e.get(0)).f1904a;
            return resolveInfo;
        }
    }

    public void m4958c(int i) {
        synchronized (this.f2463d) {
            m4947e();
            ab abVar = (ab) this.f2464e.get(i);
            ab abVar2 = (ab) this.f2464e.get(0);
            m4942a(new ad(new ComponentName(abVar.f1904a.activityInfo.packageName, abVar.f1904a.activityInfo.name), System.currentTimeMillis(), abVar2 != null ? (abVar2.f1905b - abVar.f1905b) + 5.0f : 1.0f));
        }
    }
}
