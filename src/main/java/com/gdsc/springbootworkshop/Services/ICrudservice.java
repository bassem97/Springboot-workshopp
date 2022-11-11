package com.gdsc.springbootworkshop.Services;

import java.util.List;

public interface ICrudservice<Class,TypeId> {

    List<Class> getAll();
    Class add(Class class1) throws Exception;
    Class update(TypeId typeId,Class class1) throws Exception;
    void delete(TypeId typeId);


}
