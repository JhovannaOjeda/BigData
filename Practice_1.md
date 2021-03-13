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

Jhovanna AdreaOjeda Sanchez
1

Garcia Rincon Daniel Gerardo 
16212002



**Date:**
Tijuana, Baja California, March 10, 2020. 
</div>


## 1. Desarrollar un algoritmo en scala que calcule el radio de un circulo

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

##  2. Desarrollar un algoritmo en scala que me diga si un numero es primo
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

## 3. Dada la variable bird = "tweet", utiliza interpolacion de string para imprimir "Estoy ecribiendo un tweet"

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
