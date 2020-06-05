package com.qcby.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcby.dao.*;
import com.qcby.entity.*;
import com.qcby.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

   @Autowired
   private StudentDao studentDao;
   @Autowired
   private TestPaperDao testPaperDao;
   @Autowired
   private TestStudentDao testStudentDao;
   @Autowired
   private StudentDao stuDao;
   @Autowired
   private TeacherDao teacherDao;
   @Autowired
   private StuErrtiDao stuErrtiDao;
   @Autowired
   private KuXuanzeDao kuXuanzeDao;
   @Autowired
   private KuJiandaDao kuJiandaDao;


    @Override
    public Student selectByUserNameAndPassword(String userId) {

        StudentExample student = new StudentExample();
        StudentExample.Criteria criteria = student.createCriteria();
        criteria.andUserEqualTo(userId);

        List<Student> list = studentDao.selectByExample(student);

        if(list != null && list.size() > 0) {
            return list.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public int insertStu(Student record) {
        return studentDao.insert(record);
    }

    @Override
    public Student selsctById(String userId) {
        return studentDao.selectByPrimaryKey(userId);
    }

    @Override
    public List<TestPaper> getTestInfo(String claName) {

        TestPaperExample example = new TestPaperExample();
        TestPaperExample.Criteria criteria = example.createCriteria();
        criteria.andClaNameEqualTo(claName);
        criteria.andIsreleaseEqualTo(1);
        List<TestPaper> list = testPaperDao.selectByExample(example);
        if(list != null && list.size() > 0) {
            return list;
        }
        else {
            return null;
        }
    }

    @Override
    public TestPaper findPaper(String testId) {
        return testPaperDao.selectByPrimaryKey(testId);
    }

    @Override
    public TestStudent IfExitStu(String testId, String stuId) {
        TestStudentExample example = new TestStudentExample();
        TestStudentExample.Criteria criteria = example.createCriteria();
        criteria.andTestIdEqualTo(testId);
        criteria.andStuIdEqualTo(stuId);
        List<TestStudent> list = testStudentDao.selectByExample(example);
        if(list != null && list.size() > 0) {
            return list.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public List<TestStudent> getTestList(String stuId) {
        TestStudentExample example = new TestStudentExample();
        TestStudentExample.Criteria criteria = example.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        List<TestStudent> list = testStudentDao.selectByExample(example);
        return list;
    }

    @Override
    public Student findStu(String stuId) {
        return stuDao.selectByPrimaryKey(stuId);
    }

    @Override
    public Teacher findTea(String teacherId) {
        return teacherDao.selectByPrimaryKey(teacherId);
    }

    @Override
    public int updataPwd(String user,String pwd) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(user);
        Student student = new Student();
        student.setPwd(pwd);

        return studentDao.updateByExampleSelective(student,example);
    }

    @Override
    public int repass(String stuId, String pwd) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        Student student = new Student();
        student.setPwd(pwd);

        return studentDao.updateByExampleSelective(student,example);
    }

    @Override
    public int updataInfo(String userId , String nickname, String sex, String cellphone) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andStuIdEqualTo(userId);
        Student student = new Student();
        student.setPhone(cellphone);
        if("男".equals(sex)){
            student.setSex(1);
        }else {
            student.setSex(0);
        }
        student.setName(nickname);
        return studentDao.updateByExampleSelective(student , example);
    }

    @Override
    public List<StuErrti> selsctErrByStuId(String stuId,int page,int limit) {
        StuErrtiExample example = new StuErrtiExample();
        StuErrtiExample.Criteria criteria = example.createCriteria();
        criteria.andStuIdEqualTo(stuId);

        PageHelper.startPage(page, limit);
        List<StuErrti> list = stuErrtiDao.selectByExample(example);

        return list;
    }

    @Override
    public KuXuanze selectXuanze(Integer id) {
        return kuXuanzeDao.selectByPrimaryKey(id);
    }

    @Override
    public KuJianda selectJian(Integer id) {
        return kuJiandaDao.selectByPrimaryKey(id);
    }

}
