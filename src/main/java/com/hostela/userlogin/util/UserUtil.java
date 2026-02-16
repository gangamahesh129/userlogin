package com.hostela.userlogin.util;


import com.hostela.userlogin.dto.UserDto;
import com.hostela.userlogin.jpamodel.User;
import org.apache.commons.beanutils.BeanUtils;

public class UserUtil {

    public static User convertUserToUserJpaModel(UserDto user) {
        User userJpaModel = new User();
        try {
            BeanUtils.copyProperties(userJpaModel, user);
        } catch (Exception e) {
            throw new RuntimeException("Error copying properties", e);
        }
        return userJpaModel;
    }

    public static UserDto convertUserJpaModelToUser(User userJpaModel) {
          UserDto userDetails = new UserDto();
        try {
            BeanUtils.copyProperties(userDetails, userJpaModel);
        } catch (Exception e) {
            throw new RuntimeException("Error copying properties", e);
        }
        return userDetails;
    }
}
