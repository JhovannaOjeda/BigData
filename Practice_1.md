<div align="center">

**Instituto Tecnológico de Tijuana**

Departamento de Ciencias y Computación

Ingeniería en Sistemas Computacionales

 [![](https://upload.wikimedia.org/wikipedia/commons/2/2e/ITT.jpg)](https://upload.wikimedia.org/wikipedia/commons/2/2e/ITT.jpg)

**Title:**
Practice 1

**Subject:**
BDD-1704 S DATOS MASIVOS

**Unit:**
 I

**Professor:**
JOSE CHRISTIAN ROMERO HERNANDEZ

**Student:**

Jhovanna Andrea Ojeda Sanchez
15211334

Garcia Rincon Daniel Gerardo
16212002



**Date:**
Tijuana, Baja California, March 10, 2020. 
</div>


## Practice 1

**1. Desarrollar un algoritmo en scala que calcule el radio de un circulo**

Declaring the variable for the diameter
```scala
var diameter = 6
```

Making a function to calculate radium
```scala
def CalculateRad(diameter:Int) = diameter/2
```
Calling the function to calculate
```scala
CalculateRad(diameter)
```
Returns 3

**2. Desarrollar un algoritmo en scala que me diga si un numero es primo**
Declaring the variable for test
```scala
var x = 7
```

Making a until-loop to verify that the mod is 0 otherwise we will have false value
```scala
def isPrime(x: Int) = (2 until x) forall (x % _ != 0)
```

Executing the function
```scala
isPrime(x)
```

**3. Dada la variable bird = "tweet", utiliza interpolacion de string para imprimir "Estoy ecribiendo un tweet"**

Declaring the variable tweet
```scala
var bird = "tweet"
```

Declaring the variable sentence
```scala
var sentence = "Estoy escribiendo un"
```

Interpolating strings
```scala
println(f"$sentence%s $bird")
```

Returns **Estoy escribiendo un tweet**

**4. Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slilce para extraer la secuencia "Luke"**

Declaring the variable mensaje
```scala
var mensaje = "Hola Luke yo soy tu padre!"
```

Slicing the message
```scala
mensaje.slice(5,9)
```

Returns **Luke**

**5. Cual es la diferencia entre value y una variable en scala?**

The value is immutable, it'll never change his value
```scala
val value = 3
value = 2
```
Returns **<console>:25: error: reassignment to val**

The variable by the other hand, it actually can change his value
```scala
var variable = 3
variable = 2
```
Returns **variable: Int = 2**

**6. Dada la tupla (2,4,5,1,2,3,3.1416,23) regresa el numero 3.1416**

Declaring the value of tupla
```scala
val tupla = (2,4,5,1,2,3,3.1416,23)
```

Retrieving the value 3.1416
```scala
tupla._7
```
Returns **res1: Double = 3.1416**
