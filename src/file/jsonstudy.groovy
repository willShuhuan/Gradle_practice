package file

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import oop.Person

/**
 * @author DSH
 * @date 2020/3/23
 * @description
 */

//实体转json
def list = [new Person(name:'John',age:25),
            new Person(name:'Magor',age:26)]
println JsonOutput.toJson(list)//[{"age":25,"name":"John"},{"age":26,"name":"Magor"}]

def json = JsonOutput.toJson(list)
println JsonOutput.prettyPrint(json)//带格式的json
//json转实体
//def jsonSlpuer = new JsonSlurper()
//jsonSlpuer.parse()

//模拟真实网络请求
//def getNetworkData (String ){
//    //发送http请求
//    def connection = new URL(url).openConnection()
//    connection.setRequestMethod('GET')
//    connection.connect()
//    def response = connection.content.text
//    //将 json 转化为实体对象
//    def jsonSluper = new JsonSlurper()
//    jsonSluper.parse(response)
//}
//def response = getNetworkData('http://xxx.com')
//println response.data.head.name

def responseString = "{\"age\":26,\"name\":\"Magor\"}"
def jsonSluper = new JsonSlurper()
def data =jsonSluper.parseText(responseString)
jsonSluper.
println data.name //Magor
