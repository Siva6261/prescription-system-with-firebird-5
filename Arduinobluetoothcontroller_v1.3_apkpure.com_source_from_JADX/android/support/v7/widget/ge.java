package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public class ge extends Resources {
    private final WeakReference f2377a;

    public ge(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2377a = new WeakReference(context);
    }

    final Drawable m4785a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f2377a.get();
        return context != null ? aq.m4079a().m4102a(context, this, i) : super.getDrawable(i);
    }
}
