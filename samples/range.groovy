/** 
 *  groovy range
 *
 */

// integer
(1..10).each {
  println it 
}

// decimal
(0.0..10.0).each {
  println it 
}
assert (0.0..1.0).containsWithinBounds(0.5)

// string
('a'..'c').each {
  println it
}

// for loop
for (i in 4..9) {
  println i
}

// for loop with reverse range
for (i in 5..1) {
  println i
}