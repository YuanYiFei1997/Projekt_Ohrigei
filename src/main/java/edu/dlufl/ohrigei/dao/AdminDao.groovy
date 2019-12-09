package edu.dlufl.ohrigei.dao

import edu.dlufl.ohrigei.model.Admin
import edu.dlufl.ohrigei.model.Committee
import edu.dlufl.ohrigei.model.Delegate
import edu.dlufl.ohrigei.model.Group

interface AdminDao {
    List<Delegate> queryAllDelegate()

    List<Delegate> queryAllObserver()

    List<Delegate> queryAllLeader()

    List<Delegate> queryAllTeacher()

    List<Group> queryAllGroup()

    List<Admin> queryAllAdmin()

    List<Committee> queryAllCommittee()
}