package oop

/**
 * @author DSH
 * @date 2020/3/23
 * @description
 */
//
ExpandoMetaClass.enableGlobally()

def person = new Person(name:'Android',age:29)
//.name 调用的事getName()方法
println "the name is ${person.name}"+
        "the age is ${person.age}"
person.increaseAge(2)

//调用person中不存在的方法，编译时不会报错，运行时会异常
person.decrease()//Caught: groovy.lang.MissingMethodException
//重写了Person的invokeMethod方法之后,编译运行都不会出错
println person.decrease()//the method is decrease,the params is []
//如果重写了methodMissing方法，输出的是the method  decrease is missing

//为类动态的添加一个sex属性
Person.metaClass.sex = 'male'
def person2 = new Person(name:'Android',age:29)
println person2.sex//male
person2.sex = 'female'
println "the new sex is"+person2.sex//the new sex isfemale
//为类动态的添加方法
Person.metaClass.sexUpperCase = {_-> sex.toUpperCase()}
println person2.sexUpperCase()//FEMALE
//为类动态的添加静态方法
Person.metaClass.static.createPerson={
    String name,int age ->new Person(name:name,age:age)
}
def person3 = Person.createPerson('groovy',6)
println person3.name + " and " +person3.age//groovy and 6