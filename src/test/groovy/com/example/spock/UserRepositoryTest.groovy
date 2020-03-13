package com.example.spock

import com.example.spock.model.User
import com.example.spock.repository.impl.UserRepositoryImpl
import spock.lang.Specification

class UserRepositoryTest extends Specification {
    UserRepositoryImpl userRepository = new UserRepositoryImpl()

    def "check find by name method"() {
        given:
        def expectedUser = new User("Roman", 15)


        when:
        def actualUser  = userRepository.findUserByName("Roman")

        then:
        actualUser == expectedUser
    }

    def "check user if he is absent from list"() {
        given:
        def expectedUser = null


        when:
        def actualUser  = userRepository.findUserByName("Test")

        then:
        actualUser == expectedUser
    }



}
