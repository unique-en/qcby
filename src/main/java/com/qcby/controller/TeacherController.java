package com.qcby.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.qcby.entity.*;
import com.qcby.excle.ExcelUtil;
import com.qcby.model.StudentModel;
import com.qcby.model.TopicAnalysis;
import com.qcby.service.TeacherService;
import com.qcby.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController{

    @Autowired
    private TeacherService teacherService;

    /**
     * 教师登录接口
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/teacher")
    public String list(Model model , HttpServletRequest request){

        //验证是否登录
        String session = (String) request.getSession().getAttribute("loginUser");
        if(session == null){
            model.addAttribute("msg","请先登录");
            return "/user/login";
        }

        Teacher teacher = teacherService.selsctById(session);
        String user = teacher.getTeacName();
        model.addAttribute("user",user);

        return "teacher";
    }

    /**
     * 生成试卷题目，包括单多选、简答，添加到对应表中
     * @param model
     * @param testId
     * @param testTitle
     * @param difficult
     * @param second
     * @param title
     * @param A
     * @param B
     * @param C
     * @param D
     * @param answer
     * @param parsing
     * @param project
     * @param type
     * @param request
     * @return
     */
    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    @ResponseBody
    public String insert(Model model , @RequestParam("testId") String testId,@RequestParam("testTitle") String testTitle, @RequestParam("difficult")String difficult ,@RequestParam(value = "second",required = false)  String second ,
                         @RequestParam("title")String title , @RequestParam("A")String A , @RequestParam("B")String B , @RequestParam("C")String C , @RequestParam("D")String D,
                         @RequestParam("answer")String answer , @RequestParam(value = "parsing",required = false)String parsing , @RequestParam("project")String project , @RequestParam("type")String type ,HttpServletRequest request){
        //后端验证是否登录
        String session = (String) request.getSession().getAttribute("loginUser");
        if(session == null){
            model.addAttribute("msg","请先登录");
            return "/user/login";
        }

        System.err.println(answer+"--------------------------");
        System.err.println(answer.length()+"--------------------------");

        if(answer == null || answer == ""){
            return "error";
        }

        /**
         * 每份试卷对应一个uuid,
         * 如果没有则生成一个，
         * 页面退出则当前试卷id失效
         */
        if(testId == null || testId == ""){
            testId = getId();
        }

        /**
         * 对选择和简答分类，插入到对应的表中
         */
        if(type.equals("简答")){
            KuJianda jianda = new KuJianda();
            jianda.setTestId(testId);
            jianda.setProject(project);
            jianda.setTopic(title);

            jianda.setAnswer(answer);
            jianda.setDifficult(difficult);
            if(second != null && second != ""){
                jianda.setFraction(Double.parseDouble(second));
            }
            jianda.setPerson(0);
            jianda.setRig(0);
            jianda.setTestTitle(testTitle);

            teacherService.insertJianda(jianda);
        }else {
            char[] str = answer.toCharArray();
            for (char c : str) {
                if(c!='A' && c!='B' && c!='C' && c!='D'){
                    return "error";
                }
            }
            KuXuanze xuanze = new KuXuanze();
            xuanze.setTestId(testId);
            xuanze.setProject(project);
            if(type.equals("单选")){
                xuanze.setTypes(1);
            }else {
                xuanze.setTypes(2);
            }
            xuanze.setTestTitle(testTitle);
            xuanze.setTopic(title);
            xuanze.setA(A);
            xuanze.setB(B);
            xuanze.setC(C);
            xuanze.setD(D);
            xuanze.setAnswer(answer);
            xuanze.setParsing(parsing);
            xuanze.setDifficult(difficult);
            xuanze.setFraction(Double.parseDouble(second));
            xuanze.setRig(0);
            xuanze.setPerson(0);
            teacherService.insertXuanze(xuanze);

        }

        //返回试卷id,便于预览和生成对应试卷试题
        return testId;
    }

    /**
     * 获取预览试卷的功能，并存到数据库，状态为0：未发布
     * @param model
     * @param testTitle
     * @param testId
     * @param project
     * @param cla_name
     * @param difficult
     * @param request
     * @return
     */
    @RequestMapping(value = "/yulan" , method = RequestMethod.GET)
    public String view(Model model, @RequestParam("testTitle") String testTitle  , @RequestParam("testId") String testId , @RequestParam("project") String project ,
                       @RequestParam("cla_name") String cla_name , @RequestParam("difficult") String difficult , HttpServletRequest request){
        //后端验证是否登录
        String session = (String) request.getSession().getAttribute("loginUser");
        if(session == null){
            model.addAttribute("msg","请先登录");
            return "/user/login";
        }

        TestPaper testPaper = new TestPaper();
        testPaper.setTeacherId(session);
        testPaper.setTestId(testId);
        testPaper.setTestTitle(testTitle);
        testPaper.setTestProject(project);
        testPaper.setDate("a");
        testPaper.setClaName(cla_name);
        testPaper.setIsrelease(0);
        testPaper.setDifficult(difficult);

        int insert = teacherService.inserTestPaper(testPaper);

        List<KuXuanze> danxuanList = teacherService.danxuanList(testId);
        List<KuXuanze> duoxuanList = teacherService.duoxuanList(testId);
        List<KuJianda> jiandaList = teacherService.jiandaList(testId);

        model.addAttribute("one",danxuanList);
        model.addAttribute("two",duoxuanList);
        model.addAttribute("three",jiandaList);
        model.addAttribute("testTitle",testTitle);
        model.addAttribute("cla_name",cla_name);
        model.addAttribute("testId",testId);
        return "/home/shijuanYulan";
    }


    /**
     *  发布试卷，返回学生试卷样本
     * @param model
     * @param date
     * @param testid
     * @param request
     * @return
     */
    @RequestMapping(value = "/release" , method = RequestMethod.POST)
    public String release(Model model, @RequestParam("date") String date , @RequestParam("testid") String testid , @RequestParam("className") String className ,@RequestParam("title") String title ,HttpServletRequest request){

        //后端验证是否登录
        String session = (String) request.getSession().getAttribute("loginUser");
        if(session == null){
            model.addAttribute("msg","请先登录");
            return "/user/login";
        }

        int update = teacherService.updataRele(testid,date);

        //获取试题
        List<KuXuanze> danxuanList = teacherService.danxuanList(testid);
        List<KuXuanze> duoxuanList = teacherService.duoxuanList(testid);
        List<KuJianda> jiandaList = teacherService.jiandaList(testid);

        model.addAttribute("one",danxuanList);
        model.addAttribute("two",duoxuanList);
        model.addAttribute("three",jiandaList);
        model.addAttribute("testTitle",title);
        model.addAttribute("cla_name",className);
        model.addAttribute("testId",testid);
        model.addAttribute("date",date);
        model.addAttribute("flag",1);

        return "/home/shijuan";
    }

    /**
     * 系统判断题目(选择题)正误，并将考生的考试信息以及分数存档
     * @param data
     * @param request
     * @return
     */
    @RequestMapping(value = "/judge" , method = RequestMethod.POST)
    @ResponseBody
    public Map<Object , Object> judge(@RequestParam Map<Object , Object> data,HttpServletRequest request){

        String session = (String) request.getSession().getAttribute("loginUser");

        //获取试卷id
        String testId = null;

        //记录试卷的总分，并返回给前端，显示试卷分数
        double sum = 0;
        //定义map,用于返回前端的数据
        Map<Object, Object> mapp = new ConcurrentHashMap<>();

        //收集前端传过来的多选题答案
        Map<Integer, String> duoxuan = new HashMap<>();

        for(Map.Entry<Object , Object> en : data.entrySet()){
            int len = ((String) en.getKey()).length();
            //判断是单选还是多选，如果str为1则是单选，否则为多选,如果是多选str代表答案之一
            String str = ((String) en.getKey()).substring(0,1);
            //获取题目id
            String str2 = ((String) en.getKey()).substring(1,len);
            if(!"eid".equals(str2) && !"ile".equals(str2)){
                Integer id = Integer.parseInt(str2);
                //获取多选题答案
                if(!str.equals("1")){
                    if(duoxuan.get(id) == null){
                        duoxuan.put(id,str);
                    }else {
                        duoxuan.put(id,duoxuan.get(id) + str);
                    }
                }
            }else {
                testId = (String) en.getValue();
            }

        }
        for(Map.Entry<Object , Object> en : data.entrySet()){
            int len = ((String) en.getKey()).length();
            //判断是单选还是多选，如果str为1则是单选，否则为多选,如果是多选str代表答案之一
            String str = ((String) en.getKey()).substring(0,1);
            //获取题目id
            String str2 = ((String) en.getKey()).substring(1,len);
            if(!"eid".equals(str2) && !"ile".equals(str2)){
                Integer id = Integer.parseInt(str2);
                //得到题目信息，主要是答案和分数
                KuXuanze info = teacherService.getInfo(id);
                //获取本题的提交人数以及正确提交人数
                int person = info.getPerson();
                int rig = info.getRig();

                String answer = info.getAnswer();
                //获取题目分数
                double score = info.getFraction();
                if(str.equals("1")){
                    person++;
                    if(answer.equals(en.getValue())){
                        sum += score;
                        rig += 1;
                        float rate = (float)rig/person;
                        NumberFormat nt = NumberFormat.getPercentInstance();
                        //设置百分数精确度2即保留两位小数
                        nt.setMinimumFractionDigits(2);
                        //计算正确率
                        String nu = nt.format(rate);
                        if(teacherService.getXuanzeRate(id) == null){
                            int IsInsert = teacherService.IsInsert(id , nu);
                        }else {
                            int isUpdat = teacherService.updataRate(id , nu);
                        }
                    }else {
                        String title = info.getTopic();
                        String tell = "正确答案为:" + answer + ",您的答案为:" + en.getValue();
                        mapp.put(title,tell);
                        //对于错误结果插回表中做记录
                        int insertStuerr = teacherService.insertStuerr(session , 1 , id, (String)en.getValue());

                        float rate = (float)rig/person;
                        NumberFormat nt = NumberFormat.getPercentInstance();
                        //设置百分数精确度2即保留两位小数
                        nt.setMinimumFractionDigits(2);
                        //计算正确率
                        String nu = nt.format(rate);
                        if(teacherService.getXuanzeRate(id) == null){
                            int IsInsert = teacherService.IsInsert(id , nu);
                        }else {
                            int isUpdat = teacherService.updataRate(id , nu);
                        }
                    }
                }else {
                    if(duoxuan.get(id) != null){
                        String value = duoxuan.get(id);
                        person ++;
                        if(value.equals(answer)){
                            sum += score;
                            rig ++;
                            float rate = (float)rig/person;
                            NumberFormat nt = NumberFormat.getPercentInstance();
                            //设置百分数精确度2即保留两位小数
                            nt.setMinimumFractionDigits(2);
                            //计算正确率
                            String nu = nt.format(rate);

                            if(teacherService.getXuanzeRate(id) == null){
                                int IsInsert = teacherService.IsInsert(id , nu);
                            }else {
                                int isUpdat = teacherService.updataRate(id , nu);
                            }
                        }else {
                            String title = info.getTopic();
                            String tell = "正确答案为:" + answer + ",您的答案为:" + value;
                            mapp.put(title,tell);
                            //对于错误结果插回表中做记录
                            int insertStuerr = teacherService.insertStuerr(session , 2 , id, value);

                            float rate = (float)rig/person;
                            NumberFormat nt = NumberFormat.getPercentInstance();
                            //设置百分数精确度2即保留两位小数
                            nt.setMinimumFractionDigits(2);
                            //计算正确率
                            String nu = nt.format(rate);
                            if(teacherService.getXuanzeRate(id) == null){
                                int IsInsert = teacherService.IsInsert(id , nu);
                            }else {
                                int isUpdat = teacherService.updataRate(id , nu);
                            }
                        }
                        duoxuan.put(id,null);
                    }
                }
                int IsSuccess = teacherService.updataPer(id , person , rig);
            }
        }

        //获取多选题的答案
//        String jiananswer = "";
//        for(Map.Entry<Object , Object> en : data.entrySet()){
//            System.out.println(en.getKey() + "------------" + en.getValue());
//            if(en.getKey().toString().length() > 1){
//                break;
//            }
//            jiananswer += (String)en.getValue();
//        }

        //将考生考试结果存档
        TestPaper paper = teacherService.getPaper(testId);
        String project = paper.getTestProject();
        TestStudent testStudent = new TestStudent();
        testStudent.setStuId(session);
        testStudent.setProject(project);
        testStudent.setTestId(testId);
        testStudent.setFraction(sum);
        int num = teacherService.inserTestInfo(testStudent);

        mapp.put("score",sum);
        return mapp;
    }

    /**
     * 导出对应科目的题库试题
     * @param testObj
     * @param request
     * @return
     */
    @RequestMapping(value = "/impor" , method = RequestMethod.GET)
    @ResponseBody
    public Map<String , Object> impor( @RequestParam("testObj") String testObj ,  HttpServletRequest request){//, @RequestParam("page") Integer page , @RequestParam("limit") Integer limit ,
        Map<String , Object> map = new ConcurrentHashMap<String , Object>();

        //获取试题
        List<TiKu> list = teacherService.fromTiku(testObj);

        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }

    /**
     * 题库导入试题并生成预览试卷
     * @param obj
     * @param request
     * @return
     */
    @RequestMapping(value = "/impTiku",method = RequestMethod.POST)
    @ResponseBody
    public Map<String , Object> impTiku(@RequestBody JSONObject obj, HttpServletRequest request){
        Map<String , Object> map = new ConcurrentHashMap<String , Object>();

        //生成试卷id
        String testId = getId();

        String data=obj.toJSONString();
        //解析json数据
        JSONObject json = JSON.parseObject(data);
        String createArr=json.getString("createArr");
        if(StringUtils.isNotEmpty(createArr)){
            JSONArray createArray=JSONArray.parseArray(createArr);
            for(int i=0;i<createArray.size();i++){
                String project=JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("project");
                String topic=JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("topic");
                Integer type=JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getInteger("type");
                String answer=JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("answer");
                String parsing=JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("parsing");
                String difficult=JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("difficult");
                Double fraction=JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getDouble("fraction");
                String rig=JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("rig");
                if(type != 3){
                    KuXuanze xuanze = new KuXuanze();
                    String A=JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("a");
                    String B=JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("b");
                    String C=JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("c");
                    String D=JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("d");
                    xuanze.setTestId(testId);
                    xuanze.setTestTitle(project);
                    xuanze.setProject(project);
                    xuanze.setTopic(topic);
                    xuanze.setTypes(type);
                    xuanze.setAnswer(answer);
                    xuanze.setParsing(parsing);
                    xuanze.setDifficult(difficult);
                    xuanze.setA(A);
                    xuanze.setB(B);
                    xuanze.setC(C);
                    xuanze.setD(D);
                    xuanze.setRig(0);
                    xuanze.setPerson(0);
                    xuanze.setFraction(fraction);
                    int num = teacherService.insertXuanze(xuanze);
                }else {
                    KuJianda jianda = new KuJianda();
                    jianda.setTestId(testId);
                    jianda.setTestTitle(project);
                    jianda.setProject(project);
                    jianda.setTopic(topic);
                    jianda.setAnswer(answer);
                    jianda.setDifficult(difficult);
                    jianda.setFraction(fraction);
                    jianda.setRig(0);
                    jianda.setPerson(0);
                    int two = teacherService.insertJianda(jianda);
                }
            }
        }else {
            map.put("code",2);
            map.put("msg","您未导入任何题目");
            return map;
        }

        map.put("code",0);
        map.put("msg","导入成功");
        map.put("data",testId);
        return map;
    }


    /**
     * 拿到老师发布的考试，用于查看学生成绩
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/getTestInfo",method = RequestMethod.GET)
    public String getTestInfo(Model model , HttpServletRequest request){

        String session = (String) request.getSession().getAttribute("loginUser");
        List<TestPaper> list = teacherService.getTest(session);
        model.addAttribute("list",list);

        return "/home/testInfoHome";
    }

    /**
     * 拿到老师发布的考试，用于分析题目正确情况
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/getQuestionInfo",method = RequestMethod.GET)
    public String getQuestionInfo(Model model , HttpServletRequest request){

        String session = (String) request.getSession().getAttribute("loginUser");
        List<TestPaper> list = teacherService.getTest(session);
        model.addAttribute("list",list);

        return "/home/testQuestionHome";
    }

    /**
     * 获取相应测试的学生成绩接口
     * @param testId
     * @return
     */
    @RequestMapping("/paperSore")
    @ResponseBody
    public Map<String , Object> paperSore(@RequestParam("testId") String testId,@RequestParam("page")int page , @RequestParam("limit")int limit){
        Map<String , Object> map = new ConcurrentHashMap<>();
        List<TestStudent> list1 = teacherService.getStud(testId,page,limit);
        PageInfo<TestStudent> pageInfo = new PageInfo<>(list1);
        List<StudentModel> list = new ArrayList<>();

        if(list1.size() == 0){
            map.put("code",2);
            map.put("msg","暂无数据");
            map.put("count",0);
            map.put("data","");
            return map;
        }
        for (TestStudent testStudent : list1) {
            StudentModel student = new StudentModel();
            Student stu = teacherService.getStu(testStudent.getStuId());
            student.setName(stu.getName());
            student.setSex(stu.getSex());
            student.setPhone(stu.getPhone());
            student.setClaName(stu.getClaName());
            student.setUser(stu.getUser());
            student.setFraction(testStudent.getFraction());
            list.add(student);
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",list);
        return map;
    }

    /**
     * 查看题目解答情况(包括提交人数以及正确解答人数)
     * @param testId
     * @param request
     * @return
     */
    @RequestMapping("/listQue")
    @ResponseBody
    public Map<String , Object> listQue(@RequestParam("testId") String testId , HttpServletRequest request,@RequestParam("page")int page , @RequestParam("limit") int limit){
        Map<String , Object> map = new ConcurrentHashMap<>();

        List<KuXuanze> list = teacherService.xuanList(testId,page,limit);
        PageInfo<KuXuanze> pageInfo = new PageInfo<>(list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",list);
        return map;
    }


    /**
     * 获得题目的正确率情况
     * @param request
     * @return
     */
    @RequestMapping(value = "/topicAnaly",method = RequestMethod.GET)
    @ResponseBody
    public Map<String , Object> topicAnaly(HttpServletRequest request,@RequestParam("page") int page , @RequestParam("limit") int limit){
        Map<String , Object> map = new ConcurrentHashMap<>();
        String session = (String) request.getSession().getAttribute("loginUser");

        List<TopicAnalysis> list = new ArrayList<>();
        List<TestPaper> papaerList = teacherService.getTest(session);

        for (TestPaper paper : papaerList) {
            String testId = paper.getTestId();
            List<KuXuanze> xuanzeList = teacherService.xuanList(testId,page,limit);

            for (KuXuanze kuXuanze : xuanzeList) {
                TopicAnalysis topicAnalysis = new TopicAnalysis();
                Integer id = kuXuanze.getId();
                XuanzeAnalysis xuanzeAnalysis = teacherService.getXuanzeRate(id);
                if(xuanzeAnalysis != null){
                    topicAnalysis.setCorrectRate(xuanzeAnalysis.getCorrectRate());
                }else {
                    topicAnalysis.setCorrectRate("100.00%");
                }
                topicAnalysis.setId(id);
                topicAnalysis.setPerson(kuXuanze.getPerson());
                topicAnalysis.setProject(kuXuanze.getProject());
                topicAnalysis.setRig(kuXuanze.getRig());
                topicAnalysis.setTopic(kuXuanze.getTopic());
                topicAnalysis.setType(kuXuanze.getTypes());
                topicAnalysis.setA(kuXuanze.getA());
                topicAnalysis.setB(kuXuanze.getB());
                topicAnalysis.setC(kuXuanze.getC());
                topicAnalysis.setD(kuXuanze.getD());
                topicAnalysis.setAnswer(kuXuanze.getAnswer());
                topicAnalysis.setDifficult(kuXuanze.getDifficult());
                topicAnalysis.setParsing(kuXuanze.getParsing());
                topicAnalysis.setFraction(kuXuanze.getFraction());
                list.add(topicAnalysis);
            }
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }

    /**
     * 教师批量录入学生接口
     * @param fileName
     * @return
     */
    @RequestMapping(value = "/batchInsert",method = RequestMethod.POST)
    @ResponseBody
    public Map<String , Object> batchInsert(@RequestParam("fileName") String fileName){
        Map<String , Object> map = new ConcurrentHashMap<>();
        int num = 0;
        File file = new File(fileName);
        ArrayList<ArrayList<Object>> result = ExcelUtil.readExcel(file);

        if (result == null) {
            map.put("msg","文件不存在：请检查路径是否正确！");
            map.put("code",2);
            return map;
        } else if (result.size() == 0) {
            map.put("msg","文件内容为空!");
            map.put("code",2);
            return map;
        } else {
            for (int i = 1 ; i < result.size(); i++) {

                String stuId = getId();
                String str1 = (String) result.get(i).get(1);
                String user = str1.substring(0,str1.length() - 3);
                String str2 = (String) result.get(i).get(2);
                String pwd = str2.substring(0,str2.length() - 3);
                String str3 = (String) result.get(i).get(3);
                String phone = str3.substring(0,str3.length() - 3);
                Student student = new Student();
                student.setStuId(stuId);
                student.setName(result.get(i).get(0).toString());
                student.setClaName(result.get(i).get(4).toString());
                student.setPhone(phone);
                student.setUser(user);
                student.setPwd(Md5Util.encrypByMd5Jar(pwd));
                num = teacherService.batchStudent(student);

            }
        }
        if(num == 0){
            map.put("code",2);
            map.put("msg","出现未知错误");
            return map;
        }
        map.put("code",0);
        map.put("msg","success");
        return map;
    }

    /**
     * 教师所教课程目录显示接口
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/homepage",method = RequestMethod.GET)
    public String homepage(Model model , HttpServletRequest request , @RequestParam("flag") int flag){

        //后端验证是否登录
        String session = (String) request.getSession().getAttribute("loginUser");
        if(session == null){
            model.addAttribute("msg","请先登录");
            return "/user/login";
        }

        List<ClassInfo> list = teacherService.getClassInfo(session);
        model.addAttribute("list",list);
        if(flag == 1){
            return "/home/homepage1";
        }else {
            return "/home/homepage2";
        }
    }

    /**
     * 删除课程接口
     * @param request
     * @param claId
     * @return
     */
    @RequestMapping(value = "/delcla",method = RequestMethod.POST)
    @ResponseBody
    public Map<String , Object> delcla(HttpServletRequest request , @RequestParam("claId") Integer claId){
        Map<String , Object> map = new ConcurrentHashMap<>();

        int num = teacherService.delCla(claId);
        if(num == 0){
            map.put("code",1);
            map.put("msg","删除失败");
            return map;
        }
        map.put("code",0);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * 添加课程接口
     * @param claName
     * @param claProject
     * @param request
     * @return
     */
    @RequestMapping("/addclass")
    @ResponseBody
    public Map<String , Object> addclass(@RequestParam("claName")String claName , @RequestParam("claProject")String claProject , HttpServletRequest request){
        Map<String , Object> map = new ConcurrentHashMap<>();
        String session = (String) request.getSession().getAttribute("loginUser");
        if(claProject == "" || claName == ""){
            map.put("code",1);
            map.put("msg","所填信息不能为空");
            return map;
        }
        int num = teacherService.addClass(session,claName,claProject);
        if(num == 0){
            map.put("code",1);
            map.put("msg","出现未知错误，添加失败");
            return map;
        }
        map.put("code",0);
        map.put("msg","添加成功");

        return map;
    }

    /**
     * 得到对应学生名单
     * @param claName
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/stuRoster")
    @ResponseBody
    public Map<String,Object> stuRoster(@RequestParam("claName")String claName,@RequestParam("page")int page,@RequestParam("limit")int limit){
        Map<String , Object> map = new ConcurrentHashMap<>();

        List<Student> list = teacherService.selsctByClaName(claName,page,limit);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        map.put("code",0);
        map.put("msg","success");
        map.put("data",list);
        map.put("count",pageInfo.getTotal());

        return map;
    }

}