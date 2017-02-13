package com.heyang.pic;

import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by dr on 2017/2/13.
 */
@Controller
public class GenPicController {


    @RequestMapping("/genPic")
    public String genPic(ModelMap model){

        PythonInterpreter interpreter=new PythonInterpreter();

        /**文件名放到后面的括号**/
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("hello.py");

        interpreter.execfile(resourceAsStream);

        /**把url 放到后面的那个值**/
        model.addAttribute("url","http://www.baidu.com/img/bd_logo1.png");

        return "img";
    }
}
