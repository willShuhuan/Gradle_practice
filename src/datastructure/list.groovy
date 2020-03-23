package datastructure

/**
 * @author DSH
 * @date 2020/3/23
 * @description
 */
//def list = new ArrayList()//java定义方式
def list = [1,2,3,4,5]
println list.class//class java.util.ArrayList
println list.size()//5
//定义数组
def array = [1,2,3,4,5] as int []
int[] array2 = [1,2,3,4,5]

/**
 * list的添加元素
 */
list.add(6)
list.leftShift(7)
println list.toListString()//[1, 2, 3, 4, 5, 6, 7]
list << 8
println list.toListString()//[1, 2, 3, 4, 5, 6, 7, 8]
def plusList = list+9
println plusList.toListString()//[1, 2, 3, 4, 5, 6, 7, 8, 9]
println '------------------------'
/**
 * list的删除元素
 */
//list.remove(7)//移除第八个元素后的元素
//println list.toListString()//[1, 2, 3, 4, 5, 6, 7]
//list.remove((Object)7)//移除元素7
//println list.toListString()//[1, 2, 3, 4, 5, 6]
list.removeAt(7)//移除第八个元素后的元素
println list.toListString()//[1, 2, 3, 4, 5, 6, 7]
list.removeElement(6)//移除元素6
println list.toListString()//[1, 2, 3, 4, 5, 7]
list.removeAll{return it%2 == 0}
println list.toListString()//[1, 3, 5, 7]
println list - [6,7]//[1, 3, 5]
println list.toListString()//[1, 3, 5, 7]

println '-------------'
/**
 * 列表的排序
 */
def sortList = [6,-3,9,2,-7,1,5]
//两种java排序方法
//从小到大排序
Collections.sort(sortList)
println sortList//[-7, -3, 1, 2, 5, 6, 9]
//添加绝对值大小规则
Comparator mc = {a,b ->
    a == b?0:
            Math.abs(a)<Math.abs(b)?-1:1
}
Collections.sort(sortList,mc)
println sortList//[1, 2, -3, 5, 6, -7, 9]

//groovy排序
//列表排序
sortList.sort()
sortList.sort { a, b ->
    a == b ? 0
            : Math.abs(a)<Math.abs(b)?1:-1
}
println sortList//绝对值从大到小[9, -7, 6, 5, -3, 2, 1]
//字符串数组排序
def sortStringList = ['abc','z','hello','groovy','java']
sortStringList.sort{it -> return it.size() }
println sortStringList//根据字符串长度排序 [z, abc, java, hello, groovy]
//列表的查找
def findList = [6,-3,9,2,-7,1,5]
int result = findList.find {return  it%2 == 0}
println result//第一个偶数 6
def results = findList.findAll() {return  it%2 == 0}
println results.toListString()//所有偶数 [6, 2]
def any =findList.any{return it%2 !=0}
println any//是否存在奇数 true
def every = findList.every {return it%2 == 0}
println every//是否都是偶数 false
println findList.min()//最小值-7
println findList.max()//最大值9
println findList.min{return Math.abs(it)}//绝对值最小值1
println findList.max{return Math.abs(it)}//绝对值最大值9

println findList.count{return it%2 !=0}//统计奇数个数