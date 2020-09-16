package com.qcby.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.qcby.entity.Student;
import com.qcby.entity.Teacher;
import com.qcby.service.StudentService;
import com.qcby.service.TeacherService;
import com.qcby.util.Md5Util;
import com.qcby.util.SendSms;
import com.qcby.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

    //全局变量，用于判断验证码
    private String getYzm = "yzm";

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    /**
     * 学生、教师登录接口
     * @param occupation
     * @param username
     * @param password
     * @param vercode
     * @param request
     * @return
     */
    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    @ResponseBody
    public Map<String , Object> login(@RequestParam("occupation") String occupation,@RequestParam("username") String username, @RequestParam("password") String password , @RequestParam("vercode") String vercode ,  HttpServletRequest request){

        String code = (String) WebUtils.getHttpSession().getAttribute("code");

        Map<String , Object> map = new ConcurrentHashMap<>();
        Map<String , Object> map1 = new ConcurrentHashMap<>();

        if(!code.equals(vercode)){
            map.put("code",1);
            map.put("msg","验证码错误");
            return map;
        }

        Student student = null;
        Teacher teacher = null;
        if(occupation.equals("学生")){
            student = studentService.selectByUserNameAndPassword(username);
            if(student == null){
                map.put("code", 1);
                map.put("msg", "用户不存在");
                map1.put("token", null);
                map.put("data", map1);
                return map;
            }else{
                String pwdFromDb = student.getPwd();
                String MD5pwd = Md5Util.encrypByMd5Jar(password);
                if(!MD5pwd.equals(pwdFromDb)){
                    map.put("code", 1);
                    map.put("msg", "密码错误");
                    map1.put("token", null);
                    map.put("data", map1);
                    return map;
                }
                String session = student.getStuId();

                map.put("code", 0);
                map.put("msg", "登录成功");
                map1.put("token", session);
                map.put("data", map1);
                map.put("occupation",occupation);

                request.getSession().setAttribute("loginUser",session);
                return map;
            }
        }else{
            teacher = teacherService.selectByUserNameAndPassword(username);
            if(teacher == null){
                map.put("code", 1);
                map.put("msg", "用户不存在");
                map1.put("token", null);
                map.put("data", map1);
                return map;
            }else{
                String pwdFromDb = teacher.getTeacPwd();
                String MD5pwd = Md5Util.encrypByMd5Jar(password);
                if(!MD5pwd.equals(pwdFromDb)){
                    map.put("code", 1);
                    map.put("msg", "密码错误");
                    map1.put("token", null);
                    map.put("data", map1);
                    return map;
                }
                String session = teacher.getTeacId();
                map.put("code", 0);
                map.put("msg", "登录成功");
                map1.put("token", session);
                map.put("data", map1);
                map.put("occupation",occupation);

                request.getSession().setAttribute("loginUser",session);
                return map;
            }
        }
    }

    /**
     * 用户退出接口
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginout",method = RequestMethod.POST)
    @ResponseBody
    public Map<String , Object> loginout(HttpServletRequest request){
        Map<String , Object> map = new ConcurrentHashMap<>();

        request.getSession().setAttribute("loginUser",null);
        map.put("msg","成功退出");
        map.put("code",0);
        return map;

    }

    /**
     * 图片验证码生成接口
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 33,4,30);
        //图形验证码写输出到浏览器
        lineCaptcha.write(response.getOutputStream());
        session.setAttribute("code",lineCaptcha.getCode());

    }

    /**
     * 指定手机号发验证码
     * @param cellphone
     * @return
     */
    @RequestMapping(value = "/sendNumber", method = RequestMethod.POST)
    @ResponseBody
    private Map<String , Object> sendNumber( @RequestParam("cellphone") String cellphone) {
        Map<String , Object> map = new ConcurrentHashMap<>();

        //正则表达式，用于判断手机是否只含有数字
        Pattern pattern = Pattern.compile("[0-9]*");
        if(cellphone.length()!= 11 || pattern.matcher(cellphone).matches() == false){
            map.put("msg","手机号类型错误");
            map.put("code",2);
            return map;
        }

        try {
            String phoneYzm = SendSms.sendsms(cellphone);
            getYzm = phoneYzm;
            map.put("msg","验证码已发送至手机");
            map.put("code",0);
        } catch (Exception e) {
            map.put("msg","发送失败");
            map.put("code",1);
        }
        return map;
    }

    /**
     * 教师注册接口
     * @param nickname
     * @param password
     * @return
     */
    @RequestMapping(value = "register" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String , Object> register(@RequestParam("nickname") String nickname , @RequestParam("user") String user ,@RequestParam("password") String password ,
                                         @RequestParam("cellphone") String cellphone , @RequestParam("vercode") String vercode){
        Map<String , Object> map = new ConcurrentHashMap<>();

        Teacher example = teacherService.selectByUserNameAndPassword(nickname);
        if(example != null){

            map.put("code", 2);
            map.put("msg", "用户已存在，请重新注册");
            map.put("data", 2);
            return map;
        }
        if(!getYzm.equals(vercode)){
            map.put("coed",2);
            map.put("msg","验证码有误");
            return map;
        }

        String userId = getId();
        Teacher teacher = new Teacher();
        teacher.setUser(user);
        teacher.setTeacName(nickname);
        teacher.setTeacPwd(Md5Util.encrypByMd5Jar(password));
        teacher.setTeacId(userId);
        teacher.setUserPhone(cellphone);

        int num = teacherService.insertTeac(teacher);
        map.put("code", 0);
        map.put("msg", "注册成功");
        map.put("data", 1);

        return map;
    }

    /**
     * 学生录入接口
     * @param nickname
     * @param password
     * @return
     */
    @RequestMapping(value = "registerStudent" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String , Object> registerStudent(@RequestParam("user") String user ,@RequestParam("nickname") String nickname ,
                                            @RequestParam("claName") String claName ,@RequestParam("password") String password){

        Map<String , Object> map = new ConcurrentHashMap<>();

        Student example = studentService.selectByUserNameAndPassword(user);
        if(example != null){
            map.put("code", 2);
            map.put("msg", "用户已存在，请重新注册");
            map.put("data", 2);
            return map;
        }

        String userId = getId();
        Student student = new Student();
        student.setUser(user);
        student.setClaName(claName);
        student.setName(nickname);
        student.setPwd(Md5Util.encrypByMd5Jar(password));
        student.setStuId(userId);

        int stu = studentService.insertStu(student);
        map.put("code", 0);
        map.put("msg", "录入成功");
        map.put("data", 1);
        return map;
    }

    /**
     * 找回密码接口实现
     * @param user
     * @param cellphone
     * @param vercode
     * @return
     */
    @RequestMapping(value = "/recoverPwd",method = RequestMethod.POST)
    @ResponseBody
    public Map<String , Object> recoverPwd(@RequestParam("occupation") String occupation , @RequestParam("user") String user , @RequestParam("cellphone") String cellphone , @RequestParam("vercode") String vercode){
        Map<String , Object> map = new HashMap<String , Object>();

        //正则表达式，用于判断手机是否只含有数字
        Pattern pattern = Pattern.compile("[0-9]*");
        if(cellphone.length()!= 11 || pattern.matcher(cellphone).matches() == false){
            map.put("msg","手机号类型错误");
            map.put("code",2);
            return map;
        }

        //对新密码进行MD5加密
        String newpwd = Md5Util.encrypByMd5Jar(getYzm);

        if("学生".equals(occupation)){
            Student student = studentService.selectByUserNameAndPassword(user);
            if(student == null){
                map.put("msg","用户未注册");
                map.put("code",2);
                return map;
            }
            int num = studentService.updataPwd(user,newpwd);
            map.put("msg" , "密码找回成功");
            map.put("code" , 0);
            map.put("data",getYzm);
        }else {
            Teacher teacher = teacherService.selectByUserNameAndPassword(user);
            if(teacher == null){
                map.put("msg","用户未注册");
                map.put("code",2);
                return map;
            }
            int num = teacherService.updataPwd(user,newpwd);
            map.put("msg" , "密码找回成功");
            map.put("code" , 0);
            map.put("data",getYzm);
        }

        return map;
    }

    /**
     * 修改密码接口
     * @param model
     * @param password
     * @param occupation
     * @param repass
     * @param request
     * @return
     */
    @RequestMapping(value = "/repass",method = RequestMethod.POST)
    public String repass(Model model, @RequestParam("pwd") String pwd , @RequestParam("password") String password , @RequestParam("occupation") String occupation , @RequestParam("repass") String repass , HttpServletRequest request) {

        //验证是否登录
        String session = (String) request.getSession().getAttribute("loginUser");
        if(session == null){
            model.addAttribute("msg","请先登录");
            return "/user/login";
        }
        if(!pwd.equals(repass)){
            model.addAttribute("msg","两次输入密码不一致,请重新登录");
            return "/set/user/password";
        }

        //对新密码进行MD5加密
        String newpwd = Md5Util.encrypByMd5Jar(repass);
        //旧密码判断
        String oldpwd = Md5Util.encrypByMd5Jar(password);
        if("学生".equals(occupation)){
            Student student = studentService.selsctById(session);
            if(!oldpwd.equals(student.getPwd())){
                model.addAttribute("msg","原密码错误，请重新输入");
                return "/set/user/password";
            }
            int isStu = studentService.repass(session,newpwd);
        }else {
            Teacher teacher = teacherService.selsctById(session);
            if(!oldpwd.equals(teacher.getTeacPwd())){
                model.addAttribute("msg","原密码错误，请重新输入");
                return "/set/user/password";
            }
            int isTeac = teacherService.repass(session,newpwd);
        }
        model.addAttribute("msg","密码修改成功，请重新登录");
        return "/user/login";
    }

    /**
     * 资料显示接口
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/infomt",method = RequestMethod.GET)
    public String infomt(Model model , HttpServletRequest request){

        //后端验证是否登录
        String session = (String) request.getSession().getAttribute("loginUser");
        if(session == null){
            model.addAttribute("msg","请先登录");
            return "/user/login";
        }
        Teacher teacher = teacherService.selsctById(session);
        if(teacher == null){
            Student student = studentService.selsctById(session);
            model.addAttribute("user",student);
            model.addAttribute("role","学生");
            return "/set/user/stuInfo";
        }
        model.addAttribute("user",teacher);
        model.addAttribute("role","教师");

        return "/set/user/teaInfo";
    }

    /**
     * 修改信息接口
     * @param role
     * @param nickname
     * @param sex
     * @param cellphone
     * @return
     */
    @RequestMapping("/updataInfo")
    @ResponseBody
    public Map<String , Object> updataInfo(@RequestParam("role") String role,@RequestParam("nickname") String nickname , @RequestParam("sex") String sex , @RequestParam("cellphone") String cellphone , @RequestParam(value = "cla_name" , required = false) String claName ,HttpServletRequest request){
        Map<String , Object> map = new HashMap<>();
        //正则表达式，用于判断手机是否只含有数字
        Pattern pattern = Pattern.compile("[0-9]*");
        if(cellphone.length()!= 11 || pattern.matcher(cellphone).matches() == false){
            map.put("msg","手机号类型错误");
            map.put("code",2);
            return map;
        }
        if((!"男".equals(sex)) && (!"女".equals(sex))){
            map.put("msg","请输入男或女");
            map.put("code",2);
            return map;
        }
        String session = (String) request.getSession().getAttribute("loginUser");
        if("学生".equals(role)){
            int num = studentService.updataInfo(session ,nickname , sex , cellphone , claName);
            if(num == 1){
                map.put("code" , 0);
                map.put("msg" , "success");
                return map;
            }else {
                map.put("code" , 2);
                map.put("msg" , "error");
                return map;
            }
        }else {
            int flag = teacherService.updataInfo(session,nickname,sex,cellphone);
            if(flag == 1){
                map.put("code" , 0);
                map.put("msg" , "success");
                return map;
            }else {
                map.put("code" , 2);
                map.put("msg" , "error");
                return map;
            }
        }
    }


}