package oop

/**
 * @author DSH
 * @date 2020/3/23
 * @description
 * 像是接口和抽象类的结合
 */
trait DefaultAction {
    abstract void eat()

    void play(){
        println 'i can play'
    }
}