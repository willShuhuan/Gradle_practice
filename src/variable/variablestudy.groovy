package variable

/**
 * @author DSH
 * @date 2020/3/21
 * @description groovy变量学习
 */
//不管声明基本类型还是对象类型，groovy所有类型都是对象类型
int x = 10;
println x.class //class java.lang.Integer
double y = 3.14
println y.class //class java.lang.Double

//def 弱类型定义
//如果变量不会被外部使用，使用def声明，如果要被外部使用，定义为java方式强类型
def x_1 = 11
println(x_1.class)//class java.lang.Integer
def y_1 = 3.1415
println(y_1.class)//class java.math.BigDecimal
def name = "Android"
println(name.class)//class java.lang.String

// 使用def定义的类型是可变类型的，动态类型
x_1 = 'Test'
println(x_1.class)//class java.lang.String