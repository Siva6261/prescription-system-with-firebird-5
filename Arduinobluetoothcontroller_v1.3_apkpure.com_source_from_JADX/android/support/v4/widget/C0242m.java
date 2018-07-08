package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class C0242m extends BaseAdapter implements C0241r, Filterable {
    protected boolean f1092a;
    protected boolean f1093b;
    protected Cursor f1094c;
    protected Context f1095d;
    protected int f1096e;
    protected C0255o f1097f;
    protected DataSetObserver f1098g;
    protected C0257q f1099h;
    protected FilterQueryProvider f1100i;

    public C0242m(Context context, Cursor cursor, boolean z) {
        m2629a(context, cursor, z ? 1 : 2);
    }

    public Cursor mo438a() {
        return this.f1094c;
    }

    public Cursor mo439a(CharSequence charSequence) {
        return this.f1100i != null ? this.f1100i.runQuery(charSequence) : this.f1094c;
    }

    public abstract View mo442a(Context context, Cursor cursor, ViewGroup viewGroup);

    void m2629a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f1093b = true;
        } else {
            this.f1093b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f1094c = cursor;
        this.f1092a = z;
        this.f1095d = context;
        this.f1096e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f1097f = new C0255o(this);
            this.f1098g = new C0256p();
        } else {
            this.f1097f = null;
            this.f1098g = null;
        }
        if (z) {
            if (this.f1097f != null) {
                cursor.registerContentObserver(this.f1097f);
            }
            if (this.f1098g != null) {
                cursor.registerDataSetObserver(this.f1098g);
            }
        }
    }

    public void mo440a(Cursor cursor) {
        Cursor b = m2632b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public abstract void mo771a(View view, Context context, Cursor cursor);

    public Cursor m2632b(Cursor cursor) {
        if (cursor == this.f1094c) {
            return null;
        }
        Cursor cursor2 = this.f1094c;
        if (cursor2 != null) {
            if (this.f1097f != null) {
                cursor2.unregisterContentObserver(this.f1097f);
            }
            if (this.f1098g != null) {
                cursor2.unregisterDataSetObserver(this.f1098g);
            }
        }
        this.f1094c = cursor;
        if (cursor != null) {
            if (this.f1097f != null) {
                cursor.registerContentObserver(this.f1097f);
            }
            if (this.f1098g != null) {
                cursor.registerDataSetObserver(this.f1098g);
            }
            this.f1096e = cursor.getColumnIndexOrThrow("_id");
            this.f1092a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f1096e = -1;
        this.f1092a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public View mo443b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo442a(context, cursor, viewGroup);
    }

    protected void m2634b() {
        if (this.f1093b && this.f1094c != null && !this.f1094c.isClosed()) {
            this.f1092a = this.f1094c.requery();
        }
    }

    public CharSequence mo441c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public int getCount() {
        return (!this.f1092a || this.f1094c == null) ? 0 : this.f1094c.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1092a) {
            return null;
        }
        this.f1094c.moveToPosition(i);
        if (view == null) {
            view = mo443b(this.f1095d, this.f1094c, viewGroup);
        }
        mo771a(view, this.f1095d, this.f1094c);
        return view;
    }

    public Filter getFilter() {
        if (this.f1099h == null) {
            this.f1099h = new C0257q(this);
        }
        return this.f1099h;
    }

    public Object getItem(int i) {
        if (!this.f1092a || this.f1094c == null) {
            return null;
        }
        this.f1094c.moveToPosition(i);
        return this.f1094c;
    }

    public long getItemId(int i) {
        return (this.f1092a && this.f1094c != null && this.f1094c.moveToPosition(i)) ? this.f1094c.getLong(this.f1096e) : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1092a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1094c.moveToPosition(i)) {
            if (view == null) {
                view = mo442a(this.f1095d, this.f1094c, viewGroup);
            }
            mo771a(view, this.f1095d, this.f1094c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public boolean hasStableIds() {
        return true;
    }
}
