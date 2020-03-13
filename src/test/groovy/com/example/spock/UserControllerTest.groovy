package com.example.spock

import com.example.spock.controller.UserController
import com.example.spock.model.User
import com.example.spock.service.UserService
import spock.lang.Specification;

class UserControllerTest extends Specification {

    def userService = Mock(UserService)
    def userController = new UserController(userService)

    def "check controller"() {
        given:
        def expectedUser = new User("Roman", 15);

        when:
        def actualUser = userController.findUserByName("Roman")

        then:
        1 * userService.findUserByName(_ as String) >> new User("Roman", 15)
        actualUser == expectedUser
        actualUser.getName() == expectedUser.getName()
    }
}
