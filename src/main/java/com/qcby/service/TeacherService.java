package com.qcby.service;

import com.qcby.entity.*;

import java.util.List;

public interface TeacherService {

    /**
     * @author zte
     * @param name
     * @return
     */
    Teacher selectByUserNameAndPassword(String name);

    Teacher selsctById(String userId);

    int insertTeac(Teacher record);

    /**
     * 添加简答题
     * @param record
     * @return
     */
    int insertJianda(KuJianda record);

    /**
     * 添加选择，包括单选和多选
     * @param record
     * @return
     */
    int insertXuanze(KuXuanze record);

    /**
     * 由测试id查找
     * @param testId
     * @return
     */
    List<KuXuanze> danxuanList(String testId);
    List<KuXuanze> duoxuanList(String testId);
    List<KuJianda> jiandaList(String testId);
    List<KuXuanze> xuanList(String testId,int page , int limit);

    /**
     * 由学科类别从题库导入试题
     * @param projeect
     * @return
     */
    List<TiKu> fromTiku(String projeect);


    /**
     *预览试卷，同时决定试卷的未发布状态
     * @param record
     * @return
     */
    int inserTestPaper(TestPaper record);

    int updataRele(String testid, String date);

    int updataPer(Integer id , Integer person , Integer rig);

    int updataInfo(String userId , String nickname , String sex ,String cellphone);

    KuXuanze getInfo(Integer id);

    TestPaper getPaper(String testId);

    int inserTestInfo(TestStudent testStudent);

    /**
     * 用于找回密码
     * @param user
     * @param pwd
     * @return
     */
    int updataPwd(String user,String pwd);

    /**
     * 重置密码
     * @param teacId
     * @param pwd
     * @return
     */
    int repass(String teacId,String pwd);

    List<TestPaper> getTest(String teacId);

    List<TestStudent> getStud(String testId,int page,int limit);

    Student getStu(String stuId);

    int IsInsert(Integer id , String rate);

    int updataRate(Integer id , String rate);

    /**
     * 根据题目查询
     * @param id
     * @return
     */
    XuanzeAnalysis getXuanzeRate(Integer id);

    List<XuanzeAnalysis> selectXuanze();

    int insertStuerr(String stuId , Integer type , Integer tiId , String errAnswer);

    int batchStudent(Student student);

    List<ClassInfo> getClassInfo(String claTeacId);

    int delCla(Integer claId);

    int addClass(String claTeacId , String claName , String claProject);

    List<Student> selsctByClaName(String claName,int page,int limit);

}
