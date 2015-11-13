class Dog {}

Dog.metaClass.name = 'tony'
Dog.metaClass.speak = { msg = 'where are u' -> "hi tony, ${msg}" }

Dog d = new Dog()
d.speak('how are u')