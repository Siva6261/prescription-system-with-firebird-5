package android.support.v4.p006b;

import android.os.Build.VERSION;
import android.support.v4.p015h.C0166a;
import android.support.v4.p015h.C0171e;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class C0084n extends az implements Runnable {
    static final boolean f735a = (VERSION.SDK_INT >= 21);
    final am f736b;
    C0088r f737c;
    C0088r f738d;
    int f739e;
    int f740f;
    int f741g;
    int f742h;
    int f743i;
    int f744j;
    int f745k;
    boolean f746l;
    boolean f747m = true;
    String f748n;
    boolean f749o;
    int f750p = -1;
    int f751q;
    CharSequence f752r;
    int f753s;
    CharSequence f754t;
    ArrayList f755u;
    ArrayList f756v;

    public C0084n(am amVar) {
        this.f736b = amVar;
    }

    private C0089s m1261a(SparseArray sparseArray, SparseArray sparseArray2, boolean z) {
        int i = 0;
        m1280a(sparseArray2);
        C0089s c0089s = new C0089s(this);
        c0089s.f784d = new View(this.f736b.f638o.m1000g());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4 = m1283a(sparseArray.keyAt(i2), c0089s, z, sparseArray, sparseArray2) ? 1 : i3;
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && m1283a(i4, c0089s, z, sparseArray, sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        return i3 == 0 ? null : c0089s;
    }

    private C0166a m1263a(C0089s c0089s, C0051y c0051y, boolean z) {
        C0166a c0166a = new C0166a();
        if (this.f755u != null) {
            ba.m1181a((Map) c0166a, c0051y.m880q());
            if (z) {
                c0166a.m1506a(this.f756v);
            } else {
                c0166a = C0084n.m1265a(this.f755u, this.f756v, c0166a);
            }
        }
        if (z) {
            if (c0051y.ag != null) {
                c0051y.ag.m1239a(this.f756v, c0166a);
            }
            m1275a(c0089s, c0166a, false);
        } else {
            if (c0051y.ah != null) {
                c0051y.ah.m1239a(this.f756v, c0166a);
            }
            m1286b(c0089s, c0166a, false);
        }
        return c0166a;
    }

    private C0166a m1264a(C0089s c0089s, boolean z, C0051y c0051y) {
        C0166a b = m1284b(c0089s, c0051y, z);
        if (z) {
            if (c0051y.ah != null) {
                c0051y.ah.m1239a(this.f756v, b);
            }
            m1275a(c0089s, b, true);
        } else {
            if (c0051y.ag != null) {
                c0051y.ag.m1239a(this.f756v, b);
            }
            m1286b(c0089s, b, true);
        }
        return b;
    }

    private static C0166a m1265a(ArrayList arrayList, ArrayList arrayList2, C0166a c0166a) {
        if (c0166a.isEmpty()) {
            return c0166a;
        }
        C0166a c0166a2 = new C0166a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) c0166a.get(arrayList.get(i));
            if (view != null) {
                c0166a2.put(arrayList2.get(i), view);
            }
        }
        return c0166a2;
    }

    private static Object m1266a(C0051y c0051y, C0051y c0051y2, boolean z) {
        if (c0051y == null || c0051y2 == null) {
            return null;
        }
        return ba.m1186b(z ? c0051y2.m813B() : c0051y.m812A());
    }

    private static Object m1267a(C0051y c0051y, boolean z) {
        if (c0051y == null) {
            return null;
        }
        return ba.m1167a(z ? c0051y.m889z() : c0051y.m886w());
    }

    private static Object m1268a(Object obj, C0051y c0051y, ArrayList arrayList, C0166a c0166a, View view) {
        return obj != null ? ba.m1168a(obj, c0051y.m880q(), arrayList, c0166a, view) : obj;
    }

    private void m1269a(int i, C0051y c0051y, String str, int i2) {
        c0051y.f475B = this.f736b;
        if (str != null) {
            if (c0051y.f481H == null || str.equals(c0051y.f481H)) {
                c0051y.f481H = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + c0051y + ": was " + c0051y.f481H + " now " + str);
            }
        }
        if (i != 0) {
            if (c0051y.f479F == 0 || c0051y.f479F == i) {
                c0051y.f479F = i;
                c0051y.f480G = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + c0051y + ": was " + c0051y.f479F + " now " + i);
            }
        }
        C0088r c0088r = new C0088r();
        c0088r.f774c = i2;
        c0088r.f775d = c0051y;
        m1296a(c0088r);
    }

    private void m1273a(C0089s c0089s, int i, Object obj) {
        if (this.f736b.f630g != null) {
            for (int i2 = 0; i2 < this.f736b.f630g.size(); i2++) {
                C0051y c0051y = (C0051y) this.f736b.f630g.get(i2);
                if (!(c0051y.f491R == null || c0051y.f490Q == null || c0051y.f480G != i)) {
                    if (!c0051y.f482I) {
                        ba.m1176a(obj, c0051y.f491R, false);
                        c0089s.f782b.remove(c0051y.f491R);
                    } else if (!c0089s.f782b.contains(c0051y.f491R)) {
                        ba.m1176a(obj, c0051y.f491R, true);
                        c0089s.f782b.add(c0051y.f491R);
                    }
                }
            }
        }
    }

    private void m1274a(C0089s c0089s, C0051y c0051y, C0051y c0051y2, boolean z, C0166a c0166a) {
        br brVar = z ? c0051y2.ag : c0051y.ag;
        if (brVar != null) {
            brVar.m1240b(new ArrayList(c0166a.keySet()), new ArrayList(c0166a.values()), null);
        }
    }

    private void m1275a(C0089s c0089s, C0166a c0166a, boolean z) {
        int size = this.f756v == null ? 0 : this.f756v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f755u.get(i);
            View view = (View) c0166a.get((String) this.f756v.get(i));
            if (view != null) {
                String a = ba.m1170a(view);
                if (z) {
                    C0084n.m1279a(c0089s.f781a, str, a);
                } else {
                    C0084n.m1279a(c0089s.f781a, a, str);
                }
            }
        }
    }

    private void m1276a(C0089s c0089s, View view, Object obj, C0051y c0051y, C0051y c0051y2, boolean z, ArrayList arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new C0086p(this, view, obj, arrayList, c0089s, z, c0051y, c0051y2));
    }

    private static void m1277a(C0089s c0089s, ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                C0084n.m1279a(c0089s.f781a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m1278a(C0166a c0166a, C0089s c0089s) {
        if (this.f756v != null && !c0166a.isEmpty()) {
            View view = (View) c0166a.get(this.f756v.get(0));
            if (view != null) {
                c0089s.f783c.f706a = view;
            }
        }
    }

    private static void m1279a(C0166a c0166a, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < c0166a.size(); i++) {
                if (str.equals(c0166a.m1503c(i))) {
                    c0166a.m1499a(i, (Object) str2);
                    return;
                }
            }
            c0166a.put(str, str2);
        }
    }

    private void m1280a(SparseArray sparseArray) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            C0051y c0051y = (C0051y) sparseArray.valueAt(i);
            if (c0051y.f500k < 1) {
                this.f736b.m1108d(c0051y);
                this.f736b.m1088a(c0051y, 1, 0, 0, false);
            }
        }
    }

    private static void m1281a(SparseArray sparseArray, SparseArray sparseArray2, C0051y c0051y) {
        if (c0051y != null) {
            int i = c0051y.f480G;
            if (i != 0 && !c0051y.m879p()) {
                if (c0051y.m878o() && c0051y.m880q() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, c0051y);
                }
                if (sparseArray2.get(i) == c0051y) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void m1282a(View view, C0089s c0089s, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new C0087q(this, view, c0089s, i, obj));
    }

    private boolean m1283a(int i, C0089s c0089s, boolean z, SparseArray sparseArray, SparseArray sparseArray2) {
        View view = (ViewGroup) this.f736b.f639p.mo167a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object a;
        View view2;
        bg c0085o;
        ArrayList arrayList2;
        Map c0166a;
        boolean z2;
        Object a2;
        C0051y c0051y = (C0051y) sparseArray2.get(i);
        C0051y c0051y2 = (C0051y) sparseArray.get(i);
        Object a3 = C0084n.m1267a(c0051y, z);
        Object a4 = C0084n.m1266a(c0051y, c0051y2, z);
        Object b = C0084n.m1285b(c0051y2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (a4 != null) {
            map = m1263a(c0089s, c0051y2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (a3 != null && obj == null && b == null) {
                    return false;
                }
                arrayList = new ArrayList();
                a = C0084n.m1268a(b, c0051y2, arrayList, (C0166a) map, c0089s.f784d);
                if (!(this.f756v == null || map == null)) {
                    view2 = (View) map.get(this.f756v.get(0));
                    if (view2 != null) {
                        if (a != null) {
                            ba.m1174a(a, view2);
                        }
                        if (obj != null) {
                            ba.m1174a(obj, view2);
                        }
                    }
                }
                c0085o = new C0085o(this, c0051y);
                arrayList2 = new ArrayList();
                c0166a = new C0166a();
                z2 = true;
                if (c0051y != null) {
                    z2 = z ? c0051y.m815D() : c0051y.m814C();
                }
                a2 = ba.m1169a(a3, a, obj, z2);
                if (a2 != null) {
                    ba.m1177a(a3, obj, view, c0085o, c0089s.f784d, c0089s.f783c, (Map) c0089s.f781a, arrayList2, map, c0166a, arrayList3);
                    m1282a(view, c0089s, i, a2);
                    ba.m1176a(a2, c0089s.f784d, true);
                    m1273a(c0089s, i, a2);
                    ba.m1173a((ViewGroup) view, a2);
                    ba.m1172a(view, c0089s.f784d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0089s.f782b, c0166a);
                }
                return a2 == null;
            } else {
                br brVar = z ? c0051y2.ag : c0051y.ag;
                if (brVar != null) {
                    brVar.m1238a(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
                }
                m1276a(c0089s, view, a4, c0051y, c0051y2, z, arrayList3);
            }
        }
        obj = a4;
        if (a3 != null) {
        }
        arrayList = new ArrayList();
        a = C0084n.m1268a(b, c0051y2, arrayList, (C0166a) map, c0089s.f784d);
        view2 = (View) map.get(this.f756v.get(0));
        if (view2 != null) {
            if (a != null) {
                ba.m1174a(a, view2);
            }
            if (obj != null) {
                ba.m1174a(obj, view2);
            }
        }
        c0085o = new C0085o(this, c0051y);
        arrayList2 = new ArrayList();
        c0166a = new C0166a();
        z2 = true;
        if (c0051y != null) {
            if (z) {
            }
        }
        a2 = ba.m1169a(a3, a, obj, z2);
        if (a2 != null) {
            ba.m1177a(a3, obj, view, c0085o, c0089s.f784d, c0089s.f783c, (Map) c0089s.f781a, arrayList2, map, c0166a, arrayList3);
            m1282a(view, c0089s, i, a2);
            ba.m1176a(a2, c0089s.f784d, true);
            m1273a(c0089s, i, a2);
            ba.m1173a((ViewGroup) view, a2);
            ba.m1172a(view, c0089s.f784d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0089s.f782b, c0166a);
        }
        if (a2 == null) {
        }
    }

    private C0166a m1284b(C0089s c0089s, C0051y c0051y, boolean z) {
        C0166a c0166a = new C0166a();
        View q = c0051y.m880q();
        if (q == null || this.f755u == null) {
            return c0166a;
        }
        ba.m1181a((Map) c0166a, q);
        if (z) {
            return C0084n.m1265a(this.f755u, this.f756v, c0166a);
        }
        c0166a.m1506a(this.f756v);
        return c0166a;
    }

    private static Object m1285b(C0051y c0051y, boolean z) {
        if (c0051y == null) {
            return null;
        }
        return ba.m1167a(z ? c0051y.m887x() : c0051y.m888y());
    }

    private void m1286b(C0089s c0089s, C0166a c0166a, boolean z) {
        int size = c0166a.size();
        for (int i = 0; i < size; i++) {
            String str = (String) c0166a.m1502b(i);
            String a = ba.m1170a((View) c0166a.m1503c(i));
            if (z) {
                C0084n.m1279a(c0089s.f781a, str, a);
            } else {
                C0084n.m1279a(c0089s.f781a, a, str);
            }
        }
    }

    private void m1287b(SparseArray sparseArray, SparseArray sparseArray2) {
        if (this.f736b.f639p.mo168a()) {
            for (C0088r c0088r = this.f737c; c0088r != null; c0088r = c0088r.f772a) {
                switch (c0088r.f774c) {
                    case 1:
                        m1288b(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    case 2:
                        C0051y c0051y = c0088r.f775d;
                        if (this.f736b.f630g != null) {
                            C0051y c0051y2 = c0051y;
                            for (int i = 0; i < this.f736b.f630g.size(); i++) {
                                C0051y c0051y3 = (C0051y) this.f736b.f630g.get(i);
                                if (c0051y2 == null || c0051y3.f480G == c0051y2.f480G) {
                                    if (c0051y3 == c0051y2) {
                                        c0051y2 = null;
                                        sparseArray2.remove(c0051y3.f480G);
                                    } else {
                                        C0084n.m1281a(sparseArray, sparseArray2, c0051y3);
                                    }
                                }
                            }
                        }
                        m1288b(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    case 3:
                        C0084n.m1281a(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    case 4:
                        C0084n.m1281a(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    case 5:
                        m1288b(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    case 6:
                        C0084n.m1281a(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    case 7:
                        m1288b(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void m1288b(SparseArray sparseArray, SparseArray sparseArray2, C0051y c0051y) {
        if (c0051y != null) {
            int i = c0051y.f480G;
            if (i != 0) {
                if (!c0051y.m878o()) {
                    sparseArray2.put(i, c0051y);
                }
                if (sparseArray.get(i) == c0051y) {
                    sparseArray.remove(i);
                }
            }
        }
    }

    public int mo202a() {
        return m1290a(false);
    }

    int m1290a(boolean z) {
        if (this.f749o) {
            throw new IllegalStateException("commit already called");
        }
        if (am.f623a) {
            Log.v("FragmentManager", "Commit: " + this);
            m1298a("  ", null, new PrintWriter(new C0171e("FragmentManager")), null);
        }
        this.f749o = true;
        if (this.f746l) {
            this.f750p = this.f736b.m1071a(this);
        } else {
            this.f750p = -1;
        }
        this.f736b.m1090a((Runnable) this, z);
        return this.f750p;
    }

    public az mo203a(int i, C0051y c0051y) {
        m1269a(i, c0051y, null, 1);
        return this;
    }

    public az mo204a(C0051y c0051y) {
        C0088r c0088r = new C0088r();
        c0088r.f774c = 3;
        c0088r.f775d = c0051y;
        m1296a(c0088r);
        return this;
    }

    public az mo205a(C0051y c0051y, String str) {
        m1269a(0, c0051y, str, 1);
        return this;
    }

    public C0089s m1294a(boolean z, C0089s c0089s, SparseArray sparseArray, SparseArray sparseArray2) {
        if (am.f623a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m1298a("  ", null, new PrintWriter(new C0171e("FragmentManager")), null);
        }
        if (f735a) {
            if (c0089s == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    c0089s = m1261a(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                C0084n.m1277a(c0089s, this.f756v, this.f755u);
            }
        }
        m1295a(-1);
        int i = c0089s != null ? 0 : this.f745k;
        int i2 = c0089s != null ? 0 : this.f744j;
        C0088r c0088r = this.f738d;
        while (c0088r != null) {
            int i3 = c0089s != null ? 0 : c0088r.f778g;
            int i4 = c0089s != null ? 0 : c0088r.f779h;
            C0051y c0051y;
            C0051y c0051y2;
            switch (c0088r.f774c) {
                case 1:
                    c0051y = c0088r.f775d;
                    c0051y.f489P = i4;
                    this.f736b.m1087a(c0051y, am.m1069c(i2), i);
                    break;
                case 2:
                    c0051y = c0088r.f775d;
                    if (c0051y != null) {
                        c0051y.f489P = i4;
                        this.f736b.m1087a(c0051y, am.m1069c(i2), i);
                    }
                    if (c0088r.f780i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < c0088r.f780i.size(); i5++) {
                        c0051y2 = (C0051y) c0088r.f780i.get(i5);
                        c0051y2.f489P = i3;
                        this.f736b.m1089a(c0051y2, false);
                    }
                    break;
                case 3:
                    c0051y2 = c0088r.f775d;
                    c0051y2.f489P = i3;
                    this.f736b.m1089a(c0051y2, false);
                    break;
                case 4:
                    c0051y2 = c0088r.f775d;
                    c0051y2.f489P = i3;
                    this.f736b.m1105c(c0051y2, am.m1069c(i2), i);
                    break;
                case 5:
                    c0051y = c0088r.f775d;
                    c0051y.f489P = i4;
                    this.f736b.m1100b(c0051y, am.m1069c(i2), i);
                    break;
                case 6:
                    c0051y2 = c0088r.f775d;
                    c0051y2.f489P = i3;
                    this.f736b.m1111e(c0051y2, am.m1069c(i2), i);
                    break;
                case 7:
                    c0051y2 = c0088r.f775d;
                    c0051y2.f489P = i3;
                    this.f736b.m1109d(c0051y2, am.m1069c(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0088r.f774c);
            }
            c0088r = c0088r.f773b;
        }
        if (z) {
            this.f736b.m1080a(this.f736b.f637n, am.m1069c(i2), i, true);
            c0089s = null;
        }
        if (this.f750p >= 0) {
            this.f736b.m1097b(this.f750p);
            this.f750p = -1;
        }
        return c0089s;
    }

    void m1295a(int i) {
        if (this.f746l) {
            if (am.f623a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0088r c0088r = this.f737c; c0088r != null; c0088r = c0088r.f772a) {
                C0051y c0051y;
                if (c0088r.f775d != null) {
                    c0051y = c0088r.f775d;
                    c0051y.f474A += i;
                    if (am.f623a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0088r.f775d + " to " + c0088r.f775d.f474A);
                    }
                }
                if (c0088r.f780i != null) {
                    for (int size = c0088r.f780i.size() - 1; size >= 0; size--) {
                        c0051y = (C0051y) c0088r.f780i.get(size);
                        c0051y.f474A += i;
                        if (am.f623a) {
                            Log.v("FragmentManager", "Bump nesting of " + c0051y + " to " + c0051y.f474A);
                        }
                    }
                }
            }
        }
    }

    void m1296a(C0088r c0088r) {
        if (this.f737c == null) {
            this.f738d = c0088r;
            this.f737c = c0088r;
        } else {
            c0088r.f773b = this.f738d;
            this.f738d.f772a = c0088r;
            this.f738d = c0088r;
        }
        c0088r.f776e = this.f740f;
        c0088r.f777f = this.f741g;
        c0088r.f778g = this.f742h;
        c0088r.f779h = this.f743i;
        this.f739e++;
    }

    public void m1297a(SparseArray sparseArray, SparseArray sparseArray2) {
        if (this.f736b.f639p.mo168a()) {
            for (C0088r c0088r = this.f738d; c0088r != null; c0088r = c0088r.f773b) {
                switch (c0088r.f774c) {
                    case 1:
                        C0084n.m1281a(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    case 2:
                        if (c0088r.f780i != null) {
                            for (int size = c0088r.f780i.size() - 1; size >= 0; size--) {
                                m1288b(sparseArray, sparseArray2, (C0051y) c0088r.f780i.get(size));
                            }
                        }
                        C0084n.m1281a(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    case 3:
                        m1288b(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    case 4:
                        m1288b(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    case 5:
                        C0084n.m1281a(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    case 6:
                        m1288b(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    case 7:
                        C0084n.m1281a(sparseArray, sparseArray2, c0088r.f775d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m1298a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m1299a(str, printWriter, true);
    }

    public void m1299a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f748n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f750p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f749o);
            if (this.f744j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f744j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f745k));
            }
            if (!(this.f740f == 0 && this.f741g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f740f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f741g));
            }
            if (!(this.f742h == 0 && this.f743i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f742h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f743i));
            }
            if (!(this.f751q == 0 && this.f752r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f751q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f752r);
            }
            if (!(this.f753s == 0 && this.f754t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f753s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f754t);
            }
        }
        if (this.f737c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0088r c0088r = this.f737c;
            while (c0088r != null) {
                String str3;
                switch (c0088r.f774c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0088r.f774c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0088r.f775d);
                if (z) {
                    if (!(c0088r.f776e == 0 && c0088r.f777f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0088r.f776e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0088r.f777f));
                    }
                    if (!(c0088r.f778g == 0 && c0088r.f779h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0088r.f778g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0088r.f779h));
                    }
                }
                if (c0088r.f780i != null && c0088r.f780i.size() > 0) {
                    for (int i2 = 0; i2 < c0088r.f780i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0088r.f780i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0088r.f780i.get(i2));
                    }
                }
                c0088r = c0088r.f772a;
                i++;
            }
        }
    }

    public int mo206b() {
        return m1290a(true);
    }

    public String m1301c() {
        return this.f748n;
    }

    public void run() {
        if (am.f623a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f746l || this.f750p >= 0) {
            C0089s a;
            m1295a(1);
            if (f735a) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m1287b(sparseArray, sparseArray2);
                a = m1261a(sparseArray, sparseArray2, false);
            } else {
                a = null;
            }
            int i = a != null ? 0 : this.f745k;
            int i2 = a != null ? 0 : this.f744j;
            C0088r c0088r = this.f737c;
            while (c0088r != null) {
                int i3 = a != null ? 0 : c0088r.f776e;
                int i4 = a != null ? 0 : c0088r.f777f;
                C0051y c0051y;
                switch (c0088r.f774c) {
                    case 1:
                        c0051y = c0088r.f775d;
                        c0051y.f489P = i3;
                        this.f736b.m1089a(c0051y, false);
                        break;
                    case 2:
                        C0051y c0051y2 = c0088r.f775d;
                        int i5 = c0051y2.f480G;
                        if (this.f736b.f630g != null) {
                            int size = this.f736b.f630g.size() - 1;
                            while (size >= 0) {
                                c0051y = (C0051y) this.f736b.f630g.get(size);
                                if (am.f623a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + c0051y2 + " old=" + c0051y);
                                }
                                if (c0051y.f480G == i5) {
                                    if (c0051y == c0051y2) {
                                        c0051y = null;
                                        c0088r.f775d = null;
                                        size--;
                                        c0051y2 = c0051y;
                                    } else {
                                        if (c0088r.f780i == null) {
                                            c0088r.f780i = new ArrayList();
                                        }
                                        c0088r.f780i.add(c0051y);
                                        c0051y.f489P = i4;
                                        if (this.f746l) {
                                            c0051y.f474A++;
                                            if (am.f623a) {
                                                Log.v("FragmentManager", "Bump nesting of " + c0051y + " to " + c0051y.f474A);
                                            }
                                        }
                                        this.f736b.m1087a(c0051y, i2, i);
                                    }
                                }
                                c0051y = c0051y2;
                                size--;
                                c0051y2 = c0051y;
                            }
                        }
                        if (c0051y2 == null) {
                            break;
                        }
                        c0051y2.f489P = i3;
                        this.f736b.m1089a(c0051y2, false);
                        break;
                    case 3:
                        c0051y = c0088r.f775d;
                        c0051y.f489P = i4;
                        this.f736b.m1087a(c0051y, i2, i);
                        break;
                    case 4:
                        c0051y = c0088r.f775d;
                        c0051y.f489P = i4;
                        this.f736b.m1100b(c0051y, i2, i);
                        break;
                    case 5:
                        c0051y = c0088r.f775d;
                        c0051y.f489P = i3;
                        this.f736b.m1105c(c0051y, i2, i);
                        break;
                    case 6:
                        c0051y = c0088r.f775d;
                        c0051y.f489P = i4;
                        this.f736b.m1109d(c0051y, i2, i);
                        break;
                    case 7:
                        c0051y = c0088r.f775d;
                        c0051y.f489P = i3;
                        this.f736b.m1111e(c0051y, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0088r.f774c);
                }
                c0088r = c0088r.f772a;
            }
            this.f736b.m1080a(this.f736b.f637n, i2, i, true);
            if (this.f746l) {
                this.f736b.m1098b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f750p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f750p);
        }
        if (this.f748n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f748n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
