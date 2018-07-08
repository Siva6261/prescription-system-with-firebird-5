package android.support.v7.p005a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class C0267w {
    private static int f1152a = -1;

    C0267w() {
    }

    public static C0267w m2852a(Activity activity, C0047v c0047v) {
        return C0267w.m2854a(activity, activity.getWindow(), c0047v);
    }

    public static C0267w m2853a(Dialog dialog, C0047v c0047v) {
        return C0267w.m2854a(dialog.getContext(), dialog.getWindow(), c0047v);
    }

    private static C0267w m2854a(Context context, Window window, C0047v c0047v) {
        int i = VERSION.SDK_INT;
        return i >= 23 ? new ac(context, window, c0047v) : i >= 14 ? new aa(context, window, c0047v) : i >= 11 ? new C0270z(context, window, c0047v) : new ae(context, window, c0047v);
    }

    public static int m2855i() {
        return f1152a;
    }

    public abstract C0266a mo474a();

    public abstract View mo481a(int i);

    public abstract void mo483a(Configuration configuration);

    public abstract void mo484a(Bundle bundle);

    public abstract void mo486a(Toolbar toolbar);

    public abstract void mo487a(View view);

    public abstract void mo488a(View view, LayoutParams layoutParams);

    public abstract void mo475a(CharSequence charSequence);

    public abstract MenuInflater mo476b();

    public abstract void mo492b(int i);

    public abstract void mo493b(Bundle bundle);

    public abstract void mo494b(View view, LayoutParams layoutParams);

    public abstract void mo497c();

    public abstract void mo477c(Bundle bundle);

    public abstract boolean mo498c(int i);

    public abstract void mo499d();

    public abstract void mo500e();

    public abstract void mo478f();

    public abstract void mo501g();

    public abstract boolean mo479h();
}
