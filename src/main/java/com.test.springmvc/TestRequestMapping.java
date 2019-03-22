package com.test.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

//@SessionAttributes(value="user",types={String.class})
@RequestMapping("/springmvc")
@Controller()
public class TestRequestMapping {
    private static final String SUCCESS = "success";

    /**
     * 1. @RequestMapping 除了修饰方法, 还可以用来修饰类
     * 2.
     *   1). 类定义处 : 提供初步的请求映射信息, 相对于 WEB 应用的根目录
     *   2). 方法处 : 提供进一步的细分映射信息。
     *               相对于类定义处的 URL, 若类定义出未标注 @RequestMapping 则方法处标记的 URL
     *               相当于 WEB 的根目录
     * @return
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }

    /**
     * 支持通配符 *
     * @return
     */
    @RequestMapping("/testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }

    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("testPathVariable--"+id);
        return  SUCCESS;
    }

    @RequestMapping(value="/testRest/{id}",method=RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println("testRest PUT:"+ id);
        return SUCCESS;
    }

    @RequestMapping(value="/testRest/{id}",method = RequestMethod.DELETE)
    public String testRestDelte(@PathVariable Integer id){
        System.out.println("testRestDelte--"+id);
        return  SUCCESS;
    }

    /**
     * @RequestParam 来映射请求参数
     * value 值即请求参数的参数名
     * required 该参数是否必须, 默认为 true
     * defaultValue 请求参数的默认值
     */
    @RequestMapping(value="/testRequestParam")
    public String testRequestParam(@RequestParam(value="username") String user,
                                   @RequestParam(value="age",required=false, defaultValue="0") int age) {
        System.out.println("testRequestParam"+user+"-"+age);
        return SUCCESS;
    }

    @RequestMapping(value="/testPoJo")
    public String testPoJo(User user) {
        System.out.println("testPoJo"+user);
        return SUCCESS;
    }

    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request,
                               HttpServletResponse response, Writer out) throws IOException {
        System.out.println("testServlet API"+ request+response);
        out.write("hello Servlet API");
        /*return SUCCESS;*/
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);

        //添加模型数据到 ModelAndView 中
        modelAndView.addObject("time", Calendar.getInstance().getTime());

        return modelAndView;
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("names", Arrays.asList("a","b"));
        return SUCCESS;
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String,Object> map) {
        User user = new User("anqi",12,"5161@qq.com");
        map.put("user", user);
        map.put("school", "千峰");
        return SUCCESS;
    }

    @ModelAttribute
    public void getUser(@RequestParam(value="id",required=false) Integer id,
                        Map<String, Object> map) {
        if(id != null) {
            //模拟从数据库获取某个对象
            User user = new User(id, "Tom", 15, "5161@qq.com");
            System.out.println("从数据库中获取一个对象 " + user);

            map.put("user", user);
        }
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("修改:"+user);
        return SUCCESS;
    }


}
