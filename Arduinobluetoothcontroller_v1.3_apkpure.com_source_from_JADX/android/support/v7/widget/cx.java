package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.p014g.C0160q;
import android.support.v4.widget.ah;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0308l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class cx {
    private static Method f2009a;
    private static Method f2010c;
    private final df f2011A;
    private Runnable f2012B;
    private final Handler f2013C;
    private Rect f2014D;
    private boolean f2015E;
    private int f2016F;
    int f2017b;
    private Context f2018d;
    private PopupWindow f2019e;
    private ListAdapter f2020f;
    private db f2021g;
    private int f2022h;
    private int f2023i;
    private int f2024j;
    private int f2025k;
    private int f2026l;
    private boolean f2027m;
    private int f2028n;
    private boolean f2029o;
    private boolean f2030p;
    private View f2031q;
    private int f2032r;
    private DataSetObserver f2033s;
    private View f2034t;
    private Drawable f2035u;
    private OnItemClickListener f2036v;
    private OnItemSelectedListener f2037w;
    private final dj f2038x;
    private final di f2039y;
    private final dh f2040z;

    static {
        try {
            f2009a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f2010c = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
    }

    public cx(Context context) {
        this(context, null, C0298b.listPopupWindowStyle);
    }

    public cx(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public cx(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2022h = -2;
        this.f2023i = -2;
        this.f2026l = 1002;
        this.f2028n = 0;
        this.f2029o = false;
        this.f2030p = false;
        this.f2017b = Integer.MAX_VALUE;
        this.f2032r = 0;
        this.f2038x = new dj();
        this.f2039y = new di();
        this.f2040z = new dh();
        this.f2011A = new df();
        this.f2014D = new Rect();
        this.f2018d = context;
        this.f2013C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0308l.ListPopupWindow, i, i2);
        this.f2024j = obtainStyledAttributes.getDimensionPixelOffset(C0308l.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f2025k = obtainStyledAttributes.getDimensionPixelOffset(C0308l.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f2025k != 0) {
            this.f2027m = true;
        }
        obtainStyledAttributes.recycle();
        this.f2019e = new bb(context, attributeSet, i);
        this.f2019e.setInputMethodMode(1);
        this.f2016F = C0160q.m1487a(this.f2018d.getResources().getConfiguration().locale);
    }

    private int m4132a(View view, int i, boolean z) {
        if (f2010c != null) {
            try {
                return ((Integer) f2010c.invoke(this.f2019e, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f2019e.getMaxAvailableHeight(view, i);
    }

    private void mo704a() {
        if (this.f2031q != null) {
            ViewParent parent = this.f2031q.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2031q);
            }
        }
    }

    private int mo706b() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.f2021g == null) {
            Context context = this.f2018d;
            this.f2012B = new cz(this);
            this.f2021g = new db(context, !this.f2015E);
            if (this.f2035u != null) {
                this.f2021g.setSelector(this.f2035u);
            }
            this.f2021g.setAdapter(this.f2020f);
            this.f2021g.setOnItemClickListener(this.f2036v);
            this.f2021g.setFocusable(true);
            this.f2021g.setFocusableInTouchMode(true);
            this.f2021g.setOnItemSelectedListener(new da(this));
            this.f2021g.setOnScrollListener(this.f2040z);
            if (this.f2037w != null) {
                this.f2021g.setOnItemSelectedListener(this.f2037w);
            }
            View view2 = this.f2021g;
            View view3 = this.f2031q;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f2032r) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f2032r);
                        break;
                }
                if (this.f2023i >= 0) {
                    i = this.f2023i;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.f2019e.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f2019e.getContentView();
            view = this.f2031q;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.f2019e.getBackground();
        if (background != null) {
            background.getPadding(this.f2014D);
            i2 = this.f2014D.top + this.f2014D.bottom;
            if (this.f2027m) {
                i4 = i2;
            } else {
                this.f2025k = -this.f2014D.top;
                i4 = i2;
            }
        } else {
            this.f2014D.setEmpty();
            i4 = 0;
        }
        if (this.f2019e.getInputMethodMode() != 2) {
            z = false;
        }
        i = m4132a(m4152e(), this.f2025k, z);
        if (this.f2029o || this.f2022h == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.f2023i) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2018d.getResources().getDisplayMetrics().widthPixels - (this.f2014D.left + this.f2014D.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2018d.getResources().getDisplayMetrics().widthPixels - (this.f2014D.left + this.f2014D.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2023i, 1073741824);
                break;
        }
        i2 = this.f2021g.m4387a(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += i4;
        }
        return i2 + i3;
    }

    private void m4137b(boolean z) {
        if (f2009a != null) {
            try {
                f2009a.invoke(this.f2019e, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void m4140a(int i) {
        this.f2032r = i;
    }

    public void m4141a(Drawable drawable) {
        this.f2019e.setBackgroundDrawable(drawable);
    }

    public void m4142a(View view) {
        this.f2034t = view;
    }

    public void m4143a(OnItemClickListener onItemClickListener) {
        this.f2036v = onItemClickListener;
    }

    public void mo705a(ListAdapter listAdapter) {
        if (this.f2033s == null) {
            this.f2033s = new dg();
        } else if (this.f2020f != null) {
            this.f2020f.unregisterDataSetObserver(this.f2033s);
        }
        this.f2020f = listAdapter;
        if (this.f2020f != null) {
            listAdapter.registerDataSetObserver(this.f2033s);
        }
        if (this.f2021g != null) {
            this.f2021g.setAdapter(this.f2020f);
        }
    }

    public void m4145a(OnDismissListener onDismissListener) {
        this.f2019e.setOnDismissListener(onDismissListener);
    }

    public void m4146a(boolean z) {
        this.f2015E = z;
        this.f2019e.setFocusable(z);
    }

    public void m4147b(int i) {
        this.f2024j = i;
    }

    public void mo707c() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int b = mo706b();
        boolean l = m4163l();
        ah.m2603a(this.f2019e, this.f2026l);
        if (this.f2019e.isShowing()) {
            int i2;
            int width = this.f2023i == -1 ? -1 : this.f2023i == -2 ? m4152e().getWidth() : this.f2023i;
            if (this.f2022h == -1) {
                if (!l) {
                    b = -1;
                }
                if (l) {
                    this.f2019e.setWidth(this.f2023i == -1 ? -1 : 0);
                    this.f2019e.setHeight(0);
                    i2 = b;
                } else {
                    this.f2019e.setWidth(this.f2023i == -1 ? -1 : 0);
                    this.f2019e.setHeight(-1);
                    i2 = b;
                }
            } else {
                i2 = this.f2022h == -2 ? b : this.f2022h;
            }
            PopupWindow popupWindow = this.f2019e;
            if (!(this.f2030p || this.f2029o)) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            popupWindow = this.f2019e;
            View e = m4152e();
            b = this.f2024j;
            int i3 = this.f2025k;
            if (width < 0) {
                width = -1;
            }
            if (i2 >= 0) {
                i = i2;
            }
            popupWindow.update(e, b, i3, width, i);
            return;
        }
        int width2 = this.f2023i == -1 ? -1 : this.f2023i == -2 ? m4152e().getWidth() : this.f2023i;
        if (this.f2022h == -1) {
            b = -1;
        } else if (this.f2022h != -2) {
            b = this.f2022h;
        }
        this.f2019e.setWidth(width2);
        this.f2019e.setHeight(b);
        m4137b(true);
        popupWindow = this.f2019e;
        if (this.f2030p || this.f2029o) {
            z = false;
        }
        popupWindow.setOutsideTouchable(z);
        this.f2019e.setTouchInterceptor(this.f2039y);
        ah.m2604a(this.f2019e, m4152e(), this.f2024j, this.f2025k, this.f2028n);
        this.f2021g.setSelection(-1);
        if (!this.f2015E || this.f2021g.isInTouchMode()) {
            m4161j();
        }
        if (!this.f2015E) {
            this.f2013C.post(this.f2011A);
        }
    }

    public void m4149c(int i) {
        this.f2025k = i;
        this.f2027m = true;
    }

    public Drawable m4150d() {
        return this.f2019e.getBackground();
    }

    public void m4151d(int i) {
        this.f2028n = i;
    }

    public View m4152e() {
        return this.f2034t;
    }

    public void m4153e(int i) {
        this.f2023i = i;
    }

    public int m4154f() {
        return this.f2024j;
    }

    public void m4155f(int i) {
        Drawable background = this.f2019e.getBackground();
        if (background != null) {
            background.getPadding(this.f2014D);
            this.f2023i = (this.f2014D.left + this.f2014D.right) + i;
            return;
        }
        m4153e(i);
    }

    public int m4156g() {
        return !this.f2027m ? 0 : this.f2025k;
    }

    public void m4157g(int i) {
        this.f2019e.setInputMethodMode(i);
    }

    public int m4158h() {
        return this.f2023i;
    }

    public void m4159h(int i) {
        db dbVar = this.f2021g;
        if (m4162k() && dbVar != null) {
            dbVar.f2175g = false;
            dbVar.setSelection(i);
            if (VERSION.SDK_INT >= 11 && dbVar.getChoiceMode() != 0) {
                dbVar.setItemChecked(i, true);
            }
        }
    }

    public void m4160i() {
        this.f2019e.dismiss();
        mo704a();
        this.f2019e.setContentView(null);
        this.f2021g = null;
        this.f2013C.removeCallbacks(this.f2038x);
    }

    public void m4161j() {
        db dbVar = this.f2021g;
        if (dbVar != null) {
            dbVar.f2175g = true;
            dbVar.requestLayout();
        }
    }

    public boolean m4162k() {
        return this.f2019e.isShowing();
    }

    public boolean m4163l() {
        return this.f2019e.getInputMethodMode() == 2;
    }

    public ListView m4164m() {
        return this.f2021g;
    }
}
