package com.qcby.service;


import com.qcby.entity.*;

import java.util.List;

public interface StudentService {

    /**
     * @author zte
     * @param userId
     * @return
     */
    Student selectByUserNameAndPassword(String userId);

    int insertStu(Student record);

    Student selsctById(String userId);

    /**
     * 根据学生的班级去寻找对应的科目考试信息
     * @param claName
     * @return
     */
    List<TestPaper> getTestInfo(String claName);

    TestPaper findPaper(String testId);

    TestStudent IfExitStu(String testId , String stuId);

    /**
     * 获取历史成绩
     * @param stuId
     * @return
     */
    List<TestStudent> getTestList(String stuId);

    Student findStu(String stuId);
    Teacher findTea(String teacherId);

    /**
     * 找回密码
     * @param user
     * @param pwd
     * @return
     */
    int updataPwd(String user,String pwd);

    /**
     * 重置密码
     * @param stuId
     * @param pwd
     * @return
     */
    int repass(String stuId,String pwd);

    int updataInfo(String userId , String nickname , String sex ,String cellphone , String claName);

    List<StuErrti> selsctErrByStuId(String stuId,int page,int limit);

    KuXuanze selectXuanze(Integer id);

    KuJianda selectJian(Integer id);

}
