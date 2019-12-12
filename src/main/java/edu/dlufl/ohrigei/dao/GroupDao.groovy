package edu.dlufl.ohrigei.dao

import edu.dlufl.ohrigei.model.Group

interface GroupDao {
    List<Group> selectAllGroup()
}