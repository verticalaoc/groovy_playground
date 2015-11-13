@Grab(group='org.spockframework', module='spock-core', version='1.0-groovy-2.4')
@Grab(group='org.apache.commons', module='commons-math3', version='3.5')

import static org.apache.commons.math3.complex.Complex.*
import static java.lang.Math.*

import org.apache.commons.math3.complex.*
import spock.lang.Specification

class ComplexSpec extends Specification {
  def setupSpec() {
    Complex.metaClass.plus = {Complex c -> delegate.add c}
    Complex.metaClass.minus = {Complex c -> delegate.substract c}
    Complex.metaClass.div = {Complex c -> delegate.divide c}
    Complex.metaClass.power = {Complex c -> delegate.pow c}
    Complex.metaClass.negative = {Complex c -> delegate.negate c}
    Double.metaClass.power = {Complex c -> (new Complex(delegate,0)).pow(c)}
  }
  
  def "plus method aliased to add"() {
    given:
    Complex first = new Complex(1.0, 3.0);
    Complex second = new Complex(2.0, 5.0);
    
    expect:
    new Complex(3.0, 8.0) == first + second
  }
}