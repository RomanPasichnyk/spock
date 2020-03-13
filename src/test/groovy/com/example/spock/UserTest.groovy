package com.example.spock

import com.example.spock.controller.UserController
import com.example.spock.model.User
import com.example.spock.service.UserService
import com.example.spock.service.impl.UserServiceImpl
import spock.lang.Specification

class UserTest extends Specification {
    UserService userService = Mock(UserService)
    UserController userController = new UserController(userService)
    UserController mockUserController = Mock(UserController)

    def "check call method in userService from userController"() {
        given:
        String name = "Roman"
        when:
        userController.findUserByName(name)
        then:
        1 * userService.findUserByName(name)
    }

    def "check user controller"() {
        given:
        String name = "Roman"
        mockUserController.findUserByName(_ as String) >> new User("Roman", 15)
        when:
        User user = mockUserController.findUserByName(name)
        then:
        user == new User("Roman", 15)
    }

    def 'check user changing name in service'() {
        given:
        def name = "test"
        def userService1 = Mock(UserServiceImpl)
        def sut = new UserController(userService1)

        when:
        def result = sut.doSomething(name)

        then:
        1 * userService1.doSomething(name) >> name + " Stub did something"
        result == name + ' Stub did something'
    }

}
