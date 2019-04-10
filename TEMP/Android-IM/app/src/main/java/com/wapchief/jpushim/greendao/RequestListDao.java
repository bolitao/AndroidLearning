package com.wapchief.jpushim.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.wapchief.jpushim.greendao.model.RequestList;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "REQUEST_LIST".
*/
public class RequestListDao extends AbstractDao<RequestList, Long> {

    public static final String TABLENAME = "REQUEST_LIST";

    /**
     * Properties of entity RequestList.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Msg = new Property(1, String.class, "msg", false, "MSG");
        public final static Property UserName = new Property(2, String.class, "userName", false, "USER_NAME");
        public final static Property NakeName = new Property(3, String.class, "nakeName", false, "NAKE_NAME");
        public final static Property Time = new Property(4, String.class, "time", false, "TIME");
        public final static Property Img = new Property(5, String.class, "img", false, "IMG");
    }


    public RequestListDao(DaoConfig config) {
        super(config);
    }
    
    public RequestListDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"REQUEST_LIST\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"MSG\" TEXT," + // 1: msg
                "\"USER_NAME\" TEXT," + // 2: userName
                "\"NAKE_NAME\" TEXT," + // 3: nakeName
                "\"TIME\" TEXT," + // 4: time
                "\"IMG\" TEXT);"); // 5: img
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"REQUEST_LIST\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, RequestList entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String msg = entity.getMsg();
        if (msg != null) {
            stmt.bindString(2, msg);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(3, userName);
        }
 
        String nakeName = entity.getNakeName();
        if (nakeName != null) {
            stmt.bindString(4, nakeName);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(5, time);
        }
 
        String img = entity.getImg();
        if (img != null) {
            stmt.bindString(6, img);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, RequestList entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String msg = entity.getMsg();
        if (msg != null) {
            stmt.bindString(2, msg);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(3, userName);
        }
 
        String nakeName = entity.getNakeName();
        if (nakeName != null) {
            stmt.bindString(4, nakeName);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(5, time);
        }
 
        String img = entity.getImg();
        if (img != null) {
            stmt.bindString(6, img);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public RequestList readEntity(Cursor cursor, int offset) {
        RequestList entity = new RequestList( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // msg
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // userName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // nakeName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // time
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // img
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, RequestList entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMsg(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUserName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setNakeName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setImg(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(RequestList entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(RequestList entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(RequestList entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
