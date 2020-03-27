package c05_oop.example

import oop.Person

/**
 * @author DSH
 * @date 2020/3/23
 * @description Person管理器
 */
class PersonManager {
    static Person createPerson(String name,int age){
        return Person.createPerson(name,age)
    }
}
