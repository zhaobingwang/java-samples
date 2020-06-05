package snippets.base.dao;

import snippets.base.dao.mysql.jdbc.StudentOp;

import java.sql.SQLException;

public class DataHome {
    public static void main(String[] args) throws Exception {
        System.out.println("Database operation...");
        StudentOp studentOp = new StudentOp();
//        studentOp.query();
//        studentOp.querySafe();
//        studentOp.insert();
//        studentOp.update();
//        studentOp.delete(false);
//        studentOp.transaction();
        studentOp.batchInsert();
    }
}
