package metaprogramming
import java.util.logging.Logger
import java.util.logging.Level

Logger.metaClass.fyi = { msg -> delegate.info msg }
Logger.metaClass.omg = { msg -> delegate.severe msg }

Logger log = Logger.getLogger(this.class.name)
log.fyi 'for your information'
log.omg 'oh my goodness'

////////////////////////////////

// overwrite the methodMissing

Logger.metaClass.methodMissing = { String name, args ->
    println "< enter methodMissing, function name:$name >"

    int val = Level.WARNING.intValue() + (Level.SEVERE.intValue() - Level.WARNING.intValue()) * Math.random()

    def level = new CustomLevel(name.toUpperCase(), val)
    def impl = { Object... varArgs ->
        delegate.log(level, varArgs[0])
    }

    Logger.metaClass."$name" = impl
    impl(args)
}

log.wtf 'wtf...'