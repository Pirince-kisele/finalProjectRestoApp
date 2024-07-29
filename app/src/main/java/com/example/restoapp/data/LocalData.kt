package com.example.restoapp.data

import com.example.restoapp.R
import com.example.restoapp.data.LocalData.getFoodData
import com.example.restoapp.model.Food
import com.example.restoapp.model.Gallery


sealed class Destination(val route: String) {
    object Home : Destination("Home")
    object Menu : Destination("Menu")
    object Gallery : Destination("Gallery")
    object MainScreen : Destination("MainScreen")
    object StartPage : Destination("StartPage")
    object DetailScreen : Destination("DetailScreen/{foodId}"){
        fun createRoute(foodId: Int) = "DetailScreen/$foodId"
    }
    object DetailGallery : Destination("DetailGallery/{imageGalleryId}"){
        fun createRouteGallery(imageGalleryId: Int) = "DetailGallery/$imageGalleryId"
    }
}

object LocalData{

    fun getFoodData(): List<Food> {
        return listOf(
            Food(id = 1,
                imageId = R.drawable.food01,
                name = R.string.name1,
                price = R.string.price1,
                snippet = R.string.snippet1,
                description = R.string.description1
            ),
            Food(
                id = 2,
                imageId = R.drawable.food2,
                name = R.string.name2,
                price = R.string.price2,
                snippet = R.string.snippet2,
                description = R.string.description2
            ),
            Food(
                id = 3,
                imageId = R.drawable.food3,
                name = R.string.name3,
                price = R.string.price3,
                snippet = R.string.snippet3,
                description = R.string.description3
            ),
            Food(
                id = 4,
                imageId = R.drawable.food4,
                name = R.string.name4,
                price = R.string.price4,
                snippet = R.string.snippet4,
                description = R.string.description4
            ),
            Food(
                id = 5,
                imageId = R.drawable.food5,
                name = R.string.name5,
                price = R.string.price5,
                snippet = R.string.snippet5,
                description = R.string.description5

            ),
            Food(
                id = 6,
                imageId = R.drawable.food6,
                name = R.string.name6,
                price = R.string.price6,
                snippet = R.string.snippet6,
                description = R.string.description6
            ),
            Food(
                id = 7,
                imageId = R.drawable.food7,
                name = R.string.name7,
                price = R.string.price7,
                snippet = R.string.snippet7,
                description = R.string.description7
            ),
            Food(
                id = 8,
                imageId = R.drawable.food8,
                name = R.string.name8,
                price = R.string.price8,
                snippet = R.string.snippet8,
                description = R.string.description8
            ),
            Food(
                id = 9,
                imageId = R.drawable.food9,
                name = R.string.name9,
                price = R.string.price9,
                snippet = R.string.snippet9,
                description = R.string.description9
            ),
            Food(
                id = 10,
                imageId = R.drawable.food10,
                name = R.string.name10,
                price = R.string.price10,
                snippet = R.string.snippet10,
                description = R.string.description10

            )
        )

    }
    fun getFood(id: Int): Food? {
        for (food in getFoodData().indices)
        {
            if (getFoodData()[food].id == id) return getFoodData()[food]
        }
        return null
    }
}

object GalleryData{

    fun getGalleryImage(): List<Gallery>{
        return listOf(
        Gallery(
            id = 1,
            imageGallery = R.drawable.resto1
        ),
            Gallery(
                id = 2,
                imageGallery = R.drawable.resto2
            ),
            Gallery(
                id = 3,
                imageGallery = R.drawable.resto3
            ),
            Gallery(
                id = 4,
                imageGallery = R.drawable.resto4
            ),
            Gallery(
                id = 5,
                imageGallery = R.drawable.resto5
            ),
            Gallery(
                id = 6,
                imageGallery = R.drawable.resto6
            ),
            Gallery(
                id = 7,
                imageGallery = R.drawable.resto7
            ),
            Gallery(
                id = 8,
                imageGallery = R.drawable.resto8
            ),
            Gallery(
                id = 9,
                imageGallery = R.drawable.resto9
            ),
            Gallery(
                id = 10,
                imageGallery = R.drawable.resto10
            ),

        )

    }
    fun getGallery(id: Int): Gallery? {
        for (image in getGalleryImage().indices)
        {
            if (getGalleryImage()[image].id == id) return getGalleryImage()[image]
        }
        return null
    }

}