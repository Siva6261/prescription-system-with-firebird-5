package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.design.C0021b;
import android.support.design.C0024e;
import android.support.design.C0025f;
import android.support.design.C0026g;
import android.support.design.C0028i;
import android.support.v4.view.bv;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class Snackbar {
    private static final Handler f284a = new Handler(Looper.getMainLooper(), new bi());
    private final ViewGroup f285b;
    private final Context f286c;
    private final SnackbarLayout f287d;
    private int f288e;
    private bu f289f;
    private final AccessibilityManager f290g;
    private final bz f291h = new bl(this);

    public class SnackbarLayout extends LinearLayout {
        private TextView f278a;
        private Button f279b;
        private int f280c;
        private int f281d;
        private bw f282e;
        private bv f283f;

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0028i.SnackbarLayout);
            this.f280c = obtainStyledAttributes.getDimensionPixelSize(C0028i.SnackbarLayout_android_maxWidth, -1);
            this.f281d = obtainStyledAttributes.getDimensionPixelSize(C0028i.SnackbarLayout_maxActionInlineWidth, -1);
            if (obtainStyledAttributes.hasValue(C0028i.SnackbarLayout_elevation)) {
                bv.m2024d((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(C0028i.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(C0026g.design_layout_snackbar_include, this);
            bv.m2025d((View) this, 1);
            bv.m2020c((View) this, 1);
        }

        private static void m449a(View view, int i, int i2) {
            if (bv.m2046w(view)) {
                bv.m2004a(view, bv.m2034k(view), i, bv.m2035l(view), i2);
            } else {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
            }
        }

        private boolean m450a(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.f278a.getPaddingTop() == i2 && this.f278a.getPaddingBottom() == i3) {
                return z;
            }
            m449a(this.f278a, i2, i3);
            return true;
        }

        void m451a(int i, int i2) {
            bv.m2019c(this.f278a, 0.0f);
            bv.m2040q(this.f278a).m2384a(1.0f).m2385a((long) i2).m2390b((long) i).m2393c();
            if (this.f279b.getVisibility() == 0) {
                bv.m2019c(this.f279b, 0.0f);
                bv.m2040q(this.f279b).m2384a(1.0f).m2385a((long) i2).m2390b((long) i).m2393c();
            }
        }

        void m452b(int i, int i2) {
            bv.m2019c(this.f278a, 1.0f);
            bv.m2040q(this.f278a).m2384a(0.0f).m2385a((long) i2).m2390b((long) i).m2393c();
            if (this.f279b.getVisibility() == 0) {
                bv.m2019c(this.f279b, 1.0f);
                bv.m2040q(this.f279b).m2384a(0.0f).m2385a((long) i2).m2390b((long) i).m2393c();
            }
        }

        Button getActionView() {
            return this.f279b;
        }

        TextView getMessageView() {
            return this.f278a;
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f283f != null) {
                this.f283f.mo109a(this);
            }
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f283f != null) {
                this.f283f.mo110b(this);
            }
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.f278a = (TextView) findViewById(C0025f.snackbar_text);
            this.f279b = (Button) findViewById(C0025f.snackbar_action);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f282e != null) {
                this.f282e.mo111a(this, i, i2, i3, i4);
            }
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f280c > 0 && getMeasuredWidth() > this.f280c) {
                i = MeasureSpec.makeMeasureSpec(this.f280c, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(C0024e.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0024e.design_snackbar_padding_vertical);
            int i3 = this.f278a.getLayout().getLineCount() > 1 ? 1 : 0;
            if (i3 == 0 || this.f281d <= 0 || this.f279b.getMeasuredWidth() <= this.f281d) {
                if (i3 == 0) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (m450a(0, dimensionPixelSize, dimensionPixelSize)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            } else {
                if (m450a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize != 0) {
                super.onMeasure(i, i2);
            }
        }

        void setOnAttachStateChangeListener(bv bvVar) {
            this.f283f = bvVar;
        }

        void setOnLayoutChangeListener(bw bwVar) {
            this.f282e = bwVar;
        }
    }

    private Snackbar(ViewGroup viewGroup) {
        this.f285b = viewGroup;
        this.f286c = viewGroup.getContext();
        ch.m705a(this.f286c);
        this.f287d = (SnackbarLayout) LayoutInflater.from(this.f286c).inflate(C0026g.design_layout_snackbar, this.f285b, false);
        this.f290g = (AccessibilityManager) this.f286c.getSystemService("accessibility");
    }

    public static Snackbar m453a(View view, CharSequence charSequence, int i) {
        Snackbar snackbar = new Snackbar(m455a(view));
        snackbar.m469a(charSequence);
        snackbar.m472b(i);
        return snackbar;
    }

    private static ViewGroup m455a(View view) {
        ViewGroup viewGroup = null;
        View view2 = view;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup) view2;
                }
                viewGroup = (ViewGroup) view2;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                    continue;
                } else {
                    view2 = null;
                    continue;
                }
            }
            if (view2 == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view2;
    }

    private void m462d(int i) {
        bx.m653a().m663a(this.f291h, i);
    }

    private void m463e() {
        if (VERSION.SDK_INT >= 14) {
            bv.m2015b(this.f287d, (float) this.f287d.getHeight());
            bv.m2040q(this.f287d).m2392c(0.0f).m2388a(C0031a.f303b).m2385a(250).m2386a(new bq(this)).m2393c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f287d.getContext(), C0021b.design_snackbar_in);
        loadAnimation.setInterpolator(C0031a.f303b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new br(this));
        this.f287d.startAnimation(loadAnimation);
    }

    private void m464e(int i) {
        if (VERSION.SDK_INT >= 14) {
            bv.m2040q(this.f287d).m2392c((float) this.f287d.getHeight()).m2388a(C0031a.f303b).m2385a(250).m2386a(new bs(this, i)).m2393c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f287d.getContext(), C0021b.design_snackbar_out);
        loadAnimation.setInterpolator(C0031a.f303b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new bj(this, i));
        this.f287d.startAnimation(loadAnimation);
    }

    private void m466f() {
        bx.m653a().m664b(this.f291h);
        if (this.f289f != null) {
            this.f289f.m651a(this);
        }
    }

    private void m467f(int i) {
        bx.m653a().m662a(this.f291h);
        if (this.f289f != null) {
            this.f289f.m652a(this, i);
        }
        ViewParent parent = this.f287d.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f287d);
        }
    }

    public Snackbar m468a(int i) {
        this.f287d.getActionView().setTextColor(i);
        return this;
    }

    public Snackbar m469a(CharSequence charSequence) {
        this.f287d.getMessageView().setText(charSequence);
        return this;
    }

    public Snackbar m470a(CharSequence charSequence, OnClickListener onClickListener) {
        TextView actionView = this.f287d.getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
        } else {
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new bk(this, onClickListener));
        }
        return this;
    }

    public void m471a() {
        bx.m653a().m661a(this.f288e, this.f291h);
    }

    public Snackbar m472b(int i) {
        this.f288e = i;
        return this;
    }

    public boolean m473b() {
        return bx.m653a().m667e(this.f291h);
    }

    final void m474c() {
        if (this.f287d.getParent() == null) {
            LayoutParams layoutParams = this.f287d.getLayoutParams();
            if (layoutParams instanceof ae) {
                ab btVar = new bt(this);
                btVar.m488a(0.1f);
                btVar.m493b(0.6f);
                btVar.m489a(0);
                btVar.m490a(new bm(this));
                ((ae) layoutParams).m504a(btVar);
            }
            this.f285b.addView(this.f287d);
        }
        this.f287d.setOnAttachStateChangeListener(new bn(this));
        if (bv.m1994A(this.f287d)) {
            m463e();
        } else {
            this.f287d.setOnLayoutChangeListener(new bp(this));
        }
    }

    final void m475c(int i) {
        if (this.f287d.getVisibility() != 0) {
            m467f(i);
        } else {
            m464e(i);
        }
    }
}
