package com.example.spock

import com.example.spock.model.User
import com.example.spock.repository.UserRepository
import com.example.spock.service.impl.UserServiceImpl
import spock.lang.Specification

class UserServiceTest extends Specification {
    def userRepository = Mock(UserRepository)
    def userService = new UserServiceImpl(userRepository)

    def "check method find by name"() {
        given:
        userRepository.findUserByName("Roman") >> new User("Roman", 15)
        def expectedUser = new User("Roman change in service", 15)

        when:
        def actualUser = userService.findUserByName("Roman")

        then:
        expectedUser == actualUser
        1 * userRepository.findUserByName(_) >> new User("Roman", 15)
    }

//    @Unroll("#name should have length #length")
//    def "name length"() {
//        expect:
//        name.size() == length
//
//        where:
//        name << ["Kirk", "Spock", "Scotty"]
//        length << [4, 5, 6]
//    }
}
