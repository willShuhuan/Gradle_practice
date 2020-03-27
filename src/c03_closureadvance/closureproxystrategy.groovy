package c03_closureadvance

/**
 * @author DSH
 * @date 2020/3/23
 * @description 闭包的委托策略
 */
class Student{
    String name
    def pretty = {"My name is ${name}"}
    String toString(){
        pretty.call()
    }
}

class Teacher{
    String name
}

def stu = new Student(name:'Sarash')
def tea = new Teacher(name:'Android')
println stu.toString()//my name is Sarash
stu.pretty.delegate = tea
println stu.toString()//my name is Sarash
//指定resolveStrategy为DELEGATE_FIRST，从delegate对象优先寻找属性和方法
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST
println stu.toString()//My name is Android