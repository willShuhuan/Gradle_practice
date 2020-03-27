package c03_closureadvance

/**
 * @author DSH
 * @date 2020/3/23
 * @description
 */

/**
 * 闭包的三个重要变量: this,owner,delegate
 */
def scriptClosure= {
    //this 代表闭包定义处的类
    println "scriptClosure this:"+this//scriptClosure this:closureadvance.clousure1@d5b810e
    //代表闭包定义处的类或者对象
    println "scriptClosure owner:"+owner//scriptClosure owner:closureadvance.clousure1@d5b810e
    //代表任意对象，默认值与owner一直
    println "scriptClosure delegate:"+delegate//scriptClosure delegate:closureadvance.clousure1@d5b810e
}
scriptClosure.call()
println '-------------------'
//定义了一个内部类
class Person{
    def static classClosure = {
        println "classClosure this:"+this//
        println "classClosure owner:"+owner
        println "classClosure delegate:"+delegate//
    }

    def static say(){
        def  classClosure = {
            println "method classClosure this:"+this
            println "method classClosure owner:"+owner
            println "method classClosure delegate:"+delegate//
        }
        classClosure.call()
    }
}
Person.classClosure.call()//classClosure this/owner/delegate:class closureadvance.Person
Person.say()//method classClosure this/owner/delegat:class closureadvance.Person
//去掉static
//Person p = new Person();
//p.classClosure.call()//classClosure this:closureadvance.Person@4dbb42b7，指向了具体实例对象
//p.say()//method classClosure this:closureadvance.Person@4dbb42b7，指向了具体实例对象

println '-------------------'
//闭包中定义一个闭包
def nestClosure = {
    def innerClosure = {
        //这里的this表示clousure1的实例对象
        println "innerClosure this:"+this//classClosure this:closureadvance.clousure1@7c711375
        //在类中或者方法中定义闭包 ，this,owner.delegate是一致的，但是在闭包中定义闭包，那么三者值将不再一致，owner和delegate一致
        println "innerClosure owner:"+owner//classClosure owner:closureadvance.clousure1$_run_closure2@48aca48b
        println "innerClosure delegate:"+delegate//classClosure delegate:closureadvance.clousure1$_run_closure2@48aca48b
    }
    Person p = new Person();
    innerClosure.delegate = p//人为修改默认的delegate对象，输出innerClosure delegate:closureadvance.Person@272113c4，delegate和owner不再一致
    innerClosure.call()
}
nestClosure.call()