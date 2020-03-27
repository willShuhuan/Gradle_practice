package c04_datastructure


/**
 * @author DSH
 * @date 2020/3/23
 * @description 映射
 */
//map定义
def colors = [red:'ff0000',
              gray:'00ff00',
              blue:'0000ff']
//索引方式
println colors['red']
println colors.red
//添加元素
colors.yellow = 'ffff00'
println colors.toMapString()//[red:ff0000, gray:00ff00, blue:0000ff, yellow:ffff00]
colors.leftShift(organe:'ff850d')
println colors
colors.complex = [a:1,b:2]//添加一个map进去，添加任意类型
println colors//[red:ff0000, gray:00ff00, blue:0000ff, yellow:ffff00, organe:ff850d, complex:[a:1, b:2]]
println colors.getClass()//class java.util.LinkedHashMap
//删除方法
colors.remove('red')
println colors
//修改方法
colors.gray = 'huise'
println colors//[gray:huise, blue:0000ff, yellow:ffff00, organe:ff850d, complex:[a:1, b:2]]