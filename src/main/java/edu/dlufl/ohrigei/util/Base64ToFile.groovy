package edu.dlufl.ohrigei.util

import com.alibaba.fastjson.JSONObject
import edu.dlufl.ohrigei.dao.AdminDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Base64ToFile {

    static AdminDao adminDao

    static AdminDao getAdminDao() {
        return adminDao
    }
    @Autowired
    void setAdminDao(AdminDao adminDao) {
        Base64ToFile.adminDao = adminDao
    }

    static JSONObject base64ToFile(String base64, int id) {
        String userName = adminDao.getNameByID(id)
        JSONObject object = new JSONObject()
        try {
            String[] splitBase64 = base64.split(',')
            byte[] decoder = Base64.getDecoder().decode(splitBase64[1])
            String filePath = "E:\\picture"
            String timeStamp = UtilSet.getCurrentTime().replace(":","-")
            String filename = userName + timeStamp
            adminDao.addImgPath(id, "../" + filename + ".jpg")
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath + "\\" + filename + ".jpg"))
            fileOutputStream.write(decoder)
            fileOutputStream.flush()
            fileOutputStream.close()
            object.put("status", "SUCCESS")
            return object
        }
        catch (Exception ignored) {
            object.put("status", "ERROR")
            return object
        }
    }
}
