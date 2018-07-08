package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.p008c.C0066a;
import android.support.v4.p012e.p013a.C0133a;
import android.support.v4.view.C0227n;
import android.support.v4.view.ar;
import android.support.v7.p018b.C0299c;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class C0329i implements C0133a {
    private static final int[] f1547d = new int[]{1, 4, 5, 3, 2, 0};
    CharSequence f1548a;
    Drawable f1549b;
    View f1550c;
    private final Context f1551e;
    private final Resources f1552f;
    private boolean f1553g;
    private boolean f1554h;
    private C0269j f1555i;
    private ArrayList f1556j;
    private ArrayList f1557k;
    private boolean f1558l;
    private ArrayList f1559m;
    private ArrayList f1560n;
    private boolean f1561o;
    private int f1562p = 0;
    private ContextMenuInfo f1563q;
    private boolean f1564r = false;
    private boolean f1565s = false;
    private boolean f1566t = false;
    private boolean f1567u = false;
    private ArrayList f1568v = new ArrayList();
    private CopyOnWriteArrayList f1569w = new CopyOnWriteArrayList();
    private C0337m f1570x;
    private boolean f1571y;

    public C0329i(Context context) {
        this.f1551e = context;
        this.f1552f = context.getResources();
        this.f1556j = new ArrayList();
        this.f1557k = new ArrayList();
        this.f1558l = true;
        this.f1559m = new ArrayList();
        this.f1560n = new ArrayList();
        this.f1561o = true;
        m3339e(true);
    }

    private static int m3332a(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0337m) arrayList.get(size)).m3464c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private C0337m m3333a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0337m(this, i, i2, i3, i4, charSequence, i5);
    }

    private void m3334a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m3369d();
        if (view != null) {
            this.f1550c = view;
            this.f1548a = null;
            this.f1549b = null;
        } else {
            if (i > 0) {
                this.f1548a = d.getText(i);
            } else if (charSequence != null) {
                this.f1548a = charSequence;
            }
            if (i2 > 0) {
                this.f1549b = C0066a.m958a(m3371e(), i2);
            } else if (drawable != null) {
                this.f1549b = drawable;
            }
            this.f1550c = null;
        }
        m3363b(false);
    }

    private void m3335a(int i, boolean z) {
        if (i >= 0 && i < this.f1556j.size()) {
            this.f1556j.remove(i);
            if (z) {
                m3363b(true);
            }
        }
    }

    private boolean m3336a(ad adVar, C0332x c0332x) {
        boolean z = false;
        if (this.f1569w.isEmpty()) {
            return false;
        }
        if (c0332x != null) {
            z = c0332x.mo610a(adVar);
        }
        Iterator it = this.f1569w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0332x c0332x2 = (C0332x) weakReference.get();
            if (c0332x2 == null) {
                this.f1569w.remove(weakReference);
                z = z2;
            } else {
                z = !z2 ? c0332x2.mo610a(adVar) : z2;
            }
            z2 = z;
        }
        return z2;
    }

    private static int m3337d(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f1547d.length) {
            return (f1547d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void m3338d(boolean z) {
        if (!this.f1569w.isEmpty()) {
            m3373g();
            Iterator it = this.f1569w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0332x c0332x = (C0332x) weakReference.get();
                if (c0332x == null) {
                    this.f1569w.remove(weakReference);
                } else {
                    c0332x.mo612b(z);
                }
            }
            m3374h();
        }
    }

    private void m3339e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f1552f.getConfiguration().keyboard != 1 && this.f1552f.getBoolean(C0299c.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f1554h = z2;
    }

    public int m3340a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0337m) this.f1556j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public C0329i m3341a(int i) {
        this.f1562p = i;
        return this;
    }

    protected C0329i m3342a(Drawable drawable) {
        m3334a(0, null, 0, drawable, null);
        return this;
    }

    protected C0329i m3343a(View view) {
        m3334a(0, null, 0, null, view);
        return this;
    }

    protected C0329i m3344a(CharSequence charSequence) {
        m3334a(0, charSequence, 0, null, null);
        return this;
    }

    C0337m m3345a(int i, KeyEvent keyEvent) {
        List list = this.f1568v;
        list.clear();
        m3354a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C0337m) list.get(0);
        }
        boolean b = mo600b();
        for (int i2 = 0; i2 < size; i2++) {
            C0337m c0337m = (C0337m) list.get(i2);
            char alphabeticShortcut = b ? c0337m.getAlphabeticShortcut() : c0337m.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0337m;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0337m;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return c0337m;
            }
        }
        return null;
    }

    protected MenuItem m3346a(int i, int i2, int i3, CharSequence charSequence) {
        int d = C0329i.m3337d(i3);
        MenuItem a = m3333a(i, i2, i3, d, charSequence, this.f1562p);
        if (this.f1563q != null) {
            a.m3459a(this.f1563q);
        }
        this.f1556j.add(C0329i.m3332a(this.f1556j, d), a);
        m3363b(true);
        return a;
    }

    protected String mo597a() {
        return "android:menu:actionviewstates";
    }

    public void m3348a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = ar.m1871a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (ar.m1875c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((ad) item.getSubMenu()).m3348a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo597a(), sparseArray);
        }
    }

    public void mo598a(C0269j c0269j) {
        this.f1555i = c0269j;
    }

    void m3350a(C0337m c0337m) {
        this.f1558l = true;
        m3363b(true);
    }

    public void m3351a(C0332x c0332x) {
        m3352a(c0332x, this.f1551e);
    }

    public void m3352a(C0332x c0332x, Context context) {
        this.f1569w.add(new WeakReference(c0332x));
        c0332x.mo608a(context, this);
        this.f1561o = true;
    }

    void m3353a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1556j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0337m) this.f1556j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m3471g() && menuItem2.isCheckable()) {
                menuItem2.m3462b(menuItem2 == menuItem);
            }
        }
    }

    void m3354a(List list, int i, KeyEvent keyEvent) {
        boolean b = mo600b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1556j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0337m c0337m = (C0337m) this.f1556j.get(i2);
                if (c0337m.hasSubMenu()) {
                    ((C0329i) c0337m.getSubMenu()).m3354a(list, i, keyEvent);
                }
                char alphabeticShortcut = b ? c0337m.getAlphabeticShortcut() : c0337m.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && c0337m.isEnabled())) {
                    list.add(c0337m);
                }
            }
        }
    }

    public final void m3355a(boolean z) {
        if (!this.f1567u) {
            this.f1567u = true;
            Iterator it = this.f1569w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0332x c0332x = (C0332x) weakReference.get();
                if (c0332x == null) {
                    this.f1569w.remove(weakReference);
                } else {
                    c0332x.mo609a(this, z);
                }
            }
            this.f1567u = false;
        }
    }

    boolean mo599a(C0329i c0329i, MenuItem menuItem) {
        return this.f1555i != null && this.f1555i.mo490a(c0329i, menuItem);
    }

    public boolean m3357a(MenuItem menuItem, int i) {
        return m3358a(menuItem, null, i);
    }

    public boolean m3358a(MenuItem menuItem, C0332x c0332x, int i) {
        C0337m c0337m = (C0337m) menuItem;
        if (c0337m == null || !c0337m.isEnabled()) {
            return false;
        }
        boolean b = c0337m.m3463b();
        C0227n a = c0337m.mo588a();
        boolean z = a != null && a.mo619e();
        boolean expandActionView;
        if (c0337m.m3478n()) {
            expandActionView = c0337m.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            m3355a(true);
            return expandActionView;
        } else if (c0337m.hasSubMenu() || z) {
            m3355a(false);
            if (!c0337m.hasSubMenu()) {
                c0337m.m3458a(new ad(m3371e(), this, c0337m));
            }
            ad adVar = (ad) c0337m.getSubMenu();
            if (z) {
                a.mo617a((SubMenu) adVar);
            }
            expandActionView = m3336a(adVar, c0332x) | b;
            if (expandActionView) {
                return expandActionView;
            }
            m3355a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m3355a(true);
            }
            return b;
        }
    }

    public MenuItem add(int i) {
        return m3346a(0, 0, 0, this.f1552f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m3346a(i, i2, i3, this.f1552f.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m3346a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return m3346a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1551e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1552f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1552f.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0337m c0337m = (C0337m) m3346a(i, i2, i3, charSequence);
        ad adVar = new ad(this.f1551e, this, c0337m);
        c0337m.m3458a(adVar);
        return adVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int m3359b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0337m) this.f1556j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void m3360b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mo597a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = ar.m1871a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((ad) item.getSubMenu()).m3360b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    ar.m1874b(item);
                }
            }
        }
    }

    void m3361b(C0337m c0337m) {
        this.f1561o = true;
        m3363b(true);
    }

    public void m3362b(C0332x c0332x) {
        Iterator it = this.f1569w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0332x c0332x2 = (C0332x) weakReference.get();
            if (c0332x2 == null || c0332x2 == c0332x) {
                this.f1569w.remove(weakReference);
            }
        }
    }

    public void m3363b(boolean z) {
        if (this.f1564r) {
            this.f1565s = true;
            return;
        }
        if (z) {
            this.f1558l = true;
            this.f1561o = true;
        }
        m3338d(z);
    }

    boolean mo600b() {
        return this.f1553g;
    }

    public int m3365c(int i) {
        return m3340a(i, 0);
    }

    public void m3366c(boolean z) {
        this.f1571y = z;
    }

    public boolean mo601c() {
        return this.f1554h;
    }

    public boolean mo602c(C0337m c0337m) {
        boolean z = false;
        if (!this.f1569w.isEmpty()) {
            m3373g();
            Iterator it = this.f1569w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0332x c0332x = (C0332x) weakReference.get();
                if (c0332x == null) {
                    this.f1569w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0332x.mo611a(this, c0337m);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3374h();
            if (z) {
                this.f1570x = c0337m;
            }
        }
        return z;
    }

    public void clear() {
        if (this.f1570x != null) {
            mo603d(this.f1570x);
        }
        this.f1556j.clear();
        m3363b(true);
    }

    public void clearHeader() {
        this.f1549b = null;
        this.f1548a = null;
        this.f1550c = null;
        m3363b(false);
    }

    public void close() {
        m3355a(true);
    }

    Resources m3369d() {
        return this.f1552f;
    }

    public boolean mo603d(C0337m c0337m) {
        boolean z = false;
        if (!this.f1569w.isEmpty() && this.f1570x == c0337m) {
            m3373g();
            Iterator it = this.f1569w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0332x c0332x = (C0332x) weakReference.get();
                if (c0332x == null) {
                    this.f1569w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0332x.mo614b(this, c0337m);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3374h();
            if (z) {
                this.f1570x = null;
            }
        }
        return z;
    }

    public Context m3371e() {
        return this.f1551e;
    }

    public void m3372f() {
        if (this.f1555i != null) {
            this.f1555i.mo485a(this);
        }
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0337m c0337m = (C0337m) this.f1556j.get(i2);
            if (c0337m.getItemId() == i) {
                return c0337m;
            }
            if (c0337m.hasSubMenu()) {
                MenuItem findItem = c0337m.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public void m3373g() {
        if (!this.f1564r) {
            this.f1564r = true;
            this.f1565s = false;
        }
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f1556j.get(i);
    }

    public void m3374h() {
        this.f1564r = false;
        if (this.f1565s) {
            this.f1565s = false;
            m3363b(true);
        }
    }

    public boolean hasVisibleItems() {
        if (this.f1571y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0337m) this.f1556j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList m3375i() {
        if (!this.f1558l) {
            return this.f1557k;
        }
        this.f1557k.clear();
        int size = this.f1556j.size();
        for (int i = 0; i < size; i++) {
            C0337m c0337m = (C0337m) this.f1556j.get(i);
            if (c0337m.isVisible()) {
                this.f1557k.add(c0337m);
            }
        }
        this.f1558l = false;
        this.f1561o = true;
        return this.f1557k;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m3345a(i, keyEvent) != null;
    }

    public void m3376j() {
        ArrayList i = m3375i();
        if (this.f1561o) {
            Iterator it = this.f1569w.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                C0332x c0332x = (C0332x) weakReference.get();
                if (c0332x == null) {
                    this.f1569w.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = c0332x.mo613b() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.f1559m.clear();
                this.f1560n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    C0337m c0337m = (C0337m) i.get(i4);
                    if (c0337m.m3474j()) {
                        this.f1559m.add(c0337m);
                    } else {
                        this.f1560n.add(c0337m);
                    }
                }
            } else {
                this.f1559m.clear();
                this.f1560n.clear();
                this.f1560n.addAll(m3375i());
            }
            this.f1561o = false;
        }
    }

    public ArrayList m3377k() {
        m3376j();
        return this.f1559m;
    }

    public ArrayList m3378l() {
        m3376j();
        return this.f1560n;
    }

    public CharSequence m3379m() {
        return this.f1548a;
    }

    public Drawable m3380n() {
        return this.f1549b;
    }

    public View m3381o() {
        return this.f1550c;
    }

    public C0329i mo604p() {
        return this;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m3357a(findItem(i), i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m3345a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m3357a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m3355a(true);
        }
        return z;
    }

    boolean m3383q() {
        return this.f1566t;
    }

    public C0337m m3384r() {
        return this.f1570x;
    }

    public void removeGroup(int i) {
        int c = m3365c(i);
        if (c >= 0) {
            int size = this.f1556j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((C0337m) this.f1556j.get(c)).getGroupId() != i) {
                    m3363b(true);
                } else {
                    m3335a(c, false);
                    i2 = i3;
                }
            }
            m3363b(true);
        }
    }

    public void removeItem(int i) {
        m3335a(m3359b(i), true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1556j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0337m c0337m = (C0337m) this.f1556j.get(i2);
            if (c0337m.getGroupId() == i) {
                c0337m.m3460a(z2);
                c0337m.setCheckable(z);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1556j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0337m c0337m = (C0337m) this.f1556j.get(i2);
            if (c0337m.getGroupId() == i) {
                c0337m.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f1556j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            C0337m c0337m = (C0337m) this.f1556j.get(i2);
            boolean z3 = (c0337m.getGroupId() == i && c0337m.m3465c(z)) ? true : z2;
            i2++;
            z2 = z3;
        }
        if (z2) {
            m3363b(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.f1553g = z;
        m3363b(false);
    }

    public int size() {
        return this.f1556j.size();
    }
}
