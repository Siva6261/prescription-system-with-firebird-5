package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class gc extends ContextWrapper {
    private static final ArrayList f2370a = new ArrayList();
    private Resources f2371b;
    private final Theme f2372c = getResources().newTheme();

    private gc(Context context) {
        super(context);
        this.f2372c.setTo(context.getTheme());
    }

    public static Context m4782a(Context context) {
        if (!m4783b(context)) {
            return context;
        }
        Context context2;
        int size = f2370a.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) f2370a.get(i);
            context2 = weakReference != null ? (gc) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new gc(context);
        f2370a.add(new WeakReference(context2));
        return context2;
    }

    private static boolean m4783b(Context context) {
        return ((context instanceof gc) || (context.getResources() instanceof ge)) ? false : true;
    }

    public Resources getResources() {
        if (this.f2371b == null) {
            this.f2371b = new ge(this, super.getResources());
        }
        return this.f2371b;
    }

    public Theme getTheme() {
        return this.f2372c;
    }

    public void setTheme(int i) {
        this.f2372c.applyStyle(i, true);
    }
}
