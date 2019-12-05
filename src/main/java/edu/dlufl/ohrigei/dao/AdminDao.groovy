package edu.dlufl.ohrigei.dao

import edu.dlufl.ohrigei.model.User

interface AdminDao {
    List<User> queryAllDelegate()
    List<User> queryAllObserver()
    List<User> queryAllLeader()
    List<User> queryAllTeacher()
}