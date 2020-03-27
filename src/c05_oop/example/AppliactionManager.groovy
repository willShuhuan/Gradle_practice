package c05_oop.example

import c05_oop.Person


/**
 * @author DSH
 * @date 2020/3/23
 * @description 模拟一个应用的管理类
 */
class AppliactionManager {
    static void init(){
        //一次注入拓展方法，全局都可以使用
        ExpandoMetaClass.enableGlobally()
        //为第三方类添加方法
        Person.metaClass.static.createPerson = {
            String name,int age ->
                new Person(name:name,age:age)
        }
    }
}
