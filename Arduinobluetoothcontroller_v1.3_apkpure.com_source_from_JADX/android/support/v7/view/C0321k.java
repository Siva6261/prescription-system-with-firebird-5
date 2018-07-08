package android.support.v7.view;

import android.content.res.TypedArray;
import android.support.v4.view.C0227n;
import android.support.v4.view.ar;
import android.support.v7.p018b.C0308l;
import android.support.v7.view.menu.C0337m;
import android.support.v7.view.menu.C0339o;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

class C0321k {
    final /* synthetic */ C0319i f1463a;
    private Menu f1464b;
    private int f1465c;
    private int f1466d;
    private int f1467e;
    private int f1468f;
    private boolean f1469g;
    private boolean f1470h;
    private boolean f1471i;
    private int f1472j;
    private int f1473k;
    private CharSequence f1474l;
    private CharSequence f1475m;
    private int f1476n;
    private char f1477o;
    private char f1478p;
    private int f1479q;
    private boolean f1480r;
    private boolean f1481s;
    private boolean f1482t;
    private int f1483u;
    private int f1484v;
    private String f1485w;
    private String f1486x;
    private String f1487y;
    private C0227n f1488z;

    public C0321k(C0319i c0319i, Menu menu) {
        this.f1463a = c0319i;
        this.f1464b = menu;
        m3278a();
    }

    private char m3274a(String str) {
        return str == null ? '\u0000' : str.charAt(0);
    }

    private Object m3276a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor constructor = this.f1463a.f1458e.getClassLoader().loadClass(str).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Throwable e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    private void m3277a(MenuItem menuItem) {
        boolean z = true;
        menuItem.setChecked(this.f1480r).setVisible(this.f1481s).setEnabled(this.f1482t).setCheckable(this.f1479q >= 1).setTitleCondensed(this.f1475m).setIcon(this.f1476n).setAlphabeticShortcut(this.f1477o).setNumericShortcut(this.f1478p);
        if (this.f1483u >= 0) {
            ar.m1872a(menuItem, this.f1483u);
        }
        if (this.f1487y != null) {
            if (this.f1463a.f1458e.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new C0320j(this.f1463a.m3271c(), this.f1487y));
        }
        if (menuItem instanceof C0337m) {
            C0337m c0337m = (C0337m) menuItem;
        }
        if (this.f1479q >= 2) {
            if (menuItem instanceof C0337m) {
                ((C0337m) menuItem).m3460a(true);
            } else if (menuItem instanceof C0339o) {
                ((C0339o) menuItem).m3481a(true);
            }
        }
        if (this.f1485w != null) {
            ar.m1870a(menuItem, (View) m3276a(this.f1485w, C0319i.f1454a, this.f1463a.f1456c));
        } else {
            z = false;
        }
        if (this.f1484v > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                ar.m1873b(menuItem, this.f1484v);
            }
        }
        if (this.f1488z != null) {
            ar.m1869a(menuItem, this.f1488z);
        }
    }

    public void m3278a() {
        this.f1465c = 0;
        this.f1466d = 0;
        this.f1467e = 0;
        this.f1468f = 0;
        this.f1469g = true;
        this.f1470h = true;
    }

    public void m3279a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f1463a.f1458e.obtainStyledAttributes(attributeSet, C0308l.MenuGroup);
        this.f1465c = obtainStyledAttributes.getResourceId(C0308l.MenuGroup_android_id, 0);
        this.f1466d = obtainStyledAttributes.getInt(C0308l.MenuGroup_android_menuCategory, 0);
        this.f1467e = obtainStyledAttributes.getInt(C0308l.MenuGroup_android_orderInCategory, 0);
        this.f1468f = obtainStyledAttributes.getInt(C0308l.MenuGroup_android_checkableBehavior, 0);
        this.f1469g = obtainStyledAttributes.getBoolean(C0308l.MenuGroup_android_visible, true);
        this.f1470h = obtainStyledAttributes.getBoolean(C0308l.MenuGroup_android_enabled, true);
        obtainStyledAttributes.recycle();
    }

    public void m3280b() {
        this.f1471i = true;
        m3277a(this.f1464b.add(this.f1465c, this.f1472j, this.f1473k, this.f1474l));
    }

    public void m3281b(AttributeSet attributeSet) {
        boolean z = true;
        TypedArray obtainStyledAttributes = this.f1463a.f1458e.obtainStyledAttributes(attributeSet, C0308l.MenuItem);
        this.f1472j = obtainStyledAttributes.getResourceId(C0308l.MenuItem_android_id, 0);
        this.f1473k = (obtainStyledAttributes.getInt(C0308l.MenuItem_android_menuCategory, this.f1466d) & -65536) | (obtainStyledAttributes.getInt(C0308l.MenuItem_android_orderInCategory, this.f1467e) & 65535);
        this.f1474l = obtainStyledAttributes.getText(C0308l.MenuItem_android_title);
        this.f1475m = obtainStyledAttributes.getText(C0308l.MenuItem_android_titleCondensed);
        this.f1476n = obtainStyledAttributes.getResourceId(C0308l.MenuItem_android_icon, 0);
        this.f1477o = m3274a(obtainStyledAttributes.getString(C0308l.MenuItem_android_alphabeticShortcut));
        this.f1478p = m3274a(obtainStyledAttributes.getString(C0308l.MenuItem_android_numericShortcut));
        if (obtainStyledAttributes.hasValue(C0308l.MenuItem_android_checkable)) {
            this.f1479q = obtainStyledAttributes.getBoolean(C0308l.MenuItem_android_checkable, false) ? 1 : 0;
        } else {
            this.f1479q = this.f1468f;
        }
        this.f1480r = obtainStyledAttributes.getBoolean(C0308l.MenuItem_android_checked, false);
        this.f1481s = obtainStyledAttributes.getBoolean(C0308l.MenuItem_android_visible, this.f1469g);
        this.f1482t = obtainStyledAttributes.getBoolean(C0308l.MenuItem_android_enabled, this.f1470h);
        this.f1483u = obtainStyledAttributes.getInt(C0308l.MenuItem_showAsAction, -1);
        this.f1487y = obtainStyledAttributes.getString(C0308l.MenuItem_android_onClick);
        this.f1484v = obtainStyledAttributes.getResourceId(C0308l.MenuItem_actionLayout, 0);
        this.f1485w = obtainStyledAttributes.getString(C0308l.MenuItem_actionViewClass);
        this.f1486x = obtainStyledAttributes.getString(C0308l.MenuItem_actionProviderClass);
        if (this.f1486x == null) {
            z = false;
        }
        if (z && this.f1484v == 0 && this.f1485w == null) {
            this.f1488z = (C0227n) m3276a(this.f1486x, C0319i.f1455b, this.f1463a.f1457d);
        } else {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.f1488z = null;
        }
        obtainStyledAttributes.recycle();
        this.f1471i = false;
    }

    public SubMenu m3282c() {
        this.f1471i = true;
        SubMenu addSubMenu = this.f1464b.addSubMenu(this.f1465c, this.f1472j, this.f1473k, this.f1474l);
        m3277a(addSubMenu.getItem());
        return addSubMenu;
    }

    public boolean m3283d() {
        return this.f1471i;
    }
}
