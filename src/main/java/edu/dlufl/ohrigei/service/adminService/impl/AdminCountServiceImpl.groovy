package edu.dlufl.ohrigei.service.adminService.impl

import edu.dlufl.ohrigei.dao.AdminDao
import edu.dlufl.ohrigei.model.Post
import edu.dlufl.ohrigei.service.adminService.service.AdminCountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.ui.Model

import javax.servlet.http.HttpSession

@Service("AdminCountService")
class AdminCountServiceImpl implements AdminCountService{
    @Autowired
    AdminDao adminDao
    String  countDelegate(Model model, HttpSession httpSession){
        HashMap<String,Integer>delegateMap=new HashMap<>()
        delegateMap.put("delegate",adminDao.countDelegate(1))
        delegateMap.put("observer",adminDao.countDelegate(2))
        delegateMap.put("teacher",adminDao.countDelegate(3))
        delegateMap.put("leader",adminDao.countDelegate(4))
        HashMap<String,Integer>infoMap=new HashMap<>()
        infoMap.put("application",adminDao.countDelegateWaitConfirm())
        infoMap.put("seat",adminDao.countSeatSelectWaitConfirm())
        infoMap.put("bill",adminDao.countBillWaitConfirm())
        List<Post> postList=adminDao.getPost()
        model.addAttribute("countMap",delegateMap)
        model.addAttribute("infoMap",infoMap)
        model.addAttribute("postList",postList)
        return "admin/DashBoard"
    }
}
