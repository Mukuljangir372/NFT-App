package com.mukul.jan.learn

//----------------------------------------------------------------------------------------------------------------------------
//------------------------- GENERICS IN KOTLIN -------------------------------------------------------------------------------
// What is Generics in Kotlin?
// Generics provides some great features while declaring classes, functions, interfaces etc. which can support multiple types.
//
//        class Food(name: String) {
//        println("$name")
//        }
//
//        You can only use this, like -
//        val food1 = Food("eggs")
//        val food2 = Food(1)              -> Error, compile time error
//
// You can fix this, like
//
//        class Food<T>(name: T) { }
//
//        Now, you can use this -
//        val food1 = Food<String>("eggs")
//        val food2 = Food<Int>(1)
//
//----------------------------------------------------------------------------------------------------------------------------
// ------------------------------------  Declaration Site Variance ------------------------------------------------------------
// In kotlin List<E> is not equivalent Java List<E>. Kotlin List<E> is read only but Java List<E> is both read and write.
// Declaration of Kotlin List<E> => class List<out E> ...
// As in generic class type E having `out` variance. Its means it's type parameter is covariant.
// In simple words, If you use `out` variance with generic type, It's type parameter is read only. You can't assign value to it. You
// can only read from it.
// `in` variance with generic type has opposite behaviour as well.
















