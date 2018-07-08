package android.support.design.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.C0022c;
import android.support.design.C0025f;
import android.support.design.C0026g;
import android.support.design.C0027h;
import android.support.v7.p005a.as;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class C0048o extends as {
    private C0043k f469a = new C0050q(this);

    public C0048o(Context context, int i) {
        super(context, C0048o.m804a(context, i));
        m802a(1);
    }

    private static int m804a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(C0022c.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : C0027h.Theme_Design_Light_BottomSheetDialog;
    }

    private View m805a(int i, View view, LayoutParams layoutParams) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) View.inflate(getContext(), C0026g.design_bottom_sheet_dialog, null);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, coordinatorLayout, false);
        }
        View view2 = (FrameLayout) coordinatorLayout.findViewById(C0025f.design_bottom_sheet);
        BottomSheetBehavior.m338a(view2).m361a(this.f469a);
        if (layoutParams == null) {
            view2.addView(view);
        } else {
            view2.addView(view, layoutParams);
        }
        if (m806b()) {
            coordinatorLayout.findViewById(C0025f.touch_outside).setOnClickListener(new C0049p(this));
        }
        return coordinatorLayout;
    }

    private boolean m806b() {
        if (VERSION.SDK_INT < 11) {
            return true;
        }
        TypedValue typedValue = new TypedValue();
        return getContext().getTheme().resolveAttribute(16843611, typedValue, true) ? typedValue.data != 0 : false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
    }

    public void setContentView(int i) {
        super.setContentView(m805a(i, null, null));
    }

    public void setContentView(View view) {
        super.setContentView(m805a(0, view, null));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(m805a(0, view, layoutParams));
    }
}
