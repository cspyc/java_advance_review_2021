package com.object.interface_;

/**
 * @author pi
 * @date 2021/04/11 14:38:32
 **/
public class DBLinkTest {
    public static void main(String[] args) {
        DBLinkTest dbLinkTest = new DBLinkTest();
        MySqlDB mySqlDB = new MySqlDB();
        dbLinkTest.linkDB(mySqlDB);

        OracleDB oracleDB = new OracleDB();
        dbLinkTest.linkDB(oracleDB);

    }

    public void linkDB(DBInterface db){
        db.connection();
        db.close();
    }
}
