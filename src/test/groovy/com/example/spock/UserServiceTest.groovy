package com.example.spock

import com.example.spock.model.User
import com.example.spock.repository.UserRepository
import com.example.spock.service.impl.UserServiceImpl
import spock.lang.FailsWith
import spock.lang.Specification
import spock.lang.Unroll

class UserServiceTest extends Specification {
    def userRepository = Mock(UserRepository)
    def userService = new UserServiceImpl(userRepository)

    def "check method find by name - service"() {
        given:
        userRepository.findUserByName("Roman") >> new User("Roman", 15)
        def expectedUser = new User("Roman change in service", 15)

        when:
        def actualUser = userService.findUserByName("Roman")

        then:
        expectedUser == actualUser
        1 * userRepository.findUserByName(_) >> new User("Roman", 15)
    }

    def "check method find by age in some range - service"() {
        given:
        def expectedUsers = Arrays.asList(
                new User("Roman", 15),
                new User("Andrii", 18),
                new User("Anna", 12)
        )

        when:
        def actualUsers = userService.findUserByAge(5, 20)

        then:
        1 * userRepository.findUserByAge(5, 20) >> expectedUsers
        expectedUsers == actualUsers

    }


    @FailsWith(MissingMethodException)
    @Unroll
    def "check correct type"() {
        userService.findUserByAge(rageA as int, rageB as int)
        where:
        rageA << ["Test", 0, 8]
        rageB << [0, "Test", 20]

    }

}
