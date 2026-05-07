package com.hostela.userlogin.servicetest;


import com.hostela.userlogin.dao.UserRepository;
import com.hostela.userlogin.dto.UserRequestDto;
import com.hostela.userlogin.jpamodel.User;
import com.hostela.userlogin.service.UserService;
import com.hostela.userlogin.service.impl.UserServiceImpl;
import com.hostela.userlogin.util.UserUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.InvocationTargetException;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    public UserServiceImpl userService;
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    UserUtil userUtil;

    @Mock
    public UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @BeforeAll
    public static void prepareUserObject(){
//        UserRequestDto urdto = new UserRequestDto();
//        urdto.setUserid(1);
//        urdto.setPassword("mahesh");
//        urdto.setGmail("gangamahesh129@gmail.com");
//        urdto.setFName("ganga");
//        urdto.setLName("mahesh");
//        urdto.setPhoneNumber("9347870213");
//        urdto.setProfilePicture("");
    }
    @Test
     void saveUserTest() throws InvocationTargetException, IllegalAccessException {

        User user = new User();
        user.setUserid(1);
        user.setPassword("mahesh");
        user.setGmail("gangamahesh129@gmail.com");
        user.setFName("ganga");
        user.setLName("mahesh");
        user.setPhoneNumber("9347870213");
        user.setProfilePicture("");
        UserRequestDto userRequestDto=new UserRequestDto();

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
       BeanUtils.copyProperties(userRequestDto,user);
        userRequestDto.setUserid(0);

         userRequestDto = userService.saveUser(userRequestDto);

        Assertions.assertEquals(userRequestDto.getUserid(), user.getUserid());
        Assertions.assertEquals(userRequestDto.getPassword(), passwordEncoder.encode(user.getPassword()));
        Assertions.assertEquals(userRequestDto.getGmail(), user.getGmail());
        Assertions.assertEquals(userRequestDto.getPhoneNumber(), user.getPhoneNumber());
        Assertions.assertEquals(userRequestDto.getFName(), user.getFName());
        Assertions.assertEquals(userRequestDto.getLName(), user.getLName());

        Mockito.verify(userRepository, Mockito.times(1)).save( Mockito.any(User.class));




    }
}
