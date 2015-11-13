class Dog {}

Dog.metaClass.name = 'tony'
Dog.metaClass.speak = { msg = 'where are u' -> "hi tony, ${msg}" }

Dog d = new Dog()
println d.speak('how are u')