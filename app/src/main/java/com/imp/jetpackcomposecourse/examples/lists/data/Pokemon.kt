package com.imp.jetpackcomposecourse.examples.lists.data

data class Pokemon(
    val id:Int,
    val name:String,
    val imageURL:String
)

fun getPokemon():List<Pokemon> = (1..151).map {index ->
    Pokemon(
        id=index,
        name = getRandomString(),
        imageURL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
    )
}

fun getRandomString():String {
    val charset:List<Char> = ('a'..'z')+('A'..'Z')+('0'..'9')
    return (1..10)
        .map {charset.random()}
        .joinToString("")
}
