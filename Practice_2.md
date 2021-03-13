<div align="center">

**Instituto Tecnológico de Tijuana**

Departamento de Ciencias y Computación

Ingeniería en Sistemas Computacionales

 [![](https://upload.wikimedia.org/wikipedia/commons/2/2e/ITT.jpg)](https://upload.wikimedia.org/wikipedia/commons/2/2e/ITT.jpg)

**Title:**
Practice 2

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


## Practice 2

**1.- Crea una lista llamada "lista" con los elementos "rojo", "blanco", "negro"**
Creating a list
```scala
var l = List("rojo", "blanco", "negro")
```

**2.- Añadir 5 elementos mas a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"**
Adding elements to list

```scala
l :+="verde"
l :+="amarillo"
l :+="azul"
l :+="naranja"
l :+="perla" 
```
**3.- Traer los elementos de "lista" "verde", "amarillo", "azul"**
Getting elements from list

```scala
l(3)
l(4)
l(5)
```

**4.- Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5**
Creating array and adding the number sequence and changing first number to number 1

```scala
val x = Array.range(0, 1005, 5)
x(0) = 1
x
```
