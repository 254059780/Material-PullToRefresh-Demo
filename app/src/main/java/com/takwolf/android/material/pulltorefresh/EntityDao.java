package com.takwolf.android.material.pulltorefresh;


import java.util.ArrayList;
import java.util.List;

public class EntityDao {

    public static List<Entity> getEntityList() {
        List<Entity> entityList = new ArrayList<>();
        for (int n = 0; n < Resource.names.length; n++) {
            Entity entity = new Entity();
            entity.setAvatar(Resource.avatars[n]);
            entity.setNickname(Resource.names[n]);
            entityList.add(entity);
        }
        return entityList;
    }

}
