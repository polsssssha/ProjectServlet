package com.devcolibri.app.db;

import com.devcolibri.app.model.UserModel;
import java.util.List;

public interface UsersDAO {
    UserModel get(long id);
    List<UserModel> getAll() ;
    void add(UserModel dataSet);
}