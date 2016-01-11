import java.util.concurrent.Callable
import java.util.concurrent.Executors

def THREADS = 2
def pool = Executors.newFixedThreadPool(THREADS)
def done = 0
    
def defer = { closure -> 
    pool.submit( closure as Callable )
}

for ( def i = 0; i < 10; i++ ) {
    def j = i+1
    def random = new Random()
    def sleep = random.nextInt(10000)
    
    
    defer {
        println "Executing task ${j}"
        println "going to sleep ${sleep} ms"
        Thread.sleep(sleep)
    }
}