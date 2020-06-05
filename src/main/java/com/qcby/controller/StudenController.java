package com.qcby.controller;

import com.github.pagehelper.PageInfo;
import com.qcby.entity.*;
import com.qcby.model.ErrTitle;
import com.qcby.model.Sorelist;
import com.qcby.service.StudentService;
import com.qcby.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@Controller
@RequestMapping("/student")
public class StudenController extends BaseController{

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    private int flag = 0;


    /**
     * 学生主页显示
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/student")
    public String list(Model model , HttpServletRequest request){
        //后端验证是否登录
        String session = (String) request.getSession().getAttribute("loginUser");
        if(session == null){
           model.addAttribute("msg","请先登录");
           return "/user/login";
        }
        Student student = studentService.selsctById(session);
        String user = student.getName();

        model.addAttribute("user",user);

        return "template";
    }

    /**
     * 学生查看有考试信息的学科
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/getTest" ,method = RequestMethod.GET)
    public String getTest(Model model , HttpServletRequest request){

        //后端验证是否登录
        String session = (String) request.getSession().getAttribute("loginUser");
        if(session == null){
            model.addAttribute("msg","请先登录");
            return "/user/login";
        }

        Student student = studentService.selsctById(session);
        String claName = student.getClaName();
        List<TestPaper> list = studentService.getTestInfo(claName);

        //后端控制考试时间，防止被攻击
        if(list!=null) {
            //通过Util包的Calendar 获取时间，分别获取年月日时分秒
            Calendar cal = Calendar.getInstance();
            int y = cal.get(Calendar.YEAR);
            int m = cal.get(Calendar.MONTH) + 1;
            int d = cal.get(Calendar.DATE);
            int h = cal.get(Calendar.HOUR_OF_DAY);
            int mi = cal.get(Calendar.MINUTE);
            int s = cal.get(Calendar.SECOND);
            //验证当前时间是否在考试范围内
            for (TestPaper testPaper : list) {
                //2020-05-27 21:00:00 - 2020-05-27 22:30:00
                String date = testPaper.getDate();
                String[] dat = date.split("-", 7);

                String[] befor = dat[2].split(" ");
                String[] bclock = befor[1].split(":");
                int befYear = Integer.parseInt(dat[0]);
                int befMonth = Integer.parseInt(dat[1]);
                int befDay = Integer.parseInt(befor[0]);
                int befHour = Integer.parseInt(bclock[0]);
                int befMin = Integer.parseInt(bclock[1]);
                int befSenc = Integer.parseInt(bclock[2]);

                String[] after = dat[5].split(" ");
                String[] aclock = after[1].split(":");
                String[] yy = dat[3].split(" ");
                int aftYear = Integer.parseInt(yy[1]);
                int aftMonth = Integer.parseInt(dat[4]);
                int aftDay = Integer.parseInt(after[0]);
                int aftHour = Integer.parseInt(aclock[0]);
                int aftMin = Integer.parseInt(aclock[1]);
                int aftSenc = Integer.parseInt(aclock[2]);

                if (y < befYear || (y == befYear && m < befMonth) || (y == befYear && m == befMonth && d < befDay) || (y == befYear && m == befMonth && d == befDay && h < befHour) || (y == befYear && m == befMonth && d == befDay && h == befHour && mi < befMin) || (y == befYear && m == befMonth && d == befDay && h == befHour && mi == befMin && s < befSenc)) {
                    testPaper.setMsg("考试尚未开始");
                } else if (y > aftYear || (y == aftYear && m > aftMonth) || (m == aftMonth && d > aftDay) || (m == aftMonth && d == aftDay && h > aftHour) || (m == aftMonth && d == aftDay && h == aftHour && mi > aftMin) || (m == aftMonth && d == aftDay && h == aftHour && mi == aftMin && s > aftSenc)) {
                    testPaper.setMsg("考试已结束");
                } else {
                    testPaper.setMsg("考试进行中");
                }

                String testId = testPaper.getTestId();
                TestStudent student1 = studentService.IfExitStu(testId , session);
                if(student1 != null){
                    testPaper.setMsg("考试结果已提交");
                }
            }
        }
        model.addAttribute("list",list);

        return "/home/studentHome";
    }

    /**
     * 得到对应试卷
     * @param model
     * @param testId
     * @param request
     * @return
     */
    @RequestMapping(value = "/getPaper" ,method = RequestMethod.GET)
    public String getPaper(Model model , @RequestParam("testId") String testId , HttpServletRequest request){

        //后端验证是否登录
        String session = (String) request.getSession().getAttribute("loginUser");
        if(session == null){
            model.addAttribute("msg","请先登录");
            return "/user/login";
        }

        //进入考试之后不可再查看错题，防止作弊
        flag = 1;

        List<KuXuanze> danxuanList = teacherService.danxuanList(testId);
        List<KuXuanze> duoxuanList = teacherService.duoxuanList(testId);
        List<KuJianda> jiandaList = teacherService.jiandaList(testId);

        TestPaper paper = studentService.findPaper(testId);
        String title = paper.getTestProject();
        String className = paper.getClaName();
        String date = paper.getDate();

        model.addAttribute("one",danxuanList);
        model.addAttribute("two",duoxuanList);
        model.addAttribute("three",jiandaList);
        model.addAttribute("testTitle",title);
        model.addAttribute("cla_name",className);
        model.addAttribute("testId",testId);
        model.addAttribute("date",date);
        model.addAttribute("flag",0);

        return "/home/shijuan";
    }

    /**
     * 获取历史成绩
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/histsore",method = RequestMethod.GET)
    public String histsore(Model model , HttpServletRequest request){
        //后端验证是否登录
        String session = (String) request.getSession().getAttribute("loginUser");
        if(session == null){
            model.addAttribute("msg","请先登录");
            return "/user/login";
        }
        List<TestStudent> list = studentService.getTestList(session);
        List<Sorelist> sorelists = new ArrayList<Sorelist>();

        for (TestStudent test : list) {
            Sorelist sorelist = new Sorelist();
            TestPaper paper = studentService.findPaper(test.getTestId());
            Student student = studentService.findStu(test.getStuId());
            Teacher teacher = studentService.findTea(paper.getTeacherId());
            sorelist.setName(student.getName());
            sorelist.setFraction(test.getFraction());
            sorelist.setTestObject(test.getProject());
            sorelist.setDifficult(paper.getDifficult());
            sorelist.setClaName(paper.getClaName());
            sorelist.setTeaName(teacher.getTeacName());
            sorelist.setDate(paper.getDate());
            sorelist.setTestTitle(paper.getTestTitle());

            sorelists.add(sorelist);
        }
        model.addAttribute("list",sorelists);
        return "/home/sorelist";
    }

    /**
     * 得到错题列表
     * @param request
     * @return
     */
    @RequestMapping("/errlist")
    @ResponseBody
    public Map<String , Object> errlist(HttpServletRequest request ,@RequestParam("page") int page , @RequestParam("limit") int limit){
        Map<String , Object> map = new ConcurrentHashMap<>();

        if(flag == 1){
            map.put("data","已进入考试，无法查看题目");
            map.put("count",0);
            map.put("code",0);
            map.put("msg","好好考试");
            return map;
        }
        String session = (String) request.getSession().getAttribute("loginUser");
        List<ErrTitle> list = new ArrayList<>();

        List<StuErrti> stuErrtiList = studentService.selsctErrByStuId(session,page,limit);
        PageInfo<StuErrti> pageInfo = new PageInfo<StuErrti>(stuErrtiList);
        for (StuErrti stuErrti : stuErrtiList) {
            Integer type = stuErrti.getType();
            int tiId = stuErrti.getTiId();
            if(type == 1 || type == 2){
                KuXuanze kuXuanze = studentService.selectXuanze(tiId);
                ErrTitle errTitle = new ErrTitle();
                errTitle.setStuId(session);
                errTitle.setType(type);
                errTitle.setTestTitle(kuXuanze.getTestTitle());
                errTitle.setProject(kuXuanze.getProject());
                errTitle.setTopic(kuXuanze.getTopic());
                errTitle.setA(kuXuanze.getA());
                errTitle.setB(kuXuanze.getB());
                errTitle.setC(kuXuanze.getC());
                errTitle.setD(kuXuanze.getD());
                errTitle.setAnswer(kuXuanze.getAnswer());
                errTitle.setErrAnswer(stuErrti.getErrAnswer());
                errTitle.setParsing(kuXuanze.getParsing());
                list.add(errTitle);
            }else{
                KuJianda kuJianda = studentService.selectJian(tiId);
                ErrTitle errTitle = new ErrTitle();
                errTitle.setStuId(session);
                errTitle.setType(type);
                errTitle.setTestTitle(errTitle.getTestTitle());
                errTitle.setProject(errTitle.getProject());
                errTitle.setTopic(errTitle.getTopic());
                errTitle.setAnswer(errTitle.getAnswer());
                errTitle.setErrAnswer(stuErrti.getErrAnswer());
                errTitle.setParsing(errTitle.getParsing());
                list.add(errTitle);
            }
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",list);
        return map;
    }

}
