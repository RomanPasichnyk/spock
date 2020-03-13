package com.example.spock

import com.example.spock.controller.UserController
import com.example.spock.model.User
import com.example.spock.service.UserService
import spock.lang.Specification
import spock.lang.Unroll

class UserControllerTest extends Specification {

    def userService = Mock(UserService)
    def userController = new UserController(userService)

    def "check find user by name - controller"() {
        given:
        def expectedUser = new User("Roman", 15)

        when:
        def actualUser = userController.findUserByName("Roman")

        then:
        1 * userService.findUserByName(_ as String) >> new User("Roman", 15)
        actualUser == expectedUser
        actualUser.getName() == expectedUser.getName()
    }

    def "check find user by range age - controller"() {
//        given:
//        List<User> expectedUsers = Arrays.asList(
//                new User("Roman", 15),
//                new User("Andrii", 18),
//                new User("Anna", 12)
//        )

        when:
        userController.findByUserRage(1, 1)

        then:
//        1*userService.findUserByAge(5, 20) >> null
        def exception = thrown(IllegalArgumentException)
        System.err.println(exception.class)
    }

    @Unroll("#featureName (#data)")
    def "check correct parameters"() {
        userController.findByUserRage(rageA as int, rageB as int)
        where:
        rageA << ["Test", 0, 8]
        rageB << [0, "Test", 20]
    }

}
