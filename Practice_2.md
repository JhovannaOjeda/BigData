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

Jhovanna Andrea Ojeda Sanchez
15211334

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
**5.- Cuales son los elementos unicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversion a conjuntos**

Declaring the List lista
```scala
val lista = List(1,3,3,4,6,7,3,7)
```

Converting list to set of unrepeatable items
```scala
lista.toSet
```
Returns **scala.collection.immutable.Set[Int] = Set(1, 6, 7, 3, 4)**

**6.- Crea una mapa mutable llamado nombres que contenga los siguiente: "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"**

Creating the metable Map with the mentioned elements
```scala
val nombres = collection.mutable.Map(("Jose", 20), ("Luis",24), ("Ana", 23), ("Susana", 27))
```
Returns **nombres: scala.collection.mutable.Map[String,Int] = Map(Susana -> 27, Ana -> 23, Luis -> 24, Jose -> 20)**

**6.a- Imprime todas la llaves del mapa**

Printing all the keys of the map
```scala
nombres.keys
```
Returns **Iterable[String] = Set(Susana, Ana, Luis, Jose)**

**6.b- Agrega el siguiente valor al mapa("Miguel", 23)**

Adding the value Miguel <- 23
```scala
nombres += ("Miguel" -> 23)
```
Returns **nombres.type = Map(Susana -> 27, Ana -> 23, Miguel -> 23, Luis -> 24, Jose -> 20)**
