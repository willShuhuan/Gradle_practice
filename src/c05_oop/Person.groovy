package c05_oop

/**
 * @author DSH
 * @date 2020/3/23
 * @description 面向对象
 * groovy中默认都是public
 */
//class Person implements DefaultAction
class Person implements Action{
    String name
    Integer age
    def increaseAge(Integer years){
        this.name += years
    }

    @Override
    void eat() {

    }

    @Override
    void drink() {

    }

    @Override
    void play() {

    }

    /**
     * 一个方法找不到时，调用它代替
     * @param name
     * @param args
     * @return
     */
    def invokeMethod(String name,Object args){
        return "the method is ${name},the params is ${args}"
    }

    def methodMissing(String name,Object args){
        return "the method  ${name} is missing"
    }

}
