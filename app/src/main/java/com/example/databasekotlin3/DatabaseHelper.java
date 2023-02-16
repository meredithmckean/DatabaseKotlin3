package com.example.databasekotlin3;

//import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;

import androidx.annotation.Nullable;

//import java.text.SimpleDateFormat;
//import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String USER_INFO = "user_info";
    public static final String COLUMN_USER_NAME = "COLUMN_USER_NAME";
    public static final String COLUMN_FTP = "COLUMN_FTP";
    public static final String COLUMN_ID = "COLUMN_ID";
    public static final String COLUMN_PASSWORD = "COLUMN_PASSWORD";
    public static final String COLUMN_PZ_1 = "COLUMN_PZ1";
    public static final String COLUMN_PZ_2 = "COLUMN_PZ2";
    public static final String COLUMN_PZ_3 = "COLUMN_PZ3";
    public static final String COLUMN_PZ_4 = "COLUMN_PZ4";
    public static final String COLUMN_PZ_5 = "COLUMN_PZ5";
    public static final String COLUMN_PZ_6 = "COLUMN_PZ6";
    public static final String COLUMN_PZ_7 = "COLUMN_PZ7";

    public static final String DATAFRAME33_INFO = "dataframe33_info";
    public static final String COLUMN_TIME_33 = "COLUMN_TIME_33";
    public static final String COLUMN_INTERVAL = "COLUMN_INTERVAL";
    public static final String COLUMN_POWER = "COLUMN_POWER";
    public static final String COLUMN_TOTAL_CAL = "COLUMN_TOTAL_CAL";
    public static final String COLUMN_SPLIT_PACE = "COLUMN_SPLIT_PACE";
    public static final String COLUMN_SPLIT_POWER = "COLUMN_SPLIT_POWER";
    public static final String COLUMN_SPLIT_CAL = "COLUMN_SPLIT_CAL";
    public static final String COLUMN_LAST_SPLIT_TIME = "COLUMN_LAST_SPLIT_TIME";
    public static final String COLUMN_LAST_SPLIT_DIST = "COLUMN_LAST_SPLIT_DIST";


    public static final String DATAFRAME35_INFO = "dataframe35_info";
    public static final String COLUMN_TIME_35 = "COLUMN_TIME_35";
    public static final String COLUMN_DIST = "COLUMN_DIST";
    public static final String COLUMN_DRIVE_LEN = "COLUMN_DRIVE_LEN";
    public static final String COLUMN_DRIVE_TIME = "COLUMN_DRIVE_TIME";
    public static final String COLUMN_STROKE_REC_TIME = "COLUMN_STROKE_REC_TIME";
    public static final String COLUMN_STROKE_DIST = "COLUMN_STROKE_DIST";
    public static final String COLUMN_PEAK_DRIVE_FORCE = "COLUMN_PEAK_DRIVE_FORCE";
    public static final String COLUMN_AVG_DRIVE_FORCE = "COLUMN_AVG_DRIVE_FORCE";
    public static final String COLUMN_WORK_PER_STROKE = "COLUMN_WORK_PER_STROKE";
    public static final String COLUMN_STROKE_COUNT = "COLUMN_STROKE_COUNT";

    public static final String HISTORY_INFO = "history_info";
    public static final String COLUMN_USER = "COLUMN_USER";
    public static final String COLUMN_TIMESTAMP = "COLUMN_TIMESTAMP";
    public static final String COLUMN_WORKOUT = "COLUMN_WORKOUT";

    //public static final String ERROR_INFO = "error_info";
    public static final String COLUMN_ERROR = "COLUMN_ERROR";
    public static final String COLUMN_AVGPOWER = "COLUMN_AVGPOWER";



    //Constructor
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Smart_Rower_Tables.db", null, 1); //Everytime you change the
    }
    //methods that must be implemented

    //this is called the first time a database is accessed. There should be code in here to create a new database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String user_table = "Create TABLE " + USER_INFO + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_NAME + " TEXT, " + COLUMN_PASSWORD + " TEXT, " + COLUMN_FTP + " INT, " + COLUMN_PZ_1 + " INT, " + COLUMN_PZ_2 + " INT, " + COLUMN_PZ_3 + " INT, " + COLUMN_PZ_4 + " INT, " + COLUMN_PZ_5 + " INT, " + COLUMN_PZ_6 + " INT, " + COLUMN_PZ_7 + " INT)";

        String dataframe33_table = "Create TABLE " + DATAFRAME33_INFO + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TIME_33 + " DOUB, " + COLUMN_INTERVAL + " INT, " + COLUMN_POWER + " INT, " + COLUMN_TOTAL_CAL + " INT, " + COLUMN_SPLIT_PACE + " INT, " + COLUMN_SPLIT_POWER + " INT, " + COLUMN_SPLIT_CAL + " INT, " + COLUMN_LAST_SPLIT_TIME + " INT, " + COLUMN_LAST_SPLIT_DIST + " INT)";

        String dataframe35_table = "Create TABLE " + DATAFRAME35_INFO + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TIME_35 + " DOUB, " + COLUMN_DIST + " DOUB, " + COLUMN_DRIVE_LEN + " DOUB, " + COLUMN_DRIVE_TIME + " DOUB, " + COLUMN_STROKE_REC_TIME + " DOUB, " + COLUMN_STROKE_DIST + " DOUB, " + COLUMN_PEAK_DRIVE_FORCE + " DOUB, " + COLUMN_AVG_DRIVE_FORCE + " DOUB, " + COLUMN_WORK_PER_STROKE + " DOUB, " + COLUMN_STROKE_COUNT + " INT)";

        String history_table = "Create TABLE " + HISTORY_INFO + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER + " TEXT, " + COLUMN_TIMESTAMP + " TEXT default (datetime('now','localtime')), " + COLUMN_WORKOUT + " TEXT, " + COLUMN_ERROR + " INT, " + COLUMN_AVGPOWER + " DOUB)";

        //String error_table = "Create TABLE " + ERROR_INFO + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER + " TEXT, " + COLUMN_TIMESTAMP + " TEXT default (datetime('now','localtime')), " + COLUMN_ERROR + " INT)";

        db.execSQL(user_table);
        db.execSQL(dataframe33_table);
        db.execSQL(dataframe35_table);
        db.execSQL(history_table);
        //db.execSQL(error_table);
    }

    //this is called if the database version number changes. It prevents users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table IF EXISTS USER_INFO");
        db.execSQL("Drop Table IF EXISTS DATAFRAME33_INFO");
        db.execSQL("Drop Table IF EXISTS DATAFRAME35_INFO");
        db.execSQL("Drop Table IF EXISTS HISTORY_INFO");
        //db.execSQL("Drop Table IF EXISTS ERROR_INFO");
        onCreate(db);
    }


    //Methods!!!

    //add to tables
    public boolean add_account(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        //If username exists return false
        Cursor cursor = db.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{user.getUsername()});  //Find user in user_table
        if (cursor.getCount() > 0) {
            cursor.close();
            return false;
        } else {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_USER_NAME, user.getUsername());
            cv.put(COLUMN_PASSWORD, user.getPassword());
            cv.put(COLUMN_FTP, user.getFTP());
            cv.put(COLUMN_PZ_1, user.getPz_1());
            cv.put(COLUMN_PZ_2, user.getPz_2());
            cv.put(COLUMN_PZ_3, user.getPz_3());
            cv.put(COLUMN_PZ_4, user.getPz_4());
            cv.put(COLUMN_PZ_5, user.getPz_5());
            cv.put(COLUMN_PZ_6, user.getPz_6());
            cv.put(COLUMN_PZ_7, user.getPz_7());
            //ID is a auto increment in the database
            long insert = db.insert(USER_INFO, null, cv);
            cursor.close();
            return insert != -1;
        }

    }

    public boolean add_dataframe33(dataframe33 dataframe33) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TIME_33, dataframe33.getTime_33());
        cv.put(COLUMN_INTERVAL, dataframe33.getInterval());
        cv.put(COLUMN_POWER, dataframe33.getPower());
        cv.put(COLUMN_TOTAL_CAL, dataframe33.getTotal_cal());
        cv.put(COLUMN_SPLIT_PACE, dataframe33.getSplit_pace());
        cv.put(COLUMN_SPLIT_POWER, dataframe33.getSplit_power());
        cv.put(COLUMN_SPLIT_CAL, dataframe33.getSplit_cal());
        cv.put(COLUMN_LAST_SPLIT_TIME, dataframe33.getLast_split_time());
        cv.put(COLUMN_LAST_SPLIT_DIST, dataframe33.getLast_split_dist());

        //ID is a auto increment in the database
        long insert = db.insert(DATAFRAME33_INFO, null, cv);
        return insert != -1;
    }

    public boolean add_dataframe35(dataframe35 dataframe35) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TIME_35, dataframe35.getTime_35());
        cv.put(COLUMN_DIST, dataframe35.getDist());
        cv.put(COLUMN_DRIVE_LEN, dataframe35.getDrive_len());
        cv.put(COLUMN_DRIVE_TIME, dataframe35.getDrive_time());
        cv.put(COLUMN_STROKE_REC_TIME, dataframe35.getStroke_rec_time());
        cv.put(COLUMN_STROKE_DIST, dataframe35.getStroke_dist());
        cv.put(COLUMN_PEAK_DRIVE_FORCE, dataframe35.getPeak_drive_force());
        cv.put(COLUMN_AVG_DRIVE_FORCE, dataframe35.getAvg_drive_force());
        cv.put(COLUMN_WORK_PER_STROKE, dataframe35.getWork_per_stroke());
        cv.put(COLUMN_STROKE_COUNT, dataframe35.getStroke_count());
        //ID is a auto increment in the database
        long insert = db.insert(DATAFRAME35_INFO, null, cv);
        return insert != -1;
    }

    public boolean add_history(String User, String workout, int error, double avg_power) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER, User);
        cv.put(COLUMN_WORKOUT, workout);
        cv.put(COLUMN_ERROR, error);
        cv.put(COLUMN_AVGPOWER, avg_power);

        //ID is a auto increment in the database
        long insert = db.insert(HISTORY_INFO, null, cv);
        return insert != -1;
    }

/*    public boolean add_error(String User, int error) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER, User);
        cv.put(COLUMN_ERROR, error);

        //ID is a auto increment in the database
        long insert = db.insert(ERROR_INFO, null, cv);
        return insert != -1;
    }*/


    //delete methods

    //delete one account from table
    public Boolean delete_account(String username, String password) //Username and password entered
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor1 = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username});//Find the data

        //password match
        String correct_password = null;
        while (cursor1.moveToNext()) {
            int index = cursor1.getColumnIndex(COLUMN_PASSWORD);
            correct_password = cursor1.getString(index);
        }
        boolean password_match = password.equals(correct_password);


        if (cursor1.getCount() > 0 & password_match) {
            //delete account from all tables
            long result1 = DB.delete(USER_INFO, "COLUMN_USER_NAME=?", new String[]{username});
            long result2 = DB.delete(HISTORY_INFO, "COLUMN_USER=?", new String[]{username});
            //long result3 = DB.delete(ERROR_INFO, "COLUMN_USER=?", new String[]{username});  //Deleted Error Table
            cursor1.close();
            //if (result1 == -1 || result2 == -1 || result3 == -1 ) { //deleted Error Table
            if (result1 == -1 || result2 == -1) {                     //deleted Error Table
                return false;
            } else {
                return true;
            }
        } else {
            cursor1.close();
            return false;
        }
    }

    public Boolean delete_dataframe33_table() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + DATAFRAME33_INFO);
        return true;
    }

    public Boolean delete_dataframe35_table() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + DATAFRAME35_INFO);
        return true;
    }

    //updating methods

    public Boolean updateuserFTP(String username, int FTP, int pz_1, int pz_2, int pz_3, int pz_4, int pz_5, int pz_6, int pz_7) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_FTP, FTP);
        cv.put(COLUMN_PZ_1, pz_1);
        cv.put(COLUMN_PZ_2, pz_2);
        cv.put(COLUMN_PZ_3, pz_3);
        cv.put(COLUMN_PZ_4, pz_4);
        cv.put(COLUMN_PZ_5, pz_5);
        cv.put(COLUMN_PZ_6, pz_6);
        cv.put(COLUMN_PZ_7, pz_7);
        Cursor cursor = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username}); // find in table
        if (cursor.getCount() > 0) {
            long result = DB.update(USER_INFO, cv, "COLUMN_USER_NAME = ?", new String[]{username}); //update table
            cursor.close();
            return result != -1;
        } else {
            cursor.close();
            return false;
        }
    }


    public Boolean updateuserPassword(String username, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PASSWORD, password);
        Cursor cursor = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username}); // find in table
        if (cursor.getCount() > 0) {
            long result = DB.update(USER_INFO, cv, "COLUMN_USER_NAME = ?", new String[]{username}); //update table
            cursor.close();
            return result != -1;
        } else {
            cursor.close();
            return false;
        }
    }

    //Other methods

    public boolean user_exists(String username) {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username});//Find the data
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }

    public Cursor get_history(String username) {  //display history table user specific
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from history_info where COLUMN_USER = ?", new String[]{username});//Find the data
        return cursor;
    }

/*    public Cursor get_error(String username) {  //display history table user specific
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from error_info where COLUMN_USER = ?", new String[]{username});//Find the data
        return cursor;
    }*/

    //Go getters for User

    public String getPassword(String username) //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username});//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_PASSWORD);
                String password = cursor.getString(index);
                cursor.close();
                return password;
            }
        } else {
            cursor.close();
            return "no Password";
        }
        return "no Password";
    }

    public int getFTP(String username) //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username});//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int FTP_index = cursor.getColumnIndex("COLUMN_FTP");
                int FTP = cursor.getInt(FTP_index);
                cursor.close();
                return FTP;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPZ_1(String username) //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username});//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_PZ_1);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPZ_2(String username) //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username});//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_PZ_2);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPZ_3(String username) //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username});//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_PZ_3);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }


    public int getPZ_4(String username) //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username});//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_PZ_4);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPZ_5(String username) //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username});//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_PZ_5);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPZ_6(String username) //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username});//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_PZ_6);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPZ_7(String username) //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user_info where COLUMN_USER_NAME = ?", new String[]{username});//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_PZ_7);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    //getters for databaseHelper33
    public int getTime_33() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_TIME_33);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPastTime_33() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_TIME_33);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getInterval() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_INTERVAL);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPastInterval() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_INTERVAL);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPower() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_POWER);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPastPower() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_POWER);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getTotal_cal() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_TOTAL_CAL);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPastTotal_cal() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_TOTAL_CAL);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getSplit_pace() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_SPLIT_PACE);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPastSplit_pace() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_SPLIT_PACE);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getSplit_power() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_SPLIT_POWER);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPastSplit_power() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_SPLIT_POWER);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getSplit_cal() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_SPLIT_CAL);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPastSplit_cal() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_SPLIT_CAL);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getLast_split_time() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_LAST_SPLIT_TIME);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPastLast_split_time() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_LAST_SPLIT_TIME);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getLast_split_dist() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_LAST_SPLIT_DIST);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public int getPastLast_split_dist() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe33_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_LAST_SPLIT_DIST);
                int pz = cursor.getInt(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }


    //getters for databaseHelper35
    public double getTime_35() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_TIME_35);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getPastTime_35() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_TIME_35);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getDist() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_DIST);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getPastDist() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_DIST);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getDrive_len() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_DRIVE_LEN);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getPastDrive_len() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_DRIVE_LEN);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getDrive_time() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_DRIVE_TIME);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getPastDrive_time() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_DRIVE_TIME);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getStroke_rec_time() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_STROKE_REC_TIME);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getPastStroke_rec_time() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_STROKE_REC_TIME);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getStroke_dist() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_STROKE_DIST);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getPastStroke_dist() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_STROKE_DIST);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getPeak_drive_force() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_PEAK_DRIVE_FORCE);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getPastPeak_drive_force() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_PEAK_DRIVE_FORCE);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getAvg_drive_force() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_PEAK_DRIVE_FORCE);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getPastAvg_drive_force() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_PEAK_DRIVE_FORCE);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getWork_per_stroke() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_WORK_PER_STROKE);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getPastWork_per_stroke() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_WORK_PER_STROKE);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getStroke_count() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_STROKE_COUNT);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }

    public double getPastStroke_count() //Username and password entered
    {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from dataframe35_info ORDER BY COLUMN_ID DESC LIMIT 1,1", null);//Find the data
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex(COLUMN_STROKE_COUNT);
                double pz = cursor.getDouble(index);
                cursor.close();
                return pz;
            }
        } else {
            cursor.close();
            return -1;
        }
        return -1;
    }


}

