trait B {
    String exec() { 'B' }               
}
trait A {
    String exec() { 'A' }               
}

class C implements B,A {
  String exec() {B.super.exec()}
} 

def c = new C()
c.exec()