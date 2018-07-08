package io.realm;

import io.realm.internal.C0469g;
import io.realm.internal.Table;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class aa {
    private static final Map f2793b = new HashMap();
    private static final Map f2794c = new HashMap();
    final Table f2795a;
    private final C0426a f2796d;
    private final C0469g f2797e;
    private final Map f2798f;

    static {
        f2793b.put(String.class, new ac(RealmFieldType.STRING, true));
        f2793b.put(Short.TYPE, new ac(RealmFieldType.INTEGER, false));
        f2793b.put(Short.class, new ac(RealmFieldType.INTEGER, true));
        f2793b.put(Integer.TYPE, new ac(RealmFieldType.INTEGER, false));
        f2793b.put(Integer.class, new ac(RealmFieldType.INTEGER, true));
        f2793b.put(Long.TYPE, new ac(RealmFieldType.INTEGER, false));
        f2793b.put(Long.class, new ac(RealmFieldType.INTEGER, true));
        f2793b.put(Float.TYPE, new ac(RealmFieldType.FLOAT, false));
        f2793b.put(Float.class, new ac(RealmFieldType.FLOAT, true));
        f2793b.put(Double.TYPE, new ac(RealmFieldType.DOUBLE, false));
        f2793b.put(Double.class, new ac(RealmFieldType.DOUBLE, true));
        f2793b.put(Boolean.TYPE, new ac(RealmFieldType.BOOLEAN, false));
        f2793b.put(Boolean.class, new ac(RealmFieldType.BOOLEAN, true));
        f2793b.put(Byte.TYPE, new ac(RealmFieldType.INTEGER, false));
        f2793b.put(Byte.class, new ac(RealmFieldType.INTEGER, true));
        f2793b.put(byte[].class, new ac(RealmFieldType.BINARY, true));
        f2793b.put(Date.class, new ac(RealmFieldType.DATE, true));
        f2794c.put(C0391z.class, new ac(RealmFieldType.OBJECT, false));
        f2794c.put(C0493x.class, new ac(RealmFieldType.LIST, false));
    }

    aa(C0426a c0426a, Table table, Map map) {
        this.f2796d = c0426a;
        this.f2797e = c0426a.f2788e.m5762g();
        this.f2795a = table;
        this.f2798f = map;
    }

    private void m5375a(String str, C0481k[] c0481kArr) {
        int i;
        Exception e;
        Object obj = null;
        if (c0481kArr != null) {
            try {
                if (c0481kArr.length > 0) {
                    if (m5377a(c0481kArr, C0481k.INDEXED)) {
                        m5383a(str);
                        i = 1;
                    }
                    if (m5377a(c0481kArr, C0481k.PRIMARY_KEY)) {
                        m5383a(str);
                        try {
                            m5387b(str);
                        } catch (Exception e2) {
                            e = e2;
                            i = 1;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                long h = m5382h(str);
                if (obj != null) {
                    this.f2795a.m5562k(h);
                }
                throw e;
            }
        }
    }

    private boolean m5376a(RealmFieldType realmFieldType, RealmFieldType[] realmFieldTypeArr) {
        for (RealmFieldType realmFieldType2 : realmFieldTypeArr) {
            if (realmFieldType2 == realmFieldType) {
                return true;
            }
        }
        return false;
    }

    private boolean m5377a(C0481k[] c0481kArr, C0481k c0481k) {
        if (c0481kArr == null || c0481kArr.length == 0) {
            return false;
        }
        for (C0481k c0481k2 : c0481kArr) {
            if (c0481k2 == c0481k) {
                return true;
            }
        }
        return false;
    }

    private void m5378d(String str) {
        m5379e(str);
        m5380f(str);
    }

    private void m5379e(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Field name can not be null or empty");
        } else if (str.contains(".")) {
            throw new IllegalArgumentException("Field name can not contain '.'");
        }
    }

    private void m5380f(String str) {
        if (this.f2795a.m5536a(str) != -1) {
            throw new IllegalArgumentException("Field already exists in '" + m5385a() + "': " + str);
        }
    }

    private void m5381g(String str) {
        if (this.f2795a.m5536a(str) == -1) {
            throw new IllegalArgumentException("Field name doesn't exist on object '" + m5385a() + "': " + str);
        }
    }

    private long m5382h(String str) {
        long a = this.f2795a.m5536a(str);
        if (a != -1) {
            return a;
        }
        throw new IllegalArgumentException(String.format("Field name '%s' does not exist on schema for '%s", new Object[]{str, m5385a()}));
    }

    public aa m5383a(String str) {
        m5379e(str);
        m5381g(str);
        long h = m5382h(str);
        if (this.f2795a.m5564l(h)) {
            throw new IllegalStateException(str + " already has an index.");
        }
        this.f2795a.m5560j(h);
        return this;
    }

    public aa m5384a(String str, Class cls, C0481k... c0481kArr) {
        ac acVar = (ac) f2793b.get(cls);
        if (acVar != null) {
            m5378d(str);
            boolean z = acVar.f2801b;
            if (m5377a(c0481kArr, C0481k.REQUIRED) || m5377a(c0481kArr, C0481k.PRIMARY_KEY)) {
                z = false;
            }
            long a = this.f2795a.m5534a(acVar.f2800a, str, z);
            try {
                m5375a(str, c0481kArr);
                return this;
            } catch (Exception e) {
                this.f2795a.m5537a(a);
                throw e;
            }
        } else if (f2794c.containsKey(cls)) {
            throw new IllegalArgumentException("Use addLinkField() instead to add fields that link to other RealmObjects: " + str);
        } else {
            throw new IllegalArgumentException(String.format("Realm doesn't support this field type: %s(%s)", new Object[]{str, cls}));
        }
    }

    public String m5385a() {
        return this.f2795a.m5561k().substring(Table.f2878a.length());
    }

    long[] m5386a(String str, RealmFieldType... realmFieldTypeArr) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Non-empty fieldname must be provided");
        } else if (str.startsWith(".") || str.endsWith(".")) {
            throw new IllegalArgumentException("Illegal field name. It cannot start or end with a '.': " + str);
        } else {
            Table table = this.f2795a;
            Object obj = (realmFieldTypeArr == null || realmFieldTypeArr.length <= 0) ? null : 1;
            if (str.contains(".")) {
                long a;
                String[] split = str.split("\\.");
                long[] jArr = new long[split.length];
                int i = 0;
                while (i < split.length - 1) {
                    a = table.m5536a(split[i]);
                    if (a < 0) {
                        throw new IllegalArgumentException("Invalid query: " + split[i] + " does not refer to a class.");
                    }
                    RealmFieldType d = table.m5548d(a);
                    if (d == RealmFieldType.OBJECT || d == RealmFieldType.LIST) {
                        table = table.m5554g(a);
                        jArr[i] = a;
                        i++;
                    } else {
                        throw new IllegalArgumentException("Invalid query: " + split[i] + " does not refer to a class.");
                    }
                }
                String str2 = split[split.length - 1];
                a = table.m5536a(str2);
                jArr[split.length - 1] = a;
                if (a < 0) {
                    throw new IllegalArgumentException(str2 + " is not a field name in class " + table.m5561k());
                } else if (obj == null || m5376a(table.m5548d(a), realmFieldTypeArr)) {
                    return jArr;
                } else {
                    throw new IllegalArgumentException(String.format("Field '%s': type mismatch.", new Object[]{split[split.length - 1]}));
                }
            } else if (m5388c(str) == null) {
                throw new IllegalArgumentException(String.format("Field '%s' does not exist.", new Object[]{str}));
            } else {
                RealmFieldType d2 = table.m5548d(m5388c(str).longValue());
                if (obj == null || m5376a(d2, realmFieldTypeArr)) {
                    return new long[]{m5388c(str).longValue()};
                }
                throw new IllegalArgumentException(String.format("Field '%s': type mismatch. Was %s, expected %s.", new Object[]{str, d2, Arrays.toString(realmFieldTypeArr)}));
            }
        }
    }

    public aa m5387b(String str) {
        m5379e(str);
        m5381g(str);
        if (this.f2795a.m5551f()) {
            throw new IllegalStateException("A primary key is already defined");
        }
        this.f2795a.m5543b(str);
        return this;
    }

    Long m5388c(String str) {
        return (Long) this.f2798f.get(str);
    }
}
