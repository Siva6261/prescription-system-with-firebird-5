package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.p008c.C0066a;
import android.support.v4.p010d.C0132a;
import android.support.v4.p010d.p011a.C0106a;
import android.support.v4.p015h.C0166a;
import android.support.v4.p015h.C0172f;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0302f;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class aq {
    private static final Mode f1947a = Mode.SRC_IN;
    private static aq f1948b;
    private static final at f1949c = new at(6);
    private static final int[] f1950d = new int[]{C0302f.abc_textfield_search_default_mtrl_alpha, C0302f.abc_textfield_default_mtrl_alpha, C0302f.abc_ab_share_pack_mtrl_alpha};
    private static final int[] f1951e = new int[]{C0302f.abc_ic_ab_back_mtrl_am_alpha, C0302f.abc_ic_go_search_api_mtrl_alpha, C0302f.abc_ic_search_api_mtrl_alpha, C0302f.abc_ic_commit_search_api_mtrl_alpha, C0302f.abc_ic_clear_mtrl_alpha, C0302f.abc_ic_menu_share_mtrl_alpha, C0302f.abc_ic_menu_copy_mtrl_am_alpha, C0302f.abc_ic_menu_cut_mtrl_alpha, C0302f.abc_ic_menu_selectall_mtrl_alpha, C0302f.abc_ic_menu_paste_mtrl_am_alpha, C0302f.abc_ic_menu_moreoverflow_mtrl_alpha, C0302f.abc_ic_voice_search_api_mtrl_alpha};
    private static final int[] f1952f = new int[]{C0302f.abc_textfield_activated_mtrl_alpha, C0302f.abc_textfield_search_activated_mtrl_alpha, C0302f.abc_cab_background_top_mtrl_alpha, C0302f.abc_text_cursor_material};
    private static final int[] f1953g = new int[]{C0302f.abc_popup_background_mtrl_mult, C0302f.abc_cab_background_internal_bg, C0302f.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] f1954h = new int[]{C0302f.abc_edit_text_material, C0302f.abc_tab_indicator_material, C0302f.abc_textfield_search_material, C0302f.abc_spinner_mtrl_am_alpha, C0302f.abc_spinner_textfield_background_material, C0302f.abc_ratingbar_full_material, C0302f.abc_switch_track_mtrl_alpha, C0302f.abc_switch_thumb_material, C0302f.abc_btn_default_mtrl_shape, C0302f.abc_btn_borderless_material};
    private static final int[] f1955i = new int[]{C0302f.abc_btn_check_material, C0302f.abc_btn_radio_material};
    private WeakHashMap f1956j;
    private C0166a f1957k;
    private SparseArray f1958l;
    private final Object f1959m = new Object();
    private final WeakHashMap f1960n = new WeakHashMap(0);
    private TypedValue f1961o;

    private ColorStateList m4074a(Context context) {
        int a = ga.m4775a(context, C0298b.colorControlNormal);
        int a2 = ga.m4775a(context, C0298b.colorControlActivated);
        r2 = new int[7][];
        int[] iArr = new int[]{ga.f2360a, ga.m4779c(context, C0298b.colorControlNormal), ga.f2361b, a2, ga.f2362c, a2, ga.f2363d};
        iArr[3] = a2;
        r2[4] = ga.f2364e;
        iArr[4] = a2;
        r2[5] = ga.f2365f;
        iArr[5] = a2;
        r2[6] = ga.f2367h;
        iArr[6] = a;
        return new ColorStateList(r2, iArr);
    }

    public static PorterDuffColorFilter m4075a(int i, Mode mode) {
        PorterDuffColorFilter a = f1949c.m4107a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        f1949c.m4108a(i, mode, a);
        return a;
    }

    private static PorterDuffColorFilter m4076a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        return (colorStateList == null || mode == null) ? null : m4075a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable m4077a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = m4103b(context, i);
        if (b != null) {
            if (cj.m4348b(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = C0106a.m1346f(drawable);
            C0106a.m1336a(drawable, b);
            Mode a = m4099a(i);
            if (a == null) {
                return drawable;
            }
            C0106a.m1339a(drawable, a);
            return drawable;
        } else if (i == C0302f.abc_cab_background_top_material) {
            return new LayerDrawable(new Drawable[]{m4100a(context, C0302f.abc_cab_background_internal_bg), m4100a(context, C0302f.abc_cab_background_top_mtrl_alpha)});
        } else if (i == C0302f.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            m4081a(r0.findDrawableByLayerId(16908288), ga.m4775a(context, C0298b.colorControlNormal), f1947a);
            m4081a(r0.findDrawableByLayerId(16908303), ga.m4775a(context, C0298b.colorControlNormal), f1947a);
            m4081a(r0.findDrawableByLayerId(16908301), ga.m4775a(context, C0298b.colorControlActivated), f1947a);
            return drawable;
        } else if (i != C0302f.abc_ratingbar_indicator_material && i != C0302f.abc_ratingbar_small_material) {
            return (m4085a(context, i, drawable) || !z) ? drawable : null;
        } else {
            r0 = (LayerDrawable) drawable;
            m4081a(r0.findDrawableByLayerId(16908288), ga.m4779c(context, C0298b.colorControlNormal), f1947a);
            m4081a(r0.findDrawableByLayerId(16908303), ga.m4775a(context, C0298b.colorControlActivated), f1947a);
            m4081a(r0.findDrawableByLayerId(16908301), ga.m4775a(context, C0298b.colorControlActivated), f1947a);
            return drawable;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m4078a(android.content.Context r5, long r6) {
        /*
        r4 = this;
        r2 = 0;
        r3 = r4.f1959m;
        monitor-enter(r3);
        r0 = r4.f1960n;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002b }
        r0 = (android.support.v4.p015h.C0172f) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.m1544a(r6);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0031;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r5.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0.m1549b(r6);	 Catch:{ all -> 0x002b }
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aq.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static aq m4079a() {
        if (f1948b == null) {
            f1948b = new aq();
            m4083a(f1948b);
        }
        return f1948b;
    }

    private void m4080a(Context context, int i, ColorStateList colorStateList) {
        if (this.f1956j == null) {
            this.f1956j = new WeakHashMap();
        }
        SparseArray sparseArray = (SparseArray) this.f1956j.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.f1956j.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    private static void m4081a(Drawable drawable, int i, Mode mode) {
        if (cj.m4348b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f1947a;
        }
        drawable.setColorFilter(m4075a(i, mode));
    }

    public static void m4082a(Drawable drawable, gd gdVar, int[] iArr) {
        if (!cj.m4348b(drawable) || drawable.mutate() == drawable) {
            if (gdVar.f2376d || gdVar.f2375c) {
                drawable.setColorFilter(m4076a(gdVar.f2376d ? gdVar.f2373a : null, gdVar.f2375c ? gdVar.f2374b : f1947a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private static void m4083a(aq aqVar) {
        int i = VERSION.SDK_INT;
        if (i < 21) {
            aqVar.m4084a("vector", new av());
            if (i >= 11) {
                aqVar.m4084a("animated-vector", new as());
            }
        }
    }

    private void m4084a(String str, au auVar) {
        if (this.f1957k == null) {
            this.f1957k = new C0166a();
        }
        this.f1957k.put(str, auVar);
    }

    private static boolean m4085a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = f1947a;
        if (m4087a(f1950d, i)) {
            i2 = C0298b.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (m4087a(f1952f, i)) {
            i2 = C0298b.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (m4087a(f1953g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0302f.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (cj.m4348b(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(m4075a(ga.m4775a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private boolean m4086a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.f1959m) {
            C0172f c0172f = (C0172f) this.f1960n.get(context);
            if (c0172f == null) {
                c0172f = new C0172f();
                this.f1960n.put(context, c0172f);
            }
            c0172f.m1550b(j, new WeakReference(constantState));
        }
        return true;
    }

    private static boolean m4087a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList m4088b(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ga.f2360a, ga.m4779c(context, C0298b.colorControlNormal), ga.f2364e};
        iArr[1] = ga.m4775a(context, C0298b.colorControlActivated);
        r0[2] = ga.f2367h;
        iArr[2] = ga.m4775a(context, C0298b.colorControlNormal);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m4089c(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ga.f2360a, ga.m4776a(context, 16842800, 0.1f), ga.f2364e};
        iArr[1] = ga.m4776a(context, C0298b.colorControlActivated, 0.3f);
        r0[2] = ga.f2367h;
        iArr[2] = ga.m4776a(context, 16842800, 0.3f);
        return new ColorStateList(r0, iArr);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m4090c(android.content.Context r11, int r12) {
        /*
        r10 = this;
        r1 = 0;
        r9 = 2;
        r8 = 1;
        r0 = r10.f1957k;
        if (r0 == 0) goto L_0x00c5;
    L_0x0007:
        r0 = r10.f1957k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00c5;
    L_0x000f:
        r0 = r10.f1958l;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r10.f1958l;
        r0 = r0.get(r12);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r10.f1957k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new android.util.SparseArray;
        r0.<init>();
        r10.f1958l = r0;
    L_0x0036:
        r0 = r10.f1961o;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r10.f1961o = r0;
    L_0x0041:
        r2 = r10.f1961o;
        r0 = r11.getResources();
        r0.getValue(r12, r2, r8);
        r1 = r2.assetCookie;
        r4 = (long) r1;
        r1 = 32;
        r4 = r4 << r1;
        r1 = r2.data;
        r6 = (long) r1;
        r4 = r4 | r6;
        r1 = r10.m4078a(r11, r4);
        if (r1 == 0) goto L_0x005c;
    L_0x005a:
        r0 = r1;
        goto L_0x002e;
    L_0x005c:
        r3 = r2.string;
        if (r3 == 0) goto L_0x0090;
    L_0x0060:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x0090;
    L_0x006e:
        r3 = r0.getXml(r12);	 Catch:{ Exception -> 0x0088 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0088 }
    L_0x0076:
        r0 = r3.next();	 Catch:{ Exception -> 0x0088 }
        if (r0 == r9) goto L_0x007e;
    L_0x007c:
        if (r0 != r8) goto L_0x0076;
    L_0x007e:
        if (r0 == r9) goto L_0x009b;
    L_0x0080:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0088 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0088 }
        throw r0;	 Catch:{ Exception -> 0x0088 }
    L_0x0088:
        r0 = move-exception;
        r2 = "AppCompatDrawableManager";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x0090:
        r0 = r1;
    L_0x0091:
        if (r0 != 0) goto L_0x002e;
    L_0x0093:
        r1 = r10.f1958l;
        r2 = "appcompat_skip_skip";
        r1.append(r12, r2);
        goto L_0x002e;
    L_0x009b:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0088 }
        r7 = r10.f1958l;	 Catch:{ Exception -> 0x0088 }
        r7.append(r12, r0);	 Catch:{ Exception -> 0x0088 }
        r7 = r10.f1957k;	 Catch:{ Exception -> 0x0088 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0088 }
        r0 = (android.support.v7.widget.au) r0;	 Catch:{ Exception -> 0x0088 }
        if (r0 == 0) goto L_0x00b6;
    L_0x00ae:
        r7 = r11.getTheme();	 Catch:{ Exception -> 0x0088 }
        r1 = r0.mo702a(r11, r3, r6, r7);	 Catch:{ Exception -> 0x0088 }
    L_0x00b6:
        if (r1 == 0) goto L_0x00c3;
    L_0x00b8:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0088 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0088 }
        r0 = r10.m4086a(r11, r4, r1);	 Catch:{ Exception -> 0x0088 }
        if (r0 == 0) goto L_0x00c3;
    L_0x00c3:
        r0 = r1;
        goto L_0x0091;
    L_0x00c5:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aq.c(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private ColorStateList m4091d(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = ga.m4778b(context, C0298b.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = ga.f2360a;
            iArr2[0] = ga.m4779c(context, C0298b.colorSwitchThumbNormal);
            iArr[1] = ga.f2364e;
            iArr2[1] = ga.m4775a(context, C0298b.colorControlActivated);
            iArr[2] = ga.f2367h;
            iArr2[2] = ga.m4775a(context, C0298b.colorSwitchThumbNormal);
        } else {
            iArr[0] = ga.f2360a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = ga.f2364e;
            iArr2[1] = ga.m4775a(context, C0298b.colorControlActivated);
            iArr[2] = ga.f2367h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList m4092d(Context context, int i) {
        if (this.f1956j == null) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.f1956j.get(context);
        return sparseArray != null ? (ColorStateList) sparseArray.get(i) : null;
    }

    private ColorStateList m4093e(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ga.f2360a, ga.m4779c(context, C0298b.colorControlNormal), ga.f2366g};
        iArr[1] = ga.m4775a(context, C0298b.colorControlNormal);
        r0[2] = ga.f2367h;
        iArr[2] = ga.m4775a(context, C0298b.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m4094e(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = ga.m4775a(context, i);
        int a2 = ga.m4775a(context, C0298b.colorControlHighlight);
        r0[0] = ga.f2360a;
        r1[0] = ga.m4779c(context, C0298b.colorButtonNormal);
        r0[1] = ga.f2363d;
        r1[1] = C0132a.m1450a(a2, a);
        r0[2] = ga.f2361b;
        r1[2] = C0132a.m1450a(a2, a);
        r0[3] = ga.f2367h;
        r1[3] = a;
        return new ColorStateList(r0, r1);
    }

    private ColorStateList m4095f(Context context) {
        return m4094e(context, C0298b.colorButtonNormal);
    }

    private ColorStateList m4096g(Context context) {
        return m4094e(context, C0298b.colorAccent);
    }

    private ColorStateList m4097h(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ga.f2360a, ga.m4779c(context, C0298b.colorControlNormal), ga.f2366g};
        iArr[1] = ga.m4775a(context, C0298b.colorControlNormal);
        r0[2] = ga.f2367h;
        iArr[2] = ga.m4775a(context, C0298b.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m4098i(Context context) {
        r0 = new int[2][];
        int[] iArr = new int[]{ga.f2360a, ga.m4779c(context, C0298b.colorControlActivated)};
        r0[1] = ga.f2367h;
        iArr[1] = ga.m4775a(context, C0298b.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    final Mode m4099a(int i) {
        return i == C0302f.abc_switch_thumb_material ? Mode.MULTIPLY : null;
    }

    public Drawable m4100a(Context context, int i) {
        return m4101a(context, i, false);
    }

    public Drawable m4101a(Context context, int i, boolean z) {
        Drawable c = m4090c(context, i);
        if (c == null) {
            c = C0066a.m958a(context, i);
        }
        if (c != null) {
            c = m4077a(context, i, z, c);
        }
        if (c != null) {
            cj.m4347a(c);
        }
        return c;
    }

    public final Drawable m4102a(Context context, ge geVar, int i) {
        Drawable c = m4090c(context, i);
        if (c == null) {
            c = geVar.m4785a(i);
        }
        return c != null ? m4077a(context, i, false, c) : null;
    }

    public final ColorStateList m4103b(Context context, int i) {
        ColorStateList d = m4092d(context, i);
        if (d == null) {
            if (i == C0302f.abc_edit_text_material) {
                d = m4093e(context);
            } else if (i == C0302f.abc_switch_track_mtrl_alpha) {
                d = m4089c(context);
            } else if (i == C0302f.abc_switch_thumb_material) {
                d = m4091d(context);
            } else if (i == C0302f.abc_btn_default_mtrl_shape || i == C0302f.abc_btn_borderless_material) {
                d = m4095f(context);
            } else if (i == C0302f.abc_btn_colored_material) {
                d = m4096g(context);
            } else if (i == C0302f.abc_spinner_mtrl_am_alpha || i == C0302f.abc_spinner_textfield_background_material) {
                d = m4097h(context);
            } else if (m4087a(f1951e, i)) {
                d = ga.m4778b(context, C0298b.colorControlNormal);
            } else if (m4087a(f1954h, i)) {
                d = m4074a(context);
            } else if (m4087a(f1955i, i)) {
                d = m4088b(context);
            } else if (i == C0302f.abc_seekbar_thumb_material) {
                d = m4098i(context);
            }
            if (d != null) {
                m4080a(context, i, d);
            }
        }
        return d;
    }
}
