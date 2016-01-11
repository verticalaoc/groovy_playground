import groovy.transform.*

class Phone {
    void call (num) {
        println "calling ${num}"
    }

    void from() {
        println 'from apple'
    }
}

class Camera {
    void take () {
        println "your picture is here"
    }

    void from() {
        print 'from nikon'
    }
}

class SmartPhone {
    @Delegate Phone p = new Phone()
    @Delegate Camera c = new Camera()

    // handle conflict
    void from() {
        p.from()
        c.from()
    }
}


SmartPhone s = new SmartPhone()
s.call('0999123456')
s.take()
s.from()