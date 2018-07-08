package android.support.v7.p005a;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Method;

class av implements OnClickListener {
    private final View f1245a;
    private final String f1246b;
    private Method f1247c;
    private Context f1248d;

    public av(View view, String str) {
        this.f1245a = view;
        this.f1246b = str;
    }

    private void m3018a(Context context, String str) {
        for (Context context2 = context; context2 != null; context2 = context2 instanceof ContextWrapper ? ((ContextWrapper) context2).getBaseContext() : null) {
            try {
                if (!context2.isRestricted()) {
                    Method method = context2.getClass().getMethod(this.f1246b, new Class[]{View.class});
                    if (method != null) {
                        this.f1247c = method;
                        this.f1248d = context2;
                        return;
                    }
                }
            } catch (NoSuchMethodException e) {
            }
        }
        int id = this.f1245a.getId();
        throw new IllegalStateException("Could not find method " + this.f1246b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.f1245a.getClass() + (id == -1 ? "" : " with id '" + this.f1245a.getContext().getResources().getResourceEntryName(id) + "'"));
    }

    public void onClick(View view) {
        if (this.f1247c == null) {
            m3018a(this.f1245a.getContext(), this.f1246b);
        }
        try {
            this.f1247c.invoke(this.f1248d, new Object[]{view});
        } catch (Throwable e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (Throwable e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
