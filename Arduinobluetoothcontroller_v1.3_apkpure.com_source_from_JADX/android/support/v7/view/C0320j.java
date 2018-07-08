package android.support.v7.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

class C0320j implements OnMenuItemClickListener {
    private static final Class[] f1460a = new Class[]{MenuItem.class};
    private Object f1461b;
    private Method f1462c;

    public C0320j(Object obj, String str) {
        this.f1461b = obj;
        Class cls = obj.getClass();
        try {
            this.f1462c = cls.getMethod(str, f1460a);
        } catch (Throwable e) {
            InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
            inflateException.initCause(e);
            throw inflateException;
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        try {
            if (this.f1462c.getReturnType() == Boolean.TYPE) {
                return ((Boolean) this.f1462c.invoke(this.f1461b, new Object[]{menuItem})).booleanValue();
            }
            this.f1462c.invoke(this.f1461b, new Object[]{menuItem});
            return true;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
