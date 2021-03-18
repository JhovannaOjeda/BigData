<div align="center">

**Instituto Tecnológico de Tijuana**

Departamento de Ciencias y Computación

Ingeniería en Sistemas Computacionales

 [![](https://upload.wikimedia.org/wikipedia/commons/2/2e/ITT.jpg)](https://upload.wikimedia.org/wikipedia/commons/2/2e/ITT.jpg)

**Title:**
Practice 4

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



## Pratice 3 Analyze the Following Code

### First code block

This code creates a function that reads a list of ints and what the function will do is to be able to read the int and tell if the numbers are odd or even.

```scala
def listEvens(list:List[Int]): String ={
    for(n <- list){
        if(n%2==0){
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}
```

Here is declaration of two lists that contains random numbers.

```scala
val l = List(1,2,3,4,5,6,7,8)
val l2 = List(4,3,22,55,7,8)
```

Here is the function application to the lists named "l" and "l2".

```scala
listEvens(l)
listEvens(l2)
```


### Second code block

In this block at the beginning a function called lucky is declared and a list of int is used that will analyze the numbers if there is a 7 the value will be "res" and 14 points will be added.
If the number is not 7 then the value "res" will be added to the number found and this will be repeated until there is no number to analyze.
```scala
def afortunado(list:List[Int]): Int={
    var res=0
    for(n <- list){
        if(n==7){
            res = res + 14
        }else{
            res = res + n
        }
    }
    return res
}

```
Here is a declaration of a list of three numbers.

```scala
val af= List(1,7,7)
```

Here is the application of the function to the list named "af"

```scala
println(afortunado(af))
```
