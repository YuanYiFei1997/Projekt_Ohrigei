package edu.dlufl.ohrigei.dao

import edu.dlufl.ohrigei.model.*

interface AdminDao {
    List<Delegate> queryAllMember(int type)

    List<Group> queryAllGroup()

    List<Admin> queryAllAdmin()

    List<Committee> queryAllCommittee()

    List<Admin> queryAdminIDAndName()

    int addAdminStep1(Admin admin)

    int addAdminStep2(Admin admin)

    int getInsertID(String email)

    String emailCheck(String email)

    Admin adminDetail(int id)

    int countDelegate(int roleId)

    List<School> queryAllSchool()

    List<Delegate> queryMemberAbleToUse()

    int addGroup(int schoolID, Integer headDelegateID, int size)

    Group queryGroupById(String id)

    List<Delegate> queryDelegateByGroupId(int groupID)

    int modifyGroup(int schoolID, Integer headDelegateID, int size, int groupID)

    int deleteGroup(int groupID)

    Delegate queryMemberById(int id)

    int modifyLoginStatusById(int userID, boolean loginStatus)

    List<SchoolType> queryAllSchoolType()

    int addSchool(String schoolName, String schoolNameEN, String schoolAddress, int schoolTypeID, int schoolSize)

    int addCommittee(String committeeName, int seatWidth, int chairmanID)

    List<Committee> queryCommitteeIDAndName()

    int addSeat(String seatName, int committeeID, int seatDifficulty)

    int countSeatByCommitteeID(int committeeID)

    int committeeWidthSizeGet(int committeeID)

    List<Seat> queryAllSeat()

    List<ApplicationStatus> queryAllApplicationStatus()

    int modifyApplicationStatus(int id, int applicationID)

    List<Admin> queryAdminCanInterview()

    List<Delegate> queryDelegate()

    int addInterview(int delegateID, int adminID, Date interviewDate)

    List<Interview> queryAllInterview()

    List<Interview> queryInterviewUndone(boolean interviewStatus)

    List<Interview> queryInterviewAssignToMe(int id)

    List<Interview> queryInterviewAssignToMeDoneOrUndone(int id, boolean interviewStatus)

    String getNameByID(int id)

    Interview queryInterviewByID(int id)

    int modifyInterviewScore(int id, int academicScore, int passionScore, float totalScore)

    int modifyInterviewDate(int id, String newDate)

    int modifyInterviewStatus(int id, boolean interviewStatus)

    int modifyUserStatus(int id, int statusID)

    int modifyInterviewComment(int id, String comment)

    int creatBillCheck(int id)

    int creatNewBill(int id, int typeID, String date, boolean billStatus)

    int getRoleIDByID(int id)

    List<Bill> queryAllBillList()

    List<Bill> queryBillList(Boolean billStatus)

    Bill queryBillDetail(int id)

    int confirmBill(int id)

    List<Seat> allSeatWaitProcess()

    int seatSelectConfirm(int seatID)

    int updateUserApplicationStatus(int id, int statusID)

    int deleteGroupIDFromDelegate(int groupID)

    int countSeatSelectWaitConfirm()

    int countDelegateWaitConfirm()

    int countBillWaitConfirm()

    int addPost(String post)

    List<Post> getPost()

    int deletePost(int id)

    List<Delegate> getGroupMember(int id)

    int removeDelegateFromGroup(int id)

    int addImgPath(int id,String path)

    List<Delegate> queryGroupLeaderList()
}