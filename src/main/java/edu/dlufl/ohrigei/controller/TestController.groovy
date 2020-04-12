package edu.dlufl.ohrigei.controller

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import edu.dlufl.ohrigei.util.Base64ToFile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class TestController {
    Base64ToFile base64ToFile = new Base64ToFile()

    @RequestMapping(value = "testUpload/upload", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    JSONObject testUpload(@RequestParam("imgData") String base64, HttpServletResponse response, HttpServletRequest request) {
        JSONObject status = base64ToFile.base64ToFile(base64, "paohui")
        return status
    }
    @RequestMapping("/testProfile")
    String testProfile(){
        return "allUser/testPersonalProfile"
    }

}
