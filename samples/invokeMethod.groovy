import groovy.transform.*

@Canonical
class Teacher {
    def name

    def invokeMethod(String name, Object args) {
      "method: ${name}, args: ${args}"
   }
}

class Student {
    def name
}

def t =new Teacher(name:'tname')
println t.name
println t.student(name:'sname')

