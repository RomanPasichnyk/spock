package com.example.spock

import com.example.spock.model.User
import com.example.spock.repository.impl.UserRepositoryImpl
import spock.lang.Specification

class UserRepositoryTest extends Specification {
    UserRepositoryImpl userRepository = new UserRepositoryImpl()

    def "check find by name method - repository"() {
        given:
        def expectedUser = new User("Roman", 15)

        when:
        def actualUser = userRepository.findUserByName("Roman")

        then:
        actualUser == expectedUser
    }

    def "check user if he is absent from list - repository"() {
        given:
        def expectedUser = null

        when:
        def actualUser = userRepository.findUserByName("Test")

        then:
        actualUser == expectedUser
    }

    def "check method find users by age in bad range"() {
        given:
        def expectedResult = []

        when:
        def actualResult = userRepository.findUserByAge(21312, 15273)

        then:
        expectedResult == actualResult
    }

    def "check method find users by age in good range"() {
        given:
        def expectedListUsers = Arrays.asList(
                new User("Roman", 15),
                new User("Andrii", 18),
                new User("Anna", 12)
        )

        when:
        def actualUsers = userRepository.findUserByAge(5, 20)

        then:
        actualUsers == expectedListUsers
    }

    def "check find users by age, string in parameters"() {



    }

}
