package com.ca_bpy;

import com.ca_bpy.dao.IStudentDao;
import com.ca_bpy.domain.Student;

import com.ca_bpy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 *  Unit test
 *  Test select method.
 *  Test insert method.
 */
public class TestDemo {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
    //测试selectParam方法
    @Test
    public void testSelectParam() {
        List<Student> studentList =studentDao.selectStudentsParam("张三",22);
        System.out.println("查询表的内容结果如下：");
        for(Student students:studentList) {
            System.out.println(students);
        }
    }

    //测试selectObject方法
    @Test
    public void testSelectObject() {
        Student student = new Student();
        student.setName("张三");
        student.setAge(22);
        List<Student> studentList =studentDao.selectStudentsObject(student);
        System.out.println("查询表的内容结果如下：");
        for(Student students:studentList) {
            System.out.println(students);
        }
    }

    //测试insert方法
    @Test
    public void testInsert() {
        Student student = new Student();
        student.setId(10003);
        student.setName("王五");
        student.setEmail("wangwu@qq.com");
        student.setAge(21);
        int res = studentDao.insertStudents(student);
        sqlSession.commit();
        System.out.println("表中插入了" + res + "条数据");
    }

    //测试update方法
    @Test
    public void testUpdate() {
        Student student = new Student();
        student.setId(10003);
        student.setAge(23);
        int res = studentDao.updateStudents(student);
        sqlSession.commit();
        System.out.println("表中更新了" + res + "条数据的年龄内容");
    }

    //测试delete方法
    @Test
    public void testDelete() {
        int res = studentDao.deleteStudents(10003);
        sqlSession.commit();
        System.out.println("表中删除了" + res + "条数据");
    }
}
