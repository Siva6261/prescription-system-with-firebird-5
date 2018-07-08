package android.support.v7.p005a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.bv;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0303g;
import android.support.v7.p018b.C0308l;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

class C0280e {
    private TextView f1324A;
    private TextView f1325B;
    private View f1326C;
    private ListAdapter f1327D;
    private int f1328E = -1;
    private int f1329F;
    private int f1330G;
    private int f1331H;
    private int f1332I;
    private int f1333J;
    private int f1334K;
    private int f1335L = 0;
    private Handler f1336M;
    private final OnClickListener f1337N = new C0281f(this);
    private final Context f1338a;
    private final as f1339b;
    private final Window f1340c;
    private CharSequence f1341d;
    private CharSequence f1342e;
    private ListView f1343f;
    private View f1344g;
    private int f1345h;
    private int f1346i;
    private int f1347j;
    private int f1348k;
    private int f1349l;
    private boolean f1350m = false;
    private Button f1351n;
    private CharSequence f1352o;
    private Message f1353p;
    private Button f1354q;
    private CharSequence f1355r;
    private Message f1356s;
    private Button f1357t;
    private CharSequence f1358u;
    private Message f1359v;
    private NestedScrollView f1360w;
    private int f1361x = 0;
    private Drawable f1362y;
    private ImageView f1363z;

    public C0280e(Context context, as asVar, Window window) {
        this.f1338a = context;
        this.f1339b = asVar;
        this.f1340c = window;
        this.f1336M = new C0292q(asVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0308l.AlertDialog, C0298b.alertDialogStyle, 0);
        this.f1329F = obtainStyledAttributes.getResourceId(C0308l.AlertDialog_android_layout, 0);
        this.f1330G = obtainStyledAttributes.getResourceId(C0308l.AlertDialog_buttonPanelSideLayout, 0);
        this.f1331H = obtainStyledAttributes.getResourceId(C0308l.AlertDialog_listLayout, 0);
        this.f1332I = obtainStyledAttributes.getResourceId(C0308l.AlertDialog_multiChoiceItemLayout, 0);
        this.f1333J = obtainStyledAttributes.getResourceId(C0308l.AlertDialog_singleChoiceItemLayout, 0);
        this.f1334K = obtainStyledAttributes.getResourceId(C0308l.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
    }

    private ViewGroup m3162a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    private void m3167a(ViewGroup viewGroup) {
        boolean z = false;
        View inflate = this.f1344g != null ? this.f1344g : this.f1345h != 0 ? LayoutInflater.from(this.f1338a).inflate(this.f1345h, viewGroup, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && C0280e.m3169a(inflate))) {
            this.f1340c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f1340c.findViewById(C0303g.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (this.f1350m) {
                frameLayout.setPadding(this.f1346i, this.f1347j, this.f1348k, this.f1349l);
            }
            if (this.f1343f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void m3168a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.f1340c.findViewById(C0303g.scrollIndicatorUp);
        View findViewById2 = this.f1340c.findViewById(C0303g.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            bv.m2003a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f1342e != null) {
                this.f1360w.setOnScrollChangeListener(new C0282g(this, findViewById, view2));
                this.f1360w.post(new C0283h(this, findViewById, view2));
            } else if (this.f1343f != null) {
                this.f1343f.setOnScrollListener(new C0284i(this, findViewById, view2));
                this.f1343f.post(new C0285j(this, findViewById, view2));
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    static boolean m3169a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (C0280e.m3169a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private int m3170b() {
        return this.f1330G == 0 ? this.f1329F : this.f1335L == 1 ? this.f1330G : this.f1329F;
    }

    private static void m3172b(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(bv.m2018b(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!bv.m2018b(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void m3173b(ViewGroup viewGroup) {
        if (this.f1326C != null) {
            viewGroup.addView(this.f1326C, 0, new LayoutParams(-1, -2));
            this.f1340c.findViewById(C0303g.title_template).setVisibility(8);
            return;
        }
        this.f1363z = (ImageView) this.f1340c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f1341d) ? 1 : 0) != 0) {
            this.f1324A = (TextView) this.f1340c.findViewById(C0303g.alertTitle);
            this.f1324A.setText(this.f1341d);
            if (this.f1361x != 0) {
                this.f1363z.setImageResource(this.f1361x);
                return;
            } else if (this.f1362y != null) {
                this.f1363z.setImageDrawable(this.f1362y);
                return;
            } else {
                this.f1324A.setPadding(this.f1363z.getPaddingLeft(), this.f1363z.getPaddingTop(), this.f1363z.getPaddingRight(), this.f1363z.getPaddingBottom());
                this.f1363z.setVisibility(8);
                return;
            }
        }
        this.f1340c.findViewById(C0303g.title_template).setVisibility(8);
        this.f1363z.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void m3175c() {
        View findViewById = this.f1340c.findViewById(C0303g.parentPanel);
        View findViewById2 = findViewById.findViewById(C0303g.topPanel);
        View findViewById3 = findViewById.findViewById(C0303g.contentPanel);
        View findViewById4 = findViewById.findViewById(C0303g.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(C0303g.customPanel);
        m3167a(viewGroup);
        View findViewById5 = viewGroup.findViewById(C0303g.topPanel);
        View findViewById6 = viewGroup.findViewById(C0303g.contentPanel);
        View findViewById7 = viewGroup.findViewById(C0303g.buttonPanel);
        ViewGroup a = m3162a(findViewById5, findViewById2);
        ViewGroup a2 = m3162a(findViewById6, findViewById3);
        ViewGroup a3 = m3162a(findViewById7, findViewById4);
        m3176c(a2);
        m3178d(a3);
        m3173b(a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null)) {
            findViewById3 = a2.findViewById(C0303g.textSpacerNoButtons);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
        }
        if (z2 && this.f1360w != null) {
            this.f1360w.setClipToPadding(true);
        }
        if (!z) {
            findViewById3 = this.f1343f != null ? this.f1343f : this.f1360w;
            if (findViewById3 != null) {
                m3168a(a2, findViewById3, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.f1343f;
        if (listView != null && this.f1327D != null) {
            listView.setAdapter(this.f1327D);
            int i = this.f1328E;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    private void m3176c(ViewGroup viewGroup) {
        this.f1360w = (NestedScrollView) this.f1340c.findViewById(C0303g.scrollView);
        this.f1360w.setFocusable(false);
        this.f1360w.setNestedScrollingEnabled(false);
        this.f1325B = (TextView) viewGroup.findViewById(16908299);
        if (this.f1325B != null) {
            if (this.f1342e != null) {
                this.f1325B.setText(this.f1342e);
                return;
            }
            this.f1325B.setVisibility(8);
            this.f1360w.removeView(this.f1325B);
            if (this.f1343f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f1360w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f1360w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f1343f, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void m3178d(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.f1351n = (Button) viewGroup.findViewById(16908313);
        this.f1351n.setOnClickListener(this.f1337N);
        if (TextUtils.isEmpty(this.f1352o)) {
            this.f1351n.setVisibility(8);
            i = 0;
        } else {
            this.f1351n.setText(this.f1352o);
            this.f1351n.setVisibility(0);
            i = 1;
        }
        this.f1354q = (Button) viewGroup.findViewById(16908314);
        this.f1354q.setOnClickListener(this.f1337N);
        if (TextUtils.isEmpty(this.f1355r)) {
            this.f1354q.setVisibility(8);
        } else {
            this.f1354q.setText(this.f1355r);
            this.f1354q.setVisibility(0);
            i |= 2;
        }
        this.f1357t = (Button) viewGroup.findViewById(16908315);
        this.f1357t.setOnClickListener(this.f1337N);
        if (TextUtils.isEmpty(this.f1358u)) {
            this.f1357t.setVisibility(8);
        } else {
            this.f1357t.setText(this.f1358u);
            this.f1357t.setVisibility(0);
            i |= 4;
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void m3189a() {
        this.f1339b.m802a(1);
        this.f1339b.setContentView(m3170b());
        m3175c();
    }

    public void m3190a(int i) {
        this.f1344g = null;
        this.f1345h = i;
        this.f1350m = false;
    }

    public void m3191a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f1336M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f1358u = charSequence;
                this.f1359v = message;
                return;
            case -2:
                this.f1355r = charSequence;
                this.f1356s = message;
                return;
            case -1:
                this.f1352o = charSequence;
                this.f1353p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m3192a(Drawable drawable) {
        this.f1362y = drawable;
        this.f1361x = 0;
        if (this.f1363z == null) {
            return;
        }
        if (drawable != null) {
            this.f1363z.setVisibility(0);
            this.f1363z.setImageDrawable(drawable);
            return;
        }
        this.f1363z.setVisibility(8);
    }

    public void m3193a(View view, int i, int i2, int i3, int i4) {
        this.f1344g = view;
        this.f1345h = 0;
        this.f1350m = true;
        this.f1346i = i;
        this.f1347j = i2;
        this.f1348k = i3;
        this.f1349l = i4;
    }

    public void m3194a(CharSequence charSequence) {
        this.f1341d = charSequence;
        if (this.f1324A != null) {
            this.f1324A.setText(charSequence);
        }
    }

    public boolean m3195a(int i, KeyEvent keyEvent) {
        return this.f1360w != null && this.f1360w.m2554a(keyEvent);
    }

    public void m3196b(int i) {
        this.f1362y = null;
        this.f1361x = i;
        if (this.f1363z == null) {
            return;
        }
        if (i != 0) {
            this.f1363z.setVisibility(0);
            this.f1363z.setImageResource(this.f1361x);
            return;
        }
        this.f1363z.setVisibility(8);
    }

    public void m3197b(View view) {
        this.f1326C = view;
    }

    public void m3198b(CharSequence charSequence) {
        this.f1342e = charSequence;
        if (this.f1325B != null) {
            this.f1325B.setText(charSequence);
        }
    }

    public boolean m3199b(int i, KeyEvent keyEvent) {
        return this.f1360w != null && this.f1360w.m2554a(keyEvent);
    }

    public int m3200c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f1338a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void m3201c(View view) {
        this.f1344g = view;
        this.f1345h = 0;
        this.f1350m = false;
    }
}
