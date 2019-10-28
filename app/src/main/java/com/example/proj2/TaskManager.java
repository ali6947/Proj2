package com.example.proj2;

import android.provider.BaseColumns;

public final class TaskManager {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private TaskManager() {}

    /* Inner class that defines the table contents */
    public static class TaskEntry implements BaseColumns {
        public static final String TABLE_NAME1 = "Level1";
        public static final String TABLE_NAME2 = "Level2";
        public static final String COLUMN_1_TITLE = "title1";
        public static final String COLUMN_2_TITLE = "title2";
        public static final String COLUMN_1_DESC = "desc1";
        public static final String COLUMN_2_DESC = "desc2";
        public static final String COLUMN_1_DATE = "date1";
        public static final String COLUMN_2_DATE = "date2";
        public static final String COLUMN_NAME_PARENT = "parent";
    }
}
