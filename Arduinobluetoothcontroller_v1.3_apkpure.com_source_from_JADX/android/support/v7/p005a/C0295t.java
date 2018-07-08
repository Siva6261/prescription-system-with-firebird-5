package android.support.v7.p005a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ListAdapter;

public class C0295t {
    private final C0286k f1430a;
    private int f1431b;

    public C0295t(Context context) {
        this(context, C0294s.m3206a(context, 0));
    }

    public C0295t(Context context, int i) {
        this.f1430a = new C0286k(new ContextThemeWrapper(context, C0294s.m3206a(context, i)));
        this.f1431b = i;
    }

    public Context m3208a() {
        return this.f1430a.f1390a;
    }

    public C0295t m3209a(OnKeyListener onKeyListener) {
        this.f1430a.f1407r = onKeyListener;
        return this;
    }

    public C0295t m3210a(Drawable drawable) {
        this.f1430a.f1393d = drawable;
        return this;
    }

    public C0295t m3211a(View view) {
        this.f1430a.f1396g = view;
        return this;
    }

    public C0295t m3212a(ListAdapter listAdapter, OnClickListener onClickListener) {
        this.f1430a.f1409t = listAdapter;
        this.f1430a.f1410u = onClickListener;
        return this;
    }

    public C0295t m3213a(CharSequence charSequence) {
        this.f1430a.f1395f = charSequence;
        return this;
    }

    public C0294s m3214b() {
        C0294s c0294s = new C0294s(this.f1430a.f1390a, this.f1431b, false);
        this.f1430a.m3204a(c0294s.f1429a);
        c0294s.setCancelable(this.f1430a.f1404o);
        if (this.f1430a.f1404o) {
            c0294s.setCanceledOnTouchOutside(true);
        }
        c0294s.setOnCancelListener(this.f1430a.f1405p);
        c0294s.setOnDismissListener(this.f1430a.f1406q);
        if (this.f1430a.f1407r != null) {
            c0294s.setOnKeyListener(this.f1430a.f1407r);
        }
        return c0294s;
    }
}
