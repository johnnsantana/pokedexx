package com.johnnsantana.pokedex.ui.feature.pokedex.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.johnnsantana.pokedex.domain.model.Pokemon
import com.johnnsantana.pokedex.data.repository.PokedexRepository

class PokedexPagingSource(
    private val repository: PokedexRepository
) : PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val offset = params.key ?: 0
        return try {
            val result = repository.getPokemonList(limit = PAGE_SIZE, offset = offset)
            result.fold(
                onSuccess = { pokemons ->
                    LoadResult.Page(
                        data = pokemons,
                        prevKey = if (offset == 0) null else offset - PAGE_SIZE,
                        nextKey = if (pokemons.isEmpty()) null else offset + PAGE_SIZE
                    )
                },
                onFailure = { LoadResult.Error(it) }
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(PAGE_SIZE)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(PAGE_SIZE)
        }
    }

    companion object {
        private const val PAGE_SIZE = 20
    }
}