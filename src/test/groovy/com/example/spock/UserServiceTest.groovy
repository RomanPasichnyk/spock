package com.example.spock

import com.example.spock.model.User
import com.example.spock.repository.UserRepository
import com.example.spock.service.impl.UserServiceImpl
import spock.lang.Specification
import spock.lang.Unroll

class UserServiceTest extends Specification {

    def userRepository = Mock(UserRepository)
    def userService = new UserServiceImpl(userRepository)

    def "check method find by name"() {
        given:
        userRepository.findUserByName("Romana") >> new User("Romana", 15)
        def expectedUser = new User("Romana change in service", 15)

        when:
        def actualUser = userService.findUserByName("Romana")

        then:
        expectedUser == actualUser
        1 * userRepository.findUserByName(_) >> new User("Romana", 15)
    }
}
