package com.qcby.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcby.dao.*;
import com.qcby.entity.*;
import com.qcby.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private KuJiandaDao kuJiandaDao;
    @Autowired
    private KuXuanzeDao kuXuanzeDao;
    @Autowired
    private TestPaperDao testPaperDao;
    @Autowired
    private TestStudentDao testStudentDao;
    @Autowired
    private TiKuDao tiKuDao;
    @Autowired
    private XuanzeAnalysisDao xuanzeAnalysisDao;
    @Autowired
    private StuErrtiDao stuErrtiDao;
    @Autowired
    private ClassInfoDao classInfoDao;


    @Override
    public Teacher selectByUserNameAndPassword(String name) {
        TeacherExample teacher = new TeacherExample();
        TeacherExample.Criteria criteria = teacher.createCriteria();
        criteria.andUserEqualTo(name);

        List<Teacher> list = teacherDao.selectByExample(teacher);

        if(list != null && list.size() > 0) {
            return list.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public Teacher selsctById(String userId) {
        return teacherDao.selectByPrimaryKey(userId);
    }

    @Override
    public int insertTeac(Teacher record) {
        return teacherDao.insert(record);
    }

    @Override
    public int insertJianda(KuJianda record) {
        return kuJiandaDao.insert(record);
    }

    @Override
    public int insertXuanze(KuXuanze record) {
        return kuXuanzeDao.insert(record);
    }

    @Override
    public List<KuXuanze> danxuanList(String testId) {
        KuXuanzeExample example = new KuXuanzeExample();
        KuXuanzeExample.Criteria criteria = example.createCriteria();
        criteria.andTestIdEqualTo(testId);
        criteria.andTypesEqualTo(1);
        List<KuXuanze> list = kuXuanzeDao.selectByExample(example);

        return list;
    }

    @Override
    public List<KuXuanze> duoxuanList(String testId) {
        KuXuanzeExample example = new KuXuanzeExample();
        KuXuanzeExample.Criteria criteria = example.createCriteria();
        criteria.andTestIdEqualTo(testId);
        criteria.andTypesEqualTo(2);
        List<KuXuanze> list = kuXuanzeDao.selectByExample(example);

        return list;
    }

    @Override
    public List<KuJianda> jiandaList(String testId) {
        KuJiandaExample example = new KuJiandaExample();
        KuJiandaExample.Criteria criteria = example.createCriteria();
        criteria.andTestIdEqualTo(testId);
        List<KuJianda> list = kuJiandaDao.selectByExample(example);

        return list;
    }

    @Override
    public List<KuXuanze> xuanList(String testId,int page,int limit) {
        KuXuanzeExample example = new KuXuanzeExample();
        KuXuanzeExample.Criteria criteria = example.createCriteria();
        criteria.andTestIdEqualTo(testId);

        PageHelper.startPage(page, limit);
        List<KuXuanze> list = kuXuanzeDao.selectByExample(example);

        return list;
    }

    @Override
    public List<TiKu> fromTiku(String projeect) {
        TiKuExample example = new TiKuExample();
        TiKuExample.Criteria criteria = example.createCriteria();
        criteria.andProjectEqualTo(projeect);
        List<TiKu> list = tiKuDao.selectByExample(example);
        return list;
    }

    @Override
    public int inserTestPaper(TestPaper record) {
        return testPaperDao.insert(record);
    }

    @Override
    public int updataRele(String testId , String date) {

        TestPaperExample example = new TestPaperExample();
        TestPaperExample.Criteria criteria = example.createCriteria();
        criteria.andTestIdEqualTo(testId);
        TestPaper testPaper = new TestPaper();
        testPaper.setIsrelease(1);
        testPaper.setDate(date);
        return testPaperDao.updateByExampleSelective(testPaper,example);
    }

    @Override
    public int updataPer(Integer id, Integer person, Integer rig) {
        KuXuanzeExample example = new KuXuanzeExample();
        KuXuanzeExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        KuXuanze kuXuanze = new KuXuanze();
        kuXuanze.setPerson(person);
        kuXuanze.setRig(rig);
        return kuXuanzeDao.updateByExampleSelective(kuXuanze , example);
    }

    @Override
    public int updataInfo(String userId, String nickname, String sex, String cellphone) {
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        criteria.andTeacIdEqualTo(userId);
        Teacher teacher = new Teacher();
        teacher.setUserPhone(cellphone);
        if("男".equals(sex)){
            teacher.setSex(1);
        }else {
            teacher.setSex(0);
        }
        teacher.setTeacName(nickname);
        return teacherDao.updateByExampleSelective(teacher , example);
    }

    @Override
    public KuXuanze getInfo(Integer id) {
        return kuXuanzeDao.selectByPrimaryKey(id);
    }

    @Override
    public TestPaper getPaper(String testId) {
        return testPaperDao.selectByPrimaryKey(testId);
    }

    @Override
    public int inserTestInfo(TestStudent testStudent) {
        return testStudentDao.insertSelective(testStudent);
    }

    @Override
    public int updataPwd(String user, String pwd) {
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(user);
        Teacher teacher = new Teacher();
        teacher.setTeacPwd(pwd);

        return teacherDao.updateByExampleSelective(teacher,example);
    }

    @Override
    public int repass(String teacId, String pwd) {
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        criteria.andTeacIdEqualTo(teacId);
        Teacher teacher = new Teacher();
        teacher.setTeacPwd(pwd);

        return teacherDao.updateByExampleSelective(teacher,example);
    }

    @Override
    public List<TestPaper> getTest(String teacId) {

        TestPaperExample example = new TestPaperExample();
        TestPaperExample.Criteria criteria = example.createCriteria();
        criteria.andTeacherIdEqualTo(teacId);
        criteria.andIsreleaseEqualTo(1);

        return testPaperDao.selectByExample(example);
    }

    @Override
    public List<TestStudent> getStud(String testId,int page,int limit) {
        TestStudentExample example = new TestStudentExample();
        TestStudentExample.Criteria criteria = example.createCriteria();
        criteria.andTestIdEqualTo(testId);

        PageHelper.startPage(page, limit);
        List<TestStudent> list = testStudentDao.selectByExample(example);
        return list;
    }

    @Override
    public Student getStu(String stuId) {
        return studentDao.selectByPrimaryKey(stuId);
    }

    @Override
    public int IsInsert(Integer id, String rate) {
        XuanzeAnalysis xuanzeAnalysis = new XuanzeAnalysis();
        xuanzeAnalysis.setTiId(id);
        xuanzeAnalysis.setCorrectRate(rate);
        return xuanzeAnalysisDao.insert(xuanzeAnalysis);
    }

    @Override
    public int updataRate(Integer id, String rate) {

        XuanzeAnalysisExample example = new XuanzeAnalysisExample();
        XuanzeAnalysisExample.Criteria criteria = example.createCriteria();
        criteria.andTiIdEqualTo(id);
        XuanzeAnalysis xuanzeAnalysis = new XuanzeAnalysis();
        xuanzeAnalysis.setCorrectRate(rate);
        return xuanzeAnalysisDao.updateByExampleSelective(xuanzeAnalysis , example);
    }

    @Override
    public XuanzeAnalysis getXuanzeRate(Integer id) {
        XuanzeAnalysisExample example = new XuanzeAnalysisExample();
        XuanzeAnalysisExample.Criteria criteria = example.createCriteria();
        criteria.andTiIdEqualTo(id);

        List<XuanzeAnalysis> list = xuanzeAnalysisDao.selectByExample(example);
        if(list != null && list.size() > 0){
            return list.get(0);
        }else{
            return null;
        }

    }

    @Override
    public List<XuanzeAnalysis> selectXuanze() {
        return xuanzeAnalysisDao.selectAll();
    }

    @Override
    public int insertStuerr(String stuId, Integer type, Integer tiId, String errAnswer) {
        StuErrti stuErrti = new StuErrti();
        stuErrti.setErrAnswer(errAnswer);
        stuErrti.setStuId(stuId);
        stuErrti.setTiId(tiId);
        stuErrti.setType(type);
        return stuErrtiDao.insertSelective(stuErrti) ;
    }

    @Override
    public int batchStudent(Student student) {
        return studentDao.insertSelective(student);
    }

    @Override
    public List<ClassInfo> getClassInfo(String claTeacId) {
        ClassInfoExample example = new ClassInfoExample();
        ClassInfoExample.Criteria criteria = example.createCriteria();
        criteria.andClaTeacidEqualTo(claTeacId);
        return classInfoDao.selectByExample(example);
    }

    @Override
    public int delCla(Integer claId) {
        return classInfoDao.deleteByPrimaryKey(claId);
    }

    @Override
    public int addClass(String claTeacId, String claName, String claProject) {
        ClassInfo classInfo = new ClassInfo();
        classInfo.setClaName(claName);
        classInfo.setClaProject(claProject);
        classInfo.setClaTeacid(claTeacId);
        return classInfoDao.insertSelective(classInfo);
    }

    @Override
    public List<Student> selsctByClaName(String claName,int page,int limit) {
       StudentExample example = new StudentExample();
       StudentExample.Criteria criteria = example.createCriteria();
       criteria.andClaNameEqualTo(claName);
       PageHelper.startPage(page, limit);
       List<Student> list = studentDao.selectByExample(example);

        return list;
    }

}
