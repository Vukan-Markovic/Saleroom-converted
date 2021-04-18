package vukan.com.apursp.callbacks

import vukan.com.apursp.models.FavoriteProduct

interface FavoritesCallback {
    fun onCallback(favoritesProducts: List<FavoriteProduct>)
}