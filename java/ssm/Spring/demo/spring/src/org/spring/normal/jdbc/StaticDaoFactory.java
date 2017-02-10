package org.spring.normal.jdbc;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午1:00
 */
public class StaticDaoFactory {
    public static IEmpDao getEmpDao() {
        return new EmpDao();
    }
}
