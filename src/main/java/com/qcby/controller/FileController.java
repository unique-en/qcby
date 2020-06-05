package com.qcby.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileController {

    /**
     * 上传
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/upload" , method = RequestMethod.POST)
    //@ResponseBody
    public String upload(Model model, MultipartFile file, HttpServletRequest request) throws IOException {
        //验证登录：33-38行代码
        String session = (String) request.getSession().getAttribute("loginUser");
        if(session == null){
            model.addAttribute("msg","请先登录");
            return "/user/login";
        }

        //开始上传
        String fileName = file.getOriginalFilename();
//        String path = "E://图片//" + fileName; //创建文件夹
        String path = "E://testSystem//";
        System.out.println(path);
        System.out.println(fileName);
        model.addAttribute("msg",fileName);

        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        file.transferTo(dir);
        model.addAttribute("info","上传成功,请录入");
        return "/user/regstu";
    }

    @RequestMapping(value="/list" , method = RequestMethod.GET)
    @ResponseBody
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception{

        //获取上传文件的目录
        String uploadFilePath = "E://testSystem//";
        //存储要下载的文件名
        Map<String,String> fileNameMap = new HashMap<String,String>();
        //递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
        //File既可以代表一个文件也可以代表一个目录
        listfile(new File(uploadFilePath),fileNameMap);
        //String jsonString = JSONObject.toJSONString(fileNameMap);
        JSONObject jsonObj=new JSONObject(fileNameMap);

        System.out.println(jsonObj);

        return jsonObj.toString();
    }


    /**
     * @Method: listfile
     * @Description: 递归遍历指定目录下的所有文件
     * @Anthor:hdb
     * @param file 即代表一个文件，也代表一个文件目录
     * @param map 存储文件名的Map集合
     */
    public void listfile(File file,Map<String,String> map){
        //如果file代表的不是一个文件，而是一个目录
        if(!file.isFile()){
            //列出该目录下的所有文件和目录
            File files[] = file.listFiles();
            //遍历files[]数组
            for(File f : files){
                //递归
                listfile(f,map);
            }
        }else{
            /**
             * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的uuid_部分
             file.getName().indexOf("_")检索字符串中第一次出现"_"字符的位置，如果文件名类似于：9349249849-88343-8344_阿_凡_达.avi
             那么file.getName().substring(file.getName().indexOf("_")+1)处理之后就可以得到阿_凡_达.avi部分
             */
            String realName = file.getName().substring(file.getName().indexOf("_")+1);
            //file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
            map.put(file.getName(), realName);
        }
    }

    /**
     * 下载
     * @param request
     * @param response
     * @param name
     * @throws Exception
     */
    @RequestMapping(value="/down" , method = RequestMethod.GET)
    @ResponseBody
    public void down(HttpServletRequest request, HttpServletResponse response , String name) throws Exception{
        //这里是要下载的文件名称
        String outFileName = name;

        //这里是本地要下载文件的存储路径
        String filePath="E://testSystem//" + outFileName;

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        ServletOutputStream out = null;
        PrintWriter pw = null;
        FileInputStream fis = null;
        fis = new FileInputStream(filePath);
        response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(outFileName,"UTF-8"));
        out = response.getOutputStream();
        bis = new BufferedInputStream(fis);
        bos = new BufferedOutputStream(out);
        byte[] buff = new byte[2048];
        int len = 0;
        while((len=bis.read(buff))!=-1){
            bos.write(buff,0,len);
        }
        bos.flush();
        out.flush();
    }
}
